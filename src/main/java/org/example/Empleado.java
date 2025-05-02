package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private int cuil;
    private Persona empleado;
    private Sucursal sucursal;
    private List<TipoEmpleado> roles = new ArrayList<TipoEmpleado>();

    public Empleado(Persona empleado, int cuil, Sucursal sucursal, List<TipoEmpleado> roles) {
        this.empleado = empleado;
        this.cuil = cuil;
        this.sucursal = sucursal;
        this.roles = new ArrayList<>();
    }

    public int getCuil() {
        return cuil;
    }

    public Persona getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Persona empleado) {
        this.empleado = empleado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<TipoEmpleado> getRoles() {
        return roles;
    }


}
