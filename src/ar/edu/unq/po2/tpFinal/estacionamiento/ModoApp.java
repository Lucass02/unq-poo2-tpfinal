package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public interface ModoApp {
	
	public void iniciarEstacionamiento(AppUsuario app, Sem sem, Reloj reloj);
	public void finalizarEstacionamiento(AppUsuario app, Sem sem);
}
