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
    private String username = null;
    private String password = null;
    private String firstName = null;
    private String lastName = null;
    private int clearance = -1;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the clearance
     */
    public int getClearance() {
        return clearance;
    }

    /**
     * @param clearance the clearance to set
     */
    public void setClearance(int clearance) {
        this.clearance = clearance;
    }
    
    
    /**
     *
     * @param userName
     * @param password
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param username
     * @return
     * @throws ClassNotFoundException
     * @throws ArrayIndexOutOfBoundsException
     * @throws SQLException
     */
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
    
    /**
     *  
     * 
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param clearance 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void insertUser(String username, String password, String firstName
            , String lastName, String clearance) throws SQLException, ClassNotFoundException{
        int modifiedClearance = clearanceCheck(clearance);
        UserDBConnect uc = new UserDBConnect();
        uc.insertUser(username, password, firstName, lastName, modifiedClearance);
    }
    
    /**
     *
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param clearance
     * @param oldUsername
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
    
    /**
     *
     * @param clearance
     * @return String representation of the user's clearance level to be used in the GUI
     */
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


