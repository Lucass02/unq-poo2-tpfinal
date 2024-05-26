package ar.edu.unq.po2.tpFinal.usuario;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class Usuario {
    private int id;
    private String nombre;
    private String celular;
    private double credito;

    public Usuario(int id, String nombre, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.credito = 0;
    }

    public void iniciarEstacionamiento(String patente, Sem sem) {
        //sem.iniciarEstacionamiento(patente, this.celular);
    }

    public void finalizarEstacionamiento(String patente, Sem sem) {
        //sem.finalizarEstacionamiento(patente, this.celular);
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

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

}
