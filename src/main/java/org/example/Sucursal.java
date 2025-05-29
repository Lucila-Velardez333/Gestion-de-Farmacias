package org.example;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class Sucursal {
	private static int contadorSucursales = 0;
    private int idSucursal;
    private Domicilio domicilio;
    private Empleado encargado;
    @JsonManagedReference
    private List<Empleado> empleados;
    private int contadorTickets = 0;

    public Sucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(Empleado encargado, Domicilio domicilio) {
        this.empleados = new ArrayList<Empleado>();
        this.encargado = encargado;//recorrer lista de roles y asignar cual el es el encargado
        this.domicilio = domicilio;
        this.idSucursal = ++contadorSucursales;
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
        if(encargado.getRoles().contains(TipoEmpleado.ENCARGADO)) {
            this.encargado = encargado;
        } else {
            throw new IllegalArgumentException("El empleado " + encargado.getNombre() + " " + encargado.getApellido() + " no tiene rol de encargado");
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    
    public synchronized String generarNumeroTicket() {
        contadorTickets++;
        return String.format("%04d-%08d", idSucursal, contadorTickets);
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
