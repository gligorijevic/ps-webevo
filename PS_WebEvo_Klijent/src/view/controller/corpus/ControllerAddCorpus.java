/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import java.io.IOException;
import javax.swing.JOptionPane;
import model.corpus.Corpus;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.corpus.FrmAddCorpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAddCorpus extends OpstiKontrolerKI {

    private FrmAddCorpus frmAddCorpus;

    public ControllerAddCorpus() throws IOException {
        super();
    }

    public void addNewCorpus() {
//        ControllerAL.getInstance().addNewCorpus(corpus);
//        ControllerAL.getInstance().addNewGDO(corpus);
        to = new TransferObject();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        to.setClientObject(gdo);
        to.setClientRequestOperation(RequestOntology.ADD_NEW_CORPUS);
        callSystemOperation();
        JOptionPane.showMessageDialog(frmAddCorpus, to.getServerMessage());
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        String corpusName = frmAddCorpus.getTxtFKorpusName().getText().trim();
        String corpusDescription = frmAddCorpus.getTxtAKorpusDescription().getText().trim();
        Corpus newCorpus = new Corpus();
        newCorpus.setCorpusName(corpusName);
        newCorpus.setCorpusDescription(corpusDescription);
        gdo = newCorpus;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
    }

    /**
     * @return the frmAddCorpus
     */
    public FrmAddCorpus getFrmAddCorpus() {
        return frmAddCorpus;
    }

    /**
     * @param frmAddCorpus the frmAddCorpus to set
     */
    public void setFrmAddCorpus(FrmAddCorpus frmAddCorpus) {
        this.frmAddCorpus = frmAddCorpus;
    }
}
