package test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.DetalleAlta;
import modelo.DetalleBaja;
import modelo.Sistema;

public class TestLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			// Agregamos Inspector
			sistema.agregarInspector(40667235, "Luis", "Rodriguez");
			sistema.agregarInspector(39666666, "Jorge", "Perez");
			
			// Agregamos Zonas
			sistema.agregarzona(0, "Zona Sur", sistema.traerInspector(40667235));
			sistema.agregarzona(0, "Zona Norte", sistema.traerInspector(39666666));
			
			
			// Agregamos Clientes			
			sistema.agregarClienteFisico("Baja", "20416677396", "Torrez", "Facundo", sistema.traerZona(1));
			sistema.agregarClienteJuridico("Alta", "20456897411", "Belkys Luna y Asociados S.R.L", sistema.traerZona(2));
			
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
			
			/**************************************Detalle Alta**************************************/
			List<DetalleAlta> listaDetalleAltaTension = new ArrayList<DetalleAlta>();
			List<DetalleAlta> listaDetalleMediaTension = new ArrayList<DetalleAlta>();
			List<DetalleAlta> listaDetalleBajaTension = new ArrayList<DetalleAlta>();
			//DetalleAlta
			DetalleAlta da1=new DetalleAlta("Cargo Fijo","$/mes",false,3222.41);
			DetalleAlta da2=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,2.060);
			DetalleAlta da3=new DetalleAlta("Cargo Variable Resto","$/mes",false,1.969);
			DetalleAlta da4=new DetalleAlta("Cargo Variable valle","$/mes",false,1.879);
			
			DetalleAlta da5=new DetalleAlta("Cargo Fijo", "$/mes", false, 4252.41);
			DetalleAlta da6=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,3.060);
			DetalleAlta da7=new DetalleAlta("Cargo Variable Resto","$/mes",false,1.769);
			DetalleAlta da8=new DetalleAlta("Cargo Variable valle","$/mes",false,1.879);
			
			DetalleAlta da9=new DetalleAlta("Cargo Fijo", "$/mes", true, 2252.41);
			DetalleAlta da10=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,4.160);
			DetalleAlta da11=new DetalleAlta("Cargo Variable Resto","$/mes",false,2.769);
			DetalleAlta da12=new DetalleAlta("Cargo Variable valle","$/mes",false,2.079);
			
			DetalleAlta da13=new DetalleAlta("Cargo Fijo", "$/mes", false, 2700.41);
			DetalleAlta da14=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,3.160);
			DetalleAlta da15=new DetalleAlta("Cargo Variable Resto","$/mes",false,1.769);
			DetalleAlta da16=new DetalleAlta("Cargo Variable valle","$/mes",false,1.079);
			
			DetalleAlta da17=new DetalleAlta("Cargo Fijo", "$/mes", true, 3252.41);
			DetalleAlta da18=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,3.506);
			DetalleAlta da19=new DetalleAlta("Cargo Variable Resto","$/mes",false,2.666);
			DetalleAlta da20=new DetalleAlta("Cargo Variable valle","$/mes",false,1.079);
			
			DetalleAlta da21=new DetalleAlta("Cargo Fijo", "$/mes", true, 2222.41);
			DetalleAlta da22=new DetalleAlta("Cargo Variable Pico","$/Kwh",false,1.160);
			DetalleAlta da23=new DetalleAlta("Cargo Variable Resto","$/mes",false,769);
			DetalleAlta da24=new DetalleAlta("Cargo Variable valle","$/mes",false,279);
			
			listaDetalleAltaTension.add(da1);
			listaDetalleAltaTension.add(da2);
			listaDetalleAltaTension.add(da3);
			listaDetalleAltaTension.add(da4);
			listaDetalleAltaTension.add(da5);
			listaDetalleAltaTension.add(da6);
			listaDetalleAltaTension.add(da7);
			listaDetalleAltaTension.add(da8);
			listaDetalleMediaTension.add(da9);
			listaDetalleMediaTension.add(da10);
			listaDetalleMediaTension.add(da11);
			listaDetalleMediaTension.add(da12);
			listaDetalleMediaTension.add(da13);
			listaDetalleMediaTension.add(da14);
			listaDetalleMediaTension.add(da15);
			listaDetalleMediaTension.add(da16);
			listaDetalleBajaTension.add(da17);
			listaDetalleBajaTension.add(da18);
			listaDetalleBajaTension.add(da19);
			listaDetalleBajaTension.add(da20);
			listaDetalleBajaTension.add(da21);
			listaDetalleBajaTension.add(da22);
			listaDetalleBajaTension.add(da23);
			listaDetalleBajaTension.add(da24);
			
			//genero tarifario de alta Demanda
			sistema.agregarTarifaAlta("AltaTension", "AT" , 300, listaDetalleAltaTension);
			sistema.agregarTarifaAlta("MediaTension", "MT" , 300, listaDetalleMediaTension);
			sistema.agregarTarifaAlta("BajaTension", "BT" , 300, listaDetalleBajaTension);
			
			//Agregamos  Medidores
			sistema.agregarMedidor("Calle 2", sistema.traerClienteFisico("20416677396"),sistema.traerTarifaBaja("Baja Demanda"));
			sistema.agregarMedidor("Calle 5", sistema.traerClienteJuridico("20456897411"), sistema.traerTarifaAlta("MediaTension"));
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		try {
			//Agrego Lecturas para los Medidores
			//Lecturas Medidor 1
			sistema.agregarLecturaBaja(sistema.traerInspector(40667235),LocalDate.of(2019, 2, 12),  sistema.traerMedidor("Calle 2"), 210);
			sistema.agregarLecturaBaja(sistema.traerInspector(40667235),LocalDate.of(2019, 4, 12),  sistema.traerMedidor("Calle 2"), 324);
			sistema.agregarLecturaBaja(sistema.traerInspector(40667235),LocalDate.of(2019, 6, 12) , sistema.traerMedidor("Calle 2"), 410);
			sistema.agregarLecturaBaja(sistema.traerInspector(40667235),LocalDate.of(2019, 8, 12) , sistema.traerMedidor("Calle 2"), 601);
			
			//Lecturas Medidor 2
			sistema.agregarLecturaAlta(sistema.traerInspector(39666666), LocalDate.of(2019, 3, 18), sistema.traerMedidor("Calle 5"), 200, 106, 200);
			sistema.agregarLecturaAlta(sistema.traerInspector(39666666), LocalDate.of(2019, 5, 18), sistema.traerMedidor("Calle 5"), 420, 305, 310);
			sistema.agregarLecturaAlta(sistema.traerInspector(39666666), LocalDate.of(2019, 7, 18), sistema.traerMedidor("Calle 5"), 560, 400, 470);
			sistema.agregarLecturaAlta(sistema.traerInspector(39666666), LocalDate.of(2019, 9, 18), sistema.traerMedidor("Calle 5"), 720, 510, 610);

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		///Muestro Por Consola las Lecturas agregadas a la Lista de Lecturas
		System.out.println("\nLista de Lecturas: ");
		System.out.println(sistema.getListaLectura() );
		
		
		//Modifico Lecturas
		try {
			//Modifico la Lectura con idLectura=2
			sistema.modificarLecturaBaja(LocalDate.of(2019, 4, 12), 301);
			
			//Modifico la lectura con idLectura=5
			sistema.modificarLecturaAlta(LocalDate.of(2019, 3, 18), 300, 146, 247);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//Muestro por consola la lista con las lecturas con idLectura=2 y idLectura=5 modificadas
		System.out.println("\n\nLista De Lecturas despues de las Modificiaciones: ");
		System.out.println(sistema.getListaLectura());
	
		
		//Elimino las Lecturas con idLectura=1 e idLectura=8
		try {
			sistema.eliminarLectura(LocalDate.of(2019, 2, 12));
			sistema.eliminarLectura(LocalDate.of(2019, 9, 18));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//Muestro por consla la lista sin las lecturas que anteriormente elimine
		System.out.println("\n\nLista de Lecturas despues de las Eliminaciones: ");
		System.out.println(sistema.getListaLectura() );
		
		
		//Traigo la lectura con idLectura=3
		System.out.println("\n\nTraigo la Lectura Con idLectura=3");
		System.out.println(sistema.traerLectura(LocalDate.of(2019, 6, 12)));
		
		
		//Posibles Exepciones:
		System.out.println("\nPosibles Execpciones: ");
		
		System.out.println("\nTrato de Agregar una LecturaAlta que ya Existe: ");
		try {
			sistema.agregarLecturaAlta(sistema.traerInspector(39666666), LocalDate.of(2019, 5, 18), sistema.traerMedidor("Calle 5"), 420, 305, 310);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("\nTrato de Agregar una LecturaBaja que ya existe: ");
		try {
			sistema.agregarLecturaBaja(sistema.traerInspector(40667235),LocalDate.of(2019, 8, 12) , sistema.traerMedidor("Calle 2"), 601);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nTrato de Modificar una LecturaAlta que no existe: ");
		try {
			sistema.modificarLecturaAlta(LocalDate.of(2018, 3, 10), 100, 100, 100);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("\nTrato de Modificar una LecturaBaja que no existe: ");
		try {
			sistema.modificarLecturaBaja(LocalDate.of(2018, 2, 13), 100);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nTrato de Eliminar una Lectura que no Existe: ");
		try {
			sistema.eliminarLectura(LocalDate.of(2018, 5, 10));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
