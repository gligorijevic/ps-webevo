/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author Djordje Gligorijevic
 */
public class WrongUsernameOrPasswordException extends Exception{

    public WrongUsernameOrPasswordException(String message) {
        super(message);
    }

}

