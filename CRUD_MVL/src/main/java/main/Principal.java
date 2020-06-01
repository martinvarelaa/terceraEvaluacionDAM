package main;

import PersonaCRUD.Persona_CRUD;

import java.util.Scanner;

public class Principal {
    public static void main (String[] args) {


        Scanner sc = new Scanner ( System.in );
        Persona_CRUD crud = new Persona_CRUD ( );
        while ( true ) {
            System.out.print ( "1.Crear a Martín (Si no existe aún)\r\n" +
                                       "2.Generar un DNI aleatorio \r\n" +
                                       "3.Listar personas de la Base de Datos \r\n" +
                                       "4.Eliminar persona de la Base de Datos \r\n" +
                                       "5.Detectar Juaneles \r\n" +
                                       "6.Detectar menores de edad \r\n" +
                                       "7.Cambiar persona \r\n" +
                                       "8.Buscar persona con DNI 11111111E \r\n" +
                                       "9.Salir\r\n" +
                                       "......................................................\r\n" +
                                       "Seleccione una opción: " );

            int opcion = sc.nextInt ( );

            switch (opcion) {
                case 1: {
                    crud.crearPersonaMartin ( );
                    break;
                }
                case 2: {
                    crud.generarDNI ( );
                    break;
                }
                case 3: {
                    crud.listaPersonas ( );
                    break;
                }
                case 4: {
                    crud.eliminarPersona ( );
                    break;
                }
                case 5: {
                    crud.detectarJuaneles ( );
                    break;
                }
                case 6: {
                    crud.detectarMenores ( );
                    break;
                }
                case 7: {
                    crud.cambiarPersona ( );
                    break;
                }
                case 8: {
                    crud.listaPersonasDNI ();
                }case 9:{
                    System.exit ( 0 );
                }
            }
        }

    }


}

