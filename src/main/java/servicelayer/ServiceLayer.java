package servicelayer;


import java.util.List;

import datalayer.*;
import dominio.*;
import servicelayer.requests.*;

public class ServiceLayer {
	// Guardar Datos //
	private DataLayer<Empleados> empleado_data;
	private DataLayer<Ventas> venta_data;
	private DataLayer<Productos> producto_data;
	
	private DataLayer<Comisiones> comision_data;
	private DataLayer<Premios> premio_data;
	
	public void guardarEmpleado(GuardarEmpleadoRequest req) throws Exception 
	{
		this.empleado_data.guardar(req.getEmpleado());
	}	
	public void guardarVenta(GuardarVentaRequest req) throws Exception 
	{
		this.venta_data.guardar(req.getVenta());
	}
	public void guardarProducto(GuardarProductoRequest req) throws Exception 
	{
		this.producto_data.guardar(req.getProducto());
	}
	public void guardarComision(GuardarComisionRequest req) throws Exception 
	{
		this.comision_data.guardar(req.getComision());
	}
	public void guardarPremios(GuardarPremioRequest req) throws Exception 
	{
		this.premio_data.guardar(req.getPremio());
	}
	
	
	// Reporte Premios Comisiones //
	private DataLayer<Float> total_empleado_reporte;
	public Float GenerarReporteComisionesYPremios (GenerarReporteComisionesYPremiosRequest req) throws Exception
	{
	//	this.total_empleado_reporte.obtenerReporte(req.getEmpleado(), req.getFecha_inicio(), req.getFecha_fin());
		
		Float total = this.total_empleado_reporte.obtenerReporte(req.getEmpleado(), req.getFecha_inicio(), req.getFecha_fin());
		return total;
	}

	// Consultar ventas Realizadas//
	private DataLayer<Ventas> consulta_ventas;
	public List <Ventas> ConsultarVentas (ConsultarVentasRequest req) throws Exception
	{
		List<Ventas> consulta = null;
		
		consulta = this.consulta_ventas.consultarVentas(req.getFecha_inicio(), req.getFecha_fin());
		
		return consulta;
	}
	
	// Actualizar montos //
	private DataLayer<Comisiones> actualizar_comision;
	private DataLayer<Premios> actualizar_premio;

	public boolean ActualizarComisiones (ActualizarComisionesRequest req) throws Exception
	{
		 boolean valido = false;
		 valido = this.actualizar_comision.actualizarComisiones(req.getComision());
		 return valido;		 
		
	}
	public boolean ActualizarPremios (ActualizarPremiosRequest req) throws Exception
	{
		 boolean valido = false;
		 valido = this.actualizar_premio.actualizarPremios(req.getPremio());
		 return valido;		 
		
	}
	
	
	public ServiceLayer() {
		this.empleado_data = new DataLayerImplementation<Empleados>(); 
		this.venta_data = new DataLayerImplementation<Ventas>(); 
		this.producto_data = new DataLayerImplementation<Productos>(); 
		this.comision_data = new DataLayerImplementation<Comisiones>(); 
		this.premio_data = new DataLayerImplementation<Premios>(); 
		
		this.total_empleado_reporte = new DataLayerImplementation<Float>(); 
		this.consulta_ventas = new DataLayerImplementation<Ventas>();
		
		this.actualizar_comision = new DataLayerImplementation<Comisiones>();
		this.actualizar_premio = new DataLayerImplementation<Premios>();
	}

}
