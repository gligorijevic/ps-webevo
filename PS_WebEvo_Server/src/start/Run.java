/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import controller.logic.KontrolerAL;
import controller.main.ControllerMain;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.FrmMain;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Run {
 
    public static void main(String[] args) {
        try {
            
            FrmMain frmMain = new FrmMain();
            ControllerMain controllerMain = new ControllerMain();
            frmMain.setControllerMain(controllerMain);
            controllerMain.setMainForm(frmMain);
            frmMain.setVisible(true);
             System.out.println("pre logike");
            KontrolerAL.main(args);
             System.out.println("pokrent je kontroele");
        } catch (Exception ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
