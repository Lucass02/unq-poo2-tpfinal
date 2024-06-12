package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Estacionamiento {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private String patente;
	private EstadoEstacionamiento estado;

    public Estacionamiento(String patente) {
        this.patente = patente;
        this.inicio = LocalDateTime.now();
        this.estado = new EstacionamientoIniciado();
    }
    /* Métodos */
    
    public void iniciarEstacionamiento() {
    	this.estado.iniciarEstacionamiento(this);
	}

	public void finalizarEstacionamiento() {
		this.estado.finalizarEstacionamiento(this);
	}  
    
	public boolean estaVigente() {
	    return this.estado.estaVigente(this);
	}
	
    /* Getters y Setters*/
	
	public void setEstado(EstadoEstacionamiento estadoActual) {
		this.estado = estadoActual;
	}

	public EstadoEstacionamiento getEstado() {
		return estado;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
}
