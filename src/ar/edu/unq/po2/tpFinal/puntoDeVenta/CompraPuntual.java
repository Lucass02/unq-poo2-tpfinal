package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.estacionamiento.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class CompraPuntual extends Compra {
    private double monto;

	@Override
	public void realizarCompra(Estacionamiento estacionamiento, String patente) {
        // Lógica para realizar una compra puntual
        System.out.println("Realizando una compra puntual de: " + monto);
	}
    
}
