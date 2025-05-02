package org.example;

public class Producto {
    private String codigoProducto;
    public TipoProducto tipoProducto;
    public String descripcion;
    public String nombreLaboratorio;
    public float precio;

    public Producto() {
    }

    public Producto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Producto(String codigoProducto, TipoProducto tipoProducto, String descripcion, String nombreLaboratorio, float precio) {
        this.codigoProducto = codigoProducto;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.nombreLaboratorio = nombreLaboratorio;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigoProducto + '\'' +
                ", esMedicamento=" + tipoProducto +
                ", descripcion='" + descripcion + '\'' +
                ", nombreLaboratorio='" + nombreLaboratorio + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String getCodigo() {
        return codigoProducto;
    }

    public void setCodigo(String codigo) {
        this.codigoProducto = codigo;
    }

    public TipoProducto isEsMedicamento() {
        return tipoProducto;
    }

    public void setEsMedicamento(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
