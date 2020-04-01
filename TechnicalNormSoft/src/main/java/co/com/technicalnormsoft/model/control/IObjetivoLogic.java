package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Objetivo;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;


/**
* @author Silicon Cali
* 
*
*/
public interface IObjetivoLogic {
    public List<Objetivo> getObjetivo() throws Exception;

    /**
         * Save an new Objetivo entity
         */
    public void saveObjetivo(Objetivo entity) throws Exception;

    /**
         * Delete an existing Objetivo entity
         *
         */
    public void deleteObjetivo(Objetivo entity) throws Exception;

    /**
        * Update an existing Objetivo entity
        *
        */
    public void updateObjetivo(Objetivo entity) throws Exception;

    /**
         * Load an existing Objetivo entity
         *
         */
    public Objetivo getObjetivo(Integer idObjetivo) throws Exception;

    public List<Objetivo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Objetivo> findPageObjetivo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberObjetivo() throws Exception;

    public List<ObjetivoDTO> getDataObjetivo() throws Exception;

    public void validateObjetivo(Objetivo objetivo) throws Exception;
    
    public Objetivo findObjetivoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) 
        throws Exception;

    public ObjetivoDTO objetivoToObjetivoDTO(Objetivo objetivo)
    	throws Exception;
    
    public List<ObjetivoDTO> findObjetivoDataByEstadoDescripcion(String descripcionEstado,
    	Integer idProyectoEstablecimiento) throws Exception;
    
    public List<Objetivo> findObjetivosByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    	throws Exception;
    
    public List<ObjetivoDTO> findObjetivosByEstadoDescripcionProgramaId(String descripcionEstado, 
    		Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception;
    
    public List<ObjetivoDTO> findObjetivosByProgramaId(Integer idPrograma, Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public Objetivo findObjetivoByRequisitoId(int idRequisito) 
        	throws Exception;
}
