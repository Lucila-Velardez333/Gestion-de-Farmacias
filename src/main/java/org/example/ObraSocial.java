package org.example;

public class ObraSocial {
	private static int contadorId = 0; 
    private int idObraSocial;
    private String nombre;


    public ObraSocial() {
    }

    public ObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public ObraSocial(String nombre) {
        this.nombre = nombre;
        this.idObraSocial = ++contadorId;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdObraSocial() {
        
        return idObraSocial;
    }



    @Override
    public String toString() {
        return "ObraSocial{" +
                "idObraSocial=" + idObraSocial +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
