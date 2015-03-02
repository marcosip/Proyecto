package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario0305
 */
public class BBDD {

    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    public BBDD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/rexia", "root", "usbw");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametro(int n, String parametro) {
        try {
            ps.setString(n, parametro);
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejecutarConsulta(String consulta) {
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ejecutarComando(String consulta) {
        try {
            ps = conexion.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getResultado() {
        return rs;
    }

    public void cerrarConexion() {
        try {
            rs.close();
            ps.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(BBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
