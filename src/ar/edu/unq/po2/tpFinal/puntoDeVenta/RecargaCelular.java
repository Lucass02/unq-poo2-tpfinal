package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.estacionamiento.Usuario;
import ar.edu.unq.po2.tpFinal.sem.Sem;


public class RecargaCelular extends Compra {
	
	private double monto;
	
    public RecargaCelular(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void realizarCompra(Sem sem, PuntoDeVenta puntoDeVenta, Usuario usuario) {
		puntoDeVenta.registrarCompra(this);
		sem.recargarSaldo(monto, usuario);
	}


    

}
