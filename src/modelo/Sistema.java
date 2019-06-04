package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

/*
 * NOTA SISTEMA VA A ACTUAR COMO UNA 'BASE DE DATO' PARA PODER AGREGAR CLIENTES E INSPECTORES Y ASI PODER REALIZAR TODO LO DEMAS
 */

public class Sistema {
	List<Cliente> listaClientes;
	List<Zona> listaZonas;
	List<Medidor> listaMedidores;
	List<Lectura> listaLectura;
	List<Inspector> listaInspector;
	List<Tarifa> listaTarifas;
	List<Factura> listaFacturas;
	List<ItemFactura> listaItemFactura;
	
	
	
	public Sistema() {
		super();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaMedidores = new ArrayList<Medidor>();
		this.listaLectura = new ArrayList<Lectura>();
		this.listaInspector = new ArrayList<Inspector>();
		this.listaTarifas = new ArrayList<Tarifa>();
		this.listaZonas = new ArrayList<Zona>();
		this.listaFacturas = new ArrayList<Factura>();
		this.listaItemFactura = new ArrayList<ItemFactura>();
	}
	/*********************getters y setters**********************/
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	public List<Zona> getListaZonas() {
		return listaZonas;
	}

	public void setListaZonas(List<Zona> listaZonas) {
		this.listaZonas = listaZonas;
	}

	public List<Medidor> getListaMedidores() {
		return listaMedidores;
	}

	public void setListaMedidores(List<Medidor> listaMedidores) {
		this.listaMedidores = listaMedidores;
	}
	
	public List<Lectura> getListaLectura() {
		return listaLectura;
	}
	public void setListaLectura(List<Lectura> listaLectura) {
		this.listaLectura = listaLectura;
	}
	
	public List<Inspector> getListaInspector() {
		return listaInspector;
	}
	public void setListaInspector(List<Inspector> listaInspector) {
		this.listaInspector = listaInspector;
	
	}
	public List<Tarifa> getListaTarifas() {
		return listaTarifas;
	}
	public void setListaTarifas(List<Tarifa> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}
	
	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	
	
	public List<ItemFactura> getListaItemFactura() {
		return listaItemFactura;
	}
	public void setListaItemFactura(List<ItemFactura> listaItemFactura) {
		this.listaItemFactura = listaItemFactura;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaClientes == null) ? 0 : listaClientes.hashCode());
		result = prime * result + ((listaFacturas == null) ? 0 : listaFacturas.hashCode());
		result = prime * result + ((listaInspector == null) ? 0 : listaInspector.hashCode());
		result = prime * result + ((listaItemFactura == null) ? 0 : listaItemFactura.hashCode());
		result = prime * result + ((listaLectura == null) ? 0 : listaLectura.hashCode());
		result = prime * result + ((listaMedidores == null) ? 0 : listaMedidores.hashCode());
		result = prime * result + ((listaTarifas == null) ? 0 : listaTarifas.hashCode());
		result = prime * result + ((listaZonas == null) ? 0 : listaZonas.hashCode());
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
		Sistema other = (Sistema) obj;
		if (listaClientes == null) {
			if (other.listaClientes != null)
				return false;
		} else if (!listaClientes.equals(other.listaClientes))
			return false;
		if (listaFacturas == null) {
			if (other.listaFacturas != null)
				return false;
		} else if (!listaFacturas.equals(other.listaFacturas))
			return false;
		if (listaInspector == null) {
			if (other.listaInspector != null)
				return false;
		} else if (!listaInspector.equals(other.listaInspector))
			return false;
		if (listaItemFactura == null) {
			if (other.listaItemFactura != null)
				return false;
		} else if (!listaItemFactura.equals(other.listaItemFactura))
			return false;
		if (listaLectura == null) {
			if (other.listaLectura != null)
				return false;
		} else if (!listaLectura.equals(other.listaLectura))
			return false;
		if (listaMedidores == null) {
			if (other.listaMedidores != null)
				return false;
		} else if (!listaMedidores.equals(other.listaMedidores))
			return false;
		if (listaTarifas == null) {
			if (other.listaTarifas != null)
				return false;
		} else if (!listaTarifas.equals(other.listaTarifas))
			return false;
		if (listaZonas == null) {
			if (other.listaZonas != null)
				return false;
		} else if (!listaZonas.equals(other.listaZonas))
			return false;
		return true;
	}
	/********************************************Agregar metodos**********************************************/
	public boolean agregarFactura(Lectura lectura,Tarifa tarifa,List<ItemFactura> lItemFacturas) {
		int id = 1;//generador del id de factura
		
		if( !listaFacturas.isEmpty() ) {
			
			for (int i = 0; i < listaFacturas.size() ; i++) {
				id++;
			}
		}
		String cliente = "";
		
		 if ( lectura.getMedidor().getCliente() instanceof ClienteFisico ) {
			 cliente = ( (ClienteFisico)lectura.getMedidor().getCliente() ).getApellido()+
					 " "+( (ClienteFisico)lectura.getMedidor().getCliente() ).getNombre(); //nombre del cliente fisico
		 }
		 else if( lectura.getMedidor().getCliente() instanceof ClienteJuridico ) {
					cliente = ( (ClienteJuridico)lectura.getMedidor().getCliente() ).getNombreEmpresa() ;//razon social/nombre de la empresa (cliente juridico)
		 }
		 
		Factura f = new Factura(id, cliente , lectura, lectura.getFechaRegistro() , lectura.getMedidor().getIdMedidor() , tarifa, lItemFacturas);
		return listaFacturas.add(f);
	}
	
	public boolean agregarTarifaAlta(String servicio,String tensionContratada, int limite ,List<DetalleAlta> lisDetalleAltas)throws Exception {
		if(traerTarifaAlta(servicio) != null) throw new Exception("Exepcion: La Tarifa ya existe");
		
		Tarifa t = new TarifaAlta(servicio, tensionContratada, limite, lisDetalleAltas);
		return listaTarifas.add(t);
	}
	
	public boolean agregarInspector(long dni,String nombre,String apellido) throws Exception{
		
		if(traerInspector(dni) != null ) {
			throw new Exception("Excepcion: El Inspector ya existe");
		}
		
		int id = 1; //generador de id para inspector
		if( !listaInspector.isEmpty() ) {
			for (int i = 0; i < listaInspector.size() ; i++) {
				id++;
			}
		}
		Inspector inspector = new Inspector(id, apellido, nombre, dni);
		
		return listaInspector.add(inspector);
	}
	
	public boolean agregarClienteFisico(String demanda,String cuil,String apellido,String nombre, Zona zona)throws Exception{
		int contador = 1;//se usar como generador de los id
		boolean agregado = false;
		
		if( demanda.equals("Alta") || demanda.equals("ALTA") 
				|| demanda.equals("Baja") || demanda.equals("BAJA") ) {
		
			if( !listaClientes.isEmpty() ) {
				boolean existe = false;
				
				for (int i = 0; i < listaClientes.size() ; i++) {
					if( listaClientes.get(i) instanceof ClienteFisico ) {
						ClienteFisico cf = (ClienteFisico) listaClientes.get(i);
			
						if(cf.getCuil().equals(cuil)) {
							existe = true;
						}
						
					}
					contador ++;
				}
				
				if(!existe) {
					
					ClienteFisico cf = new ClienteFisico(contador, demanda, zona, cuil, apellido, nombre);
					listaClientes.add(cf); 
					agregado = true;
				}
				else {
					throw new Exception("Excepcion: El cliente ya existe");
				}
				
			}
			else {
				
				ClienteFisico cf = new ClienteFisico(contador, demanda, zona, cuil, apellido, nombre);
				listaClientes.add(cf); 
				agregado = true;
			}
			
		}
		else {
			throw new Exception("Exepcion: La demanda es incorrecta");
		}
		
		return agregado;
	}

	public boolean agregarClienteJuridico(String demanda,String cuit,String nombreEmpresa,Zona zona)throws Exception{
		int contador = 1;//se usar como generador de los id
		boolean agregado = false;
		
		if( demanda.equals("Alta") || demanda.equals("ALTA") 
				|| demanda.equals("Baja") || demanda.equals("BAJA") ) {
		
			if( !listaClientes.isEmpty() ) {
				boolean existe = false;
				
				for (int i = 0; i < listaClientes.size() ; i++) {
					if(listaClientes.get(i) instanceof ClienteJuridico) {
						ClienteJuridico cj= (ClienteJuridico) listaClientes.get(i);
						if(cj.getCuit().equals(cuit)) {
							existe=true;
						}
					}
					contador ++;
				}
				
				if(!existe) {
					ClienteJuridico cj = new ClienteJuridico(contador, demanda, zona, cuit, nombreEmpresa);
					listaClientes.add(cj);
					agregado = true;
				}
				else {
					throw new Exception("Excepcion: El cliente ya existe");
				}
				
			}
			else {
			
				ClienteJuridico cj = new ClienteJuridico(contador, demanda, zona, cuit, nombreEmpresa);
				listaClientes.add(cj);
				agregado = true;
			}
			
		}
		else {
			throw new Exception("Exepcion: La demanda es incorrecta");
		}
		
		return agregado;
	}
	
	public boolean agregarMedidor(String domicilioMedidor,Cliente cliente) throws Exception{
		boolean agregado = false;
		int contador = 1;
		
		if( !listaMedidores.isEmpty() ) {
			boolean existe = false;
			
			for (int i = 0; i < listaMedidores.size() ; i++) {
				if( listaMedidores.get(i).getDomicilioMedidor().equals(domicilioMedidor) ) {
					existe = true;
				}
				contador ++;
			}
			if( !existe ) {
				if( cliente.getDemanda().equals("Alta") ) {
					Medidor m = new Medidor(contador, domicilioMedidor, false, cliente);
					listaMedidores.add(m);
				}
				else {
					Medidor m = new Medidor(contador, domicilioMedidor, true, cliente);
					listaMedidores.add(m);
				}
				agregado = true;
			}
			else {
				throw new Exception("Excepcion: El medidor ya existe");
			}
		}
		else {
			
			if( cliente.getDemanda().equals("Alta") ) {
				Medidor m = new Medidor(contador, domicilioMedidor, false, cliente);
				listaMedidores.add(m);
			}
			else {
				Medidor m = new Medidor(contador, domicilioMedidor, true, cliente);
				listaMedidores.add(m);
			}
			agregado = true;
		}
		
		return agregado;
	}
	
	public boolean agregarzona(String zona, Inspector inspector) throws Exception {

		boolean agregar=false, existe=false;
		int c=1;
		if (listaZonas.isEmpty()==false) {
			for (int i = 0; i < listaZonas.size(); i++) {
				if (listaZonas.get(i).getZona().equals(zona)) {
					existe=true;
				}
				c++;
			}
			if (existe==false) {
				Zona z = new Zona(c, zona, inspector);
				listaZonas.add(z);
				agregar=true;
			}
			else throw new Exception(zona+ " ya existe");
		}
		else {
			Zona z = new Zona(c, zona,inspector);
			listaZonas.add(z);
			agregar=true;
		}
		return agregar;
	}

	public boolean agregarLecturaBaja(Inspector inspector,LocalDate fechaRegistro,Medidor medidor,int consumo)throws Exception {
		boolean agregado = false;
		int contador = 1;
		
		if( !listaLectura.isEmpty() ) {
			boolean existe = false;
			
			for (int i = 0; i < listaLectura.size() ; i++) {
				if( listaLectura.get(i).getFechaRegistro().equals(fechaRegistro) ) {
					existe = true;
				}
				contador ++;
			}
			if( !existe ) {
				LecturaBaja lb = new LecturaBaja(contador, inspector, fechaRegistro, medidor, consumo);
				listaLectura.add(lb);
				agregado = true;
			}
			else {
				throw new Exception("Excepcion: La lectura ya existe");
			}
		}
		else {
			LecturaBaja lb = new LecturaBaja(contador, inspector, fechaRegistro, medidor, consumo);
			listaLectura.add(lb);
			agregado = true;
		}
		
		return agregado;
	}
	
	public boolean agregarLecturaAlta(Inspector inspector,LocalDate fechaRegistro,Medidor medidor,int consumoHorasPico,int consumoHorasValle,int consumoHorasResto,String tipoTension) throws Exception{
		boolean agregado = false;
		int contador = 1;
		
		if( !listaLectura.isEmpty() ) {
			boolean existe = false;
			
			for (int i = 0; i < listaLectura.size() ; i++) {
				if( listaLectura.get(i).getFechaRegistro().equals(fechaRegistro) ) {
					existe = true;
				}
				contador ++;
			}
			if( !existe ) {
				LecturaAlta la= new LecturaAlta(contador, inspector, fechaRegistro, medidor, tipoTension,consumoHorasPico, consumoHorasValle, consumoHorasResto);
				listaLectura.add(la);
				agregado = true;
			}
			else {
				throw new Exception("Excepcion: La lectura ya existe");
			}
		}
		else {
			LecturaAlta la= new LecturaAlta(contador, inspector, fechaRegistro, medidor,tipoTension,consumoHorasPico, consumoHorasValle, consumoHorasResto);
			listaLectura.add(la);
			agregado = true;
		}
		
		return agregado;
	}

	
	public boolean agregarTarifaBaja(String servicio, List<DetalleBaja> listaDetalle) throws Exception {
		if (traerTarifaBaja(servicio)!= null) {
			throw new Exception("La tarifa ingresada ya existe");
		}
		TarifaBaja tarifaBaja = new TarifaBaja(servicio, listaDetalle);
		
		return listaTarifas.add(tarifaBaja);
	}
	 
	/**********************************************Traer Metodos**************************************************/
	public Inspector traerInspector(long dni) {
		Inspector inspector = null;
		int contador = 0;
		
		while( inspector == null && contador < listaInspector.size() ) {
			if(listaInspector.get(contador).getDni()== dni) {
				
				inspector = listaInspector.get(contador);
			}
			
			contador ++;
		}
		return inspector;
	}
	
	public ClienteFisico traerClienteFisico(String cuil ){
		boolean existe = false;
		int i;
		
		for (i = 0; i < listaClientes.size() ; i++) {
			if(listaClientes.get(i) instanceof ClienteFisico) {
				ClienteFisico cf = (ClienteFisico)listaClientes.get(i);
			  	
				if(cf.getCuil().equals(cuil)) {
					existe = true;
				  	break;
			  	}
				
			}
		}
		if(existe) {
			return (ClienteFisico) listaClientes.get(i);
		}
		else {
			ClienteFisico cf = new ClienteFisico();
			return cf;
		}
	}
	
	public ClienteJuridico traerClienteJuridico(String cuit) {
		boolean existe=false;
		int i=0;
		
		for ( i = 0; i < listaClientes.size(); i++) {
			
			if (listaClientes.get(i) instanceof ClienteJuridico) {
				ClienteJuridico cj=(ClienteJuridico) listaClientes.get(i);
				if (cj.getCuit().equals(cuit)) {
					existe=true;
					break;
				}
			}
		}
		if (existe) {
			return (ClienteJuridico) listaClientes.get(i);
		}
		else {
			ClienteJuridico cj = new ClienteJuridico();
			return cj;
		}
	}
		
	public Medidor traerMedidor(int idMedidor){
		boolean existe = false;
		int i;
		
		for (i = 0; i < listaMedidores.size(); i++) {
			if(listaMedidores.get(i).getIdMedidor() == idMedidor ) {
				existe = true;
				break;
			}
		}
		if( existe ) {
			return listaMedidores.get(i);
		}
		else {
			Medidor m = new Medidor();
			return m;
		}
	}

	public Zona traerZona(int idZona) {
		boolean existe=false;
		int i=0;
		for ( i = 0; i < listaZonas.size(); i++) {
			if (listaZonas.get(i).getIdZona()==idZona) {
				existe=true;
				break;
			}
		}
		if (existe==true) {
			return listaZonas.get(i);
		}
		else {
			Zona z = new Zona();
			return z;
		}
	}
	
	public LecturaBaja traerLecturaBaja(LocalDate fechaRegistro) {
		boolean existe = false;
		int i;
		
		for (i = 0; i < listaLectura.size() ; i++) {
			if( listaLectura.get(i) instanceof LecturaBaja ) {
				
				if(listaLectura.get(i).getFechaRegistro().equals(fechaRegistro) ) {
					existe = true;
					break;
				}
			}
		}
		if(existe) {
			return ( (LecturaBaja)listaLectura.get(i) );
		}
		else {
			LecturaBaja lb = new LecturaBaja();
			return lb;
		}
	}
	
	public LecturaAlta traerLecturaAlta(LocalDate fechaRegistro) {
		boolean existe = false;
		int i;
		
		for (i = 0; i < listaLectura.size() ; i++) {				
			if(listaLectura.get(i) instanceof LecturaAlta ) {
				
				if(listaLectura.get(i).getFechaRegistro().equals(fechaRegistro)) {
					existe = true;
					break;
				}
			}
		}
		if(existe) {
			return ( (LecturaAlta)listaLectura.get(i) );
		}
		else {
			LecturaAlta la = new LecturaAlta();
			return la;
		}
	}
	
	public TarifaBaja traerTarifaBaja(String servicio) {
		TarifaBaja tarifaBaja =null;
		int contador=0;
		
		while(tarifaBaja == null && contador<listaTarifas.size() ) {
			if (listaTarifas.get(contador) instanceof TarifaBaja) {
				TarifaBaja tb = (TarifaBaja) listaTarifas.get(contador);
				if (tb.getServicio().equals(Servicio)) {
					tarifaBaja = (TarifaBaja)listaTarifas.get(contador);
				}
			}
			contador++;
		}
		return tarifaBaja;
	}
	
	public TarifaAlta traerTarifaAlta(String servicio) {
		TarifaAlta dato = null;
		int c=0;
		while ( dato == null && c < listaTarifas.size() ) {
			if (listaTarifas.get(c) instanceof TarifaAlta) {
				TarifaAlta ta = (TarifaAlta) listaTarifas.get(c);
				if (ta.getServicio().equals(servicio)) {
					dato = ta;
				}
			}
			c++;
		}
		return dato;	
	}
	
	
	public Factura traerFactura(int idFactura) {
		Factura dato = null;
		int i=0;
		while (dato==null && i<listaFacturas.size()) {
			if ( listaFacturas.get(i).getIdFactura()==idFactura) {
				dato=listaFacturas.get(i);
			}
			i++;
		}
		return dato;
	}
	
	public ItemFactura traerItemFactura(long idItemFactura) {
		ItemFactura dato =null;
		int i=0;
		while (dato==null && i<listaItemFactura.size()) {
			if (listaItemFactura.get(i).getIdItemFactura()==idItemFactura) {
				dato=listaItemFactura.get(i);
			}
			i++;
		}
		return dato;
		
	}
	/*****************************************Eliminar Metodo*****************************************************************/	
	public boolean eliminarInspector(long dni)throws Exception {
		
		Inspector inspector = traerInspector(dni);
		
		if(inspector == null) {
			throw new Exception("Excepcion: El Inspector Solicitado no Existe");
		}
		
		return listaInspector.remove(inspector);	
	}
	
	public void eliminarClienteFisico (String cuil)throws Exception {
		
		if(traerClienteFisico(cuil).getDemanda() != null) {
			listaClientes.remove( traerClienteFisico(cuil) );
		}
		else throw new Exception("Excepcion: El Cliente solicitado no existe");
	}
	
	
	public void eliminarClienteJuridico (String cuit) throws Exception {
		
		if(traerClienteJuridico(cuit).getDemanda() !=  null) {
			listaClientes.remove( traerClienteJuridico(cuit) );
		}
		else {
			throw new Exception("Excepcion: El Cliente solicitado no existe");
		}
	}

	
	public void eliminarMedidor(int idMedidor)throws Exception {
		
		if(traerMedidor(idMedidor).getCliente().getDemanda() != null) {
			listaMedidores.remove( traerMedidor(idMedidor) );
		}
		else {
			throw new Exception("Excepcion: El Medidor solicitado no existe");
		}
	}

	
	public void eliminarZona(int idZona) throws Exception {
		
		if (traerZona(idZona).getZona()!=null) {
			listaZonas.remove( traerZona(idZona) );
		}
		else throw new Exception("Excepcion: La Zona solicitada no existe");
	}
	

	public void eliminarLecturaAlta(LocalDate fechaRegistro) throws Exception{		
		
		if(traerLecturaAlta(fechaRegistro).getFechaRegistro() != null) {
			listaLectura.remove( traerLecturaAlta(fechaRegistro) );
		}
		else {
			throw new Exception("Excepcion: La Lectura solicitada no existe");
		}
	}
	

	public void eliminarLecturaBaja(LocalDate fechaRegistro) throws Exception{
		
		if(traerLecturaBaja(fechaRegistro).getFechaRegistro() != null) {
			listaLectura.remove( traerLecturaBaja(fechaRegistro) );

		}
		else {
			throw new Exception("Excepcion: La Lectura solicitada no existe");
		}
	}
	
	public void eliminarTarifaAlta(String servicio) throws Exception {
		if (traerTarifaAlta(servicio).getServicio() != null) {
			listaTarifas.remove(traerTarifaAlta(servicio));
		}
		else throw new Exception("Excepcion: La tarifa ingresada no exite");
	}
	public void eliminarTarifaBaja(String servicio) throws Exception {
		if (traerTarifaBaja(servicio).getServicio() != null) {
			listaTarifas.remove(traerTarifaBaja(servicio));
		}
		else throw new Exception("Excepcion: La tarifa ingresa no existe");
	}
	public void eliminarFactura(int idFactura) throws Exception {
		if (traerFactura(idFactura)!=null) {
			listaFacturas.remove(traerFactura(idFactura));
		}
		else {
			throw new Exception("Exception: La factura ingresada no existe");
		}
	}
	
	public void eliminarItemFactura(int idItemFactura) throws Exception {
		if (traerItemFactura(idItemFactura)!=null) {
			listaItemFactura.remove(traerItemFactura(idItemFactura));
		}
		else throw new Exception("Exception: El Item Factura ingresado no existe");
	}
	/*******************************************Modificar Metodos*************************************************************/
	public void modificarInspector(long dni , String nombre,String apellido)throws Exception {
		Inspector inspector = traerInspector(dni);
		
		if(inspector == null) {
			throw new Exception("Excepcion: El Inspector Solicitado no Existe");
		}
		else {
			inspector.setApellido(apellido);
			inspector.setNombre(nombre);
		}
	}
	
	public void modificarLecturaAlta(LocalDate fechaRegistro,int consumoHorasPico,int consumoHorasValle,int consumoHorasResto,
		LocalDate fechaNuevaRegitro) throws Exception {
		
		if(traerLecturaAlta(fechaRegistro) != null) {
			
			traerLecturaAlta(fechaRegistro).setConsumoHorasPico(consumoHorasPico);
			traerLecturaAlta(fechaRegistro).setConsumoHorasValle(consumoHorasValle);
			traerLecturaAlta(fechaRegistro).setConsumoHorasResto(consumoHorasResto);
			traerLecturaAlta(fechaRegistro).setFechaRegistro(fechaNuevaRegitro);
		}
		else throw new Exception("Excepcion: La Lectura Solicitada no existe");
	}
	
	public void modificarLecturaBaja(LocalDate fechaRegistro, int consumo,LocalDate fechaNuevaRegistro)throws Exception {
		
		if(traerLecturaBaja(fechaRegistro).getFechaRegistro() != null) {
			
			traerLecturaBaja(fechaRegistro).setConsumo(consumo);
			traerLecturaBaja(fechaRegistro).setFechaRegistro(fechaNuevaRegistro);
		}
		else throw new Exception("Excepcion: La Lectura solicitada no existe");
	}

	public void modificarZona(int idZona, String zona) throws Exception {
		
		if(traerZona(idZona) != null) {
			traerZona(idZona).setZona(zona);
		}
		else throw new Exception("Excepcion: La zona solicitada no existe");
	}
	
	public void modificarMedidor(int idMedidor, Cliente cliente) throws Exception {
	
		if ( traerMedidor(idMedidor) != null) {
			
			if(cliente.getDemanda().equals("Alta") ) {
				traerMedidor(idMedidor).setEsBaja(false);
			}
			else {
				traerMedidor(idMedidor).setEsBaja(true);
			}
		}
		else throw new Exception("Excepcion: El Medidor solicitado no existe");
		
	}
		
	public void modificarClienteFisico(String cuil, String demanda) throws Exception {
		
		if(traerClienteFisico(cuil) != null) {
			traerClienteFisico(cuil).setDemanda(demanda);
		}
		else throw new Exception("Excepcion: El Cliente solicitado no existe");
	}
	
	public void modificarClienteJuridico(String cuit, String demanda) throws Exception {
		
		if (traerClienteJuridico(cuit) != null) {
			traerClienteJuridico(cuit).setDemanda(demanda);
		}
		else throw new Exception("Excepcion: El Cliente solicitado no existe");
	}
	
	
	/*****************************************Calcula Totales***************************************************************/
	public float calcularConsumoBajo(Lectura lecturaActual,Lectura lecturaAnterior) {
		float consumoPeriodo = 0;
		
		if(traerLecturaBaja( lecturaActual.getFechaRegistro() ).getFechaRegistro() != null &&
				traerLecturaBaja( lecturaAnterior.getFechaRegistro() ).getFechaRegistro() != null) {
			
			Period periodo = Period.between( traerLecturaBaja(lecturaAnterior.getFechaRegistro()).getFechaRegistro() ,
					traerLecturaBaja(lecturaActual.getFechaRegistro() ).getFechaRegistro() );
			
			if(periodo.getMonths() == 2) {//verifico que las fechas esten entre 2 meses
				
				consumoPeriodo = traerLecturaBaja(lecturaActual.getFechaRegistro()).getConsumo()
						- traerLecturaBaja(lecturaAnterior.getFechaRegistro()).getConsumo();
			}
		}
		
		return consumoPeriodo;
	}

	public float calcularConsumoAlto(Lectura lecturaActual,Lectura lecturaAnterior) {
		float consumoPeriodo = 0 , consumoPico = 0 , consumoValle = 0 , consumoResto = 0;
		
		if(traerLecturaAlta( lecturaActual.getFechaRegistro() ).getFechaRegistro() != null &&
				traerLecturaAlta( lecturaAnterior.getFechaRegistro() ).getFechaRegistro() != null) {
			
			Period periodo = Period.between( traerLecturaAlta(lecturaAnterior.getFechaRegistro()).getFechaRegistro() ,
					traerLecturaAlta(lecturaActual.getFechaRegistro() ).getFechaRegistro() );
			
			if(periodo.getMonths() == 2) {//verifico que las fechas esten entre 2 meses
				consumoPico = traerLecturaAlta(lecturaActual.getFechaRegistro()).getConsumoHorasPico()
						- traerLecturaAlta(lecturaAnterior.getFechaRegistro()).getConsumoHorasPico();
				
				consumoValle = traerLecturaAlta(lecturaActual.getFechaRegistro()).getConsumoHorasValle()
						- traerLecturaAlta(lecturaAnterior.getFechaRegistro()).getConsumoHorasValle();
				
				consumoResto = traerLecturaAlta(lecturaActual.getFechaRegistro()).getConsumoHorasResto()
						- traerLecturaAlta(lecturaAnterior.getFechaRegistro()).getConsumoHorasResto();
				
				consumoPeriodo = consumoPico + consumoValle + consumoResto;
			}
		}
		
		return consumoPeriodo;
	}
 	
	
}
