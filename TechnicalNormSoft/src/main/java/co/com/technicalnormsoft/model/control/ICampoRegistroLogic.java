package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICampoRegistroLogic {
    public List<CampoRegistro> getCampoRegistro() throws Exception;

    /**
         * Save an new CampoRegistro entity
         */
    public void saveCampoRegistro(CampoRegistro entity)
        throws Exception;

    /**
         * Delete an existing CampoRegistro entity
         *
         */
    public void deleteCampoRegistro(CampoRegistro entity)
        throws Exception;

    /**
        * Update an existing CampoRegistro entity
        *
        */
    public void updateCampoRegistro(CampoRegistro entity)
        throws Exception;

    /**
         * Load an existing CampoRegistro entity
         *
         */
    public CampoRegistro getCampoRegistro(Integer idCampoRegistro)
        throws Exception;

    public List<CampoRegistro> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CampoRegistro> findPageCampoRegistro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCampoRegistro() throws Exception;

    public List<CampoRegistroDTO> getDataCampoRegistro()
        throws Exception;

    public void validateCampoRegistro(CampoRegistro campoRegistro)
        throws Exception;
    
    public List<CampoRegistro> findCampoRegistrosByDatoObjetivoId(Integer idDatoObjetivo)
    		throws Exception;
    
    public CampoRegistro findCampoRegistroByValorCampoId(Integer idValorCampo)
            throws Exception;
    
    public List<CampoRegistroDTO> listCampoRegistroToListCampoRegistroDTO(List<CampoRegistro> campoRegistros)
            throws Exception;
    
    public CampoRegistroDTO campoRegistroToCampoRegistroDTO(CampoRegistro campoRegistro) throws Exception;
}
