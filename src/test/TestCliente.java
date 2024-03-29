package test;

import modelo.Sistema;

public class TestCliente {

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
			sistema.agregarClienteFisico("Alta", "20401257257", "Rivera", "Tomas", sistema.traerZona(2));

			sistema.agregarClienteJuridico("Alta", "20458994561", "Rodriguez Hermanos S.A", sistema.traerZona(1));
			sistema.agregarClienteJuridico("Alta", "20456897411", "Belkys Luna y Asociados S.R.L", sistema.traerZona(2));
  
			//Mostramos Lista Clientes
			System.out.println("Lista de Cliente: \n");
			for (int i = 0; i < sistema.getListaClientes().size(); i++) {
				System.out.println(sistema.getListaClientes().get(i));
			}
			
			
			//Modificar Clientes
			sistema.modificarClienteFisico("20416677396", "Alta");
			sistema.modificarClienteJuridico("20458994561", "Baja");
			
			System.out.println("\nLista Modificada: \n");
			for (int i = 0; i < sistema.getListaClientes().size(); i++) {
				System.out.println(sistema.getListaClientes().get(i));
			}
			
			//Eliminar Cliente
			sistema.eliminarClienteFisico("20416677396");
			sistema.eliminarClienteJuridico("20456897411");		
			
			System.out.println("\nLista de Clientes despues de eliminar: \n");
			for (int i = 0; i < sistema.getListaClientes().size(); i++) {
				System.out.println(sistema.getListaClientes().get(i));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// Posibles Excepciones
		System.out.println("\nPosibles Excepciones: \n");
		try {
			//Mandar Excepcion al agregar un cliente Fisico que ya existe
			sistema.agregarClienteFisico("Alta", "20401257257", "Rivera", "Tomas", sistema.traerZona(2));
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			//Mandar Excepcion al agregar un Cliente Juridico qe ya existe
			sistema.agregarClienteJuridico("Alta", "20458994561", "Rodriguez Hermanos S.A", sistema.traerZona(1));
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		try {
			//Mandar excepcion al eliminar un cliente que no existe
			sistema.eliminarClienteFisico("hola");
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());		
		}
		
		try {
			//Mandar excepcion al modificar un cliente que no existe
			sistema.modificarClienteJuridico("sdasd","Baja");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			//Mandar excepcion al agregar un cliente con una demana incorrecta
			sistema.agregarClienteFisico("hola", "456879879", "Gomez", "Raul", sistema.traerZona(1));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
