package org.example;

public class Domicilio {
	private static int contadorId = 0;
	
    private int idDomicilio;
    private String calle;
    private String localidad;
    private String provincia;

    public Domicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio(String calle, String localidad, String provincia) {
        this.calle = calle;
        this.idDomicilio = ++contadorId;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio +
                ", calle='" + calle + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }


}
