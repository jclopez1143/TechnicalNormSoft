package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Norma;


/**
* Interface for   NormaDAO.
*
*/
public interface INormaDAO extends Dao<Norma, Integer> {
	public List<Norma> findNormasByTipoServicioId(int idTipoServicio);
	
	public Norma findNormaByProyectoEstablecimientoId(int idProyectoEstablecimiento);
	
	public Norma findNormaByRequisitoId(int idRequisito);
}
