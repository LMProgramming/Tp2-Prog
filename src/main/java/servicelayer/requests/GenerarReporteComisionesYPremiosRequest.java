package servicelayer.requests;

import java.sql.Date;

import dominio.Empleados;

public class GenerarReporteComisionesYPremiosRequest {
	private Empleados empleado;
	private Date fecha_inicio, fecha_fin;
	public GenerarReporteComisionesYPremiosRequest(Empleados empleado, Date fecha_inicio,
			Date fecha_fin) {
		this.empleado = empleado;
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

	public Empleados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
}
