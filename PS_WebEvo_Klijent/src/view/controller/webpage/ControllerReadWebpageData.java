/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.webpage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GeneralDomainObject;
import model.website.HtmlPage;
import model.website.Website;
import org.jsoup.nodes.Document;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.webpage.FrmDefineWebsite;
import view.webpage.FrmReadWebpageData;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerReadWebpageData extends OpstiKontrolerKI {

    private FrmReadWebpageData frmReadWebpageData;
    private FrmDefineWebsite frmDefineWebsite;
    private HtmlPage htmlPage;

    public ControllerReadWebpageData() throws IOException {
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
        to = new TransferObject();
        to.setClientObject(frmReadWebpageData.getTxtFWebpageUrl().getText().trim());
        System.out.println(frmReadWebpageData.getTxtFWebpageUrl().getText().trim());
        to.setClientRequestOperation(RequestOntology.LOAD_WEBPAGE);
        callSystemOperation();
        String result = String.valueOf(to.getServerObject());
        frmReadWebpageData.getTxtAWebpage().setText(result);
    }

    public void copyHtmlPageStructure() {
        to = new TransferObject();
        to.setClientObject(frmReadWebpageData.getTxtFWebpageUrl().getText().trim());
        to.setClientRequestOperation(RequestOntology.COPY_WEBPAGE_STRUCTURE);
        System.out.println(getHtmlPage());
        callSystemOperation();
        htmlPage = (HtmlPage) to.getServerObject();
        frmReadWebpageData.getLblCopyDataResult().setText(to.getServerMessage());
    }

    public void saveWebsite() throws Exception {
        KonvertujGrafickiObjekatUDomenskiObjekat();
        Website website = (Website) gdo;
        website.getHtmlPageList().add(getHtmlPage());
        htmlPage.setWebsiteId(website);


        to = new TransferObject();
        to.setClientObject(website);
        to.setClientRequestOperation(RequestOntology.SAVE_WEBPAGE);
        callSystemOperation();
        JOptionPane.showMessageDialog(frmDefineWebsite, to.getServerMessage());
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
        List<GeneralDomainObject> rezultat = null;
        to = new TransferObject();
        to.setClientObject(websites);
        to.setClientRequestOperation(RequestOntology.GET_ALL_WEBSITES);
        callSystemOperation();
        rezultat = (List<GeneralDomainObject>) to.getServerObject();
        System.out.println(rezultat);
        for (GeneralDomainObject generalDomainObject : rezultat) {
            websites.add((Website) generalDomainObject);
        }
        frmDefineWebsite.fillCbWebsites(websites);
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        if (!frmDefineWebsite.getTxtFWebsiteName().getText().equals("")) {
            try {
                Website website = new Website();
                website.setWebsiteName(frmDefineWebsite.getTxtFWebsiteName().getText().trim());
                website.setWebsiteDescription(frmDefineWebsite.getTxtFWebsiteDescr().getText().trim());
                website.setWebsiteUrl(frmDefineWebsite.getTxtFWebsiteUrl().getText().trim());
                gdo = website;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmDefineWebsite, ex.getMessage());
            }
        } else {
            try {
                Website website = (Website) frmDefineWebsite.getCbWeasies().getSelectedItem();
                gdo = website;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frmDefineWebsite, ex.getMessage());
            }
        }
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
    }
}
