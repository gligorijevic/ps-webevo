/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.administer.users;

import controller.logic.ControllerAL;
import java.util.ArrayList;
import java.util.List;
import model.GeneralDomainObject;
import model.users.Client;
import model.users.Expert;
import model.users.Speciality;
import model.users.User;
import view.administer.users.FrmEditUser;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ControllerEditUser {
    
    FrmEditUser frmEditUser;
    User user;
    
    public ControllerEditUser(User user) {
        this.user = user;
    }
    
    public void setFrmEditUser(FrmEditUser frmEditUser) {
        this.frmEditUser = frmEditUser;
    }
    
    public FrmEditUser getFrmEditUser() {
        return frmEditUser;
    }
    
    public void setData() {
        frmEditUser.getTxtFFirstName().setText(user.getFirstName());
        frmEditUser.getTxtFLastName().setText(user.getLastName());
        frmEditUser.getTxtFUsername().setText(user.getUsername());
        frmEditUser.getTxtFPassword().setText(user.getPassword());
        frmEditUser.getTxtFEmail().setText(user.getEmail());
        if (user.getExpert() != null) {
            frmEditUser.getCbUsertype().setSelectedItem("Expert");
        } else {
            frmEditUser.getCbUsertype().setSelectedItem("Client");
        }
        if (user.getExpert() != null) {
            frmEditUser.getCbSpeciality().setSelectedItem(user.getExpert().getSpecialityId());
        } else {
            frmEditUser.getLblSpeciality().setVisible(false);
            frmEditUser.getCbSpeciality().setVisible(false);
        }
    }
    
    public void updatePlayer() {
        
        user.setFirstName(frmEditUser.getTxtFFirstName().getText().trim());
        user.setLastName(frmEditUser.getTxtFLastName().getText().trim());
        user.setUsername(frmEditUser.getTxtFUsername().getText().trim());
        user.setPassword(frmEditUser.getTxtFPassword().getText().trim());
        user.setEmail(frmEditUser.getTxtFEmail().getText().trim());
        if (String.valueOf(frmEditUser.getCbUsertype().getSelectedItem()).equals("Expert")) {
            Expert newExpert = new Expert();
            newExpert.setUser(user);
            Speciality spec = (Speciality) frmEditUser.getCbSpeciality().getSelectedItem();
            newExpert.setSpecialityId(spec);
            newExpert.setUserId(user.getUserId());
            user.setExpert(newExpert);
            user.setClient(null);
        } else {
            Client newClient = new Client();
            newClient.setUser(user);
            newClient.setUserId(user.getUserId());
            user.setClient(newClient);
            user.setExpert(null);
        }
        ControllerAL.getInstance().updateGDO(user);
    }
    
    public void fillCbData() {
        frmEditUser.fillCBData();
    }
    
    public List<Speciality> getListOdSpecialities() {
        List<Speciality> listOfSpecialities = new ArrayList<Speciality>();
        List<GeneralDomainObject> rezultat = ControllerAL.getInstance().returnAll(new Speciality());
        for (GeneralDomainObject generalDomainObject : rezultat) {
            listOfSpecialities.add((Speciality) generalDomainObject);
        }
        return listOfSpecialities;
    }
}
