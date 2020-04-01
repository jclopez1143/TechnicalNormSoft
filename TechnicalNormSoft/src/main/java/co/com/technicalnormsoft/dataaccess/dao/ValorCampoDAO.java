package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.ValorCampo;

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
 * ValorCampo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.ValorCampo
 */
@Scope("singleton")
@Repository("ValorCampoDAO")
public class ValorCampoDAO extends HibernateDaoImpl<ValorCampo, Integer>
    implements IValorCampoDAO {
    private static final Logger log = LoggerFactory.getLogger(ValorCampoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IValorCampoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IValorCampoDAO) ctx.getBean("ValorCampoDAO");
    }
    
    public List<ValorCampo> findValorCamposByRegistroDatoId(int idRegistroDato) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select vc from ValorCampo vc "
    			+ "where vc.registroDato.idRegistroDato = " + idRegistroDato);
    	
    	return (List<ValorCampo>) queryObject.getResultList();
    }
}
