package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.TipoServicio;


/**
* Interface for   TipoServicioDAO.
*
*/
public interface ITipoServicioDAO extends Dao<TipoServicio, Integer> {
	public TipoServicio findTipoServicioByEstablecimientoId(int idEstablecimiento);
}
