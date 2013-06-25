/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.tagger.tag;

import com.aliasi.crf.ChainCrf;
import com.aliasi.tag.ScoredTagging;
import com.aliasi.tag.TagLattice;
import com.aliasi.tag.Tagging;
import com.aliasi.util.AbstractExternalizable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Djordje Gligorijevic
 */
public class NamedEntityRecognition {

    public static void main(String[] args)
            throws ClassNotFoundException, IOException {

//        File modelFile = new File("simple_pos_model_crf");
        File modelFile = new File("simple_pos_model_crf_laplace_regression_prior");
        @SuppressWarnings("unchecked")
        ChainCrf<String> crf = (ChainCrf<String>) AbstractExternalizable.readObject(modelFile);

        String args1[] = new String[]{"", "John ran ."};
//        String args1[] = new String[]{"","Compact","System","Camera","Buying","Guide","Digital","Photography"};
//        String args1[] = new String[]{"","ASUS","R","Series","R500A","15.6","Laptop","-","Mocha","(Intel","Core","i7-3630QM","/","750GB","HDD","/","8GB","RAM","/","Windows","8","Get","Microsoft","Office","for","$99.99","with","any","PC","purchase","(SAVE","$30)."};
//        String args1[] = new String[]{"","DC","comics","and","the","series","of","Harry","Potter",
//            "books","can","be","found","at","Microsoft","Windows",
//            "8","store","at","price","of","$99.99","."};

        for (int i = 1; i < args1.length; ++i) {
            String arg = args1[i];
            List<String> tokens = Arrays.asList(arg.split(" "));

            System.out.println("\nFIRST BEST");
            Tagging<String> tagging = crf.tag(tokens);
            System.out.println(tagging);

            int maxNBest = 5;
            System.out.println("\n" + maxNBest + " BEST CONDITIONAL");
            System.out.println("Rank log p(tags|tokens)  Tagging");
            Iterator<ScoredTagging<String>> it = crf.tagNBestConditional(tokens, maxNBest);
            for (int rank = 0; rank < maxNBest && it.hasNext(); ++rank) {
                ScoredTagging<String> scoredTagging = it.next();
                System.out.println(rank + "    " + scoredTagging);
            }

            System.out.println("\nMARGINAL TAG PROBABILITIES");
            System.out.println("Token .. Tag log p(tag|pos,tokens)");
            TagLattice<String> fbLattice = crf.tagMarginal(tokens);
            for (int n = 0; n < tokens.size(); ++n) {
                System.out.println(tokens.get(n));
                for (int k = 0; k < fbLattice.numTags(); ++k) {
                    String tag = fbLattice.tag(k);
                    double prob = fbLattice.logProbability(n, k);
                    System.out.println("     " + fbLattice.tag(k) + " " + fbLattice.logProbability(n, k));
                }
            }

        }
    }
}
