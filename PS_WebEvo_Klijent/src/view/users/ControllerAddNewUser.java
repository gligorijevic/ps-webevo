/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.users;

import view.users.FrmRegister;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAddNewUser {
    FrmRegister frmRegister;

    public ControllerAddNewUser() {
    }

    public void setFrmAddNewUser(FrmRegister frmAddNewUser) {
        this.frmRegister = frmAddNewUser;
    }

    public FrmRegister getFrmAddNewUser() {
        return frmRegister;
    }
    
}
