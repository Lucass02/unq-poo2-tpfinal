package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.estacionamiento.Usuario;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class CompraPuntual extends Compra {
    private double cantidadDeHsCompradas;

	public CompraPuntual(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora,
			double cantidadDeHsCompradas) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}

	@Override
	public void realizarCompra(Sem sem, PuntoDeVenta puntoDeVenta, Usuario usuario) {
		//Logica para registrar la compra dentro del punto de venta
        puntoDeVenta.registrarCompra(this);
        
        // Lógica para realizar una compra puntual desde sem
        sem.asignarEstacionamiento(puntoDeVenta.getZona(), usuario, cantidadDeHsCompradas);
        
	}
    
}
