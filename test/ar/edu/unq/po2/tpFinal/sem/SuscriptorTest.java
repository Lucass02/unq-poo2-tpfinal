package ar.edu.unq.po2.tpFinal.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SuscriptorTest {

	private Suscriptor suscriptor;
	
	@BeforeEach
	public void setUp() {
		suscriptor = new Suscriptor("Entidad");
	}
	
	@Test
	public void testParaActualizarEnPantalla() {
		suscriptor.actualizar("Un evento");
		
		
	}
	
	@Test
	public void testConstructor() {
		assertEquals("Entidad", suscriptor.getNombre());
	}
}
