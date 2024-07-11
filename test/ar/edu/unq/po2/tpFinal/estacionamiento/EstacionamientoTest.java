package ar.edu.unq.po2.tpFinal.estacionamiento;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.appUsuario.AppUsuario;
import ar.edu.unq.po2.tpFinal.sem.Sem;

public class EstacionamientoTest {
	private Estacionamiento estacionamientoApp;
	private Estacionamiento estacionamientoPuntual;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Sem sem;
	private AppUsuario usuario;
	
	
	
	@BeforeEach
	public void SetUp() {
		horaInicio = LocalTime.of(10, 0);
		horaFin = LocalTime.of(12, 0);
		sem = mock(Sem.class);
		usuario = mock(AppUsuario.class);
		estacionamientoApp = new EstacionamientoPorApp("ABC123", horaInicio, horaFin, usuario);
		estacionamientoPuntual = new EstacionamientoPorCompraPuntual("DEF456", horaInicio, horaFin, 2);
	}
	
	/*Test estacionamiento puntual*/
	@Test
	void seIniciaUnEstacionamientoPuntual() {
		// Verify
		assertEquals(estacionamientoApp.getInicio().getHour(),10);
	}
	
	@Test
	void seFinalizaUnEstacionamientoPuntual() { 
		// Excercise
		estacionamientoPuntual.finalizarEstacionamiento(sem);
		// Verify
		verify(sem).finalizarEstacionamiento(estacionamientoPuntual.getPatente());
	}
	
	@Test
	void seObtieneLaHoraFin() { 
		// Verify
		assertEquals(estacionamientoPuntual.getFin().getHour(),12);
	}
	
	/*Test estacionamiento App*/
	@Test
	void seIniciaUnEstacionamientoApp() {
		// Verify
		assertEquals(estacionamientoPuntual.getInicio().getHour(),10);
	}
	
	@Test
	void seFinalizaUnEstacionamientoApp() { 
		// Excercise
		estacionamientoApp.finalizarEstacionamiento(sem);
		// Verify
		verify(sem).finalizarEstacionamientoPorApp(usuario);
	} 
}
