package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.ValorCampo;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;

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
public interface IValorCampoLogic {
    public List<ValorCampo> getValorCampo() throws Exception;

    /**
         * Save an new ValorCampo entity
         */
    public void saveValorCampo(ValorCampo entity) throws Exception;

    /**
         * Delete an existing ValorCampo entity
         *
         */
    public void deleteValorCampo(ValorCampo entity) throws Exception;

    /**
        * Update an existing ValorCampo entity
        *
        */
    public void updateValorCampo(ValorCampo entity) throws Exception;

    /**
         * Load an existing ValorCampo entity
         *
         */
    public ValorCampo getValorCampo(Integer idValorCampo)
        throws Exception;

    public List<ValorCampo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ValorCampo> findPageValorCampo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberValorCampo() throws Exception;

    public List<ValorCampoDTO> getDataValorCampo() throws Exception;

    public void validateValorCampo(ValorCampo valorCampo)
        throws Exception;
    
    public List<ValorCampo> findValorCamposByRegistroDatoId(Integer idRegistroDato) 
    		throws Exception;
    
    public List<ValorCampoDTO> listValorCampoToListValorCampoDTO(List<ValorCampo> valorCampos) 
    		throws Exception;
    
    public ValorCampoDTO valorCampoToValorCampoDTO(ValorCampo valorCampo)
            throws Exception;
}
