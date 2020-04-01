package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.dto.NormaDTO;

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
public interface INormaLogic {
    public List<Norma> getNorma() throws Exception;

    /**
         * Save an new Norma entity
         */
    public void saveNorma(Norma entity) throws Exception;

    /**
         * Delete an existing Norma entity
         *
         */
    public void deleteNorma(Norma entity) throws Exception;

    /**
        * Update an existing Norma entity
        *
        */
    public void updateNorma(Norma entity) throws Exception;

    /**
         * Load an existing Norma entity
         *
         */
    public Norma getNorma(Integer idNorma) throws Exception;

    public List<Norma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Norma> findPageNorma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNorma() throws Exception;

    public List<NormaDTO> getDataNorma() throws Exception;

    public void validateNorma(Norma norma) throws Exception;
    
    public List<Norma> findNormasByTipoServicioId(Integer idTipoServicio) throws Exception;
    
    public Norma findNormaByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    	throws Exception;
    
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception;
    
    public Norma findNormaByRequisitoId(Integer idRequisito) throws Exception;
}
