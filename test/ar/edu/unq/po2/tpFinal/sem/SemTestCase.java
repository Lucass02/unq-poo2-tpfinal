package ar.edu.unq.po2.tpFinal.sem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.appUsuario.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.Compra;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.RecargaCelular;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;


public class SemTestCase {
	private Sem sem;
	private Reloj relojMock;
	private AppUsuario usuarioMock;
	private ZonaDeEstacionamiento zonaMock;
	private ZonaDeEstacionamiento zonaMock2;
	private Estacionamiento estacionamientoMock;
	private Infraccion infraccion;
	private Compra compra;
	
	
    @BeforeEach
    public void setUp(){
    	relojMock = mock(Reloj.class);
    	sem =  new Sem(relojMock);
    	usuarioMock = mock(AppUsuario.class);
    	zonaMock = mock(ZonaDeEstacionamiento.class);
    	zonaMock2 = mock(ZonaDeEstacionamiento.class);
    	estacionamientoMock = mock(Estacionamiento.class);
    	compra = mock(Compra.class);
    	
         when(usuarioMock.getCelular()).thenReturn("1124831610");
         when(usuarioMock.getPatente()).thenReturn("AAA111");
         when(usuarioMock.getSaldo()).thenReturn(100.0);
         when(usuarioMock.getZona()).thenReturn(zonaMock);
         when(zonaMock.getUbicacion()).thenReturn("Bernal");
         when(zonaMock2.getUbicacion()).thenReturn("Quilmes");
         
         sem.agregarAppUsuario(usuarioMock);
         sem.agregarZona(zonaMock);
    }
    
    @Test
    public void testElRelojEstaEnFranjaHoraria() {
    	 when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(10, 0));
         when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 10, 0));
    	
    	assertTrue(sem.esFranjaHoraria()); 
    }
    
    @Test
    public void testElRelojEstaFueraDeFranjaHoraria() {
    	 when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(5, 0));
         when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 5, 0));
    	
    	assertFalse(sem.esFranjaHoraria()); 
    }
    
    @Test
    public void testLaZonaEstaDentroDelSem() {
    	
    	assertTrue(sem.estaLaZonaAEstacionarDentroDeLasZonasDelSem(zonaMock));
    }
    
    @Test
    public void testLaZonaNoEstaDentroDelSem() {
    	
    	assertFalse(sem.estaLaZonaAEstacionarDentroDeLasZonasDelSem(zonaMock2));
    }
    
    @Test
    public void testIniciarEstacionamientoAppConSaldoSuficienteDentroDeFranjaHoraria() {
    	when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(10, 0));
        when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 10, 0));
        when(relojMock.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13));
        
        sem.iniciarEstacionamientoApp(usuarioMock);
        
        assertEquals(1, sem.getEstacionamientos().size());
        verify(usuarioMock, times(1)).recibirInformacionDeEstacionamiento("La hora de inicio del estacionamiento es: 10:00" +
        																  ", su saldo alcanza para tener activo el estacionamiento hasta las: 12:00");
    }
    
    @Test
    public void testIniciarEstacionamientoAppConSaldoInsuficiente() {
        when(usuarioMock.getSaldo()).thenReturn(0.0);

        sem.iniciarEstacionamientoApp(usuarioMock);
        
        assertEquals(0, sem.getEstacionamientos().size());
        verify(usuarioMock, times(1)).recibirInformacionDeEstacionamiento("Saldo insuficiente. Estacionamiento no permitido.");
    }
    
    @Test
    public void testIniciarEstacionamientoPuntualConUnaCantidadDeHs() {
    	when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(10, 0));
        when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 10, 0));
        when(relojMock.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13));
        
        sem.iniciarEstacionamientoCompraPuntual(zonaMock, usuarioMock.getPatente(), 7);
        
        assertEquals(1, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testNoIniciarEstacionamientoPuntualPorNoEstarDentroDeLaZona() {
    	sem.getZonas().clear();
        
        sem.iniciarEstacionamientoCompraPuntual(zonaMock, usuarioMock.getPatente(), 7);
        
        assertEquals(0, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testFinalizarEstacionamientoPorApp() {
    	when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(10, 0));
        when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 10, 0));
        when(relojMock.obtenerFechaActual()).thenReturn(LocalDate.of(2024, 6, 13));
        
        sem.iniciarEstacionamientoApp(usuarioMock);
        
        when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(12, 0));
        when(relojMock.obtenerFechaYHoraActual()).thenReturn(LocalDateTime.of(2024, 6, 13, 12, 0));
        sem.finalizarEstacionamientoPorApp(usuarioMock);
        
        assertEquals(0, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testSuscribirYDesuscribir() {
        ISuscriptor suscriptorMock = mock(ISuscriptor.class);
        sem.suscribir(suscriptorMock);
        
        assertTrue(sem.getSuscriptores().contains(suscriptorMock));
        
        sem.desuscribir(suscriptorMock);
        
        assertFalse(sem.getSuscriptores().contains(suscriptorMock));
    }
    
    @Test
    public void testVerificarSiCaducaronLosEstacionamientosYSiEsAsiFinalizarlos() {
        when(estacionamientoMock.getFin()).thenReturn(LocalTime.of(9, 0));
        when(estacionamientoMock.getPatente()).thenReturn("AAA111");
        sem.getEstacionamientos().add(estacionamientoMock);
        when(relojMock.obtenerHoraActual()).thenReturn(LocalTime.of(14, 0));
        
        sem.verificarSiCaducaronLosEstacionamientosYSiEsAsiFinalizarlos();
        
        assertEquals(0, sem.getEstacionamientos().size());
    }
    
    @Test
    public void testFinalizarTodosLosEstacionamientos() {
        sem.getEstacionamientos().add(estacionamientoMock);
        sem.finalizarTodosLosEstacionamientos();
        
        verify(estacionamientoMock).finalizarEstacionamiento(sem);
    }
    
    @Test
    public void testRecargarSaldo() {
        sem.recargarSaldo("1124831610", 50.0,compra);
        
        verify(usuarioMock, times(1)).recargarSaldo(50.0);
    }
    
    @Test
    public void testDescontarSaldo() {
        sem.descontarSaldo("1124831610", 20.0);
        
        verify(usuarioMock, times(1)).descontarSaldo(20.0);
    }
    @Test
    public void testRegistrarInfraccion() {
        sem.registrarInfraccion(infraccion);
        
        assertEquals(sem.getInfracciones().size(),1);
    }
}

