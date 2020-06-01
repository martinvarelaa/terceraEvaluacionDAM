package PersonaCRUD;

import conexion.Conexion;
import persona.Persona;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public
class Persona_CRUD {

    private Scanner scanner = new Scanner ( System.in );
    private String query;
    private Statement sentencia;
    private Conexion conexion;

    public Persona_CRUD ( ) {
        conexion = new Conexion ( );
    }

    public Persona crearPersonaMartin ( ) {


        String nombre   = "Martin";
        String apellido = "Varela";
        int    edad     = 19;
        String dni      = "11111111E";

        Persona persona = new Persona ( nombre , apellido , edad , dni );

        System.out.println ( persona.toString ( ) );

        try {

            query = "INSERT INTO persona VALUES ('" + persona.getDni ( ) + "','" + persona.getNombre ( ) + "','" + persona.getApellido ( ) + "'," + persona.getEdad ( ) + ")";
            sentencia = conexion.conectar ( ).createStatement ( );


            if (sentencia.executeUpdate ( query ) > 0) {
                System.out.println ( "Registro insertado con éxito!" );
            } else {
                System.out.println ( "No se ha podido insertar el registro!" );

            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println ("Martín ya está creado, elimínalo primero! \r\n" );

        } catch (SQLException ex) {

        }

        return persona;

    }

    public void eliminarPersona ( ) {

        System.out.println ( "Buscar por DNI para borrar: " );
        String dni = scanner.next ( );

        try {

            query = "DELETE FROM persona WHERE dni =" + "'" + dni + "'";
            sentencia = conexion.conectar ( ).createStatement ( );


            if (sentencia.executeUpdate ( query ) > 0) {
                System.out.println ( "Registro borrado con éxito!\r\n" );
            } else {
                System.out.println ( "No se ha encontrado persona con ese DNI!\r\n" );

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
        }

    }

    public void cambiarPersona ( ) {

        try {

            System.out.println ( "Filtrar por DNI para cambiar datos: " );
            String    dni       = scanner.next ( );
            ResultSet resultSet = null;
            query = "SELECT * FROM persona WHERE dni =" + "'" + dni + "'";
            sentencia = conexion.conectar ( ).createStatement ( );

            resultSet = sentencia.executeQuery ( query );
            if(resultSet.first ()){
                while ( resultSet.next ( ) ) {
                    Persona p = new Persona ( resultSet.getString ( 2 ) , resultSet.getString ( 3 ) , resultSet.getInt ( 4 ) , resultSet.getString ( 1 ) );
                    System.out.println ( p.toString ( ) );
                }
                System.out.println ( "Seleccione que campo desea cambiar: \r\n" +
                                             "1.DNI \r\n" +
                                             "2.Nombre \r\n" +
                                             "3.Apellido \r\n" +
                                             "4.Edad \r\n" );
                int opcion = scanner.nextInt ( );
                switch (opcion) {
                    case 1: {
                        System.out.println ( "Escriba un nuevo DNI: " );
                        String nuevo_dni = scanner.next ( );
                        query = "UPDATE persona SET dni = " + "'" + nuevo_dni + "'" + " WHERE DNI = '" + dni + "'";
                        break;
                    }
                    case 2: {
                        System.out.println ( "Escriba un nuevo nombre: " );
                        String nombre = scanner.next ( );
                        query = "UPDATE persona SET nombre = " + "'" + nombre + "'" + " WHERE DNI = '" + dni + "'";
                        break;
                    }
                    case 3: {
                        System.out.println ( "Escriba un nuevo apellido: " );
                        String apellido = scanner.next ( );
                        query = "UPDATE persona SET apellido = " + "'" + apellido + "'" + " WHERE DNI = '" + dni + "'";
                        break;
                    }
                    case 4: {
                        System.out.println ( "Escriba una nueva edad: " );
                        int edad = scanner.nextInt ( );
                        query = "UPDATE persona SET edad = " + "'" + edad + "'" + " WHERE DNI = '" + dni + "'";
                        break;
                    }
                }

                if (sentencia.executeUpdate ( query ) > 0) {
                    System.out.println ( "Se ha realizado el cambio satisfactoriamente" );
                } else {
                    System.out.println ( "No se ha podido realiazar el cambio" );
                }
            }else{
                System.out.println ("No se ha encontrado el registro!" );
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
        }
    }

    public void listaPersonas ( ) {
        try {

            ResultSet resultSet = null;
            query = "SELECT * FROM persona";
            sentencia = conexion.conectar ( ).createStatement ( );
            resultSet = sentencia.executeQuery ( query );

            while ( resultSet.next ( ) ) {
                Persona p = new Persona ( resultSet.getString ( 2 ) , resultSet.getString ( 3 ) , resultSet.getInt ( 4 ) , resultSet.getString ( 1 ) );
                System.out.println ( p.toString ( ) );

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
        }


    }

    public ArrayList< Persona> listaPersonasDNI ( ) {

        try {
            String    dni       = "12345678E";
            ResultSet resultSet = null;
            ArrayList<Persona> listapersona = new ArrayList <Persona> (  );

            query = "SELECT * FROM persona WHERE dni =" + "'" + dni + "'";
            sentencia = conexion.conectar ( ).createStatement ( );
            resultSet = sentencia.executeQuery ( query );

            while ( resultSet.next ( ) ) {
                Persona p = new Persona ( resultSet.getString ( 2 ) , resultSet.getString ( 3 ) , resultSet.getInt ( 4 ) , resultSet.getString ( 1 ) );
                System.out.println (p.toString () );
                listapersona.add ( p );

            }
                return listapersona;

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
        }
            return null;

    }

    public ArrayList < Persona > detectarMenores ( ) {
        ResultSet             resultSet;
        ArrayList < Persona > listaPersona = new ArrayList < Persona > ( );
        try {


            query = "SELECT * FROM persona WHERE edad < 18";
            sentencia = conexion.conectar ( ).createStatement ( );
            resultSet = sentencia.executeQuery ( query );

            while ( resultSet.next ( ) ) {
                Persona p = new Persona ( resultSet.getString ( 2 ) , resultSet.getString ( 3 ) , resultSet.getInt ( 4 ) , resultSet.getString ( 1 ) );
                System.out.println (p.toString () );
                listaPersona.add ( p );

            }

            return listaPersona;

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
        }
        return null;


    }

    public ArrayList < Persona > detectarJuaneles ( ) {
        ResultSet             resultSet;
        ArrayList < Persona > listaPersona = new ArrayList < Persona > ( );

        try {


            query = "SELECT * FROM persona WHERE nombre LIKE" + "'" + "Juanele" + "'";
            sentencia = conexion.conectar ( ).createStatement ( );


            resultSet = sentencia.executeQuery ( query );
            while ( resultSet.next ( ) ) {
                Persona p = new Persona ( resultSet.getString ( 2 ) , resultSet.getString ( 3 ) , resultSet.getInt ( 4 ) , resultSet.getString ( 1 ) );
                System.out.println (p.toString () );
                listaPersona.add ( p );

            }
            return listaPersona;

        } catch (SQLException throwables) {
            throwables.printStackTrace ( );
            return null;
        }

    }

    public String generarDNI ( ) {

        String dni = new String ( );
        for (int i = 0; i <= 7; i++) {
            int valorEntero = (int) Math.floor ( Math.random ( ) * (9 - 1 + 1) + 1 );
            dni += Integer.toString ( valorEntero );
        }
        int letra_Num = (int) Math.floor ( Math.random ( ) * (122 - 97) + 97 );
        dni += (char) letra_Num;
        System.out.println ( dni.toUpperCase ( ) );
        return dni;


    }


}
