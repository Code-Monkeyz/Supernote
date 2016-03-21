/*
 * UserDBConnectTest
 * Re-done on March 21 2016
 * Code Monkeys
 * CIST 2931 for the DeRichie Group
 */
package Data_Access;

import Business.UserLogic;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void testLogin() throws Exception {
        
        UserLogic ul = new UserLogic();
        
        
        System.out.println("login");
        String userName = "Admin";
        ul.setUsername(userName);
        UserDBConnect instance = new UserDBConnect();
        //String expResult = "bonnief-pass";
       // String expResult = "John-Admin";
        UserLogic newObject = instance.login(ul);
        //Object expResult = ul;
        
        
        String result = newObject.getUsername() + newObject.getPassword();
        String expResult = "Adminpassword";
        assertEquals(expResult, result);
        System.out.println("Result: " + result);
        System.out.println("Exp : " + expResult);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of populateUser method, of class UserDBConnect.
     */
    
    @Test
    public void testPopulateUser() throws Exception {
        System.out.println("populateUser");
        String actualResult = null;
        String actualExpResult = null;
        
        ArrayList<String> expResult = null;
        
        String[] expResultArray = new String[]{"Admin", "Lucy" };
       // String[] expResultArray = new String[]{"Amy", "mary", "bonnief", "Wendyh", "Davidr", "Sami" };//this was the old one
        ArrayList<String> result = UserDBConnect.populateUser();
        Object[] resultArray = result.toArray();
        
        
        System.out.println(result.toString());
        assertTrue(Arrays.equals(resultArray, expResultArray));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UserSelect method, of class UserDBConnect.
     */
    @Test
    public void testUserSelect() throws Exception {
        System.out.println("userSelect");
        String name = "Lucy";
        UserLogic ul = new UserLogic();
        ul.setUsername(name);
        UserDBConnect instance = new UserDBConnect();
        String expResult = "Ricardo";
        UserLogic result = (UserLogic) instance.userSelect(ul);
        assertEquals(expResult, result.getLastName() );
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
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
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertUser method, of class UserDBConnect.
     */
//    @Test
//    public void testInsertUser() throws Exception {
//        System.out.println("insertUser");
//        String userName = "TristonG";
//        String pass = "pass";
//        String firstName = "Triston";
//        String lastName = "Gregoire";
//        int clearance = 0;
//        UserDBConnect instance = new UserDBConnect();
//        instance.insertUser(userName, pass, firstName, lastName, clearance);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of update method, of class UserDBConnect.
     */
    @Test
    public void testUpdate() throws Exception {
        UserLogic ul = new UserLogic();
        System.out.println("update");
        String newUsername = "";
        String password = "";
        String firstName = "";
        String lastName = "";
        int clearance = 0;
        String oldUsername = "";
        UserDBConnect instance = new UserDBConnect();
        instance.update(ul);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }
    
}
