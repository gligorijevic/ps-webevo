/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.administer.users;

import controller.logic.ControllerAL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.GeneralDomainObject;
import model.corpus.Corpus;
import model.users.User;
import view.administer.users.FrmEditUser;
import view.administer.users.PnlPreviewUsers;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerPreviewUsers {

    private PnlPreviewUsers pnlPreviewUsers;

    public ControllerPreviewUsers() {
    }

    public PnlPreviewUsers getPnlPreviewUsers() {
        return pnlPreviewUsers;
    }

    public void setPnlPreviewUsers(PnlPreviewUsers pnlPreviewUsers) {
        this.pnlPreviewUsers = pnlPreviewUsers;
    }

    public List<User> getAllUsers() {
        List<User> listOfUsers = new ArrayList<User>();
        List<GeneralDomainObject> rezultat = ControllerAL.getInstance().returnAll(new User());
        for (GeneralDomainObject generalDomainObject : rezultat) {
            listOfUsers.add((User) generalDomainObject);
        }
        return listOfUsers;
    }

    public void setData() {
        pnlPreviewUsers.setData();
    }

    public void deleteSelectedUser() {
        int selectedUser = pnlPreviewUsers.getTblUsers().getSelectedRow();
        User usr = getAllUsers().get(selectedUser);
        int response = JOptionPane.showConfirmDialog(pnlPreviewUsers, "Are you sure you want to delete this user?");
        if (response == 1) {
            ControllerAL.getInstance().deleteGDO(usr);
            JOptionPane.showMessageDialog(pnlPreviewUsers, "Selected user has been deleted");
            ((AbstractTableModel) pnlPreviewUsers.getTblUsers().getModel()).fireTableDataChanged();
        }
    }

    public void updateSelectedUser() {
        int selectedUser = pnlPreviewUsers.getTblUsers().getSelectedRow();
        User usr = getAllUsers().get(selectedUser);
        ControllerEditUser controllerEditUser = new ControllerEditUser(usr);
        FrmEditUser frmEditUser = new FrmEditUser(null, true);
        controllerEditUser.setFrmEditUser(frmEditUser);
        frmEditUser.setControllerEditUser(controllerEditUser);
        controllerEditUser.fillCbData();
        controllerEditUser.setData();
        frmEditUser.setVisible(true);
    }
}
