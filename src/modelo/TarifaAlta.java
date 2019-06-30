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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limite;
		result = prime * result + ((listaDetalle == null) ? 0 : listaDetalle.hashCode());
		result = prime * result + ((tensionContratada == null) ? 0 : tensionContratada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarifaAlta other = (TarifaAlta) obj;
		if (limite != other.limite)
			return false;
		if (listaDetalle == null) {
			if (other.listaDetalle != null)
				return false;
		} else if (!listaDetalle.equals(other.listaDetalle))
			return false;
		if (tensionContratada == null) {
			if (other.tensionContratada != null)
				return false;
		} else if (!tensionContratada.equals(other.tensionContratada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TarifaAlta [tensionContratada=" + tensionContratada + ", limite=" + limite + ", getListaDetalle()="
				+ getListaDetalle() + "]";
	}
	
	
	
}
