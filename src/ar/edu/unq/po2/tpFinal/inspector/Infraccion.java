package ar.edu.unq.po2.tpFinal.inspector;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.estacionamiento.Vehiculo;

public class Infraccion {
    private static int contador = 0;
    private int id;
    private Vehiculo vehiculo;
    private Inspector inspector;
    private LocalDateTime fechaHora;

    public Infraccion(Vehiculo vehiculo, Inspector inspector) {
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
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
