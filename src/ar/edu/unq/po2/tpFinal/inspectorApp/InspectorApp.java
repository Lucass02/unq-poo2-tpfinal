package ar.edu.unq.po2.tpFinal.inspectorApp;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class InspectorApp {
    private String nombre;
    private ZonaDeEstacionamiento zona;

    public InspectorApp(String nombre, ZonaDeEstacionamiento zona) {
        this.nombre = nombre;
        this.zona = zona;
    }
    /*
    public void verificarZona(Sem sem) {
        this.zona.getEstacionamientos().stream().filter(estacionamiento -> !estacionamiento.estaVigente())
        										.registrarInfraccion(sem, estacionamiento.getPatente());
    }
    */
    public boolean verificarEstacionamiento(Sem sem, String patente) {
        return sem.estacionamientoVigente(patente);
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ZonaDeEstacionamiento getZona() {
		return zona;
	}

	public void setZona(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}

}
