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
import pojos.Ejercicio;

/**
 *
 * @author usuario0305
 */
public class EjercicioDAOTest {
    
    public EjercicioDAOTest() {
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
     * Test of iniciaOperacion method, of class EjercicioDAO.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        EjercicioDAO instance = new EjercicioDAO();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class EjercicioDAO.
     */
    @Test
    public void testFinalizaOperacion() {
        System.out.println("finalizaOperacion");
        EjercicioDAO instance = new EjercicioDAO();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenItem method, of class EjercicioDAO.
     */
    @Test
    public void testObtenItem() {
        System.out.println("obtenItem");
        int id = 0;
        EjercicioDAO instance = new EjercicioDAO();
        Ejercicio expResult = null;
        Ejercicio result = instance.obtenItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class EjercicioDAO.
     */
    @Test
    public void testObtenListado() {
        System.out.println("obtenListado");
        EjercicioDAO instance = new EjercicioDAO();
        List<Ejercicio> expResult = null;
        List<Ejercicio> result = instance.obtenListado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of total method, of class EjercicioDAO.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        EjercicioDAO instance = new EjercicioDAO();
        Number expResult = null;
        Number result = instance.total();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class EjercicioDAO.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        int id = 0;
        EjercicioDAO instance = new EjercicioDAO();
        int expResult = 0;
        int result = instance.borrar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
