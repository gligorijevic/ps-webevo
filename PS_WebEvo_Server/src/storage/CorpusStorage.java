/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import controller.logic.ControllerAL;
import java.util.ArrayList;
import java.util.List;
import model.GeneralDomainObject;
import model.corpus.Corpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CorpusStorage {

    private List<Corpus> listOfCorpuses;
    private static CorpusStorage instance;

    private CorpusStorage() {
//        listOfCorpuses = ControllerAL.getInstance().getAllCorpuses();
        listOfCorpuses = new ArrayList<Corpus>();
        List<GeneralDomainObject> rezultat = ControllerAL.getInstance().returnAll(new Corpus());
        for (GeneralDomainObject generalDomainObject : rezultat) {
            listOfCorpuses.add((Corpus) generalDomainObject);
        }
    }

    public void refreshData() {
        listOfCorpuses = new ArrayList<Corpus>();
        List<GeneralDomainObject> rezultat = ControllerAL.getInstance().returnAll(new Corpus());
        for (GeneralDomainObject generalDomainObject : rezultat) {
            listOfCorpuses.add((Corpus) generalDomainObject);
        }
    }

    public static CorpusStorage getInstance() {
        if (instance == null) {
            instance = new CorpusStorage();
        }
        return instance;
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
