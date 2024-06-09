package ar.edu.unq.po2.tpFinal.inspector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.inspectorApp.InspectorApp;
import ar.edu.unq.po2.tpFinal.sem.Sem;
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
	    	inspector = new InspectorApp("pepe",zona);
	    	zona.agregarInspector(inspector);
	    }
	    
	    @Test
	    public void seLeAsignaUnaZonaAUnInspector() {
	    	when(zona.getUbicacion()).thenReturn("Bernal");
	    	assertEquals(inspector.getZona().getUbicacion(),"Bernal"); 
	    }
	    @Test
	    public void seVerificaUnEstacionamiento() {
	    	/*when(inspector.verificarEstacionamiento(sem, patente)).thenReturn(true);
	    	*/
	    }
	    /* when(reloj.getHora()).thenReturn(21); */
}
