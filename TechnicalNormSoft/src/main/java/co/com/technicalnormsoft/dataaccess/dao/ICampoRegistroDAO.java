package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.CampoRegistro;


/**
* Interface for   CampoRegistroDAO.
*
*/
public interface ICampoRegistroDAO extends Dao<CampoRegistro, Integer> {
	public List<CampoRegistro> findCampoRegistrosByDatoObjetivoId(int idDatoObjetivo);
	
	public CampoRegistro findCampoRegistroByValorCampoId(int idValorCampo);
}
