package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;
import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Requisito;


/**
* Interface for   RequisitoDAO.
*
*/
public interface IRequisitoDAO extends Dao<Requisito, Integer> {
	public Requisito findRequisitoByObjetivoId(int idObjetivo);
	
	public List<Requisito> findRequisitoByNormaId(int idNorma);
	
	public List<Requisito> findRequisitosByEstadoObjetivoDescripcion(String descripcionEstado, 
    		int idProyectoEstablecimiento);
}
