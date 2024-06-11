package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public interface EstadoEstacionamiento {
	
	public void iniciarEstacionamiento(Estacionamiento estacionamiento);
	public void finalizarEstacionamiento(Estacionamiento estacionamiento);
	public boolean estaVigente(Estacionamiento estacionamiento);
	public void driving(AppUsuario app, Sem sem);
	public void walking(AppUsuario app, Sem sem, Reloj reloj);
}
