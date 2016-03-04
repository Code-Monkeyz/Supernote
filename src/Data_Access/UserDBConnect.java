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
import java.util.ArrayList;

/**
 *
 * @author Triston_Gregoire
 */
public class UserDBConnect {

    /**
     *
     */
    public static final String driver = "com.mysql.jdbc.Driver";

    /**
     *
     */
    public static final String database = "jdbc:mysql://localhost/DeRiche?user=root";
    
    /**
     *
     * @param userName
     * @return
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public String login(String userName) throws SQLException, ClassNotFoundException{
        boolean isLoggedIn = false;
            //select
            
            String sql = "Select UserName, Password from User where UserName = ?";
            Class.forName(driver);
            Connection connect = DriverManager.getConnection(database);
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setString(1, userName);
            ResultSet result = prepared.executeQuery();
            ResultSetMetaData meta = result.getMetaData();
            result.next();
            String credentials = result.getString(1) + "-" + result.getString(2);
            
        return credentials;
    }

    /**
     * Pulls all users from the User table of the database and populates an ArrayList with all users
     * Method should be used to return ArrayLists for the purpose of filling GUI elements with user information
     * 
     * @return Returns Array list containing list of all users' first and last name
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<String> populateUser() throws SQLException, ClassNotFoundException{
        ArrayList userList = new ArrayList();
        String sql = "Select UserName from User";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        ResultSet result = prepared.executeQuery();
        int i = 0;
        
        //Runs until the end of the result set is reached
        //Places the first and last name of each user into userList
        while(result.next()){
            String user;
            user = result.getString(1);
            userList.add(i, user);
            i++;
        }
        return userList;
    }
    
    /**
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String UserSelect(String name) throws ClassNotFoundException, SQLException{
        String sql = "Select * from User where UserName = ?";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        prepared.setString(1, name);
        ResultSet result = prepared.executeQuery();
        String rs = "";
        
        if(!result.isBeforeFirst()){
            rs = null;
        }
        else{
            result.next();
            rs = Integer.toString(result.getInt(1)) + "-" + result.getString(2)
            + "-" + result.getString(3) + "-" + result.getString(4) + "-" + 
            result.getString(5) + "-" + Integer.toString(result.getInt(6));
        }
        
        return rs;
    }
    
    /**
     *
     * @param userID
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void deleteUser(String userID) throws ClassNotFoundException, SQLException{
        String sql = "Delete from user where UserName = ?";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        prepared.setString(1,userID);
        prepared.execute();
        connect.close();
        
    }
    

    
    /**
     * Inserts information into the User table of the database
     * 
     * @param userName Username for the user being entered into the system
     * @param pass Password for the username being entered into the system
     * @param firstName First Name for the user being entered into the system
     * @param lastName Last Name for the user being entered into the system
     * @param clearance clearance level for users in system. 0 being the highest level access and 4 being the lowest
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void insertUser(String userName, String pass, String firstName,
            String lastName, int clearance) throws SQLException, ClassNotFoundException{
        //ArrayList <String> list = populateUser();
        String sql = "Insert into User (UserName, PASSWORD, FirstName, LastName, Clearance)"
                + "values (?,?,?,?,?)";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        prepared.setString(1, userName);
        prepared.setString(2, pass);
        prepared.setString(3, firstName);
        prepared.setString(4, lastName);
        prepared.setInt(5, clearance);
        prepared.execute();
        connect.close();
    }  

    /**
     *
     * 
     * 
     * @param newUsername
     * @param password
     * @param firstName
     * @param lastName
     * @param clearance
     * @param oldUsername
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void update(String newUsername, String password, String firstName, String lastName, int clearance, String oldUsername) throws SQLException, ClassNotFoundException{
        String sql = "update user set UserName = ?, Password = ?, FirstName = ?,"
                + " LastName = ?, Clearance = ? where UserName = ?";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        prepared.setString(1, newUsername);
        prepared.setString(2, password);
        prepared.setString(3, firstName);
        prepared.setString(4, lastName);
        prepared.setInt(5, clearance);
        prepared.setString(6, oldUsername);
        prepared.execute();
        connect.close();
    }
}
