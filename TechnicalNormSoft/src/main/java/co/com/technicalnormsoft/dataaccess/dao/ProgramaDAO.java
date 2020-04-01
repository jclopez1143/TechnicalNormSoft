package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Programa;
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
 * Programa entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Programa
 */
@Scope("singleton")
@Repository("ProgramaDAO")
public class ProgramaDAO extends HibernateDaoImpl<Programa, Integer>
    implements IProgramaDAO {
    private static final Logger log = LoggerFactory.getLogger(ProgramaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IProgramaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProgramaDAO) ctx.getBean("ProgramaDAO");
    }
    
    public List<Programa> findProgramasByProyectoId(int idProyecto) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select p from Programa p, Proyecto pr "
    			+ "where p.proyecto.idProyecto = pr.idProyecto "
    			+ "and pr.idProyecto =" + idProyecto);
    	
    	return (List<Programa>) queryObject.getResultList();
    }
}
