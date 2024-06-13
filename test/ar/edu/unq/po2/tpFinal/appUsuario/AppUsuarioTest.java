package ar.edu.unq.po2.tpFinal.appUsuario;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class AppUsuarioTest {
	private Sem sem;
	private AppUsuario usuario;
	private ZonaDeEstacionamiento zona;
	private Reloj reloj;
	
    @BeforeEach
    public void setUp() throws Exception{
    	reloj = mock(Reloj.class);
        sem = new Sem(reloj);
        zona = mock(ZonaDeEstacionamiento.class);
        when(zona.getUbicacion()).thenReturn("Bernal");
        usuario = new AppUsuario("1154534248", "SDA346", new ModoManual(), zona, sem);
    }
        
	@Test
	public void testRecargarSaldo() {
        sem.agregarAppUsuario(usuario);
		sem.recargarSaldo(1500, "SDA346");
		
		assertEquals(usuario.getSaldo(), 1500);
	}
	
	@Test
	public void testRecargarSaldoInvalido() throws Exception {
		assertThrows(Exception.class, () -> sem.recargarSaldo(1500, "SDA346"));
	}
	
	@Test
	public void testDescontarSaldo() {
        sem.agregarAppUsuario(usuario);
		sem.recargarSaldo(1500, "SDA346");
		//sem.descontarSaldo(400, "SDA346"); 
		usuario.descontarSaldo(400);
		
		assertEquals(usuario.getSaldo(), 1100);
	}
	
    @Test
    public void testIniciarEstacionamientoValido() {
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 12, 4, 0)); 
        
        sem.agregarAppUsuario(usuario);
        sem.recargarSaldo(1500, "SDA346");
        usuario.iniciarEstacionamiento();
        
        assertTrue(sem.estacionamientoVigente("SDA346"));
    }
	
    @Test
    public void testIniciarEstacionamientoInvalido() {
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 12, 11, 0)); 
        
        sem.agregarAppUsuario(usuario);
        sem.recargarSaldo(1500, "SDA346");
        usuario.iniciarEstacionamiento();
        
        assertFalse(sem.estacionamientoVigente("SDA346"));
    }
	
}
