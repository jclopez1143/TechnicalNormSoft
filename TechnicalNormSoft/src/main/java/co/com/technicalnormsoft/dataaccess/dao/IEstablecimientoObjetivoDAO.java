package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.Objetivo;


/**
* Interface for   EstablecimientoObjetivoDAO.
*
*/
public interface IEstablecimientoObjetivoDAO extends Dao<EstablecimientoObjetivo, Integer> {
	
	public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(int idProyectoEstablecimiento, int idObjetivo);
	
	List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProgramaId(int idPrograma, int idProyectoEstablecimiento);
	
	public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId(int idProyectoEstablecimiento);
}
