package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unq.po2.tpFinal.estacionamiento.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.estacionamiento.EstacionamientoPorApp;
import ar.edu.unq.po2.tpFinal.estacionamiento.EstacionamientoPorCompraPuntual;
import ar.edu.unq.po2.tpFinal.inspectorApp.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Sem implements INotificador {
    private List<ZonaDeEstacionamiento> zonas;
    private List<Estacionamiento> estacionamientos;
    private List<Infraccion> infracciones;
    private List<AppUsuario> usuarios;
    private List<ISuscriptor> suscriptores;
    
    
    public Sem() {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.estacionamientos = new ArrayList<Estacionamiento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.usuarios = new ArrayList<AppUsuario>();
        this.suscriptores = new ArrayList<ISuscriptor>();
    }
    
    //Observer para entidades
    
    public void suscribir(ISuscriptor suscriptor) {
    	suscriptores.add(suscriptor);
    }

    public void desuscribir(ISuscriptor suscriptor) {
    	suscriptores.remove(suscriptor);
    }
    
    public void notificar(String evento) {
    	suscriptores.stream().forEach(s -> s.actualizar(evento));
    }
    
    
	//Estacionamiento
	
	public void asignarEstacionamientoPorApp(String patente, ZonaDeEstacionamiento zona, LocalDateTime inicio, String celular) {
		if (!estacionamientoVigente(patente) && esFranjaHoraria(inicio)) {
			Estacionamiento nuevoEstacionamiento = new EstacionamientoPorApp(patente, zona, inicio, celular);
			nuevoEstacionamiento.iniciarEstacionamiento();
			estacionamientos.add(nuevoEstacionamiento);
			notificar("Se inicio el estacionamiento para la patente: " + patente);
		} else {
			System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
		}
	}
	
	public void asignarEstacionamientoPorCompraPuntual(String patente, ZonaDeEstacionamiento zona, LocalDateTime inicio, int cantidadDeHsCompradas) {
		if (!estacionamientoVigente(patente) && esFranjaHoraria(inicio)) {
			Estacionamiento nuevoEstacionamiento = new EstacionamientoPorCompraPuntual(patente, zona, inicio, cantidadDeHsCompradas);
			nuevoEstacionamiento.iniciarEstacionamiento();
			estacionamientos.add(nuevoEstacionamiento);
		} else {
			System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
		}
	}
	
	public void finalizarEstacionamiento(String patente) {
    	if (estacionamientoVigente(patente)) {
    		Estacionamiento estacionamiento = estacionamientoDePatente(patente);
    		estacionamiento.finalizarEstacionamiento();
    		estacionamientos.remove(estacionamiento);
    		notificar("Se finalizo el estacionamiento para la patente: " + patente);
    	} else {
            System.out.println("El usuario no tiene ningún estacionamiento activo");
        }
    }

    public void finalizarTodosLosEstacionamientos() {
        for (Estacionamiento e : estacionamientos) {
            if (e.estaVigente()) {
                e.finalizarEstacionamiento();
            }
        }
        estacionamientos.clear();
    }
	
    public boolean estacionamientoVigente(String patente) {
    	return estacionamientos.stream().anyMatch(estacionamiento -> estacionamiento.getPatente().equals(patente));
    }
    
    public Estacionamiento estacionamientoDePatente(String patente) {
    	return estacionamientos.stream()
    								  .filter(e -> e.getPatente().equals(patente))
    								  .findFirst()
    								  .orElseThrow(() -> new RuntimeException("No se encontró un Estacionamiento con el usuario dado."));
    }

    
    public boolean esFranjaHoraria(LocalDateTime horaInicioEstacionamiento) {
    	LocalDateTime ahora = LocalDateTime.now();
    	LocalDateTime horaInicioDeFranjaHoraria = LocalDateTime.of(ahora.getYear(), ahora.getMonth(), ahora.getDayOfMonth(), 7, 0);
    	LocalDateTime horaFinDeFranjaHoraria = LocalDateTime.of(ahora.getYear(), ahora.getMonth(), ahora.getDayOfMonth(), 20, 0);
    	return (horaInicioEstacionamiento.isAfter(horaInicioDeFranjaHoraria) && horaInicioEstacionamiento.isBefore(horaFinDeFranjaHoraria));
    }  
    
    /* PARA QUE SE REQUERIA??
    public boolean consultarEstacionamiento(String patente) {
        for (Estacionamiento e : estacionamientosActivos) {
            if (e.getVehiculo().getPatente().equals(patente) && e.estaVigente()) {
                return true;
            }
        }
        return false;
    }
    */
    
	//Recarga Celular
	
	public void recargarSaldo(double monto, String patente) {
		buscarUsuarioPorPatente(patente).ifPresent(u -> u.recargarSaldo(monto));
		
		String celular = buscarUsuarioPorPatente(patente)
                			.map(AppUsuario::getCelular)
                			.orElse("Número de celular no encontrado");
		
		notificar("Se recargo saldo para el celular: " + celular + "por un monto de: " + monto );
	}
	
	public Optional<AppUsuario> buscarUsuarioPorPatente(String patente) {
		return usuarios.stream().filter(u -> u.getPatente().equals(patente))
								.findFirst();
	}

	//Infracciones 

    public void registrarInfraccion(Infraccion infraccion) {
        infracciones.add(infraccion);
    }
	
	//Getters y Setters
    
    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }
    
    public void agregarAppUsuario(AppUsuario usuario) {
        usuarios.add(usuario);
    }
    
    public List<AppUsuario> getUsuarios() {
		return usuarios;
	}
    
	public List<ZonaDeEstacionamiento> getZonas() {
		return zonas;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	
}