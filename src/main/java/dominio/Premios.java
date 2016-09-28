package dominio;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Premios implements Serializable {
	@Id
	@GeneratedValue
	private Integer premioID;
	private String categoria; // Mejor vendedor del mes, Producto en particular
	private Date fecha;
	private String descripcion; // Null a determinar
	private float total;
	@ManyToOne
	private Empleados empleado;

	public Premios() {
		// TODO Auto-generated constructor stub
	}

	public Premios(String categoria, Date fecha, float total, String descripcion) {
		super();
		this.categoria = categoria;
		this.fecha = fecha;
		this.total = total;
		this.descripcion = descripcion;
	}
	
	
	public Premios(Integer premioID, String categoria, Date fecha, String descripcion,
			float total) {
		super();
		this.premioID = premioID;
		this.categoria = categoria;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "PremiosXEmpleados", joinColumns = @JoinColumn(name = "premioID"), inverseJoinColumns = @JoinColumn(name = "dni"))
	private List<Empleados> empleados;*/
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PremiosXEmpleados", joinColumns = @JoinColumn(name = "premioID"), inverseJoinColumns = @JoinColumn(name = "dni"))
	private List<Empleados> empleados;*/


	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getPremioID() {
		return premioID;
	}

	public void setPremioID(Integer premioID) {
		this.premioID = premioID;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
