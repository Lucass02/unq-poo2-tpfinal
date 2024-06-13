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

	//Constructor
	
	  public AppUsuario(String celular, String patente, ModoApp modo, ZonaDeEstacionamiento zona, Sem sem) {
			this.celular = celular;
			this.patente = patente;
			this.saldo = 0;
			this.modo = modo;
			this.zona = zona;
			this.estado = new EstacionamientoSinIniciar();
			this.sem = sem;
		}
	
	//Methods

	public void recargarSaldo(double monto) {
	    this.saldo += monto;
	} 
	
	public void descontarSaldo(double saldoADescontar) {
		this.saldo -= saldoADescontar;
	}
	
	public void iniciarEstacionamiento() {
		this.sem.iniciarEstacionamientoApp(celular);
	}
	
	public void finalizarEstacionamiento() {
		this.sem.finalizarEstacionamiento(celular);
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
        
    public void setModo(ModoApp modo) {
    	this.modo = modo;
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

	public ModoApp getModo() {
		return this.modo;
	}
	
	public EstadoEstacionamiento getEstado() {
		return this.estado;
	}
	
	public ZonaDeEstacionamiento getZona() {
		return this.zona;
	}
}