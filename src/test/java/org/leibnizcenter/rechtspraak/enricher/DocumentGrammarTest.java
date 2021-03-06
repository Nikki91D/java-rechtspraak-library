package org.leibnizcenter.rechtspraak.enricher;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.leibnizcenter.rechtspraak.enricher.cfg.CYK;
import org.leibnizcenter.rechtspraak.enricher.cfg.ScoreChart;
import org.leibnizcenter.rechtspraak.enricher.cfg.rule.Term;
import org.leibnizcenter.rechtspraak.enricher.cfg.rule.type.Terminal;

import java.util.Iterator;
import java.util.List;

/**
 * Created by maarten on 21-4-16.
 */
public class DocumentGrammarTest {
    @Test
    public void test() {
        DocumentGrammar grammar = new DocumentGrammar();

        List<Terminal> sentence = Lists.newArrayList(
                DocumentGrammar.TERMINAL_NEWLINE,
                DocumentGrammar.TERMINAL_NEWLINE,
                DocumentGrammar.TERMINAL_NEWLINE,
                DocumentGrammar.TERMINAL_NUMBERING,
                DocumentGrammar.TERMINAL_SECTION_TITLE,
                DocumentGrammar.TERMINAL_NEWLINE,
                DocumentGrammar.TERMINAL_TEXT,
                DocumentGrammar.TERMINAL_TEXT,
                DocumentGrammar.TERMINAL_TEXT,
                DocumentGrammar.TERMINAL_SECTION_TITLE,
                DocumentGrammar.TERMINAL_NEWLINE
        );
        ScoreChart.ParseTreeContainer tree = CYK.getBestParseTree(
                sentence, grammar, grammar.getStartSymbol()
        );

        System.out.println(tree);
    }
}