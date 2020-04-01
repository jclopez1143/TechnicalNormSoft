package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.HibernateDaoImpl;
import co.com.technicalnormsoft.model.Medalla;

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
 * Medalla entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Medalla
 */
@Scope("singleton")
@Repository("MedallaDAO")
public class MedallaDAO extends HibernateDaoImpl<Medalla, Integer>
    implements IMedallaDAO {
    private static final Logger log = LoggerFactory.getLogger(MedallaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IMedallaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IMedallaDAO) ctx.getBean("MedallaDAO");
    }
}
