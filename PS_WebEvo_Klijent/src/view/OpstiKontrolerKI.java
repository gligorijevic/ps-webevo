package view;

/*
 * KontrolerKI.java
 *
 * 02.05.2011
 *
 * @autor Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */
import java.awt.event.*;
import javax.swing.table.*;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GeneralDomainObject;
import model.users.User;
import util.RequestOntology;
import util.TransferObject;

public abstract class OpstiKontrolerKI {

    protected Socket soketK;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;
    protected String signal;
    protected GeneralDomainObject gdo;
    protected TransferObject to;
    protected OpstaEkranskaForma oef;

    protected OpstiKontrolerKI() throws IOException {
        soketK = new Socket("127.0.0.1", 8189);
        out = new ObjectOutputStream(soketK.getOutputStream());
        in = new ObjectInputStream(soketK.getInputStream());
        System.out.println("Povezan sa serverom.");
    }

    public String pritisakTipke(KeyEvent evt) {
        DefaultTableModel DTM = (DefaultTableModel) oef.vratiModel();
        if (evt.getKeyCode() == KeyEvent.VK_INSERT) {
            DTM.addRow(oef.vratiPocetneVrednosti());
            return "Unet novi red u kolonu";
        }

        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            int selRed = oef.vratiSelektovaniRed();
            if (selRed >= 0) {
                DTM.removeRow(selRed);
                return SOZapamti();
            } else {
                return "Red ne moze da se brise ako nije selektovan.";
            }
        }

        return "Uneta je tipka koja se ne obradjuje.";
    }

    public String pustanjeTipke(KeyEvent evt) {
        DefaultTableModel DTM = (DefaultTableModel) oef.vratiModel();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            return SOZapamti();
        }
        return "Uneta je tipka koja se ne obradjuje.";
    }

    public String SOPretrazi() {
        gdo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Pretrazi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();

        return signal;
    }

    public String SOKreirajNovi() {
        gdo = oef.kreirajObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("kreirajNovi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOZapamti() {
        to = new TransferObject();
        gdo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        to.setClientObject(gdo);
        to.setClientRequestOperation(RequestOntology.REGISTER);
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         */
        signal = pozivSO("Zapamti");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOStorniraj() {
        gdo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Storniraj");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public String SOObradi() {
        gdo = oef.kreirajObjekat();
        KonvertujGrafickiObjekatUDomenskiObjekat();
        /**
         * ****** POZIVA SE KONTROLER APL. LOGIKE DA IZVRSI SISTEMSKU OPERACIJU
         * ********
         */
        signal = pozivSO("Obradi");
        /**
         * *******************************************************************************
         */
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return signal;
    }

    public List<GeneralDomainObject> SOVratiSve() {
        gdo = oef.kreirajObjekat();
        List<GeneralDomainObject> odoList = null;
        try {
            out.writeObject("VratiSve");
            out.writeObject(gdo);
        } catch (IOException ex) {
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Neuspesno slanje objekata ka serveru.");
        }
        try {
            odoList = (List<GeneralDomainObject>) in.readObject();
            signal = (String) in.readObject();
            System.out.println(signal);
        } catch (IOException ex) {
            System.out.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Neuspesno citanje objekata sa servera.");
            Logger.getLogger(OpstiKontrolerKI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return odoList;

    }

    String pozivSO(String nazivSO) {
        try {
            out.writeObject(nazivSO);
            out.writeObject(gdo);
        } catch (IOException io) {
            return "Neuspesno slanje objekata ka serveru.";
        }

        try {
            gdo = (GeneralDomainObject) in.readObject();
            signal = (String) in.readObject();
        } catch (Exception e) {
            return "Neuspesno citanje objekata sa servera";
        }
        return signal;
    }

    /* Korisne metode koje se koriste */
    public User login() {
        to = new TransferObject();
        gdo = oef.kreirajObjekat();

        KonvertujGrafickiObjekatUDomenskiObjekat();
        to.setClientObject(gdo);
        to.setClientRequestOperation(RequestOntology.LOGIN);
//        signal = pozivSO("Login");
        callSystemOperation();
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return (User) gdo;
    }

    public String callSystemOperation() {
        try {
            out.writeObject(to);
        } catch (IOException io) {
            return io.getMessage();
        }
        try {
            to = (TransferObject) in.readObject();
            try {
                gdo = (GeneralDomainObject) to.getServerObject();
                if (gdo == null) {
                    return "Neuspesna komunikacija";
                }
            } catch (ClassCastException ex) {
                gdo = null;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return "Neuspesno citanje objekata sa servera";
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            return "Pogresno kastovanje objekata";
        }
        return signal;
    }

    /* Kraj korisnih metoda koje se koriste */
    abstract public void KonvertujGrafickiObjekatUDomenskiObjekat();

    abstract public void KonvertujDomenskiObjekatUGrafickiObjekat();
}