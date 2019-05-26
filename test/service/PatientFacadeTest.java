/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Patient;
import java.util.Date;
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
public class PatientFacadeTest {
    
    public PatientFacadeTest() {
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
     * Test of create method, of class PatientFacade.
     */
//    @Test
//    public void testCreate() {
//        System.out.println("create");
//        Patient patient = null;
//        PatientFacade instance = new PatientFacade();
//        instance.create(patient);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createPatient method, of class PatientFacade.
     */
    @Test
    public void testCreatePatient() {
        System.out.println("createPatient");
        String nom = "yassine";
        String prenom = "zomorod";
        String email = "yass@yassine.co";
        String password = "yassine";
        String telephone = "0606060606";
        Date dateNaissance = new Date();
        PatientFacade instance = new PatientFacade();
        //int expResult = 0;
//        int result = instance.createPatient(nom, prenom,1, email, password, telephone, dateNaissance);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
