package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.Objetivo;

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
 * Objetivo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 */
@Scope("singleton")
@Repository("ObjetivoDAO")
public class ObjetivoDAO extends HibernateDaoImpl<Objetivo, Integer>
    implements IObjetivoDAO {
    private static final Logger log = LoggerFactory.getLogger(ObjetivoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IObjetivoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IObjetivoDAO) ctx.getBean("ObjetivoDAO");
    }
    
    public Objetivo findObjetivoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o, EstablecimientoObjetivo eo "
    			+ "where eo.idEstablecimientoObjetivo = " + idEstablecimientoObjetivo
    			+ " and eo.objetivo.idObjetivo = o.idObjetivo");
		return (Objetivo) queryObject.uniqueResult();
    }
    
    public List<Objetivo> findObjetivosByEstadoDescripcion(String descripcionEstado, int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o, EstablecimientoObjetivo eo "
    			+ "where eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento
    			+ " and eo.objetivo.idObjetivo = o.idObjetivo"
    			+ " and eo.estadoObjetivo.descripcion = :descripcionEstado");
    	queryObject.setParameter("descripcionEstado", descripcionEstado);
		return (List<Objetivo>) queryObject.getResultList();
    }
    
    public List<Objetivo> findObjetivosByEstadoDescripcionProgramaId(String descripcionEstado, 
    		int idPrograma, int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o, EstablecimientoObjetivo eo "
    			+ "where eo.proyectoEstablecimiento.idProyectoEstablecimiento = " + idProyectoEstablecimiento
    			+ " and eo.objetivo.idObjetivo = o.idObjetivo"
    			+ " and o.programa.idPrograma = " + idPrograma
    			+ " and eo.estadoObjetivo.descripcion = :descripcionEstado");
    	queryObject.setParameter("descripcionEstado", descripcionEstado);
		return (List<Objetivo>) queryObject.getResultList();
    }
    
    public List<Objetivo> findObjetivosByProgramaId(int idPrograma) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o "
    			+ "where o.programa.idPrograma = " + idPrograma);
		return (List<Objetivo>) queryObject.getResultList();
    }
    
    public List<Objetivo> findObjetivosByProyectoEstablecimientoId(int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o, ProyectoEstablecimiento pe "
    			+ "where pe.idProyectoEstablecimiento = " + idProyectoEstablecimiento
    			+ " and pe.proyecto.idProyecto = o.programa.proyecto.idProyecto");
		return (List<Objetivo>) queryObject.getResultList();
    }
    
    public Objetivo findObjetivoByRequisitoId(int idRequisito) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select o from Objetivo o "
    			+ "where o.requisito.idRequisito = " + idRequisito);
		return (Objetivo) queryObject.uniqueResult();
    }
}
