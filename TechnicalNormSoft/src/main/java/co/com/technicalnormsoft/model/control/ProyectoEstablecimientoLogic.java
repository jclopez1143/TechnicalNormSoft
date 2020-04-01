package co.com.technicalnormsoft.model.control;

import co.com.technicalnormsoft.dataaccess.dao.*;
import co.com.technicalnormsoft.dto.mapper.IProyectoEstablecimientoMapper;
import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
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
@Service("ProyectoEstablecimientoLogic")
public class ProyectoEstablecimientoLogic
implements IProyectoEstablecimientoLogic {
	private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoLogic.class);

	/**
	 * DAO injected by Spring that manages ProyectoEstablecimiento entities
	 *
	 */
	@Autowired
	private IProyectoEstablecimientoDAO proyectoEstablecimientoDAO;
	@Autowired
	private IProyectoEstablecimientoMapper proyectoEstablecimientoMapper;
	@Autowired
	private Validator validator;

	/**
	 * Logic injected by Spring that manages Establecimiento entities
	 *
	 */
	@Autowired
	IEstablecimientoLogic logicEstablecimiento1;

	/**
	 * Logic injected by Spring that manages EstadoProyecto entities
	 *
	 */
	@Autowired
	IEstadoProyectoLogic logicEstadoProyecto2;

	/**
	 * Logic injected by Spring that manages Proyecto entities
	 *
	 */
	@Autowired
	IProyectoLogic logicProyecto3;

	/**
	 * Logic injected by Spring that manages Programa entities
	 *
	 */
	@Autowired
	IProgramaLogic logicPrograma4;

	/**
	 * Logic injected by Spring that manages Objetivo entities
	 *
	 */
	@Autowired
	IObjetivoLogic logicObjetivo5;

	/**
	 * Logic injected by Spring that manages EstablecimientoObjetivo entities
	 *
	 */
	@Autowired
	IEstablecimientoObjetivoLogic logicEstablecimientoObjetivo6;

	/**
	 * Logic injected by Spring that manages EstablecimientoObjetivo entities
	 *
	 */
	@Autowired
	IEstadoObjetivoLogic logicEstadoObjetivo7;

	/**
	 * Logic injected by Spring that manages Norma entities
	 *
	 */
	@Autowired
	INormaLogic logicNorma8;

	public void validateProyectoEstablecimiento(
			ProyectoEstablecimiento proyectoEstablecimiento)
					throws Exception {
		try {
			Set<ConstraintViolation<ProyectoEstablecimiento>> constraintViolations =
					validator.validate(proyectoEstablecimiento);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<ProyectoEstablecimiento> constraintViolation : constraintViolations) {
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
	public List<ProyectoEstablecimiento> getProyectoEstablecimiento()
			throws Exception {
		log.debug("finding all ProyectoEstablecimiento instances");

		List<ProyectoEstablecimiento> list = new ArrayList<ProyectoEstablecimiento>();

		try {
			list = proyectoEstablecimientoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ProyectoEstablecimiento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"ProyectoEstablecimiento");
		} finally {
		}

		return list;
	}


	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		log.debug("saving ProyectoEstablecimiento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ProyectoEstablecimiento");
			}

			//            validateProyectoEstablecimiento(entity);
			//
			//            if (getProyectoEstablecimiento(
			//                        entity.getIdProyectoEstablecimiento()) != null) {
			//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			//            }

			proyectoEstablecimientoDAO.save(entity);

			log.debug("save ProyectoEstablecimiento successful");
		} catch (Exception e) {
			log.error("save ProyectoEstablecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProyectoEstablecimiento(
			Integer idEstablecimiento, Integer idProyecto) throws Exception {
		log.debug("saving ProyectoEstablecimiento instance");

		try {
			ProyectoEstablecimiento entity = new ProyectoEstablecimiento();
			//TODO

			//            validateProyectoEstablecimiento(entity);
			//
			//            if (getProyectoEstablecimiento(
			//                        entity.getIdProyectoEstablecimiento()) != null) {
			//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			//            }

			proyectoEstablecimientoDAO.save(entity);

			log.debug("save ProyectoEstablecimiento successful");
		} catch (Exception e) {
			log.error("save ProyectoEstablecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		log.debug("deleting ProyectoEstablecimiento instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"ProyectoEstablecimiento");
		}

		if (entity.getIdProyectoEstablecimiento() == null) {
			throw new ZMessManager().new EmptyFieldException(
					"idProyectoEstablecimiento");
		}

		try {
			proyectoEstablecimientoDAO.delete(entity);

			log.debug("delete ProyectoEstablecimiento successful");
		} catch (Exception e) {
			log.error("delete ProyectoEstablecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		log.debug("updating ProyectoEstablecimiento instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ProyectoEstablecimiento");
			}

			validateProyectoEstablecimiento(entity);

			proyectoEstablecimientoDAO.update(entity);

			log.debug("update ProyectoEstablecimiento successful");
		} catch (Exception e) {
			log.error("update ProyectoEstablecimiento failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ProyectoEstablecimientoDTO> getDataProyectoEstablecimiento()
			throws Exception {
		try {
			List<ProyectoEstablecimiento> proyectoEstablecimiento = proyectoEstablecimientoDAO.findAll();

			List<ProyectoEstablecimientoDTO> proyectoEstablecimientoDTO = new ArrayList<ProyectoEstablecimientoDTO>();

			for (ProyectoEstablecimiento proyectoEstablecimientoTmp : proyectoEstablecimiento) {
				ProyectoEstablecimientoDTO proyectoEstablecimientoDTO2 = proyectoEstablecimientoMapper.
						proyectoEstablecimientoToProyectoEstablecimientoDTO(proyectoEstablecimientoTmp);
				proyectoEstablecimientoDTO.add(proyectoEstablecimientoDTO2);
			}

			return proyectoEstablecimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ProyectoEstablecimiento getProyectoEstablecimiento(
			Integer idProyectoEstablecimiento) throws Exception {
		log.debug("getting ProyectoEstablecimiento instance");

		ProyectoEstablecimiento entity = null;

		try {
			entity = proyectoEstablecimientoDAO.findById(idProyectoEstablecimiento);
		} catch (Exception e) {
			log.error("get ProyectoEstablecimiento failed", e);
			throw new ZMessManager().new FindingException(
					"ProyectoEstablecimiento");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ProyectoEstablecimiento> findPageProyectoEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ProyectoEstablecimiento> entity = null;

		try {
			entity = proyectoEstablecimientoDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProyectoEstablecimiento Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberProyectoEstablecimiento()
			throws Exception {
		Long entity = null;

		try {
			entity = proyectoEstablecimientoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProyectoEstablecimiento Count");
		} finally {
		}

		return entity;
	}

	//Method that calculates ProyectoEstablecimiento progress with all Programas
	@Transactional(readOnly = true)
	public Double getProyectoEstablecimeintoProgress(Integer idProyectoEstablecimiento) throws Exception {
		double progress = 0.0;
		double totalScore = 0.0;
		EstadoProyecto estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByProyectoEstablecimientoId(idProyectoEstablecimiento);
		try {
			List<Objetivo> objetivos = logicObjetivo5.findObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);
			EstablecimientoObjetivo establecimientoObjetivo;

			for (Objetivo objetivo : objetivos) {
				totalScore = totalScore + objetivo.getScore();
				establecimientoObjetivo = logicEstablecimientoObjetivo6.findEstablecimientoObjetivoByIds(idProyectoEstablecimiento, objetivo.getIdObjetivo());

				if (establecimientoObjetivo != null) {
					EstadoObjetivo estadoObjetivo = logicEstadoObjetivo7.findEstadoObjetivoByEstablecimientoObjetivoId(
							establecimientoObjetivo.getEstablecimientoObjetivoId());
					if (!estadoProyecto.getDescripcion().equals("Autoevaluación")) {
						if (estadoObjetivo.getDescripcion().equals("Completado")) {
							progress = progress + objetivo.getScore();
						}
					} else {
						if (estadoObjetivo.getDescripcion().equals("No Cumple Req.") ||
								estadoObjetivo.getDescripcion().equals("Cumple Req.") ||
								estadoObjetivo.getDescripcion().equals("No Aplica")) {
							progress = progress + objetivo.getScore();
						}
					}
				}
			}
			progress = (progress*100)/totalScore;
		} catch (Exception e) {
			throw e;
		}
		return progress;
	}

	//Method finds ProyectoEstablecimiento by Establecimiento id
	@Transactional(readOnly = true)
	public List<ProyectoEstablecimiento> getProyectoEstablecimientoByEstablecimientoId(
			Integer idEstablecimiento) throws Exception {
		log.debug("finding all ProyectoEstablecimiento instances");

		List<ProyectoEstablecimiento> list = new ArrayList<ProyectoEstablecimiento>();

		try {
			list = proyectoEstablecimientoDAO.findProyectoEstablecimientoListByEstablecimientoId(idEstablecimiento);
		} catch (Exception e) {
			log.error("finding all ProyectoEstablecimiento failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"ProyectoEstablecimiento");
		} finally {
		}

		return list;
	}

	//Returns ProyectoEstablecimiento DTO list found by EstablecimientoId
	@Transactional(readOnly = true)
	public List<ProyectoEstablecimientoDTO> getProyectoEstablecimientoDTOByEstablecimientoId(
			Integer idEstablecimiento) throws Exception {
		try {
			List<ProyectoEstablecimiento> proyectoEstablecimiento = proyectoEstablecimientoDAO.
					findProyectoEstablecimientoListByEstablecimientoId(idEstablecimiento);

			List<ProyectoEstablecimientoDTO> proyectoEstablecimientoDTO = new ArrayList<ProyectoEstablecimientoDTO>();

			for (ProyectoEstablecimiento proyectoEstablecimientoTmp : proyectoEstablecimiento) {
				ProyectoEstablecimientoDTO proyectoEstablecimientoDTO2 = proyectoEstablecimientoMapper.
						proyectoEstablecimientoToProyectoEstablecimientoDTO(proyectoEstablecimientoTmp);
				proyectoEstablecimientoDTO.add(proyectoEstablecimientoDTO2);
			}

			return proyectoEstablecimientoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	//Method return ProyectoEstablecimientoDTO from ProyectoEstablecimiento
	@Transactional(readOnly = true)
	public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
			ProyectoEstablecimiento proyectoEstablecimiento) throws Exception {
		log.debug("getting ProyectoEstablecimiento instance");

		ProyectoEstablecimientoDTO entity = null;

		try {
			entity = proyectoEstablecimientoMapper.proyectoEstablecimientoToProyectoEstablecimientoDTO(
					proyectoEstablecimiento);
		} catch (Exception e) {
			log.error("get ProyectoEstablecimiento failed", e);
			throw new ZMessManager().new FindingException(
					"ProyectoEstablecimiento");
		} finally {
		}

		return entity;
	}


	//Method checks if there is another ProyectoEstablecimiento with EstadoProyecto != "Completado" and same Nroma
	@Transactional(readOnly = true)
	public boolean isOtherSameProyectoInExecution(Integer idEstablecimiento, Integer idNorma) throws Exception {
		log.debug("check other same ProyectoEstablecimiento instance");
		EstadoProyecto estadoProyecto = null;
		Norma normaProyecto = null;

		try {
			List<ProyectoEstablecimientoDTO> proyectosEstablecimientoDTO = getProyectoEstablecimientoDTOByEstablecimientoId(
					idEstablecimiento);

			for (ProyectoEstablecimientoDTO proyectoEstablecimientoDTO : proyectosEstablecimientoDTO) {
				estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByProyectoEstablecimientoId(
						proyectoEstablecimientoDTO.getIdProyectoEstablecimiento());

				normaProyecto = logicNorma8.findNormaByProyectoEstablecimientoId(
						proyectoEstablecimientoDTO.getIdProyectoEstablecimiento());

				if (normaProyecto.getIdNorma() == idNorma && !estadoProyecto.getDescripcion().equals("Completado")) {
					return true;
				}
			}
		} catch (Exception e) {
			log.error("check other same ProyectoEstablecimiento failed", e);
			throw new Exception(e);
		}
		return false;
	}

	//Method checks if Proyecto state is finish check every EstadoObjetivo descripcion
	@Transactional(readOnly = true)
	public boolean isProyectoStateFinished(Integer idProyectoEstablecimiento) throws Exception {
		log.debug("check Proyecto state finished");

		try {
			List<Objetivo> objetivosProyecto = logicObjetivo5.findObjetivosByProyectoEstablecimientoId(
					idProyectoEstablecimiento);
			List<EstablecimientoObjetivo> objetivosEstablecimiento = logicEstablecimientoObjetivo6.
					findEstablecimientoObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);

			if (objetivosEstablecimiento.size() < objetivosProyecto.size()) {
				return false;
			} else {
				EstadoProyecto estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByProyectoEstablecimientoId(
						idProyectoEstablecimiento);

				EstadoObjetivo estadoObjetivo = null;

				if (estadoProyecto.equals("Autoevaluación")) {
					for (EstablecimientoObjetivo establecimientoObjetivo : objetivosEstablecimiento) {
						estadoObjetivo = logicEstadoObjetivo7.findEstadoObjetivoByEstablecimientoObjetivoId(
								establecimientoObjetivo.getEstablecimientoObjetivoId());
						if (estadoObjetivo.getDescripcion().equals("No Iniciado")) {
							return false;
						}
					}
				} else {
					for (EstablecimientoObjetivo establecimientoObjetivo : objetivosEstablecimiento) {
						estadoObjetivo = logicEstadoObjetivo7.findEstadoObjetivoByEstablecimientoObjetivoId(
								establecimientoObjetivo.getEstablecimientoObjetivoId());
						if (!estadoObjetivo.getDescripcion().equals("Completado")) {
							return false;
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			log.error("check Proyecto state finished failed", e);
			throw new Exception(e);
		}
	}

	//Method finishes ProyectoEstablecimiento changing actual Estado and reset all EstablecimientoObjetivo
	@Transactional(readOnly = true)
	public void finishProyectoEstado (Integer idProyectoEstablecimiento) throws Exception {
		log.debug("finish Proyecto Estado instance");
		try {
			ProyectoEstablecimiento entity = getProyectoEstablecimiento(idProyectoEstablecimiento);
			EstadoProyecto estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByProyectoEstablecimientoId(
					entity.getIdProyectoEstablecimiento());

			if (getProyectoEstablecimeintoProgress(idProyectoEstablecimiento) <= 100d) {
				throw new Exception("Debe completar todos los objetivos del Proyecto para finalizar "
						+ estadoProyecto.getDescripcion());
			}

			switch (estadoProyecto.getDescripcion()) {
			case "Autoevaluación":
				estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByDescripcion("Revisión Autoevaluación");
				break;
			case "Revisión Autoevaluación":
				estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByDescripcion("Ejecución");
				break;
			case "Ejecución":
				estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByDescripcion("Revisión Ejecución");
				break;
			case "Revisión Ejecución":
				estadoProyecto = logicEstadoProyecto2.findEstadoProyectoByDescripcion("Completado");
				break;
			}
			
			entity.setEstadoProyecto(estadoProyecto);
			entity.setDateUpdate(new Date());
			
			updateProyectoEstablecimiento(entity);
			
			logicEstablecimientoObjetivo6.resetAllNewEstablecimientoObjetivoEstado(idProyectoEstablecimiento);

		} catch (Exception e) {
			log.error("finish Proyecto Estado failed", e);
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
	public List<ProyectoEstablecimiento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<ProyectoEstablecimiento> list = new ArrayList<ProyectoEstablecimiento>();
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
			list = proyectoEstablecimientoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
