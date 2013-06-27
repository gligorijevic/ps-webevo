/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.login;

import broker.DBBroker;
import exception.UserAlreadyExistsException;
import exception.WrongUsernameOrPasswordException;
import java.util.List;
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
        loginUser=DBBroker.getInstance().loginUser(loginUser);
        if (loginUser != null) {
            DBBroker.getInstance().commitTransaction();
            DBBroker.getInstance().closeTransaction();
        } else {
            DBBroker.getInstance().rollbackTransaction();
            DBBroker.getInstance().closeTransaction();
            throw new WrongUsernameOrPasswordException("Wrong username or password");
        }

        return loginUser;
    }
}
