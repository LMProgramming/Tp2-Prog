package servicelayer.requests;

import java.sql.Date;

import dominio.Empleados;
import dominio.Ventas;

public class ConsultarVentasRequest {
	private Date fecha_inicio, fecha_fin;
	private Ventas venta;
	public ConsultarVentasRequest(Date fecha_inicio,
			Date fecha_fin) {
		
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Ventas getVenta() {
		return venta;
	}

	public void setVenta(Ventas venta) {
		this.venta = venta;
	}


}
