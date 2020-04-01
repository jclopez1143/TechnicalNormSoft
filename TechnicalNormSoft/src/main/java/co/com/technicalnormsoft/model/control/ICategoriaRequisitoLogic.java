package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.CategoriaRequisito;
import co.com.technicalnormsoft.model.dto.CategoriaRequisitoDTO;

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
public interface ICategoriaRequisitoLogic {
    public List<CategoriaRequisito> getCategoriaRequisito()
        throws Exception;

    /**
         * Save an new CategoriaRequisito entity
         */
    public void saveCategoriaRequisito(CategoriaRequisito entity)
        throws Exception;

    /**
         * Delete an existing CategoriaRequisito entity
         *
         */
    public void deleteCategoriaRequisito(CategoriaRequisito entity)
        throws Exception;

    /**
        * Update an existing CategoriaRequisito entity
        *
        */
    public void updateCategoriaRequisito(CategoriaRequisito entity)
        throws Exception;

    /**
         * Load an existing CategoriaRequisito entity
         *
         */
    public CategoriaRequisito getCategoriaRequisito(
        Integer idCategoriaRequisito) throws Exception;

    public List<CategoriaRequisito> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CategoriaRequisito> findPageCategoriaRequisito(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCategoriaRequisito() throws Exception;

    public List<CategoriaRequisitoDTO> getDataCategoriaRequisito()
        throws Exception;

    public void validateCategoriaRequisito(
        CategoriaRequisito categoriaRequisito) throws Exception;
}
