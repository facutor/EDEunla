package modelo;

import java.time.LocalDate;
import java.util.List;


public class Factura {
	private int idFactura;
	private String cliente;
	private Lectura lectura;
	private LocalDate fecha;
	private int nroMedidor;
	private Tarifa tarifa;
	private List<ItemFactura> listaItemFactura;
	
	

	public Factura(int idFactura, String cliente, Lectura lectura, LocalDate fecha, int nroMedidor, Tarifa tarifa,
			List<ItemFactura> listaItemFactura) {
		super();
		this.idFactura = idFactura;
		this.cliente = cliente;
		this.lectura = lectura;
		this.fecha = fecha;
		this.nroMedidor = nroMedidor;
		this.tarifa = tarifa;
		this.listaItemFactura = listaItemFactura;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Lectura getLectura() {
		return lectura;
	}
	public void setLectura(Lectura lectura) {
		this.lectura = lectura;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNroMedidor() {
		return nroMedidor;
	}

	public void setNroMedidor(int nroMedidor) {
		this.nroMedidor = nroMedidor;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	public List<ItemFactura> getListaItemFactura() {
		return listaItemFactura;
	}
	public void setListaItemFactura(List<ItemFactura> listaItemFactura) {
		this.listaItemFactura = listaItemFactura;
	}
	
	/**********************************************************************************/
	private float calcularTotal() {
		float total = 0;
		
		for (int i = 0; i < listaItemFactura.size() ; i++) {
			total += listaItemFactura.get(i).calcularSubtotal();
		}
		
		return total;
	}
	
		
}
