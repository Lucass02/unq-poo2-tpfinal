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

    public void agregarEstacionamiento(Estacionamiento estacionamiento) {
        estacionamientos.add(estacionamiento);
    }

    public List<Estacionamiento> getEstacionamientos() {
        return estacionamientos;
    }

    public void iniciarEstacionamiento(Vehiculo vehiculo, Sem sem) {
        if (sem.consultarEstacionamiento(vehiculo.getPatente())) {
            System.out.println("El vehículo ya tiene un estacionamiento activo.");
        } else {
            sem.iniciarEstacionamiento(vehiculo.getPatente(), usuario.getCelular());
            Estacionamiento estacionamiento = new Estacionamiento(vehiculo, usuario);
            agregarEstacionamiento(estacionamiento);
            System.out.println("Estacionamiento iniciado para el vehículo con patente: " + vehiculo.getPatente());
        }
    }

    public void finalizarEstacionamiento(Vehiculo vehiculo, Sem sem) {
        if (sem.consultarEstacionamiento(vehiculo.getPatente())) {
            sem.finalizarEstacionamiento(vehiculo.getPatente(), usuario.getCelular());
            for (Estacionamiento e : estacionamientos) {
                if (e.getVehiculo().getPatente().equals(vehiculo.getPatente()) && e.estaVigente()) {
                    e.finalizarEstacionamiento();
                    System.out.println("Estacionamiento finalizado para el vehículo con patente: " + vehiculo.getPatente());
                    break;
                }
            }
        } else {
            System.out.println("No hay un estacionamiento activo para el vehículo con patente: " + vehiculo.getPatente());
        }
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