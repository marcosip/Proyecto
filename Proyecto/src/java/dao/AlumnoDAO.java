package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;
import pojos.Alumno;
import proyecto.HibernateUtil;

/**
 * Clase DAO para el manejo de la tabla alumnos
 *
 * @author usuario0305
 */
public class AlumnoDAO implements IDAO {

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
     * @param id
     * @return
     */
    public Alumno obtenItem(int id) {
        Alumno a;

        iniciaOperacion();
        a = (Alumno) s.createCriteria(Alumno.class).add(eq("id", id)).uniqueResult();
        finalizaOperacion();

        return a;
    }

    /**
     *
     * @return Lista de alumnos registrados en el sistema
     */
    public List<Alumno> obtenListado() {
        List<Alumno> lista;
        iniciaOperacion();
        lista = s.createCriteria(Alumno.class).list();
        finalizaOperacion();

        return lista;
    }

    /**
     * Obtiene el listado de alumnos asociados a un monitor, es decir, la lista
     * de alumnos a los cuales ha creado alguna tabla dicho monitor
     *
     * @param monitor Id del monitor
     * @return Lista de alumnos
     */
    public List<Alumno> obtenListado(int monitor) {
        List<Alumno> lista;
        iniciaOperacion();
        Query consulta = s.createSQLQuery("SELECT DISTINCT alumnos.* FROM alumnos RIGHT JOIN tablas ON alumnos.Id = tablas.Alumno WHERE tablas.Monitor = :idMonitor").addEntity(Alumno.class);
        consulta.setParameter("idMonitor", monitor);
        lista = consulta.list();
        finalizaOperacion();
        return lista;
    }

    /**
     *
     * @param alumno
     * @return
     */
    public Alumno guardar(Alumno alumno) {
        iniciaOperacion();
        try {
            s.persist(alumno);
        } catch (HibernateException e) {
            t.rollback();
            System.out.println(e.getMessage());
        }
        finalizaOperacion();

        return alumno;
    }

    /**
     *
     * @param alumno Alumno a modificar en la BBDD
     * @return
     */
    public Alumno actualizar(Alumno alumno) {
        iniciaOperacion();
        s.update(alumno);
        finalizaOperacion();

        return alumno;
    }

    /**
     * Elimina un alumno de la BBDD
     */
    @Override
    public int borrar(int id) {
        iniciaOperacion();
        Query query = s.createSQLQuery("DELETE FROM alumnos WHERE id = :ID");
        query.setParameter("ID", id);
        int result = query.executeUpdate();
        finalizaOperacion();

        return result;
    }

    /**
     * @return total Nº de alumnos registrados en la BBDD
     */
    @Override
    public Number total() {
        Number total = 0;
        iniciaOperacion();
        total = (Number) s.createCriteria(Alumno.class).setProjection(rowCount()).uniqueResult();
        finalizaOperacion();
        return total;
    }
}
