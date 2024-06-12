package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

public abstract class Estacionamiento {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private String patente;

    public Estacionamiento(String patente) {
        this.patente = patente;
        this.inicio = LocalDateTime.now();
    }
    /* Getters y Setters*/

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
