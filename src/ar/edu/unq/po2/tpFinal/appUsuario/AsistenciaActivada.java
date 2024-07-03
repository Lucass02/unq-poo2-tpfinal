package ar.edu.unq.po2.tpFinal.appUsuario;

public class AsistenciaActivada implements Asistencia {

	@Override
	public void driving(AppUsuario usuario) {
		usuario.recibirInformacionDeEstacionamiento("¡Alerta! Cambio de desplazamiento de pie a automovil");
	}

	@Override
	public void walking(AppUsuario usuario) {
		usuario.recibirInformacionDeEstacionamiento("¡Alerta! Cambio de desplazamiento de automovil a pie");
	}

}
