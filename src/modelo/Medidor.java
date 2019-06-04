package modelo;
import java.util.List;


public class Medidor {
	private int idMedidor;//en vez de 'numero de serie' para hacerlo mas simple
	private String domicilioMedidor;
	private boolean esBaja;
	private Cliente cliente;

	public Medidor(int idMedidor, String domicilioMedidor, boolean esBaja, Cliente cliente) {
		super();
		this.idMedidor = idMedidor;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = esBaja;
		this.cliente = cliente;
	}

	//constructor vacio
	public Medidor(){
	}
	
	/*************************getters y setters******************************/
	public int getIdMedidor() {
		return idMedidor;
	}
	public void setIdMedidor(int idMedidor) {
		this.idMedidor = idMedidor;
	}
	
	public String getDomicilioMedidor() {
		return domicilioMedidor;
	}
	public void setDomicilioMedidor(String domicilioMedidor) {
		this.domicilioMedidor = domicilioMedidor;
	}
	
	public boolean isEsBaja() {
		return esBaja;
	}
	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*****************************to String**********************************/
	public String toString() {
		if(esBaja) {
			return "Id Medidor: "+idMedidor+"\tDomicilio: "+domicilioMedidor+
					"\nTipo Medidor: Baja Demanda";
		}
		else {
			return "Id Medidor: "+idMedidor+"\tDomicilio: "+domicilioMedidor+
					"\nTipo Medidor: Alta Demanda";
		}
	}

}
