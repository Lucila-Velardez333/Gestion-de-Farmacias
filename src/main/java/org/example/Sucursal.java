package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private int idSucursal;
    private Domicilio domicilio;
    private Empleado encargado;
    private List<Empleado> empleados;
    //private List<Venta> ventas= new ArrayList<>(); //VER
    //chequear si dejar la variable de ventas para saber cuantas ventas tiene
    //si lo dejamos debemos combrobar en ventas si coinciden los empleados cobrador y vendedor
    // si coinciden se agrega a la lista

    public Sucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(Empleado encargado, Domicilio domicilio, int idSucursal) {
        this.empleados = new ArrayList<Empleado>();
        this.encargado = encargado;//recorrer lista de roles y asignar cual el es el encargado
        this.domicilio = domicilio;
        this.idSucursal = idSucursal;//debe ser autoincremental
    }

    public int getIdSucursal() {

        return idSucursal;
    }


    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Empleado getEncargado() {

        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }


    @Override
    public String toString() {
        return "Sucursal{" +
                "idSucursal=" + idSucursal +
                ", domicilio=" + domicilio +
                ", encargado=" + encargado +
                ", empleados=" + empleados +
                '}';
    }
}
