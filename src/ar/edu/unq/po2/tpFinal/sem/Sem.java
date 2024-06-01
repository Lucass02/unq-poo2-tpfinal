package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.estacionamiento.Usuario;
import ar.edu.unq.po2.tpFinal.estacionamiento.Vehiculo;
import ar.edu.unq.po2.tpFinal.inspector.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Sem {
    private List<ZonaDeEstacionamiento> zonas;
    private List<Evento> eventos;
    private List<Infraccion> infracciones;
    private List<Estacionamiento> estacionamientosActivos;
    private int horaInicioDeFranjaHoraria;
    private int horaFinDeFranjaHoraria;
    private int horaActual;
    

    public Sem(LocalTime horaFinDeFranjaHoraria, LocalTime horaInicioDeFranjaHoraria) {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.eventos = new ArrayList<Evento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.estacionamientosActivos = new ArrayList<Estacionamiento>();
        this.horaInicioDeFranjaHoraria = 7;
        this.horaFinDeFranjaHoraria = 20;
        this.horaActual = 12;
    }

    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }

    public void iniciarEstacionamiento(Usuario usuario) {
    	
    	boolean existeUsuario = estacionamientosActivos.stream().anyMatch(estacionamiento -> estacionamiento.getUsuario().equals(usuario));
    	if (! esFranjaHoraria()) {
    		System.out.println("Horario fuera de franja horaria");
    		return;
    	}
    	if (! existeUsuario) {
    		Estacionamiento estacionamiento = new Estacionamiento(usuario);
    		estacionamientosActivos.add(estacionamiento);
    	} else {
            System.out.println("El usuario ya tiene un estacionamiento activo");
        }
    }

    public void finalizarEstacionamiento(Usuario usuario) {
    	
    	/* Extract method: existeUsuario(usuario)*/
    	boolean existeUsuario = estacionamientosActivos.stream().anyMatch(estacionamiento -> estacionamiento.getUsuario().equals(usuario));
    	/* Extract method: estacionamientoUsuario(usuario) */
    	Estacionamiento estacionamientoUsuario = estacionamientosActivos.stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró un Estacionamiento con el usuario dado."));
    	
    	if (existeUsuario) {
    		estacionamientoUsuario.finalizarEstacionamiento();
    		estacionamientosActivos.remove(estacionamientoUsuario);
    	} else {
            System.out.println("El usuario no tiene ningún estacionamiento activo");
        }
    }
    
    public boolean esFranjaHoraria() {
    	return (this.horaInicioDeFranjaHoraria < this.horaActual && 
    			this.horaFinDeFranjaHoraria > this.horaActual);
    }
    
    public void finalizarTodosLosEstacionamientos() {
        for (Estacionamiento e : estacionamientosActivos) {
            if (e.estaVigente()) {
                e.finalizarEstacionamiento();
            }
        }
        estacionamientosActivos.clear();
    }

    public void registrarInfraccion(Infraccion infraccion) {
        infracciones.add(infraccion);
    }

    public boolean consultarEstacionamiento(String patente) {
        for (Estacionamiento e : estacionamientosActivos) {
            if (e.getVehiculo().getPatente().equals(patente) && e.estaVigente()) {
                return true;
            }
        }
        return false;
    }

    public void suscribir(Evento evento) {
        eventos.add(evento);
    }

    public void desuscribir(Evento evento) {
        eventos.remove(evento);
    }

    private void notificar(Evento evento) {
        for (Evento e : eventos) {
            if (e.getTipo().equals(evento.getTipo())) {
                e.notificar();
            }
        }
    }

    public void chequearYFinalizarEstacionamientos() {
        if (LocalTime.now().isAfter(horaFinDeFranjaHoraria)) {
            finalizarTodosLosEstacionamientos();
        }
    }

    private Usuario buscarUsuarioPorCelular(String celular) {
        for (Usuario u : usuarios) {
            if (u.getCelular().equals(celular)) {
                return u;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                return v;
            }
        }
        return null;
    }

	public LocalTime getHoraFinDeFranjaHoraria() {
		return horaFinDeFranjaHoraria;
	}

	public void setHoraFinDeFranjaHoraria(LocalTime horaFinDeFranjaHoraria) {
		this.horaFinDeFranjaHoraria = horaFinDeFranjaHoraria;
	}

	public List<ZonaDeEstacionamiento> getZonas() {
		return zonas;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public List<Estacionamiento> getEstacionamientosActivos() {
		return estacionamientosActivos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

}