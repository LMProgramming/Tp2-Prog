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
public class Comisiones implements Serializable {
	@Id
	@GeneratedValue
	private Integer comisionID;
	private String categoria; // Comision por ventas, Ventas de un producto
	private Date fecha;
	private String descripcion; // Id del producto en particular, null en caso del mejor vendedor

	public Comisiones(String categoria, Date fecha, float total, String descripcion) {
		super();

		this.categoria = categoria;
		this.fecha = fecha;
		this.total = total;
		this.descripcion = descripcion;
	}
	
	

	public Comisiones(Integer comisionID, String categoria, Date fecha, String descripcion, float total) {
		super();
		this.comisionID = comisionID;
		this.categoria = categoria;
		this.fecha = fecha;
		this.descripcion = descripcion;		
		this.total = total;
	}



	/*@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "ComisionesXEmpleados", joinColumns = @JoinColumn(name = "comisionID"), inverseJoinColumns = @JoinColumn(name = "dni"))
	private List<Empleados> empleados;*/
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ComisionesXEmpleados", joinColumns = @JoinColumn(name = "comisionID"), inverseJoinColumns = @JoinColumn(name = "dni"))
	private List<Empleados> empleados;
	
	public List<Empleados> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleados> empleados) {
		this.empleados = empleados;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	private float total;

	public Comisiones() {
		// TODO Auto-generated constructor stub
	}

	public Integer getComisionID() {
		return comisionID;
	}

	public void setComisionID(Integer comisionID) {
		this.comisionID = comisionID;
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
