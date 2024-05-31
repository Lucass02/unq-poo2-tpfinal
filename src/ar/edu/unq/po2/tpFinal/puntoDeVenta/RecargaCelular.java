package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.estacionamiento.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class RecargaCelular extends Compra {
    private String numeroCelular;
    private double monto;

    public String getNumeroCelular() {
        return numeroCelular;
    }

	public RecargaCelular(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora,
			String numeroCelular, double monto) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		this.numeroCelular = numeroCelular;
		this.monto = monto;
	}

	@Override
	public void realizarCompra(Estacionamiento estacionamiento, String patente) {
        // Lógica para realizar una recarga de celular
        System.out.println("Realizando una recarga al número " + numeroCelular + " de: " + monto);
	}

}
