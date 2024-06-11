package ar.edu.unq.po2.tpFinal.puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.sem.Sem;

class RecargaCelularTest {

	private RecargaCelular recargaCelular;
	private PuntoDeVenta mockPuntoDeVenta;
	private Sem mockSem;
	private LocalDate fecha;
    private LocalDate hora;
    private double monto;
    private String patente;
    private String patente2;

    @BeforeEach
    public void setUp() {
        fecha = LocalDate.now();
        hora = LocalDate.now();
        monto = 100.0;
        patente = "AAA111";
        patente2 = "BBB222";
        mockPuntoDeVenta = mock(PuntoDeVenta.class);
        mockSem = mock(Sem.class);
        
        when(mockPuntoDeVenta.getSem()).thenReturn(mockSem);
        
        recargaCelular = new RecargaCelular(1, mockPuntoDeVenta , fecha, hora, monto);
    }

    @Test
    public void testConstructor() {	
    	assertEquals(100.0, recargaCelular.getMonto());
    }
    
    @Test
    public void seRealizanDosRecargasYSonRegistradas() {
        
        recargaCelular.realizarCompra(patente);
        recargaCelular.realizarCompra(patente2);

        
        verify(mockPuntoDeVenta, times(2)).registrarCompra(recargaCelular);
        verify(mockSem).recargarSaldo(monto, patente);
        verify(mockSem).recargarSaldo(monto, patente2);
    }	


}
