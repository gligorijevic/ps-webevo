/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logic;

import broker.DBBroker;
import java.io.IOException;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import logic.tagger.EntityCorpus.TrainingCorpus;
import logic.tagger.train.NamedEntityRecognitionTraining;
import logic.webpage.parse.HtmlParsing;
import logic.webpage.parse.TreeModelFromHtmlPage;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
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

    public void addNewCorpus(Corpus corpus) throws Exception {
        DBBroker.getInstance().addNewCorpus(corpus);
    }

    public List<Corpus> getAllCorpuses() {
        return DBBroker.getInstance().getAllCorpuses();
    }

    public void addNewTaggedSentence(TaggedSentence ts) throws Exception {
        DBBroker.getInstance().addNewTaggedSentence(ts);
    }

    public void updateCorpus(Corpus corpus) throws Exception {
        DBBroker.getInstance().updateCorpus(corpus);
    }

    public void removeCorpus(Corpus selectedCorpus) throws Exception {
        DBBroker.getInstance().removeCorpus(selectedCorpus);
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
    
    public void copyHtmlPageStructure(Document htmlDocument, HtmlPage htmlPage){
        TreeModelFromHtmlPage.copyHtmlStructure(htmlDocument, htmlPage);
    }

    public void saveHtmlPage(HtmlPage htmlPage) throws Exception {
        DBBroker.getInstance().addHtmlPage(htmlPage);
    }
    
    public void saveWebsite(Website website) throws Exception{
        DBBroker.getInstance().addWebsite(website);
    }

    public List<Website> getAddWebsites() {
        return DBBroker.getInstance().getAllWebsites();
    }
}
