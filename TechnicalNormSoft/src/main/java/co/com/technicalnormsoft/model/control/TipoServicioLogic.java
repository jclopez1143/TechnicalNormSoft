package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.dataaccess.dao.*;
import co.com.technicalnormsoft.dto.mapper.ITipoServicioMapper;
import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
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


@Scope("singleton")
@Service("TipoServicioLogic")
public class TipoServicioLogic implements ITipoServicioLogic {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioLogic.class);

    /**
     * DAO injected by Spring that manages TipoServicio entities
     *
     */
    @Autowired
    private ITipoServicioDAO tipoServicioDAO;
    @Autowired
    private ITipoServicioMapper tipoServicioMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages Establecimiento entities
    *
    */
    @Autowired
    private IEstablecimientoDAO establecimientoDAO;

    /**
    * DAO injected by Spring that manages TipoServicioNorma entities
    *
    */
    @Autowired
    private ITipoServicioNormaDAO tipoServicioNormaDAO;

    public void validateTipoServicio(TipoServicio tipoServicio)
        throws Exception {
        try {
            Set<ConstraintViolation<TipoServicio>> constraintViolations = validator.validate(tipoServicio);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<TipoServicio> constraintViolation : constraintViolations) {
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
    public List<TipoServicio> getTipoServicio() throws Exception {
        log.debug("finding all TipoServicio instances");

        List<TipoServicio> list = new ArrayList<TipoServicio>();

        try {
            list = tipoServicioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all TipoServicio failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "TipoServicio");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTipoServicio(TipoServicio entity) throws Exception {
        log.debug("saving TipoServicio instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("TipoServicio");
            }

//            validateTipoServicio(entity);
//
//            if (getTipoServicio(entity.getIdTipoServicio()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

            tipoServicioDAO.save(entity);

            log.debug("save TipoServicio successful");
        } catch (Exception e) {
            log.error("save TipoServicio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTipoServicio(TipoServicio entity)
        throws Exception {
        log.debug("deleting TipoServicio instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("TipoServicio");
        }

        if (entity.getIdTipoServicio() == null) {
            throw new ZMessManager().new EmptyFieldException("idTipoServicio");
        }

        List<Establecimiento> establecimientos = null;
        List<TipoServicioNorma> tipoServicioNormas = null;

        try {
            establecimientos = establecimientoDAO.findByProperty("tipoServicio.idTipoServicio",
                    entity.getIdTipoServicio());

            if (Utilities.validationsList(establecimientos) == true) {
                throw new ZMessManager().new DeletingException(
                    "establecimientos");
            }

            tipoServicioNormas = tipoServicioNormaDAO.findByProperty("tipoServicio.idTipoServicio",
                    entity.getIdTipoServicio());

            if (Utilities.validationsList(tipoServicioNormas) == true) {
                throw new ZMessManager().new DeletingException(
                    "tipoServicioNormas");
            }

            tipoServicioDAO.delete(entity);

            log.debug("delete TipoServicio successful");
        } catch (Exception e) {
            log.error("delete TipoServicio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTipoServicio(TipoServicio entity)
        throws Exception {
        log.debug("updating TipoServicio instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("TipoServicio");
            }

            validateTipoServicio(entity);

            tipoServicioDAO.update(entity);

            log.debug("update TipoServicio successful");
        } catch (Exception e) {
            log.error("update TipoServicio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TipoServicioDTO> getDataTipoServicio()
        throws Exception {
        try {
            List<TipoServicio> tipoServicio = tipoServicioDAO.findAll();

            List<TipoServicioDTO> tipoServicioDTO = new ArrayList<TipoServicioDTO>();

            for (TipoServicio tipoServicioTmp : tipoServicio) {
                TipoServicioDTO tipoServicioDTO2 = tipoServicioMapper.tipoServicioToTipoServicioDTO(tipoServicioTmp);
                tipoServicioDTO.add(tipoServicioDTO2);
            }

            return tipoServicioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoServicio getTipoServicio(Integer idTipoServicio)
        throws Exception {
        log.debug("getting TipoServicio instance");

        TipoServicio entity = null;

        try {
            entity = tipoServicioDAO.findById(idTipoServicio);
        } catch (Exception e) {
            log.error("get TipoServicio failed", e);
            throw new ZMessManager().new FindingException("TipoServicio");
        } finally {
        }

        return entity;
    }
    
    @Transactional(readOnly = true)
    public TipoServicio findTipoServicioByEstablecimientoId(int idEstablecimiento) 
    	throws Exception {
    	 log.debug("getting TipoServicio instance");

         TipoServicio entity = null;

         try {
             entity = tipoServicioDAO.findTipoServicioByEstablecimientoId(idEstablecimiento);
         } catch (Exception e) {
             log.error("get TipoServicio failed", e);
             throw new ZMessManager().new FindingException("TipoServicio");
         } finally {
         }

         return entity;
    }

    @Transactional(readOnly = true)
    public List<TipoServicio> findPageTipoServicio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<TipoServicio> entity = null;

        try {
            entity = tipoServicioDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("TipoServicio Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTipoServicio() throws Exception {
        Long entity = null;

        try {
            entity = tipoServicioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("TipoServicio Count");
        } finally {
        }

        return entity;
    }
    
    @Transactional(readOnly = true)
    public TipoServicioDTO tipoServicioToTipoServicioDTO(TipoServicio tipoServicio) throws Exception {
    	return tipoServicioMapper.tipoServicioToTipoServicioDTO(tipoServicio);
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
    public List<TipoServicio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<TipoServicio> list = new ArrayList<TipoServicio>();
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
            list = tipoServicioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
