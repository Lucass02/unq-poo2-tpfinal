package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoPorApp extends Estacionamiento {

	private String celular;

	//Constructor
	
	public EstacionamientoPorApp(String patente, LocalTime inicio, LocalTime fin, String celular) {
		super(patente, inicio, fin);
		this.celular = celular;
	}
	
	//Methods
	
	@Override
	public void finalizarEstacionamiento(Sem sem) {
		sem.finalizarEstacionamientoPorApp(this.getCelular());
	}
	
	//Getters y Setters
	
	public String getCelular() {
		return celular;
	}
}
