package ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.inspectorApp.InspectorApp;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class ZonaDeEstacionamientoTestCase {
	private ZonaDeEstacionamiento zona;
	private InspectorApp inspector;
	private PuntoDeVenta punto;
	private Estacionamiento estacionamiento;
	
	@BeforeEach
    public void setUp() {
    	zona = new ZonaDeEstacionamiento("Bernal");
    	punto = mock(PuntoDeVenta.class);
    	inspector = mock(InspectorApp.class);
    	estacionamiento = mock(Estacionamiento.class);
    }
    
    @Test
    public void seLeAsignaUnaZonaAUnInspector() {
    	// Excercise
    	zona.agregarInspector(inspector);
    	// Verify
    	verify(inspector).agregarAZona(zona);
    }
    
    @Test
    public void seLeAgregaUnPuntoDeVenta() {
    	// Excercise
    	zona.agregarPuntoDeVenta(punto);
    	// Verify
    	assertFalse(this.zona.getPuntosDeVentas().isEmpty());
    }
    
    @Test
    public void seQuitaUnPuntoDeVenta() {
    	// Excercise
    	zona.agregarPuntoDeVenta(punto);
    	zona.quitarPuntoDeVenta(punto);
    	// Verify
    	assertTrue(this.zona.getPuntosDeVentas().isEmpty());
    }
    
    @Test
    public void seObtieneUbicacionDeLaZona() {
    	// Verify
    	assertEquals(this.zona.getUbicacion(),"Bernal");
    }
    
    @Test
    public void seObtieneInspectorDeLaZona() {
    	// Excercise
    	zona.agregarInspector(inspector);
    	when(inspector.getNombre()).thenReturn("Pepe");
    	// Verify
    	assertEquals(this.zona.getInspector().getNombre(),"Pepe");
    }
}
