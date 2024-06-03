package ar.edu.unq.po2.tpFinal.estacionamiento;

public class estacionamientoSinIniciar implements EstadoEstacionamiento {
	
	@Override
	public void iniciarEstacionamiento(Estacionamiento estacionamiento) {
		estacionamiento.setEstado(new estacionamientoIniciado());
	}

	@Override
	public void finalizarEstacionamiento(Estacionamiento estacionamiento) {
		System.out.println("Error: No hay estacionamiento iniciado");
	}
	@Override
	public boolean estaVigente() {
		return false;
	}
}
