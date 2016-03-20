/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data_Access.ParticipantDBConnect;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Triston_Gregoire
 */
public class ParticipantLogic {
    private int participantID = -1;
    private String participantFirstName;
    private String participantLastName;
    private String insurance;
    private String medicaidNumber;

    /**
     *
     */
    public ParticipantDBConnect pdb = new ParticipantDBConnect();

    /**
     * @return the participantID
     */
    public int getParticipantID() {
        return participantID;
    }

    /**
     * @param participantID the participantID to set
     */
    public void setParticipantID(int participantID) {
        this.participantID = participantID;
    }

    /**
     * @return the participantFirstName
     */
    public String getParticipantFirstName() {
        return participantFirstName;
    }

    /**
     * @param participantFirstName the participantFirstName to set
     */
    public void setParticipantFirstName(String participantFirstName) {
        this.participantFirstName = participantFirstName;
    }

    /**
     * @return the participantLastName
     */
    public String getParticipantLastName() {
        return participantLastName;
    }

    /**
     * @param participantLastName the participantLastName to set
     */
    public void setParticipantLastName(String participantLastName) {
        this.participantLastName = participantLastName;
    }

    /**
     * @return the insurance
     */
    public String getInsurance() {
        return insurance;
    }

    /**
     * @param insurance the insurance to set
     */
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    /**
     * @return the medicaidNumber
     */
    public String getMedicaidNumber() {
        return medicaidNumber;
    }

    /**
     * @param medicaidNumber the medicaidNumber to set
     */
    public void setMedicaidNumber(String medicaidNumber) {
        this.medicaidNumber = medicaidNumber;
    }
    
    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void addParticipant() throws ClassNotFoundException, SQLException{
        pdb.insertParticipant(this);
        
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ArrayList<ParticipantLogic> populate() throws SQLException, ClassNotFoundException{
        ArrayList<ParticipantLogic> participants = ParticipantDBConnect.selectAllParticipants();
        return participants;
    }
    public ParticipantLogic select(int num) throws SQLException, ClassNotFoundException{
        ParticipantLogic pl = new ParticipantLogic();
        pl.setParticipantID(num);
        return pdb.selectParticipant(pl);
    }
    public void updateParticipant(String medicaid, String firstname, String lastname, String insurance, int ID) throws SQLException, ClassNotFoundException{
        ParticipantLogic object = new ParticipantLogic();
        object = object.select(ID);
        object.setInsurance(insurance);
        object.setMedicaidNumber(medicaid);
        object.setParticipantFirstName(firstname);
        object.setParticipantLastName(lastname);
        object.setParticipantID(participantID);
        pdb.updateParticipant(object);
    }
}
