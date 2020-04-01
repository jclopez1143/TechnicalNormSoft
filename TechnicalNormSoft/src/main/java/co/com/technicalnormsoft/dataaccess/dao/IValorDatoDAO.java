package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.ValorDato;


/**
* Interface for   ValorDatoDAO.
*
*/
public interface IValorDatoDAO extends Dao<ValorDato, Integer> {
	
	public List<ValorDato> findValorDatosByIds(int establecimientoObjetivoId,
    		int idDatoObjetivo);
	
	public ValorDato findValorDatoAutoevaluacionByEstablecimientoObjetivoId(
			int establecimientoObjetivoId);
}
