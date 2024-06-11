package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new EstacionamientoIniciado());
		estacionamiento.setInicio(LocalDateTime.now());
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: No hay estacionamiento iniciado");
	}

	@Override
	public boolean estaVigente(Estacionamiento estacionamiento) {
		return false;
	}
	
	@Override
	public void driving(AppUsuario app, Sem sem) {
		System.out.println("Error");
	}

	@Override
	public void walking(AppUsuario app, Sem sem, Reloj reloj) {
		app.getAsistencia().walking(app, sem, reloj);
		
	}
}
