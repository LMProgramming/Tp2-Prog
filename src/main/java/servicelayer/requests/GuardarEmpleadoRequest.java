package servicelayer.requests;

import dominio.Empleados;

public class GuardarEmpleadoRequest {
	private Empleados empleado;
	
	public GuardarEmpleadoRequest(Empleados empleado) {
	this.empleado = empleado;
	}
	public Empleados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	
	

}
