package test;

import java.util.ArrayList;
import java.util.List;

import modelo.DetalleAlta;
import modelo.DetalleBaja;
import modelo.Sistema;

public class TestMedidor {

	public static void main(String[] args) {
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
			
			sistema.agregarClienteFisico( "Alta", "20404578978", "Rodriguez","Tomas", sistema.traerZona(2));
			sistema.agregarClienteJuridico( "Alta", "21567898799", "Empresa 2", sistema.traerZona(1) );
			
			sistema.agregarClienteFisico( "Alta", "19787454541", "Rivera","Facundo", sistema.traerZona(2));
			sistema.agregarClienteJuridico( "Alta", "45646789888", "Empresa 3", sistema.traerZona(1) );
			
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
			
			sistema.agregarTarifaAlta("AltaTension", "AT" , 300, listaDetalleAltaTension);
			sistema.agregarTarifaAlta("MediaTension", "MT" , 300, listaDetalleMediaTension);
			sistema.agregarTarifaAlta("BajaTension", "BT" , 300, listaDetalleBajaTension);
			
			//******************************Agregar Medidores *******************************/
			sistema.agregarMedidor("Calle 2", sistema.traerClienteJuridico("20393453452"),sistema.traerTarifaBaja("Baja Demanda"));
			sistema.agregarMedidor("Calle 3", sistema.traerClienteFisico("20417677377"), sistema.traerTarifaBaja("Baja Demanda"));
			
			sistema.agregarMedidor("Calle 4", sistema.traerClienteFisico("20404578978"), sistema.traerTarifaAlta("AltaTension"));
			sistema.agregarMedidor("Calle 5", sistema.traerClienteJuridico("21567898799"), sistema.traerTarifaAlta("MediaTension"));
			sistema.agregarMedidor("Calle 6", sistema.traerClienteJuridico("45646789888"), sistema.traerTarifaAlta("BajaTension"));
			sistema.agregarMedidor("Calle 7", sistema.traerClienteFisico("19787454541"), sistema.traerTarifaAlta("BajaTension"));
			
			System.out.println(sistema.getListaMedidores());
			// Modifciar Medidores 
			
			sistema.modificarMedidor("Calle 3", sistema.traerClienteJuridico("21567898799"));
			
			System.out.println("\nLista modificada"+sistema.getListaMedidores());
			
			// Eliminar Medidor 
			sistema.eliminarMedidor("Calle 2");
			System.out.println("\nLista actualizada con el medidor eliminado"+sistema.getListaMedidores());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		// Excepciones 
		
		try {
			//Agregar  un medidor que ya existe 
			sistema.agregarMedidor("Calle 7", sistema.traerClienteFisico("19787454541"), sistema.traerTarifaAlta("BajaTension"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			//Eliminar  un medidor que no existe existe 
			sistema.eliminarMedidor(" Calle 9");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
