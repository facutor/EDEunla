package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


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
			id = this.listaFacturas.get(this.listaFacturas.size() - 1).getIdFactura() + 1;
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
	
	public boolean agregarTarifaAlta(String servicio,String tensionContratada, int limite ,List<DetalleAlta> lisDetalleAltas) {
		Tarifa tarifa = new TarifaAlta(servicio, tensionContratada, limite, lisDetalleAltas);
		return listaTarifas.add(tarifa);
	}
	
	public boolean agregarInspector(long dni,String nombre,String apellido) throws Exception{
		int id = 1; //generador de id para inspector
		if(traerInspector(dni) != null )throw new Exception("Excepcion: El inspector con dni= "+dni+" que quiere agregar ya existe");
		if( !listaInspector.isEmpty() ) {
			id = this.listaInspector.get( this.listaInspector.size() - 1 ).getIdInspector() + 1;
		}
		Inspector inspector = new Inspector(id, apellido, nombre, dni);
		return listaInspector.add(inspector);
	}
	
	public boolean agregarClienteFisico(String demanda,String cuil,String apellido,String nombre, Zona zona)throws Exception{
		int id = 1;//generador de id
		if( demanda.equalsIgnoreCase("Alta") || demanda.equalsIgnoreCase("Baja") ) {
			
			if (traerClienteFisico(cuil)!=null) throw new Exception("Excepcion: El cliente Fisico con cuil "+cuil+" que quiere agregar ya existe");
			else if( !this.listaClientes.isEmpty() ) {
				id = this.listaClientes.get(this.listaClientes.size() - 1 ).getIdCliente() + 1;
			}
			ClienteFisico cf = new ClienteFisico(id, demanda, zona, cuil, apellido, nombre);
			return listaClientes.add(cf);
		
		}
		else throw new Exception("La Demanda es Incorrecta");
	}

	public boolean agregarClienteJuridico(String demanda,String cuit,String nombreEmpresa,Zona zona)throws Exception{
		int id = 1;//se usar como generador de los id

		if( demanda.equalsIgnoreCase("Alta") || demanda.equalsIgnoreCase("Baja") ) {
		
			if (traerClienteJuridico(cuit)!=null) throw new Exception("Excepcion: El cliente Juridico con cuit "+cuit+" que quiere agregar ya existe");
			else if( !this.listaClientes.isEmpty() ) {
				id = this.listaClientes.get( this.listaClientes.size() - 1).getIdCliente() + 1;
			}
		    ClienteJuridico cj= new ClienteJuridico(id, demanda, zona, cuit, nombreEmpresa);
		    return listaClientes.add(cj);
		
		}
		else {
			throw new Exception("Exepcion: La demanda es incorrecta");
		}
	}
	
	public boolean agregarMedidor(String domicilioMedidor,Cliente cliente,Tarifa tarifa) throws Exception{
		boolean esBaja = false;
		int contador = 1;
		
		if (traerMedidor(domicilioMedidor)!=null) throw new Exception("El medidor con domicilio="+domicilioMedidor+" que quiere agregar ya exite");
	    
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
		if (traerLecturaBaja(fechaRegistro)!=null) throw new Exception("La lecturaBaja con fechaRegistro="+fechaRegistro+" que quiere ingresar ya existe");
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
		if(traerLecturaAlta(fechaRegistro)!=null) throw new Exception("La lecturaAlta con fechaRegistro="+fechaRegistro+" que quiere agregar ya existe");
		if ( !this.listaLectura.isEmpty()) {
			c = this.listaLectura.get(this.listaLectura.size() - 1).getIdLectura() + 1;
		}
		LecturaAlta la = new LecturaAlta(c, inspector, fechaRegistro, medidor, consumoHorasPico, consumoHorasValle, consumoHorasResto);
		return listaLectura.add(la);
	}
	
	public boolean agregarTarifaBaja(String servicio, List<DetalleBaja> listaDetalle) throws Exception {
		if (traerTarifaBaja(servicio)!= null) throw new Exception("La tarifa con el servicio="+servicio+" que quiere ingresar ya existe");
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
	public Lectura traerLectura(LocalDate fechaRegistro) {
		int i = 0;
		Lectura lectura = null;
		while(lectura == null && i < listaLectura.size() ) {
			if(this.listaLectura.get(i).getFechaRegistro().equals(fechaRegistro) ) {
					lectura = this.listaLectura.get(i);
			}
			i++;
		}
		return lectura;
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
	public Tarifa traerTarifa(String servicio) {
		Tarifa tarifa = null;
		int indice = 0;
		while( tarifa == null && indice < this.listaTarifas.size() ) {
			if( this.listaTarifas.get(indice).getServicio().equals(servicio) ) {
				tarifa = this.listaTarifas.get(indice);
			}
			indice++;
		}
		return tarifa;
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
	
	public boolean eliminarClienteFisico (String cuil)throws Exception {
		ClienteFisico cf = this.traerClienteFisico(cuil);
		if( cf == null ) throw new Exception("Excepcion: El Cliente con cuil "+cuil+" que quiere eliminar no existe");
		
		return this.listaClientes.remove(cf);		
	}
	
	public boolean eliminarClienteJuridico (String cuit) throws Exception {	
		ClienteJuridico cj = this.traerClienteJuridico(cuit);
		if(cj ==  null) throw new Exception("Excepcion: El Cliente con cuit="+cuit+" que quiere eliminar no existe");
		
		return this.listaClientes.remove(cj);
	}

	public boolean eliminarMedidor(String domicilioMedidor)throws Exception {
		Medidor m = this.traerMedidor(domicilioMedidor);
		if(m == null) throw new Exception("Excepcion: El Medidor con domicilio="+domicilioMedidor+" que quiere eliminar no existe");
		
		return this.listaMedidores.remove(m);
	}

	public boolean eliminarZona(int idZona) throws Exception {
		Zona z = this.traerZona(idZona);
		if (z==null) throw new Exception("Excepcion: La Zona con id="+idZona+" que quiere eliminar no existe");
		
		return this.listaZonas.remove(z);
	}
	
	public boolean eliminarLectura(LocalDate fechaRegistro)throws Exception {
		Lectura lectura = this.traerLectura(fechaRegistro);
		if(lectura == null) throw new Exception("Excepcion: La Lectura con la fechaRegistro="+fechaRegistro+" que quiere eliminar no existe");
		
		return this.listaLectura.remove(lectura);
	}
	
	public boolean eliminarTarifa(String servicio)throws Exception{
		Tarifa tarifa = this.traerTarifa(servicio);
		if(tarifa == null) throw new Exception("Excepcion: La Tarifa que quiere eliminar no existe");
		
		return this.listaTarifas.remove(tarifa);
	}
	
	public boolean eliminarFactura(int idFactura) throws Exception {
		Factura f = this.traerFactura(idFactura);
		if ( f == null) throw new Exception("Exception: La factura que quiere eliminar no existe");
		
		return this.listaFacturas.remove(f);
	}
	
	public boolean eliminarItemFactura(int idItemFactura) throws Exception {
		ItemFactura itemF = this.traerItemFactura(idItemFactura);
		if (traerItemFactura(idItemFactura) == null) throw new Exception("Exception: El Item Factura que quiere eliminar no existe");
	
		return this.listaItemFactura.remove(itemF);
	}
	/*******************************************Modificar Metodos*************************************************************/
	public void modificarInspector(long dni , String nombre,String apellido)throws Exception {
		Inspector inspector = traerInspector(dni);
		
		if(inspector == null) {
			throw new Exception("Excepcion: El Inspector que quiere modificar no Existe");
		}
		else {
			inspector.setApellido(apellido);
			inspector.setNombre(nombre);
		}
	}
	
	public void modificarLecturaAlta(LocalDate fechaRegistro,int consumoHorasPico,int consumoHorasValle,int consumoHorasResto) throws Exception {
		LecturaAlta la = this.traerLecturaAlta(fechaRegistro);
		if( la == null) throw new Exception("Excepcion: La Lectura Alta con la fechaRegistro="+fechaRegistro+" que quiere modificar no existe");  
			
		la.setConsumoHorasPico(consumoHorasPico);
		la.setConsumoHorasValle(consumoHorasValle);
		la.setConsumoHorasResto(consumoHorasResto);
	}
	
	public void modificarLecturaBaja(LocalDate fechaRegistro, int consumo)throws Exception {
		
		LecturaBaja lb = this.traerLecturaBaja(fechaRegistro);
		if( lb == null) throw new Exception("Excepcion: La Lectura Baja con la fechaRegistro="+fechaRegistro+" que quiere modificar no existe");  
			
		lb.setConsumo(consumo);
	}

	public void modificarZona(int idZona, String zona , Inspector inspector) throws Exception {
		Zona z = this.traerZona(idZona);
		if( z == null) throw new Exception("Excepcion: La zona que quiere modificar no existe");
			
		z.setZona(zona);
		z.setInspector(inspector);
	}
	
	public void modificarMedidor(String domicilioMedidor, Cliente cliente) throws Exception {
		Medidor medidor = this.traerMedidor(domicilioMedidor);
		if ( medidor == null) throw new Exception("Excepcion: El Medidor con domicilio="+domicilioMedidor+" que quiere modificar no existe");
			
		if(cliente.getDemanda().equalsIgnoreCase("Alta") ) {
			medidor.setEsBaja(false);
		}
		else {
			medidor.setEsBaja(true);
		}
		medidor.setCliente(cliente);
	}
	
		
	public void modificarClienteFisico(String cuil, String demanda) throws Exception {
		ClienteFisico cf = this.traerClienteFisico(cuil);
		if( cf == null) throw new Exception("Excepcion: El Cliente Fisico con cuil "+cuil+" que quiere modificar no existe");
		
		cf.setDemanda(demanda);
	}
	
	public void modificarClienteJuridico(String cuit, String demanda) throws Exception {
		ClienteJuridico cj = this.traerClienteJuridico(cuit);
		if ( cj == null) throw new Exception("Excepcion: El Cliente Juridico con cuit "+cuit+" que quiere modificar no existe");
		
		cj.setDemanda(demanda);
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