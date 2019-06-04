package test;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

import modelo.Cliente;
import modelo.DetalleAlta;
import modelo.Factura;
import modelo.Inspector;
import modelo.ItemFactura;
import modelo.Lectura;
import modelo.Medidor;
import modelo.Sistema;
import modelo.Tarifa;
import modelo.TarifaAlta;
import modelo.Zona;

public class EscenarioTarifa {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		List<DetalleAlta> listDetalleAltas1 = new ArrayList<DetalleAlta>();
		DetalleAlta da1 = new DetalleAlta("Cargo Fijo", "", true, 1000);
		listDetalleAltas1.add(da1);
		
		List<DetalleAlta> listDetalleAltas2 = new ArrayList<DetalleAlta>();
		DetalleAlta da2 = new DetalleAlta("Cargo Fijo", "", true, 50000);
		listDetalleAltas2.add(da2);
		
		try {
			
			sistema.agregarTarifaAlta("Alta","AT", 100 , listDetalleAltas1 );
			
			sistema.agregarTarifaAlta("Baja", "BT", 1 , listDetalleAltas2 );
			
			System.out.println( sistema.traerTarifaAlta("Baja").getLimite() );

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
