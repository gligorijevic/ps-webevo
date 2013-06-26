/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.webpage;

import controller.logic.ControllerAL;
import java.io.IOException;
import javax.swing.tree.DefaultTreeModel;
import org.jsoup.nodes.Document;
import view.webpage.FrmLoadWebpage;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerLoadWebpageFromUrl {

    private FrmLoadWebpage frmLoadWebpage;

    public ControllerLoadWebpageFromUrl() {
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
        Document webpage = ControllerAL.getInstance().parseWebpageDocumentFromUrl(frmLoadWebpage.getTxtFUrl().getText().trim());
        frmLoadWebpage.getTxtAreaHTMLCode().setText(webpage.html());
        DefaultTreeModel dtm = ControllerAL.getInstance().getTreeModelFromWebpage(webpage);
        frmLoadWebpage.getTreeViewNodes().setModel(dtm);
    }
}
