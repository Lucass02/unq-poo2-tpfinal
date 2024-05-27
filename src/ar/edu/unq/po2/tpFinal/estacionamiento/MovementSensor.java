package ar.edu.unq.po2.tpFinal.estacionamiento;

public interface MovementSensor {

	//Indica que el desplazamiento se realiza a bordo de un vehículo.
	public void driving();
	
	//Indica que el desplazamiento se realiza caminando.
	public void walking();
}