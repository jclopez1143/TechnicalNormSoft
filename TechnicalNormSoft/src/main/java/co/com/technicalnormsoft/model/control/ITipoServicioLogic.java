package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.TipoServicio;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;

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
public interface ITipoServicioLogic {
    public List<TipoServicio> getTipoServicio() throws Exception;

    /**
         * Save an new TipoServicio entity
         */
    public void saveTipoServicio(TipoServicio entity) throws Exception;

    /**
         * Delete an existing TipoServicio entity
         *
         */
    public void deleteTipoServicio(TipoServicio entity)
        throws Exception;

    /**
        * Update an existing TipoServicio entity
        *
        */
    public void updateTipoServicio(TipoServicio entity)
        throws Exception;

    /**
         * Load an existing TipoServicio entity
         *
         */
    public TipoServicio getTipoServicio(Integer idTipoServicio)
        throws Exception;

    public List<TipoServicio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoServicio> findPageTipoServicio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoServicio() throws Exception;

    public List<TipoServicioDTO> getDataTipoServicio()
        throws Exception;

    public void validateTipoServicio(TipoServicio tipoServicio)
        throws Exception;
    
    public TipoServicio findTipoServicioByEstablecimientoId(int idEstablecimiento) 
        throws Exception;
    
    public TipoServicioDTO tipoServicioToTipoServicioDTO(TipoServicio tipoServicio) 
    	throws Exception;
}
