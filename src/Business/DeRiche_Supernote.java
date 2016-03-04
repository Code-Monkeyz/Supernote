/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data_Access.*;
import Presentation.*;
import java.sql.SQLException;


/**
 *
 * @author Triston_Gregoire
 */
public class DeRiche_Supernote {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDBConnect dc = new UserDBConnect();
        //dc.insertUser("","","","","");
        //dc.select("User");
        LoginForm start = new LoginForm();
        start.setVisible(true);
        
        
    }
    
}
