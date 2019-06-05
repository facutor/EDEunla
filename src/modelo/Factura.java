package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Factura {
	private int idFactura;
	private LocalDate fecha;
	private String cliente;
	private int nroMedidor;
	private Lectura lecturaAnterior;
	private Lectura lecturaActual;
	private List<ItemFactura> listaItemFactura;

	public Factura(int idFactura, LocalDate fecha, String cliente, int nroMedidor, Lectura lecturaAnterior,
			Lectura lecturaActual) {
		super();
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.cliente = cliente;
		this.nroMedidor = nroMedidor;
		this.lecturaAnterior = lecturaAnterior;
		this.lecturaActual = lecturaActual;
		this.listaItemFactura = new ArrayList<ItemFactura>();
	}
	/*****************************getters y setters******************************/
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
	
	public List<ItemFactura> getListaItemFactura() {
		return listaItemFactura;
	}
	public void setListaItemFactura(List<ItemFactura> listaItemFactura) {
		this.listaItemFactura = listaItemFactura;
	}
	
	public Lectura getLecturaAnterior() {
		return lecturaAnterior;
	}

	public void setLecturaAnterior(Lectura lecturaAnterior) {
		this.lecturaAnterior = lecturaAnterior;
	}

	public Lectura getLecturaActual() {
		return lecturaActual;
	}

	public void setLecturaActual(Lectura lecturaActual) {
		this.lecturaActual = lecturaActual;
	}

	/**********************************************************************************/
	public float calcularTotal() {
		float total = 0;
		
		for (int i = 0; i < listaItemFactura.size() ; i++) {
			total += listaItemFactura.get(i).calcularSubtotal();
		}
		
		return total;
	}
	
	public float calcularConsumoBajo() {
		
		float consumoBajo = 0;
		if(lecturaAnterior instanceof LecturaBaja && lecturaActual instanceof Lectura) {
			consumoBajo=( (LecturaBaja) lecturaActual).getConsumo() - ( (LecturaBaja) lecturaAnterior).getConsumo();
		}
		return consumoBajo ;
	
	}
	
	public float calcularConsumoHorasPico() {
		
		return ( (LecturaAlta)lecturaActual).getConsumoHorasPico() - ( (LecturaAlta)lecturaActual).getConsumoHorasPico();
	
	}
	
	public float calcularConsumoHorasValle() {
	
		return ( (LecturaAlta)lecturaActual).getConsumoHorasValle() - ( (LecturaAlta)lecturaActual).getConsumoHorasValle();
	
	}
	
	public float calcularConsumoHorasResto() {
	
		return ( (LecturaAlta)lecturaActual).getConsumoHorasResto() - ( (LecturaAlta)lecturaActual).getConsumoHorasResto();
	
	}
	
	
}
