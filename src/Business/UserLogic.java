/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data_Access.UserDBConnect;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Triston_Gregoire
 */
public class UserLogic {
    public boolean isValid(String userName, String password) throws SQLException, ClassNotFoundException{
        boolean result = false;
        UserDBConnect uc = new UserDBConnect();
        String databaseCredentials = uc.login(userName);
        String[] usernamePassword = databaseCredentials.split("-");
        if(userName.equalsIgnoreCase(usernamePassword[0]) && password.equals(usernamePassword[1])){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
    
    public String[] selectUser(String username) throws ClassNotFoundException,ArrayIndexOutOfBoundsException, SQLException{
        UserDBConnect uc = new UserDBConnect();
        String result = uc.UserSelect(username);
        String[] array = null;
        if(result != null){
            array = new String[5];
            array = result.split("-");
            System.out.println(Arrays.toString(array));
            array[5] = clearanceCheck(Integer.parseInt(array[5]));
            System.out.println(Arrays.toString(array));
        }
        
        return array;
    }
    
    public boolean insertUser(String username, String password, String firstName
            , String lastName, String clearance) throws SQLException, ClassNotFoundException{
        int modifiedClearance = clearanceCheck(clearance);
        UserDBConnect uc = new UserDBConnect();
        uc.insertUser(username, password, firstName, lastName, modifiedClearance);
        return false;
    }
    
    public void updateUser(String username, String password, String firstName, String lastName, Object clearance, Object oldUsername) throws SQLException, ClassNotFoundException{
        int newClearance = clearanceCheck((String) clearance);
        UserDBConnect uc = new UserDBConnect();
        uc.update(username, password, firstName, lastName, newClearance, (String) oldUsername);
        
    }
    
    
      /**
     * Method accepts the user clearance level pulled from GUI and converts it into an integer
     * Integer representation of clearance is used for storing in the database
     * 
     * @param clearance  String clearance variable pulled from the GUI. 
     * @return returns an Integer representation of Clearance to be stored in database
     */
    public int clearanceCheck(String clearance){
        int newClearance = -1;
        switch(clearance){
            case "Admin":
                newClearance = 0;
                break;
            case "Reviewer":
                newClearance = 1;
                break;
            case "Employee":
                newClearance = 2;
                break;
            case "Auditor":
                newClearance = 3;
        }
        return newClearance;
    }
    
    public String clearanceCheck(int clearance){
        String newClearance = null;
        switch(clearance){
            case 0:
                newClearance = "Admin";
                break;
            case 1:
                newClearance = "Reviewer";
                break;
            case 2:
                newClearance = "DCP";
                break;
            case 3:
                newClearance = "Auditor";
                break;
        }
        return newClearance;
    }
}


