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
import pojos.Alumno;

/**
 *
 * @author usuario0305
 */
public class AlumnoDAOTest {
    
    public AlumnoDAOTest() {
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
     * Test of iniciaOperacion method, of class AlumnoDAO.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        AlumnoDAO instance = new AlumnoDAO();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class AlumnoDAO.
     */
    @Test
    public void testFinalizaOperacion() {
        System.out.println("finalizaOperacion");
        AlumnoDAO instance = new AlumnoDAO();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenItem method, of class AlumnoDAO.
     */
    @Test
    public void testObtenItem() {
        System.out.println("obtenItem");
        int id = 0;
        AlumnoDAO instance = new AlumnoDAO();
        Alumno expResult = null;
        Alumno result = instance.obtenItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class AlumnoDAO.
     */
    @Test
    public void testObtenListado_0args() {
        System.out.println("obtenListado");
        AlumnoDAO instance = new AlumnoDAO();
        List<Alumno> expResult = null;
        List<Alumno> result = instance.obtenListado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class AlumnoDAO.
     */
    @Test
    public void testObtenListado_int() {
        System.out.println("obtenListado");
        int monitor = 0;
        AlumnoDAO instance = new AlumnoDAO();
        List<Alumno> expResult = null;
        List<Alumno> result = instance.obtenListado(monitor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class AlumnoDAO.
     */
    @Test
    public void testGuardar() {
        System.out.println("guardar");
        Alumno alumno = null;
        AlumnoDAO instance = new AlumnoDAO();
        Alumno expResult = null;
        Alumno result = instance.guardar(alumno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class AlumnoDAO.
     */
    @Test
    public void testActualizar() {
        System.out.println("actualizar");
        Alumno alumno = null;
        AlumnoDAO instance = new AlumnoDAO();
        Alumno expResult = null;
        Alumno result = instance.actualizar(alumno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class AlumnoDAO.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        int id = 0;
        AlumnoDAO instance = new AlumnoDAO();
        int expResult = 0;
        int result = instance.borrar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of total method, of class AlumnoDAO.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        AlumnoDAO instance = new AlumnoDAO();
        Number expResult = null;
        Number result = instance.total();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
