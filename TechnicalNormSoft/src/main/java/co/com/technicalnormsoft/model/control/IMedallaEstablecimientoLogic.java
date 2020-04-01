package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.MedallaEstablecimiento;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;

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
public interface IMedallaEstablecimientoLogic {
    public List<MedallaEstablecimiento> getMedallaEstablecimiento()
        throws Exception;

    /**
         * Save an new MedallaEstablecimiento entity
         */
    public void saveMedallaEstablecimiento(MedallaEstablecimiento entity)
        throws Exception;

    /**
         * Delete an existing MedallaEstablecimiento entity
         *
         */
    public void deleteMedallaEstablecimiento(MedallaEstablecimiento entity)
        throws Exception;

    /**
        * Update an existing MedallaEstablecimiento entity
        *
        */
    public void updateMedallaEstablecimiento(MedallaEstablecimiento entity)
        throws Exception;

    /**
         * Load an existing MedallaEstablecimiento entity
         *
         */
    public MedallaEstablecimiento getMedallaEstablecimiento(
        Integer idMedallaEstablecimiento) throws Exception;

    public List<MedallaEstablecimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<MedallaEstablecimiento> findPageMedallaEstablecimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberMedallaEstablecimiento()
        throws Exception;

    public List<MedallaEstablecimientoDTO> getDataMedallaEstablecimiento()
        throws Exception;

    public void validateMedallaEstablecimiento(
        MedallaEstablecimiento medallaEstablecimiento)
        throws Exception;
}
