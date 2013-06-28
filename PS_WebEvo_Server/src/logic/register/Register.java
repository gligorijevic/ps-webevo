/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.register;

import broker.JPABroker;
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
        JPABroker.getInstance().beginTransaction();
        try {
            JPABroker.getInstance().registerNewUser(regUser);
            JPABroker.getInstance().commitTransaction();
        } catch (Exception ex) {
            JPABroker.getInstance().rollbackTransaction();
            throw new UserAlreadyExistsException("User with this username already exists.");
        }
    }
}
