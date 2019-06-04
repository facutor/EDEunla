package test;

import modelo.Sistema;

public class EscenarioZona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();
		
		try {
			sistema.agregarInspector(40667235 , "Luis", "Rodriguez");
			sistema.agregarInspector(39666666, "Jorge", "Perez");
			
			/*********************************ALTA DE ZONAS*****************************/
			sistema.agregarzona( "Zona Sur", sistema.traerInspector(40667235) );
			sistema.agregarzona(" Zona Norte", sistema.traerInspector(39666666));
			
			System.out.println(sistema.traerZona(2)); //Muestro por consola datos de Zona 2 con traerZona
		
			/*************************************MODIFICACION DE ZONAS********************************/
			sistema.modificarZona( 2, "Zona Este",sistema.traerInspector(40667235) );//modifico todos los datos de zona con id2
			System.out.println( "\n\n"+sistema.traerZona(2) );
			
			/***********************************BAJA DE ZONAS*********************************/
			sistema.eliminarZona(2);
			System.out.println("\n\n"+sistema.traerZona(2));//la zona con id2 fue eliminada por ende el metodo traerZona devuelve null
			
			
		}catch(Exception e) {
			System.out.println( e.getMessage() );
		}


	}

}
