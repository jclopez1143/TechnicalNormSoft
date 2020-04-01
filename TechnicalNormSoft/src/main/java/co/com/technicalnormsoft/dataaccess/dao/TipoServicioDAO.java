package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.TipoServicio;

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
 * TipoServicio entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TipoServicio
 */
@Scope("singleton")
@Repository("TipoServicioDAO")
public class TipoServicioDAO extends HibernateDaoImpl<TipoServicio, Integer>
    implements ITipoServicioDAO {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ITipoServicioDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITipoServicioDAO) ctx.getBean("TipoServicioDAO");
    }
    
    public TipoServicio findTipoServicioByEstablecimientoId(int idEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select ts from TipoServicio ts, Establecimiento e "
    			+ "where e.tipoServicio.idTipoServicio = ts.idTipoServicio "
    			+ "and e.idEstablecimiento = " + idEstablecimiento);
    	
    	return (TipoServicio) queryObject.uniqueResult();
    }
}
