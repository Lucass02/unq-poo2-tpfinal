package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.estacionamiento.Usuario;
import ar.edu.unq.po2.tpFinal.inspector.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Sem {
    private List<ZonaDeEstacionamiento> zonas;
    private List<Evento> eventos;
    private List<Infraccion> infracciones;
    private List<Estacionamiento> estacionamientosActivos;
    private int horaInicioDeFranjaHoraria;
    private int horaFinDeFranjaHoraria;

    public Sem() {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.eventos = new ArrayList<Evento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.estacionamientosActivos = new ArrayList<Estacionamiento>();
        this.horaInicioDeFranjaHoraria = 7;
        this.horaFinDeFranjaHoraria = 20;
    }

    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }

    public void iniciarEstacionamiento(Usuario usuario, Reloj reloj) {
    	if (!existeUsuario(usuario) && esFranjaHoraria(reloj)) {
    		Estacionamiento estacionamiento = new Estacionamiento(usuario);
    		estacionamientosActivos.add(estacionamiento);
    	} else {
            System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
        }
    }

    public void finalizarEstacionamiento(Usuario usuario) {
    	if (existeUsuario(usuario)) {
    		Estacionamiento estacionamiento = estacionamientoUsuario(usuario);
    		estacionamiento.finalizarEstacionamiento();
    		estacionamientosActivos.remove(estacionamiento);
    	} else {
            System.out.println("El usuario no tiene ningún estacionamiento activo");
        }
    }
    
    public boolean existeUsuario(Usuario usuario) {
    	return estacionamientosActivos.stream().anyMatch(estacionamiento -> estacionamiento.getUsuario().equals(usuario));
    }
    
    public Estacionamiento estacionamientoUsuario(Usuario usuario) {
    	return estacionamientosActivos.stream()
    								  .filter(e -> e.getUsuario().equals(usuario))
    								  .findFirst()
    								  .orElseThrow(() -> new RuntimeException("No se encontró un Estacionamiento con el usuario dado."));
    }
        
    public boolean esFranjaHoraria(Reloj reloj) {
        return (this.horaInicioDeFranjaHoraria <= reloj.getHora() &&
                reloj.getHora() < this.horaFinDeFranjaHoraria);
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

    //public boolean consultarEstacionamiento(String patente) {
    //    for (Estacionamiento e : estacionamientosActivos) {
    //        if (e.getVehiculo().getPatente().equals(patente) && e.estaVigente()) {
    //            return true;
    //        }
    //    }
    //    return false;
    //}

    public void suscribir(Evento evento) {
        eventos.add(evento);
    }

    public void desuscribir(Evento evento) {
        eventos.remove(evento);
    }

   // private void notificar(Evento evento) {
   //     for (Evento e : eventos) {
   //         if (e.getTipo().equals(evento.getTipo())) {
   //             e.notificar();
   //         }
   //     }
   // }

	public int getHoraFinDeFranjaHoraria() {
		return horaFinDeFranjaHoraria;
	}

	public void setHoraFinDeFranjaHoraria(int horaFinDeFranjaHoraria) {
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

	public void asignarEstacionamiento(ZonaDeEstacionamiento zona, Usuario usuario, double cantidadDeHsCompradas) {
		//Debe implementarse proximamente ya que se deben poder registrar bien los estacionamientos.
		
		// iniciarEstacionamiento(usuario, LocalDataTimeNow());	
	}

	public void recargarSaldo(double monto, Usuario usuario) {
		usuario.recargarSaldo(monto);
	}

}