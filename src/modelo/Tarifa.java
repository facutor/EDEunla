package modelo;

public class Tarifa {
	private String servicio;
	
	
	public Tarifa(String servicio) {
		super();
		this.servicio = servicio;
	}
	
	/*****************************getters y setter**************************/
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((servicio == null) ? 0 : servicio.hashCode());
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
		Tarifa other = (Tarifa) obj;
		if (servicio == null) {
			if (other.servicio != null)
				return false;
		} else if (!servicio.equals(other.servicio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarifa [servicio=" + servicio + "]";
	}
	
	
	
}
