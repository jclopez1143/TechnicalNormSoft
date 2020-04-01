package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.RegistroDato;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;

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
public interface IRegistroDatoLogic {
    public List<RegistroDato> getRegistroDato() throws Exception;

    /**
         * Save an new RegistroDato entity
         */
    public void saveRegistroDato(RegistroDato entity) throws Exception;

    /**
         * Delete an existing RegistroDato entity
         *
         */
    public void deleteRegistroDato(RegistroDato entity)
        throws Exception;

    /**
        * Update an existing RegistroDato entity
        *
        */
    public void updateRegistroDato(RegistroDato entity)
        throws Exception;

    /**
         * Load an existing RegistroDato entity
         *
         */
    public RegistroDato getRegistroDato(Integer idRegistroDato)
        throws Exception;

    public List<RegistroDato> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RegistroDato> findPageRegistroDato(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRegistroDato() throws Exception;

    public List<RegistroDatoDTO> getDataRegistroDato()
        throws Exception;

    public void validateRegistroDato(RegistroDato registroDato)
        throws Exception;
    
    public void deleteRegistroDatoFull(RegistroDato entity)
            throws Exception;
    
    public List<RegistroDatoDTO> listRegistroDatoToListRegistroDatoDTO(List<RegistroDato> registroDatos)
            throws Exception;
    
    public List<RegistroDato> findRegistroDatosByIds(Integer establecimientoObjetivoId,
    		Integer idDatoObjetivo) throws Exception;
}
