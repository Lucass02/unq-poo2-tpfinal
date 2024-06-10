package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;


public abstract class Compra {
	private int numeroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalDate hora;
	
	//Constructor
	
	public Compra(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora) {
		this.numeroControl = numeroControl;
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	//Methods
	
	//Al hacer una compra con la patente no hace falta que el usuario posea la app, en caso de ser una recarga, se busca al celular mediante la patente.
	public abstract void realizarCompra(PuntoDeVenta puntoDeVenta, String patente);
	
	//Getters y Setters
	
	public int getNumeroControl() {
		return numeroControl;
	}
	
	public void setNumeroControl(int numeroControl) {
		this.numeroControl = numeroControl;
	}
	
	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}
	
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public LocalDate getHora() {
		return hora;
	}
	
	public void setHora(LocalDate hora) {
		this.hora = hora;
	}
	
}
