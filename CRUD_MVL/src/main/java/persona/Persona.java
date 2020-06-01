package persona;

import java.util.Objects;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

    public Persona (String nombre , String apellido , int edad , String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad &&
                Objects.equals ( nombre , persona.nombre ) &&
                Objects.equals ( apellido , persona.apellido ) &&
                dni.equals ( persona.dni );
    }


    public String getNombre ( ) {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getApellido ( ) {
        return apellido;
    }

    public void setApellido (String apellido) {
        this.apellido = apellido;
    }

    public int getEdad ( ) {
        return edad;
    }

    public void setEdad (int edad) {
        this.edad = edad;
    }

    public String getDni ( ) {
        return dni;
    }

    public void setDni (String dni) {
        this.dni = dni;
    }

    @Override
    public String toString ( ) {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }
}
