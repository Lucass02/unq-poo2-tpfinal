package ar.edu.unq.po2.tpFinal.estacionamiento;

public class estacionamientoIniciado implements EstadoEstacionamiento {
	
	private Estacionamiento estacionamiento;
	
	@Override
	public void iniciarEstacionamiento() {
		System.out.println("Error: Estacionamiento ya iniciado");
	}

	@Override
	public void finalizarEstacionamiento() {
		estacionamiento.setEstado(new estacionamientoSinIniciar());
	}
	
	@Override
	public boolean estaVigente() {
		return true;
	}
	
	@Override
	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

}
