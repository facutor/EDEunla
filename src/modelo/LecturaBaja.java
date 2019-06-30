package modelo;

import java.time.LocalDate;

public class LecturaBaja extends Lectura {
	private float consumo;

	public LecturaBaja(int idLectura, Inspector inspector, LocalDate fechaRegistro, Medidor medidor,
			float consumo) {
		super(idLectura, inspector, fechaRegistro, medidor);
		this.consumo = consumo;
	}

	//constructor vacio
	public LecturaBaja() {
	}
	
	/******************getters y setters********************/
	public float getConsumo() {
		return consumo;
	}
	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	@Override
	public String toString() {
		return "LecturaBaja["+super.toString()+", consumo=" + consumo +"]\n";
	}
	
	
	

}