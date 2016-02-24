/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles all database connection methods for the User use cases
 * Assumes the database in question is titles 'DeRiche'
 * 
 * @author Triston_Gregoire
 * @version 0.0.1
 */
public class UserDBConnect {

    /**
     *
     */
    public final String driver = "com.mysql.jdbc.Driver";

    /**
     *
     */
    public final String database = "jdbc:mysql://localhost/DeRiche?user=root";
    
    /**
     * Takes login input from user and authenticates it against the DeRiche database.
     * Returns true if login information is correct. Otherwise method returns false.
     * 
     * @param userName The username entered by the user to be authenticated
     * @param password The password entered by the user to be authenticated
     * @return         <code>boolean</code> value indicating whether or not input could be authenticated
     * 
     */
    /*
    Reminder: Code can be simplified by using an sql statement that searches for
    row that matches both inputted username AND password.
    For example Select UserName, Password from User where UserName = ? and Password =?
    */
    public boolean login(String userName, String password){
        boolean isLoggedIn = false;
        try {
            String sql = "Select UserName, Password from User where UserName = ?";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setString(1, userName);
            ResultSet result = prepared.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            
            //loop ends when end of result set is reached or matching database entry is found
            while(result.next()){                       
                String userCheck = result.getString(1);
                String passCheck = result.getString(2);
                
                /* 
                   loops as long as 'i' is less than or equal to the number of 
                   rows pulled from the database, or until matching row is found.
                */
                for(int i = 1; i <= meta.getColumnCount(); i++){
                    if(userName.equalsIgnoreCase(userCheck) && password.equals(passCheck)){
                        System.out.println("Login successful");
                        isLoggedIn = true;
                        break;
                    }
                }
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isLoggedIn;
    }
    
    /**
     * Accepts a users ID and pulls all of the user's information from the database
     * 
     * @param userID Identification value for the user
     */
    public void selectDB(int userID){
        try {
            String sql = "Select * from User where UserID = ?";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setInt(1, userID);
            ResultSet result = prepared.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            int columnNumber = meta.getColumnCount();
            while(result.next()){
                for(int i = 1; i <= columnNumber; i++){
                    //System.out.println(result.getString(i));
                }
            }
            connect.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Inputs passed arguments into an existing database table inside the DeRiche database.
     * Purpose of method is to create new users for the program
     * 
     * @param userID        Identification number of new user
     * @param userName      User's username for login 
     * @param pass          User's password for login
     * @param firstName     User's legal first name
     * @param lastName      User's legal last name
     * @param clearance     User's authorization level
     */
    //Reminder: Have the method check for pre existing rows that already have the 
    //matching combination of username and password to avoid duplicate entries
    public void insertDB(int userID, String userName, String pass, String firstName,
            String lastName, int clearance){
        try {
            String sql = "Insert into User values (?,?,?,?,?,?)";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setInt(1,userID);
            prepared.setString(2, userName);
            prepared.setString(3, pass);
            prepared.setString(4, firstName);
            prepared.setString(5, lastName);
            prepared.setInt(6, clearance);
            prepared.execute();
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Deletes users from the database with the ID number matching the number inputted to the function.
     * 
     * @param userID Identification number for the user to be deleted
     */
    public void deleteDB(int userID){
        try{
            String sql = "Delete from User where UserID = ?";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setInt(1, userID);
            prepared.execute();
            connect.close();
        }
        catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // I am trying to do an updateDB don't know if it will work
    //by bonnie this is not working correct for the UserDBConnectTest
    
    public void updateDB(int userID, String userName, String pass, String firstName,
            String lastName, int clearance){
        try {
            //String sql = "update into User values (?,?,?,?,?,?) where UserID=?";
            String sql = "update User set UserName=?,Password=?,FirstName=?,LastName=?,Clearance=? where UserID =?";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setString(1, userName);
            prepared.setString(2, pass);
            prepared.setString(3, firstName);
            prepared.setString(4, lastName);
            prepared.setInt(5, clearance);
            prepared.setInt(6, userID);
            prepared.execute();
            connect.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
