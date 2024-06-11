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

    public ZonaDeEstacionamiento(String ubicacion) {
        this.ubicacion = ubicacion;
        this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
        this.estacionamientos = new ArrayList<Estacionamiento>();
        this.inspector = null;
    }
    
    public void agregarInspector(InspectorApp inspector) {
    	inspector.agregarAZona(this);
    	this.inspector = inspector;
    }
    
    public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
    	puntosDeVentas.add(puntoDeVenta);
    }
    
    public void iniciarEstacionamiento(String patente) {
    	Estacionamiento estacionamiento = new Estacionamiento(patente);
    	this.estacionamientos.add(estacionamiento);
    }
    
    public void finEstacionamiento(String patente) {
    	Estacionamiento estacionamiento = encontrarEstacionamiento(patente);
    	this.estacionamientos.remove(estacionamiento);
    }
    
    public Estacionamiento encontrarEstacionamiento(String patente) {
    	return estacionamientos.stream()
				               .filter(e -> e.getPatente().equals(patente))
				               .findFirst()
				               .orElseThrow(() -> new RuntimeException("No se encontró un Estacionamiento con el usuario dado."));
    }
    
	public String getUbicacion() {
		return ubicacion;
	}

	public List<PuntoDeVenta> getPuntosDeVentas() {
		return puntosDeVentas;
	}

	public InspectorApp getInspector() {
		return inspector;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

}