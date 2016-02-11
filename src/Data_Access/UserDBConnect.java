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
 *
 * @author Triston_Gregoire
 */
public class UserDBConnect {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String database = "jdbc:mysql://localhost/DeRiche?user=root";
    
    public void selectDB(int userID) throws SQLException{
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
                    System.out.println(result.getString(i));
                }
            }
            connect.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
}
