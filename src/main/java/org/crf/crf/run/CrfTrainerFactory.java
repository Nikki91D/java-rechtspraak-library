package org.crf.crf.run;

import org.apache.log4j.Logger;
import org.crf.crf.CrfTags;
import org.crf.crf.CrfUtilities;
import org.crf.crf.filters.CrfFeaturesAndFilters;
import org.crf.crf.filters.CrfFilteredFeature;
import org.crf.crf.filters.Filter;
import org.crf.crf.filters.FilterFactory;
import org.crf.utilities.CrfException;
import org.crf.utilities.TaggedToken;

import java.lang.reflect.Array;
import java.util.*;


/**
 * A factory which generates a new CRF trainer.
 *
 * @param <K>
 * @param <G>
 * @author Asher Stern
 *         Date: Nov 23, 2014
 */
public class CrfTrainerFactory<K, G> {
    private static final Logger logger = Logger.getLogger(CrfTrainerFactory.class);

    private static <K, G> CrfFeaturesAndFilters<K, G> createFeaturesAndFiltersObjectFromSetOfFeatures(Set<CrfFilteredFeature<K, G>> setFilteredFeatures, FilterFactory<K, G> filterFactory) {
        if (setFilteredFeatures.size() <= 0) throw new CrfException("No features have been generated.");
        @SuppressWarnings("unchecked")
        CrfFilteredFeature<K, G>[] featuresAsArray = (CrfFilteredFeature<K, G>[]) Array.newInstance(setFilteredFeatures.iterator().next().getClass(), setFilteredFeatures.size()); // new CrfFilteredFeature<String,String>[setFilteredFeatures.size()];
        Iterator<CrfFilteredFeature<K, G>> filteredFeatureIterator = setFilteredFeatures.iterator();
        for (int index = 0; index < featuresAsArray.length; ++index) {
            if (!filteredFeatureIterator.hasNext()) {
                throw new CrfException("BUG");
            }
            CrfFilteredFeature<K, G> filteredFeature = filteredFeatureIterator.next();
            featuresAsArray[index] = filteredFeature;
        }
        if (filteredFeatureIterator.hasNext()) {
            throw new CrfException("BUG");
        }


        Set<Integer> indexesOfFeaturesWithNoFilter = new LinkedHashSet<Integer>();
        Map<Filter<K, G>, Set<Integer>> mapActiveFeatures = new LinkedHashMap<Filter<K, G>, Set<Integer>>();
        for (int index = 0; index < featuresAsArray.length; ++index) {
            CrfFilteredFeature<K, G> filteredFeature = featuresAsArray[index];
            Filter<K, G> filter = filteredFeature.getFilter();
            if (filter != null) {
                CrfUtilities.putInMapSet(mapActiveFeatures, filter, index);
            } else {
                indexesOfFeaturesWithNoFilter.add(index);
            }
        }

        CrfFeaturesAndFilters<K, G> allFeatures = new CrfFeaturesAndFilters<K, G>(
                filterFactory,
                featuresAsArray,
                mapActiveFeatures,
                indexesOfFeaturesWithNoFilter
        );

        return allFeatures;
    }

    /**
     * Creates a CRF trainer.<BR>
     * <B>The given corpus must reside completely in the internal memory. Not in disk/data-base etc.</B>
     *
     * @param corpus                  The corpus: a list a tagged sequences. Must reside completely in memory.
     * @param featureGeneratorFactory A factory which creates a feature-generator (the feature-generator creates a set of features)
     * @param filterFactory           The {@link FilterFactory} <B>that corresponds to the feature-generator.</B>
     * @return a CRF trainer.
     */
    public CrfTrainer<K, G> createTrainer(List<List<? extends TaggedToken<K, G>>> corpus, CrfFeatureGeneratorFactory<K, G> featureGeneratorFactory, FilterFactory<K, G> filterFactory) {
        logger.info("Extracting tags.");
        CrfTagsBuilder<G> tagsBuilder = new CrfTagsBuilder<G>(corpus);
        tagsBuilder.build();
        CrfTags<G> crfTags = tagsBuilder.getCrfTags();

        return createTrainer(corpus, featureGeneratorFactory, filterFactory, crfTags);
    }

    public CrfTrainer<K, G> createTrainer(List<List<? extends TaggedToken<K, G>>> corpus, CrfFeatureGeneratorFactory<K, G> featureGeneratorFactory, FilterFactory<K, G> filterFactory, CrfTags<G> crfTags) {
        logger.info("Generating features.");
        CrfFeatureGenerator<K, G> featureGenerator = featureGeneratorFactory.create(corpus, crfTags.getTags());
        featureGenerator.generateFeatures();
        Set<CrfFilteredFeature<K, G>> setFilteredFeatures = featureGenerator.getFeatures();
        CrfFeaturesAndFilters<K, G> features = createFeaturesAndFiltersObjectFromSetOfFeatures(setFilteredFeatures, filterFactory);

        logger.info("CrfPosTaggerTrainer has been created.");
        return new CrfTrainer<K, G>(features, crfTags);
    }

}
