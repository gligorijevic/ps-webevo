/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import controller.main.ControllerMain;
import view.FrmMain;

/**
 *
 * @author Djordje Gligorijevic
 */
public class Run {
 
    public static void main(String[] args) {
        FrmMain frmMain = new FrmMain();
        ControllerMain controllerMain = new ControllerMain();
        frmMain.setControllerMain(controllerMain);
        controllerMain.setMainForm(frmMain);
        frmMain.setVisible(true);
        
    }
    
}
