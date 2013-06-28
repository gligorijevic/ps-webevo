/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

//import view.controller.corpus.ControllerKorpusPreview;
//import view.controller.corpus.ControllerAddCorpus;
//import view.controller.corpus.ControllerKorpusesPreview;
//import view.controller.sentence.ControllerSentence;
//import java.sql.SQLException;
import java.io.IOException;
import view.FrmMain;
import view.about.FrmAboutJPA;
import view.about.FrmAboutJSoup;
import view.about.FrmAboutLingPipe;
import view.about.FrmAboutWebEvo;
import view.controller.corpus.ControllerAddCorpus;
import view.controller.corpus.ControllerKorpusPreview;
import view.controller.corpus.ControllerKorpusesPreview;
import view.controller.sentence.ControllerSentence;
import view.controller.training.ControllerTraining;
import view.controller.webpage.ControllerLoadWebpageFromUrl;
import view.controller.webpage.ControllerReadWebpageData;
import view.corpus.FrmAddCorpus;
import view.corpus.FrmKorpusPreview;
import view.corpus.FrmKorpusesPreview;
import view.sentence.FrmAddTaggedSentence;
import view.training.FrmTrainingTaggerModel;
import view.webpage.FrmLoadWebpage;
import view.webpage.FrmReadWebpageData;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerMain {
    
    private FrmMain mainForm;
    
    public FrmMain getMainForm() {
        return mainForm;
    }
    
    public void setMainForm(FrmMain mainForm) {
        this.mainForm = mainForm;
    }
    
    public ControllerMain() {
    }
    
//    public void saveAllKorpuses() throws ClassNotFoundException, SQLException {
//        for (int i = 0; i < persistence.KorpusPersistence.getInstance().getKorpus().size(); i++) {
//            saveKorpus(persistence.KorpusPersistence.getInstance().getKorpus().get(i).getId());
//        }
//    }
    
    public void frmAddKorpus() throws IOException {
        FrmAddCorpus frmAddkorpus = new FrmAddCorpus(mainForm, true);
        ControllerAddCorpus controllerAddCorpus = new ControllerAddCorpus();
        controllerAddCorpus.setFrmAddCorpus(frmAddkorpus);
        frmAddkorpus.setControllerAddKorpus(controllerAddCorpus);
        frmAddkorpus.setVisible(true);
    }
    
    public void addTaggedSentenceForm(FrmMain frmMain) throws IOException {
        FrmAddTaggedSentence frmTaggedSentence = new FrmAddTaggedSentence(frmMain, true);
        ControllerSentence controllerSentence = new ControllerSentence();
        controllerSentence.setFrmAddTaggedSentence(frmTaggedSentence);
        frmTaggedSentence.setControllerSentence(controllerSentence);
        frmTaggedSentence.update();
        frmTaggedSentence.setVisible(true);
    }
    
    public void frmKorpusesPreview(FrmMain frmMain) throws IOException {
        FrmKorpusesPreview frmKorpusPreview = new FrmKorpusesPreview(frmMain, false);
        ControllerKorpusesPreview controllerKorpusesPreview = new ControllerKorpusesPreview();
        frmKorpusPreview.setControllerKorpusesPreview(controllerKorpusesPreview);
        controllerKorpusesPreview.setFrmKorpusPreview(frmKorpusPreview);
        frmKorpusPreview.updateForm();
        frmKorpusPreview.setVisible(true);
    }
    

    
    public void frmKorpusPreview() throws IOException {
        FrmKorpusPreview frmKorpusPreview = new FrmKorpusPreview(mainForm, false);
        ControllerKorpusPreview controllerKorpusPreview = new ControllerKorpusPreview();
        frmKorpusPreview.setControllerKorpusPreview(controllerKorpusPreview);
        controllerKorpusPreview.setFrmKorpusPreview(frmKorpusPreview);
        frmKorpusPreview.updateForm();
        frmKorpusPreview.setVisible(true);
    }

    public void frmTrainingTaggerModel() throws IOException {
        FrmTrainingTaggerModel frmTrainingTaggerModel = new FrmTrainingTaggerModel(mainForm, true);
        ControllerTraining controllerTraining = new ControllerTraining();
        frmTrainingTaggerModel.setControllerTraining(controllerTraining);
        controllerTraining.setFrmTrainingTaggerModel(frmTrainingTaggerModel);
        frmTrainingTaggerModel.updateForm();
        frmTrainingTaggerModel.setVisible(true);
    }

    public void frmLoadWebpage() throws IOException {
        FrmLoadWebpage frmLoadWebpage = new FrmLoadWebpage();
        ControllerLoadWebpageFromUrl clwfu = new ControllerLoadWebpageFromUrl();
        frmLoadWebpage.setClwfu(clwfu);
        clwfu.setFrmLoadWebpage(frmLoadWebpage);
        frmLoadWebpage.setVisible(true);
    }
  
    public void frmAboutWebEvo() {
        FrmAboutWebEvo frmAboutWebEvo = new FrmAboutWebEvo(mainForm, true);
        frmAboutWebEvo.setVisible(true);
    }

    public void frmAboutLingPipe() {
        FrmAboutLingPipe frmAboutLingPipe = new FrmAboutLingPipe(mainForm, true);
        frmAboutLingPipe.setVisible(true);
    }

    public void frmAboutJSoup() {
        FrmAboutJSoup frmAboutJSoup = new FrmAboutJSoup(mainForm, true);
        frmAboutJSoup.setVisible(true);
    }

    public void frmAboutJpa() {
        FrmAboutJPA frmAboutJpa = new FrmAboutJPA(mainForm, true);
        frmAboutJpa.setVisible(true);
    }

    public void frmReadWebpageData() throws IOException {
        FrmReadWebpageData frmReadWebpageData = new FrmReadWebpageData();
        ControllerReadWebpageData controllerReadWebpageData = new ControllerReadWebpageData();
        frmReadWebpageData.setControllerReadWebpageData(controllerReadWebpageData);
        controllerReadWebpageData.setFrmReadWebpageData(frmReadWebpageData);
        frmReadWebpageData.setVisible(true);
    }
}
