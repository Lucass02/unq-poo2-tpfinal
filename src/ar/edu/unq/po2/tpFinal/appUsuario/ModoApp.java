package ar.edu.unq.po2.tpFinal.appUsuario;

import ar.edu.unq.po2.tpFinal.sem.Sem;

public interface ModoApp {
	
	public void iniciarEstacionamiento(AppUsuario app, Sem sem);
	public void finalizarEstacionamiento(AppUsuario app, Sem sem);
}
