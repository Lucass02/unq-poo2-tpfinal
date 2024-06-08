package ar.edu.unq.po2.tpFinal.sem;

public interface INotificador {
	public void suscribir(ISuscriptor suscriptor);
	public void desuscribir(ISuscriptor suscriptor);
	public void notificar(String evento);
}
