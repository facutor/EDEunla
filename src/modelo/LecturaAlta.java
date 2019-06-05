package modelo;

import java.time.LocalDate;

public class LecturaAlta extends Lectura{
	private float consumoHorasPico;
	private float consumoHorasValle;
	private float consumoHorasResto;
	

	public LecturaAlta(int idLectura, Inspector inspector, LocalDate fechaRegistro, Medidor medidor,
			float consumoHorasPico, float consumoHorasValle, float consumoHorasResto) {
		super(idLectura, inspector, fechaRegistro, medidor);
		this.consumoHorasPico = consumoHorasPico;
		this.consumoHorasValle = consumoHorasValle;
		this.consumoHorasResto = consumoHorasResto;
	}

	//constructor vacio
	public LecturaAlta() {
	}
	
	/*********************getters y setters**************************/
	public float getConsumoHorasPico() {
		return consumoHorasPico;
	}
	public void setConsumoHorasPico(int consumoHorasPico) {
		this.consumoHorasPico = consumoHorasPico;
	}
	public float getConsumoHorasValle() {
		return consumoHorasValle;
	}
	public void setConsumoHorasValle(int consumoHorasValle) {
		this.consumoHorasValle = consumoHorasValle;
	}
	public float getConsumoHorasResto() {
		return consumoHorasResto;
	}
	public void setConsumoHorasResto(int consumoHorasResto) {
		this.consumoHorasResto = consumoHorasResto;
	}
	

}