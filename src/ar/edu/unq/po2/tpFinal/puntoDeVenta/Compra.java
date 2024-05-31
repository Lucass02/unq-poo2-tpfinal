package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.estacionamiento.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;

public abstract class Compra {
	private int numeroControl;
	private PuntoDeVenta puntoDeVenta;
	private LocalDate fecha;
	private LocalDate hora;
	
	public Compra(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora) {
		this.numeroControl = numeroControl;
		this.puntoDeVenta = puntoDeVenta;
		this.fecha = fecha;
		this.hora = hora;
	}
	
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
	
	public abstract void realizarCompra(Estacionamiento estacionamiento, String patente);
	public abstract void realizarCompra(AppUsuario appUsuario);
}
