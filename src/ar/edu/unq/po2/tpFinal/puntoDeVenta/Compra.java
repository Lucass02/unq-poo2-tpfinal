package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class Compra {
	private int numeroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalTime hora;
	
	//Constructor
	
	public Compra(PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalTime hora) {
		this.numeroControl += 1;
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	//Getters y Setters
	
	public int getNumeroControl() {
		return numeroControl;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
	
	public LocalTime getHora() {
		return hora;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	
}
