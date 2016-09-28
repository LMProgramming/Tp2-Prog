package servicelayer.requests;

import dominio.Comisiones;

public class ActualizarComisionesRequest {

	private Comisiones comision;
	public ActualizarComisionesRequest(Comisiones comision) {
		this.comision = comision;
	}
	public Comisiones getComision() {
		return comision;
	}
	public void setComision(Comisiones comision) {
		this.comision = comision;
	}
}
