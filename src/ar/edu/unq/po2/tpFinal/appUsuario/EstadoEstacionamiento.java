package ar.edu.unq.po2.tpFinal.appUsuario;

public interface EstadoEstacionamiento {
	
	public void iniciarEstacionamiento(AppUsuario usuario);
	public void finalizarEstacionamiento(AppUsuario usuario);
	public void notificarDriving(AppUsuario usuario);
	public void notificarWalking(AppUsuario usuario);
}
