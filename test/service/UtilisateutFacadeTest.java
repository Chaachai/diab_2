/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Utilisateur;
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
public class UtilisateutFacadeTest {
    
    public UtilisateutFacadeTest() {
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
     * Test of createUser method, of class UtilisateutFacade.
     */
//    @Test
//    public void testCreateUser() {
//        System.out.println("createUser");
//        UtilisateutFacade instance = new UtilisateutFacade();
//        int expResult = 0;
//        int result = instance.createUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getUtilisateurByTelOrEmail method, of class UtilisateutFacade.
     */
//    @Test
//    public void testGetUtilisateurByTelOrEmail() {
//        System.out.println("getUtilisateurByTelOrEmail");
//        String telephone = "0606060606";
//        String email = "yass@yassine.co";
//        UtilisateutFacade instance = new UtilisateutFacade();
////        Utilisateur expResult = null;
//        Utilisateur result = instance.getUtilisateurByTelOrEmail(telephone, email);
//        System.out.println(result.getNom());
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of seConnecter method, of class UtilisateutFacade.
     */
    @Test
    public void testSeConnecter() {
        System.out.println("seConnecter");
        UtilisateurFacade instance = new UtilisateurFacade();
        //int expResult = 0;
        int result = instance.seConnecter("ana@ana" ,"aaa" );
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
