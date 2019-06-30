package modelo;

import java.time.LocalDate;

public class Lectura{
	protected int idLectura;
	protected Inspector inspector;
	protected LocalDate fechaRegistro;
	protected Medidor medidor;

	
	public Lectura(int idLectura, Inspector inspector, LocalDate fechaRegistro, Medidor medidor) {
		super();
		this.idLectura = idLectura;
		this.inspector = inspector;
		this.fechaRegistro = fechaRegistro;
		this.medidor = medidor;
	}

	//constructor vacio
	public Lectura(){
	}
	
	/***************************getters y setters****************************/
	public Inspector getInspector() {
		return inspector;
	}
	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getIdLectura() {
		return idLectura;
	}
	public void setIdLectura(int idLectura) {
		this.idLectura = idLectura;
	}
	
	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	@Override
	public String toString() {
		return "idLectura=" + idLectura + ", inspector[dni="+inspector.getDni() +", apellido="+inspector.getApellido()+"], fechaRegistro=" + fechaRegistro
				+ ", medidor[idMedidor="+medidor.getIdMedidor()+", domicilioMedidor= "+medidor.getDomicilioMedidor()+"]";
	}
	
	
	
}
