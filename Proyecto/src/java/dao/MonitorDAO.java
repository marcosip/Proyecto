/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import pojos.Monitor;
import proyecto.HibernateUtil;

/**
 *
 * @author usuario0305
 */
public class MonitorDAO implements IDAO {

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

    public Monitor obtenItem(int id) {
        Monitor a;

        iniciaOperacion();
        a = (Monitor) s.createCriteria(Monitor.class).add(eq("id", id)).uniqueResult();
        finalizaOperacion();

        return a;
    }

    public List<Monitor> obtenListado() {
        List<Monitor> lista;
        iniciaOperacion();
        lista = s.createCriteria(Monitor.class).list();
        finalizaOperacion();

        return lista;
    }

    public Monitor guardar(Monitor monitor) {
        int id = 0;
        iniciaOperacion();
        try {
            id = (int) s.save(monitor);
        } catch (HibernateException e) {
            t.rollback();
            System.out.println(e.getMessage());
        }
        finalizaOperacion();

        monitor.setId(id);

        return monitor;
    }

    public Monitor actualizar(Monitor monitor) {
        iniciaOperacion();
        s.update(monitor);
        finalizaOperacion();

        return monitor;
    }

    public int borrar(int id) {
        iniciaOperacion();
        Query query = s.createSQLQuery("DELETE FROM monitores WHERE id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        finalizaOperacion();

        return result;
    }

    public Number total() {
        Number total = 0;
        iniciaOperacion();
        total = (Number) s.createCriteria(Monitor.class).setProjection(rowCount()).uniqueResult();
        finalizaOperacion();
        return total;
    }
}