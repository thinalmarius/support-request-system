/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import srs.entity.Customers;
import srs.entity.Tickets;
import srs.entity.Users;
import srs.entity.Words;

/**
 *
 * @author Thinal
 */
public class datalinkTest {
    
    public datalinkTest() {
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
     * Test of getPassword method, of class datalink.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String name = "";
        datalink instance = new datalink();
        String expResult = "";
        String result = instance.getPassword(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getuser method, of class datalink.
     */
    @Test
    public void testGetuser() {
        System.out.println("getuser");
        datalink instance = new datalink();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getuser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCusId method, of class datalink.
     */
    @Test
    public void testGetCusId() {
        System.out.println("getCusId");
        String name = "";
        String email = "";
        datalink instance = new datalink();
        int expResult = 0;
        int result = instance.getCusId(name, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTicket method, of class datalink.
     */
    @Test
    public void testAddTicket() {
        System.out.println("addTicket");
        int cus_id = 0;
        String line = "";
        int level = 0;
        datalink instance = new datalink();
        int expResult = 0;
        int result = instance.addTicket(cus_id, line, level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewTickets method, of class datalink.
     */
    @Test
    public void testViewTickets() {
        System.out.println("viewTickets");
        datalink instance = new datalink();
        List<Tickets> expResult = null;
        List<Tickets> result = instance.viewTickets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStopWords method, of class datalink.
     */
    @Test
    public void testGetStopWords() {
        System.out.println("getStopWords");
        datalink instance = new datalink();
        Set<String> expResult = null;
        Set<String> result = instance.getStopWords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewWords method, of class datalink.
     */
    @Test
    public void testGetNewWords() {
        System.out.println("getNewWords");
        datalink instance = new datalink();
        ArrayList<Words> expResult = null;
        ArrayList<Words> result = instance.getNewWords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excludeList method, of class datalink.
     */
    @Test
    public void testExcludeList() {
        System.out.println("excludeList");
        datalink instance = new datalink();
        Set<String> expResult = null;
        Set<String> result = instance.excludeList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class datalink.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String name = "";
        String email = "";
        String company = "";
        datalink instance = new datalink();
        int expResult = 0;
        int result = instance.addCustomer(name, email, company);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLearnWords method, of class datalink.
     */
    @Test
    public void testGetLearnWords() {
        System.out.println("getLearnWords");
        ArrayList<Words> learnWords = null;
        datalink instance = new datalink();
        instance.getLearnWords(learnWords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class datalink.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "";
        String email = "";
        String pswd = "";
        datalink instance = new datalink();
        instance.addUser(name, email, pswd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyCustomer method, of class datalink.
     */
    @Test
    public void testVerifyCustomer() {
        System.out.println("verifyCustomer");
        int id = 0;
        datalink instance = new datalink();
        String expResult = "";
        String result = instance.verifyCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHardwareCategory method, of class datalink.
     */
    @Test
    public void testGetHardwareCategory() {
        System.out.println("getHardwareCategory");
        datalink instance = new datalink();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getHardwareCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoftwareCategory method, of class datalink.
     */
    @Test
    public void testGetSoftwareCategory() {
        System.out.println("getSoftwareCategory");
        datalink instance = new datalink();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getSoftwareCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTicket method, of class datalink.
     */
    @Test
    public void testDeleteTicket() {
        System.out.println("deleteTicket");
        int id = 0;
        datalink instance = new datalink();
        instance.deleteTicket(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCustomers method, of class datalink.
     */
    @Test
    public void testViewCustomers() {
        System.out.println("viewCustomers");
        datalink instance = new datalink();
        List<Customers> expResult = null;
        List<Customers> result = instance.viewCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class datalink.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int id = 0;
        datalink instance = new datalink();
        instance.deleteCustomer(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class datalink.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int id = 0;
        datalink instance = new datalink();
        instance.deleteUser(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewUsers method, of class datalink.
     */
    @Test
    public void testViewUsers() {
        System.out.println("viewUsers");
        datalink instance = new datalink();
        List<Users> expResult = null;
        List<Users> result = instance.viewUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
