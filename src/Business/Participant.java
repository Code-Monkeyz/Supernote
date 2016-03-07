/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Kristen
 */
public class Participant {
    private int participantID;
    /* Changed to Boolean value instead of previously diagrammed String value.  
    No need to store more detail than Self-Pay (FALSE) or Medicaid (TRUE) as the 
    participantID is intended to be the Medicaid number and other insurance is
    irrelevant. */
    private Boolean insurance;
    private String firstName;
    private String lastName;
    private String dcp;
    /* I couldn't decide how to name the goal and objective description variables,
    every combination I tried looked weird.  Feel free to edit this out and change 
    variable names as needed for improved readability. */
    private String g1;
    private String o1;
    private String g2;
    private String o2;
    private String g3;
    private String o3;
    private String g4;
    private String o4;
    private String g5;
    private String o5;

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
     * @return the insurance
     */
    public Boolean getInsurance() {
        return insurance;
    }

    /**
     * @param insurance the insurance to set
     */
    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
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
     * @return the dcp
     */
    public String getDcp() {
        return dcp;
    }

    /**
     * @param dcp the dcp to set
     */
    public void setDcp(String dcp) {
        this.dcp = dcp;
    }

    /**
     * @return the g1
     */
    public String getG1() {
        return g1;
    }

    /**
     * @param g1 the g1 to set
     */
    public void setG1(String g1) {
        this.g1 = g1;
    }

    /**
     * @return the o1
     */
    public String getO1() {
        return o1;
    }

    /**
     * @param o1 the o1 to set
     */
    public void setO1(String o1) {
        this.o1 = o1;
    }

    /**
     * @return the g2
     */
    public String getG2() {
        return g2;
    }

    /**
     * @param g2 the g2 to set
     */
    public void setG2(String g2) {
        this.g2 = g2;
    }

    /**
     * @return the o2
     */
    public String getO2() {
        return o2;
    }

    /**
     * @param o2 the o2 to set
     */
    public void setO2(String o2) {
        this.o2 = o2;
    }

    /**
     * @return the g3
     */
    public String getG3() {
        return g3;
    }

    /**
     * @param g3 the g3 to set
     */
    public void setG3(String g3) {
        this.g3 = g3;
    }

    /**
     * @return the o3
     */
    public String getO3() {
        return o3;
    }

    /**
     * @param o3 the o3 to set
     */
    public void setO3(String o3) {
        this.o3 = o3;
    }

    /**
     * @return the g4
     */
    public String getG4() {
        return g4;
    }

    /**
     * @param g4 the g4 to set
     */
    public void setG4(String g4) {
        this.g4 = g4;
    }

    /**
     * @return the o4
     */
    public String getO4() {
        return o4;
    }

    /**
     * @param o4 the o4 to set
     */
    public void setO4(String o4) {
        this.o4 = o4;
    }

    /**
     * @return the g5
     */
    public String getG5() {
        return g5;
    }

    /**
     * @param g5 the g5 to set
     */
    public void setG5(String g5) {
        this.g5 = g5;
    }

    /**
     * @return the o5
     */
    public String getO5() {
        return o5;
    }

    /**
     * @param o5 the o5 to set
     */
    public void setO5(String o5) {
        this.o5 = o5;
    }
}
