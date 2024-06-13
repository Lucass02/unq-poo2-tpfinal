package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalTime;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public abstract class Estacionamiento {
    private LocalTime inicio;
    private LocalTime fin;
    private String patente;
    
    public Estacionamiento(String patente, LocalTime inicio, LocalTime fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.patente = patente;
	}

    public abstract void finalizarEstacionamiento(Sem sem);
    
	/* Getters y Setters*/

	public LocalTime getInicio() {
		return inicio;
	}

	public LocalTime getFin() {
		return fin;
	}
	
	public String getPatente() {
		return patente;
	}
}
