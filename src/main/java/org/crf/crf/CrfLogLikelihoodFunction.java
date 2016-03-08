package org.crf.crf;

import static org.crf.crf.CrfUtilities.safeAdd;

import java.util.ArrayList;
import java.util.List;

import org.crf.crf.filters.CrfFeaturesAndFilters;
import org.crf.crf.run.CrfTagsBuilder;
import org.crf.function.DerivableFunction;
import org.crf.utilities.CrfException;
import org.crf.utilities.TaggedToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CRF log-likelihood function for the given <B>tagged</B> corpus, under the given model.
 * <BR>
 * The "likelihood" of a sequence of tags for a given sentence is the probability of that sequence of tags to occur (to exist)
 * for that sentence.
 * This probability is:
 * \Sum{j=0}^{sentence-length-1}(e^( \Sum_{i=0}^{numbering-of-features}(\theta_i*f_i(j,g,g')) )) / Z(x)
 * where \theta_i is parameter numbering i (these are the parameters that are learned during training - these parameters form
 * the input vector "point" of this function), f_i is feature numbering i, g is the tag of token numbering j, and g' is the tag of
 * token numbering j-1. Z(x) is the normalization factor.
 * <p>
 * The log-likelihood is \Sum_{sentence \in corpus}log( \Sum{j=0}^{sentence-length-1}(e^( \Sum_{i=0}^{numbering-of-features}(\theta_i*f_i(j,g,g')) )) / Z(x) ).
 * <BR>
 * The log is in the natural basis (e) (It is actually ln).
 * <p>
 * <p>
 * <B>This function is CONCAVE, not convex!!!</B>
 * <p>
 *
 * @param <K>
 * @param <G>
 * @author Asher Stern
 *         Date: Nov 9, 2014
 */
public class CrfLogLikelihoodFunction<K, G> extends DerivableFunction {
    /**
     * Constructs the log-likelihood function of the CRF.
     * Note that the whole corpus should be inside the internal memory (the JVM heap). It should not be in disk or data-base.
     *
     * @param corpus                                  A corpus -- a list of sequences of tokens, where each token has a tag (this is a gold-standard corpus: the tags are known).
     * @param crfTags                                 The tags that exist in the given corpus. See {@link CrfTagsBuilder}.
     * @param features                                The CRF features.
     * @param useRegularization                       whether to use a regularization factor or not.
     * @param sigmaSquare_inverseRegularizationFactor the \sigma^2 parameter of the L2 regularization factor.
     */
    public CrfLogLikelihoodFunction(List<? extends List<? extends TaggedToken<K, G>>> corpus, CrfTags<G> crfTags,
                                    CrfFeaturesAndFilters<K, G> features, boolean useRegularization,
                                    double sigmaSquare_inverseRegularizationFactor) {
        super();
        this.corpus = corpus;
        this.crfTags = crfTags;
        this.features = features;
        this.useRegularization = useRegularization;
        this.sigmaSquare_inverseRegularizationFactor = sigmaSquare_inverseRegularizationFactor;
    }


    /*
     * (non-Javadoc)
     * @see org.postagging.function.Function#value(double[])
     */
    @Override
    public double value(double[] point) {
        logger.debug("Calculating value");

        CrfModel<K, G> model = createModel(point);
        double regularization = useRegularization ? calculateRegularizationFactor(point) : 0.0;
        logger.debug("Calculating sum weighted features");
        double sumWeightedFeatures = calculateSumWeightedFeatures(model);
        logger.debug("Calculating sum log normalizations");
        double sumOfLogNormalizations = calculateSumOfLogNormalizations(model);
        double ret = sumWeightedFeatures - sumOfLogNormalizations - regularization;
        logger.debug("Calculating value - done.");
        return ret;
    }


    /*
     * (non-Javadoc)
     * @see org.postagging.function.DerivableFunction#gradient(double[])
     */
    @Override
    public double[] gradient(double[] point) {
        logger.debug("Calculating gradient");

        CrfModel<K, G> model = createModel(point);

        logger.debug("Calculating empirical feature values");
        CrfEmpiricalFeatureValueDistributionInCorpus<K, G> empiricalFeatureValue =
                new CrfEmpiricalFeatureValueDistributionInCorpus<>(corpus.iterator(), model.getFeatures());
        empiricalFeatureValue.calculate();

        logger.debug("Calculating expected feature values by models");
        CrfFeatureValueExpectationByModel<K, G> featureValueExpectationsByModel =
                new CrfFeatureValueExpectationByModel<>(corpus.iterator(), model);
        featureValueExpectationsByModel.calculate();

        logger.debug("Creating gradient array.");
        double[] ret = new double[point.length];
        for (int parameterIndex = 0; parameterIndex < ret.length; ++parameterIndex) {
            double regularizationDerivative = useRegularization ? calculateRegularizationDerivative(point[parameterIndex]) : 0.0;

            ret[parameterIndex] =
                    empiricalFeatureValue.getEmpiricalFeatureValue()[parameterIndex]
                            - featureValueExpectationsByModel.getFeatureValueExpectation()[parameterIndex]
                            - regularizationDerivative;
            if (Double.isNaN(ret[parameterIndex]))
                throw new Error("Was NaN: " + empiricalFeatureValue.getEmpiricalFeatureValue()[parameterIndex] +
                        " - " + featureValueExpectationsByModel.getFeatureValueExpectation()[parameterIndex] +
                        " - " + regularizationDerivative);
        }
        return ret;
    }


    /*
     * (non-Javadoc)
     * @see org.postagging.function.Function#size()
     */
    @Override
    public int size() {
        return features.getFilteredFeatures().length;
    }


    private double calculateSumWeightedFeatures(CrfModel<K, G> model) {
        double sumWeightedFeatures = 0.0;
        for (List<? extends TaggedToken<K, G>> sentence : corpus) {
            K[] sentenceAsArray = CrfUtilities.extractSentence(sentence);
            G previousTag = null;
            int tokenIndex = 0;
            for (TaggedToken<K, G> taggedToken : sentence) {
                double sumForThisToken = CrfUtilities.oneTokenSumWeightedFeatures(model, sentenceAsArray, tokenIndex, taggedToken.getTag(), previousTag);
                sumWeightedFeatures = safeAdd(sumWeightedFeatures, sumForThisToken);

                previousTag = taggedToken.getTag();
                ++tokenIndex;
            }
            if (tokenIndex != sentence.size()) {
                throw new CrfException("BUG");
            }
        }

        return sumWeightedFeatures;
    }

    private double calculateSumOfLogNormalizations(CrfModel<K, G> model) {
        double sum = 0.0;
        for (List<? extends TaggedToken<K, G>> sentence : corpus) {
            K[] sentenceAsArray = CrfUtilities.extractSentence(sentence);
            CrfRememberActiveFeatures<K, G> activeFeaturesForSentence = CrfRememberActiveFeatures.findForSentence(features, crfTags, sentenceAsArray);
            CrfForwardBackward<K, G> forwardBackward = new CrfForwardBackward<>(model, sentenceAsArray, activeFeaturesForSentence);
            //forwardBackward.calculateForwardAndBackward();
            forwardBackward.calculateOnlyNormalizationFactor();

            double normalizationFactor = forwardBackward.getCalculatedNormalizationFactor();
            double logNormalizationFactor = Math.log(normalizationFactor);
            sum = safeAdd(sum, logNormalizationFactor);
        }

        return sum;
    }

    private double calculateRegularizationFactor(double[] parameters) {
        return normSquare(parameters) / (2 * sigmaSquare_inverseRegularizationFactor);
    }

    private double calculateRegularizationDerivative(double parameter) {
        return parameter / sigmaSquare_inverseRegularizationFactor;
    }


    private CrfModel<K, G> createModel(double[] point) {
        if (point.length != features.getFilteredFeatures().length) {
            throw new CrfException("Number of parameters differs from numbering of features.");
        }
        ArrayList<Double> parameters = new ArrayList<>(point.length);
        for (double parameter : point) {
            parameters.add(parameter);
        }
        return new CrfModel<>(crfTags, features, parameters);
    }

    private double normSquare(double[] vector) {
        double ret = 0.0;
        for (double component : vector) {
            ret = safeAdd(ret, component * component);
        }
        return ret;
    }

//	private void buildActiveFeaturesWholeCorpus()
//	{
//		activeFeaturesWholeCorpus = new LinkedList<CrfRememberActiveFeatures<K,G>>();
//		for (List<? extends TaggedToken<K, G> > sentence : corpus)
//		{
//			K[] sentenceAsArray = CrfUtilities.extractSentence(sentence);
//			CrfRememberActiveFeatures<K,G> activeFeaturesOfSentence = CrfRememberActiveFeatures.findForSentence(features,tags, sentenceAsArray);
//			activeFeaturesWholeCorpus.add(activeFeaturesOfSentence);
//		}
//		logger.info(RuntimeUtilities.getUsedMemory());
//	}

    /**
     * A corpus -- a list of tagged sequences.
     * <B>The whole corpus should reside in the internal memory completely!</B> Otherwise, the run will be very slow.
     */
    private final List<? extends List<? extends TaggedToken<K, G>>> corpus;
    private final CrfTags<G> crfTags;
    private final CrfFeaturesAndFilters<K, G> features;
    private final boolean useRegularization;
    private final double sigmaSquare_inverseRegularizationFactor;
    private static final Logger logger = LoggerFactory.getLogger(CrfLogLikelihoodFunction.class);
}
