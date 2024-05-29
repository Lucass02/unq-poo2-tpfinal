package ar.edu.unq.po2.tpFinal.estacionamiento;

public class estacionamientoSinIniciar implements EstadoEstacionamiento {
	
	private Estacionamiento estacionamiento;
	
	@Override
	public void iniciarEstacionamiento() {
		estacionamiento.setEstado(new estacionamientoIniciado());
	}

	@Override
	public void finalizarEstacionamiento() {
		System.out.println("Error: No hay estacionamiento iniciado");
	}

	@Override
	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
}
