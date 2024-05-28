package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalDateTime;

public class Evento {
    private String tipo;
    private String patente;
    private String celular;
    private LocalDateTime fechaYHora;

    public Evento(String tipo, String patente, String celular) {
        this.tipo = tipo;
        this.patente = patente;
        this.celular = celular;
        this.fechaYHora = LocalDateTime.now();
    }

    public void notificar() {
        // Lógica para notificar el evento
        System.out.println("Evento " + tipo + " notificado para patente " + patente + " y celular " + celular);
    }

    public String getTipo() {
        return tipo;
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
