package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.ValorDato;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;

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
public interface IValorDatoLogic {
    public List<ValorDato> getValorDato() throws Exception;

    /**
         * Save an new ValorDato entity
         */
    public void saveValorDato(ValorDato entity) throws Exception;

    /**
         * Delete an existing ValorDato entity
         *
         */
    public void deleteValorDato(ValorDato entity) throws Exception;

    /**
        * Update an existing ValorDato entity
        *
        */
    public void updateValorDato(ValorDato entity) throws Exception;

    /**
         * Load an existing ValorDato entity
         *
         */
    public ValorDato getValorDato(Integer idValorDato)
        throws Exception;

    public List<ValorDato> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ValorDato> findPageValorDato(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberValorDato() throws Exception;

    public List<ValorDatoDTO> getDataValorDato() throws Exception;

    public void validateValorDato(ValorDato valorDato)
        throws Exception;
    
    public List<ValorDato> findValorDatosByIds(Integer establecimientoObjetivoId,
    		Integer idDatoObjetivo) throws Exception;
    
    public List<ValorDatoDTO> listValorDatoToListValorDatoDTO(List<ValorDato> valorDatos) 
    		throws Exception;
    
    public ValorDatoDTO valorDatoToValorDatoDTO(ValorDato valorDatos) 
    		throws Exception;
    
    public ValorDato findValorDatoAutoevaluacionByEstablecimientoObjetivoId(
    		Integer establecimientoObjetivoId) throws Exception;
}
