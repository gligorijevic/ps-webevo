package controller.logic;

/*
 * KontrolerAL.java
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
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
//import logic.SO.*;
import model.GeneralDomainObject;
import model.users.User;

public class KontrolerAL // Kontroler aplikacione logike
{

    static ServerSocket ss;
    static Klijent kl[];

    public static void main(String[] args) throws Exception {
        kl = new Klijent[10];
        ss = new ServerSocket(8189);

        System.out.println("Podignut je serverski program:");
        for (int brojKlijenta = 0; brojKlijenta < 10; brojKlijenta++) {
            Socket soketS = ss.accept();
            System.out.println("Klijent " + (brojKlijenta + 1));
            kl[brojKlijenta] = new Klijent(soketS, brojKlijenta + 1);
        }
    }
}

class Klijent extends Thread {

    public Klijent(Socket soketS1, int brojKlijenta1) {
        soketS = soketS1;
        brojKlijenta = brojKlijenta1;
        System.out.println("Konstruktor");
        start();
    }

    @Override
    public void run() {
        try {
            String signal = "";
            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            System.out.println("run");
            while (true) { // Citanje naziva operacije i racuna
                String NazivSO = (String) in.readObject();
                GeneralDomainObject gdo = (GeneralDomainObject) in.readObject();


                if (NazivSO.equals("Login") == true) {
                    User user = (User) gdo;
                    User login = ControllerAL.getInstance().login(user.getUsername(), user.getPassword());
                    gdo = login;
                } //                else if (NazivSO.equals("VratiSve") == true) {
                //                    List<OpstiDomenskiObjekat> odoList = new ArrayList<OpstiDomenskiObjekat>();
                //                    odoList.add(gdo);
                //                    odoList = VratiSve.VratiSve(odoList, signal);
                //                    List<OpstiDomenskiObjekat> odoListDS = new ArrayList<OpstiDomenskiObjekat>();
                //                    if (gdo instanceof Dataset) {
                //
                //                        for (int i = 0; i < odoList.size(); i++) {
                //                            OpstiDomenskiObjekat opstiDomenskiObjekat = odoList.get(i);
                //                            DataSetTO dto = new DataSetTO((Dataset) opstiDomenskiObjekat);
                //                            odoListDS.add(dto);
                //
                //                        }
                //                        out.writeObject(odoListDS);
                //                    } else {
                //                        out.writeObject(odoList);
                //                    }
                //                    out.writeObject(signal);
                //                }  
                else {
//                    if (NazivSO.equals("kreirajNovi") == true) {
//                        signal = KreirajNovi.kreirajNovi(gdo);
//                    }
//
//                    if (NazivSO.equals("Pretrazi") == true) {
//                        signal = Pretrazi.Pretrazi(gdo);
//                    }
//
//                    if (NazivSO.equals("Zapamti") == true) {
//                        signal = Zapamti.Zapamti(gdo);
//                    }
//
//                    if (NazivSO.equals("Obradi") == true) {
//                        signal = Obradi.Obradi(gdo);
//                    }
//
//                    if (NazivSO.equals("Storniraj") == true) {
//                        signal = Storniraj.Storniraj(gdo);
//                    }
                }
                // Slanje promenjenog racuna i signala o uspesnosti operacije
                out.writeObject(gdo);
                out.writeObject(signal);

            }

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    private Socket soketS;
    int brojKlijenta;
    ObjectOutputStream out;
    ObjectInputStream in;
}
