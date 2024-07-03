package ar.edu.unq.po2.tpFinal.appUsuario;

public class AsistenciaActivada implements Asistencia {

	@Override
	public void driving(AppUsuario usuario) {
		usuario.recibirInformacionDeEstacionamiento("Forma de desplazamiento: A pie");
	}

	@Override
	public void walking(AppUsuario usuario) {
		usuario.recibirInformacionDeEstacionamiento("Forma de desplazamiento: Automovil");
	}

}
