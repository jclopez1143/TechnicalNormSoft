package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.ValorCampo;


/**
* Interface for   ValorCampoDAO.
*
*/
public interface IValorCampoDAO extends Dao<ValorCampo, Integer> {
	
	public List<ValorCampo> findValorCamposByRegistroDatoId(int idRegistroDato);
}
