package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class AppUsuario implements MovementSensor{
    private String celular;
    private String patente;
	private double saldo;
    private ModoApp modo;
    private Gps gps;
	private EstadoEstacionamiento estado;
	private Asistencia asistencia;
	private Sem sem;
	private Reloj reloj;

	//Constructor
	
	  public AppUsuario(String celular, String patente, double saldo,
				ModoApp modo, Gps gps, EstadoEstacionamiento estado, Asistencia asistencia, Sem sem, Reloj reloj) {
			super();
			this.celular = celular;
			this.patente = patente;
			this.saldo = 0;
			this.modo = modo;
			this.gps = gps;
			this.estado = estado;
			this.asistencia = asistencia;
			this.sem = sem;
			this.reloj = reloj;
		}
	
	//Methods

	public void recargarSaldo(double monto) {
	    this.saldo += monto;
	} 
	
	public void iniciarEstacionamiento(Gps gps) {
		this.sem.iniciarEstacionamientoApp(this.getZona(), patente, celular);
	}
	
	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(patente);
	}
    
    public void recibirInformacionDeEstacionamiento(String informacion) {
        System.out.println(informacion);
    }

	@Override
	public void driving() {
		this.estado.driving(this, this.sem);
	}

	@Override
	public void walking() {
		this.estado.walking(this, this.sem, this.reloj);
	}
	
	//Getters y Setters
    
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Asistencia getAsistencia() {
		return this.asistencia;
	}

	public ModoApp getModo() {
		return this.modo;
	}
}