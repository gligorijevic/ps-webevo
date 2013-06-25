/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.administer.users;

import view.administer.users.FrmAddNewUser;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerAddNewUser {
    FrmAddNewUser frmAddNewUser;

    public ControllerAddNewUser() {
    }

    public void setFrmAddNewUser(FrmAddNewUser frmAddNewUser) {
        this.frmAddNewUser = frmAddNewUser;
    }

    public FrmAddNewUser getFrmAddNewUser() {
        return frmAddNewUser;
    }
    
}
