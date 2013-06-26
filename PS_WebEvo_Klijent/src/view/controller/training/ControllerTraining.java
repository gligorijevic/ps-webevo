/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.training;

import controller.logic.ControllerAL;
import java.io.IOException;
import logic.tagger.EntityCorpus.TrainingCorpus;
import logic.tagger.train.NamedEntityRecognitionTraining;
import model.corpus.Corpus;
import storage.CorpusStorage;
import view.training.FrmTrainingTaggerModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerTraining {

    private FrmTrainingTaggerModel frmTrainingTaggerModel;

    public ControllerTraining() {
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
        frmTrainingTaggerModel.getTxtATrainingResults().setText(ControllerAL.getInstance().startTraining(corpus));
        

    }

    public void getCorpusesComboBox() {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            System.out.println(CorpusStorage.getInstance().getListOfCorpuses().get(i));
            frmTrainingTaggerModel.getCbCorpuses().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
    }
}
