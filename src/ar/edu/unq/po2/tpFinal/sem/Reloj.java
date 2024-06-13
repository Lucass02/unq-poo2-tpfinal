package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reloj {
	
    public LocalTime obtenerHoraActual() {
        return LocalTime.now();
    }
    
    public LocalDateTime obtenerFechaYHoraActual() {
        return LocalDateTime.now();
    }
    
    public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }
    
}
