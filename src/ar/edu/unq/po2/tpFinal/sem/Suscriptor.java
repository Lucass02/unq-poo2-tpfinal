package ar.edu.unq.po2.tpFinal.sem;

public class Suscriptor implements ISuscriptor {

	private String nombre;
	
	public Suscriptor(String nombre) {
		super();
		this.nombre = nombre;
	}
	

	@Override
	public void actualizar(String evento) {
		System.out.println("El suscriptor " + this.nombre + "ha recibido el evento " + evento);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


		
}
