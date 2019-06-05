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
		
		sistema.agregarzona( 0,"Zona Sur",sistema.traerInspector(40667235) );
		sistema.agregarzona(0," Zona Norte", sistema.traerInspector(40667235));
			
		
		sistema.agregarClienteFisico( "Alta", "20417677377", "Rivera","Tomas", sistema.traerZona(2));
		sistema.agregarClienteJuridico( "Baja", "20393453452", "Empresa 1", sistema.traerZona(1) );
		
		/*************************Detalle Baja*************************/
		List<DetalleBaja> listDetalleBaja = new ArrayList<DetalleBaja>();
		//DetalleBaja(detalleConcepto, unidad, desde, hasta, valor)
		DetalleBaja db1 = new DetalleBaja("Cargo Fijo", "$mes", 0, 200, 45);
		DetalleBaja db2 = new DetalleBaja("Cargo Variable", "$kw/h", 201, 300, 20);
		DetalleBaja db3 = new DetalleBaja("Cargo Fijo", "$mes", 301, 400, 34.6);
		DetalleBaja db4 = new DetalleBaja("Cargo Variable", "$kw/h", 301, 400, 16.8);
		listDetalleBaja.add(db1);
		listDetalleBaja.add(db2);
		listDetalleBaja.add(db3);
		listDetalleBaja.add(db4);
		/*************************Genero Tarifario Baja Demanda***********************/
		sistema.agregarTarifaBaja("Baja Demanda", listDetalleBaja);
		//Medidor
		sistema.agregarMedidor("Calle 2", sistema.traerClienteJuridico("20393453452"),sistema.traerTarifaBaja("Baja Demanda"));
		
		/******************Lectura Baja*************************/
		LocalDate fecha1 = LocalDate.of(2019, 4, 10);
		LocalDate fecha2 = LocalDate.of(2019, 6, 10);
		LocalDate fecha3 = LocalDate.of(2019, 6, 11);
		LocalDate fecha4 = LocalDate.of(2019, 8, 11);
		
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha1, sistema.traerMedidor("Calle 2"), 100);
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha2, sistema.traerMedidor("Calle 2"), 150);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha3, sistema.traerMedidor("Calle 2"), 120);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha4, sistema.traerMedidor("Calle 2"), 200);
		/************************Item Factura de Baja Demanda **************************/
		//agregarItemFactura(idItemFactura, detalle, precioUnitario, cantidad, unidad)
		sistema.agregarItemFactura(1111,"Cargo Fijo","$mes",(float)db1.getValor(),1 );
		sistema.agregarItemFactura(2222, "CargoVariable","$kw/h",(float)db2.getValor() ,(int)sistema.calcularConsumoBaja( sistema.traerLecturaBaja(fecha1), sistema.traerLecturaBaja(fecha2) ) );
		sistema.agregarItemFactura(3333, "Cargo Fijo", "$mes",(float)db3.getValor(), 1 );
		sistema.agregarItemFactura(4444, "CargoVariable","$kw/h",(float)db4.getValor(),(int)sistema.calcularConsumoBaja( sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4) ) );
		
		/************************Item Factura de Baja Demanda 1**************************/
		List<ItemFactura> listItemFacturasBaja1 = new ArrayList<ItemFactura>();
		listItemFacturasBaja1.add(sistema.traerItemFactura(1111));
		listItemFacturasBaja1.add(sistema.traerItemFactura(2222));
		
		/************************Item Factura de Baja Demanda 2**************************/
		List<ItemFactura> listItemFacturasBaja2 = new ArrayList<ItemFactura>();
		listItemFacturasBaja2.add(sistema.traerItemFactura(3333));
		listItemFacturasBaja2.add(sistema.traerItemFactura(4444));

		/*******************************generar Facturas  Baja Demanda*******************************/
		//agregarFactura(lecturaAnterior, lecturaActual, fecha, lisItemFacturas)
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha1), sistema.traerLecturaBaja(fecha2), LocalDate.of(2019, 7, 10), listItemFacturasBaja1);
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4), LocalDate.of(2019, 8, 12), listItemFacturasBaja2);
		System.out.println(sistema.traerFactura(1));
		System.out.println(sistema.traerFactura(2));
		
		System.out.println("\nTotal de La Factura 1: "+ sistema.traerFactura(1).calcularTotal() );
		System.out.println("\nTotal de La Factura 2: "+ sistema.traerFactura(2).calcularTotal() );

		System.out.println("Total Consumo Factura 1: " + sistema.traerFactura(1).calcularConsumoBajo() );
		System.out.println("Total Consumo Factura 2: "+ sistema.traerFactura(1).calcularConsumoBajo() );
		
		System.out.println("**********************Precios********************* ");
		System.out.println(" Precio Baja Demanda Factura 1:" + sistema.calcularPrecioBaja(sistema.traerFactura(1), sistema.traerItemFactura(1111), sistema.traerItemFactura(2222)) );
		System.out.println(" Precio Baja Demanda Factura 2: " + sistema.calcularPrecioBaja(sistema.traerFactura(1), sistema.traerItemFactura(3333), sistema.traerItemFactura(4444)));
		/******************Lectura Alta*************************/
	/*	
		LocalDate fecha1 = LocalDate.of(2019, 1, 10);
		LocalDate fecha2 = LocalDate.of(2019, 3, 10);
		
		sistema.agregarLecturaAlta(sistema.traerInspector(40667235), fecha1, sistema.traerMedidor(1), 1000, 1000, 1000);
		sistema.agregarLecturaAlta(sistema.traerInspector(40667235), fecha2, sistema.traerMedidor(1), 10000,10000,10000);	
	*/	
		
		/***********************Factura Alta Demanda*****************************/
	/*	
		List<ItemFactura> listItemFacturas1 = new ArrayList<ItemFactura>();
		sistema.agregarItemFactura(1111, "CargoFijo", 10000, 1, "$mes");
		sistema.agregarItemFactura(2222, "CargoVariable", 100000, 5, "$kw/h");
		
		listItemFacturas1.add(if1);
		listItemFacturas1.add(if2);
	
		
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4), LocalDate.of(2019, 9, 10),listItemFacturas2);
		
		
		System.out.println( sistema.traerFactura(2).calcularConsumoBajo());
		*/
		}catch(Exception e) {
			System.out.println( e.getMessage() );
		}
		

	}

}
