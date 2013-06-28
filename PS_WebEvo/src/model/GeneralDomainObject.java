/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Djordje Gligorijevic
 */
public interface GeneralDomainObject {

// POZIVA SE IZ BROKERA BAZE PODATAKA - pocetak

//// ***koristi se***//
//String vratiVrednostiAtributa();
//
//// ***koristi se***//
//String postaviVrednostiAtributa();
//
//// ***koristi se***//



/*************DJOLE************/
// ***koristi se***//

String vratiImeKlase();

Class vratiKlasu();

String vratiNazivTabele();

void prekopirajVrednostiAtributa(GeneralDomainObject gdo);

Object vratiID();

void postaviAtributPretrazivanja(String atribut);
String vratiAtributPretrazivanja();
// ***koristi se***//
public String vratiNazivNovogObjekta();

// ***koristi se***//
public String vratiNazivObjekta(); // koga, sta

//Object vratiVrednostAtributeaPretrazivanja();

/************* end DJOLE************/

// ***koristi se***//



//
//// ***koristi se***//
//String vratiUslovZaNadjiSlog();
//
//// ***koristi se***//
//String vratiUslovZaNadjiSlogove();
//
//
//// ***koristi se***//
//boolean Napuni(ResultSet RSslog);
//
//// ***koristi se***//
//int povecajBroj(ResultSet rs);
//
//// ***koristi se***//
//OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekta);
//
//// ***koristi se***//
//void Napuni(ResultSet RSslog, int brojSloga, int brojVezanogObjekta);
//
//// ***koristi se***//
//void kreirajVezaniObjekat(int brojStavkiVezanogObjekta,int brojVezanogObjekta);
//
//// ***koristi se***//
//int vratiBrojVezanihObjekata();
//
//// ***koristi se***//
//public void postaviPocetniBroj();
//
//// ***koristi se***//
//public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVezanogObjekta,int brojSloga);
//
//// ***koristi se***//
//public int vratiBrojSlogovaVezanogObjekta(int brojVezanogObjekta);
//// POZIVA SE IZ BROKERA BAZE PODATAKA - kraj
//
//
//// POZIVA SE IZ KLASA ZA SO - pocetak
//
//// ***koristi se***//
//public boolean vrednosnaOgranicenja();
//
//// ***koristi se***//
//public void Obradi();
//
//// ***koristi se***//
//public void Storniraj();
//
//
//// POZIVA SE IZ KLASA ZA SO - kraj

    
}
