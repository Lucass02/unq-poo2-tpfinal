package ar.edu.unq.po2.tpFinal.inspector;

import java.time.LocalDateTime;

public class Infraccion {
    private static int contador = 0;
    private int id;
    private String vehiculo;
    private Inspector inspector;
    private LocalDateTime fechaHora;

    public Infraccion(String vehiculo, Inspector inspector) {
        this.id = ++contador;
        this.vehiculo = vehiculo;
        this.inspector = inspector;
        this.fechaHora = LocalDateTime.now();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
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
