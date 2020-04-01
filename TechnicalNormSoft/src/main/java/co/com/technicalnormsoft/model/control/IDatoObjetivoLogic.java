package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IDatoObjetivoLogic {
    public List<DatoObjetivo> getDatoObjetivo() throws Exception;

    /**
         * Save an new DatoObjetivo entity
         */
    public void saveDatoObjetivo(DatoObjetivo entity) throws Exception;

    /**
         * Delete an existing DatoObjetivo entity
         *
         */
    public void deleteDatoObjetivo(DatoObjetivo entity)
        throws Exception;

    /**
        * Update an existing DatoObjetivo entity
        *
        */
    public void updateDatoObjetivo(DatoObjetivo entity)
        throws Exception;

    /**
         * Load an existing DatoObjetivo entity
         *
         */
    public DatoObjetivo getDatoObjetivo(Integer idDatoObjetivo)
        throws Exception;

    public List<DatoObjetivo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatoObjetivo> findPageDatoObjetivo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDatoObjetivo() throws Exception;

    public List<DatoObjetivoDTO> getDataDatoObjetivo()
        throws Exception;

    public void validateDatoObjetivo(DatoObjetivo datoObjetivo)
        throws Exception;
    
    public List<DatoObjetivo> findDatoObjetivosByObjetivoId(Integer idObjetivo)
            throws Exception;
    
    public List<DatoObjetivoDTO> listDatoObjetivoToListDatoObjetivoDTO( List<DatoObjetivo> datoObjetivos)
            throws Exception;
    
    public DatoObjetivoDTO datoObjetivoToDatoObjetivoDTO(DatoObjetivo datoObjetivo)
    		throws Exception;
    
    public DatoObjetivo findDatoObjetivoAutoevaluacion(Integer idObjetivo) throws Exception;
}
