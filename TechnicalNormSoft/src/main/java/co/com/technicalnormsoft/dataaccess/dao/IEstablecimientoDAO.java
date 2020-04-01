package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Establecimiento;


/**
* Interface for   EstablecimientoDAO.
*
*/
public interface IEstablecimientoDAO extends Dao<Establecimiento, Integer> {
	public Establecimiento findEstablecimientoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo);
	
	public Establecimiento findEstablecimientoByProyectoEstablecimientoId(int idProyectoEstablecimiento);
}
