package test;

import modelo.Sistema;
public class TestZona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarInspector(40667235 , "Luis", "Rodriguez");
			sistema.agregarInspector(39666666, "Jorge", "Perez");
			
			/*********************************ALTA DE ZONAS*****************************/
			sistema.agregarzona(1, "Zona Sur", sistema.traerInspector(40667235) );
			sistema.agregarzona(2, "Zona Norte", sistema.traerInspector(39666666));
			
			System.out.println("Antes de Realizar Altas Bajas y Modificacion de Zonas:");
			for (int i = 0; i < sistema.getListaZonas().size() ; i++) {
				System.out.println(sistema.getListaZonas().get(i));
				System.out.println("**************************************************************");
			}
			
			/*************************************MODIFICACION DE ZONAS********************************/
			sistema.modificarZona( 2, "Zona Este",sistema.traerInspector(40667235) );//modifico todos los datos de zona con id2
			
			/***********************************BAJA DE ZONAS*********************************/
			sistema.eliminarZona(2);
			/***************************************************************************************/
			System.out.println("\n\nDespues de realizar Altas,Bajas,Modificacion de Zonas:");
			for (int i = 0; i < sistema.getListaZonas().size() ; i++) {
				System.out.println(sistema.getListaZonas().get(i));
				System.out.println("***************************************************************");
			}
			
		}catch(Exception e) {
			System.out.println( e.getMessage() );
		}

		// Posibles excepciones
		try {
			// Agregar una zona que ya existe 
			sistema.agregarzona(1, "Zona Sur", sistema.traerInspector(40667235) );
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			//Mandar excepcion al eliminar una zona que no existe 
			sistema.eliminarZona(4);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		try {
			//Mandar excepcion al modificar una zona que no existe 
			sistema.modificarZona(4, "zona 2", sistema.traerInspector(40667235));;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		

	}

}
