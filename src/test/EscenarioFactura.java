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
		//****************************Inspector*************************
		sistema.agregarInspector(40667235 , "Luis", "Rodriguez");
		sistema.agregarInspector(39666666, "Jorge", "Perez");
		//**************************Zona********************************
		sistema.agregarzona( 0,"Zona Sur",sistema.traerInspector(40667235) );
		sistema.agregarzona(0," Zona Norte", sistema.traerInspector(40667235));
		//******************************Cliente********************************
		sistema.agregarClienteFisico( "Baja", "20417677377", "Rivera","Tomas", sistema.traerZona(2));
		sistema.agregarClienteJuridico( "Baja", "20393453452", "Empresa 1", sistema.traerZona(1) );
		
		/*************************Detalle Baja*************************/
		List<DetalleBaja> listDetalleBaja = new ArrayList<DetalleBaja>();
		//DetalleBaja(detalleConcepto, unidad, desde, hasta, valor)
		DetalleBaja db1 = new DetalleBaja("Cargo Fijo", "$mes", 0, 200, 45);
		DetalleBaja db2 = new DetalleBaja("Cargo Variable", "$kw/h", 201, 300, 20);
		DetalleBaja db3 = new DetalleBaja("Cargo Fijo", "$mes", 301, 400, 34.6);
		DetalleBaja db4 = new DetalleBaja("Cargo Variable", "$kw/h", 301, 400, 16.8);
		DetalleBaja db5 = new DetalleBaja("Cargo Fijo", "$mes", 401, 550, 20.60);
		DetalleBaja db6 = new DetalleBaja("Cargo Variable", "$kw/h", 551, 700, 26.12);
		DetalleBaja db7 = new DetalleBaja("Cargo Fijo", "$mes", 701, 801, 35);
		DetalleBaja db8 = new DetalleBaja("Cargo Variable", "$kw/h", 802 , 940, 23);
		listDetalleBaja.add(db1);
		listDetalleBaja.add(db2);
		listDetalleBaja.add(db3);
		listDetalleBaja.add(db4);
		listDetalleBaja.add(db5);
		listDetalleBaja.add(db6);
		listDetalleBaja.add(db7);
		listDetalleBaja.add(db8);
		/*************************Genero Tarifario Baja Demanda***********************/
		sistema.agregarTarifaBaja("Baja Demanda", listDetalleBaja);
		
		//******************************Medidor*******************************/
		sistema.agregarMedidor("Calle 2", sistema.traerClienteJuridico("20393453452"),sistema.traerTarifaBaja("Baja Demanda"));
		sistema.agregarMedidor("Calle 3", sistema.traerClienteFisico("20417677377"), sistema.traerTarifaBaja("Baja Demanda"));
		
		/******************Lectura Baja*************************/
		LocalDate fecha1 = LocalDate.of(2019, 4, 10);
		LocalDate fecha2 = LocalDate.of(2019, 6, 10);
		LocalDate fecha3 = LocalDate.of(2019, 6, 11);
		LocalDate fecha4 = LocalDate.of(2019, 8, 11);
		
		LocalDate fecha5 = LocalDate.of(2019, 8, 12);
		LocalDate fecha6 = LocalDate.of(2019, 10, 12);
		LocalDate fecha7 = LocalDate.of(2019, 10, 13);
		LocalDate fecha8 = LocalDate.of(2019, 12, 13);
		//Lectura medidor 1
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha1, sistema.traerMedidor("Calle 2"), 100);
		sistema.agregarLecturaBaja(sistema.traerInspector(39666666), fecha2, sistema.traerMedidor("Calle 2"), 150);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha3, sistema.traerMedidor("Calle 2"), 120);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha4, sistema.traerMedidor("Calle 2"), 200);
		//Lectura medidor 2
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha5, sistema.traerMedidor("Calle 3"), 170);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha6, sistema.traerMedidor("Calle 3"), 240);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha7, sistema.traerMedidor("Calle 3"), 241);
		sistema.agregarLecturaBaja(sistema.traerInspector(40667235), fecha8, sistema.traerMedidor("Calle 3"), 340);		
		
		/************************Item Factura de Baja Demanda**************************/
		//agregarItemFactura(idItemFactura, detalle, precioUnitario, cantidad, unidad)
		sistema.agregarItemFactura(1111,"Cargo Fijo","$mes",(float)db1.getValor(),1 );
		sistema.agregarItemFactura(2222, "Cargo Variable","$kWh",(float)db2.getValor() ,sistema.calcularConsumoBaja( sistema.traerLecturaBaja(fecha1), sistema.traerLecturaBaja(fecha2) ) );
		sistema.agregarItemFactura(3333, "Cargo Fijo", "$mes",(float)db3.getValor(), 1 );
		sistema.agregarItemFactura(4444, "Cargo Variable","$kWh",(float)db4.getValor(),sistema.calcularConsumoBaja( sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4) ) );
		sistema.agregarItemFactura(5555, "Cargo Fijo", "$mes", (float)db5.getValor(),1);
		sistema.agregarItemFactura(6666, "Cargo Variable", "$kWh", (float)db6.getValor(),sistema.calcularConsumoBaja(sistema.traerLecturaBaja(fecha5),sistema.traerLecturaBaja(fecha6) ));
		sistema.agregarItemFactura(7777, "Cargo Fijo", "$mes", (float)db7.getValor(),1);
		sistema.agregarItemFactura(8888, "Cargo Variable", "$kWh", (float)db8.getValor(),sistema.calcularConsumoBaja(sistema.traerLecturaBaja(fecha7),sistema.traerLecturaBaja(fecha8) ));
		
		/*****************************************Item Factura Cliente 1****************************************/
		/********************Item Factura 1**************************/
		List<ItemFactura> listItemFacturasBaja1 = new ArrayList<ItemFactura>();
		listItemFacturasBaja1.add(sistema.traerItemFactura(1111));
		listItemFacturasBaja1.add(sistema.traerItemFactura(2222));
		/****************************Item Factura 2**************************/
		List<ItemFactura> listItemFacturasBaja2 = new ArrayList<ItemFactura>();
		listItemFacturasBaja2.add(sistema.traerItemFactura(3333));
		listItemFacturasBaja2.add(sistema.traerItemFactura(4444));
		
		/*****************************************Item Factura Cliente 2****************************************/
		/************************Item Factura 1**************************/
		List<ItemFactura> listItemFacturasBaja3 = new ArrayList<ItemFactura>();
		listItemFacturasBaja3.add(sistema.traerItemFactura(5555));
		listItemFacturasBaja3.add(sistema.traerItemFactura(6666));
		
		/************************Item Factura 2**************************/
		List<ItemFactura> listItemFacturasBaja4 = new ArrayList<ItemFactura>();
		listItemFacturasBaja4.add(sistema.traerItemFactura(7777));
		listItemFacturasBaja4.add(sistema.traerItemFactura(8888));
		
		
		/*******************************generar Facturas de  Baja Demanda*******************************/
		//agregarFactura(lecturaAnterior, lecturaActual, fecha, lisItemFacturas)
		//facturas del cliente 1
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha1), sistema.traerLecturaBaja(fecha2), LocalDate.of(2019, 6, 20), listItemFacturasBaja1);
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha3), sistema.traerLecturaBaja(fecha4), LocalDate.of(2019, 8, 15), listItemFacturasBaja2);
		//facturas del cliente 2
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha5),sistema.traerLecturaBaja(fecha6), LocalDate.of(2019, 10, 20), listItemFacturasBaja3);
		sistema.agregarFactura(sistema.traerLecturaBaja(fecha7),sistema.traerLecturaBaja(fecha8), LocalDate.of(2019, 12, 19), listItemFacturasBaja4);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		/**************************Genero Facturas*********************/
		System.out.println("Consumo x Factura: ");
		System.out.println(sistema.traerFactura(1));
		System.out.println(sistema.traerFactura(2));
		System.out.println(sistema.traerFactura(3));
		System.out.println(sistema.traerFactura(4));
		
		/*************************************Precio de las Facturas(Baja Demanda)*********************************/
		System.out.println("\n**********************Precios********************* ");
		System.out.println(" Precio Baja Demanda Factura 1:" + sistema.calcularPrecioBaja(sistema.traerFactura(1), sistema.traerItemFactura(1111), sistema.traerItemFactura(2222)) );
		System.out.println(" Precio Baja Demanda Factura 2: " + sistema.calcularPrecioBaja(sistema.traerFactura(2), sistema.traerItemFactura(3333), sistema.traerItemFactura(4444)));
		System.out.println(" Precio Baja Demanda Factura 3: " + sistema.calcularPrecioBaja(sistema.traerFactura(3), sistema.traerItemFactura(5555), sistema.traerItemFactura(6666)));
		System.out.println(" Precio Baja Demanda Factura 4: " + sistema.calcularPrecioBaja(sistema.traerFactura(4), sistema.traerItemFactura(7777), sistema.traerItemFactura(8888)));
		
		/******************Consumo Total porBandaTarifaria de Baja Demanda entre 2 Fechas(fecha inicio/fecha fin)*******************/
		System.out.println("\n************Consumo Total Baja Demanda entre "+LocalDate.of(2019, 1, 1)+" y "+LocalDate.of(2019, 8, 30)+"***********");			//fecha inicio				//fecha fin
		System.out.println("Consumo total: "+sistema.calcularConsumoTarifaBajaTotal(sistema.traerTarifaBaja("Baja Demanda"), LocalDate.of(2019, 1, 1), LocalDate.of(2019, 8, 30) ) );
	
		/************************Reporte de facturas emitidas entre fechas(Fecha inicio/fecha Fin)*****************************/
		System.out.println("\n**************Reporte de facturas emitidas entre "+LocalDate.of(2019, 1, 1)+" y "+LocalDate.of(2019, 8, 20)+"*****************");
		System.out.println(sistema.reporteFacturasEntreFechas( LocalDate.of(2019, 1, 1), LocalDate.of(2019, 8, 20) ) );
		
		/*********************Reporte de consumo por Cliente entre Fechas(fecha inicio/fecha fin)************************/
		System.out.println("\n*************Reporte de consumo por Cliente entre "+LocalDate.of(2019, 10, 10)+" y "+LocalDate.of(2020, 1,1 )+"***************");
		System.out.println( sistema.traerClienteFisico("20417677377")+"\nConsumo Total :"								//fecha inicio		//fecha fin
				+sistema.reporteConsumoPorClienteEntreFechas(sistema.traerClienteFisico("20417677377"), LocalDate.of(2019, 10, 10), LocalDate.of(2020, 1,1 ) ) );
	
		/***************************Report de Energia Total entre Fechas*************************/
		System.out.println("\n**************Reporte de energia total entre "+( LocalDate.of(2019, 1, 10))+" y "+LocalDate.of(2020, 1,10 )+"***************");
		System.out.println("Consumo Total: "+sistema.reporteEnergioTotalEntreFechas(LocalDate.of(2019, 1, 10), LocalDate.of(2020, 1, 10) ) );
	}

}
