/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.users;

import controller.main.ControllerMain;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.GeneralDomainObject;
import model.users.User;
import util.TypeConverter;
import view.OpstaEkranskaForma;
import view.OpstiKontrolerKI;
import view.users.FrmRegister;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAddNewUser  extends OpstiKontrolerKI{

    public void setOdo(GeneralDomainObject odo) {
        this.odo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    public ControllerAddNewUser() throws IOException {
       super();
   }
    
    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        if(odo==null){
            odo=oef.kreirajObjekat();
        }
        User admin = (User) odo;
        FrmRegister frmAdmin = (FrmRegister) oef;
        admin.setUsername(TypeConverter.Konvertuj(frmAdmin.getUsername(), admin.getUsername()));
        admin.setPassword(TypeConverter.Konvertuj(frmAdmin.getPassword(), admin.getPassword()));
        admin.setFirstName(TypeConverter.Konvertuj(frmAdmin.getFirstName(), admin.getFirstName()));
        admin.setLastName(TypeConverter.Konvertuj(frmAdmin.getLastName(), admin.getLastName()));
        admin.setEmail(TypeConverter.Konvertuj(frmAdmin.getEmail(), admin.getEmail()));
        odo=admin;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        if (signal==null){
            JOptionPane.showMessageDialog(frmRegister, "Successfull regisration!");
            frmRegister.dispose();
            
        }else{
            JOptionPane.showMessageDialog(frmRegister, "Try again, "+signal);
            //frmRegister.dispose();
        }
        User admin = (User) odo;
        FrmRegister frmadmin = (FrmRegister) oef;
        TypeConverter.Konvertuj(admin.getUsername(), frmadmin.getUsername());
        TypeConverter.Konvertuj(admin.getPassword(), frmadmin.getPassword());
        TypeConverter.Konvertuj(admin.getFirstName(), frmadmin.getFirstName());
        TypeConverter.Konvertuj(admin.getLastName(), frmadmin.getLastName());
        TypeConverter.Konvertuj(admin.getEmail(), frmadmin.getEmail());
    }
    
    FrmRegister frmRegister;

  
    public void setFrmAddNewUser(FrmRegister frmAddNewUser) {
        this.frmRegister = frmAddNewUser;
        oef=frmRegister;
    }

    public FrmRegister getFrmAddNewUser() {
        return frmRegister;
    }
    
}
