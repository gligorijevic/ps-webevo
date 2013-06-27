/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.administer.users;

import controller.logic.ControllerAL;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.users.Client;
import model.users.Expert;
import model.users.User;

/**
 *
 * @author Djordje Gligorijevic
 */
public class TblModelPreviewUsers extends AbstractTableModel {
    
    private List<User> allUsers;
    
    public TblModelPreviewUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
    
    @Override
    public int getRowCount() {
        return allUsers.size();
    }
    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "UserId";
            case 1:
                return "Username";
            case 2:
                return "Password";
            case 3:
                return "First name";
            case 4:
                return "Last name";
            case 5:
                return "Email";
            case 6:
                return "Usertype";
        }
        return "";
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return allUsers.get(rowIndex).getUserId();
            case 1:
                return allUsers.get(rowIndex).getUsername();
            case 2:
                return allUsers.get(rowIndex).getPassword();
            case 3:
                return allUsers.get(rowIndex).getFirstName();
            case 4:
                return allUsers.get(rowIndex).getLastName();
            case 5:
                return allUsers.get(rowIndex).getEmail();
            case 6:
                if (allUsers.get(rowIndex).getExpert() != null) {
                    return "Expert";
                } else {
                    return "Client";
                }
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                allUsers.get(rowIndex).setUserId(Integer.parseInt(String.valueOf(aValue)));
                break;
            case 1:
                allUsers.get(rowIndex).setUsername(String.valueOf(aValue));
                break;
            case 2:
                allUsers.get(rowIndex).setPassword(String.valueOf(aValue));
                break;
            case 3:
                allUsers.get(rowIndex).setFirstName(String.valueOf(aValue));
                break;
            case 4:
                allUsers.get(rowIndex).setLastName(String.valueOf(aValue));
                break;
            case 5:
                allUsers.get(rowIndex).setEmail(String.valueOf(aValue));
                break;
            case 6:
                if (String.valueOf(aValue).equals("Expert")) {
                    Expert newExpert = new Expert();
                    newExpert.setUser(allUsers.get(rowIndex));
                    allUsers.get(rowIndex).setExpert(newExpert);
                    allUsers.get(rowIndex).setClient(null);
                } else {
                    Client newClient = new Client();
                    newClient.setUser(allUsers.get(rowIndex));
                    allUsers.get(rowIndex).setClient(newClient);
                    allUsers.get(rowIndex).setExpert(null);
                }
                break;
        }
        ControllerAL.getInstance().updateGDO(allUsers.get(rowIndex));
        fireTableDataChanged();
    }
}
