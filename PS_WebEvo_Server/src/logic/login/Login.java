/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.login;

import broker.JPABroker;
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

        JPABroker.getInstance().beginTransaction();
        try {
            loginUser = JPABroker.getInstance().loginUser(loginUser);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new WrongUsernameOrPasswordException("Wrong username or password");
        }
        if (loginUser != null) {
            JPABroker.getInstance().commitTransaction();
            System.out.println("Ulogovan korisnik " + loginUser.getUsername());
        } else {
            JPABroker.getInstance().rollbackTransaction();
            System.out.println("Korisnik ne postoji");
            throw new WrongUsernameOrPasswordException("Wrong username or password");
        }

        return loginUser;
    }
}
