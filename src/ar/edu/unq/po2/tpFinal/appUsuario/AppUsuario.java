package ar.edu.unq.po2.tpFinal.appUsuario;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class AppUsuario implements MovementSensor{
    private String celular;
    private String patente;
	private double saldo;
    private ModoApp modo;
    private ZonaDeEstacionamiento zona;
	private EstadoEstacionamiento estado;
	private Sem sem;
	private Asistencia asistencia;

	//Constructor
	
	public AppUsuario(String celular, String patente, ModoApp modo, ZonaDeEstacionamiento zona, Sem sem, Asistencia asistencia) {
		this.celular = celular;
		this.patente = patente;
		this.saldo = 0;
		this.modo = modo;
		this.zona = zona;
		this.estado = new EstacionamientoSinIniciar();
		this.sem = sem;
		this.asistencia = asistencia;
	}
	
	//Methods

	public void recargarSaldo(double monto) {
	    this.saldo += monto;
	} 
	
	public void descontarSaldo(double saldoADescontar) {
		this.saldo -= saldoADescontar;
	}
	
	public void iniciarEstacionamiento() {
		this.estado.iniciarEstacionamiento(this);
	}
	
	public void finalizarEstacionamiento() {
		this.estado.finalizarEstacionamiento(this);
	}
    
    public void recibirInformacionDeEstacionamiento(String informacion) {
        System.out.println(informacion);
    }
    
    /* INTERFAZ MOVEMENT SENSOR */
	@Override
	public void driving() {
		this.modo.driving(this);
	}

	@Override
	public void walking() {
		this.modo.walking(this);
	}
	
	//Getters y Setters
        
    public void activarModoAutomatico() {
    	this.modo = new ModoAutomatico();
    	this.asistencia = new AsistenciaActivada();
    }
    
    public void activarModoManual() {
    	this.modo = new ModoManual();
    }
    
	public void setEstado(EstadoEstacionamiento estadoActual) {
		this.estado = estadoActual;
	}

	public String getCelular() {
		return celular;
	}

	public String getPatente() {
		return patente;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public Sem getSem() {
		return sem;
	}

	public ModoApp getModo() {
		return modo;
	}

	public Asistencia getAsistencia() {
		return asistencia;
	}
	
	public void asistenciaActivada() {
		this.asistencia = new AsistenciaActivada();
	}
	
	public void asistenciaDesactivada() {
		this.asistencia = new AsistenciaDesactivada();
	}
	
	public EstadoEstacionamiento getEstado() {
		return this.estado;
	}
	
	public ZonaDeEstacionamiento getZona() {
		return this.zona;
	}
}