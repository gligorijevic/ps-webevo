package view;

/*
 * OpstaEkranskaForma.java
 *
 * 02.05.2011
 *
 * @autor  Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */


import javax.swing.*;  // JFrame
import javax.swing.table.*; // TableModel
import model.GeneralDomainObject;



 public interface OpstaEkranskaForma 
{
  public abstract TableModel vratiModel();
  public abstract Object[] vratiPocetneVrednosti();
  public abstract int vratiSelektovaniRed();
  public abstract GeneralDomainObject kreirajObjekat();
}
