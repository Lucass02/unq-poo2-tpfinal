package ar.edu.unq.po2.tpFinal.sem;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.Compra;

public interface ISuscriptor {
	
	void actualizarInicioDeEstacionamiento(Estacionamiento estacionamiento); 
	
	void actualizarFinDeEstacionamiento(Estacionamiento estacionamiento); 
	
	void actualizarRecargaDeCelular(Compra compra); 
}
