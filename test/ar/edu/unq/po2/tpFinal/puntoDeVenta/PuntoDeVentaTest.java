package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

class PuntoDeVentaTest {

	private Sem sem;
	private PuntoDeVenta puntoDeVenta;
	private ZonaDeEstacionamiento zona;

	
	@BeforeEach
	public void setUp() {
		zona = mock(ZonaDeEstacionamiento.class);
		sem = mock(Sem.class);
		
		puntoDeVenta = new PuntoDeVenta (1,zona, sem);
	}
	
	
	@Test
	public void testSeRealizanCompras() {
		puntoDeVenta.CompraEstacionamiento("AAA111", 2);
		puntoDeVenta.RecargaCelular("11123456", 200);
		
		assertEquals(2, puntoDeVenta.getComprasRealizadas().size());
	}

	
	@Test
	public void testRegistrarRecargaCelular() {
		puntoDeVenta.RecargaCelular("11123456", 200);
		
		assertEquals(puntoDeVenta.getComprasRealizadas().getFirst().getNumeroControl(),1);
	}
	@Test
	public void testRegistrarCompraPuntual() {

		puntoDeVenta.CompraEstacionamiento("AAA111", 2);
		
		verify(sem).iniciarEstacionamientoCompraPuntual(zona, "AAA111", 2);
	}
	
	
	@Test
	public void obtenerZona() {
		assertEquals(zona, puntoDeVenta.getZona());
	}
	
	
	@Test
	public void obtenerId() {
		assertEquals(1, puntoDeVenta.getId());
	}
	
	
	@Test
	public void obtenerSem() {
		assertEquals(sem, puntoDeVenta.getSem());
	}
}
