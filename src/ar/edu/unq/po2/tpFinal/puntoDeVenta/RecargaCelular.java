package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;



public class RecargaCelular extends Compra {
	
	private double monto;
	
	//Constructor
	
	public RecargaCelular(PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalTime hora, double monto) {
		super(puntoDeVenta, fecha, hora);
		this.monto = monto;
	}

    

	
	//Getters y Setters
    
	public double getMonto() {
		return monto;
	}

}
