package ar.edu.unq.po2.tpFinal.appUsuario;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class ModoAutomatico implements ModoApp{

	@Override
	public void iniciarEstacionamiento(AppUsuario app, Sem sem) {
		app.iniciarEstacionamiento(sem);
		app.recibirInformacionDeEstacionamiento("El inicio de estacionamiento se ha realizado de forma automática");
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario app, Sem sem) {
		app.finalizarEstacionamiento(sem);
		app.recibirInformacionDeEstacionamiento("El fin de estacionamiento se ha realizado de forma automática");	
	}

}
