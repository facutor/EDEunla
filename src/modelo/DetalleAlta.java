package modelo;

public class DetalleAlta {
	private String detalleConcepto;
	private String unidad;
	private boolean superaLimite;
	private double valor;
	
	public DetalleAlta(String detalleConcepto, String unidad, boolean superaLimite, double valor) {
		super();
		this.detalleConcepto = detalleConcepto;
		this.unidad = unidad;
		this.superaLimite = superaLimite;
		this.valor = valor;
	}

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

	public boolean isSuperaLimite() {
		return superaLimite;
	}

	public void setSuperaLimite(boolean superaLimite) {
		this.superaLimite = superaLimite;
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
		result = prime * result + ((detalleConcepto == null) ? 0 : detalleConcepto.hashCode());
		result = prime * result + (superaLimite ? 1231 : 1237);
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
		DetalleAlta other = (DetalleAlta) obj;
		if (detalleConcepto == null) {
			if (other.detalleConcepto != null)
				return false;
		} else if (!detalleConcepto.equals(other.detalleConcepto))
			return false;
		if (superaLimite != other.superaLimite)
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
		return "DetalleAlta [detalleConcepto=" + detalleConcepto + ", unidad=" + unidad + ", superaLimite="
				+ superaLimite + ", valor=" + valor + "]";
	}
	
	
	
	
	
}
