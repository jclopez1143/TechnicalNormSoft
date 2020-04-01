package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.RegistroDato;


/**
* Interface for   RegistroDatoDAO.
*
*/
public interface IRegistroDatoDAO extends Dao<RegistroDato, Integer> {
	public List<RegistroDato> findRegistroDatosByIds(int establecimientoObjetivoId,
    		int idDatoObjetivo);
}
