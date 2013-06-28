/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.sentence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.GeneralDomainObject;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import storage.CorpusStorage;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.sentence.FrmAddTaggedSentence;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerSentence extends OpstiKontrolerKI {

    private List<Corpus> listOfCorpuses;
    private FrmAddTaggedSentence frmAddTaggedSentence;

    public ControllerSentence() throws IOException {
        super();
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

        to = new TransferObject();
        to.setClientObject(ts);
        to.setClientRequestOperation(RequestOntology.AD_NEW_TAGGEDSENTENCE);
        callSystemOperation();
//        ControllerAL.getInstance().addNewTaggedSentence(ts);
//        ControllerAL.getInstance().addNewGDO(ts);
        //TODO
    }

    public void fillComboBoxKorpus() {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            getFrmAddTaggedSentence().getCmbBoxCorpus().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
    }

    public void refreshStorageData() {
        listOfCorpuses = new ArrayList<Corpus>();
        List<GeneralDomainObject> rezultat = null;// = ControllerAL.getInstance().returnAll(new Corpus());

        to = new TransferObject();
        to.setClientObject(listOfCorpuses);
        to.setClientRequestOperation(RequestOntology.GET_ALL_CORPUSES);
        callSystemOperation();
        listOfCorpuses =  (List<Corpus>) to.getServerObject();

//        for (GeneralDomainObject generalDomainObject : rezultat) {
//            listOfCorpuses.add((Corpus) generalDomainObject);
//        }
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the listOfCorpuses
     */
    public List<Corpus> getListOfCorpuses() {
        return listOfCorpuses;
    }

    /**
     * @param listOfCorpuses the listOfCorpuses to set
     */
    public void setListOfCorpuses(List<Corpus> listOfCorpuses) {
        this.listOfCorpuses = listOfCorpuses;
    }
}
