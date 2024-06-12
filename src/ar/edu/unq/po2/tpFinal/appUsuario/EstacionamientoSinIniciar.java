package ar.edu.unq.po2.tpFinal.appUsuario;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {

	@Override
	public void iniciarEstacionamiento(AppUsuario usuario) {
		usuario.iniciarEstacionamiento(usuario.getGps());
		usuario.recibirInformacionDeEstacionamiento("El inicio de estacionamiento se ha realizado de forma automática");
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario usuario) {
		/* NO HACE NADA */
	}
	
}
