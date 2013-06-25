/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TypeConverter {
    
    public static String Konvertuj(JFormattedTextField kon_u, String kon_i) {
        return (String) kon_u.getValue();
    }

   public static String Konvertuj(JTextField kon_u, String kon_i) {
        return kon_u.getText();
    }

   
   public static Date Konvertuj(Double d){
         Long time= Math.round(d);
        Date date= new Date(time);
        return date;
   }
    
    public static String Konvertuj(JTextArea kon_u, String kon_i) {
        return kon_u.getText();
    }

    public static java.util.Date Konvertuj(JTextField kon_u, java.util.Date kon_i) throws ParseException {
        java.util.Date date = null;
        if (kon_u != null&&!kon_u.getText().equals("")) {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(kon_u.getText().trim());
        }
        return date;
    }

    public static Double Konvertuj(JFormattedTextField kon_u, Double kon_i) {
        return (Double) kon_u.getValue();
    }

    public static int Konvertuj(JTextField kon_u, int kon_i) {
        return Integer.parseInt(kon_u.getText());
    }

    public static boolean Konvertuj(JCheckBox kon_u, boolean kon_i) {
        return kon_u.isSelected();
    }

// Konvertovanje prostih tipova i tipova objekata u tipove grafickih elemenata
    public static void Konvertuj(String kon_u, JFormattedTextField kon_i) {
        kon_i.setValue(kon_u);
    }

    public static void Konvertuj(String kon_u, JTextField kon_i) {
        kon_i.setText(kon_u);
    }

    public static void Konvertuj(java.util.Date kon_u, JTextField kon_i) {
        if(kon_u!=null)
        kon_i.setText(kon_u.toString());
    }

//    public static void Konvertuj(List<Reference> references, javax.swing.JList list) {
//        DefaultListModel dlm = new DefaultListModel();
//        for (Reference refer : references) {
//            dlm.addElement(refer);
//        }
//        list.setModel(dlm);
//    }

    public static void Konvertuj(String kon_u, JTextArea kon_i) {
        kon_i.setText(kon_u);
    }

    public static void Konvertuj(Double kon_u, JFormattedTextField kon_i) {
        kon_i.setValue(kon_u);
    }

    public static void Konvertuj(boolean kon_u, JCheckBox kon_i) {
        kon_i.setSelected(kon_u);
    }

// Konvertovanje tabele u niz objekata
    public static void KonvertujTabeluUNizObjekata(JTable Tabela, GeneralDomainObject[] nizObjekata) {
        try {
            for (int i = 0; i < Tabela.getRowCount(); i++) {
                for (int j = 0; j < Tabela.getColumnCount(); j++) {
                    Object ob = Tabela.getValueAt(i, j);
                    Polje.Napuni(j, ob, nizObjekata[i]);
                }
            }
        } catch (IllegalAccessException iae) {
        }
    }

// Konvertovanje niza objekata u tabelu
    public static void KonvertujNizObjekataUTabelu(GeneralDomainObject[] nizObjekata, JTable Tabela) {
        try {
            DefaultTableModel DTM = (DefaultTableModel) Tabela.getModel();
            DTM.setRowCount(nizObjekata.length);
            if(nizObjekata!=null&&nizObjekata[0]!=null)
            DTM.setColumnCount(nizObjekata[0].getClass().getDeclaredFields().length);
            for (int i = 0; i < nizObjekata.length; i++) {
                for (int j = 0; j < Tabela.getColumnCount(); j++) {
                    Tabela.setValueAt(Polje.Vrati(j, nizObjekata[i]), i, j);
                }
            }
        } catch (IllegalAccessException iae) {
        }
    }

// Konvertovanje atributa result seta u atribut objekta
    public static String Konvertuj(ResultSet kon_u, String kon_i, String nazivAtributa) {
        try {
            return kon_u.getString(nazivAtributa);
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return "";
        }
    }

    public static Double Konvertuj(ResultSet kon_u, Double kon_i, String nazivAtributa) {
        try {
            return new Double(kon_u.getDouble(nazivAtributa));
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return new Double(0);
        }
    }

    public static boolean Konvertuj(ResultSet kon_u, boolean kon_i, String nazivAtributa) {
        try {
            return kon_u.getBoolean(nazivAtributa);
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return false;
        }
    }

    public static Integer Konvertuj(ResultSet kon_u, Integer kon_i, String nazivAtributa) {
        try {
            return new Integer(kon_u.getInt(nazivAtributa));
        } catch (SQLException sqle) {
            System.out.println(sqle);
            return new Integer(0);
        }
    }
}

 class Polje {

    public static void Napuni(int j, Object ob, GeneralDomainObject gdo) throws IllegalAccessException {
        Class cl = ((Object) gdo).getClass();
        Field[] f = cl.getDeclaredFields();
        // Puni j-ti atribut polje tekuceg objekta (odo) sa vrednoscu ob.
        f[j].set(gdo, ob);
    }

    public static Object Vrati(int j, GeneralDomainObject gdo) throws IllegalAccessException {
        Class cl = ((Object) gdo).getClass();
        Field[] f = cl.getDeclaredFields();
        // Vraca od tekuceg objekta (odo) vrednost i-tog atributa (polja).
        return f[j].get(gdo);
    }
}
