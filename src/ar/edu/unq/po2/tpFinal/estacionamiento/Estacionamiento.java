package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.state.EstadoMaquina;

public class Estacionamiento {
    private static int contador = 0;
    private int id;
    private Vehiculo vehiculo;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Usuario usuario;
    private EstadoEstacionamiento estado;

    public Estacionamiento(Vehiculo vehiculo, Usuario usuario) {
        this.id = ++contador;
        this.vehiculo = vehiculo;
        this.usuario = usuario;
        this.inicio = LocalDateTime.now();
        setEstado(new estacionamientoIniciado());
    }
    public EstadoEstacionamiento getEstado() {
		return estado;
	}
    
	public void setEstado(EstadoEstacionamiento estadoActual) {
		this.estado = estadoActual;
		this.estado.setEstacionamiento(this);
	}
	
    public void finalizarEstacionamiento() {
        this.fin = LocalDateTime.now();
        this.vigente = false;
    }

    public boolean estaVigente() {
        return vigente;
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

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}

}
