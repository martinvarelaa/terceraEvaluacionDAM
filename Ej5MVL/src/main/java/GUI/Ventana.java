package GUI;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JPanel panel1, panel2;

    public Ventana ( )  {
        this.setSize ( 1270,768 );
        this.setResizable ( true );
        this.setDefaultCloseOperation ( EXIT_ON_CLOSE );
        this.setLocationRelativeTo ( null );
        this.setLayout ( new GridLayout ( 1,2 ) );

        menuBar = new JMenuBar ();
        this.setJMenuBar ( menuBar );

        menu1 = new JMenu ( "Opciones" );
        menuBar.add ( menu1 );

        menu2 = new JMenu ( "Informes" );
        menuBar.add ( menu2 );

        panel1 = new JPanel (  );
        this.add ( panel1 );
        panel1.setLayout ( new GridLayout (1,5  ) );
        panel1.setBackground ( Color.BLACK );

        panel2 = new JPanel (  );
        this.add ( panel2 );
        panel2.setLayout ( new GridLayout ( 1,5 ) );
        panel2.setBackground ( Color.RED );

        





    }
}
