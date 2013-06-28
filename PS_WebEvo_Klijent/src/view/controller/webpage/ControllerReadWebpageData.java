/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.webpage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.GeneralDomainObject;
import model.website.HtmlPage;
import model.website.Website;
import org.jsoup.nodes.Document;
import view.OpstiKontrolerKI;
import view.webpage.FrmDefineWebsite;
import view.webpage.FrmReadWebpageData;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerReadWebpageData extends OpstiKontrolerKI{

    private FrmReadWebpageData frmReadWebpageData;
    private FrmDefineWebsite frmDefineWebsite;
    private Document webpage;
    private HtmlPage htmlPage;

    public ControllerReadWebpageData() throws IOException{
        super();
        htmlPage = new HtmlPage();
    }

    public void setFrmReadWebpageData(FrmReadWebpageData frmReadWebpageData) {
        this.frmReadWebpageData = frmReadWebpageData;
    }

    public FrmReadWebpageData getFrmReadWebpageData() {
        return frmReadWebpageData;
    }

    public void parseWebpageFromUrl() throws IOException {
        //setWebpage(ControllerAL.getInstance().parseWebpageDocumentFromUrl(frmReadWebpageData.getTxtFWebpageUrl().getText().trim()));
        //TODO
        frmReadWebpageData.getTxtAWebpage().setText(getWebpage().html());
    }

    public void copyHtmlPageStructure() {
        //ControllerAL.getInstance().copyHtmlPageStructure(getWebpage(), getHtmlPage());
        //TODO
        System.out.println(getHtmlPage());
        frmReadWebpageData.getLblCopyDataResult().setText("Successful copy.");
    }

    public void saveCopiedHtmlPage() throws Exception {
        //TODO
        //ControllerAL.getInstance().saveHtmlPage(getHtmlPage());
    }

    public void saveWebsite(Website website) throws Exception {
        website.getHtmlPageList().add(getHtmlPage());
        htmlPage.setWebsiteId(website);
        //ControllerAL.getInstance().saveWebsite(website);
        //TODO
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
        List<Website> websites = new ArrayList<Website>();
        List<GeneralDomainObject> rezultat = null; //TODO ControllerAL.getInstance().returnAll(new Website());
        for (GeneralDomainObject generalDomainObject : rezultat) {
            websites.add((Website) generalDomainObject);
        }
        frmDefineWebsite.fillCbWebsites(websites);
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
