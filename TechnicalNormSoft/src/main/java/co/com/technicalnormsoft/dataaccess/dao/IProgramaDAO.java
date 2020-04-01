package co.com.technicalnormsoft.dataaccess.dao;

import java.util.List;

import co.com.technicalnormsoft.dataaccess.api.Dao;
import co.com.technicalnormsoft.model.Programa;


/**
* Interface for   ProgramaDAO.
*
*/
public interface IProgramaDAO extends Dao<Programa, Integer> {
	public List<Programa> findProgramasByProyectoId(int idProyecto);
}
