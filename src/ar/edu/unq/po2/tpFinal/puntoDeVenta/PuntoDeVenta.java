package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;
import java.util.ArrayList;
import java.util.List;

public class PuntoDeVenta {
    private int id;
    private ZonaDeEstacionamiento zona;
    private Sem sem;
	private List<Compra> comprasRealizadas;

	//Constructor
	
    public PuntoDeVenta(int id, ZonaDeEstacionamiento zona) {
        this.id = id;
        this.zona = zona;
        this.comprasRealizadas = new ArrayList<Compra>();
    }
        
    //Methods
    
    public void registrarCompra(Compra compra) {
    	comprasRealizadas.add(compra);
    }
    
    //Getters y Setters
    
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
	

    public Sem getSem() {
		return sem;
	}

	public void setSem(Sem sem) {
		this.sem = sem;
	}

	  public int getId() {
	        return id;
	    }
	    
	
}
