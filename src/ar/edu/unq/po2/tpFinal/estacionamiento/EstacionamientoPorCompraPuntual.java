package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

public class EstacionamientoPorCompraPuntual extends Estacionamiento {
	private int cantidadDeHsCompradas;

	//Constructor
	
	public EstacionamientoPorCompraPuntual(String patente, int cantidadDeHsCompradas) {
		super(patente);
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
