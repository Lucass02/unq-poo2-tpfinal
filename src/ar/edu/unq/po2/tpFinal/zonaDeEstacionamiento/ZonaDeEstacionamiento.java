package ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.inspector.Inspector;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.PuntoDeVenta;

public class ZonaDeEstacionamiento {
    private int id;
    private String nombre;
    private String ubicacion;
    private List<PuntoDeVenta> puntosDeVentas;
    private List<Inspector> inspectores;

    public ZonaDeEstacionamiento(int id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
        this.inspectores = new ArrayList<Inspector>();
    }

    public void agregarPuntoVenta(PuntoDeVenta puntoDeVenta) {
    	puntosDeVentas.add(puntoDeVenta);
    }

    public void agregarInspector(Inspector inspector) {
        inspectores.add(inspector);
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<PuntoDeVenta> getPuntosDeVentas() {
		return puntosDeVentas;
	}

	public List<Inspector> getInspectores() {
		return inspectores;
	}

}