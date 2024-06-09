package ar.edu.unq.po2.tpFinal.inspectorApp;

import java.time.LocalDateTime;

public class Infraccion {
    private static int contador = 0;
    private int id;
    private InspectorApp inspector;
    private LocalDateTime fechaHora;
    private String patente;

    public Infraccion(InspectorApp inspector, String patente) {
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

	public InspectorApp getInspector() {
		return inspector;
	}

	public void setInspector(InspectorApp inspector) {
		this.inspector = inspector;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

}
