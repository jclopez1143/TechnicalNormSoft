package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.ProyectoEstablecimiento;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;

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
public interface IProyectoEstablecimientoLogic {
    public List<ProyectoEstablecimiento> getProyectoEstablecimiento()
        throws Exception;

    /**
         * Save an new ProyectoEstablecimiento entity
         */
    public void saveProyectoEstablecimiento(ProyectoEstablecimiento entity)
        throws Exception;

    /**
         * Delete an existing ProyectoEstablecimiento entity
         *
         */
    public void deleteProyectoEstablecimiento(ProyectoEstablecimiento entity)
        throws Exception;

    /**
        * Update an existing ProyectoEstablecimiento entity
        *
        */
    public void updateProyectoEstablecimiento(ProyectoEstablecimiento entity)
        throws Exception;

    /**
         * Load an existing ProyectoEstablecimiento entity
         *
         */
    public ProyectoEstablecimiento getProyectoEstablecimiento(
        Integer idProyectoEstablecimiento) throws Exception;

    public List<ProyectoEstablecimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ProyectoEstablecimiento> findPageProyectoEstablecimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProyectoEstablecimiento()
        throws Exception;

    public List<ProyectoEstablecimientoDTO> getDataProyectoEstablecimiento()
        throws Exception;

    public void validateProyectoEstablecimiento(
        ProyectoEstablecimiento proyectoEstablecimiento)
        throws Exception;
    
    public List<ProyectoEstablecimiento> getProyectoEstablecimientoByEstablecimientoId(
    		Integer idEstablecimiento) throws Exception;
    
    public Double getProyectoEstablecimeintoProgress(Integer idProyectoEstablecimiento)
    	throws Exception;
    
    public List<ProyectoEstablecimientoDTO> getProyectoEstablecimientoDTOByEstablecimientoId(
    	Integer idEstablecimiento) throws Exception;
    
    public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
    		ProyectoEstablecimiento proyectoEstablecimiento) throws Exception;
    
    public boolean isOtherSameProyectoInExecution(Integer idEstablecimiento, Integer idNorma) 
    		throws Exception;
    
    public boolean isProyectoStateFinished(Integer idProyectoEstablecimiento) throws Exception;
    
    public void finishProyectoEstado (Integer idProyectoEstablecimiento) throws Exception;
    
    public void rollBackFinishProyectoEstado (Integer idProyectoEstablecimiento) throws Exception;
}
