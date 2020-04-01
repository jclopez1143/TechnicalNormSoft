package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;

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
public interface ICategoriaProgramaLogic {
    public List<CategoriaPrograma> getCategoriaPrograma()
        throws Exception;

    /**
         * Save an new CategoriaPrograma entity
         */
    public void saveCategoriaPrograma(CategoriaPrograma entity)
        throws Exception;

    /**
         * Delete an existing CategoriaPrograma entity
         *
         */
    public void deleteCategoriaPrograma(CategoriaPrograma entity)
        throws Exception;

    /**
        * Update an existing CategoriaPrograma entity
        *
        */
    public void updateCategoriaPrograma(CategoriaPrograma entity)
        throws Exception;

    /**
         * Load an existing CategoriaPrograma entity
         *
         */
    public CategoriaPrograma getCategoriaPrograma(Integer idCategoriaPrograma)
        throws Exception;

    public List<CategoriaPrograma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CategoriaPrograma> findPageCategoriaPrograma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCategoriaPrograma() throws Exception;

    public List<CategoriaProgramaDTO> getDataCategoriaPrograma()
        throws Exception;

    public void validateCategoriaPrograma(CategoriaPrograma categoriaPrograma)
        throws Exception;
    
    public CategoriaPrograma getCategoriaProgramaByProgramaId(Integer idPrograma)
        throws Exception;
}
