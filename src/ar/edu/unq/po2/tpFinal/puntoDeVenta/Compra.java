package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalTime;


public abstract class Compra {
	private int numeroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalTime hora;
	
	//Constructor
	
	public Compra(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalTime hora) {
		this.numeroControl = numeroControl;
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	//Methods
	
	//Al hacer una compra con la patente no hace falta que el usuario posea la app, en caso de ser una recarga, se busca al celular mediante la patente.
	public abstract void realizarCompra(String patente);
	
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
