package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Medalla;
import co.com.technicalnormsoft.model.dto.MedallaDTO;

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
public interface IMedallaLogic {
    public List<Medalla> getMedalla() throws Exception;

    /**
         * Save an new Medalla entity
         */
    public void saveMedalla(Medalla entity) throws Exception;

    /**
         * Delete an existing Medalla entity
         *
         */
    public void deleteMedalla(Medalla entity) throws Exception;

    /**
        * Update an existing Medalla entity
        *
        */
    public void updateMedalla(Medalla entity) throws Exception;

    /**
         * Load an existing Medalla entity
         *
         */
    public Medalla getMedalla(Integer idMedalla) throws Exception;

    public List<Medalla> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Medalla> findPageMedalla(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMedalla() throws Exception;

    public List<MedallaDTO> getDataMedalla() throws Exception;

    public void validateMedalla(Medalla medalla) throws Exception;
}
