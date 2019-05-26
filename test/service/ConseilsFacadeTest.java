/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Conseils;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CHAACHAI Youssef
 */
public class ConseilsFacadeTest {

    public ConseilsFacadeTest() {
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
     * Test of createConseil method, of class ConseilsFacade.
     */
//    @Test
//    public void testCreateConseil() {
//        System.out.println("createConseil");
//        String titre = "TESTING";
//        String message = "TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST ";
//        Long idMedcin = 1L;
//        Long idType = 401L;
//        ConseilsFacade instance = new ConseilsFacade();
////        int expResult = 0;
//        int result = instance.createConseil(titre, message, idMedcin, idType);
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//        System.out.println(result);
//    }
    /**
     * Test of findByMedcinAndCategory method, of class ConseilsFacade.
     */
    @Test
    public void testFindByMedcinAndCategory() {
        System.out.println("findByMedcinAndCategory");
        Long idMedcin = 1L;
        Long idCategorie = 401L;
        ConseilsFacade instance = new ConseilsFacade();
//        List<Conseils> expResult = null;
        List<Conseils> result = instance.findByMedcinAndCategory(idMedcin, idCategorie);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        for (Conseils conseils : result) {
            System.out.println(conseils);
        }
    }

}
