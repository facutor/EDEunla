package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.EmptyStackException;
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
	/********************************************Agregar metodos*****************************/
	public boolean agregarItemFactura(long idItemFactura,String detalle,String unidad,float precioUnitario,float cantidad) {
		
		ItemFactura itemFactura = new ItemFactura(idItemFactura, detalle, unidad, cantidad, precioUnitario);
		return listaItemFactura.add(itemFactura);
	}
	
	public boolean agregarFactura(Lectura lecturaAnterior,Lectura lecturaActual,LocalDate fecha,List<ItemFactura> lisItemFacturas) throws Exception {
		
		if( lecturaActual.getMedidor().getIdMedidor() != lecturaAnterior.getMedidor().getIdMedidor() )throw new Exception("Execpion: La Lecturas no tienen el mismo Medidor");
		
		Period periodo = Period.between(lecturaAnterior.getFechaRegistro() , lecturaActual.getFechaRegistro() );
		if(periodo.getMonths() != 2) throw new Exception("Excepcion: Las Lecturas no tienen una diferencia de 2 meses");
		
		int id = 1;//generador del id de factura
		if( !listaFacturas.isEmpty() ) {
			for (int i = 0; i < listaFacturas.size() ; i++) {
				id++;
			}
		}
		//NOTA: un medidor va a pertenecer a un solo cliente y logicamente las lecturas que paso son de un mismo medidor 
		String cliente = "";	
		 if ( lecturaActual.getMedidor().getCliente() instanceof ClienteFisico ) {
			 cliente = ( (ClienteFisico)lecturaActual.getMedidor().getCliente() ).getApellido()+
					 " "+( (ClienteFisico)lecturaActual.getMedidor().getCliente() ).getNombre(); //nombre del cliente fisico
		 }
		 else if( lecturaActual.getMedidor().getCliente() instanceof ClienteJuridico ) {
					cliente = ( (ClienteJuridico)lecturaActual.getMedidor().getCliente() ).getNombreEmpresa() ;//razon social/nombre de la empresa (cliente juridico)
		 }
		 
		Factura f = new Factura(id, fecha, cliente, lecturaActual.getMedidor().getIdMedidor() , lecturaAnterior, lecturaActual,lisItemFacturas );
		return listaFacturas.add(f);
	}
	
	public boolean agregarTarifaAlta(String servicio,String tensionContratada, int limite ,List<DetalleAlta> lisDetalleAltas)throws Exception {
		if(traerTarifaAlta(servicio) != null) throw new Exception("Exepcion: La Tarifa ya existe");
		
		Tarifa t = new TarifaAlta(servicio, tensionContratada, limite, lisDetalleAltas);
		return listaTarifas.add(t);
	}
	
	public boolean agregarInspector(long dni,String nombre,String apellido) throws Exception{
		int id = 1; //generador de id para inspector
		if(traerInspector(dni) != null )throw new Exception("Excepcion: El Inspector ya existe");
		
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
		if( demanda.equals("Alta") || demanda.equals("ALTA") 
				|| demanda.equals("Baja") || demanda.equals("BAJA") ) {
			
			if (traerClienteFisico(cuil)!=null) {
				throw new Exception("El cliente con cuil "+cuil+" que quiere ingresar ya exite");
			}
			for (int i = 0; i < listaClientes.size(); i++) {
				contador++;
			}
			ClienteFisico cf = new ClienteFisico(contador, demanda, zona, cuil, apellido, nombre);
			return listaClientes.add(cf);
		}
		else {
			throw new Exception("Exepcion: La demanda "+demanda+" es incorrecta");
		}
	}

	public boolean agregarClienteJuridico(String demanda,String cuit,String nombreEmpresa,Zona zona)throws Exception{
		int contador = 1;//se usar como generador de los id

		if( demanda.equals("Alta") || demanda.equals("ALTA") 
				|| demanda.equals("Baja") || demanda.equals("BAJA") ) {
		
			if (traerClienteJuridico(cuit)!=null) throw new Exception("El cliente con cuit "+cuit+" que quiere agregar ya existe");
		    for (int i = 0; i < listaClientes.size(); i++) {
				contador++;
			}
		    ClienteJuridico cj= new ClienteJuridico(contador, demanda, zona, cuit, nombreEmpresa);
		    return listaClientes.add(cj);
		}
		else {
			throw new Exception("Exepcion: La demanda "+demanda+" es incorrecta");
		}
	}
	
	public boolean agregarMedidor(String domicilioMedidor,Cliente cliente,Tarifa tarifa) throws Exception{
		boolean esBaja = false;
		int contador = 1;
		
		if (traerMedidor(domicilioMedidor)!=null) throw new Exception("El medidor con domicilio "+domicilioMedidor+" que quiere agregar ya exite");
	    
		if (listaMedidores.isEmpty()==false) {
			for (int i = 0; i < listaMedidores.size(); i++) {
				contador++;
			}
		}
		if (cliente.getDemanda().equalsIgnoreCase("Alta")) {
			esBaja=false;
		}
		else if (cliente.getDemanda().equalsIgnoreCase("Baja")) {
			esBaja=true;
		}
		Medidor medidor = new Medidor(contador, domicilioMedidor, esBaja, cliente, tarifa);
		return listaMedidores.add(medidor);
	}
	
	public boolean agregarzona(int idZona,String zona, Inspector inspector) throws Exception {
		if (traerZona(idZona)!=null) throw new Exception("La zona con id "+idZona+" que quiere ingresar ya existe");
		idZona = 1;
		
		if (getListaZonas().isEmpty()==false) {
			idZona=listaZonas.get(listaZonas.size()-1).getIdZona()+1;
		}	
		Zona z= new Zona(idZona, zona, inspector);
		return listaZonas.add(z);
	}

	public boolean agregarLecturaBaja(Inspector inspector,LocalDate fechaRegistro,Medidor medidor,int consumo)throws Exception {
		int c=1;
		if (traerLecturaBaja(fechaRegistro)!=null) throw new Exception("La lectura con fecha "+fechaRegistro+" que quiere ingresar ya exite");
	    if (listaLectura.isEmpty()==false) {
	    	for (int i = 0; i < listaLectura.size(); i++) {
				c++;
			}
		}
	    LecturaBaja lb= new LecturaBaja(c, inspector, fechaRegistro, medidor, consumo);
	    return listaLectura.add(lb);
	}
	
	public boolean agregarLecturaAlta(Inspector inspector,LocalDate fechaRegistro,Medidor medidor,int consumoHorasPico,int consumoHorasValle,int consumoHorasResto) throws Exception{
		int c = 1;
		if(traerLecturaAlta(fechaRegistro)!=null) throw new Exception("La lectura con fecha "+fechaRegistro+" que quiere agregar ya exite");
	
		if (listaLectura.isEmpty()) {
			for (int i = 0; i < listaLectura.size(); i++) {
				c++;
			}
		}
		
		LecturaAlta la = new LecturaAlta(c, inspector, fechaRegistro, medidor, consumoHorasPico, consumoHorasValle, consumoHorasResto);
		return listaLectura.add(la);
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
		ClienteFisico dato=null;
		int i=0;
		while (dato==null&&i<listaClientes.size()) {
			if (listaClientes.get(i) instanceof ClienteFisico) {
				ClienteFisico cf =(ClienteFisico) listaClientes.get(i);
				if (cf.getCuil().equals(cuil)) {
					dato= (ClienteFisico) listaClientes.get(i);
				}
			}
			i++;
		}
		return dato;
	}
	
	public ClienteJuridico traerClienteJuridico(String cuit) {
		ClienteJuridico dato=null;
		int i=0;
		while (dato==null&&i<listaClientes.size()) {
			if (listaClientes.get(i) instanceof ClienteJuridico) {
				ClienteJuridico cj =(ClienteJuridico) listaClientes.get(i);
				if (cj.getCuit().equals(cuit)) {
					dato = (ClienteJuridico) listaClientes.get(i);
				}
			}
			i++;
		}
		return dato;

	}
		
	public Medidor traerMedidor(String domicilio){
		Medidor dato=null;
		int i=0;
		while (dato==null&& i<listaMedidores.size()) {
			if (listaMedidores.get(i).getDomicilioMedidor().equals(domicilio)) {
				dato=listaMedidores.get(i);
			}
			i++;
		}
		return dato;
	}

	public Zona traerZona(int idZona) {
		int i=0;
		Zona zona = null;
		while(zona == null && i< listaZonas.size() ) {
			if(listaZonas.get(i).getIdZona() == idZona) {
				zona = listaZonas.get(i);
			}
			i++;
		}
		return zona;
	}
	
	public LecturaBaja traerLecturaBaja(LocalDate fechaRegistro) {
		int i = 0;
		LecturaBaja lecturaBaja = null;
		
		while(lecturaBaja == null && i < listaLectura.size() ) {
			if(listaLectura.get(i) instanceof LecturaBaja) {
				if( ((LecturaBaja)listaLectura.get(i)).getFechaRegistro().equals(fechaRegistro) ) {
					lecturaBaja = ((LecturaBaja)listaLectura.get(i));
				}
			}
			i++;
		}
		return lecturaBaja;
	}
	
	public LecturaAlta traerLecturaAlta(LocalDate fechaRegistro) {
		int i = 0;
		LecturaAlta lecturaAlta = null;
		
		while(lecturaAlta == null && i < listaLectura.size() ) {
			if(listaLectura.get(i) instanceof LecturaAlta) {
				if( ((LecturaAlta)listaLectura.get(i)).getFechaRegistro().equals(fechaRegistro) ) {
					lecturaAlta = ((LecturaAlta)listaLectura.get(i));
				}
			}
			i++;
		}
		return lecturaAlta;
	}
	
	public TarifaBaja traerTarifaBaja(String servicio) {
		TarifaBaja tarifaBaja =null;
		int contador=0;
		
		while(tarifaBaja == null && contador<listaTarifas.size() ) {
			if (listaTarifas.get(contador) instanceof TarifaBaja) {
				TarifaBaja tb = (TarifaBaja) listaTarifas.get(contador);
				if (tb.getServicio().equals(servicio)) {
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
			if ( listaFacturas.get(i).getIdFactura() == idFactura) {
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
		
		if(traerClienteFisico(cuil) != null) {
			listaClientes.remove( traerClienteFisico(cuil) );
		}
		else throw new Exception("Excepcion: El Cliente con cuil "+cuil+" que quiere eliminar no existe");
	}
	
	
	public void eliminarClienteJuridico (String cuit) throws Exception {
		
		if(traerClienteJuridico(cuit) !=  null) {
			listaClientes.remove( traerClienteJuridico(cuit) );
		}
		else {
			throw new Exception("Excepcion: El Cliente con cuit "+cuit+" que quiere eliminar no existe");
		}
	}

	public void eliminarMedidor(String domicilioMedidor)throws Exception {
		
		if(traerMedidor(domicilioMedidor).getCliente().getDemanda() != null) {
			listaMedidores.remove( traerMedidor(domicilioMedidor) );
		}
		else {
			throw new Exception("Excepcion: El Medidor con domicilio"+domicilioMedidor+" que quiere eliminar no existe");
		}
	}

	public void eliminarZona(int idZona) throws Exception {
		
		if (traerZona(idZona).getZona()!=null) {
			listaZonas.remove( traerZona(idZona) );
		}
		else throw new Exception("Excepcion: La Zona con id "+idZona+" que quiere eliminar no existe");
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

	public void modificarZona(int idZona, String zona , Inspector inspector) throws Exception {
		
		if(traerZona(idZona) != null) {
			traerZona(idZona).setZona(zona);
			traerZona(idZona).setInspector(inspector);
		}
		else throw new Exception("Excepcion: La zona con id "+idZona+" que quiere modificar no existe");
	}
	
	public void modificarMedidor(String domicilioMedidor, Cliente cliente) throws Exception {
		
		if ( traerMedidor(domicilioMedidor) != null) {
			
			if(cliente.getDemanda().equals("Alta") ) {
				traerMedidor(domicilioMedidor).setEsBaja(false);
			}
			else {
				traerMedidor(domicilioMedidor).setEsBaja(true);
			}
		}
		else throw new Exception("Excepcion: El Medidor con domicilio "+domicilioMedidor+" que quiere modificar no existe");
		
	}
		
	public void modificarClienteFisico(String cuil, String demanda) throws Exception {
		
		if(traerClienteFisico(cuil) != null) {
			traerClienteFisico(cuil).setDemanda(demanda);
		}
		else throw new Exception("Excepcion: El Cliente con cuil "+cuil+" que quiere modificar no existe");
	}
	
	public void modificarClienteJuridico(String cuit, String demanda) throws Exception {
		
		if (traerClienteJuridico(cuit) != null) {
			traerClienteJuridico(cuit).setDemanda(demanda);
		}
		else throw new Exception("Excepcion: El Cliente con cuit "+cuit+" que quiere modificar no existe");
	}
	
	/***********************************************Calcular Consumos*********************************************/
	public float calcularConsumoBaja(LecturaBaja lecturaAnterior , LecturaBaja lecturaActual) {
		float consumoBajo = 0;
		if(lecturaAnterior instanceof LecturaBaja && lecturaActual instanceof LecturaBaja) {
			consumoBajo=( (LecturaBaja) lecturaActual).getConsumo() - ( (LecturaBaja) lecturaAnterior).getConsumo();
		}
		return consumoBajo ;
	}
	
	public float calcularConsumoAlta(LecturaAlta lecturaAnterior,LecturaAlta lecturaActual) {
		float consumoPico = 0;
		if(lecturaAnterior instanceof LecturaAlta && lecturaActual instanceof LecturaAlta) {
			consumoPico = ( (LecturaAlta)lecturaActual).getConsumoHorasPico() - ( (LecturaAlta)lecturaAnterior).getConsumoHorasPico();
		}
		return consumoPico;
	}
	
	//punto 13
	public float calcularConsumoTarifaBajaTotal(Tarifa tarifa,LocalDate fehcaInicio,LocalDate fechaFin) {
		float total = 0;
		if(tarifa != null && tarifa.getServicio().equals("Baja Demanda") ) {
			for (int i = 0; i < listaFacturas.size() ; i++) {
				if( listaFacturas.get(i).getLecturaActual().getMedidor().getTarifa().equals(tarifa) ) {
					if( listaFacturas.get(i).getFecha().isAfter(fehcaInicio) && listaFacturas.get(i).getFecha().isBefore(fechaFin) ) {
						total+=listaFacturas.get(i).calcularConsumoBajo();
					}
				}
			}
		}
		return total;
	}
	//punto 13
	public float calcularConsumoTarifaAltaTotal(Tarifa tarifa,LocalDate fehcaInicio,LocalDate fechaFin) {
		float total = 0;
		if(tarifa != null && ( tarifa.getServicio().contains("Alta") || tarifa.getServicio().contains("ALTA") ) ) {
			for (int i = 0; i < listaFacturas.size() ; i++) {
				if( listaFacturas.get(i).getLecturaActual().getMedidor().getTarifa().equals(tarifa) ) {
					if( listaFacturas.get(i).getFecha().isAfter(fehcaInicio) && listaFacturas.get(i).getFecha().isBefore(fechaFin) ) {
						total += ( listaFacturas.get(i).calcularConsumoHorasPico() + listaFacturas.get(i).calcularConsumoHorasValle()+listaFacturas.get(i).calcularConsumoHorasResto() );
					}
				}
			}
		}
		return total;
	}
	/***********************************************Calcular Precios***************************************************/
	//punto 5
	public float calcularPrecioBaja(Factura factura,ItemFactura cargoFijo,ItemFactura cargoVariable ) {
		
		return (float)cargoFijo.getPrecioUnitario() + factura.calcularConsumoBajo()*cargoVariable.getPrecioUnitario();
	}
	//punto 5
	/*
	public float calcularPrecioAlta(Factura factura,ItemFactura cargoFijo,ItemFactura cargoVarible) {
		float precioAlta = 0;
		String tipoTension = ( (TarifaAlta) factura.getLecturaActual().getMedidor().getTarifa() ).getTensionContratada();
		//SUPONGAMOS QUE SI LA TESNION ES: AT=$5000 , MT=$2500 , BT=$1250 
		if(tipoTension.equalsIgnoreCase("AT")) precioAlta = cargoFijo.getPrecioUnitario() +
				factura.calcularConsumoTotalAlta()*cargoVarible.getPrecioUnitario() + 5000;
		
		if(tipoTension.equalsIgnoreCase("MT")) precioAlta = cargoFijo.getPrecioUnitario() +
				factura.calcularConsumoTotalAlta()*cargoVarible.getPrecioUnitario() + 2500;
		
		if(tipoTension.equalsIgnoreCase("BT")) precioAlta = cargoFijo.getPrecioUnitario() +
				factura.calcularConsumoTotalAlta()*cargoVarible.getPrecioUnitario() + 1250;
		
		return precioAlta;
	}
	*/
	
	/******************************************Reportes**********************************/
	//punto 7
	public float reporteConsumoPorClienteEntreFechas(Cliente cliente , LocalDate fechaInicio , LocalDate fechaFin){
		float consumoCliente = 0;
		
		if(cliente != null) {
			for (int i = 0; i < listaFacturas.size() ; i++) {
				if( listaFacturas.get(i).getLecturaActual().getMedidor().getCliente().equals(cliente) ) {
					if( listaFacturas.get(i).getFecha().isAfter(fechaInicio) && listaFacturas.get(i).getFecha().isBefore(fechaFin) ) {
						if(listaFacturas.get(i).getLecturaActual() instanceof LecturaAlta ){
							consumoCliente += listaFacturas.get(i).calcularConsumoTotalAlta();
						}
						else if(listaFacturas.get(i).getLecturaActual() instanceof LecturaBaja){
							consumoCliente += listaFacturas.get(i).calcularConsumoBajo();
						}
					}
				}
			}
		}
		return consumoCliente;
	}
	//punto 8
	public List<Factura> reporteFacturasEntreFechas(LocalDate fechaInicio,LocalDate fechaFin){
		List<Factura> listaReporte = new ArrayList<Factura>();
		for (int i = 0; i < listaFacturas.size() ; i++) {
			if(listaFacturas.get(i).getFecha().isAfter(fechaInicio) && listaFacturas.get(i).getFecha().isBefore(fechaFin) ) {
				listaReporte.add (listaFacturas.get(i) );
			}
		}
		return listaReporte;
	}
	//punto 9
	public float reporteEnergioTotalEntreFechas(LocalDate fechaInicio , LocalDate fechaFin) {
		float energiaTotal = 0;
		
		for (int i = 0; i < listaFacturas.size() ; i++) {
			if(listaFacturas.get(i).getFecha().isAfter(fechaInicio) && listaFacturas.get(i).getFecha().isBefore(fechaFin) ) {
				energiaTotal += listaFacturas.get(i).calcularConsumoTotal();
			}
		}
		return energiaTotal;
	}
		
}