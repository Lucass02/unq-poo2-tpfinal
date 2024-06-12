package ar.edu.unq.po2.tpFinal.inspectorApp;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class InspectorApp {
    private String nombre;
    private ZonaDeEstacionamiento zona;

    public InspectorApp(String nombre) {
        this.nombre = nombre;
        this.zona = null;
    }
    
    public boolean verificarEstacionamiento(Sem sem, String patente) {
    	boolean elEstacionamientoEstaVigente = sem.estacionamientoVigente(patente);
        if (elEstacionamientoEstaVigente) {
        	registrarInfraccion(sem,patente);
        }
        return elEstacionamientoEstaVigente;
    }
    
    public void registrarInfraccion(Sem sem, String patente) {
        Infraccion infraccion = new Infraccion(this, patente);
        sem.registrarInfraccion(infraccion);
    }
    
    public void agregarAZona(ZonaDeEstacionamiento zona) {
    	this.zona = zona;
    }
    
	public String getNombre() {
		return nombre;
	}
	
	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

}
