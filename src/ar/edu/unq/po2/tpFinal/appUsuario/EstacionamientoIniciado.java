package ar.edu.unq.po2.tpFinal.appUsuario;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoIniciado implements EstadoEstacionamiento {

	@Override
	public void iniciarEstacionamiento(AppUsuario usuario) {
		/*No hace nada*/
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario usuario) {
		usuario.finalizarEstacionamiento();
		usuario.recibirInformacionDeEstacionamiento("El fin de estacionamiento se ha realizado de forma automática");
	}
}
