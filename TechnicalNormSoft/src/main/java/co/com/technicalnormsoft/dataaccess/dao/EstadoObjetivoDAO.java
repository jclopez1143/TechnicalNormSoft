package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.EstadoObjetivo;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * EstadoObjetivo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.EstadoObjetivo
 */
@Scope("singleton")
@Repository("EstadoObjetivoDAO")
public class EstadoObjetivoDAO extends HibernateDaoImpl<EstadoObjetivo, Integer>
implements IEstadoObjetivoDAO {
	private static final Logger log = LoggerFactory.getLogger(EstadoObjetivoDAO.class);
	@Resource
	private SessionFactory sessionFactory;

	public static IEstadoObjetivoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IEstadoObjetivoDAO) ctx.getBean("EstadoObjetivoDAO");
	}

	public EstadoObjetivo findEstadoObjetivoByEstablecimientoObjetivoId(int establecimientoObjetivoId) {
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				"select est from EstadoObjetivo est, EstablecimientoObjetivo eo "
						+ "where eo.establecimientoObjetivoId = " + establecimientoObjetivoId 
						+ " and est.idEstado = eo.estadoObjetivo.idEstado");

		return (EstadoObjetivo) queryObject.uniqueResult();
	}

	public EstadoObjetivo findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(int idProyectoEstablecimiento,
			int idObjtivo) {
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				"select est from EstadoObjetivo est, EstablecimientoObjetivo eo "
						+ "where eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento
						+ " and eo.objetivo.idObjetivo = " + idObjtivo
						+ " and eo.estadoObjetivo.idEstado = est.idEstado");

		return (EstadoObjetivo) queryObject.uniqueResult();

	}

	public EstadoObjetivo findEstadoObjetivoByDescripcion(String descripcionEstado) {
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
				"select est from EstadoObjetivo est "
						+ "where est.descripcion = :descripcionEstado");
		queryObject.setParameter("descripcionEstado", descripcionEstado);
		return (EstadoObjetivo) queryObject.uniqueResult();
	}
}
