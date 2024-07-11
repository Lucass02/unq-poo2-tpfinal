package ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.InspectorApp;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

class InfraccionTestCase {
	private InspectorApp inspector;
	private String patente;
	private Infraccion infraccion;
	private ZonaDeEstacionamiento zona;
	
	@BeforeEach
	public void SetUp() {
		
		patente = "ABC123";
		
		inspector = new InspectorApp("Pepe");
		
		zona = new ZonaDeEstacionamiento("Bernal");
		
		zona.agregarInspector(inspector);
		
		infraccion = new Infraccion(inspector,patente);
	}
	
	@Test
	void seObtieneLaFechaYHoraDeLaInfraccion() {
		// Verify
		assertEquals(infraccion.getFechaHora().getHour(),LocalDateTime.now().getHour());
	}
	
	
	@Test
	void seObtieneLaPatente() {
		// Verify
		assertEquals(infraccion.getPatente(),patente);
	}
	
	
	@Test
	void seObtieneLaZona() {
		// Verify
		assertEquals(infraccion.getZona().getUbicacion(),"Bernal");
	}
	
	
	@Test
	void seObtieneElInspector() {
		// Verify
		assertEquals(infraccion.getInspector(),inspector);
	}
	
	
}
