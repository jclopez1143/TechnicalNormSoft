package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Objetivo;


/**
* Interface for   ObjetivoDAO.
*
*/
public interface IObjetivoDAO extends Dao<Objetivo, Integer> {
	public Objetivo findObjetivoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo);
	
	public List<Objetivo> findObjetivosByEstadoDescripcion(String descripcionEstado, int idProyectoEstablecimiento);
	
	public List<Objetivo> findObjetivosByProyectoEstablecimientoId(int idProyectoEstablecimiento);
	
	public List<Objetivo> findObjetivosByEstadoDescripcionProgramaId(String descripcionEstado, 
    		int idPrograma, int idProyectoEstablecimiento);
	
	public List<Objetivo> findObjetivosByProgramaId(int idPrograma);
	
	public Objetivo findObjetivoByRequisitoId(int idRequisito);
}
