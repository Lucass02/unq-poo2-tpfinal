package ar.edu.unq.po2.tpFinal.sem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.estacionamiento.Estacionamiento;
import ar.edu.unq.po2.tpFinal.estacionamiento.Usuario;
import ar.edu.unq.po2.tpFinal.inspectorApp.Infraccion;
import ar.edu.unq.po2.tpFinal.zonaDeEstacionamiento.ZonaDeEstacionamiento;

public class Sem implements INotificador {
    private List<ZonaDeEstacionamiento> zonas;
    private List<Infraccion> infracciones;
    private int horaInicioDeFranjaHoraria;
    private int horaFinDeFranjaHoraria;
    private List<ISuscriptor> suscriptores;
    
    
    public Sem() {
        this.zonas = new ArrayList<ZonaDeEstacionamiento>();
        this.infracciones = new ArrayList<Infraccion>();
        this.suscriptores = new ArrayList<ISuscriptor>();
        this.horaInicioDeFranjaHoraria = 7;
        this.horaFinDeFranjaHoraria = 20;
    }
    
    public void suscribir(ISuscriptor suscriptor) {
    	suscriptores.add(suscriptor);
    }

    public void desuscribir(ISuscriptor suscriptor) {
    	suscriptores.remove(suscriptor);
    }
    
    public void notificar(String evento) {
    	suscriptores.stream().forEach(s -> s.actualizar(evento));
    }
    
    public void agregarZona(ZonaDeEstacionamiento zona) {
        zonas.add(zona);
    }

    public void iniciarEstacionamiento(String patente, Reloj reloj) {
    	if (!estacionamientoVigente(patente) && esFranjaHoraria(reloj)) {
    		Estacionamiento estacionamiento = new Estacionamiento(patente);
    		estacionamiento.iniciarEstacionamiento();
    		estacionamientosActivos.add(estacionamiento);
    		notificar("Se inicio el estacionamiento para la patente: " + patente);
    	} else {
            System.out.println("El usuario ya tiene un estacionamiento activo o el horario esta fuera de la franja horaria");
        }
    }

    public void finalizarEstacionamiento(String patente) {
    	if (estacionamientoVigente(patente)) {
    		Estacionamiento estacionamiento = estacionamientoUsuario(patente);
    		estacionamiento.finalizarEstacionamiento();
    		estacionamientosActivos.remove(estacionamiento);
    		notificar("Se finalizo el estacionamiento para la patente: " + patente);
    	} else {
            System.out.println("El usuario no tiene ningún estacionamiento activo");
        }
    }
    public boolean estacionamientoVigente(String patente) {
    	return estacionamientosActivos.stream().anyMatch(estacionamiento -> estacionamiento.getPatente().equals(patente));
    }
    
    public Estacionamiento estacionamientoUsuario(String patente) {
    	return estacionamientosActivos.stream()
    								  .filter(e -> e.getPatente().equals(patente))
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

	public int getHoraFinDeFranjaHoraria() {
		return horaFinDeFranjaHoraria;
	}

	public void setHoraFinDeFranjaHoraria(int horaFinDeFranjaHoraria) {
		this.horaFinDeFranjaHoraria = horaFinDeFranjaHoraria;
	}

	public List<ZonaDeEstacionamiento> getZonas() {
		return zonas;
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
		notificar("Se recargo saldo para el celular: " + usuario.getCelular() + "por un monto de: " + monto );
	}

}