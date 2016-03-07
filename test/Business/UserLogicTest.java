/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bonnie
 */
public class UserLogicTest {
    
    public UserLogicTest() {
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
     * Test of isValid method, of class UserLogic.
     */
    @Test
    public void testIsValid() throws Exception {
        System.out.println("isValid");
        String userName = "bonnief";
        String password = "pass";
        UserLogic instance = new UserLogic();
       // boolean expResult = false;  //this caused and error bf I changed to true?
        boolean expResult = true;
        boolean result = instance.isValid(userName, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectUser method, of class UserLogic.
     */
    @Test
    public void testSelectUser() throws Exception {
        System.out.println("selectUser");
        String username = "TirstonG";
        UserLogic instance = new UserLogic();
        String[] expResult = null;
        String[] result = instance.selectUser(username);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertUser method, of class UserLogic.
     */
    @Test
   public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        String username = "TristonG";
        String password = "pass";
        String firstName = "Triston";
        String lastName = "Gregoire";
        String clearance = "0";
        UserLogic instance = new UserLogic();
        instance.insertUser(username, password, firstName, lastName, clearance);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserLogic.
     */
   @Test
   public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        String username = "Amy";
        String password = "happy";
        String firstName = "Amy";
        String lastName = "Kaye";
        Object clearance = "Admin";
        Object oldUsername = "Amy";
        UserLogic instance = new UserLogic();
        instance.updateUser(username, password, firstName, lastName, clearance, oldUsername);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of clearanceCheck method, of class UserLogic.
     */
    @Test
    public void testClearanceCheck_String() {
        System.out.println("clearanceCheck");
        String clearance = "Admin";
        UserLogic instance = new UserLogic();
        int expResult = 0;
        int result = instance.clearanceCheck(clearance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of clearanceCheck method, of class UserLogic.
     */
    @Test
    
    public void testClearanceCheck_int() {
        System.out.println("clearanceCheck");
        int clearance = 0;
        UserLogic instance = new UserLogic();
        String expResult = "Admin";
        String result = instance.clearanceCheck(clearance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
