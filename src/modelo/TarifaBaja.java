package modelo;

import java.util.List;


public class TarifaBaja extends Tarifa{
	private List<DetalleBaja> listaDetalle;

	public TarifaBaja(String servicio, List<DetalleBaja> listaDetalle) {
		super(servicio);
		this.listaDetalle = listaDetalle;
	}
	
	/************************getters y setters*********************/
	public List<DetalleBaja> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(List<DetalleBaja> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((listaDetalle == null) ? 0 : listaDetalle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarifaBaja other = (TarifaBaja) obj;
		if (listaDetalle == null) {
			if (other.listaDetalle != null)
				return false;
		} else if (!listaDetalle.equals(other.listaDetalle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TarifaBaja [getListaDetalle()=" + getListaDetalle() + "]";
	}
	

	
}
