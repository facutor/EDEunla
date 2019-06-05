package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.DetalleAlta;
import modelo.DetalleBaja;
import modelo.ItemFactura;
import modelo.Sistema;

public class EscenarioFactura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sistema = new Sistema();
		try {
			
		sistema.agregarInspector(40667235 , "Luis", "Rodriguez");
		sistema.agregarInspector(39666666, "Jorge", "Perez");
		
		sistema.agregarzona( "Zona Sur", sistema.traerInspector(40667235) );
		sistema.agregarzona(" Zona Norte", sistema.traerInspector(39666666));
			
		
		sistema.agregarClienteFisico( "Alta", "20417677377", "Rivera","Tomas", sistema.traerZona(2));
		sistema.agregarClienteJuridico( "Baja", "20393453452", "Empresa 1", sistema.traerZona(1) );
		
		
		List<DetalleAlta> listaDetallaAlta = new ArrayList<DetalleAlta>();
		DetalleAlta da = new DetalleAlta("Cargo Fijo", "kw/h", true, 20000);
		listaDetallaAlta.add(da);
		sistema.agregarTarifaAlta("Alta Tension","AT", 10000, listaDetallaAlta );

		sistema.agregarMedidor("Calle 1", sistema.traerClienteFisico("20417677377"),sistema.traerTarifaAlta("Alta Tension"));

		
		List<DetalleBaja> listDetalleBaja = new ArrayList<DetalleBaja>();
		DetalleBaja db1 = new DetalleBaja("Cargo Fijo", "$/kwh", 1, 3, 1000);
		listDetalleBaja.add(db1);
		DetalleBaja db2 = new DetalleBaja("Cargo Fijo", "$/mes", 6, 10, 1500);
		listDetalleBaja.add(db2);
		sistema.agregarTarifaBaja("Baja", listDetalleBaja);
		
		sistema.agregarMedidor("Calle 2", sistema.traerClienteJuridico("20393453452"),sistema.traerTarifaBaja("Baja"));
		
		/******************Lectura Alta*************************/
		LocalDate fecha1 = LocalDate.of(2019, 1, 10);
		LocalDate fecha2 = LocalDate.of(2019, 3, 10);
		
		sistema.agregarLecturaAlta(sistema.traerInspector(40667235), fecha1, sistema.traerMedidor(1), 1000, 1000, 1000);
		sistema.agregarLecturaAlta(sistema.traerInspector(40667235), fecha2, sistema.traerMedidor(1), 10000,10000,10000);
	
		/***********************Factura Alta Demanda*****************************/
		
		List<ItemFactura> listItemFacturas1 = new ArrayList<ItemFactura>();
		sistema.agregarItemFactura(1111, "CargoFijo", 10000, 10, "kw/h");
		sistema.agregarItemFactura(2222, "CargoVariable", 100000, 5, "kw/h");
		
		listItemFacturas1.add(if1);
		listItemFacturas1.add(if2);
		
		/******************Lectura Baja*************************/
		LocalDate fecha3 = LocalDate.of(2019, 4, 10);
		LocalDate fecha4 = LocalDate.of(2019, 6, 10);
		
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha3, sistema.traerMedidor(2), 1000);
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha4, sistema.traerMedidor(2), 10000);
		
		/************************Factura Baja Demanda**************************/
		List<ItemFactura> listItemFacturas2 = new ArrayList<ItemFactura>();
		ItemFactura if3 = new ItemFactura(6666, "CargoFijo", 5555, 4, "kw/h");
		ItemFactura if4 = new ItemFactura(6666, "CargoVariable", 15555, 5, "kw/h");
		listItemFacturas2.add(if3);
		listItemFacturas2.add(if4);
		
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4), LocalDate.of(2019, 9, 10),listItemFacturas2);
		
		System.out.println( sistema.traerFactura(2).calcularConsumoBajo());
		}catch(Exception e) {
			System.out.println( e.getMessage() );
		}

	}

}
