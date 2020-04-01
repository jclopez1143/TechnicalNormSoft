package co.com.technicalnormsoft.dataaccess.dao;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.CategoriaPrograma;


/**
* Interface for   CategoriaProgramaDAO.
*
*/
public interface ICategoriaProgramaDAO extends Dao<CategoriaPrograma, Integer> {
	public CategoriaPrograma findCategoriaProgramaByProgramaId(int idPrograma);
}
