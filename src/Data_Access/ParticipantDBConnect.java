/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import Business.ParticipantLogic;
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
public class ParticipantDBConnect {
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
     * @param pl
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void insertParticipant(ParticipantLogic pl) throws ClassNotFoundException, SQLException{
        String sql = "Insert into Participant ( FirstName, LastName, Insurance, MedicaidNumber) values (?,?,?,?)";
        Class.forName(driver);
        try (Connection connect = DriverManager.getConnection(database)) {
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setString(1, pl.getParticipantFirstName());
            prepared.setString(2, pl.getParticipantLastName());
            prepared.setString(3, pl.getInsurance());
            prepared.setString(4,pl.getMedicaidNumber());
            prepared.execute();
        }
    }

    /**
     * Selects All user information from the database then inserts all fields into a ParticipantLogic object. 
     * Iterates over the entire result set and creates a new object for each row returned from the database
     * 
     * @return ArrayList containing ParticipantLogic objects
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<ParticipantLogic>selectAllParticipants() throws SQLException, ClassNotFoundException{
        String sql = "Select * from Participant";
        Class.forName(driver);
        try(Connection connect = DriverManager.getConnection(database)){
            PreparedStatement prepared = connect.prepareStatement(sql);
            ResultSet rs = prepared.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            ArrayList<ParticipantLogic> participantList = new ArrayList<>();
            while(rs.next()){
                ParticipantLogic participant = new ParticipantLogic();
                participant.setParticipantID(rs.getInt(1));
                participant.setParticipantFirstName(rs.getString(2));
                participant.setParticipantLastName(rs.getString(3));
                participant.setInsurance(rs.getString(3));
                participant.setMedicaidNumber(rs.getString(4));
                participantList.add(participant);
            }
            return participantList;
        }
    }
    public void updateParticipant(ParticipantLogic object) throws SQLException, ClassNotFoundException{
        String sql = "update participant set Firstname = ?, Lastname = ?, Insurance = ?, MedicaidNumber = ? where ParticipantID = ?";
        Class.forName(driver);
        try(Connection connect = DriverManager.getConnection(database)){
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setString(1, object.getParticipantFirstName());
            prepared.setString(2, object.getParticipantLastName());
            prepared.setString(3, object.getInsurance());
            prepared.setString(4, object.getMedicaidNumber());
            prepared.setInt(5,object.getParticipantID());
            prepared.execute();
        }
            
    }
    public ParticipantLogic selectParticipant(ParticipantLogic object) throws SQLException, ClassNotFoundException{
        ParticipantLogic pl = object;
        //System.out.println(pl.getParticipantID());
        String sql = "select * from Participant where ParticipantID = ?";
        Class.forName(driver);
        try(Connection connect = DriverManager.getConnection(database)){
            PreparedStatement prepared = connect.prepareStatement(sql);
            prepared.setInt(1, pl.getParticipantID());
            ResultSet result = prepared.executeQuery();
            result.next();
            pl.setParticipantFirstName(result.getString(2));
            pl.setParticipantLastName(result.getString(3));
            pl.setInsurance(result.getString(4));
            pl.setMedicaidNumber(result.getString(5));
        }
        return pl;
    }
}
