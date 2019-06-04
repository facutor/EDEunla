package modelo;

import java.time.LocalDate;

public class LecturaAlta extends Lectura{
	private String tipoTension;
	private int consumoHorasPico;
	private int consumoHorasValle;
	private int consumoHorasResto;
	
	
	

	

	

	public LecturaAlta(int idLectura, Inspector inspector, LocalDate fechaRegistro, Medidor medidor,
			String tipoTension, int consumoHorasPico, int consumoHorasValle, int consumoHorasResto) {
		super(idLectura, inspector, fechaRegistro, medidor);
		this.tipoTension = tipoTension;
		this.consumoHorasPico = consumoHorasPico;
		this.consumoHorasValle = consumoHorasValle;
		this.consumoHorasResto = consumoHorasResto;
	}

	//constructor vacio
	public LecturaAlta() {
	}
	
	/*********************getters y setters**************************/
	public int getConsumoHorasPico() {
		return consumoHorasPico;
	}
	public void setConsumoHorasPico(int consumoHorasPico) {
		this.consumoHorasPico = consumoHorasPico;
	}
	public int getConsumoHorasValle() {
		return consumoHorasValle;
	}
	public void setConsumoHorasValle(int consumoHorasValle) {
		this.consumoHorasValle = consumoHorasValle;
	}
	public int getConsumoHorasResto() {
		return consumoHorasResto;
	}
	public void setConsumoHorasResto(int consumoHorasResto) {
		this.consumoHorasResto = consumoHorasResto;
	}

	public String getTipoTension() {
		return tipoTension;
	}

	public void setTipoTension(String tipoTension) {
		this.tipoTension = tipoTension;
	}
	
	
	

}