package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class AppUsuario implements MovementSensor{
    private Usuario usuario;
    private List<Estacionamiento> estacionamientos;
    private ModoApp modo;

    public AppUsuario(Usuario usuario, ModoApp modo) {
        this.usuario = usuario;
        this.estacionamientos = new ArrayList<Estacionamiento>();
        this.modo = modo;
    }
    
    public void setModo(ModoApp modo) {
    	this.modo = modo;
    }
    
    public void agregarEstacionamiento(Estacionamiento estacionamiento) {
        estacionamientos.add(estacionamiento);
    }

    public List<Estacionamiento> getEstacionamientos() {
        return estacionamientos;
    }

    public void iniciarEstacionamiento() {
    	this.modo.iniciarEstacionamiento();
    }

    public void finalizarEstacionamiento() {
    	this.modo.finalizarEstacionamiento();
    }

    public void consultarSaldo() {
        System.out.println("El saldo del usuario " + usuario.getNombre() + " es: " + usuario.consultarSaldo());
    }

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}