package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.dataaccess.dao.*;
import co.com.technicalnormsoft.dto.mapper.INormaMapper;
import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Silicon Cali
* 
*
*/
@Scope("singleton")
@Service("NormaLogic")
public class NormaLogic implements INormaLogic {
    private static final Logger log = LoggerFactory.getLogger(NormaLogic.class);

    /**
     * DAO injected by Spring that manages Norma entities
     *
     */
    @Autowired
    private INormaDAO normaDAO;
    @Autowired
    private INormaMapper normaMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages Proyecto entities
    *
    */
    @Autowired
    private IProyectoDAO proyectoDAO;

    /**
    * DAO injected by Spring that manages Requisito entities
    *
    */
    @Autowired
    private IRequisitoDAO requisitoDAO;

    /**
    * DAO injected by Spring that manages TipoServicioNorma entities
    *
    */
    @Autowired
    private ITipoServicioNormaDAO tipoServicioNormaDAO;

    public void validateNorma(Norma norma) throws Exception {
        try {
            Set<ConstraintViolation<Norma>> constraintViolations = validator.validate(norma);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Norma> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Norma> getNorma() throws Exception {
        log.debug("finding all Norma instances");

        List<Norma> list = new ArrayList<Norma>();

        try {
            list = normaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Norma failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Norma");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveNorma(Norma entity) throws Exception {
        log.debug("saving Norma instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Norma");
            }

            validateNorma(entity);

            if (getNorma(entity.getIdNorma()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            normaDAO.save(entity);

            log.debug("save Norma successful");
        } catch (Exception e) {
            log.error("save Norma failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteNorma(Norma entity) throws Exception {
        log.debug("deleting Norma instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Norma");
        }

        if (entity.getIdNorma() == null) {
            throw new ZMessManager().new EmptyFieldException("idNorma");
        }

        List<Proyecto> proyectos = null;
        List<Requisito> requisitos = null;
        List<TipoServicioNorma> tipoServicioNormas = null;

        try {
            proyectos = proyectoDAO.findByProperty("norma.idNorma",
                    entity.getIdNorma());

            if (Utilities.validationsList(proyectos) == true) {
                throw new ZMessManager().new DeletingException("proyectos");
            }

            requisitos = requisitoDAO.findByProperty("norma.idNorma",
                    entity.getIdNorma());

            if (Utilities.validationsList(requisitos) == true) {
                throw new ZMessManager().new DeletingException("requisitos");
            }

            tipoServicioNormas = tipoServicioNormaDAO.findByProperty("norma.idNorma",
                    entity.getIdNorma());

            if (Utilities.validationsList(tipoServicioNormas) == true) {
                throw new ZMessManager().new DeletingException(
                    "tipoServicioNormas");
            }

            normaDAO.delete(entity);

            log.debug("delete Norma successful");
        } catch (Exception e) {
            log.error("delete Norma failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateNorma(Norma entity) throws Exception {
        log.debug("updating Norma instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Norma");
            }

            validateNorma(entity);

            normaDAO.update(entity);

            log.debug("update Norma successful");
        } catch (Exception e) {
            log.error("update Norma failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<NormaDTO> getDataNorma() throws Exception {
        try {
            List<Norma> norma = normaDAO.findAll();

            List<NormaDTO> normaDTO = new ArrayList<NormaDTO>();

            for (Norma normaTmp : norma) {
                NormaDTO normaDTO2 = normaMapper.normaToNormaDTO(normaTmp);
                normaDTO.add(normaDTO2);
            }

            return normaDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<Norma> findNormasByTipoServicioId(Integer idTipoServicio) throws Exception {
        log.debug("finding all Norma instances");

        List<Norma> list = new ArrayList<Norma>();

        try {
            list = normaDAO.findNormasByTipoServicioId(idTipoServicio);
        } catch (Exception e) {
            log.error("finding all Norma failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Norma");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = true)
    public Norma getNorma(Integer idNorma) throws Exception {
        log.debug("getting Norma instance");

        Norma entity = null;

        try {
            entity = normaDAO.findById(idNorma);
        } catch (Exception e) {
            log.error("get Norma failed", e);
            throw new ZMessManager().new FindingException("Norma");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Norma> findPageNorma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Norma> entity = null;

        try {
            entity = normaDAO.findPage(sortColumnName, sortAscending, startRow,
                    maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Norma Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberNorma() throws Exception {
        Long entity = null;

        try {
            entity = normaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Norma Count");
        } finally {
        }

        return entity;
    }
    
    @Transactional(readOnly = true)
    public Norma findNormaByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception {
        log.debug("getting Norma instance");

        Norma entity = null;
        
        try {
            entity = normaDAO.findNormaByProyectoEstablecimientoId(idProyectoEstablecimiento);
        } catch (Exception e) {
            log.error("get Norma failed", e);
            throw new ZMessManager().new FindingException("Norma");
        } finally {
        }

        return entity;
    }
    
    @Transactional(readOnly = true)
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception {
        NormaDTO entity = null;
        
        try {
            entity = normaMapper.normaToNormaDTO(norma);
        } catch (Exception e) {
            throw e;
        }
        return entity;
    }
    
    @Transactional(readOnly = true)
    public Norma findNormaByRequisitoId(Integer idRequisito) throws Exception {
        log.debug("getting Norma instance");

        Norma entity = null;
        
        try {
            entity = normaDAO.findNormaByRequisitoId(idRequisito);
        } catch (Exception e) {
            log.error("get Norma failed", e);
            throw new ZMessManager().new FindingException("Norma");
        } finally {
        }

        return entity;
    }
    

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Norma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Norma> list = new ArrayList<Norma>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = normaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
