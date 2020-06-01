package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String BD = "acme?serverTimezone=Europe/Madrid";
    private String usuario;
    private String contraseña;
    private Connection conexion;

    public Conexion() {




    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL + BD, usuario, contraseña);
            if (conexion != null){
                System.out.println("Conexion exitosa");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return conexion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
