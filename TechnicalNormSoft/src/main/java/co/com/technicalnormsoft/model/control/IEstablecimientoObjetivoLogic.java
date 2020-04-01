package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Silicon Cali
* 
*
*/
public interface IEstablecimientoObjetivoLogic {
    public List<EstablecimientoObjetivo> getEstablecimientoObjetivo()
        throws Exception;

    /**
         * Save an new EstablecimientoObjetivo entity
         */
    public void saveEstablecimientoObjetivo(EstablecimientoObjetivo entity)
        throws Exception;

    /**
         * Delete an existing EstablecimientoObjetivo entity
         *
         */
    public void deleteEstablecimientoObjetivo(EstablecimientoObjetivo entity)
        throws Exception;

    /**
        * Update an existing EstablecimientoObjetivo entity
        *
        */
    public void updateEstablecimientoObjetivo(EstablecimientoObjetivo entity)
        throws Exception;

    /**
         * Load an existing EstablecimientoObjetivo entity
         *
         */
    public EstablecimientoObjetivo getEstablecimientoObjetivo(
        Integer establecimientoObjetivoId) throws Exception;

    public List<EstablecimientoObjetivo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EstablecimientoObjetivo> findPageEstablecimientoObjetivo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEstablecimientoObjetivo()
        throws Exception;

    public List<EstablecimientoObjetivoDTO> getDataEstablecimientoObjetivo()
        throws Exception;

    public void validateEstablecimientoObjetivo(
        EstablecimientoObjetivo establecimientoObjetivo)
        throws Exception;
    
    public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(
        	Integer idProyectoEstablecimiento, Integer idObjetivo) throws Exception;
    
    public List<EstablecimientoObjetivo> getEstablecimientoObjetivosByProgramaId(
    		Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception;
    
    public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId
	(Integer idProyectoEstablecimiento) throws Exception;
    
    public void resetAllNewEstablecimientoObjetivoEstado(Integer idProyectoEstablecimiento)
    		throws Exception;
}
