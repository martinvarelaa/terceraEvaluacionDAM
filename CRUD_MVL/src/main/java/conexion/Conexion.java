package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private final String USER = "root";
    private final String PASSWORD = "";
    private final String BBDD = "personacrud";
    private final String URL = "jdbc:mysql://localhost:3306/" + BBDD + "?user=" + USER + "&password= " + PASSWORD;
    private Connection conexion = null;

    public Connection conectar ( ) throws SQLException {
        if (conexion == null) {

            try {
                Class.forName ( "com.mysql.cj.jdbc.Driver" );
                conexion = DriverManager.getConnection ( URL );
                if (conexion != null) {
                    System.out.println ( "Conexión realizada con éxito!\r\n" );
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println ( "No se ha podido realizar la conexión!\r\n" );
                return null;

            }
            return conexion;


        }
        return conexion;

    }

}
