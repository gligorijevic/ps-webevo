/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.webpage;

import controller.logic.ControllerAL;
import java.io.IOException;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import model.website.HtmlPage;
import model.website.Website;
import org.jsoup.nodes.Document;
import view.webpage.FrmDefineWebsite;
import view.webpage.FrmReadWebpageData;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerReadWebpageData {

    private FrmReadWebpageData frmReadWebpageData;
    private FrmDefineWebsite frmDefineWebsite;
    private Document webpage;
    private HtmlPage htmlPage;

    public ControllerReadWebpageData() {
        htmlPage = new HtmlPage();
    }

    public void setFrmReadWebpageData(FrmReadWebpageData frmReadWebpageData) {
        this.frmReadWebpageData = frmReadWebpageData;
    }

    public FrmReadWebpageData getFrmReadWebpageData() {
        return frmReadWebpageData;
    }

    public void parseWebpageFromUrl() throws IOException {
        setWebpage(ControllerAL.getInstance().parseWebpageDocumentFromUrl(frmReadWebpageData.getTxtFWebpageUrl().getText().trim()));
        frmReadWebpageData.getTxtAWebpage().setText(getWebpage().html());
    }
    
    public void copyHtmlPageStructure(){
        ControllerAL.getInstance().copyHtmlPageStructure(getWebpage(), getHtmlPage());
        System.out.println(getHtmlPage());
        frmReadWebpageData.getLblCopyDataResult().setText("Successful copy.");
    }

    public void saveCopiedHtmlPage() throws Exception {
        ControllerAL.getInstance().saveHtmlPage(getHtmlPage());
    }

    public void saveWebsite(Website website) throws Exception {
       website.getHtmlPageList().add(getHtmlPage());
       
       ControllerAL.getInstance().saveWebsite(website);
    }

    /**
     * @return the frmDefineWebsite
     */
    public FrmDefineWebsite getFrmDefineWebsite() {
        return frmDefineWebsite;
    }

    /**
     * @param frmDefineWebsite the frmDefineWebsite to set
     */
    public void setFrmDefineWebsite(FrmDefineWebsite frmDefineWebsite) {
        this.frmDefineWebsite = frmDefineWebsite;
    }

    /**
     * @return the webpage
     */
    public Document getWebpage() {
        return webpage;
    }

    /**
     * @param webpage the webpage to set
     */
    public void setWebpage(Document webpage) {
        this.webpage = webpage;
    }

    /**
     * @return the htmlPage
     */
    public HtmlPage getHtmlPage() {
        return htmlPage;
    }

    /**
     * @param htmlPage the htmlPage to set
     */
    public void setHtmlPage(HtmlPage htmlPage) {
        this.htmlPage = htmlPage;
    }

    public void fillCbOnFrmDefineWebsite() {
        List<Website> websites = ControllerAL.getInstance().getAddWebsites();
        
        frmDefineWebsite.fillCbWebsites(websites);
    }
}
