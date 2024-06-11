package ar.edu.unq.po2.tpFinal.inspectorApp;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Infraccion {
    private InspectorApp inspector;
    private LocalDateTime fechaHora;
    private String patente;
    private ZonaDeEstacionamiento zona;

	public Infraccion(InspectorApp inspector, String patente) {
        this.inspector = inspector;
        this.fechaHora = LocalDateTime.now();
        this.patente = patente;
        this.zona = inspector.getZona();
    }

	public String getPatente() {
		return patente;
	}

	public InspectorApp getInspector() {
		return inspector;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

    public ZonaDeEstacionamiento getZona() {
		return zona;
	}
}
