package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;
import java.util.ArrayList;
import java.util.List;

public abstract class PuntoDeVenta {
    private int id;
    private ZonaDeEstacionamiento zona;
    private List<Compra> comprasRealizadas;

    public PuntoDeVenta(int id, ZonaDeEstacionamiento zona) {
        this.id = id;
        this.zona = zona;
        this.comprasRealizadas = new ArrayList<Compra>();
    }
        
    public int getId() {
        return id;
    }
    
    public void registrarCompra(Compra compra) {
    	comprasRealizadas.add(compra);
    }
    
    public List<Compra> getComprasRealizadas(){
    	return comprasRealizadas;
    }

    public ZonaDeEstacionamiento getZona() {
        return zona;
    }
    
    public void setId(int id) {
		this.id = id;
	}

	public void setZona(ZonaDeEstacionamiento zona) {
		this.zona = zona;
	}
	
}
