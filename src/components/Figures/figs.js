import {url as markupStatsUrl} from './MarkupStatsFigure/data';

const figs = {
    markupStats: {
        id: 'markup-stats',
        num: 1,
        url: markupStatsUrl
    },

    titleTf: {
        id: "fig-title-tf",
        num: 3
    },
    taggingResults: {
        id: "fig-results",
        num: 3
    },
    confusionMatrix: {
        id: "fig-confusion-matrix",
        num: 4
    },
    figTitleWordCount: {
        id: "fig-title-word-count",
        num: 3
    },
    titleRelativeWordCount: {
        id: "fig-title-relative-word-count",
        num: 3
    },

    tfidf: {
        id: "fig-title-tf-idf",
        num: 4
    },

    figTitleNumbering: {
        id: "fig-title-numbering",
        num: 2
    },
    figTitleTreemap: {
        id: "fig-title-patterns",
        num: 2
    }, 
    sectionsTfidf: {
        id: "fig-tfidf-sections",
        num: 4
    },

    hmm: function () {
        const id = "fig-hmm";
        const src = "/img/hmm.svg";// TODO relativeurl
        const alt = "Graphical representation of a Hidden Markov Model";
        const num = 1;
        return {
            id: id,
            src: src,
            alt: alt,
            num: num
        }
    }(),

    graphicalModels: function () {
        const id = "fig-models-relationships";
        const src = "/img/graphical-models.svg"; // TODO relativeurl
        const alt = "Diagram of the relationship between naive Bayes, logistic regression, HMMs, linear-chain CRFs, " +
            "generative models, and general CRFs";
        const num = 1;
        return {
            id: id,
            src: src,
            alt: alt,
            num: num
        }
    }(),

    tfidf: function () {
        const id = "tfidf";
        const num = 3;

        return {
            id: id,
            num: num
        };
    }(),
    factorGraph: function () {
        const id = "fig-factor-graph";
        const src = "/img/factor-graph.svg";//// TODO relativeurl
        const alt = "Illustration of a factor graph. The set V represents all variable nodes; the set F represents all function nodes.";
        const num = 1;

        return {
            id: id,
            src: src,
            alt: alt,
            num: num
        };
    }()
};

export default figs;