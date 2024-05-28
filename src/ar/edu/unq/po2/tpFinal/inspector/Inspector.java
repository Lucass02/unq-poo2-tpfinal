package ar.edu.unq.po2.tpFinal.inspector;

import ar.edu.unq.po2.tpFinal.estacionamiento.Vehiculo;
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

    public void verificarEstacionamiento(Vehiculo vehiculo, Sem sem) {
        boolean estacionamientoValido = sem.consultarEstacionamiento(vehiculo.getPatente());
        if (!estacionamientoValido) {
            registrarInfraccion(vehiculo, sem);
        }
    }

    private void registrarInfraccion(Vehiculo vehiculo, Sem sem) {
        Infraccion infraccion = new Infraccion(vehiculo, this);
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
