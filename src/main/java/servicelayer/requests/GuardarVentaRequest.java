package servicelayer.requests;

import dominio.Ventas;

public class GuardarVentaRequest {

	public GuardarVentaRequest() {
		// TODO Auto-generated constructor stub
	}

	private Ventas venta;

	public GuardarVentaRequest(Ventas venta) {
		this.venta = venta;
	}
	public Ventas getVenta() {
		return venta;
	}
	public void setVenta(Ventas venta) {
		this.venta = venta;
	}
}
