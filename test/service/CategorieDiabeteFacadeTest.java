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
public class CategorieDiabeteFacadeTest {
    
    public CategorieDiabeteFacadeTest() {
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
     * Test of createType method, of class CategorieDiabeteFacade.
     */
    @Test
    public void testCreateType() {
        System.out.println("createType");
        String libelle = "Le pré-diabète";
        CategorieDiabeteFacade instance = new CategorieDiabeteFacade();
        instance.createType(libelle);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
