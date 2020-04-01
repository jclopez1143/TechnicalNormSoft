package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.EstadoObjetivo;
import co.com.technicalnormsoft.model.dto.EstadoObjetivoDTO;

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
public interface IEstadoObjetivoLogic {
    public List<EstadoObjetivo> getEstadoObjetivo() throws Exception;

    /**
         * Save an new EstadoObjetivo entity
         */
    public void saveEstadoObjetivo(EstadoObjetivo entity)
        throws Exception;

    /**
         * Delete an existing EstadoObjetivo entity
         *
         */
    public void deleteEstadoObjetivo(EstadoObjetivo entity)
        throws Exception;

    /**
        * Update an existing EstadoObjetivo entity
        *
        */
    public void updateEstadoObjetivo(EstadoObjetivo entity)
        throws Exception;

    /**
         * Load an existing EstadoObjetivo entity
         *
         */
    public EstadoObjetivo getEstadoObjetivo(Integer idEstado)
        throws Exception;

    public List<EstadoObjetivo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EstadoObjetivo> findPageEstadoObjetivo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstadoObjetivo() throws Exception;

    public List<EstadoObjetivoDTO> getDataEstadoObjetivo()
        throws Exception;

    public void validateEstadoObjetivo(EstadoObjetivo estadoObjetivo)
        throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByEstablecimientoObjetivoId(Integer establecimientoObjetivoId)
    	throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(Integer idProyectoEstablecimiento,
    	Integer idObjtivo) throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByDescripcion(String descripcionEstado) throws Exception;
}
