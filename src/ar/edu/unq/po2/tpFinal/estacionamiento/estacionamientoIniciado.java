package ar.edu.unq.po2.tpFinal.estacionamiento;

public class estacionamientoIniciado implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: Estacionamiento ya iniciado");
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new estacionamientoSinIniciar());
	}
	
	@Override
	public boolean estaVigente() {
		return true;
	}
}
