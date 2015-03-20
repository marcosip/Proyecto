package dao;

/**
 * Interfaz común a todos los DAO. Define algunas operaciones básicas que deben
 * implementar todas las clases que la implementen
 *
 * @author usuario0305
 */
public interface IDAO {

    /**
     * Inicia una transacción previo a ejecutar una operación sobre la BBDD
     */
    public void iniciaOperacion();

    /**
     * Finaliza la transacción en ejecución tras ejecutar las diferentes
     * operaciones sobre la BBDD
     */
    public void finalizaOperacion();

    /**
     * Borra un item de la entidad actual de la BBDD
     *
     * @param id Nº identificativo del item a borrar
     * @return
     */
    public int borrar(int id);

    /**
     *
     * @return Devuelve el total de items registrados para la entidad actual
     */
    public Number total();
}
