package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public abstract class PuntoDeVenta {
    private int id;
    private String direccion;
    private ZonaDeEstacionamiento zona;

    public PuntoDeVenta(int id, String direccion, ZonaDeEstacionamiento zona) {
        this.id = id;
        this.direccion = direccion;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public ZonaDeEstacionamiento getZona() {
        return zona;
    }
    
    public void setId(int id) {
		this.id = id;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setZona(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}
	
	public abstract void realizarTransaccion();
	
}
