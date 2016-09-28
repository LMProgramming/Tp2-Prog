package servicelayer.requests;

import dominio.Premios;

public class ActualizarPremiosRequest {
	private Premios premio;
	public ActualizarPremiosRequest(Premios premio) {
		this.premio = premio;
	}
	public Premios getPremio() {
		return premio;
	}
	public void setPremio(Premios premio) {
		this.premio = premio;
	}


}
