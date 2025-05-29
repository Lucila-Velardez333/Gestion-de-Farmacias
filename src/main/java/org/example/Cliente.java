package org.example;

public class Cliente extends Persona{
    private int idCliente;

    public Cliente(String nombre,String apellido,int dni,int numAfiliado, ObraSocial obraSocial, Domicilio domicilio) {
        super(nombre,apellido,dni,numAfiliado,obraSocial,domicilio);
        this.idCliente = getIdPersona();

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente + super.toString()+
                '}';
    }
}
