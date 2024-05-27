package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class AppUsuario implements MovementSensor{
    private Usuario usuario;
    private List<Estacionamiento> estacionamientos;

    public AppUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.estacionamientos = new ArrayList<Estacionamiento>();
    }

    public void iniciarEstacionamiento(String patente, Sem sem) {
        usuario.iniciarEstacionamiento(patente, sem);
    }

    public void finalizarEstacionamiento(String patente, Sem sem) {
        usuario.finalizarEstacionamiento(patente, sem);
    }

    public void consultarSaldo() {
        double saldo = usuario.consultarSaldo();
        System.out.println("Saldo disponible: " + saldo);
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}
	
	@Override
	public void driving() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		
	}

}