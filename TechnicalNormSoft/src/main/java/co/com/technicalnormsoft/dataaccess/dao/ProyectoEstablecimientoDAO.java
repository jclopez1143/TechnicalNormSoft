package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.ProyectoEstablecimiento;

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
 * ProyectoEstablecimiento entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.ProyectoEstablecimiento
 */
@Scope("singleton")
@Repository("ProyectoEstablecimientoDAO")
public class ProyectoEstablecimientoDAO extends HibernateDaoImpl<ProyectoEstablecimiento, Integer>
    implements IProyectoEstablecimientoDAO {
    private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IProyectoEstablecimientoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IProyectoEstablecimientoDAO) ctx.getBean(
            "ProyectoEstablecimientoDAO");
    }
    
    public List<ProyectoEstablecimiento> findProyectoEstablecimientoListByEstablecimientoId(
    		Integer idEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select pe from ProyectoEstablecimiento pe "
    			+ "where pe.establecimiento.idEstablecimiento = " + idEstablecimiento);
    	
    	return (List<ProyectoEstablecimiento>) queryObject.getResultList();
    }
}
