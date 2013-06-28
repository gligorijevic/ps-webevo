/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.webpage;

import java.io.IOException;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultTreeModel;
import org.jsoup.nodes.Document;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.webpage.FrmLoadWebpage;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerLoadWebpageFromUrl extends OpstiKontrolerKI {

    private FrmLoadWebpage frmLoadWebpage;

    public ControllerLoadWebpageFromUrl() throws IOException {
    }

    /**
     * @return the frmLoadWebpage
     */
    public FrmLoadWebpage getFrmLoadWebpage() {
        return frmLoadWebpage;
    }

    /**
     * @param frmLoadWebpage the frmLoadWebpage to set
     */
    public void setFrmLoadWebpage(FrmLoadWebpage frmLoadWebpage) {
        this.frmLoadWebpage = frmLoadWebpage;
    }

    public void parseWebpageFromUrl() throws IOException {
        to = new TransferObject();
        to.setClientObject(frmLoadWebpage.getTxtFUrl().getText().trim());
        to.setClientRequestOperation(RequestOntology.LOAD_WEBPAGE);
        callSystemOperation();
        String result = String.valueOf(to.getServerObject());
        frmLoadWebpage.getTxtAreaHTMLCode().setText(result);

        DefaultTreeModel dtm = null; 
        to = new TransferObject();
        to.setClientObject(frmLoadWebpage.getTxtFUrl().getText().trim());
        to.setClientRequestOperation(RequestOntology.GET_WEBPAGE_TREEMODEL);
        callSystemOperation();
        dtm = (DefaultTreeModel) to.getServerObject();
        frmLoadWebpage.getTreeViewNodes().setModel(dtm);
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
