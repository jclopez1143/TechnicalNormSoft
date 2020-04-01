package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Proyecto;


/**
* Interface for   ProyectoDAO.
*
*/
public interface IProyectoDAO extends Dao<Proyecto, Integer> {
	public Proyecto findProyectoByProyectoEstablecimientoId(int idProyectoEstablecimiento);
	
	public Proyecto findProyectoByNormaId(int idNorma);
}
