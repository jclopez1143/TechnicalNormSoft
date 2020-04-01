package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Proyecto;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;

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
public interface IProyectoLogic {
    public List<Proyecto> getProyecto() throws Exception;

    /**
         * Save an new Proyecto entity
         */
    public void saveProyecto(Proyecto entity) throws Exception;

    /**
         * Delete an existing Proyecto entity
         *
         */
    public void deleteProyecto(Proyecto entity) throws Exception;

    /**
        * Update an existing Proyecto entity
        *
        */
    public void updateProyecto(Proyecto entity) throws Exception;

    /**
         * Load an existing Proyecto entity
         *
         */
    public Proyecto getProyecto(Integer idProyecto) throws Exception;

    public List<Proyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proyecto> findPageProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProyecto() throws Exception;

    public List<ProyectoDTO> getDataProyecto() throws Exception;

    public void validateProyecto(Proyecto proyecto) throws Exception;
    
    public Proyecto findProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    	throws Exception;
    
    public Proyecto findProyectoByNormaId(Integer idNorma) throws Exception;
}
