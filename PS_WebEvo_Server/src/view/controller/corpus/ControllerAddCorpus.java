/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import controller.logic.ControllerAL;
import model.corpus.Corpus;
import view.corpus.FrmAddCorpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAddCorpus {
    FrmAddCorpus frmAddCorpus;

    public ControllerAddCorpus(FrmAddCorpus frmAddCorpus) {
        this.frmAddCorpus = frmAddCorpus;
    }
    
    public void addCorpus(Corpus corpus) throws Exception{
//        ControllerAL.getInstance().addNewCorpus(corpus);
        ControllerAL.getInstance().addNewGDO(corpus);
    }
}
