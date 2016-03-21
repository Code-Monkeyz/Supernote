/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;
import Data_Access.UserDBConnect;
import Business.NoteLogic;

/**
 *
 * @author Triston_Gregoire
 */
public class NoteDBConnect {
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String database = "jdbc:mysql://localhost/DeRiche?user=root";
        
    public void insertNote(NoteLogic object){
        String sql = "insert into Note (Text, Time_Submitted, Time_Accepted, ParticipantID, UserID) values (?,?,?,?,?)";
        
    }


}
