/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.List;
import model.corpus.Corpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CorpusStorage {
    private List<Corpus> listOfCorpuses;
    private static CorpusStorage instance;
    
//    private CorpusStorage() {
//        listOfCorpuses = ControllerAL.getInstance().getAllCorpuses();
//    }
//    
//    public void refreshData(){
//        listOfCorpuses = ControllerAL.getInstance().getAllCorpuses();
//    }
    
    public static CorpusStorage getInstance() {
        if(instance==null) instance=new CorpusStorage();
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
