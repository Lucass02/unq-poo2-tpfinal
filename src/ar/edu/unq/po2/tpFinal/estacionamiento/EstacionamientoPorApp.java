package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

public class EstacionamientoPorApp extends Estacionamiento {

	private String celular;

	//Constructor
	
	public EstacionamientoPorApp(String patente, String celular) {
		super(patente);
		this.celular = celular;
	}
	/*LA HORA FIN SE CALCULA POR EL CARGA HASTA EL MAXIMO DE LA FRANJA HORARIA O HASTA DONDE DE*/
	
	//Methods
	
	
	
	//Getters y Setters
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
