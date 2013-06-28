/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.training;

import java.io.IOException;
import model.corpus.Corpus;
import storage.CorpusStorage;
import view.OpstiKontrolerKI;
import view.training.FrmTrainingTaggerModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerTraining extends OpstiKontrolerKI{

    private FrmTrainingTaggerModel frmTrainingTaggerModel;

    public ControllerTraining() throws IOException{
    }

    /**
     * @return the frmTrainingTaggerModel
     */
    public FrmTrainingTaggerModel getFrmTrainingTaggerModel() {
        return frmTrainingTaggerModel;
    }

    /**
     * @param frmTrainingTaggerModel the frmTrainingTaggerModel to set
     */
    public void setFrmTrainingTaggerModel(FrmTrainingTaggerModel frmTrainingTaggerModel) {
        this.frmTrainingTaggerModel = frmTrainingTaggerModel;
    }

    public void startTraining() throws IOException {
        Corpus corpus = (Corpus) frmTrainingTaggerModel.getCbCorpuses().getSelectedItem();
//        frmTrainingTaggerModel.getTxtATrainingResults().setText(ControllerAL.getInstance().startTraining(corpus));
        //TODO
    }

    public void getCorpusesComboBox() {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            System.out.println(CorpusStorage.getInstance().getListOfCorpuses().get(i));
            frmTrainingTaggerModel.getCbCorpuses().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
