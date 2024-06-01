package ar.edu.unq.po2.tpFinal.estacionamiento;

public interface EstadoEstacionamiento {
	public void iniciarEstacionamiento();
	public void finalizarEstacionamiento();
	public boolean estaVigente();
	void setEstacionamiento(Estacionamiento estacionamiento);
}
