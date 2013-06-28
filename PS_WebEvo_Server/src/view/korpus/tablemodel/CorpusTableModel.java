/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.korpus.tablemodel;

import broker.JPABroker;
import controller.logic.ControllerAL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.corpus.Corpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class CorpusTableModel extends AbstractTableModel {

    List<Corpus> allCorpuses = null;

    public CorpusTableModel(List<Corpus> allCorpuses) {
        this.allCorpuses = allCorpuses;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return allCorpuses.get(row).getCorpusId();
            case 1:
                return allCorpuses.get(row).getCorpusName();
            case 2:
                return allCorpuses.get(row).getCorpusDescription();
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return allCorpuses.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Corpus Id";
            case 1:
                return "Corpus name";
            case 2:
                return "Corpus description";
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column); //To change body of generated methods, choose Tools | Templates.
        String fix = String.valueOf(aValue);

        Corpus corpus = allCorpuses.get(row);

        switch (column) {
            case 0:
                corpus.setCorpusId(Integer.parseInt(fix));
//                taggedSentence.setWords(new ArrayList<>(Arrays.asList(fix.split(" "))));
//                persistence.KorpusPersistence.getInstance().getKorpusFromId(taggedSentence.getKorpus().getId()).getTaggedSentenceFromKorpusById(taggedSentence.getId()).setWords(new ArrayList<>(Arrays.asList(fix.split(" "))));
                break;
            case 1:
                corpus.setCorpusName(fix);
//                taggedSentence.setWords(new ArrayList<>(Arrays.asList(fix.split(" "))));
//                persistence.KorpusPersistence.getInstance().getKorpusFromId(taggedSentence.getKorpus().getId()).getTaggedSentenceFromKorpusById(taggedSentence.getId()).setTags(new ArrayList<>(Arrays.asList(fix.split(" "))));
                break;
            case 2:
                corpus.setCorpusDescription(fix);
//                persistence.KorpusPersistence.getInstance().getKorpusFromId(taggedSentence.getKorpus().getId()).getTaggedSentenceFromKorpusById(taggedSentence.getId()).setKorpus((Korpus) aValue);
        }
        try {
//            ControllerAL.getInstance().updateCorpus(corpus);
            ControllerAL.getInstance().updateGDO(corpus);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "System failed to update corpus.");
        }
        fireTableDataChanged();
    }
    
//    public void addNewTaggedSentence(TaggedSentence taggedSentence) {
//        allCorpuses.add(taggedSentence);
//        fireTableDataChanged();
//    }
}
