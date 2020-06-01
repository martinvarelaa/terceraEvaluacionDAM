package GUI;


import Conexion.Conexion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;


public class Dialogo extends JDialog {
    private Ventana ventana;

    public Dialogo ( ) {

        this.setSize ( 400 , 300 );
        this.setDefaultCloseOperation ( DISPOSE_ON_CLOSE );
        this.setLayout ( new GridLayout ( 3 , 0 ) );
        this.setTitle ( "Escoja la Base de Datos" );
        this.setResizable ( false );
        this.setLocationRelativeTo ( null );


        JPanel panel1 = new JPanel ( );
        panel1.setLayout ( new FlowLayout ( ) );
        panel1.setBorder ( new EmptyBorder ( 30 , 20 , 0 , 0 ) );

        JPanel panel2 = new JPanel ( );
        panel2.setLayout ( new FlowLayout ( ) );

        JPanel panel3 = new JPanel ( );
        panel3.setLayout ( new FlowLayout ( ) );


        JLabel     usuario_lbl = new JLabel ( "Usuario: " );
        JTextField usuario_txt = new JTextField ( );
        usuario_txt.setPreferredSize ( new Dimension ( 180 , 30 ) );


        JLabel     contraseña_lbl = new JLabel ( "Contraseña: " );
        JTextField contraseña_txt = new JTextField ( );
        contraseña_txt.setPreferredSize ( new Dimension ( 180 , 30 ) );

        JButton aceptar_btn  = new JButton ( "Aceptar" );
        JButton cancelar_btn = new JButton ( "Cancelar" );


        panel1.add ( usuario_lbl );
        panel1.add ( usuario_txt );

        panel2.add ( contraseña_lbl );
        panel2.add ( contraseña_txt );

        panel3.add ( aceptar_btn );
        panel3.add ( cancelar_btn );


        this.add ( panel1 );
        this.add ( panel2 );
        this.add ( panel3 );


        this.revalidate ( );

        aceptar_btn.addActionListener ( actionEvent -> {
            if (usuario_txt.getText ( ).equals ( "" )) {

                showMessageDialog ( this , "Introduce los datos correctamente" , "Error" , JOptionPane.WARNING_MESSAGE );

            } else {

                Conexion conexion = new Conexion ( );
                conexion.setUsuario ( usuario_txt.getText ( ) );
                conexion.setContraseña ( contraseña_txt.getText ( ) );

                if (conexion.conectar ( ) != null && ventana == null) {
                    this.setVisible ( false );
                    ventana = new Ventana ( );
                    ventana.setVisible ( true );
                }else if (conexion.conectar () != null && ventana != null){
                    ventana.setVisible ( true );
                    this.setVisible ( false );
                }
            }
        } );

        cancelar_btn.addActionListener ( actionEvent -> {
            System.exit ( 0 );
        } );

        //Al pulsar intro que se meta en la BBDD!

    }
}
