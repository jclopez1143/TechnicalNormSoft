package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;

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
public interface IEstablecimientoLogic {
    public List<Establecimiento> getEstablecimiento() throws Exception;

    /**
         * Save an new Establecimiento entity
         */
    public void saveEstablecimiento(Establecimiento entity)
        throws Exception;

    /**
         * Delete an existing Establecimiento entity
         *
         */
    public void deleteEstablecimiento(Establecimiento entity)
        throws Exception;

    /**
        * Update an existing Establecimiento entity
        *
        */
    public void updateEstablecimiento(Establecimiento entity)
        throws Exception;

    /**
         * Load an existing Establecimiento entity
         *
         */
    public Establecimiento getEstablecimiento(Integer idEstablecimiento)
        throws Exception;

    public List<Establecimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Establecimiento> findPageEstablecimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEstablecimiento() throws Exception;

    public List<EstablecimientoDTO> getDataEstablecimiento()
        throws Exception;

    public void validateEstablecimiento(Establecimiento establecimiento)
        throws Exception;
    
    public Establecimiento findEstablecimientoByEstablecimientoObjetivoId(Integer idEstablecimientoObjetivo)
         throws Exception;
    
    public Establecimiento findEstablecimientoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    	throws Exception;
}
