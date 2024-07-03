package ar.edu.unq.po2.tpFinal.appUsuario;

public class ModoAutomatico implements ModoApp{

	@Override
	public void driving(AppUsuario usuario) {
		usuario.getEstado().notificarDriving(usuario);
		usuario.getEstado().finalizarEstacionamiento(usuario);
	}

	@Override
	public void walking(AppUsuario usuario) {
		usuario.getEstado().notificarWalking(usuario);
		usuario.getEstado().iniciarEstacionamiento(usuario);
	}
	public String nombre() {
		return ("automática");
	}
}
