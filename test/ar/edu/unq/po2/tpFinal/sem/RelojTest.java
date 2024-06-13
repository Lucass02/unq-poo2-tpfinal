package ar.edu.unq.po2.tpFinal.sem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RelojTest {

    private Reloj reloj;

    @BeforeEach
    public void setUp() {
        reloj = new Reloj();
    }

    @Test
    public void testObtenerHoraActual() {
        LocalTime horaActual = reloj.obtenerHoraActual();
        
        assertEquals(horaActual, reloj.obtenerHoraActual());
    }

    @Test
    public void testObtenerFechaYHoraActual() {
        LocalDateTime fechaHoraActual = reloj.obtenerFechaYHoraActual();

        assertEquals(fechaHoraActual, reloj.obtenerFechaYHoraActual());
    }

    @Test
    public void testObtenerFechaActual() {
        LocalDate fechaActual = reloj.obtenerFechaActual();

        assertEquals(fechaActual, reloj.obtenerFechaActual());
    }
}
