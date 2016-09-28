package servicelayer.requests;

import dominio.Premios;

public class GuardarPremioRequest {
	private Premios premio;
	public GuardarPremioRequest(Premios premio) {
		this.premio = premio;
	}
	public Premios getPremio() {
		return premio;
	}
	public void setPremio(Premios premio) {
		this.premio = premio;
	}

	
}
