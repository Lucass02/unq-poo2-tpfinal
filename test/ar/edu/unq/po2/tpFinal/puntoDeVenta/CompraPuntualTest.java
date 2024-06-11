package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.sem.Sem;

class CompraPuntualTest {
	
	private CompraPuntual compraPuntual;
	private PuntoDeVenta mockPuntoDeVenta;
	private Sem mockSem;
	
	private LocalDate fecha;
    private LocalDate hora;
    private double cantidadDeHsCompradas;
    private String patente;
	
    @BeforeEach
    public void setUp() {
        fecha = LocalDate.now();
        hora = LocalDate.now();
        cantidadDeHsCompradas = 4.0;
        patente = "AAA111";
        mockPuntoDeVenta = mock(PuntoDeVenta.class);
        mockSem = mock(Sem.class);
        
        when(mockPuntoDeVenta.getSem()).thenReturn(mockSem);
        
        compraPuntual = new CompraPuntual(1, mockPuntoDeVenta , fecha, hora, cantidadDeHsCompradas);
    }
	
	
	@Test
	public void testConstructor() {
		assertEquals(4.0, compraPuntual.getCantidadDeHsCompradas());
	}
	
	@Test
	public void seCompraUnEstacionamientoYSeRegistra() {
		compraPuntual.realizarCompra(patente);
		 
		verify(mockPuntoDeVenta).registrarCompra(compraPuntual);
		verify(mockSem).asignarEstacionamiento(mockPuntoDeVenta.getZona(), patente, cantidadDeHsCompradas);
	}

}
