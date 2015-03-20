/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author usuario0305
 */
public class IDAOTest {
    
    public IDAOTest() {
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
     * Test of iniciaOperacion method, of class IDAO.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        IDAO instance = new IDAOImpl();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class IDAO.
     */
    @Test
    public void testFinalizaOperacion() {
        System.out.println("finalizaOperacion");
        IDAO instance = new IDAOImpl();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class IDAO.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        int id = 0;
        IDAO instance = new IDAOImpl();
        int expResult = 0;
        int result = instance.borrar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of total method, of class IDAO.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        IDAO instance = new IDAOImpl();
        Number expResult = null;
        Number result = instance.total();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IDAOImpl implements IDAO {

        public void iniciaOperacion() {
        }

        public void finalizaOperacion() {
        }

        public int borrar(int id) {
            return 0;
        }

        public Number total() {
            return null;
        }
    }
    
}
