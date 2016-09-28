package servicelayer.requests;

import dominio.Comisiones;

public class GuardarComisionRequest {
	private Comisiones comision;
	public GuardarComisionRequest(Comisiones comision) {
		this.comision = comision;
	}
	public Comisiones getComision() {
		return comision;
	}
	public void setComision(Comisiones comision) {
		this.comision = comision;
	}

}
