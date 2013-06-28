/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.corpus;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import storage.CorpusStorage;
import util.RequestOntology;
import util.TransferObject;
import view.OpstiKontrolerKI;
import view.corpus.FrmKorpusPreview;
import view.korpus.tablemodel.SingleCorpusTableModel;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerKorpusPreview extends OpstiKontrolerKI {

    private FrmKorpusPreview frmKorpusPreview;

    public ControllerKorpusPreview() throws IOException {
        super();
    }

    public FrmKorpusPreview getFrmKorpusPreview() {
        return frmKorpusPreview;
    }

    public void setFrmKorpusPreview(FrmKorpusPreview frmKorpusPreview) {
        this.frmKorpusPreview = frmKorpusPreview;
    }

    public void getKorpusesComboBox() {
        getFrmKorpusPreview().getCmbBoxChooseKorpus().removeAllItems();
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            System.out.println(CorpusStorage.getInstance().getListOfCorpuses().get(i));
            getFrmKorpusPreview().getCmbBoxChooseKorpus().addItem(CorpusStorage.getInstance().getListOfCorpuses().get(i));
        }
        getFrmKorpusPreview().getCmbBoxChooseKorpus().setSelectedIndex(-1);
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
                ((SingleCorpusTableModel) getFrmKorpusPreview().getTrbKorpusPreview().getModel()).addNewTaggedSentence(taggedSentence);
            }
        });
        jpm.add(jmiAddSentence);
        return jpm;
    }

    public void showSingleKorpus(Corpus corpus) {
        for (int i = 0; i < CorpusStorage.getInstance().getListOfCorpuses().size(); i++) {
            if (corpus.equals(CorpusStorage.getInstance().getListOfCorpuses().get(i))) {
                int provera = CorpusStorage.getInstance().getListOfCorpuses().get(i).getTaggedSentenceList().size();
                System.out.println("Provera " + provera);
                getFrmKorpusPreview().getTrbKorpusPreview().setModel(new SingleCorpusTableModel((List<TaggedSentence>) CorpusStorage.getInstance().getListOfCorpuses().get(i).getTaggedSentenceList()));
            }
        }
    }

    public void removeKorpus(Corpus corpus) throws Exception {
        to = new TransferObject();
        to.setClientObject(corpus);
        to.setClientRequestOperation(RequestOntology.REMOVE_CORPUS);
        callSystemOperation();
        JOptionPane.showMessageDialog(frmKorpusPreview, to.getServerMessage());
        CorpusStorage.getInstance().refreshData();
        getFrmKorpusPreview().getTrbKorpusPreview().setModel(new DefaultTableModel());
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
    }
}
