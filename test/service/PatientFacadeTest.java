/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.CategorieDiabete;
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
        String nom = "bala";
        String prenom = "bali";
        int role = 1;
        String email = "ok@ok";
        String password = "bala";
        String telephone = "09897877";
        Date dateNaissance = null;
        float taille = 180.0F;
        float poids = 65.0F;
        CategorieDiabete typeDiab = new CategorieDiabete((long)1);
        
        PatientFacade instance = new PatientFacade();
        //int expResult = 0;
        int result = instance.createPatient(nom, prenom, role, email, password, telephone, dateNaissance, taille, poids, typeDiab);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
