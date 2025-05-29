package org.example;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

public class Empleado extends Persona{
    private String cuil;
    @JsonBackReference
    private Sucursal sucursal;
    private List<TipoEmpleado> roles = new ArrayList<TipoEmpleado>();

    public Empleado(String nombre,String apellido,int dni,int numAfiliado, ObraSocial obraSocial, Domicilio domicilio, String cuil, Sucursal sucursal, List<TipoEmpleado> roles) {
        super(nombre,apellido,dni,numAfiliado,obraSocial,domicilio);
        this.cuil = cuil;
        this.sucursal = sucursal;
        this.roles = roles;
    }

    public String getCuil() {
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
