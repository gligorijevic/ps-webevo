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
import util.RequestOntology;
import util.TransferObject;
import util.TypeConverter;
import view.OpstaEkranskaForma;
import view.OpstiKontrolerKI;
import view.users.FrmRegister;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerRegisterNewUser extends OpstiKontrolerKI {

    public void setOdo(GeneralDomainObject odo) {
        this.gdo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    public ControllerRegisterNewUser() throws IOException {
        super();
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        if (gdo == null) {
            gdo = oef.kreirajObjekat();
        }
        User user = (User) gdo;
        FrmRegister frmAdmin = (FrmRegister) oef;
        user.setUsername(TypeConverter.Konvertuj(frmAdmin.getUsername(), user.getUsername()));
        user.setPassword(TypeConverter.Konvertuj(frmAdmin.getPassword(), user.getPassword()));
        user.setFirstName(TypeConverter.Konvertuj(frmAdmin.getFirstName(), user.getFirstName()));
        user.setLastName(TypeConverter.Konvertuj(frmAdmin.getLastName(), user.getLastName()));
        user.setEmail(TypeConverter.Konvertuj(frmAdmin.getEmail(), user.getEmail()));
        gdo = user;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        gdo = (GeneralDomainObject) to.getServerObject();
        String serverMessage = to.getServerMessage();
        if (gdo != null) {
            JOptionPane.showMessageDialog(frmRegister, serverMessage);
            frmRegister.dispose();

        } else {
            JOptionPane.showMessageDialog(frmRegister, "Try again, " + serverMessage);
            //frmRegister.dispose();
        }
        User user = (User) gdo;
        FrmRegister frmadmin = (FrmRegister) oef;
        TypeConverter.Konvertuj(user.getUsername(), frmadmin.getUsername());
        TypeConverter.Konvertuj(user.getPassword(), frmadmin.getPassword());
        TypeConverter.Konvertuj(user.getFirstName(), frmadmin.getFirstName());
        TypeConverter.Konvertuj(user.getLastName(), frmadmin.getLastName());
        TypeConverter.Konvertuj(user.getEmail(), frmadmin.getEmail());
    }
    FrmRegister frmRegister;

    public void setFrmAddNewUser(FrmRegister frmAddNewUser) {
        this.frmRegister = frmAddNewUser;
        oef = frmRegister;
    }

    public FrmRegister getFrmAddNewUser() {
        return frmRegister;
    }

    User register() {
        to = new TransferObject();
        gdo = oef.kreirajObjekat();

        KonvertujGrafickiObjekatUDomenskiObjekat();
        to.setClientObject(gdo);
        to.setClientRequestOperation(RequestOntology.REGISTER);
//        signal = pozivSO("Login");
        callSystemOperation();
        KonvertujDomenskiObjekatUGrafickiObjekat();
        return (User) gdo;
    }
}
