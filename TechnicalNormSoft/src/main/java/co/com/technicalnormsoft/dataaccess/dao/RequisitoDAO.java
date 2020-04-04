package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Requisito;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * Requisito entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Requisito
 */
@Scope("singleton")
@Repository("RequisitoDAO")
public class RequisitoDAO extends HibernateDaoImpl<Requisito, Integer>
    implements IRequisitoDAO {
    private static final Logger log = LoggerFactory.getLogger(RequisitoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IRequisitoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IRequisitoDAO) ctx.getBean("RequisitoDAO");
    }
    
    public Requisito findRequisitoByObjetivoId(int idObjetivo) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select r from Requisito r, Objetivo o "
    			+ "where o.requisito.idRequisito = r.idRequisito "
    			+ "and o.idObjetivo =" + idObjetivo);
    	
    	return (Requisito) queryObject.uniqueResult();
    }
    
    public Requisito findRequisitoByEstablecimientoObjetivoId(int establecimientoObjetivoId) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select r from Requisito r, EstablecimientoObjetivo eo "
    			+ "where eo.objetivo.requisito.idRequisito = r.idRequisito "
    			+ "and eo.establecimientoObjetivoId =" + establecimientoObjetivoId);
    	
    	return (Requisito) queryObject.uniqueResult();
    }
    
    public List<Requisito> findRequisitoByNormaId(int idNorma) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select r from Requisito r "
    			+ "where r.norma.idNorma = " + idNorma
    			+ " order by r.numeral");
    	
    	return (List<Requisito>) queryObject.getResultList();
    }
    
    
    //TODO change idEstablecimiento to idProyectoEstablecimiento
    public List<Requisito> findRequisitosByEstadoObjetivoDescripcion(String descripcionEstado, 
    		int idProyectoEstablecimiento) {
    	Query queryObject = sessionFactory.getCurrentSession().createQuery(
    			"select r from Requisito r, Objetivo o, EstablecimientoObjetivo eo "
    			+ "where o.requisito.idRequisito = r.idRequisito"
    			+ " and o.idObjetivo = eo.objetivo.idObjetivo"
    			+ " and eo.proyectoEstablecimiento.idProyectoEstablecimiento = " 
    			+ idProyectoEstablecimiento
    			+ " and eo.estadoObjetivo.descripcion = :descripcionEstado");
    	
    	queryObject.setParameter("descripcionEstado", descripcionEstado);
    	return (List<Requisito>) queryObject.getResultList();
    }
}
