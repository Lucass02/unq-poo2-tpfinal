package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class ModoAutomatico implements ModoApp{

	@Override
	public void iniciarEstacionamiento(AppUsuario app, Sem sem, Reloj reloj) {
		app.iniciarEstacionamiento(sem, reloj);
		app.recibirNotificacion("El inicio de estacionamiento se ha realizado de forma automática");
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario app, Sem sem) {
		app.finalizarEstacionamiento(sem);
		app.recibirNotificacion("El fin de estacionamiento se ha realizado de forma automática");	
	}

}
