package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstacionamientoPorCompraPuntual extends Estacionamiento {
	private int cantidadDeHsCompradas;

	//Constructor
	
	public EstacionamientoPorCompraPuntual(String patente, ZonaDeEstacionamiento zona, LocalDateTime inicio, int cantidadDeHsCompradas) {
		super(patente, zona, inicio);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}
	
	//Methods

	@Override
	public void iniciarEstacionamiento() {
		super.iniciarEstacionamiento();
		this.setFin(calcularFinEstacionamiento());
	}
	
	public LocalDateTime calcularFinEstacionamiento() {
		return this.getInicio().plusHours(this.cantidadDeHsCompradas);
	}
	
	//Getters y Setters
	
	public double getCantidadDeHsCompradas() {
		return cantidadDeHsCompradas;
	}	

	public void setCantidadDeHsCompradas(int cantidadDeHsCompradas) {
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}
	
	
}
