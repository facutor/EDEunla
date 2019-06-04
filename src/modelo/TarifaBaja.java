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
	

	
}
