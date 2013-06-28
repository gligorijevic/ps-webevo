/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logic;

import broker.JPABroker;
import exception.UserAlreadyExistsException;
import exception.WrongUsernameOrPasswordException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import logic.login.Login;
import logic.register.Register;
import logic.tagger.EntityCorpus.TrainingCorpus;
import logic.tagger.train.NamedEntityRecognitionTraining;
import logic.webpage.parse.HtmlParsing;
import logic.webpage.parse.TreeModelFromHtmlPage;
import model.GeneralDomainObject;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import model.users.User;
import model.website.HtmlPage;
import model.website.Website;
import org.jsoup.nodes.Document;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAL {

    private static ControllerAL instance;

    private ControllerAL() {
    }

    public static ControllerAL getInstance() {
        if (instance == null) {
            instance = new ControllerAL();
        }
        return instance;
    }

    /* Beginning of GeneralDomainObject calls */
    public void addNewGDO(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        try {
            JPABroker.getInstance().createNew(gdo);
            JPABroker.getInstance().commitTransaction();
        } catch (Exception ex) {
            JPABroker.getInstance().rollbackTransaction();
        }
    }

    public List<GeneralDomainObject> returnAll(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        List<GeneralDomainObject> result = JPABroker.getInstance().returnAll(gdo);
        JPABroker.getInstance().closeTransaction();
        return result;
    }

    public List<GeneralDomainObject> returnGDOsByCondition(GeneralDomainObject odo, HashMap<String, Object> mapFieldValue) throws Exception {
        List<GeneralDomainObject> result;
        JPABroker.getInstance().beginTransaction();
        try {
            result = JPABroker.getInstance().returnGDOforCondition(odo, mapFieldValue);
            JPABroker.getInstance().commitTransaction();
            return result;
        } catch (Exception ex) {
            JPABroker.getInstance().rollbackTransaction();
            throw ex;
        }
    }

    public void insertNewGDO(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        try {
            JPABroker.getInstance().createNew(gdo);
            JPABroker.getInstance().commitTransaction();
        } catch (Exception ex) {
            JPABroker.getInstance().rollbackTransaction();
        }
    }

    public void saveGDO(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        try {
            JPABroker.getInstance().saveGDO(gdo);
            JPABroker.getInstance().commitTransaction();
        } catch (Exception ex) {
            JPABroker.getInstance().rollbackTransaction();
        }
    }

    public void deleteGDO(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        JPABroker.getInstance().deleteGDO(gdo);
        JPABroker.getInstance().closeTransaction();
    }

    public void updateGDO(GeneralDomainObject gdo) {
        JPABroker.getInstance().beginTransaction();
        JPABroker.getInstance().updateGDO(gdo);
        JPABroker.getInstance().commitTransaction();
    }

    /* Ending of GeneralDomainObject calls */
    public User login(String username, String password) throws WrongUsernameOrPasswordException {
        return Login.login(username, password);
    }

    public void register(User regUser) throws UserAlreadyExistsException  {
        Register.register(regUser);
    }

    public void addNewCorpus(Corpus corpus) throws Exception {
        JPABroker.getInstance().addNewCorpus(corpus);
    }

    public List<Corpus> getAllCorpuses() {
        return JPABroker.getInstance().getAllCorpuses();
    }

    public void addNewTaggedSentence(TaggedSentence ts) throws Exception {
        JPABroker.getInstance().addNewTaggedSentence(ts);
    }

    public void updateCorpus(Corpus corpus) throws Exception {
        JPABroker.getInstance().updateCorpus(corpus);
    }

    public void removeCorpus(Corpus selectedCorpus) throws Exception {
        JPABroker.getInstance().removeCorpus(selectedCorpus);
    }

    public String startTraining(Corpus corpus) throws IOException {
        TrainingCorpus trainingCorpus = new TrainingCorpus(
                corpus.getTaggedSentenceList(), corpus.getCorpusName());

        return NamedEntityRecognitionTraining.trainNamedEntityRecognitionModel(trainingCorpus);
    }

    public String parseWebpageFromUrl(String stringUrl) throws IOException {
        String responseCode = null;
        return responseCode = HtmlParsing.parseUrlJsoup(stringUrl);
    }

    public Document parseWebpageDocumentFromUrl(String stringUrl) throws IOException {
        return HtmlParsing.getHTMLDocument(stringUrl);
    }

    public String parseWebpageFromFile(String filepath) throws IOException {
        return HtmlParsing.parseFileJsoup(filepath);
    }

    public DefaultTreeModel getTreeModelFromWebpage(Document urlDocument) throws IOException {
        DefaultTreeModel dtm;
        DefaultMutableTreeNode dmtn = TreeModelFromHtmlPage.getTreeNodes(urlDocument);
        dtm = new DefaultTreeModel(dmtn);
        return dtm;
    }

    public void copyHtmlPageStructure(Document htmlDocument, HtmlPage htmlPage) {
        TreeModelFromHtmlPage.copyHtmlStructure(htmlDocument, htmlPage);
    }

    public void saveHtmlPage(HtmlPage htmlPage) throws Exception {
        JPABroker.getInstance().addHtmlPage(htmlPage);
    }

    public void saveWebsite(Website website) throws Exception {
        JPABroker.getInstance().addWebsite(website);
    }

    public List<Website> getAddWebsites() {
        return JPABroker.getInstance().getAllWebsites();
    }
}
