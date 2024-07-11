package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.appUsuario.AppUsuario;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoPorApp extends Estacionamiento {

	private AppUsuario usuario;

	//Constructor
	
	public EstacionamientoPorApp(String patente, LocalTime inicio, LocalTime fin, AppUsuario usuario) {
		super(patente, inicio, fin);
		this.usuario = usuario;
	}
	
	//Methods
	
	@Override
	public void finalizarEstacionamiento(Sem sem) {
		sem.finalizarEstacionamientoPorApp(this.getUsuario());
	}
	
	//Getters y Setters
	
	public AppUsuario getUsuario() {
		return usuario;
	}
}
