package modelo;

import java.util.List;


public class Zona {
	private int idZona;
	private String zona;//nombre de la zona
	private Inspector inspector;
	
	
	
	public Zona(int idZona, String zona, Inspector inspector) {
		super();
		this.idZona = idZona;
		this.zona = zona;
		this.inspector = inspector;
	}
	public Zona() {
		
	}
	/******************getters y setters*******************/
	public int getIdZona() {
		return idZona;
	}
	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	


	
	
}
