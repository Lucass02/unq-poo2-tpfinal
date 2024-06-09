package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(AppUsuario app, Sem sem, Reloj reloj) {
		app.setEstado(new EstacionamientoIniciado());
		sem.iniciarEstacionamiento(app.getUsuario().getPatente(), reloj);
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario app, Sem sem) {
		System.out.println("Error: No hay estacionamiento iniciado");
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
