package ar.edu.unq.po2.tpFinal.sem;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.Compra;

public interface INotificador {
	
	public void suscribir(ISuscriptor suscriptor);
	
	public void desuscribir(ISuscriptor suscriptor);
	
	public void notificarInicioDeEstacionamiento(Estacionamiento estacionamiento);
	
	public void notificarFinDeEstacionamiento(Estacionamiento estacionamiento);
	
	public void notificarRecargaDeCelular(Compra compra);
}
