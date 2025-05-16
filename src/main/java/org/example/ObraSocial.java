package org.example;

public class ObraSocial {
    private int idObraSocial;
    private String nombre;


    public ObraSocial() {
    }

    public ObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public ObraSocial(String nombre, int idObraSocial, int numAfiliado) {
        this.nombre = nombre;
        this.idObraSocial = idObraSocial;//auto incremental
        this.numAfiliado = numAfiliado;
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

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public int getNumAfiliado() {
        return numAfiliado;
    }

    public void setNumAfiliado(int numAfiliado) {
        this.numAfiliado = numAfiliado;
    }

    @Override
    public String toString() {
        return "ObraSocial{" +
                "idObraSocial=" + idObraSocial +
                ", nombre='" + nombre + '\'' +
                ", numAfiliado=" + numAfiliado +
                '}';
    }
}
