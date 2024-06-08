package ar.edu.unq.po2.tpFinal.inspector;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Inspector {
    private int id;
    private String nombre;
    private ZonaDeEstacionamiento zona;

    public Inspector(int id, String nombre, ZonaDeEstacionamiento zona) {
        this.id = id;
        this.nombre = nombre;
        this.zona = zona;
    }
    public void verificarZona() {
        this.zona.estacionamientosActivos.stream().filter(estacionamiento -> !estacionamiento.estaVigente())
        										  .registrarInfraccion(this,estacionamiento.getPatente());
    }
    
    public boolean verificarEstacionamiento(Sem sem, String patente) {
        return sem.estacionamientoVigente(patente);
    }

    private void registrarInfraccion(Sem sem, String patente) {
        Infraccion infraccion = new Infraccion(this, patente);
        sem.registrarInfraccion(infraccion);
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
