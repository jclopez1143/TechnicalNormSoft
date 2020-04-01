package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;

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
 * Establecimiento entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Establecimiento
 */
@Scope("singleton")
@Repository("EstablecimientoDAO")
public class EstablecimientoDAO extends HibernateDaoImpl<Establecimiento, Integer>
    implements IEstablecimientoDAO {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IEstablecimientoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEstablecimientoDAO) ctx.getBean("EstablecimientoDAO");
    }
    
    public Establecimiento findEstablecimientoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select e from Establecimiento e, EstablecimientoObjetivo eo "
    			+ "where eo.idEstablecimientoObjetivo = " + idEstablecimientoObjetivo
    			+ " and eo.establecimiento.idEstablecimiento = e.idEstablecimiento");
		return (Establecimiento) queryObject.uniqueResult();
    }
    
    public Establecimiento findEstablecimientoByProyectoEstablecimientoId(int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select e from Establecimiento e, ProyectoEstablecimiento pe "
    			+ "where pe.idProyectoEstablecimiento = " + idProyectoEstablecimiento
    			+ " and pe.establecimiento.idEstablecimiento = e.idEstablecimiento");
		return (Establecimiento) queryObject.uniqueResult();
    }
}
