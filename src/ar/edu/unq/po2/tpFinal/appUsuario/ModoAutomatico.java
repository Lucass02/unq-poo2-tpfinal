package ar.edu.unq.po2.tpFinal.appUsuario;

public class ModoAutomatico implements ModoApp{

	@Override
	public void driving(AppUsuario usuario) {
		usuario.getEstado().finalizarEstacionamiento(usuario);
	}

	@Override
	public void walking(AppUsuario usuario) {
		usuario.getEstado().iniciarEstacionamiento(usuario);
	}
}
