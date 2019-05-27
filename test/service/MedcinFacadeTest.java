/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hamza
 */
public class MedcinFacadeTest {
    
    public MedcinFacadeTest() {
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
     * Test of createPatient method, of class MedcinFacade.
     */
    @Test
    public void testCreatePatient() {
        System.out.println("createPatient");
        String nom = "berrada";
        String prenom = "farid";
        int role = 2;
        String email = "farid.berrada@medcin.com";
        String password = "aaa";
        String telephone = "090909090909";
        String speciaite = "type1";
        MedcinFacade instance = new MedcinFacade();
        //int expResult = 0;
//        int result = instance.createPatient(nom, prenom, role, email, password, telephone, speciaite);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
