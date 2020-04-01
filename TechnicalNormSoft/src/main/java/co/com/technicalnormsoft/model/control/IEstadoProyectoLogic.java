package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.dto.EstadoProyectoDTO;

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
public interface IEstadoProyectoLogic {
    public List<EstadoProyecto> getEstadoProyecto() throws Exception;

    /**
         * Save an new EstadoProyecto entity
         */
    public void saveEstadoProyecto(EstadoProyecto entity)
        throws Exception;

    /**
         * Delete an existing EstadoProyecto entity
         *
         */
    public void deleteEstadoProyecto(EstadoProyecto entity)
        throws Exception;

    /**
        * Update an existing EstadoProyecto entity
        *
        */
    public void updateEstadoProyecto(EstadoProyecto entity)
        throws Exception;

    /**
         * Load an existing EstadoProyecto entity
         *
         */
    public EstadoProyecto getEstadoProyecto(Integer idEstadoProyecto)
        throws Exception;

    public List<EstadoProyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EstadoProyecto> findPageEstadoProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEstadoProyecto() throws Exception;

    public List<EstadoProyectoDTO> getDataEstadoProyecto()
        throws Exception;

    public void validateEstadoProyecto(EstadoProyecto estadoProyecto)
        throws Exception;
    
    public EstadoProyecto findEstadoProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    	throws Exception;
    
    public EstadoProyecto findEstadoProyectoByDescripcion(String descripcionEstado)
    		throws Exception;
}
