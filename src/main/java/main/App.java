package main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dominio.*;
import hibernate.HibernateUtil;
import servicelayer.*;
import servicelayer.requests.*;

public class App {
	public static void main(String[] args) throws Exception {		
		
		//altaEntidades();
	
		//reporteComisionesPremios();
		
		consultarVentas();
		
		//actualizarComisionesPremios();		
	}
	
	public static void altaEntidades() throws Exception{
		// Session //
		Session session = HibernateUtil.getSession();
		session.beginTransaction();		
		session.getTransaction().commit();
		ServiceLayer service = new ServiceLayer();
		 java.sql.Date today = new
		 java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		// Empleados //
		Empleados vendedor1 = new Empleados(66, "Enrique", "Dubert", "Vendedor");
		Empleados vendedor2 = new Empleados(77, "Damian", "Roman", "Vendedor");
		Empleados vendedor3 = new Empleados(88, "Jesica", "L'oreal", "Vendedor");
		
		List<Empleados> empleados = new ArrayList<Empleados>();
		empleados.add(vendedor1);
		empleados.add(vendedor2);
		empleados.add(vendedor3);
		
		GuardarEmpleadoRequest req_empleados_1 = new GuardarEmpleadoRequest(vendedor1);
		GuardarEmpleadoRequest req_empleados_2 = new GuardarEmpleadoRequest(vendedor2);
		GuardarEmpleadoRequest req_empleados_3 = new GuardarEmpleadoRequest(vendedor3);
		
		service.guardarEmpleado(req_empleados_1);
		service.guardarEmpleado(req_empleados_2);
		service.guardarEmpleado(req_empleados_3);

		
		// Comisiones //
		Comisiones comision1 = new Comisiones("Comision por ventas", today, 444.22f, null);		
		comision1.setEmpleados(empleados);
		Comisiones comision2 = new Comisiones("Ventas de un producto", today, 144.11f, null);
		comision2.setEmpleados(empleados);
		
		GuardarComisionRequest req_comisiones_1 = new GuardarComisionRequest(comision1);
		GuardarComisionRequest req_comisiones_2 = new GuardarComisionRequest(comision2);
		
		service.guardarComision(req_comisiones_1);
		service.guardarComision(req_comisiones_2);
		
		// Premios //
		Premios premio1 = new Premios("Mejor vendedor del mes", today, 555.33f, null);
		premio1.setEmpleado(vendedor1);
		Premios premio2 = new Premios("Producto en particular", today, 265.37f, "1");
		premio2.setEmpleado(vendedor2);
		
		GuardarPremioRequest req_premios_1 = new GuardarPremioRequest(premio1);
		GuardarPremioRequest req_premios_2 = new GuardarPremioRequest(premio2);
		
		service.guardarPremios(req_premios_1);
		service.guardarPremios(req_premios_2);
		
		// Productos //		
		Productos producto1 = new Productos("Papita", 22.66f);
		Productos producto2 = new Productos("Papita", 22.66f);
		Productos producto3 = new Productos("Papita", 22.66f);
		Productos producto4 = new Productos("Papita", 22.66f);
		Productos producto5 = new Productos("Papita", 22.66f);
		
		List<Productos> productos = new ArrayList<Productos>();		
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);
		productos.add(producto5);
		
		GuardarProductoRequest req_productos_1 = new GuardarProductoRequest(producto1);
		GuardarProductoRequest req_productos_2 = new GuardarProductoRequest(producto2);
		GuardarProductoRequest req_productos_3 = new GuardarProductoRequest(producto3);
		GuardarProductoRequest req_productos_4 = new GuardarProductoRequest(producto4);
		GuardarProductoRequest req_productos_5 = new GuardarProductoRequest(producto5);		

		service.guardarProducto(req_productos_1);
		service.guardarProducto(req_productos_2);
		service.guardarProducto(req_productos_3);
		service.guardarProducto(req_productos_4);
		service.guardarProducto(req_productos_5);
		
		// Ventas //
		Ventas venta1 = new Ventas(330.10f, today, vendedor1, null);
		Ventas venta2 = new Ventas(100.20f, today, vendedor2, null);
		Ventas venta3 = new Ventas(200.50f, today, vendedor3, null);	
		
		venta1.setProductos(productos);
		venta2.setProductos(productos);
		venta3.setProductos(productos);

		venta1.setEmpleado(vendedor1);	
		venta2.setEmpleado(vendedor2);
		venta3.setEmpleado(vendedor3);		

		GuardarVentaRequest req_ventas_1 = new GuardarVentaRequest(venta1);
		GuardarVentaRequest req_ventas_2 = new GuardarVentaRequest(venta2);
		GuardarVentaRequest req_ventas_3 = new GuardarVentaRequest(venta3);

		service.guardarVenta(req_ventas_1);		
		service.guardarVenta(req_ventas_2);	
		service.guardarVenta(req_ventas_3);		
	}
	
	public static void  reporteComisionesPremios() throws Exception{
		// Session //
		Session session = HibernateUtil.getSession();
		session.beginTransaction();		
		session.getTransaction().commit();
		ServiceLayer service = new ServiceLayer();
		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		java.sql.Date before = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		Empleados vendedor1 = new Empleados(66, "Enrique", "Dubert", "Vendedor");
		 
		GenerarReporteComisionesYPremiosRequest req_reporte = new
	    GenerarReporteComisionesYPremiosRequest(vendedor1, today , before);
		Float reporte = service.GenerarReporteComisionesYPremios(req_reporte);
		 
		System.out.println(reporte);
	}
	public static void  consultarVentas() throws Exception{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();		
		session.getTransaction().commit();
		ServiceLayer service = new ServiceLayer();
		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		java.sql.Date before = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	
		ConsultarVentasRequest req_consultar_ventas_1 = new ConsultarVentasRequest(today , before);
			
		List <Ventas> ventas_consulta = service.ConsultarVentas(req_consultar_ventas_1);
		for (Ventas unaventa: ventas_consulta){
			System.out.println("Precio de venta " + unaventa.getFacturaID() + " es: " + unaventa.getPrecio_total());
		}
		
	}
	
	public static void actualizarComisionesPremios() throws Exception{
		Session session = HibernateUtil.getSession();
		session.beginTransaction();		
		session.getTransaction().commit();
		ServiceLayer service = new ServiceLayer();
		java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());		
		java.sql.Date before = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	
		Comisiones comisionchange = new Comisiones(1,null,null, null, 9999.99f);
		Premios premiochange = new Premios (1,null,null,null,888.88f);
		
		ActualizarPremiosRequest req_actualizar_premio_1 = new ActualizarPremiosRequest(premiochange);
		ActualizarComisionesRequest req_actualizar_comision_1 = new ActualizarComisionesRequest(comisionchange);
	
		service.ActualizarPremios(req_actualizar_premio_1);
		service.ActualizarComisiones(req_actualizar_comision_1);		
	}
}
