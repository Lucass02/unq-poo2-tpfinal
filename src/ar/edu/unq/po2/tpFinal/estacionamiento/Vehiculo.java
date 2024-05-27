package ar.edu.unq.po2.tpFinal.estacionamiento;

public class Vehiculo {
    private String patente;
    private Usuario usuario;

    public Vehiculo(String patente, Usuario usuario) {
        this.patente = patente;
        this.usuario = usuario;
    }

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}