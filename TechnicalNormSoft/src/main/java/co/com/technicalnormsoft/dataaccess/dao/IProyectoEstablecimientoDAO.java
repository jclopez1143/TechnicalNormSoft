package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.ProyectoEstablecimiento;


/**
 * Interface for   ProyectoEstablecimientoDAO.
 *
 */
public interface IProyectoEstablecimientoDAO extends Dao<ProyectoEstablecimiento, Integer> {
	public List<ProyectoEstablecimiento> findProyectoEstablecimientoListByEstablecimientoId(
			Integer idEstablecimiento);
}
