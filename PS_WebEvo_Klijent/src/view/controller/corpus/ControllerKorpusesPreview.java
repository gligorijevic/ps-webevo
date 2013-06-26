/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import controller.logic.ControllerAL;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import model.corpus.Corpus;
import storage.CorpusStorage;
import view.corpus.FrmAddCorpus;
import view.corpus.FrmKorpusesPreview;
import view.korpus.tablemodel.CorpusTableModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerKorpusesPreview {

    FrmKorpusesPreview frmKorpusPreview;

    public ControllerKorpusesPreview() {
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
                FrmAddCorpus frmAddkorpus = new FrmAddCorpus(null, true);
                ControllerAddCorpus controllerAddCorpus = new ControllerAddCorpus(frmAddkorpus);
                frmAddkorpus.setControllerAddKorpus(controllerAddCorpus);
                frmAddkorpus.setVisible(true);
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
        ControllerAL.getInstance().removeCorpus(selectedCorpus);
    }
}
