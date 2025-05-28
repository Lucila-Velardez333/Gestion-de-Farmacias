package org.example;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class Sucursal {
    private int idSucursal;
    private Domicilio domicilio;
    private Empleado encargado;
    @JsonManagedReference
    private List<Empleado> empleados;

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
