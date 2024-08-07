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

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.InspectorApp;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class InspectorTestCase {
		private InspectorApp inspector;
		private ZonaDeEstacionamiento zona;
		private Sem sem;
		private String patente;
		
	    @BeforeEach
	    public void setUp() {
	    	zona = mock(ZonaDeEstacionamiento.class);
	    	sem = mock(Sem.class);
	    	patente = "ABC123"; 
	    	inspector = new InspectorApp("Pepe");
	    	zona.agregarInspector(inspector);
	    }
	    
	    @Test
	    public void seLeAsignaUnaZonaAUnInspector() {
	    	// Excercise
	    	
	    	inspector.agregarAZona(zona);
	    	when(zona.getUbicacion()).thenReturn("Bernal");
	    	
	    	// Verify
	    	
	    	verify(zona).agregarInspector(inspector);
	    }
	    
	    @Test
	    public void seVerificaUnEstacionamientoYseRegistraInfraccion() {
	    	
	    	when(sem.estacionamientoVigente(patente)).thenReturn(true);
	    	// Excercise
	    	
	    	inspector.verificarEstacionamiento(sem, patente);
	    	// Verify
	    	
	    	verify(sem).estacionamientoVigente(patente);
	    	verify(sem).registrarInfraccion(Mockito.any(Infraccion.class));
	    }
	    
	    @Test
	    public void noSeRegistraUnaInfraccion() {
	    	
	    	when(sem.estacionamientoVigente(patente)).thenReturn(false);
	    	// Excercise
	    	
	    	inspector.verificarEstacionamiento(sem, patente);
	    	// Verify
	    	
	    	verify(sem, never()).registrarInfraccion(Mockito.any(Infraccion.class));
	    }
	    
	    @Test
	    public void seRegistraUnaInfraccion() {
	    	
	    	when(sem.estacionamientoVigente(patente)).thenReturn(true);
	    	// Excercise
	    	
	    	inspector.verificarEstacionamiento(sem, patente);
	    	// Verify
	    	
	    	verify(sem).registrarInfraccion(Mockito.any(Infraccion.class));
	    }
	    
	    @Test
	    public void seObtieneElNombreDelInspector() {
	    	
	    	// Verify
	    	
	    	assertEquals(inspector.getNombre(),"Pepe");
	    }
	    
	    
}
