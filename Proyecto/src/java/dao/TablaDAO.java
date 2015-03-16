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
import pojos.Ejercicio;
import pojos.Lineasejercicio;
import pojos.Tabla;
import proyecto.HibernateUtil;

/**
 *
 * @author usuario0305
 */
public class TablaDAO implements IDAO {

    private Session s;
    private Transaction t;

    public void iniciaOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
    }

    public void finalizaOperacion() {
        t.commit();
        s.close();
    }

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

    public Tabla actualizar(Tabla tabla) {
        iniciaOperacion();
        s.update(tabla);
        finalizaOperacion();

        return tabla;
    }

    public Lineasejercicio actualizar(Lineasejercicio linea) {
        iniciaOperacion();
        s.update(linea);
        finalizaOperacion();

        return linea;
    }

    public int borrar(int id) {
        iniciaOperacion();
        Query query = s.createSQLQuery("DELETE FROM tablas WHERE id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        finalizaOperacion();

        return result;
    }

    public Number total() {
        Number total = 0;
        iniciaOperacion();
        total = (Number) s.createCriteria(Tabla.class).setProjection(rowCount()).uniqueResult();
        finalizaOperacion();
        return total;
    }
}
