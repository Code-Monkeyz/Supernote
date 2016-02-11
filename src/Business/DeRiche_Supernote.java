/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Data_Access.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Triston_Gregoire
 */
public class DeRiche_Supernote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            UserDBConnect dc = new UserDBConnect();
            dc.selectDB(1);
            //dc.insertDB(1, "hello", "hello", "hello", "hello", 1);
            //dc.deleteDB(1);
        } catch (SQLException ex) {
            Logger.getLogger(DeRiche_Supernote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
