package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class RecargaCelular extends PuntoDeVenta {
    private String numeroCelular;
    private double monto;

    public RecargaCelular(int id, String direccion, ZonaDeEstacionamiento zona, String numeroCelular, double monto) {
        super(id, direccion, zona);
        this.numeroCelular = numeroCelular;
        this.monto = monto;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    @Override
    public void realizarTransaccion() {
        // Lógica para realizar una recarga de celular
        System.out.println("Realizando una recarga al número " + numeroCelular + " de: " + monto);
    }
}
