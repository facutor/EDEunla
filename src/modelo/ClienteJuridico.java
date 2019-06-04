package modelo;

import java.util.List;



public class ClienteJuridico extends Cliente{
		private String cuit;
		private String nombreEmpresa;

		
		public ClienteJuridico(int idCliente, String demanda, Zona zona, String cuit, String nombreEmpresa) {
			super(idCliente, demanda, zona);
			this.cuit = cuit;
			this.nombreEmpresa = nombreEmpresa;
		}

		//constructor vacio
		public ClienteJuridico(){
		}
		
		/************************getters y setters****************************/
		public String getCuit() {
			return cuit;
		}
		public void setCuit(String cuit) {
			this.cuit = cuit;
		}
		public String getNombreEmpresa() {
			return nombreEmpresa;
		}
		public void setNombreEmpresa(String nombreEmpresa) {
			this.nombreEmpresa = nombreEmpresa;
		}
		
		/***************************************************************************/
		public String toString() {
			return "ID: " + super.getIdCliente()+"\tDemanda: "+super.getDemanda()
			+"\nCuit: "+cuit+"\tEmpresa: "+nombreEmpresa;
		}
		
}
