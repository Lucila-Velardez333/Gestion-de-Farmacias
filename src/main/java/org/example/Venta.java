package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String numTicket;
    private LocalDate fecha;
    private float totalVenta;
    private int puntoDeVenta;
    private FormaDePago formaDePago;
    private Persona cliente;
    private Empleado empleadoAtencion;
    private Empleado empleadoCobro;
    //private DetalleProducto detalleProducto;
    private List<DetalleProducto> productos;
    private Sucursal sucursal;
    private int pago;
    
    public Venta(String numTicket) {
        this.numTicket = numTicket;
    }
    
 

    public Venta(LocalDate fecha, float totalVenta, FormaDePago formaDePago, Persona cliente, Empleado empleadoAtencion, Empleado empleadoCobro, Sucursal sucursal, int pago) {
        
    	//Sucursal sucursal = empleadoAtencion.getSucursal();
    	this.productos = new ArrayList<DetalleProducto>();
    	this.fecha = fecha;
        this.numTicket = sucursal.generarNumeroTicket();
        this.totalVenta = totalVenta;
        this.puntoDeVenta = sucursal.getIdSucursal();
        this.formaDePago = formaDePago;
        this.cliente = cliente;
        this.empleadoAtencion = empleadoAtencion;
        //recorrer lista roles para asignar cual es el de atencion o cajero
        this.empleadoCobro = empleadoCobro;
        //this.detalleProducto = detalleProducto;
        this.sucursal = sucursal;
        this.setPago(pago);
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getPuntoDeVenta() {
        return puntoDeVenta;
    }

    public void setPuntoDeVenta(int puntoDeVenta) {
        this.puntoDeVenta = puntoDeVenta;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleadoAtencion() {
        return empleadoAtencion;
    }

    public void setEmpleadoAtencion(Empleado empleadoAtencion) {
        //recorrer lista roles para asignar cual es el de atencion o cajero

        this.empleadoAtencion = empleadoAtencion;
    }

    public Empleado getEmpleadoCobro() {
        return empleadoCobro;
    }

    public void setEmpleadoCobro(Empleado empleadoCobro) {
        //recorrer lista roles para asignar cual es el de atencion o cajero

        this.empleadoCobro = empleadoCobro;
    }
/*
    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }
*/


	public Sucursal getSucursal() {
		return sucursal;
	}



	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}



	public List<DetalleProducto> getProductos() {
		return productos;
	}



	public void setProductos(List<DetalleProducto> productos) {
		this.productos = productos;
	}



	public int getPago() {
		return pago;
	}



	public void setPago(int pago) {
		this.pago = pago;
	}
}
