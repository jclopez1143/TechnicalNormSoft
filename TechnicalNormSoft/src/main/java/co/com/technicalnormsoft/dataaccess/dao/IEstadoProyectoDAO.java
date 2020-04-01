package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.EstadoProyecto;


/**
* Interface for   EstadoProyectoDAO.
*
*/
public interface IEstadoProyectoDAO extends Dao<EstadoProyecto, Integer> {
	
	public EstadoProyecto findEstadoProyectoByProyectoEstablecimientoId(int idProyectoEstablecimiento);

	public EstadoProyecto findEstadoProyectoByDescripcion(String descripcionEstado);
}
