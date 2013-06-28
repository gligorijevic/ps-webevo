/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.login;

import broker.DBBroker;
import exception.WrongUsernameOrPasswordException;
import model.users.User;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Login {

    public static User login(String username, String password) throws WrongUsernameOrPasswordException {
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        DBBroker.getInstance().beginTransaction();
        loginUser = DBBroker.getInstance().loginUser(loginUser);
        if (loginUser != null) {
            DBBroker.getInstance().commitTransaction();
            System.out.println("Ulogovan korisnik " + loginUser.getUsername());
        } else {
            DBBroker.getInstance().rollbackTransaction();
            System.out.println("Korisnik ne postoji");
            throw new WrongUsernameOrPasswordException("Wrong username or password");
        }

        return loginUser;
    }
}
