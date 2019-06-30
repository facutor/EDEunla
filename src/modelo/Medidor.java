package modelo;
import java.util.List;


public class Medidor {
	private int idMedidor;//en vez de 'numero de serie' para hacerlo mas simple
	private String domicilioMedidor;
	private boolean esBaja;
	private Cliente cliente;
	private Tarifa tarifa;

	public Medidor(int idMedidor, String domicilioMedidor, boolean esBaja, Cliente cliente, Tarifa tarifa) {
		super();
		this.idMedidor = idMedidor;
		this.domicilioMedidor = domicilioMedidor;
		this.esBaja = esBaja;
		this.cliente = cliente;
		this.tarifa = tarifa;
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

	
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	@Override
	public String toString() {
		return "\nMedidor [idMedidor=" + idMedidor + ", domicilioMedidor=" + domicilioMedidor + ", esBaja=" + esBaja
				+ ", cliente=" + cliente + ", tarifa=" + tarifa + "]";
	}
	
	/*****************************to String**********************************/
	

}
