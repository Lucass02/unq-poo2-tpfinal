package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

class PuntoDeVentaTest {

	private Sem mockSem;
	private PuntoDeVenta puntoDeVenta;
	private ZonaDeEstacionamiento mockZona;
	private Compra compraMock;
	
	@BeforeEach
	public void setUp() {
		mockZona = mock(ZonaDeEstacionamiento.class);
		compraMock = mock(Compra.class);
		mockSem = mock(Sem.class);
		puntoDeVenta = new PuntoDeVenta (1,mockZona, mockSem) {};
	}
	
	@Test
	public void testConstructor() {
		assertEquals(1, puntoDeVenta.getId());
		assertEquals(mockZona, puntoDeVenta.getZona());
		assertEquals(mockSem, puntoDeVenta.getSem());
		assertEquals(0, puntoDeVenta.getComprasRealizadas().size());
	}
	
	@Test
	public void testRegistrarCompra() {
		puntoDeVenta.registrarCompra(compraMock);
		List<Compra> compras = puntoDeVenta.getComprasRealizadas();
		assertEquals(1,compras.size());
	}

}
