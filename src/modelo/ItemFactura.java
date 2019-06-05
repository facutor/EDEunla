package modelo;

public class ItemFactura {
	private long idItemFactura ;
	private String detalle;
	private float precioUnitario;
	private int cantidad;
	private String unidad;
	
	public ItemFactura(long idItemFactura, String detalle, float precioUnitario, int cantidad, String unidad) {
		super();
		this.idItemFactura = idItemFactura;
		this.detalle = detalle;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}

	public long getIdItemFactura() {
		return idItemFactura;
	}

	public void setIdItemFactura(long idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public float calcularSubtotal() {
		
		return precioUnitario*cantidad;
	}

	@Override
	public String toString() {
		return "itemFactura [idItemFactura=" + idItemFactura + ", detalle=" + detalle + ", precioUnitario="
				+ precioUnitario + ", cantidad=" + cantidad + ", unidad=" + unidad + "]";
	}
	
	
	
	
}
