package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.model.Requisito;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;

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
public interface IRequisitoLogic {
	public List<Requisito> getRequisito() throws Exception;

	/**
	 * Save an new Requisito entity
	 */
	public void saveRequisito(Requisito entity) throws Exception;

	/**
	 * Delete an existing Requisito entity
	 *
	 */
	public void deleteRequisito(Requisito entity) throws Exception;

	/**
	 * Update an existing Requisito entity
	 *
	 */
	public void updateRequisito(Requisito entity) throws Exception;

	/**
	 * Load an existing Requisito entity
	 *
	 */
	public Requisito getRequisito(Integer idRequisito)
			throws Exception;

	public List<Requisito> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Requisito> findPageRequisito(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberRequisito() throws Exception;

	public List<RequisitoDTO> getDataRequisito() throws Exception;

	public void validateRequisito(Requisito requisito)
			throws Exception;

	public Requisito findRequisitoByObjetivoId(Integer idObjetivo)
			throws Exception;
	
	public List<RequisitoDTO> findRequisitoByNormaId(Integer idNorma) throws Exception;
	
	public RequisitoDTO requisitoToRequisitoDTO(Requisito requisito) throws Exception;
	
	public List<RequisitoDTO> findRequisitosDTOByEstadoObjetivoDescripcion(String descripcionEstado,
    		Integer idProyectoEstablecimiento) throws Exception;
	
	public Requisito findRequisitoByEstablecimientoObjetivoId(Integer establecimientoObjetivoId)
	        throws Exception;
}
