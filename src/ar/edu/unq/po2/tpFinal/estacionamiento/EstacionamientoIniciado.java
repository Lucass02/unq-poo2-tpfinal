package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoIniciado implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(AppUsuario app, Sem sem, Reloj reloj) {
		System.out.println("Error: Estacionamiento ya iniciado");
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario app, Sem sem) {
		app.setEstado(new EstacionamientoSinIniciar());
		sem.finalizarEstacionamiento(app.getUsuario().getPatente());
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
