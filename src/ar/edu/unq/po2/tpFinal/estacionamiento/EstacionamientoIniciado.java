package ar.edu.unq.po2.tpFinal.estacionamiento;

public class EstacionamientoIniciado implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: Estacionamiento ya iniciado");
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new EstacionamientoSinIniciar());
	}
}
