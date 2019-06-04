package modelo;

public class Tarifa {
	private String servicio;
	
	
	public Tarifa(String servicio) {
		super();
		this.servicio = servicio;
	}
	
	/*****************************getters y setter**************************/
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	
	
}
