package ar.edu.unq.po2.tpFinal.estacionamiento;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.appUsuario.AppUsuario;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoIniciado implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: Estacionamiento ya iniciado");
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new EstacionamientoSinIniciar());
		estacionamiento.setFin(LocalDateTime.now());
	}
	
	@Override
	public boolean estaVigente(Estacionamiento estacionamiento) {
		LocalDateTime ahora = LocalDateTime.now();
		return ahora.isAfter(estacionamiento.getInicio()) && ahora.isBefore(estacionamiento.getFin());
	}

	@Override
	public void driving(AppUsuario app, Sem sem) {
		app.getAsistencia().driving(app, sem);
	}

	@Override
	public void walking(AppUsuario app, Sem sem, Reloj reloj) {
		System.out.println("Error");
	}

}
