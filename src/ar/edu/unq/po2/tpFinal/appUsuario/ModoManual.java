package ar.edu.unq.po2.tpFinal.appUsuario;

public class ModoManual implements ModoApp{

	@Override
	public void driving(AppUsuario usuario) {
		usuario.getEstado().notificarDriving(usuario);
	}

	@Override
	public void walking(AppUsuario usuario) {
		usuario.getEstado().notificarWalking(usuario);
	}
	public String nombre() {
		return ("manual");
	}
}
