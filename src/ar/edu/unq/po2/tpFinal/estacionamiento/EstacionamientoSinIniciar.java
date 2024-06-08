package ar.edu.unq.po2.tpFinal.estacionamiento;

public class EstacionamientoSinIniciar implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new EstacionamientoIniciado());
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: No hay estacionamiento iniciado");
	}
}
