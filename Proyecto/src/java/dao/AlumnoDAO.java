/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import pojos.Alumno;
import pojos.Monitor;
import proyecto.HibernateUtil;

/**
 *
 * @author usuario0305
 */
public class AlumnoDAO implements DAO{

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

    public Alumno obtenItem(int id) {
        Alumno a;

        iniciaOperacion();
        a = (Alumno) s.createCriteria(Alumno.class).add(eq("id", id)).uniqueResult();
        finalizaOperacion();

        return a;
    }

    public List<Alumno> obtenListado() {
        List<Alumno> lista;
        iniciaOperacion();
        lista = s.createCriteria(Alumno.class).list();
        finalizaOperacion();

        return lista;
    }

    public Alumno guardar(Alumno alumno) {
        iniciaOperacion();
        s.persist(alumno);
        finalizaOperacion();

        return alumno;
    }

    public int borrar(int id) {
        iniciaOperacion();
        Query query = s.createQuery("DELETE Alumno WHERE id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        finalizaOperacion();

        return result;
    }

    public Number total() {
        Number total = 0;
        iniciaOperacion();
        total = (Number) s.createCriteria(Monitor.class).setProjection(rowCount()).setCacheable(true).uniqueResult();
        finalizaOperacion();
        return total;
    }
}
