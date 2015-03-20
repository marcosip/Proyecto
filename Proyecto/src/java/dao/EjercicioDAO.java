/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import pojos.Ejercicio;
import proyecto.HibernateUtil;

/**
 * Clase DAO para el manejo de la tabla ejercicios
 *
 * @author usuario0305
 */
public class EjercicioDAO implements IDAO {

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
    public Ejercicio obtenItem(int id) {
        Ejercicio e;

        iniciaOperacion();
        e = (Ejercicio) s.createCriteria(Ejercicio.class).add(eq("id", id)).uniqueResult();
        finalizaOperacion();

        return e;
    }

    /**
     *
     * @return
     */
    public List<Ejercicio> obtenListado() {
        List<Ejercicio> lista;
        iniciaOperacion();
        lista = s.createCriteria(Ejercicio.class).list();
        finalizaOperacion();

        return lista;
    }

    public Number total() {
        Number total = 0;
        iniciaOperacion();
        total = (Number) s.createCriteria(Ejercicio.class).setProjection(rowCount()).uniqueResult();
        finalizaOperacion();
        return total;
    }

    @Override
    public int borrar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
