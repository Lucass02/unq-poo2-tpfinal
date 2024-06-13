package ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.puntoDeVenta.PuntoDeVenta;

public class ZonaDeEstacionamiento {
    private String ubicacion;
    private List<PuntoDeVenta> puntosDeVentas;
    private InspectorApp inspector;

    public ZonaDeEstacionamiento(String ubicacion) {
        this.ubicacion = ubicacion;
        this.puntosDeVentas = new ArrayList<PuntoDeVenta>();
        this.inspector = null;
    }
    
    public void agregarInspector(InspectorApp inspector) {
    	this.inspector = inspector;
    	inspector.agregarAZona(this);
    }
    
    public void agregarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
    	puntosDeVentas.add(puntoDeVenta);
    }
    
    public void quitarPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
    	puntosDeVentas.remove(puntoDeVenta);
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

}