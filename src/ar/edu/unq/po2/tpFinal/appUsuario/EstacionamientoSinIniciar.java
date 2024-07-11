package ar.edu.unq.po2.tpFinal.appUsuario;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {

	@Override
	public void iniciarEstacionamiento(AppUsuario usuario) {
		usuario.setEstado(new EstacionamientoIniciado());
		usuario.getSem().iniciarEstacionamientoApp(usuario);
		usuario.recibirInformacionDeEstacionamiento("El inicio de estacionamiento se ha realizado de forma " + usuario.getModo().nombre());
	}

	@Override
	public void finalizarEstacionamiento(AppUsuario usuario) {
		/*No hace nada*/
	}

	@Override
	public void notificarDriving(AppUsuario usuario) {
	}

	@Override
	public void notificarWalking(AppUsuario usuario) {
		usuario.getAsistencia().walking(usuario);
	}
	
}
