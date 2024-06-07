package ar.edu.unq.po2.tpFinal.sem;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SemTestCase {
	private Sem sem1;
	private Reloj reloj;
	
    @BeforeEach
    public void setUp(){
    	sem1 =  new Sem();
    }
    
    @Test
    public void testRelojEnFranjaHoraria() {
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(17);
    	assertTrue(sem1.esFranjaHoraria(reloj)); 
    }
    
    @Test
    public void testRelojFueraDeFranjaHoraria() {
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(21);
    	assertFalse(sem1.esFranjaHoraria(reloj)); 
    }
                            
}

