package org.example;

public class Persona {
	private static int contador = 1;
	
    private int idPersona;
    private String nombre;
    private String apellido;
    private int dni;
    private int numAfiliado;
    private ObraSocial obraSocial;
    private Domicilio domicilio;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apellido, int dni, int numAfiliado, ObraSocial obraSocial, Domicilio domicilio) {
    	this.idPersona = contador++;
    	this.nombre = nombre;
        this.numAfiliado=numAfiliado;
        this.apellido = apellido;
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.domicilio = domicilio;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public int getNumAfiliado() {
        return numAfiliado;
    }

    public void setNumAfiliado(int numAfiliado) {
        this.numAfiliado = numAfiliado;
    }
    
    public ObraSocial getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(ObraSocial obraSocial) {
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
