package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.ValorDato;

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
 * ValorDato entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.ValorDato
 */
@Scope("singleton")
@Repository("ValorDatoDAO")
public class ValorDatoDAO extends HibernateDaoImpl<ValorDato, Integer>
    implements IValorDatoDAO {
    private static final Logger log = LoggerFactory.getLogger(ValorDatoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IValorDatoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IValorDatoDAO) ctx.getBean("ValorDatoDAO");
    }
    
    public List<ValorDato> findValorDatosByIds(int establecimientoObjetivoId,
    		int idDatoObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select vd from ValorDato vd "
    			+ "where vd.establecimientoObjetivo.establecimientoObjetivoId = " + establecimientoObjetivoId
    			+ " and vd.datoObjetivo.idDatoObjetivo = " + idDatoObjetivo);
    	
    	return (List<ValorDato>) queryObject.getResultList();
    }
    
    public ValorDato findValorDatoAutoevaluacionByEstablecimientoObjetivoId(int establecimientoObjetivoId) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select vd from ValorDato vd, DatoObjetivo do "
    			+ "where vd.establecimientoObjetivo.establecimientoObjetivoId = " + establecimientoObjetivoId
    			+ " and vd.datoObjetivo.idDatoObjetivo = do.idDatoObjetivo"
    			+ " and do.tipo = 'autoevaluacion'");
    	
    	return (ValorDato) queryObject.uniqueResult();
    }
}
