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
    private String oldUserName = null;
    private String password = null;
    private String oldPassowrd = null;
    private String firstName = null;
    private String lastName = null;
    private int clearance = -1;

    /**
     *
     */
    public UserDBConnect uc = new UserDBConnect();

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
     * @return the oldUserName
     */
    public String getOldUserName() {
        return oldUserName;
    }

    /**
     * @param oldUserName the oldUserName to set
     */
    public void setOldUserName(String oldUserName) {
        this.oldUserName = oldUserName;
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
     * @return the oldPassowrd
     */
    public String getOldPassowrd() {
        return oldPassowrd;
    }

    /**
     * @param oldPassowrd the oldPassowrd to set
     */
    public void setOldPassowrd(String oldPassowrd) {
        this.oldPassowrd = oldPassowrd;
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
     * @param username
     * @param password
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean isValid(String username, String password) throws SQLException, ClassNotFoundException{
        boolean result = false;
        UserLogic object1 = new UserLogic();
        UserLogic object2 = null;
        object1.setUsername(username);
        object1.setPassword(password);
        uc = new UserDBConnect();
        object2 = uc.login(object1);
        result = object1.getUsername().equalsIgnoreCase(object2.getUsername()) && object1.getPassword().equals(object2.getPassword());
        return result;
    }
    
    /**
     *
     * @param username
     * @throws ClassNotFoundException
     * @throws ArrayIndexOutOfBoundsException
     * @throws SQLException
     */
    public void select(Object username) throws ClassNotFoundException,ArrayIndexOutOfBoundsException, SQLException{
        this.setUsername((String) username);
        uc = new UserDBConnect();
        uc.userSelect(this);
        
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
            , String lastName, Object clearance) throws SQLException, ClassNotFoundException{
        uc = new UserDBConnect();
        int modifiedClearance = clearanceCheck((String) clearance);
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setClearance(modifiedClearance);
        uc.insertUser(this);
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void updateUser() throws SQLException, ClassNotFoundException{
        uc = new UserDBConnect();
        uc.update(this);
       // uc.update(username, password, firstName, lastName, newClearance, (String) oldUsername);
        
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
            case "DCP":
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


