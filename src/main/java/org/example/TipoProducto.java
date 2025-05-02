package org.example;

public enum TipoProducto {
    MEDICAMENTO("Compro Medicamento"),
    PERFUMERIA("Compro productos en Perfumeria");

    private final String respuesta;

    private TipoProducto(String eleccion){
        this.respuesta= eleccion;
    }
    public String getDescripcionDeRespuesta(){
        return respuesta;
    }
}
