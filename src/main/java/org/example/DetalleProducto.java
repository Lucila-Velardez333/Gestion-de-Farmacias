package org.example;

public class DetalleProducto {
	private static int contadorId = 1;
	
    private int idDetalleProducto;
    private int cantidad;
    private float precioUnidad;
    private float total;
    private Producto producto;

    public DetalleProducto(int cantidad, Producto producto) {
        this.idDetalleProducto = ++contadorId;
        this.cantidad = cantidad;
        this.precioUnidad = producto.getPrecio();
        this.total = this.precioUnidad * this.cantidad;
        this.producto = producto;
    }

    public int getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(int idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
