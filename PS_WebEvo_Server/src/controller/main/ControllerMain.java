/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.main;

import view.controller.corpus.ControllerKorpusPreview;
import view.controller.corpus.ControllerAddCorpus;
import view.controller.corpus.ControllerKorpusesPreview;
import view.controller.sentence.ControllerSentence;
import view.FrmMain;
import view.about.FrmAboutJPA;
import view.about.FrmAboutJSoup;
import view.about.FrmAboutLingPipe;
import view.about.FrmAboutWebEvo;
import view.administer.users.FrmAddNewUser;
import view.administer.users.FrmRemoveSelectedUser;
import view.administer.users.PnlPreviewUsers;
import view.controller.administer.users.ControllerAddNewUser;
import view.controller.administer.users.ControllerPreviewUsers;
import view.controller.administer.users.ControllerRemoveSelectedUser;
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
    public void frmAddKorpus() {
        FrmAddCorpus frmAddkorpus = new FrmAddCorpus(mainForm, true);
        ControllerAddCorpus controllerAddCorpus = new ControllerAddCorpus(frmAddkorpus);
        frmAddkorpus.setControllerAddKorpus(controllerAddCorpus);
        frmAddkorpus.setVisible(true);
    }

    public void addTaggedSentenceForm(FrmMain frmMain) {
        FrmAddTaggedSentence frmTaggedSentence = new FrmAddTaggedSentence(frmMain, true);
        ControllerSentence controllerSentence = new ControllerSentence(frmTaggedSentence);
        frmTaggedSentence.setControllerSentence(controllerSentence);
        frmTaggedSentence.update();
        frmTaggedSentence.setVisible(true);
    }

    public void frmKorpusesPreview(FrmMain frmMain) {
        FrmKorpusesPreview frmKorpusPreview = new FrmKorpusesPreview(frmMain, false);
        ControllerKorpusesPreview controllerKorpusesPreview = new ControllerKorpusesPreview();
        frmKorpusPreview.setControllerKorpusesPreview(controllerKorpusesPreview);
        controllerKorpusesPreview.setFrmKorpusPreview(frmKorpusPreview);
        frmKorpusPreview.updateForm();
        frmKorpusPreview.setVisible(true);
    }

//    public void saveKorpus(int id) throws ClassNotFoundException, SQLException {
//        
//        DBBroker.getInstance().updateKorpus(id);
//    }
//    public void getKorpus(int id) throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().getKorpus(id);
//    }
//    
//    public void removeAllKorpuses() throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().removeAllKorpuses();
//    }
//    
//    public void removeKorpus(int id) throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().removeCorpus(id);
//    }
//    
//    public void getTaggedSentence(int id) throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().getTaggedSentence(id);
//    }
//    
//    public void getTaggedSentences() throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().getTaggedSentences();
//    }
//    
//    public void removeTaggedSentence(int id) throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().removeTaggedSentences();
//    }
//    
//    public void removeTaggedSentences() throws ClassNotFoundException, SQLException {
//        DBBroker.getInstance().removeTaggedSentences();
//    }
    public void frmKorpusPreview() {
        FrmKorpusPreview frmKorpusPreview = new FrmKorpusPreview(mainForm, false);
        ControllerKorpusPreview controllerKorpusPreview = new ControllerKorpusPreview();
        frmKorpusPreview.setControllerKorpusPreview(controllerKorpusPreview);
        controllerKorpusPreview.setFrmKorpusPreview(frmKorpusPreview);
        frmKorpusPreview.updateForm();
        frmKorpusPreview.setVisible(true);
    }

    public void frmTrainingTaggerModel() {
        FrmTrainingTaggerModel frmTrainingTaggerModel = new FrmTrainingTaggerModel(mainForm, true);
        ControllerTraining controllerTraining = new ControllerTraining();
        frmTrainingTaggerModel.setControllerTraining(controllerTraining);
        controllerTraining.setFrmTrainingTaggerModel(frmTrainingTaggerModel);
        frmTrainingTaggerModel.updateForm();
        frmTrainingTaggerModel.setVisible(true);
    }

    public void frmLoadWebpage() {
        FrmLoadWebpage frmLoadWebpage = new FrmLoadWebpage();
        ControllerLoadWebpageFromUrl clwfu = new ControllerLoadWebpageFromUrl();
        frmLoadWebpage.setClwfu(clwfu);
        clwfu.setFrmLoadWebpage(frmLoadWebpage);
        frmLoadWebpage.setVisible(true);
    }

    public void frmAddNewUser() {
        FrmAddNewUser frmAddNewUser = new FrmAddNewUser(mainForm, false);
        ControllerAddNewUser controllerAddNewUser = new ControllerAddNewUser();
        frmAddNewUser.setControllerAddNewUser(controllerAddNewUser);
        controllerAddNewUser.setFrmAddNewUser(frmAddNewUser);
//        controllerAddNewUser.fillCbData();
        frmAddNewUser.setVisible(true);
    }

    public void frmRemoveSelecterUser() {
        FrmRemoveSelectedUser frmRemoveSelecterUser = new FrmRemoveSelectedUser(mainForm, true);
        ControllerRemoveSelectedUser controllerRemoveSelectedUser = new ControllerRemoveSelectedUser();
        frmRemoveSelecterUser.setControllerRemoveSelectedUser(controllerRemoveSelectedUser);
        controllerRemoveSelectedUser.setFrmRemoveSelectedUser(frmRemoveSelecterUser);
        frmRemoveSelecterUser.setVisible(true);
    }

    public void pnlPreviewUsers() {
        PnlPreviewUsers pnlPreviewUsers = new PnlPreviewUsers();
        ControllerPreviewUsers controllerPreviewUsers = new ControllerPreviewUsers();
        pnlPreviewUsers.setControllerPreviewUsers(controllerPreviewUsers);
        controllerPreviewUsers.setPnlPreviewUsers(pnlPreviewUsers);
        controllerPreviewUsers.setData();
        mainForm.setActivePanel(pnlPreviewUsers);
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

    public void frmReadWebpageData() {
        FrmReadWebpageData frmReadWebpageData = new FrmReadWebpageData();
        ControllerReadWebpageData controllerReadWebpageData = new ControllerReadWebpageData();
        frmReadWebpageData.setControllerReadWebpageData(controllerReadWebpageData);
        controllerReadWebpageData.setFrmReadWebpageData(frmReadWebpageData);
        frmReadWebpageData.setVisible(true);
    }
}
