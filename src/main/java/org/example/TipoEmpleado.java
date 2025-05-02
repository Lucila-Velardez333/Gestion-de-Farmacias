package org.example;

public enum TipoEmpleado {
    VENDEDOR("Es el vendedor"),
    COBRADOR("Es cajero"),
    ENCARGADO("Es encargado");

    private final String descripcion;

    TipoEmpleado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "TipoEmpleado{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
