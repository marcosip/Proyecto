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
 * Clase DAO para el manejo de la tabla monitores
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

    /**
     *
     * @param id
     * @return
     */
    public Monitor obtenItem(int id) {
        Monitor a;

        iniciaOperacion();
        a = (Monitor) s.createCriteria(Monitor.class).add(eq("id", id)).uniqueResult();
        finalizaOperacion();

        return a;
    }

    /**
     * Devuelve el monitor correspondiente al hash pasado en caso de que exista
     *
     * @param hash Cadena con el hash formado por el nombre y los apellidos del
     * monitor
     * @return Devuelve el monitor que coincida con el hash especificado en caso
     * de exisitr o null si no se encuentraf
     */
    public Monitor obtenItem(String hash) {
        Monitor m;

        iniciaOperacion();
        m = (Monitor) s.createSQLQuery("SELECT * FROM monitores WHERE SHA2(CONCAT(monitores.Nombre, monitores.Apellidos),256) LIKE :hash").addEntity(Monitor.class).setParameter("hash", hash).uniqueResult();

        return m;
    }

    /**
     *
     * @return
     */
    public List<Monitor> obtenListado() {
        List<Monitor> lista;
        iniciaOperacion();
        lista = s.createCriteria(Monitor.class).list();
        finalizaOperacion();

        return lista;
    }

    /**
     *
     * @param monitor
     * @return
     */
    public Monitor guardar(Monitor monitor) {
        iniciaOperacion();
        try {
            s.persist(monitor);
        } catch (HibernateException e) {
            t.rollback();
            System.out.println(e.getMessage());
        }
        finalizaOperacion();

        return monitor;
    }

    /**
     *
     * @param monitor
     * @return
     */
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
