package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class AppUsuario implements MovementSensor{
    private Usuario usuario;
    private List<Estacionamiento> estacionamientos;
    private ModoApp modo;
    private Gps gps;
	private EstadoEstacionamiento estado;
	private Asistencia asistencia;
	private Sem sem;
	private Reloj reloj;

    public AppUsuario(Usuario usuario, Gps gps, Sem sem, Reloj reloj) {
        this.usuario = usuario;
        this.estacionamientos = new ArrayList<Estacionamiento>();
        this.modo = new ModoManual();
        this.gps = gps;
        this.estado = new EstacionamientoSinIniciar();
        this.asistencia = new AsistenciaDesactivada();
        this.sem = sem;
        this.reloj = reloj;
    }
    
    public ZonaDeEstacionamiento getZona() {
    	return gps.getZona();  
    }
    
    public void setModoManual() {
    	this.modo =  new ModoManual();
    }
    
    public void setModoAutomatico() {
    	this.modo =  new ModoAutomatico();
    	this.asistencia = new AsistenciaActivada();
    }
    
	public void setAsistenciaActivada() {
		this.asistencia = new AsistenciaActivada();
	}
	
	public void setAsistenciaDesactivada() {
		this.asistencia = new AsistenciaDesactivada();
	}
	
	public void setEstado(EstadoEstacionamiento estadoActual) {
		this.estado = estadoActual;
	}
    
    public void agregarEstacionamiento(Estacionamiento estacionamiento) {
        estacionamientos.add(estacionamiento);
    }

    public List<Estacionamiento> getEstacionamientos() {
        return estacionamientos;
    }

    public void iniciarEstacionamiento(Sem sem, Reloj reloj) {
    	this.estado.iniciarEstacionamiento(this, sem, reloj);
    }

    public void finalizarEstacionamiento(Sem sem) {
    	this.estado.finalizarEstacionamiento(this, sem);
    }

    public void consultarSaldo() {
        System.out.println("El saldo del usuario " + usuario.getNombre() + " es: " + usuario.consultarSaldo());
    }
    
    public void recibirNotificacion(String notificacion) {
        System.out.println(notificacion);
    }

	@Override
	public void driving() {
		this.estado.driving(this, this.sem);
	}

	@Override
	public void walking() {
		this.estado.walking(this, this.sem, this.reloj);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Asistencia getAsistencia() {
		return this.asistencia;
	}

	public ModoApp getModo() {
		return this.modo;
	}
}