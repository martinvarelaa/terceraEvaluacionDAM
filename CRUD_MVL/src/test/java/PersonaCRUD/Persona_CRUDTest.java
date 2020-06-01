package PersonaCRUD;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import persona.Persona;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public
class Persona_CRUDTest {

    Persona_CRUD utils;
    Persona persona;


    @Before
    public void setUp ( ) {
        utils = new Persona_CRUD ( );
        persona = new Persona ( "Martin" , "Varela" , 19 , "11111111E" );
    }

    @Test
    public void crearPersonaMartinTest  ( ) {


            assertTrue ( persona.equals ( utils.crearPersonaMartin () ) );





    }

    @Test
    public void generarDNITest ( ) {

        String dni         = utils.generarDNI ( );
        String digitos_dni = dni.replaceAll ( "[a-zA-Z]" , "" );
        String letra_dni   = dni.replaceAll ( "\\d*" , "" );


        if (digitos_dni.matches ( "\\d*" ) && letra_dni.matches ( "[a-zA-Z]" )) {

            assertEquals ( 8 , digitos_dni.length ( ) );
            assertEquals ( 1 , letra_dni.length ( ) );

        } else
            Assert.fail ( );
    }

    @Test
    public void detectarMenoresTest ( ) throws SQLException {

        ArrayList < Persona > listaPersonas = utils.detectarMenores ( );
        for (Persona personaIt : listaPersonas) {
            if (personaIt.getEdad () > 18){
                Assert.fail ();
            }
        }
    }

    @Test
    public void detectarJuanelesTest ( ) throws SQLException {
        ArrayList < Persona > listaPersonas = utils.detectarJuaneles ( );
        for (Persona personaIt : listaPersonas) {
            if (!personaIt.getNombre ().equals ( "Juanele" )){
                Assert.fail ();
            }
        }
    }

    @Test
    public void listarPersonasTest ( ) {
        ArrayList < Persona > listaPersonas = utils.listaPersonasDNI ( );
        for (Persona personaIt : listaPersonas) {
            assertEquals ( 1, listaPersonas.size ()  );
            assertEquals ( persona.getClass (), personaIt.getClass () );
        }
    }
}
