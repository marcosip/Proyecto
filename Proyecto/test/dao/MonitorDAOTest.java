/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.Monitor;

/**
 *
 * @author usuario0305
 */
public class MonitorDAOTest {
    
    public MonitorDAOTest() {
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
     * Test of iniciaOperacion method, of class MonitorDAO.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        MonitorDAO instance = new MonitorDAO();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class MonitorDAO.
     */
    @Test
    public void testFinalizaOperacion() {
        System.out.println("finalizaOperacion");
        MonitorDAO instance = new MonitorDAO();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenItem method, of class MonitorDAO.
     */
    @Test
    public void testObtenItem_int() {
        System.out.println("obtenItem");
        int id = 0;
        MonitorDAO instance = new MonitorDAO();
        Monitor expResult = null;
        Monitor result = instance.obtenItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenItem method, of class MonitorDAO.
     */
    @Test
    public void testObtenItem_String() {
        System.out.println("obtenItem");
        String hash = "";
        MonitorDAO instance = new MonitorDAO();
        Monitor expResult = null;
        Monitor result = instance.obtenItem(hash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class MonitorDAO.
     */
    @Test
    public void testObtenListado() {
        System.out.println("obtenListado");
        MonitorDAO instance = new MonitorDAO();
        List<Monitor> expResult = null;
        List<Monitor> result = instance.obtenListado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class MonitorDAO.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Monitor monitor = null;
        MonitorDAO instance = new MonitorDAO();
        Monitor expResult = null;
        Monitor result = instance.guardar(monitor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class MonitorDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Monitor monitor = null;
        MonitorDAO instance = new MonitorDAO();
        Monitor expResult = null;
        Monitor result = instance.actualizar(monitor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class MonitorDAO.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        int id = 0;
        MonitorDAO instance = new MonitorDAO();
        int expResult = 0;
        int result = instance.borrar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of total method, of class MonitorDAO.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        MonitorDAO instance = new MonitorDAO();
        Number expResult = null;
        Number result = instance.total();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
