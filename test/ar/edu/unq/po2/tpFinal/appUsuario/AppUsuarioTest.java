package ar.edu.unq.po2.tpFinal.appUsuario;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.puntoDeVenta.PuntoDeVenta;
import ar.edu.unq.po2.tpFinal.sem.Reloj;
import ar.edu.unq.po2.tpFinal.sem.Sem;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class AppUsuarioTest {
	private Sem sem;
	private AppUsuario usuario;
	private ZonaDeEstacionamiento zona;
	private Reloj reloj;
	private PuntoDeVenta puntoVenta;
	
    @BeforeEach
    public void setUp() throws Exception {
    	reloj = mock(Reloj.class);
        sem = new Sem(reloj);
        zona = new ZonaDeEstacionamiento("Bernal");
        usuario = new AppUsuario("1154534248", "SDA346", new ModoManual(), zona, sem, new AsistenciaDesactivada());
        puntoVenta = new PuntoDeVenta(100, zona, sem);
    }
        
	@Test
	public void testRecargarSaldoValido() {
        sem.agregarAppUsuario(usuario);
		puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
		
		assertEquals(usuario.getSaldo(), 2000);
	}
	
	  
	@Test
	public void testRecargarSaldoInvalido() throws Exception {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> puntoVenta.RecargaCelular(usuario.getCelular(), 2000));
		
	    assertEquals("No se encontró un Usuario con el celular dado", exception.getMessage());
	} 
	


	
	
	
	
	
	@Test
	public void testDescontarSaldo() {
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
		usuario.descontarSaldo(900);
        
		assertEquals(usuario.getSaldo(), 1100);
	}
	
    @Test
    public void testIniciarEstacionamientoValido() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        usuario.iniciarEstacionamiento();
        
        assertTrue(sem.estacionamientoVigente("SDA346"));
    }
	
    @Test
    public void testIniciarEstacionamientoFueraDeHorario() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(23, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 23, 0)); 
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        usuario.iniciarEstacionamiento();
        
        assertFalse(sem.estacionamientoVigente("SDA346"));
    }
    
    @Test
    public void testIniciarEstacionamientoYaIniciado() {
    	when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0));
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        usuario.iniciarEstacionamiento();
        usuario.iniciarEstacionamiento();
        
        assertEquals(1, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testFinalizarEstacionamientoValido() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        usuario.iniciarEstacionamiento();
        
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(19, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 19, 0)); 
        
        usuario.finalizarEstacionamiento();
        
        assertEquals(0, sem.getEstacionamientos().size());
        assertEquals(usuario.getSaldo(), 1880);
    }
	
    @Test
    public void testFinalizarEstacionamientoInvalido() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
        usuario.finalizarEstacionamiento();
        assertEquals(0, sem.getEstacionamientos().size());
    }
	    
    @Test
    public void testWalkingModoAutomatico() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	
        usuario.activarModoAutomatico();
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.walking();
        
        assertTrue(sem.estacionamientoVigente("SDA346"));
    }
    
    @Test
    public void testDrivingModoAutomatico() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	
        usuario.activarModoAutomatico();
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.walking();
    	
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(18, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 18, 0)); 
    	
        usuario.driving();
        
        assertEquals(0, sem.getEstacionamientos().size());
        assertEquals(usuario.getSaldo(), 1920);
    }
    
    @Test
    public void testDrivingYWalkingModoManual() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	  
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.walking();
    	
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(18, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 18, 0)); 
    	
        usuario.driving();
        
        assertEquals(0, sem.getEstacionamientos().size());
        assertEquals(usuario.getSaldo(), 2000);
    }
    @Test
    public void testWalkingConEstacionamientoIniciadoModoAutomatico() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	
        usuario.activarModoAutomatico();
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.walking();
    	
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(18, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 18, 0)); 
    	
        usuario.walking();
        
        assertEquals(1, sem.getEstacionamientos().size());
    }
    @Test
    public void testDrivingConEstacionamientoIniciadoModoAutomatico() {
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	usuario.asistenciaDesactivada();
        usuario.activarModoAutomatico();
        
        sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.driving();
    	
        when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(18, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 18, 0)); 
    	
        usuario.driving();
        
        assertEquals(0, sem.getEstacionamientos().size());
    }
    @Test
    public void testAsistenciaActivadaDriving() {
    	when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	usuario.asistenciaActivada();
    	usuario.activarModoManual();
    	
    	sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        puntoVenta.RecargaCelular(usuario.getCelular(), 2000);
        
    	usuario.iniciarEstacionamiento();
    	System.out.println("Empiezo a manejar");
    	usuario.driving();
    	
    	assertEquals(1, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testAsistenciaActivadaWalking() {
    	when(reloj.obtenerHoraActual()).thenReturn(LocalTime.of(16, 0)); 
        when(reloj.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13)); 
        when(reloj.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 16, 0)); 
    	usuario.asistenciaActivada();
    	
    	sem.agregarZona(zona);
        sem.agregarAppUsuario(usuario);
        
    	System.out.println("Empiezo a caminar");
    	usuario.walking();
    	usuario.walking();
    	
    	assertEquals(0, sem.getEstacionamientos().size());
    }
}
