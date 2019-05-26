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
 * @author CHAACHAI Youssef
 */
public class CabinetFacadeTest {

    public CabinetFacadeTest() {
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
     * Test of createCabinet method, of class CabinetFacade.
     */
    @Test
    public void testCreateCabinet() {
        System.out.println("createCabinet");
        String nom = "Cabinet2";
        String adresse = "Marrakech, Sidi Abbad";
        String telephone = "+212 (0) 550 999 555";
        Long idMedcin = 1L;
        CabinetFacade instance = new CabinetFacade();
//        int expResult = 0;
        int result = instance.createCabinet(nom, adresse, telephone, idMedcin);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
    }

}
