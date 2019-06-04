package modelo;

import java.util.List;


public class TarifaAlta extends Tarifa {
	private String tensionContratada;
	private int limite;
	private List<DetalleAlta> listaDetalle;
	
	public TarifaAlta(String servicio, String tensionContratada, int limite, List<DetalleAlta> listaDetalle) {
		super(servicio);
		this.tensionContratada = tensionContratada;
		this.limite = limite;
		this.listaDetalle = listaDetalle;
	}

	/****************************getters y setters*************************/
	public String getTensionContratada() {
		return tensionContratada;
	}

	public void setTensionContratada(String tensionContratada) {
		this.tensionContratada = tensionContratada;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public List<DetalleAlta> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<DetalleAlta> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	
	
}
