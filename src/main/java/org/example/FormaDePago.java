package org.example;

public enum FormaDePago {
    EFECTIVO("pago en EFECTIVO"),
    TRANSFERENCIA("pago por TRANSFERENCIA"),
    TARJETA_DE_CREDITO("pago con Tarjeta");

    private final String mensaje;

    FormaDePago(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "FormaDePago{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }

    public String getMensaje() {
        return mensaje;
    }

}
