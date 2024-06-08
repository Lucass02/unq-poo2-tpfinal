package ar.edu.unq.po2.tpFinal.inspector;

import java.time.LocalDateTime;

public class Infraccion {
    private static int contador = 0;
    private int id;
    private Inspector inspector;
    private LocalDateTime fechaHora;
    private String patente;

    public Infraccion(Inspector inspector, String patente) {
        this.id = ++contador;
        this.inspector = inspector;
        this.patente = patente;
        this.fechaHora = LocalDateTime.now();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

}
