package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity
public class Empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Integer dni;
	private String nombre;
	private String apellido;
	private String categoria; // Vendedor, Recursos Humanos

	public Empleados(Integer dni, String nombre, String apellido, String categoria) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.categoria = categoria;
	}

	/*@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "EmpleadosXVentas", joinColumns = @JoinColumn(name = "dni"), inverseJoinColumns = @JoinColumn(name = "facturaID"))
	private List<Ventas> ventas;*/

	public Empleados() {
		// TODO Auto-generated constructor stub
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
