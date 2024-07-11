package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.sem.Sem;

class CompraPuntualTest {
	
	private CompraPuntual compraPuntual;
	private PuntoDeVenta mockPuntoDeVenta;
	
	private LocalDate fecha;
    private LocalTime hora;

    
	
    @BeforeEach
    public void setUp() {
        fecha = LocalDate.now();
        hora = LocalTime.now();

        
        mockPuntoDeVenta = mock(PuntoDeVenta.class);
        
        compraPuntual = new CompraPuntual(mockPuntoDeVenta , fecha, hora, 2);
    }
	
	@Test
	public void testObtenerCantidadDeHorasCompradas() {

		
		assertEquals(2,compraPuntual.getCantidadDeHsCompradas());
	}
}
