package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.DatoObjetivo;


/**
* Interface for   DatoObjetivoDAO.
*
*/
public interface IDatoObjetivoDAO extends Dao<DatoObjetivo, Integer> {
	public List<DatoObjetivo> findDatoObjetivosByObjetivoId(int idObjetivo);
	
	public DatoObjetivo findDatoObjetivoAutoevaluacion(int idObjetivo);
}
