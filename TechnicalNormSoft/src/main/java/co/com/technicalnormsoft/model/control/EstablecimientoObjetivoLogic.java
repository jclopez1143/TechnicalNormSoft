package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.dataaccess.dao.*;
import co.com.technicalnormsoft.dto.mapper.IEstablecimientoObjetivoMapper;
import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;
import co.com.technicalnormsoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
 * @author Silicon Cali
 * 
 *
 */
@Scope("singleton")
@Service("EstablecimientoObjetivoLogic")
public class EstablecimientoObjetivoLogic
implements IEstablecimientoObjetivoLogic {
	private static final Logger log = LoggerFactory.getLogger(EstablecimientoObjetivoLogic.class);

	/**
	 * DAO injected by Spring that manages EstablecimientoObjetivo entities
	 *
	 */
	@Autowired
	private IEstablecimientoObjetivoDAO establecimientoObjetivoDAO;
	@Autowired
	private IEstablecimientoObjetivoMapper establecimientoObjetivoMapper;
	@Autowired
	private Validator validator;

	/**
	 * DAO injected by Spring that manages DatoObjetivo entities
	 *
	 */
	@Autowired
	private IDatoObjetivoDAO datoObjetivoDAO;

	/**
	 * Logic injected by Spring that manages EstadoObjetivo entities
	 *
	 */
	@Autowired
	IEstadoObjetivoLogic logicEstadoObjetivo;

	/**
	 * Logic injected by Spring that manages Objetivo entities
	 *
	 */
	@Autowired
	IObjetivoLogic logicObjetivo;

	/**
	 * Logic injected by Spring that manages ProyectoEstablecimiento entities
	 *
	 */
	@Autowired
	IProyectoEstablecimientoLogic logicProyectoEstablecimiento;

	/**
	 * Logic injected by Spring that manages EstadoProyecto entities
	 *
	 */
	@Autowired
	IEstadoProyectoLogic logicEstadoProyecto;

	/**
	 * Logic injected by Spring that manages ValorDato entities
	 *
	 */
	@Autowired
	IValorDatoLogic logicValorDato;

	public void validateEstablecimientoObjetivo(
			EstablecimientoObjetivo establecimientoObjetivo)
					throws Exception {
		try {
			Set<ConstraintViolation<EstablecimientoObjetivo>> constraintViolations =
					validator.validate(establecimientoObjetivo);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<EstablecimientoObjetivo> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath()
							.toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}

				throw new Exception(strMessage.toString());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivo> getEstablecimientoObjetivo()
			throws Exception {
		log.debug("finding all EstablecimientoObjetivo instances");

		List<EstablecimientoObjetivo> list = new ArrayList<EstablecimientoObjetivo>();

		try {
			list = establecimientoObjetivoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all EstablecimientoObjetivo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"EstablecimientoObjetivo");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		log.debug("saving EstablecimientoObjetivo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"EstablecimientoObjetivo");
			}

			//            validateEstablecimientoObjetivo(entity);
			//
			//            if (getEstablecimientoObjetivo(
			//                        entity.getEstablecimientoObjetivoId()) != null) {
			//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			//            }

			establecimientoObjetivoDAO.save(entity);

			log.debug("save EstablecimientoObjetivo successful");
		} catch (Exception e) {
			log.error("save EstablecimientoObjetivo failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		log.debug("deleting EstablecimientoObjetivo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"EstablecimientoObjetivo");
		}

		if (entity.getEstablecimientoObjetivoId() == null) {
			throw new ZMessManager().new EmptyFieldException(
					"establecimientoObjetivoId");
		}

		List<DatoObjetivo> datoObjetivos = null;

		try {
			datoObjetivos = datoObjetivoDAO.findByProperty("establecimientoObjetivo.establecimientoObjetivoId",
					entity.getEstablecimientoObjetivoId());

			if (Utilities.validationsList(datoObjetivos) == true) {
				throw new ZMessManager().new DeletingException("datoObjetivos");
			}

			establecimientoObjetivoDAO.delete(entity);

			log.debug("delete EstablecimientoObjetivo successful");
		} catch (Exception e) {
			log.error("delete EstablecimientoObjetivo failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		log.debug("updating EstablecimientoObjetivo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"EstablecimientoObjetivo");
			}

			validateEstablecimientoObjetivo(entity);

			establecimientoObjetivoDAO.update(entity);

			log.debug("update EstablecimientoObjetivo successful");
		} catch (Exception e) {
			log.error("update EstablecimientoObjetivo failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivoDTO> getDataEstablecimientoObjetivo()
			throws Exception {
		try {
			List<EstablecimientoObjetivo> establecimientoObjetivo = establecimientoObjetivoDAO.findAll();

			List<EstablecimientoObjetivoDTO> establecimientoObjetivoDTO = new ArrayList<EstablecimientoObjetivoDTO>();

			for (EstablecimientoObjetivo establecimientoObjetivoTmp : establecimientoObjetivo) {
				EstablecimientoObjetivoDTO establecimientoObjetivoDTO2 = establecimientoObjetivoMapper.
						establecimientoObjetivoToEstablecimientoObjetivoDTO(establecimientoObjetivoTmp);
				establecimientoObjetivoDTO.add(establecimientoObjetivoDTO2);
			}

			return establecimientoObjetivoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public EstablecimientoObjetivo getEstablecimientoObjetivo(
			Integer establecimientoObjetivoId) throws Exception {
		log.debug("getting EstablecimientoObjetivo instance");

		EstablecimientoObjetivo entity = null;

		try {
			entity = establecimientoObjetivoDAO.findById(establecimientoObjetivoId);
		} catch (Exception e) {
			log.error("get EstablecimientoObjetivo failed", e);
			throw new ZMessManager().new FindingException(
					"EstablecimientoObjetivo");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivo> findPageEstablecimientoObjetivo(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<EstablecimientoObjetivo> entity = null;

		try {
			entity = establecimientoObjetivoDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"EstablecimientoObjetivo Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberEstablecimientoObjetivo()
			throws Exception {
		Long entity = null;

		try {
			entity = establecimientoObjetivoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"EstablecimientoObjetivo Count");
		} finally {
		}

		return entity;
	}

	//Method return list of EstablecimientoObjetivo found by Programa Id
	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivo> getEstablecimientoObjetivosByProgramaId(
			Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception {
		log.debug("finding EstablecimientoObjetivo by idPrograma instances");

		List<EstablecimientoObjetivo> list = new ArrayList<EstablecimientoObjetivo>();

		try {
			list = establecimientoObjetivoDAO.findEstablecimientoObjetivosByProgramaId(idPrograma, idProyectoEstablecimiento);
		} catch (Exception e) {
			log.error("finding EstablecimientoObjetivo by idPrograma failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"EstablecimientoObjetivo");
		}
		return list;
	}

	//method returns EstablecimientoObjetivo foound by ProyectoEstablecimiento Id and Objetivo Id
	@Transactional(readOnly = true)
	public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(
			Integer idProyectoEstablecimiento, Integer idObjetivo) throws Exception {
		log.debug("getting EstablecimientoObjetivo instance");

		EstablecimientoObjetivo entity = null;

		try {
			entity = establecimientoObjetivoDAO.findEstablecimientoObjetivoByIds(
					idProyectoEstablecimiento, idObjetivo);
		} catch (Exception e) {
			log.error("get EstablecimientoObjetivo failed", e);
			throw new ZMessManager().new FindingException(
					"EstablecimientoObjetivo");
		}

		return entity;
	}

	//Method returns all EstablecimientoObjetivos from ProyectoEstablecimiento
	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId
	(Integer idProyectoEstablecimiento) throws Exception {
		log.debug("finding EstablecimientoObjetivo by idPrograma instances");

		List<EstablecimientoObjetivo> list = new ArrayList<EstablecimientoObjetivo>();

		try {
			list = establecimientoObjetivoDAO.findEstablecimientoObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);
		} catch (Exception e) {
			log.error("finding EstablecimientoObjetivo by idPrograma failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"EstablecimientoObjetivo");
		}
		return list;
	}

	//Method resets all EstablecimientoObjetivo to default state : "No Iniciado"
	@Transactional(readOnly = true)
	public void resetAllNewEstablecimientoObjetivoEstado(Integer idProyectoEstablecimiento) throws Exception {
		log.debug("reseting all EstablecimientoObjetivo estado by idProyectoEstablecimiento instances");
		List<EstablecimientoObjetivo> establecimientoObjetivos = new ArrayList<EstablecimientoObjetivo>();
		EstadoObjetivo estadoObjetivo = null;
		EstadoProyecto estadoProyecto = null;
		ValorDato valorDatoAutoevaluacion = null;
		try {
			estadoProyecto = logicEstadoProyecto.findEstadoProyectoByProyectoEstablecimientoId(idProyectoEstablecimiento);
			establecimientoObjetivos = findEstablecimientoObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);

			for (EstablecimientoObjetivo establecimientoObjetivo : establecimientoObjetivos) {
				estadoObjetivo = logicEstadoObjetivo.findEstadoObjetivoByEstablecimientoObjetivoId(
						establecimientoObjetivo.getEstablecimientoObjetivoId());

				if (estadoObjetivo.getDescripcion().equals("No Iniciado")) {
					throw new Exception("No ha completado todos los objetivos del Proyecto.");
				} else {
					valorDatoAutoevaluacion = logicValorDato.findValorDatoAutoevaluacionByEstablecimientoObjetivoId(
							establecimientoObjetivo.getEstablecimientoObjetivoId());
					if (estadoProyecto.getDescripcion().equals("Ejecución") && 
							!valorDatoAutoevaluacion.getValor().equals("No Cumple Req.")) {
						estadoObjetivo = logicEstadoObjetivo.findEstadoObjetivoByDescripcion(valorDatoAutoevaluacion.getValor());
					} else {
						if (!estadoProyecto.getDescripcion().equals("Completado")) {
							estadoObjetivo = logicEstadoObjetivo.findEstadoObjetivoByDescripcion("No Iniciado");
						}
					}
					establecimientoObjetivo.setEstadoObjetivo(estadoObjetivo);
					establecimientoObjetivo.setDateUpdate(new Date());

					updateEstablecimientoObjetivo(establecimientoObjetivo);
				}
			}
		} catch (Exception e) {
			log.error("reseting all EstablecimientoObjetivo estado by idProyectoEstablecimiento failed", e);
			throw new Exception(e);
		}
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 * [0] = String variable = (String) varibles[i]; representa como se llama la
	 * variable en el pojo
	 *
	 * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
	 * valor necesita o no ''(comillas simples)usado para campos de tipo string
	 *
	 * [2] = Object value = varibles[i + 2]; representa el valor que se va a
	 * buscar en la BD
	 *
	 * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
	 * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
	 * en este campo iria el tipo de comparador que quiero si es = o <>
	 *
	 * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
	 * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
	 * que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 * la diferencia son estas dos posiciones
	 *
	 * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
	 * a ser buscada en un rango
	 *
	 * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
	 *
	 * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
	 * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
	 *
	 * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
	 * ejemplo: a comparator1 1 and a < 5
	 *
	 * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
	 * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
	 * 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql)
	 *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
	 *
	 * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
	 * dates)
	 *
	 * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
	 * dates)
	 *
	 * esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<EstablecimientoObjetivo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<EstablecimientoObjetivo> list = new ArrayList<EstablecimientoObjetivo>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) &&
						(variables[i + 2] != null) &&
						(variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" +
										value + "\' )")
										: (tempWhere + " AND (model." + variable + " " +
												comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " +
										value + " )")
										: (tempWhere + " AND (model." + variable + " " +
												comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) &&
						(variablesBetween[j + 1] != null) &&
						(variablesBetween[j + 2] != null) &&
						(variablesBetween[j + 3] != null) &&
						(variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable +
									" and " + variable + " " + comparator2 + " " + value2 +
									" )")
									: (tempWhere + " AND (" + value + " " + comparator1 +
											" " + variable + " and " + variable + " " +
											comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) &&
						(variablesBetweenDates[k + 1] != null) &&
						(variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between " + value +
									" and " + value2 + ")")
									: (tempWhere + " AND (model." + variable + " between " +
											value + " and " + value2 + ")");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = establecimientoObjetivoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
