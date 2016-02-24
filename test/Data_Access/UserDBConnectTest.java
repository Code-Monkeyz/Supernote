/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Triston_Gregoire
 */
public class UserDBConnectTest {
    
    /**
     *
     */
    public UserDBConnectTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Tests login method, of class UserDBConnect.
     */
    @Test
    public void testLogin() {
        System.out.println("login()");
        String userName = "tristong";
        String password = "lol";
        UserDBConnect instance = new UserDBConnect();
        boolean expResult = true;
        boolean result = instance.login(userName, password);
        System.out.println("Expected Result: " + expResult);
        System.out.println("Actual Result: " + result + "\n");
        assertTrue(result);
    }

    /**
     * Tests selectDB method, of class UserDBConnect.
     */
    @Test
    public void testSelectDB() {
        System.out.println("selectDB()");
        int userID = 1;
        UserDBConnect instance = new UserDBConnect();
        instance.selectDB(userID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertDB method, of class UserDBConnect.
     */
    @Test
    public void testInsertDB() {
        System.out.println("insertDB()");
        int userID = 3;
        String userName = "d";
        String pass = "d";
        String firstName = "d";
        String lastName = "d";
        int clearance = 0;
        UserDBConnect instance = new UserDBConnect();
        instance.insertDB(userID, userName, pass, firstName, lastName, clearance);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDB method, of class UserDBConnect.
     */
    @Test
    public void testDeleteDB() {
        System.out.println("deleteDB()");
        int userID = 3;
        UserDBConnect instance = new UserDBConnect();
        instance.deleteDB(userID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
