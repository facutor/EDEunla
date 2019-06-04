package modelo;


import java.util.ArrayList;
import java.util.List;

public class Cliente{
	private int idCliente;
	private String demanda;
	private Zona zona;
	
	
	public Cliente(int idCliente, String demanda, Zona zona) {
		super();
		this.idCliente = idCliente;
		this.demanda = demanda;
		this.zona = zona;
	}

	//constructor vacio
	public Cliente(){
	}

	/*************************getters y setters**************************/
	public String getDemanda() {
		return demanda;
	}
	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	
	
	/*public boolean agregarMedidor(String domicilioMedidor) throws Exception{
		boolean agregado = false;
		int contador = 1;
		
		if( !listaMedidores.isEmpty() ) {
			boolean existe = false;
			contador = 1;
			
			for(int i = 0; i<listaMedidores.size() ; i++) {
				if( listaMedidores.get(i).getDomicilioMedidor().equals(domicilioMedidor) ) {
					existe = true;
				}
				contador++;
			}
			if( !existe ) {
				List<Lectura> listaLecturas = new ArrayList<Lectura>();
				
				
				if(demanda.equals("Alta") ) {
					
					Medidor m = new Medidor( contador, domicilioMedidor, false ,listaLecturas );
					listaMedidores.add(m);
				}
				
				else {
					Medidor m = new Medidor( contador, domicilioMedidor, true ,listaLecturas );
					listaMedidores.add(m);
				}
				agregado = true;
				
			}
			else {
				throw new Exception("Excepcion: El Cliente con ID: "+idCliente+ " ya tiene ese medidor");
			}
			
		}
		else {
			List<Lectura> listaLecturas = new ArrayList<Lectura>();
			agregado = true;
			if(demanda.equals("Alta") ) {	
				Medidor m = new Medidor( contador, domicilioMedidor, false ,listaLecturas );
				listaMedidores.add(m);
				
			}
			else {
				Medidor m = new Medidor( contador, domicilioMedidor, true ,listaLecturas );
				listaMedidores.add(m);
			}

		}
		
		return agregado;	
	}
	
	public Medidor traerMedidor(int idMedidor) {
		boolean existe = false;
		int i;
		
		for (i = 0; i < listaMedidores.size() ; i++) {
			if(listaMedidores.get(i).getIdMedidor() == idMedidor) {
				existe = true;
				break;
			}
		}
		if( existe ) {
			return listaMedidores.get(i);
		}
		else {
			Medidor m =  new Medidor();
			return m;
		}
		
	}
	
	public boolean eliminarMedidor(String domicilioMedidor) throws Exception{
		boolean eliminado = false , existe = false;
		int i;
		
		for (i = 0; i < listaMedidores.size() ; i++) {
			if( listaMedidores.get(i).getDomicilioMedidor().equals(domicilioMedidor) ) {
				existe = true;
				break;
			}
		}
		if( !existe ) {
			throw new Exception("El Cliente "+idCliente+" no tiene ese medidor");
		}
		else {
			listaMedidores.remove(i);
			eliminado = true;
		}
		
		return eliminado;
	}
	*/
	
}