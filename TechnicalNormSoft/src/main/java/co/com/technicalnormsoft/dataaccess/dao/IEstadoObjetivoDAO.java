package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.EstadoObjetivo;


/**
* Interface for   EstadoObjetivoDAO.
*
*/
public interface IEstadoObjetivoDAO extends Dao<EstadoObjetivo, Integer> {
	public EstadoObjetivo findEstadoObjetivoByEstablecimientoObjetivoId(int establecimientoObjetivoId);
	
	public EstadoObjetivo findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(int idProyectoEstablecimiento,
    		int idObjtivo);
	
	public EstadoObjetivo findEstadoObjetivoByDescripcion(String descripcionEstado);
}
