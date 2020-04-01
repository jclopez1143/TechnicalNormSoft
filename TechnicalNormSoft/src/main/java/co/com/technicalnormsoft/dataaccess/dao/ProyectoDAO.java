package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.Proyecto;

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
 * Proyecto entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Proyecto
 */
@Scope("singleton")
@Repository("ProyectoDAO")
public class ProyectoDAO extends HibernateDaoImpl<Proyecto, Integer>
    implements IProyectoDAO {
    private static final Logger log = LoggerFactory.getLogger(ProyectoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IProyectoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProyectoDAO) ctx.getBean("ProyectoDAO");
    }
    
    public Proyecto findProyectoByProyectoEstablecimientoId(int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select p from Proyecto p, ProyectoEstablecimiento pe "
    			+ "where p.idProyecto = pe.proyecto.idProyecto "
    			+ "and pe.idProyectoEstablecimiento = " + idProyectoEstablecimiento);
		
		return (Proyecto) queryObject.uniqueResult();
    }
    
    public Proyecto findProyectoByNormaId(int idNorma) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select p from Proyecto p "
    			+ "where p.norma.idNorma = " + idNorma);
		
		return (Proyecto) queryObject.uniqueResult();
    }
}
