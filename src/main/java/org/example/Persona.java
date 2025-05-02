package org.example;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private int dni;
    private ObraSocial obraSocial;
    private Domicilio domicilio;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, int idPersona, String apellido, int dni, ObraSocial obraSocial, Domicilio domicilio) {
        this.nombre = nombre;
        this.idPersona = idPersona;//auto incremental
        this.apellido = apellido;
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ObraSocial getNumAfiliado() {
        return obraSocial;
    }

    public void setNumAfiliado(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", obra social=" + obraSocial +
                ", domicilio=" + domicilio +
                '}';
    }
}
