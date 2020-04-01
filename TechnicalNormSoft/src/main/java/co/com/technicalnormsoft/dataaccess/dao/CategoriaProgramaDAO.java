package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;

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
 * CategoriaPrograma entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.CategoriaPrograma
 */
@Scope("singleton")
@Repository("CategoriaProgramaDAO")
public class CategoriaProgramaDAO extends HibernateDaoImpl<CategoriaPrograma, Integer>
    implements ICategoriaProgramaDAO {
    private static final Logger log = LoggerFactory.getLogger(CategoriaProgramaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ICategoriaProgramaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ICategoriaProgramaDAO) ctx.getBean("CategoriaProgramaDAO");
    }
    
    public CategoriaPrograma findCategoriaProgramaByProgramaId(int idPrograma) {
		Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select cp from CategoriaPrograma cp, Programa p "
    			+ "where p.idPrograma = " + idPrograma 
    			+ " and cp.idCategoriaPrograma = p.categoriaPrograma.idCategoriaPrograma");
		
		return (CategoriaPrograma) queryObject.uniqueResult();
	}
}
