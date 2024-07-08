package ar.edu.unq.po2.tpFinal.sem;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.appUsuario.AppUsuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.estacionamiento.EstacionamientoPorApp;
import ar.edu.unq.po2.tpFinal.estacionamiento.EstacionamientoPorCompraPuntual;
import ar.edu.unq.po2.tpFinal.puntoDeVenta.Compra;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Sem implements INotificador {
    private List<ZonaDeEstacionamiento> zonas;
    private List<Estacionamiento> estacionamientos;
    private List<Infraccion> infracciones;
    private List<AppUsuario> usuarios;
    private List<ISuscriptor> suscriptores;
    private LocalTime horaInicioDeFranjaHoraria;
    private LocalTime horaFinDeFranjaHoraria;
    private double precioEstacionamientoPorHora;
    private Reloj reloj; 
    
    public Sem(Reloj reloj) {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.estacionamientos = new ArrayList<Estacionamiento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.usuarios = new ArrayList<AppUsuario>();
        this.suscriptores = new ArrayList<ISuscriptor>();
        this.horaInicioDeFranjaHoraria = LocalTime.of(7, 0);
        this.horaFinDeFranjaHoraria = LocalTime.of(20, 0);
        this.precioEstacionamientoPorHora = 40.0;
        this.reloj = reloj;
    }
    
    //Observer para entidades
    
    public void suscribir(ISuscriptor suscriptor) {
    	this.getSuscriptores().add(suscriptor);
    }

    public void desuscribir(ISuscriptor suscriptor) {
    	this.getSuscriptores().remove(suscriptor);
    }
    
    public void notificarInicioDeEstacionamiento(Estacionamiento estacionamiento) {
    	this.getSuscriptores().stream().forEach(s -> s.actualizarInicioDeEstacionamiento(estacionamiento));
    }
    
    public void notificarFinDeEstacionamiento(Estacionamiento estacionamiento) {
    	this.getSuscriptores().stream().forEach(s -> s.actualizarFinDeEstacionamiento(estacionamiento));
    }
    
    public void notificarRecargaDeCelular(Compra compra) {
    	this.getSuscriptores().stream().forEach(s -> s.actualizarRecargaDeCelular(compra));
    }
    
	//Estacionamiento
    
    public void iniciarEstacionamientoApp(String celular) {
        AppUsuario usuario = this.buscarUsuarioPorCelular(celular);
        if (usuario.getSaldo() > 0) {
            if (estaLaZonaAEstacionarDentroDeLasZonasDelSem(usuario.getZona()) && !estacionamientoVigente(usuario.getPatente()) && esFranjaHoraria()) {
                double horasMaximasSegunSaldo = (usuario.getSaldo() / this.getPrecioEstacionamientoPorHora());
                LocalTime inicio = reloj.obtenerHoraActual();
                LocalDateTime inicioEnDias = reloj.obtenerFechaYHoraActual();
                LocalDateTime finSegunSaldo = inicioEnDias.plusHours((long)(horasMaximasSegunSaldo));
                LocalDateTime finEnDias;
                finEnDias = obtenerFinMasTempranoEnDias(finSegunSaldo);
                LocalTime fin = finEnDias.toLocalTime();

                Estacionamiento nuevoEstacionamiento = new EstacionamientoPorApp(usuario.getPatente(), inicio, fin, celular);
                this.getEstacionamientos().add(nuevoEstacionamiento);

                notificarInicioDeEstacionamiento(nuevoEstacionamiento);
                usuario.recibirInformacionDeEstacionamiento("La hora de inicio del estacionamiento es: " + inicio + 
                                                            ", su saldo alcanza para tener activo el estacionamiento hasta las: " + fin);
            } else {
                usuario.recibirInformacionDeEstacionamiento("El usuario ya tiene un estacionamiento activo "
                                                            + "o el horario esta fuera de la franja horaria "
                                                            + "o la zona no se encuentra dentro del sem");
            }
        } else {
            usuario.recibirInformacionDeEstacionamiento("Saldo insuficiente. Estacionamiento no permitido.");
        }
    }

		
	public void iniciarEstacionamientoCompraPuntual(ZonaDeEstacionamiento zona, String patente, int cantidadDeHsCompradas ) {
		//ZonaDeEstacionamiento zonaActual = encontrarZona(zona);
		if (estaLaZonaAEstacionarDentroDeLasZonasDelSem(zona) && !estacionamientoVigente(patente) && esFranjaHoraria()) {
			LocalTime inicio = reloj.obtenerHoraActual();
			LocalDateTime inicioEnDias = reloj.obtenerFechaYHoraActual();
			LocalDateTime finSegunCantidadHs = inicioEnDias.plusHours(cantidadDeHsCompradas);
			LocalDateTime finEnDias = obtenerFinMasTempranoEnDias(finSegunCantidadHs);
			LocalTime fin = finEnDias.toLocalTime();
			
			Estacionamiento nuevoEstacionamiento = new EstacionamientoPorCompraPuntual (patente, inicio, fin, cantidadDeHsCompradas);
			this.getEstacionamientos().add(nuevoEstacionamiento);
			notificarInicioDeEstacionamiento(nuevoEstacionamiento);
		} else {
			System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
		}
	}
	
	public void finalizarEstacionamientoPorApp(String celular) {
		AppUsuario usuario = this.buscarUsuarioPorCelular(celular);
    	Estacionamiento estacionamiento = estacionamientoDePatente(usuario.getPatente());
    	
    	LocalTime horaActual = reloj.obtenerHoraActual();
    	int duracionDelEstacionamiento = Duration.between(estacionamiento.getInicio(), horaActual).toHoursPart();
    	double saldoADescontar = duracionDelEstacionamiento * this.getPrecioEstacionamientoPorHora();
    	usuario.descontarSaldo(saldoADescontar);
    	LocalTime horaFin = horaActual;
    	LocalTime horaInicio = estacionamiento.getInicio();    		
    	this.getEstacionamientos().remove(estacionamiento);
    	
    	
    	notificarFinDeEstacionamiento(estacionamiento);
    	usuario.recibirInformacionDeEstacionamiento("La hora de inicio del estacionamiento fue: " + horaInicio + 
													", la hora de fin del estacionamiento fue: " + horaFin +
													", la duracion en horas del estacionamiento fue: " + duracionDelEstacionamiento +
													", el costo descontado del estacionamiento fue de: " + saldoADescontar);
    	}
	
	public void finalizarEstacionamiento(String patente) {
    	Estacionamiento estacionamiento = estacionamientoDePatente(patente);
    	this.getEstacionamientos().remove(estacionamiento);
    	notificarFinDeEstacionamiento(estacionamiento);
    } 
	
	public void verificarSiCaducaronLosEstacionamientosYSiEsAsiFinalizarlos() {
		LocalTime ahora = reloj.obtenerHoraActual();
	    List<Estacionamiento> estacionamientosCaducados = new ArrayList<>();

	    this.getEstacionamientos().forEach(e -> {
	        if (e.getFin().isBefore(ahora) || e.getFin().equals(ahora)) {
	            estacionamientosCaducados.add(e);
	        }
	    });

	    estacionamientosCaducados.forEach(e -> finalizarEstacionamiento(e.getPatente()));
	}
	
    public void finalizarTodosLosEstacionamientos() {
    	this.getEstacionamientos().forEach(e -> e.finalizarEstacionamiento(this));
    }
        
    public boolean estaLaZonaAEstacionarDentroDeLasZonasDelSem(ZonaDeEstacionamiento zona) {
        return this.getZonas().stream()
        				 .anyMatch(zonaDeEstacionamiento -> zonaDeEstacionamiento.getUbicacion().equals(zona.getUbicacion()));
    }
    
    public boolean esFranjaHoraria() {
    	LocalTime horaActual = reloj.obtenerHoraActual(); 
    	return (horaActual.isAfter(this.getHoraInicioDeFranjaHoraria()) && horaActual.isBefore(this.getHoraFinDeFranjaHoraria()));
    }  
    
    public boolean estacionamientoVigente(String patente) {
    	return this.getEstacionamientos().stream().anyMatch(estacionamiento -> estacionamiento.getPatente().equals(patente));
    }
    
    public Estacionamiento estacionamientoDePatente(String patente) {
    	return this.getEstacionamientos().stream()
    								  .filter(e -> e.getPatente().equals(patente))
    								  .findFirst()
    								  .orElseThrow(() -> new RuntimeException("No se encontró un Estacionamiento con el usuario dado."));
    }

	private LocalDateTime obtenerFinMasTempranoEnDias(LocalDateTime finSegunSaldo) {
		LocalDateTime finEnDias;
        LocalDate hoy = reloj.obtenerFechaActual();
		if (finSegunSaldo.isBefore(this.getHoraFinDeFranjaHoraria().atDate(hoy))) {
		    finEnDias = finSegunSaldo;
		} else {
		    finEnDias = this.getHoraFinDeFranjaHoraria().atDate(hoy);
		}
		return finEnDias;
	}
    
	//Recarga Celular
	
	public void recargarSaldo(String celular, double monto, Compra compra) {
		AppUsuario usuario = buscarUsuarioPorCelular(celular);
		usuario.recargarSaldo(monto);
		
		notificarRecargaDeCelular(compra);
	}
	
	public void descontarSaldo(String celular, double monto) {
		AppUsuario usuario = buscarUsuarioPorCelular(celular);
		usuario.descontarSaldo(monto)
		
		;	
	}
	
	public AppUsuario buscarUsuarioPorPatente(String patente) {
		return getUsuarios().stream().filter(u -> u.getPatente().equals(patente))
								.findFirst()
								.orElseThrow(() -> new RuntimeException("No se encontró un Usuario con la patente dada"));
	}
	
	public AppUsuario buscarUsuarioPorCelular(String celular) {
		return getUsuarios().stream().filter(u -> u.getCelular().equals(celular))
								.findFirst()
								.orElseThrow(() -> new RuntimeException("No se encontró un Usuario con el celular dado"));
	}

	//Infracciones 

    public void registrarInfraccion(Infraccion infraccion) {
        infracciones.add(infraccion);
    }
	
	//Getters y Setters
    
    
    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }
    
    public double getPrecioEstacionamientoPorHora() {
		return precioEstacionamientoPorHora;
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

	public LocalTime getHoraInicioDeFranjaHoraria() {
		return horaInicioDeFranjaHoraria;
	}

	public LocalTime getHoraFinDeFranjaHoraria() {
		return horaFinDeFranjaHoraria;
	}

	public List<Estacionamiento> getEstacionamientos() {
		return estacionamientos;
	}

	public List<ISuscriptor> getSuscriptores() {
		return suscriptores;
	}

}