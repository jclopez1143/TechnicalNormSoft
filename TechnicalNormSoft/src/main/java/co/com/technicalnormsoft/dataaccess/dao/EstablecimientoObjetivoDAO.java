package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.Objetivo;
import co.com.technicalnormsoft.model.Programa;

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
 * EstablecimientoObjetivo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.EstablecimientoObjetivo
 */
@Scope("singleton")
@Repository("EstablecimientoObjetivoDAO")
public class EstablecimientoObjetivoDAO extends HibernateDaoImpl<EstablecimientoObjetivo, Integer>
    implements IEstablecimientoObjetivoDAO {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoObjetivoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IEstablecimientoObjetivoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEstablecimientoObjetivoDAO) ctx.getBean(
            "EstablecimientoObjetivoDAO");
    }
	
	public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(int idProyectoEstablecimiento, int idObjetivo) {
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select eo from EstablecimientoObjetivo eo "
    			+ "where eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento
    			+ " and eo.objetivo.idObjetivo = " + idObjetivo);
		return (EstablecimientoObjetivo) queryObject.uniqueResult();
	}
    
    public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProgramaId(int idPrograma, int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select eo from EstablecimientoObjetivo eo, Objetivo o "
    			+ "where o.programa.idPrograma = " + idPrograma
    			+ " and eo.objetivo.idObjetivo = o.idObjetivo "
    			+ "and eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento);
    	
    	return (List<EstablecimientoObjetivo>) queryObject.getResultList();
    }
    
    public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId(int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select eo from EstablecimientoObjetivo eo"
    			+ "where eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento);
    	
    	return (List<EstablecimientoObjetivo>) queryObject.getResultList();
    }
}
