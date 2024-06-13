package ar.edu.unq.po2.tpFinal.appUsuario;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {

	@Override
	public void iniciarEstacionamiento(AppUsuario usuario) {
		usuario.iniciarEstacionamiento();
		usuario.recibirInformacionDeEstacionamiento("El inicio de estacionamiento se ha realizado de forma automática");
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario usuario) {
		/*No hace nada*/
	}
	
}
