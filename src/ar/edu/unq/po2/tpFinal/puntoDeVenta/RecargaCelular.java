package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;



public class RecargaCelular extends Compra {
	
	private double monto;
	
	//Constructor
	
	public RecargaCelular(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalTime hora, double monto) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		this.monto = monto;
	}

    //Methods
    
	@Override
	public void realizarCompra(String patente) {
		this.getPuntoDeVenta().registrarCompra(this);
		this.getPuntoDeVenta().getSem().recargarSaldo(monto, patente);;
	}

	
	//Getters y Setters
    
	public double getMonto() {
		return monto;
	}

}
