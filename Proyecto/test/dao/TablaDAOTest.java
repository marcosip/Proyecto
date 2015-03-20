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
import pojos.Lineasejercicio;
import pojos.Tabla;

/**
 *
 * @author usuario0305
 */
public class TablaDAOTest {
    
    public TablaDAOTest() {
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
     * Test of iniciaOperacion method, of class TablaDAO.
     */
    @Test
    public void testIniciaOperacion() {
        System.out.println("iniciaOperacion");
        TablaDAO instance = new TablaDAO();
        instance.iniciaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalizaOperacion method, of class TablaDAO.
     */
    @Test
    public void testFinalizaOperacion() {
        System.out.println("finalizaOperacion");
        TablaDAO instance = new TablaDAO();
        instance.finalizaOperacion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenItem method, of class TablaDAO.
     */
    @Test
    public void testObtenItem() {
        System.out.println("obtenItem");
        int id = 0;
        TablaDAO instance = new TablaDAO();
        Tabla expResult = null;
        Tabla result = instance.obtenItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class TablaDAO.
     */
    @Test
    public void testObtenListado_0args() {
        System.out.println("obtenListado");
        TablaDAO instance = new TablaDAO();
        List<Tabla> expResult = null;
        List<Tabla> result = instance.obtenListado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListado method, of class TablaDAO.
     */
    @Test
    public void testObtenListado_int() {
        System.out.println("obtenListado");
        int alumno = 0;
        TablaDAO instance = new TablaDAO();
        List<Tabla> expResult = null;
        List<Tabla> result = instance.obtenListado(alumno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenListaEjercicios method, of class TablaDAO.
     */
    @Test
    public void testObtenListaEjercicios() {
        System.out.println("obtenListaEjercicios");
        int tabla = 0;
        TablaDAO instance = new TablaDAO();
        List<Lineasejercicio> expResult = null;
        List<Lineasejercicio> result = instance.obtenListaEjercicios(tabla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class TablaDAO.
     */
    @Test
    public void testGuardar_Tabla() {
        System.out.println("guardar");
        Tabla tabla = null;
        TablaDAO instance = new TablaDAO();
        Tabla expResult = null;
        Tabla result = instance.guardar(tabla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardar method, of class TablaDAO.
     */
    @Test
    public void testGuardar_Lineasejercicio() {
        System.out.println("guardar");
        Lineasejercicio linea = null;
        TablaDAO instance = new TablaDAO();
        Lineasejercicio expResult = null;
        Lineasejercicio result = instance.guardar(linea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class TablaDAO.
     */
    @Test
    public void testActualizar_Tabla() {
        System.out.println("actualizar");
        Tabla tabla = null;
        TablaDAO instance = new TablaDAO();
        Tabla expResult = null;
        Tabla result = instance.actualizar(tabla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class TablaDAO.
     */
    @Test
    public void testActualizar_Lineasejercicio() {
        System.out.println("actualizar");
        Lineasejercicio linea = null;
        TablaDAO instance = new TablaDAO();
        Lineasejercicio expResult = null;
        Lineasejercicio result = instance.actualizar(linea);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrar method, of class TablaDAO.
     */
    @Test
    public void testBorrar() {
        System.out.println("borrar");
        int id = 0;
        TablaDAO instance = new TablaDAO();
        int expResult = 0;
        int result = instance.borrar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of total method, of class TablaDAO.
     */
    @Test
    public void testTotal() {
        System.out.println("total");
        TablaDAO instance = new TablaDAO();
        Number expResult = null;
        Number result = instance.total();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
