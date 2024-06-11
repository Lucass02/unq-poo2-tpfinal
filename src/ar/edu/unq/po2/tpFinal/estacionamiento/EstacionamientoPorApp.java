package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class EstacionamientoPorApp extends Estacionamiento {

	private String celular;

	//Constructor
	
	public EstacionamientoPorApp(String patente, ZonaDeEstacionamiento zona, LocalDateTime inicio,
			String celular) {
		super(patente, zona, inicio);
		this.celular = celular;
	}

	
	//Methods
	
	
	
	//Getters y Setters
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
