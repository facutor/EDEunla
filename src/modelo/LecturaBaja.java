package modelo;

import java.time.LocalDate;
import java.time.Period;


public class LecturaBaja extends Lectura {
	private int consumo;

	public LecturaBaja(int idLectura, Inspector inspector, LocalDate fechaRegistro, Medidor medidor,
			int consumo) {
		super(idLectura, inspector, fechaRegistro, medidor);
		this.consumo = consumo;
	}

	//constructor vacio
	public LecturaBaja() {
	}
	
	/******************getters y setters********************/
	public int getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}
	
	
	
	

}