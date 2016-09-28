package servicelayer.requests;

import dominio.Productos;
import dominio.Ventas;

public class GuardarProductoRequest {

	public GuardarProductoRequest() {
		// TODO Auto-generated constructor stub
	}
	
	private Productos producto;

	public GuardarProductoRequest(Productos producto) {
		this.producto = producto;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}


}
