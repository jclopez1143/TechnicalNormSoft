package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.TipoServicioNorma;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;

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
public interface ITipoServicioNormaLogic {
    public List<TipoServicioNorma> getTipoServicioNorma()
        throws Exception;

    /**
         * Save an new TipoServicioNorma entity
         */
    public void saveTipoServicioNorma(TipoServicioNorma entity)
        throws Exception;

    /**
         * Delete an existing TipoServicioNorma entity
         *
         */
    public void deleteTipoServicioNorma(TipoServicioNorma entity)
        throws Exception;

    /**
        * Update an existing TipoServicioNorma entity
        *
        */
    public void updateTipoServicioNorma(TipoServicioNorma entity)
        throws Exception;

    /**
         * Load an existing TipoServicioNorma entity
         *
         */
    public TipoServicioNorma getTipoServicioNorma(Integer idTipoServicioNorma)
        throws Exception;

    public List<TipoServicioNorma> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoServicioNorma> findPageTipoServicioNorma(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoServicioNorma() throws Exception;

    public List<TipoServicioNormaDTO> getDataTipoServicioNorma()
        throws Exception;

    public void validateTipoServicioNorma(TipoServicioNorma tipoServicioNorma)
        throws Exception;
}
