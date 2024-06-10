package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import java.time.LocalDate;


public class CompraPuntual extends Compra {
    private double cantidadDeHsCompradas;

    //Constructor
    
	public CompraPuntual(int numeroControl, PuntoDeVenta puntoDeVenta, LocalDate fecha, LocalDate hora,
			double cantidadDeHsCompradas) {
		super(numeroControl, puntoDeVenta, fecha, hora);
		this.cantidadDeHsCompradas = cantidadDeHsCompradas;
	}

	//Methods
	
	@Override
	public void realizarCompra(PuntoDeVenta puntoDeVenta, String patente) {
		//Logica para registrar la compra dentro del punto de venta
        puntoDeVenta.registrarCompra(this);
        
        // Lógica para realizar una compra puntual desde sem
        puntoDeVenta.getSem().asignarEstacionamiento(puntoDeVenta.getZona(), patente, cantidadDeHsCompradas);
        
	}
	
	//Getters y Setters
    
}
