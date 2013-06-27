/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.korpus.tablemodel;

import broker.DBBroker;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.corpus.TaggedSentence;

/**
 *
 * @author Djordje Gligorijevic
 */
public class SingleCorpusTableModel extends AbstractTableModel {

    List<TaggedSentence> allSentences = null; // = persistence.KorpusPersistence.getInstance().getAllTaggedSentences();

    public SingleCorpusTableModel(List<TaggedSentence> sentences) {
        this.allSentences = sentences;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return allSentences.get(row).getSentence();
            case 1:
                return allSentences.get(row).getTags();
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return allSentences.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Sentence";
            case 1:
                return "Tags";
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column); //To change body of generated methods, choose Tools | Templates.
        String fix = String.valueOf(aValue);

        TaggedSentence taggedSentence = allSentences.get(row);

        switch (column) {
            case 0:
                taggedSentence.setSentence(fix);
//                persistence.KorpusPersistence.getInstance().getKorpusFromId(taggedSentence.getKorpus().getId()).getTaggedSentenceFromKorpusById(taggedSentence.getId()).setWords(new ArrayList<>(Arrays.asList(fix.split(" "))));
                break;
            case 1:
                taggedSentence.setTags(fix);
//                persistence.KorpusPersistence.getInstance().getKorpusFromId(taggedSentence.getKorpus().getId()).getTaggedSentenceFromKorpusById(taggedSentence.getId()).setTags(new ArrayList<>(Arrays.asList(fix.split(" "))));
                break;
        }
        DBBroker.getInstance().updateGDO(taggedSentence);
        
        fireTableDataChanged();
    }
    
    public void addNewTaggedSentence(TaggedSentence taggedSentence) {
        allSentences.add(taggedSentence);
        fireTableDataChanged();
    }
}
