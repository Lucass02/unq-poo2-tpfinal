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
    
	public void iniciarEstacionamientoApp(String celular) {
		//ZonaDeEstacionamiento zonaActual = encontrarZona(zona);
		AppUsuario usuario = this.buscarUsuarioPorCelular(celular);
		//Mas condiciones respecto al saldo 
		//Devolverle la informacion del estacionamiento al usuario
		if (estaLaZonaAEstacionarDentroDeLasZonasDelSem(usuario.getZona()) && !estacionamientoVigente(usuario.getPatente()) && esFranjaHoraria()) {
			Estacionamiento nuevoEstacionamiento = new EstacionamientoPorApp(usuario.getPatente(), celular);
			nuevoEstacionamiento.iniciarEstacionamiento();
			estacionamientos.add(nuevoEstacionamiento);
			notificar("Se inicio el estacionamiento para la patente: " + usuario.getPatente());
		} else {
			System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
		}
	}
	
	public void iniciarEstacionamientoCompraPuntual(ZonaDeEstacionamiento zona, String patente, int cantidadDeHsCompradas ) {
		//ZonaDeEstacionamiento zonaActual = encontrarZona(zona);
		if (estaLaZonaAEstacionarDentroDeLasZonasDelSem(zona) && !estacionamientoVigente(patente) && esFranjaHoraria()) {
			Estacionamiento nuevoEstacionamiento = new EstacionamientoPorCompraPuntual (patente, cantidadDeHsCompradas);
			nuevoEstacionamiento.iniciarEstacionamiento();
			estacionamientos.add(nuevoEstacionamiento);
			notificar("Se inicio el estacionamiento para la patente: " + patente);
		} else {
			System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
		}
	}
	
	public void finalizarEstacionamientoPorApp(String celular) {
		AppUsuario usuario = this.buscarUsuarioPorCelular(celular);
		//Devolverle la informacion del estacionamiento al usuario 
    	if (estacionamientoVigente(usuario.getPatente())) {
    		Estacionamiento estacionamiento = estacionamientoDePatente(usuario.getPatente());
    		estacionamiento.finalizarEstacionamiento();
    		estacionamientos.remove(estacionamiento);
    		notificar("Se finalizo el estacionamiento para la patente: " + usuario.getPatente());
    	} else {
            System.out.println("El usuario no tiene ningún estacionamiento activo");
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
    
    // No se usa
    /*private ZonaDeEstacionamiento encontrarZona(ZonaDeEstacionamiento zona) {
		ZonaDeEstacionamiento zonaActual = (this.zonas.stream()
							.filter(zonaDeEstacionamiento -> zonaDeEstacionamiento.getUbicacion().equals(zona.getUbicacion()))
						    .findFirst()
						    .orElseThrow(() -> new RuntimeException("No existe la zona dentro del sistema")));
		return zonaActual;
	}*/
    
    private boolean estaLaZonaAEstacionarDentroDeLasZonasDelSem(ZonaDeEstacionamiento zona) {
        return this.zonas.stream()
        				 .anyMatch(zonaDeEstacionamiento -> zonaDeEstacionamiento.getUbicacion().equals(zona.getUbicacion()));
    }
    
    public boolean esFranjaHoraria() {
    	LocalDateTime ahora = LocalDateTime.now();
    	LocalDateTime horaInicioDeFranjaHoraria = LocalDateTime.of(ahora.getYear(), ahora.getMonth(), ahora.getDayOfMonth(), 7, 0);
    	LocalDateTime horaFinDeFranjaHoraria = LocalDateTime.of(ahora.getYear(), ahora.getMonth(), ahora.getDayOfMonth(), 20, 0);
    	return (ahora.isAfter(horaInicioDeFranjaHoraria) && ahora.isBefore(horaFinDeFranjaHoraria));
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
    
    
	//Recarga Celular
	
	public void recargarSaldo(double monto, String patente) {
		AppUsuario usuario = buscarUsuarioPorPatente(patente);
		usuario.recargarSaldo(monto);
		
		String celular = usuario.getCelular();
		notificar("Se recargo saldo para el celular: " + celular + "por un monto de: " + monto );
	}
	
	public AppUsuario buscarUsuarioPorPatente(String patente) {
		return usuarios.stream().filter(u -> u.getPatente().equals(patente))
								.findFirst()
								.orElseThrow(() -> new RuntimeException("No se encontró un Usuario con el Celular dado"));
	}
	
	public AppUsuario buscarUsuarioPorCelular(String celular) {
		return usuarios.stream().filter(u -> u.getCelular().equals(celular))
								.findFirst()
								.orElseThrow(() -> new RuntimeException("No se encontró un Usuario con el Celular dado"));
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
	
}