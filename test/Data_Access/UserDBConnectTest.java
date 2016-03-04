/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access;

import java.util.ArrayList;
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
    
    public UserDBConnectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class UserDBConnect.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String userName = "tristong";
        String password = "lol";
        UserDBConnect instance = new UserDBConnect();
        boolean expResult = true;
        boolean result = instance.login(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectUser method, of class UserDBConnect.
     */
    @Test
    public void testSelectUser() throws Exception {
        System.out.println("selectUser");
        ArrayList<String> expResult = null;
        ArrayList<String> result = UserDBConnect.selectUser();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of selectDB method, of class UserDBConnect.
     */
    @Test
    public void testSelectDB() {
        System.out.println("selectDB");
        int userID = 0;
        UserDBConnect instance = new UserDBConnect();
        instance.selectDB(userID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertUser method, of class UserDBConnect.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        String userName = "";
        String pass = "";
        String firstName = "";
        String lastName = "";
        String clearance = "";
        UserDBConnect instance = new UserDBConnect();
        instance.insertUser(userName, pass, firstName, lastName, clearance);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteDB method, of class UserDBConnect.
     */
    @Test
    public void testDeleteDB() {
        System.out.println("deleteDB");
        int userID = 0;
        UserDBConnect instance = new UserDBConnect();
        instance.deleteDB(userID);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clearanceCheck method, of class UserDBConnect.
     */
    @Test
    public void testClearanceCheck() {
        System.out.println("clearanceCheck");
        String clearance = "Reviewer";
        UserDBConnect instance = new UserDBConnect();
        int expResult = 1;
        int result = instance.clearanceCheck(clearance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of populateUser method, of class UserDBConnect.
     */
    @Test
    public void testPopulateUser() throws Exception {
        System.out.println("populateUser");
        ArrayList<String> expResult = null;
        ArrayList<String> result = UserDBConnect.populateUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UserSelect method, of class UserDBConnect.
     */
    @Test
    public void testUserSelect() throws Exception {
        System.out.println("UserSelect");
        String name = "";
        UserDBConnect instance = new UserDBConnect();
        String expResult = "";
        String result = instance.UserSelect(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDBConnect.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        String userID = "";
        UserDBConnect instance = new UserDBConnect();
        instance.deleteUser(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserDBConnect.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        String newUsername = "";
        String password = "";
        String firstName = "";
        String lastName = "";
        int clearance = 0;
        String oldUsername = "";
        UserDBConnect instance = new UserDBConnect();
        instance.update(newUsername, password, firstName, lastName, clearance, oldUsername);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
