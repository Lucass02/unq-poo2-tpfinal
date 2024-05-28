package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class CompraPuntual extends PuntoDeVenta {
    private double monto;

    public CompraPuntual(int id, String direccion, ZonaDeEstacionamiento zona, double monto) {
        super(id, direccion, zona);
        this.monto = monto;
    }

    @Override
    public void realizarTransaccion() {
        // Lógica para realizar una compra puntual
        System.out.println("Realizando una compra puntual de: " + monto);
    }
}
