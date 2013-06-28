/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CorpusStorage extends OpstiKontrolerKI {

    private List<Corpus> listOfCorpuses;
    private static CorpusStorage instance;

    private CorpusStorage() throws IOException {
//        listOfCorpuses = ControllerAL.getInstance().getAllCorpuses();
        getAllCorpuses();
    }

    public void refreshData() {
        getAllCorpuses();
    }

    public static CorpusStorage getInstance() {
        if (instance == null) {
            try {
                instance = new CorpusStorage();
            } catch (IOException ex) {
                Logger.getLogger(CorpusStorage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    private void getAllCorpuses() {
        to = new TransferObject();
        listOfCorpuses = new ArrayList<Corpus>();
        to.setClientObject(listOfCorpuses);
        to.setClientRequestOperation(RequestOntology.GET_ALL_CORPUSES);
        callSystemOperation();
        listOfCorpuses = (List<Corpus>) to.getServerObject();
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

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
    }

    public void updateTaggedSentence(TaggedSentence taggedSentence) {
        to = new TransferObject();
        to.setClientObject(taggedSentence);
        to.setClientRequestOperation(RequestOntology.UPDATE_TAGGEDSENTENCE);
        callSystemOperation();
        TaggedSentence taggedS = (TaggedSentence) to.getServerObject();
        for (Corpus corpus : listOfCorpuses) {
            for (TaggedSentence ts : corpus.getTaggedSentenceList()) {
                if (ts.equals(taggedS)) {
                    ts = taggedSentence;
                }
            }
        }
    }

    public void updateCorpus(Corpus corpus) {
        to = new TransferObject();
        to.setClientObject(corpus);
        to.setClientRequestOperation(RequestOntology.UPDATE_CORPUS);
        callSystemOperation();
        Corpus c = (Corpus) to.getServerObject();
        for (Corpus corpus1 : listOfCorpuses) {
            if (corpus1.equals(c)) {
                corpus1 = c;
            }
        }
    }
}
