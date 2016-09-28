package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Productos implements Serializable {
	@Id
	@GeneratedValue
	Integer productoID;
	String nombre;
	Float precio;

	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(String nombre, Float precio) {
		super();
		
		this.nombre = nombre;
		this.precio = precio;
	}
	
	

	public Integer getProductoID() {
		return productoID;
	}

	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

}
