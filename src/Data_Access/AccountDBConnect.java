/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import Business.Account;
//import static Presentation.AdminForm.activeUser;
import static Data_Access.UserDBConnect.database;
import static Data_Access.UserDBConnect.driver;
import Presentation.AdminForm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Triston_Gregoire
 */
public class AccountDBConnect {    

    /**
     *
     * @param object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void updatePassword(Account object) throws ClassNotFoundException, SQLException{
        String sql = "update user set Password = ? where UserName = ?";
        Class.forName(driver);
        Connection connect = DriverManager.getConnection(database);
        PreparedStatement prepared = connect.prepareStatement(sql);
        prepared.setString(1, object.getNewPassword());
        prepared.setString(2, AdminForm.activeUser);
        prepared.execute();
        connect.close();
        
        
    }
}
