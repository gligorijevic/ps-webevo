/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import broker.JPABroker;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import storage.CorpusStorage;
import view.corpus.FrmKorpusPreview;
import view.korpus.tablemodel.SingleCorpusTableModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerKorpusPreview {
    FrmKorpusPreview frmKorpusPreview;

    public ControllerKorpusPreview() {
    }

    public ControllerKorpusPreview(FrmKorpusPreview frmKorpusPreview) {
        this.frmKorpusPreview = frmKorpusPreview;
    }

    public FrmKorpusPreview getFrmKorpusPreview() {
        return frmKorpusPreview;
    }

    public void setFrmKorpusPreview(FrmKorpusPreview frmKorpusPreview) {
        this.frmKorpusPreview = frmKorpusPreview;
    }

    public void getKorpusesComboBox() {
        frmKorpusPreview.getCmbBoxChooseKorpus().removeAllItems();
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            System.out.println(CorpusStorage.getInstance().getListOfCorpuses().get(i));
            frmKorpusPreview.getCmbBoxChooseKorpus().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
    }

    public JPopupMenu postaviPopupmenu() {
        JPopupMenu jpm = new JPopupMenu("Corpus");
        JMenuItem jmiAddSentence = new JMenuItem();
        jmiAddSentence.setText("Add sentence to Corpus");
        jmiAddSentence.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddSentenceActionPerformed(evt);
            }

            private void jmiAddSentenceActionPerformed(ActionEvent evt) {
                TaggedSentence taggedSentence = new TaggedSentence();
                taggedSentence.setSentence("");
                taggedSentence.setTags("");
                //TODO sredi da se doda i korpus.
//                new ArrayList<>(Arrays.asList("".split(" "))), new ArrayList<>(Arrays.asList("".split(" ")))
                ((SingleCorpusTableModel) frmKorpusPreview.getTrbKorpusPreview().getModel()).addNewTaggedSentence(taggedSentence);
            }
        });
        jpm.add(jmiAddSentence);
        return jpm;
    }

    public void showSingleKorpus(Corpus corpus) {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            if(corpus.equals(CorpusStorage.getInstance().getListOfCorpuses().get(i))){
                frmKorpusPreview.getTrbKorpusPreview().setModel(new SingleCorpusTableModel((List<TaggedSentence>) CorpusStorage.getInstance().getListOfCorpuses().get(i).getTaggedSentenceList()));
            }
        }
    }

    public void removeKorpus(Corpus corpus) throws Exception {
        JPABroker.getInstance().removeCorpus(corpus);
    }
    
    
}
