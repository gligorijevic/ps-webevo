/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.tagger.EntityCorpus;

import com.aliasi.corpus.ObjectHandler;
import com.aliasi.corpus.Corpus;
import com.aliasi.tag.Tagging;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import model.corpus.TaggedSentence;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TrainingCorpus extends Corpus<ObjectHandler<Tagging<String>>> {

    private String corpusName;
    private List<TaggedSentence> corpus;

    public TrainingCorpus(List<TaggedSentence> corpus, String corpusName) {
        this.corpus = corpus;
        this.corpusName = corpusName;
    }

    @Override
    public void visitTrain(ObjectHandler<Tagging<String>> handler) throws IOException {
        for (TaggedSentence taggedSentence : getCorpus()) {
            Tagging<String> tagging = new Tagging<String>(
                    Arrays.asList(taggedSentence.getSentence().split(" ")), Arrays.asList(taggedSentence.getTags().split(" ")));
            handler.handle(tagging);
        }
    }

    @Override
    public void visitTest(ObjectHandler<Tagging<String>> handler) {
        /* no op */
    }

    /**
     * @return the corpusName
     */
    public String getCorpusName() {
        return corpusName;
    }

    /**
     * @param corpusName the corpusName to set
     */
    public void setCorpusName(String corpusName) {
        this.corpusName = corpusName;
    }

    /**
     * @return the corpus
     */
    public List<TaggedSentence> getCorpus() {
        return corpus;
    }

    /**
     * @param corpus the corpus to set
     */
    public void setCorpus(List<TaggedSentence> corpus) {
        this.corpus = corpus;
    }
}
