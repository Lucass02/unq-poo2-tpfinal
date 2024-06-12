package ar.edu.unq.po2.tpFinal.appUsuario;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class AsistenciaActivada implements Asistencia {

	@Override
	public void walking(AppUsuario app, Sem sem) {
		app.recibirInformacionDeEstacionamiento("El desplazamiento ha cambiado de vehículo a pie");
		app.getModo().iniciarEstacionamiento(app, sem);	
	}

	@Override
	public void driving(AppUsuario app, Sem sem) {
		app.recibirInformacionDeEstacionamiento("El desplazamiento ha cambiado de pie a vehiculo");
		app.getModo().finalizarEstacionamiento(app, sem);
	}

}
