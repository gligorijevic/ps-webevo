/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.register;

import broker.DBBroker;
import exception.UserAlreadyExistsException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GeneralDomainObject;
import model.users.User;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Register {

    /**
     *
     * @param gdo
     * @throws Exception
     */
    public static void register(GeneralDomainObject gdo) throws UserAlreadyExistsException {
        User regUser = (User) gdo;
        DBBroker.getInstance().beginTransaction();
        try {
            DBBroker.getInstance().registerNewUser(regUser);
            DBBroker.getInstance().commitTransaction();
        } catch (Exception ex) {
            DBBroker.getInstance().rollbackTransaction();
            throw new UserAlreadyExistsException("User with this username already exists.");
        }
    }
}
