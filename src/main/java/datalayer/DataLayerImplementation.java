package datalayer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import datalayer.*;
import dominio.*;
import hibernate.HibernateUtil;

public class DataLayerImplementation<T> implements DataLayer<T> {
	private static SessionFactory factory;
	public DataLayerImplementation() {
		// TODO Auto-generated constructor stub
	}

	public void guardar(T t) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public List<Ventas> consultarVentas(Date fecha_inicio, Date fecha_fin) {
		List<Ventas> ventas = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			String hql = "from Ventas where fecha >= :fecha_inicio and fecha <= :fecha_fin";

			Query query = session.createQuery(hql);

			query.setParameter("fecha_inicio", fecha_inicio);

			query.setParameter("fecha_fin", fecha_fin);

			List<Ventas> ventasquery = query.list();

			/*for (Ventas unaventa : ventasquery) {
				System.out.println(unaventa.getPrecio_total());
			}*/
			ventas = ventasquery;

		} catch (HibernateException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return ventas;
	}
	
	// TODO: Filtrar por fecha // 
	@SuppressWarnings("unchecked")
	public float obtenerReporte(Empleados empleado, Date fecha_inicio, Date fecha_fin) {

		float total = 0;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			List<Integer> empleadosxcomisiones = session.createSQLQuery(
					"SELECT comisionID FROM comisionesxempleados Where dni = " + empleado.getDni())
					.list();
			List<Float> empleadosxpremios = session
					.createSQLQuery(
							"SELECT total FROM premios Where empleado_dni = " + empleado.getDni())
					.list();
			
			List comisiones = session.createQuery("from Comisiones").list();
			List premios = session.createQuery("FROM Premios Where empleado_dni =" + empleado.getDni()).list();
			
			for (int i = 0; i < empleadosxcomisiones.size(); i++) {

				for (int j = 0; j < comisiones.size(); j++) {
					Comisiones comision = (Comisiones) comisiones.get(j);

					if (empleadosxcomisiones.get(i) == comision.getComisionID()) {
						// if (comision.getFecha().after(fecha_inicio) &&
						// comision.getFecha().before(fecha_fin)){
						total += comision.getTotal();
						// }
					}

				}

			}

			for (int i = 0; i < premios.size(); i++) {
				// if (comision.getFecha().after(fecha_inicio) &&
				// comision.getFecha().before(fecha_fin)){				
				Premios premio = (Premios) premios.get(i);
				total += premio.getTotal();				
				// }
			}
			

		} catch (HibernateException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return total;
	}

	public boolean actualizarComisiones(Comisiones comision) {
		boolean valido = false;

		Transaction tx = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			String hql = "update Comisiones set total = :total where comisionID = :comisionID";
			Query query = session.createQuery(hql);

			query.setParameter("total", comision.getTotal());
			query.setParameter("comisionID", comision.getComisionID());

			int rowsAffected = query.executeUpdate();
			tx = session.beginTransaction();
			tx.commit();
			if (rowsAffected > 0) {
				System.out.println("Updated " + rowsAffected + " rows.");
				valido = true;
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return valido;
	}

	public boolean actualizarPremios(Premios premio) {
		boolean valido = false;

		Transaction tx = null;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			String hql = "update Premios set total = :total where premioID = :premioID";
			Query query = session.createQuery(hql);

			query.setParameter("total", premio.getTotal());
			query.setParameter("premioID", premio.getPremioID());

			int rowsAffected = query.executeUpdate();
			tx = session.beginTransaction();
			tx.commit();
			if (rowsAffected > 0) {
				System.out.println("Updated " + rowsAffected + " rows.");
				valido = true;
			}
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return valido;
	}
}
