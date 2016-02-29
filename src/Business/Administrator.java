/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Triston_Gregoire
 */
public class Administrator implements User {
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int clearance;

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
    
    @Override
    public void login() {
        
    }

    @Override
    public void logout() {

    }
    
    public void updatePass(){
        
    }
    
    public void editNote(){
        
    }
    
    public void acceptNote(){
        
    }
    
    public void rejectNote(){
        
    }
    
    public void addComment(){
        
    }
    
    public void exportFile(){
        
    }
}
