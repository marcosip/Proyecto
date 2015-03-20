/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import pojos.Alumno;
import pojos.Lineasejercicio;
import pojos.Monitor;
import pojos.Tabla;
import proyecto.HibernateUtil;

/**
 * Clase DAO para el manejo de la tabla tablas
 *
 * @author usuario0305
 */
public class TablaDAO implements IDAO {

    private Session s;
    private Transaction t;

    @Override
    public void iniciaOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
    }

    @Override
    public void finalizaOperacion() {
        t.commit();
        s.close();
    }

    /**
     *
     * @param id Identificador de la tabla
     * @return Tabla asociada al identificador seleccionado
     */
    public Tabla obtenItem(int id) {
        Tabla t;

        iniciaOperacion();
        t = (Tabla) s.createCriteria(Tabla.class).
                setFetchMode("alumno", FetchMode.JOIN).
                setFetchMode("monitor", FetchMode.JOIN).
                add(eq("id", id)).uniqueResult();

        Hibernate.initialize(t.getAlumno());
        Hibernate.initialize(t.getMonitor());
        finalizaOperacion();

        return t;
    }

    /**
     *
     * @return Devuelve un listado con las tablas almacenadas en la BBDD
     */
    public List<Tabla> obtenListado() {
        List<Tabla> lista;
        iniciaOperacion();
        lista = s.createCriteria(Tabla.class).
                setFetchMode("alumno", FetchMode.JOIN).
                setFetchMode("monitor", FetchMode.JOIN).
                list();

        for (Tabla item : lista) {
            Hibernate.initialize(item.getAlumno());
            Hibernate.initialize(item.getMonitor());
        }
        finalizaOperacion();

        return lista;
    }

    /**
     *
     * @param alumno Alumno por el cual se van a filtrar las tablas
     * @return Devuelve un listado con las tablas que coincidan con el alumno
     * seleccionado
     */
    public List<Tabla> obtenListado(int alumno) {
        List<Tabla> lista;
        iniciaOperacion();
        lista = s.createCriteria(Tabla.class).
                setFetchMode("alumno", FetchMode.JOIN).
                setFetchMode("monitor", FetchMode.JOIN).
                add(eq("alumno", new Alumno(alumno))).
                list();

        for (Tabla item : lista) {
            Hibernate.initialize(item.getAlumno());
            Hibernate.initialize(item.getMonitor());
        }
        finalizaOperacion();

        return lista;
    }

    /**
     *
     * @param monitor Monitor por el cual se van a filtrar las tablas
     * @return Devuelve un listado con las tablas que estén asiganadas al
     * monitor selccionado
     */
    public List<Tabla> obtenListadoPorMonitor(int monitor) {
        List<Tabla> lista;
        iniciaOperacion();
        lista = s.createCriteria(Tabla.class).
                setFetchMode("alumno", FetchMode.JOIN).
                setFetchMode("monitor", FetchMode.JOIN).
                add(eq("monitor", new Monitor(monitor))).
                list();

        for (Tabla item : lista) {
            Hibernate.initialize(item.getAlumno());
            Hibernate.initialize(item.getMonitor());
        }
        finalizaOperacion();

        return lista;
    }

    /**
     *
     * @param ejercicio Ejercicio por el cual se van a filtrar las tablas
     * @return Devuelve un listado con las tablas que utilizan el ejercicio
     * seleccionado
     */
    public List<Tabla> obtenListadoPorEjercicio(int ejercicio) {
        List<Tabla> lista;
        iniciaOperacion();

        lista = s.createSQLQuery(""
                + "SELECT tablas.* FROM ejercicios RIGHT JOIN lineasejercicios ON ejercicios.Id"
                + " = lineasejercicios.Ejercicio JOIN tablas ON lineasejercicios.Tabla "
                + "= tablas.Id WHERE lineasejercicios.Ejercicio = :idEjercicio")
                .addEntity(Tabla.class)
                .setParameter("idEjercicio", ejercicio)
                .list();

        return lista;
    }

    /**
     *
     * @param tabla Tabla asociada a la lista de ejercicios a obtener
     * @return Lista de ejercicios asociada
     */
    public List<Lineasejercicio> obtenListaEjercicios(int tabla) {
        List<Lineasejercicio> lista;
        iniciaOperacion();
        lista = s.createCriteria(Lineasejercicio.class).
                setFetchMode("ejercicio", FetchMode.JOIN).
                add(eq("tabla", tabla)).
                list();

        for (Lineasejercicio item : lista) {
            Hibernate.initialize(item.getEjercicio());
        }

        finalizaOperacion();

        return lista;
    }

    /**
     *
     * @param tabla
     * @return
     */
    public Tabla guardar(Tabla tabla) {
        int id = 0;
        iniciaOperacion();
        try {
            id = (int) s.save(tabla);
        } catch (HibernateException e) {
            t.rollback();
            System.out.println(e.getMessage());
        }
        finalizaOperacion();

        tabla.setId(id);

        return tabla;
    }

    /**
     *
     * @param linea
     * @return
     */
    public Lineasejercicio guardar(Lineasejercicio linea) {
        int id = 0;
        iniciaOperacion();
        try {
            id = (int) s.save(linea);
        } catch (HibernateException e) {
            t.rollback();
            System.out.println(e.getMessage());
        }
        finalizaOperacion();

        linea.setId(id);

        return linea;
    }

    /**
     *
     * @param tabla
     * @return
     */
    public Tabla actualizar(Tabla tabla) {
        iniciaOperacion();
        s.update(tabla);
        finalizaOperacion();

        return tabla;
    }

    /**
     *
     * @param linea
     * @return
     */
    public Lineasejercicio actualizar(Lineasejercicio linea) {
        iniciaOperacion();
        s.update(linea);
        finalizaOperacion();

        return linea;
    }

    /**
     * 
     */
    @Override
    public int borrar(int id) {
        iniciaOperacion();
        Query query = s.createSQLQuery("DELETE FROM tablas WHERE id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        finalizaOperacion();

        return result;
    }

    /**
     *
     */
    @Override
    public Number total() {
        Number total;
        iniciaOperacion();
        total = (Number) s.createCriteria(Tabla.class).setProjection(rowCount()).uniqueResult();
        finalizaOperacion();
        return total;
    }
}
