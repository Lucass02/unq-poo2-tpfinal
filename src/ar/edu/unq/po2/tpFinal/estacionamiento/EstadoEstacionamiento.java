package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public interface EstadoEstacionamiento {
	
	public void iniciarEstacionamiento(AppUsuario app, Sem sem, Reloj reloj);
	public void finalizarEstacionamiento(AppUsuario app, Sem sem);
	public void driving(AppUsuario app, Sem sem);
	public void walking(AppUsuario app, Sem sem, Reloj reloj);
}
