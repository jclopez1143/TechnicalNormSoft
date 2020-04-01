package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.DatoObjetivo;

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
 * CampoRegistro entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.CampoRegistro
 */
@Scope("singleton")
@Repository("CampoRegistroDAO")
public class CampoRegistroDAO extends HibernateDaoImpl<CampoRegistro, Integer>
    implements ICampoRegistroDAO {
    private static final Logger log = LoggerFactory.getLogger(CampoRegistroDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ICampoRegistroDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ICampoRegistroDAO) ctx.getBean("CampoRegistroDAO");
    }
    
    public List<CampoRegistro> findCampoRegistrosByDatoObjetivoId(int idDatoObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select cr from CampoRegistro cr "
    			+ "where cr.datoObjetivo.idDatoObjetivo = " + idDatoObjetivo
    			+ " order by cr.prioridad");
    	
    	return (List<CampoRegistro>) queryObject.getResultList();
    }
    
    public CampoRegistro findCampoRegistroByValorCampoId(int idValorCampo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select cr from CampoRegistro cr, ValorCampo vc "
    			+ "where vc.idValorCampo = " + idValorCampo
    			+ " and cr.idCampoRegistro = vc.campoRegistro.idCampoRegistro");
    	
    	return (CampoRegistro) queryObject.uniqueResult();
    }
    
}
