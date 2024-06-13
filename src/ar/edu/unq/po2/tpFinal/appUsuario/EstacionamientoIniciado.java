package ar.edu.unq.po2.tpFinal.appUsuario;

public class EstacionamientoIniciado implements EstadoEstacionamiento {

	@Override
	public void iniciarEstacionamiento(AppUsuario usuario) {
		/*No hace nada*/
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario usuario) {
		usuario.setEstado(new EstacionamientoSinIniciar());
		usuario.finalizarEstacionamiento();
		usuario.recibirInformacionDeEstacionamiento("El fin de estacionamiento se ha realizado de forma automática");
	}
}
