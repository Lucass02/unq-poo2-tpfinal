package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PuntoDeVenta {
    private int id;
    private ZonaDeEstacionamiento zona;
    private Sem sem;
	private List<Compra> comprasRealizadas;

	//Constructor
	
    public PuntoDeVenta(int id, ZonaDeEstacionamiento zona, Sem sem) {
        this.id = id;
        this.zona = zona;
        this.sem = sem;
        this.comprasRealizadas = new ArrayList<Compra>();
    }
        
    //Methods
    public void RecargaCelular(String celular, double monto) {
    	Compra compra = new RecargaCelular(this, LocalDate.now(), LocalTime.now(), monto);
    	comprasRealizadas.add(compra);
    	sem.recargarSaldo(celular, monto, compra);
    }
    
    public void CompraEstacionamiento(String patente, int horasCompradas) {
    	Compra compra = new CompraPuntual(this, LocalDate.now(), LocalTime.now(), horasCompradas);
    	comprasRealizadas.add(compra);
    	sem.iniciarEstacionamientoCompraPuntual(zona, patente, horasCompradas);
    }
    
    //Getters y Setters
    
    public List<Compra> getComprasRealizadas(){
    	return comprasRealizadas;
    }

    public ZonaDeEstacionamiento getZona() {
        return zona;
    }

    public Sem getSem() {
		return sem;
	}

	  public int getId() {
	        return id;
	}
	    
	
}
