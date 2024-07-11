package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoPorCompraPuntual extends Estacionamiento {
	private int cantidadDeHsCompradas;

	//Constructor
	
	public EstacionamientoPorCompraPuntual(String patente, LocalTime inicio, LocalTime fin, int cantidadDeHsCompradas) {
		super(patente, inicio, fin);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}
	
	//Methods
	
	@Override
	public void finalizarEstacionamiento(Sem sem) {
		sem.finalizarEstacionamiento(this.getPatente());
	}
	
	public int getCantidadDeHsCompradas() {
		return cantidadDeHsCompradas;
	}
	
}
