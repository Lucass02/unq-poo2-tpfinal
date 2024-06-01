package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class Usuario {
    private int id;
    private String nombre;
    private String celular;
    private String patente;
	private double credito;

    public Usuario(int id, String nombre, String celular, String patente) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.credito = 0;
        this.patente = patente;
    }
	
    public void iniciarEstacionamiento(String patente, Sem sem) {
        sem.iniciarEstacionamiento(patente, this.celular);
    }

    public void finalizarEstacionamiento(String patente, Sem sem) {
        sem.finalizarEstacionamiento(patente, this.celular);
    }

    public double consultarSaldo() {
        return this.credito;
    }

    public void recargarCredito(double monto) {
        this.credito += monto;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

}
