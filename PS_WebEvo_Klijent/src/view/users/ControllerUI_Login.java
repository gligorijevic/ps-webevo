/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.users;

import controller.main.ControllerMain;
import java.io.IOException;
import util.TypeConverter;
import javax.swing.JOptionPane;
import model.GeneralDomainObject;
import model.users.User;
import view.FrmMain;
import view.OpstiKontrolerKI;
import view.OpstaEkranskaForma;

/**
 *
 * @author Djordje
 */
public class ControllerUI_Login extends OpstiKontrolerKI {

    public void setOdo(GeneralDomainObject odo) {
        this.gdo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    ControllerUI_Login() throws IOException {
        super();
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        User user = new User();
        FrmLogin fst = (FrmLogin) oef;
        user.setUsername(TypeConverter.Konvertuj(fst.getTfUserName(), signal));
        user.setPassword(String.valueOf(fst.getPfPassword().getPassword()));
        System.out.println("Login: " + user.getUsername() + " " + user.getPassword());
        this.gdo = user;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        if (gdo != null) {
            JOptionPane.showMessageDialog((FrmLogin) oef, "Welcome, " + ((User) gdo).getFirstName() + " " + ((User) gdo).getLastName() + "! :)");
            ControllerMain cmain = new ControllerMain();
            FrmMain frmMain = new FrmMain();
            frmMain.setControllerMain(cmain);
            cmain.setMainForm(frmMain);
            frmMain.setVisible(true);

            ((FrmLogin) oef).dispose();
        } else {
            JOptionPane.showMessageDialog((FrmLogin) oef, to.getServerMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ((FrmLogin) oef).getPfPassword().setText("");
        }
    }
}
