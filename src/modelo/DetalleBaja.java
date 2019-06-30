package modelo;

public class DetalleBaja {
	private String detalleConcepto;
	private String unidad;
	private int desde;
	private int hasta;
	private double valor;
	
	public DetalleBaja(String detalleConcepto, String unidad, int desde, int hasta, double valor) {
		super();
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.desde = desde;
		this.hasta = hasta;
		this.valor = valor;
	}
	/********************getters y setters**********************/
	public String getDetalleConcepto() {
		return detalleConcepto;
	}

	public void setDetalleConcepto(String detalleConcepto) {
		this.detalleConcepto = detalleConcepto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public int getDesde() {
		return desde;
	}

	public void setDesde(int desde) {
		this.desde = desde;
	}

	public int getHasta() {
		return hasta;
	}

	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + desde;
		result = prime * result + ((detalleConcepto == null) ? 0 : detalleConcepto.hashCode());
		result = prime * result + hasta;
		result = prime * result + ((unidad == null) ? 0 : unidad.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		DetalleBaja other = (DetalleBaja) obj;
		if (desde != other.desde)
			return false;
		if (detalleConcepto == null) {
			if (other.detalleConcepto != null)
				return false;
		} else if (!detalleConcepto.equals(other.detalleConcepto))
			return false;
		if (hasta != other.hasta)
			return false;
		if (unidad == null) {
			if (other.unidad != null)
				return false;
		} else if (!unidad.equals(other.unidad))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleBaja [detalleConcepto=" + detalleConcepto + ", unidad=" + unidad + ", desde=" + desde
				+ ", hasta=" + hasta + ", valor=" + valor + "]";
	}
	
	
}
