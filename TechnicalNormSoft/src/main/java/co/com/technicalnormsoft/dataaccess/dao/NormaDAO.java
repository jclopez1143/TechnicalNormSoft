package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.Norma;

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
 * Norma entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Norma
 */
@Scope("singleton")
@Repository("NormaDAO")
public class NormaDAO extends HibernateDaoImpl<Norma, Integer>
    implements INormaDAO {
    private static final Logger log = LoggerFactory.getLogger(NormaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static INormaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (INormaDAO) ctx.getBean("NormaDAO");
    }
    
    public List<Norma> findNormasByTipoServicioId(int idTipoServicio) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select n from Norma n, TipoServicioNorma tsn "
    			+ "where tsn.tipoServicio.idTipoServicio = " + idTipoServicio
    			+ " and tsn.norma.idNorma = n.idNorma");
    	
    	return (List<Norma>) queryObject.getResultList();
    }
    
    public Norma findNormaByProyectoEstablecimientoId(int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select n from Norma n, ProyectoEstablecimiento pe "
    			+ "where pe.proyecto.norma.idNorma = n.idNorma "
    			+ "and pe.idProyectoEstablecimiento = " + idProyectoEstablecimiento);
    	
    	return (Norma) queryObject.uniqueResult();
    }
    
    public Norma findNormaByRequisitoId(int idRequisito) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select n from Norma n, Requisito r "
    			+ "where r.idRequisito = " + idRequisito
    			+ " and r.norma.idNorma = n.idNorma");
    	
    	return (Norma) queryObject.uniqueResult();
    }
}
