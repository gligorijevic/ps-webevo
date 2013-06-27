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
    
//    public void fillCbData(){
//        frmAddNewUser.fillCBData();
//    }

    public void insertNewUser() {
        String username = frmAddNewUser.getTxtFUsername().getText().trim();
        String password = frmAddNewUser.getTxtFPassword().getText().trim();
        String firstName = frmAddNewUser.getTxtFFirstName().getText().trim();
        String lastName = frmAddNewUser.getTxtFLastName().getText().trim();
        String email = frmAddNewUser.getTxtFEmail().getText().trim();
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);
//        if (String.valueOf(frmAddNewUser.getCbUsertype().getSelectedItem()).equals("Expert")) {
//            Expert newExpert = new Expert();
//            newExpert.setUser(newUser);
//            Speciality spec = (Speciality) frmAddNewUser.getCbSpeciality().getSelectedItem();
//            newExpert.setSpecialityId(spec);
//            newUser.setExpert(newExpert);
//            newUser.setClient(null);
//        } else {
//            Client newClient = new Client();
//            newClient.setUser(newUser);
//            newUser.setClient(newClient);
//            newUser.setExpert(null);
//        }
        ControllerAL.getInstance().insertNewGDO(newUser);
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
