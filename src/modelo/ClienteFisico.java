package modelo;

import java.util.List;


public class ClienteFisico extends Cliente{
	private String cuil;
	private String apellido;
	private String nombre;
	
	
	public ClienteFisico(int idCliente, String demanda, Zona zona, String cuil, String apellido, String nombre) {
		super(idCliente, demanda, zona);
		this.cuil = cuil;
		this.apellido = apellido;
		this.nombre = nombre;
	}
	//constructor vacio
	public ClienteFisico(){
	}
	/***********************getters y setters****************************/
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
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
	
	/*********************************************************************/
	public String toString() {
		return "ID: "+super.getIdCliente()+"\tDemanda: "+super.getDemanda()
		+"\nCUIL: "+cuil+"\tApellido y Nombre: "+apellido+" "+nombre;
	}
}
