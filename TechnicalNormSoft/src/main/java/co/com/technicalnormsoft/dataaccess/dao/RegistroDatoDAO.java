package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.RegistroDato;

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
 * RegistroDato entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RegistroDato
 */
@Scope("singleton")
@Repository("RegistroDatoDAO")
public class RegistroDatoDAO extends HibernateDaoImpl<RegistroDato, Integer>
    implements IRegistroDatoDAO {
    private static final Logger log = LoggerFactory.getLogger(RegistroDatoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IRegistroDatoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IRegistroDatoDAO) ctx.getBean("RegistroDatoDAO");
    }
    
    public List<RegistroDato> findRegistroDatosByIds(int establecimientoObjetivoId,
    		int idDatoObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select rd from RegistroDato rd "
    			+ "where rd.establecimientoObjetivo.establecimientoObjetivoId = " + establecimientoObjetivoId
    			+ " and rd.datoObjetivo.idDatoObjetivo = " + idDatoObjetivo);
    	
    	return (List<RegistroDato>) queryObject.getResultList();
    }
}
