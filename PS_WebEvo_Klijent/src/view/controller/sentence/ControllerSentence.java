/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.sentence;

import controller.logic.ControllerAL;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import storage.CorpusStorage;
import view.sentence.FrmAddTaggedSentence;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerSentence {

    private FrmAddTaggedSentence frmAddTaggedSentence;

    public ControllerSentence(FrmAddTaggedSentence frmAddTaggedSentence) {
        this.frmAddTaggedSentence = frmAddTaggedSentence;
    }

    private ControllerSentence() {
    }

    /**
     * @return the frmAddTaggedSentence
     */
    public FrmAddTaggedSentence getFrmAddTaggedSentence() {
        return frmAddTaggedSentence;
    }

    /**
     * @param frmAddTaggedSentence the frmAddTaggedSentence to set
     */
    public void setFrmAddTaggedSentence(FrmAddTaggedSentence frmAddTaggedSentence) {
        this.frmAddTaggedSentence = frmAddTaggedSentence;
    }

    public void addTaggedSentence(String sentence, String tags, Corpus corpus) throws Exception {
        TaggedSentence ts = new TaggedSentence();//sentence, tags);
        ts.setCorpusId(corpus);
        ts.setSentence(sentence);
        ts.setTags(tags);
        ControllerAL.getInstance().addNewTaggedSentence(ts);
    }

    public void fillComboBoxKorpus() {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            frmAddTaggedSentence.getCmbBoxCorpus().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
    }

    public void refreshStorageData() {
        CorpusStorage.getInstance().refreshData();
    }
}
