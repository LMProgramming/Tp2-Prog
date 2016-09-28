package dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Ventas implements Serializable {
	@Id
	@GeneratedValue
	private Integer facturaID;
	private float precio_total;
	private Date fecha;	
	@ManyToOne
	private Empleados empleado;

	public Ventas() {
		// TODO Auto-generated constructor stub
	}

	public Ventas(float precio_total, Date fecha, Empleados empleado, List<Productos> productos) {
		super();

		this.precio_total = precio_total;
		this.fecha = fecha;
		this.empleado = empleado;
		this.productos = productos;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "VentasXProductos", joinColumns = @JoinColumn(name = "facturaID"), inverseJoinColumns = @JoinColumn(name = "productoID"))
	private List<Productos> productos;

	
	public Integer getFacturaID() {
		return facturaID;
	}

	public void setFacturaID(Integer facturaID) {
		this.facturaID = facturaID;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

}
