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
    private List<Usuario> usuarios;
    private List<Vehiculo> vehiculos;
    private LocalTime horaFinDeFranjaHoraria;

    public Sem(LocalTime horaFinDeFranjaHoraria) {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.eventos = new ArrayList<Evento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.estacionamientosActivos = new ArrayList<Estacionamiento>();
        this.usuarios = new ArrayList<Usuario>();
        this.vehiculos = new ArrayList<Vehiculo>();
        this.horaFinDeFranjaHoraria = horaFinDeFranjaHoraria;
    }

    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void iniciarEstacionamiento(String patente, String celular) {
        Usuario usuario = buscarUsuarioPorCelular(celular);
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);

        if (usuario != null && vehiculo != null) {
            Estacionamiento estacionamiento = new Estacionamiento(vehiculo, usuario);
            estacionamientosActivos.add(estacionamiento);

            Evento evento = new Evento("Inicio", patente, celular);
            notificar(evento);
        } else {
            System.out.println("Usuario o vehículo no encontrado.");
        }
    }

    public void finalizarEstacionamiento(String patente, String celular) {
        for (Estacionamiento e : estacionamientosActivos) {
            if (e.getVehiculo().getPatente().equals(patente) && e.estaVigente()) {
                e.finalizarEstacionamiento();
                Evento evento = new Evento("Fin", patente, celular);
                notificar(evento);
                break;
            }
        }
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