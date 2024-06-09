package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class AsistenciaActivada implements Asistencia {

	@Override
	public void walking(AppUsuario app, Sem sem, Reloj reloj) {
		app.recibirNotificacion("El desplazamiento ha cambiado de vehículo a pie");
		app.getModo().iniciarEstacionamiento(app, sem, reloj);	
	}

	@Override
	public void driving(AppUsuario app, Sem sem) {
		app.recibirNotificacion("El desplazamiento ha cambiado de pie a vehiculo");
		app.getModo().finalizarEstacionamiento(app, sem);
	}

}
