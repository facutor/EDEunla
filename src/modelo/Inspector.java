package modelo;

import java.util.List;

public class Inspector {
	private int idInspector;
	private String apellido;
	private String nombre;
	private long dni;
	
		
	public Inspector(int idInspector, String apellido, String nombre, long dni) {
		super();
		this.idInspector = idInspector;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}
	//constructor vacio
	public Inspector() {
	}
	
	/*************************getters y setters***********************/
	public int getIdInspector() {
		return idInspector;
	}
	
	public void setIdInspector(int idInspector) {
		this.idInspector = idInspector;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	/******************************************************************/
	public String traerNombreCompleto() {
		return apellido+" "+nombre;
	}

	public String toString() {
		return "ID: "+idInspector+"\nDni: "+dni+"\tInspector: "+traerNombreCompleto();
	}
	
	
}
