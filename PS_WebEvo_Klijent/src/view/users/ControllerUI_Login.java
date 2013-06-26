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
public class ControllerUI_Login extends OpstiKontrolerKI{

    public void setOdo(GeneralDomainObject odo) {
        this.odo = odo;
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
        FrmLogin fst=(FrmLogin) oef;
        user.setUsername(TypeConverter.Konvertuj(fst.getTfUserName(), signal));
        user.setPassword(String.valueOf(fst.getPfPassword().getPassword()));
        odo=user;
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
        if(odo!=null){
            JOptionPane.showMessageDialog((FrmLogin)oef,"Welcome, "+((User)odo).getFirstName()+" "+((User)odo).getLastName() +"! :)");
            ControllerMain cmain= new ControllerMain();
            FrmMain frmMain= new FrmMain();
            cmain.setMainForm(frmMain);
            frmMain.setVisible(true);
            
            ((FrmLogin)oef).dispose();
        }
        else{
            JOptionPane.showMessageDialog((FrmLogin)oef,"Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
           ((FrmLogin)oef).getPfPassword().setText("");
        }
    }
    

   
}
