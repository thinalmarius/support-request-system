/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srs.db;

import java.sql.ResultSet;
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
import srs.entity.Users;
import srs.entity.Words;

/**
 *
 * @author Thinal
 */
public class sqlTest {
    
    public sqlTest() {
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
     * Test of getpwd method, of class sql.
     */
    @Test
    public void testGetpwd() {
        System.out.println("getpwd");
        String name = "";
        String expResult = "";
        String result = sql.getpwd(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getusr method, of class sql.
     */
    @Test
    public void testGetusr() {
        System.out.println("getusr");
        List<Users> expResult = null;
        List<Users> result = sql.getusr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUsr method, of class sql.
     */
    @Test
    public void testAddUsr() {
        System.out.println("addUsr");
        String name = "";
        String email = "";
        String pswd = "";
        String username = "";
        sql.addUsr(name, username, email, pswd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStopwords method, of class sql.
     */
    @Test
    public void testGetStopwords() {
        System.out.println("getStopwords");
        Set<String> expResult = null;
        Set<String> result = sql.getStopwords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewWords method, of class sql.
     */
    @Test
    public void testGetNewWords() {
        System.out.println("getNewWords");
        ArrayList<Words> expResult = null;
        ArrayList<Words> result = sql.getNewWords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excludeList method, of class sql.
     */
    @Test
    public void testExcludeList() {
        System.out.println("excludeList");
        Set<String> expResult = null;
        Set<String> result = sql.excludeList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCusId method, of class sql.
     */
    @Test
    public void testGetCusId() {
        System.out.println("getCusId");
        String name = "";
        String email = "";
        int expResult = 0;
        int result = sql.getCusId(name, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyCus method, of class sql.
     */
    @Test
    public void testVerifyCus() {
        System.out.println("verifyCus");
        int id = 0;
        String expResult = "";
        String result = sql.verifyCus(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCustomers method, of class sql.
     */
    @Test
    public void testViewCustomers() {
        System.out.println("viewCustomers");
        List<Customers> expResult = null;
        List<Customers> result = sql.viewCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewTicket method, of class sql.
     */
    @Test
    public void testAddNewTicket() {
        System.out.println("addNewTicket");
        int cus_id = 0;
        String problem = "";
        int severity = 0;
        sql.addNewTicket(cus_id, problem, severity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewTickets method, of class sql.
     */
    @Test
    public void testViewTickets() {
        System.out.println("viewTickets");
        ResultSet expResult = null;
        ResultSet result = sql.viewTickets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTicket method, of class sql.
     */
    @Test
    public void testDeleteTicket() {
        System.out.println("deleteTicket");
        int id = 0;
        sql.deleteTicket(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class sql.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int id = 0;
        sql.deleteCustomer(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class sql.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int id = 0;
        sql.deleteUser(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectLastTicket method, of class sql.
     */
    @Test
    public void testSelectLastTicket() {
        System.out.println("selectLastTicket");
        int expResult = 0;
        int result = sql.selectLastTicket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class sql.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String name = "";
        String email = "";
        String company = "";
        sql.addCustomer(name, email, company);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHardware method, of class sql.
     */
    @Test
    public void testGetHardware() {
        System.out.println("getHardware");
        ResultSet expResult = null;
        ResultSet result = sql.getHardware();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoftware method, of class sql.
     */
    @Test
    public void testGetSoftware() {
        System.out.println("getSoftware");
        ResultSet expResult = null;
        ResultSet result = sql.getSoftware();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
