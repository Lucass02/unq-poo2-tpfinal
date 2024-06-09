package ar.edu.unq.po2.tpFinal.estacionamiento;

import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public interface Asistencia {
	
	public void walking(AppUsuario app, Sem sem, Reloj reloj);
	public void driving(AppUsuario app, Sem sem);
}
