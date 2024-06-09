package ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.inspectorApp.InspectorApp;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.PuntoDeVenta;

public class ZonaDeEstacionamiento {
    private String ubicacion;
    private List<PuntoDeVenta> puntosDeVentas;
    private List<Estacionamiento> estacionamientos;
    private InspectorApp inspector;

    public ZonaDeEstacionamiento(String ubicacion, InspectorApp inspector) {
        this.ubicacion = ubicacion;
        this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
        this.inspector = inspector;
    }
    
    public void agregarInspector(InspectorApp inspector) {
    	inspector.agregarAZona(this);
    	this.inspector = inspector;
    }
    
    public void agregarPuntoVenta(PuntoDeVenta puntoDeVenta) {
    	puntosDeVentas.add(puntoDeVenta);
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

	public InspectorApp getInspector() {
		return inspector;
	}

	public void setInspector(InspectorApp inspector) {
		this.inspector = inspector;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

}