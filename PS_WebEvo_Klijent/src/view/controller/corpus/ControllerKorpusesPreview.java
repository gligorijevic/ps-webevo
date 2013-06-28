/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import model.corpus.Corpus;
import storage.CorpusStorage;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.corpus.FrmAddCorpus;
import view.corpus.FrmKorpusesPreview;
import view.korpus.tablemodel.CorpusTableModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerKorpusesPreview extends OpstiKontrolerKI {

    FrmKorpusesPreview frmKorpusPreview;

    public ControllerKorpusesPreview() throws IOException {
    }

    public void setFrmKorpusPreview(FrmKorpusesPreview frmKorpusPreview) {
        this.frmKorpusPreview = frmKorpusPreview;
    }

    public FrmKorpusesPreview getFrmKorpusPreview() {
        return frmKorpusPreview;
    }

    public void removeTaggedSentence(int index, Corpus corpus) {
//        try {
//
//            int key = (storage.KorpusPersistence.getInstance().getTaggedSentence(index, k)).getId();
//            storage.KorpusPersistence.getInstance().deleteTaggedSentence(index, k);
//
//            DBBroker.getInstance().removeTaggedSentence(key);
//            JOptionPane.showMessageDialog(null, "Korpus has been successfully updated.");
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(FrmKorpusesPreview.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public JPopupMenu postaviPopupmenu() {
        JPopupMenu jpm = new JPopupMenu("Corpus");
        JMenuItem jmiAddSentence = new JMenuItem();
        jmiAddSentence.setText("Add new corpus.");
        jmiAddSentence.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddCorpusActionPerformed(evt);
            }

            private void jmiAddCorpusActionPerformed(ActionEvent evt) {
                try {
                    FrmAddCorpus frmAddkorpus = new FrmAddCorpus(null, true);
                    ControllerAddCorpus controllerAddCorpus = new ControllerAddCorpus();
                    controllerAddCorpus.setFrmAddCorpus(frmAddkorpus);
                    frmAddkorpus.setControllerAddKorpus(controllerAddCorpus);
                    frmAddkorpus.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ControllerKorpusesPreview.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JMenuItem jmiRemoveSentence = new JMenuItem();
        jmiAddSentence.setText("Remove corpus.");
        jmiAddSentence.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jmiRemoveCorpusActionPerformed(evt);
                    JOptionPane.showMessageDialog(frmKorpusPreview, "Selected corpus has been removed succesfully.");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frmKorpusPreview, ex.getMessage());
                }
            }

            private void jmiRemoveCorpusActionPerformed(ActionEvent evt) throws Exception {
                removeSelectedCorpus();
            }
        });
        jpm.add(jmiAddSentence);
        jpm.add(jmiRemoveSentence);
        return jpm;
    }

    public void setTableData() {
        frmKorpusPreview.getTblKorpus().setModel(new CorpusTableModel(CorpusStorage.getInstance().getListOfCorpuses()));
    }

    public void removeSelectedCorpus() throws Exception {
        Corpus selectedCorpus = CorpusStorage.getInstance().getListOfCorpuses().get(frmKorpusPreview.getTblKorpus().getSelectedRow());
        to = new TransferObject();
        to.setClientObject(selectedCorpus);
        to.setClientRequestOperation(RequestOntology.REMOVE_CORPUS);
        callSystemOperation();
        JOptionPane.showMessageDialog(frmKorpusPreview, to.getServerMessage());
        CorpusStorage.getInstance().refreshData();
        setTableData();
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
    }
}
