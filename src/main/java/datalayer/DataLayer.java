package datalayer;

import java.sql.Date;
import java.util.List;

import dominio.Comisiones;
import dominio.Empleados;
import dominio.Premios;
import dominio.Ventas;

public interface DataLayer<T> {
	public void guardar(T t);
	public float obtenerReporte(Empleados empleado, Date fecha_inicio, Date fecha_fin);
	
	public List<Ventas> consultarVentas(Date fecha_inicio, Date fecha_fin);
	public boolean actualizarComisiones(Comisiones comision);
	public boolean actualizarPremios(Premios premio);


}
