package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona{
    private int cuil;
    private Sucursal sucursal;
    private List<TipoEmpleado> roles = new ArrayList<TipoEmpleado>();

    public Empleado(String nombre,String apellido,int dni,int numAfiliado, ObraSocial obraSocial, Domicilio domicilio, int cuil, Sucursal sucursal, List<TipoEmpleado> roles) {
        super(nombre,apellido,dni,numAfiliado,obraSocial,domicilio);
        this.cuil = cuil;
        this.sucursal = sucursal;
        this.roles = new ArrayList<>();
    }

    public int getCuil() {
        return cuil;
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
