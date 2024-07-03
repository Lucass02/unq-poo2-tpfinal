package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;


public class CompraPuntual extends Compra {
    private int cantidadDeHsCompradas;

    //Constructor
    
	public CompraPuntual(PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalTime hora,
			int cantidadDeHsCompradas) {
		super(puntoDeVenta, fecha, hora);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}

	//Getters y Setters
	
	public double getCantidadDeHsCompradas() {
		return cantidadDeHsCompradas;
	}
	
}
