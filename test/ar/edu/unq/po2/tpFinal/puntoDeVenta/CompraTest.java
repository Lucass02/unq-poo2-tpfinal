package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompraTest {

	private Compra compra;
	private PuntoDeVenta puntoDeVentaMock;
	private LocalDate fecha;
	private LocalTime hora;
	
	@BeforeEach
	public void setUp() {
		fecha = LocalDate.of(2024, 6, 13);
		hora = LocalTime.of(13, 15);
		puntoDeVentaMock = mock(PuntoDeVenta.class);
		
		compra = new CompraPuntual(2, puntoDeVentaMock, fecha, hora, 7);
	}
	
	@Test
	public void testConstructor() {
	    assertEquals(2, compra.getNumeroControl());
	    assertEquals(puntoDeVentaMock, compra.getPuntoDeVenta());
	    assertEquals(fecha, compra.getFecha());
	    assertEquals(hora, compra.getHora());
	}
}
