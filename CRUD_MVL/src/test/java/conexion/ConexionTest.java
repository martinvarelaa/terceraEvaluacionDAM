package conexion;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public
class ConexionTest {

    Conexion utils;


    @Before
    public void setUp ( ) throws Exception {
        utils = new Conexion ( );
    }

    @Test
    public void conectar ( ) {
        try {
            assertNotNull ( utils.conectar ( ) );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }


}