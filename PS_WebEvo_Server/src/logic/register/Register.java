/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.register;

import broker.DBBroker;
import model.GeneralDomainObject;
import model.users.User;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Register {
    
    public static void register(GeneralDomainObject gdo){
        User regUser = (User)gdo;
        DBBroker.getInstance().beginTransaction();
        DBBroker.getInstance().registerNewUser(regUser);
        DBBroker.getInstance().closeTransaction();
    }
    
}
