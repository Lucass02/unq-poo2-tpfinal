package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class CompraPuntual extends Compra {
    private int cantidadDeHsCompradas;

    //Constructor
    
	public CompraPuntual(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora,
			int cantidadDeHsCompradas) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}

	//Methods
	
	@Override
	public void realizarCompra(String patente) {
		LocalDateTime horaInicio = LocalDateTime.now();
        this.getPuntoDeVenta().registrarCompra(this);
        this.getPuntoDeVenta().getSem().asignarEstacionamientoPorCompraPuntual(patente, this.getPuntoDeVenta().getZona(), horaInicio, cantidadDeHsCompradas);;
	}


	//Getters y Setters
	
	public double getCantidadDeHsCompradas() {
		return cantidadDeHsCompradas;
	}

	public void setCantidadDeHsCompradas(int cantidadDeHsCompradas) {
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}
	
	
	
}
