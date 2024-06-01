package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

public class Estacionamiento {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Usuario usuario;
    private EstadoEstacionamiento estado;

    public Estacionamiento(Usuario usuario) {
        this.usuario = usuario;
        this.inicio = LocalDateTime.now();
        setEstado(new estacionamientoIniciado());
    }
    /* Métodos */
    
    public void iniciarEstacionamiento() {
		this.estado.iniciarEstacionamiento();
	}

	public void finalizarEstacionamiento() {
		this.estado.finalizarEstacionamiento();
	}
	
	public boolean estaVigente() {
		return (this.estado.estaVigente());
	}
    
    
    /* Getters y Setters*/
	
	public void setEstado(EstadoEstacionamiento estadoActual) {
		this.estado = estadoActual;
		this.estado.setEstacionamiento(this);
	}

	public EstadoEstacionamiento getEstado() {
		return estado;
	}

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
