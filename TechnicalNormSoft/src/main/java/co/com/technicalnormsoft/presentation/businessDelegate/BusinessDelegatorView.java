package co.com.technicalnormsoft.presentation.businessDelegate;

import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.CategoriaRequisito;
import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.EstadoObjetivo;
import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.Medalla;
import co.com.technicalnormsoft.model.MedallaEstablecimiento;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.Objetivo;
import co.com.technicalnormsoft.model.Programa;
import co.com.technicalnormsoft.model.Proyecto;
import co.com.technicalnormsoft.model.ProyectoEstablecimiento;
import co.com.technicalnormsoft.model.RegistroDato;
import co.com.technicalnormsoft.model.Requisito;
import co.com.technicalnormsoft.model.TipoServicio;
import co.com.technicalnormsoft.model.TipoServicioNorma;
import co.com.technicalnormsoft.model.Usuario;
import co.com.technicalnormsoft.model.ValorCampo;
import co.com.technicalnormsoft.model.ValorDato;
import co.com.technicalnormsoft.model.control.ICampoRegistroLogic;
import co.com.technicalnormsoft.model.control.ICategoriaProgramaLogic;
import co.com.technicalnormsoft.model.control.ICategoriaRequisitoLogic;
import co.com.technicalnormsoft.model.control.IDatoObjetivoLogic;
import co.com.technicalnormsoft.model.control.IEstablecimientoLogic;
import co.com.technicalnormsoft.model.control.IEstablecimientoObjetivoLogic;
import co.com.technicalnormsoft.model.control.IEstadoObjetivoLogic;
import co.com.technicalnormsoft.model.control.IEstadoProyectoLogic;
import co.com.technicalnormsoft.model.control.IMedallaEstablecimientoLogic;
import co.com.technicalnormsoft.model.control.IMedallaLogic;
import co.com.technicalnormsoft.model.control.INormaLogic;
import co.com.technicalnormsoft.model.control.IObjetivoLogic;
import co.com.technicalnormsoft.model.control.IProgramaLogic;
import co.com.technicalnormsoft.model.control.IProyectoEstablecimientoLogic;
import co.com.technicalnormsoft.model.control.IProyectoLogic;
import co.com.technicalnormsoft.model.control.IRegistroDatoLogic;
import co.com.technicalnormsoft.model.control.IRequisitoLogic;
import co.com.technicalnormsoft.model.control.ITipoServicioLogic;
import co.com.technicalnormsoft.model.control.ITipoServicioNormaLogic;
import co.com.technicalnormsoft.model.control.IUsuarioLogic;
import co.com.technicalnormsoft.model.control.IValorCampoLogic;
import co.com.technicalnormsoft.model.control.IValorDatoLogic;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;
import co.com.technicalnormsoft.model.dto.CategoriaRequisitoDTO;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;
import co.com.technicalnormsoft.model.dto.EstadoObjetivoDTO;
import co.com.technicalnormsoft.model.dto.EstadoProyectoDTO;
import co.com.technicalnormsoft.model.dto.MedallaDTO;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.technicalnormsoft.utilities.IFileController;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;


import java.util.List;

@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
	private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
	@Autowired
	private ICampoRegistroLogic campoRegistroLogic;
	@Autowired
	private ICategoriaProgramaLogic categoriaProgramaLogic;
	@Autowired
	private ICategoriaRequisitoLogic categoriaRequisitoLogic;
	@Autowired
	private IDatoObjetivoLogic datoObjetivoLogic;
	@Autowired
	private IEstablecimientoLogic establecimientoLogic;
	@Autowired
	private IEstablecimientoObjetivoLogic establecimientoObjetivoLogic;
	@Autowired
	private IEstadoObjetivoLogic estadoObjetivoLogic;
	@Autowired
	private IEstadoProyectoLogic estadoProyectoLogic;
	@Autowired
	private IMedallaLogic medallaLogic;
	@Autowired
	private IMedallaEstablecimientoLogic medallaEstablecimientoLogic;
	@Autowired
	private INormaLogic normaLogic;
	@Autowired
	private IObjetivoLogic objetivoLogic;
	@Autowired
	private IProgramaLogic programaLogic;
	@Autowired
	private IProyectoLogic proyectoLogic;
	@Autowired
	private IProyectoEstablecimientoLogic proyectoEstablecimientoLogic;
	@Autowired
	private IRegistroDatoLogic registroDatoLogic;
	@Autowired
	private IRequisitoLogic requisitoLogic;
	@Autowired
	private ITipoServicioLogic tipoServicioLogic;
	@Autowired
	private ITipoServicioNormaLogic tipoServicioNormaLogic;
	@Autowired
	private IUsuarioLogic usuarioLogic;
	@Autowired
	private IFileController fileController;
	@Autowired
	private IValorDatoLogic valorDatoLogic;
	@Autowired
	private IValorCampoLogic valorCampoLogic;
	
	public List<CampoRegistro> getCampoRegistro() throws Exception {
		return campoRegistroLogic.getCampoRegistro();
	}

	public void saveCampoRegistro(CampoRegistro entity)
			throws Exception {
		campoRegistroLogic.saveCampoRegistro(entity);
	}

	public void deleteCampoRegistro(CampoRegistro entity)
			throws Exception {
		campoRegistroLogic.deleteCampoRegistro(entity);
	}

	public void updateCampoRegistro(CampoRegistro entity)
			throws Exception {
		campoRegistroLogic.updateCampoRegistro(entity);
	}

	public CampoRegistro getCampoRegistro(Integer idCampoRegistro)
			throws Exception {
		CampoRegistro campoRegistro = null;

		try {
			campoRegistro = campoRegistroLogic.getCampoRegistro(idCampoRegistro);
		} catch (Exception e) {
			throw e;
		}

		return campoRegistro;
	}

	public List<CampoRegistro> findByCriteriaInCampoRegistro(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return campoRegistroLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<CampoRegistro> findPageCampoRegistro(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return campoRegistroLogic.findPageCampoRegistro(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberCampoRegistro() throws Exception {
		return campoRegistroLogic.findTotalNumberCampoRegistro();
	}

	public List<CampoRegistroDTO> getDataCampoRegistro()
			throws Exception {
		return campoRegistroLogic.getDataCampoRegistro();
	}

	public void validateCampoRegistro(CampoRegistro campoRegistro)
			throws Exception {
		campoRegistroLogic.validateCampoRegistro(campoRegistro);
	}

	public List<CategoriaPrograma> getCategoriaPrograma()
			throws Exception {
		return categoriaProgramaLogic.getCategoriaPrograma();
	}

	public void saveCategoriaPrograma(CategoriaPrograma entity)
			throws Exception {
		categoriaProgramaLogic.saveCategoriaPrograma(entity);
	}

	public void deleteCategoriaPrograma(CategoriaPrograma entity)
			throws Exception {
		categoriaProgramaLogic.deleteCategoriaPrograma(entity);
	}

	public void updateCategoriaPrograma(CategoriaPrograma entity)
			throws Exception {
		categoriaProgramaLogic.updateCategoriaPrograma(entity);
	}

	public CategoriaPrograma getCategoriaPrograma(Integer idCategoriaPrograma)
			throws Exception {
		CategoriaPrograma categoriaPrograma = null;

		try {
			categoriaPrograma = categoriaProgramaLogic.getCategoriaPrograma(idCategoriaPrograma);
		} catch (Exception e) {
			throw e;
		}

		return categoriaPrograma;
	}

	public List<CategoriaPrograma> findByCriteriaInCategoriaPrograma(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return categoriaProgramaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<CategoriaPrograma> findPageCategoriaPrograma(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return categoriaProgramaLogic.findPageCategoriaPrograma(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberCategoriaPrograma() throws Exception {
		return categoriaProgramaLogic.findTotalNumberCategoriaPrograma();
	}

	public List<CategoriaProgramaDTO> getDataCategoriaPrograma()
			throws Exception {
		return categoriaProgramaLogic.getDataCategoriaPrograma();
	}

	public void validateCategoriaPrograma(CategoriaPrograma categoriaPrograma)
			throws Exception {
		categoriaProgramaLogic.validateCategoriaPrograma(categoriaPrograma);
	}

	public List<CategoriaRequisito> getCategoriaRequisito()
			throws Exception {
		return categoriaRequisitoLogic.getCategoriaRequisito();
	}

	public void saveCategoriaRequisito(CategoriaRequisito entity)
			throws Exception {
		categoriaRequisitoLogic.saveCategoriaRequisito(entity);
	}

	public void deleteCategoriaRequisito(CategoriaRequisito entity)
			throws Exception {
		categoriaRequisitoLogic.deleteCategoriaRequisito(entity);
	}

	public void updateCategoriaRequisito(CategoriaRequisito entity)
			throws Exception {
		categoriaRequisitoLogic.updateCategoriaRequisito(entity);
	}

	public CategoriaRequisito getCategoriaRequisito(
			Integer idCategoriaRequisito) throws Exception {
		CategoriaRequisito categoriaRequisito = null;

		try {
			categoriaRequisito = categoriaRequisitoLogic.getCategoriaRequisito(idCategoriaRequisito);
		} catch (Exception e) {
			throw e;
		}

		return categoriaRequisito;
	}

	public List<CategoriaRequisito> findByCriteriaInCategoriaRequisito(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return categoriaRequisitoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<CategoriaRequisito> findPageCategoriaRequisito(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return categoriaRequisitoLogic.findPageCategoriaRequisito(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberCategoriaRequisito() throws Exception {
		return categoriaRequisitoLogic.findTotalNumberCategoriaRequisito();
	}

	public List<CategoriaRequisitoDTO> getDataCategoriaRequisito()
			throws Exception {
		return categoriaRequisitoLogic.getDataCategoriaRequisito();
	}

	public void validateCategoriaRequisito(
			CategoriaRequisito categoriaRequisito) throws Exception {
		categoriaRequisitoLogic.validateCategoriaRequisito(categoriaRequisito);
	}

	public List<DatoObjetivo> getDatoObjetivo() throws Exception {
		return datoObjetivoLogic.getDatoObjetivo();
	}

	public void saveDatoObjetivo(DatoObjetivo entity) throws Exception {
		datoObjetivoLogic.saveDatoObjetivo(entity);
	}

	public void deleteDatoObjetivo(DatoObjetivo entity)
			throws Exception {
		datoObjetivoLogic.deleteDatoObjetivo(entity);
	}

	public void updateDatoObjetivo(DatoObjetivo entity)
			throws Exception {
		datoObjetivoLogic.updateDatoObjetivo(entity);
	}

	public DatoObjetivo getDatoObjetivo(Integer idDatoObjetivo)
			throws Exception {
		DatoObjetivo datoObjetivo = null;

		try {
			datoObjetivo = datoObjetivoLogic.getDatoObjetivo(idDatoObjetivo);
		} catch (Exception e) {
			throw e;
		}

		return datoObjetivo;
	}

	public List<DatoObjetivo> findByCriteriaInDatoObjetivo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return datoObjetivoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<DatoObjetivo> findPageDatoObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return datoObjetivoLogic.findPageDatoObjetivo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDatoObjetivo() throws Exception {
		return datoObjetivoLogic.findTotalNumberDatoObjetivo();
	}

	public List<DatoObjetivoDTO> getDataDatoObjetivo()
			throws Exception {
		return datoObjetivoLogic.getDataDatoObjetivo();
	}

	public void validateDatoObjetivo(DatoObjetivo datoObjetivo)
			throws Exception {
		datoObjetivoLogic.validateDatoObjetivo(datoObjetivo);
	}

	public List<Establecimiento> getEstablecimiento() throws Exception {
		return establecimientoLogic.getEstablecimiento();
	}

	public void saveEstablecimiento(Establecimiento entity)
			throws Exception {
		establecimientoLogic.saveEstablecimiento(entity);
	}

	public void deleteEstablecimiento(Establecimiento entity)
			throws Exception {
		establecimientoLogic.deleteEstablecimiento(entity);
	}

	public void updateEstablecimiento(Establecimiento entity)
			throws Exception {
		establecimientoLogic.updateEstablecimiento(entity);
	}

	public Establecimiento getEstablecimiento(Integer idEstablecimiento)
			throws Exception {
		Establecimiento establecimiento = null;

		try {
			establecimiento = establecimientoLogic.getEstablecimiento(idEstablecimiento);
		} catch (Exception e) {
			throw e;
		}

		return establecimiento;
	}

	public List<Establecimiento> findByCriteriaInEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return establecimientoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Establecimiento> findPageEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return establecimientoLogic.findPageEstablecimiento(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEstablecimiento() throws Exception {
		return establecimientoLogic.findTotalNumberEstablecimiento();
	}

	public List<EstablecimientoDTO> getDataEstablecimiento()
			throws Exception {
		return establecimientoLogic.getDataEstablecimiento();
	}

	public void validateEstablecimiento(Establecimiento establecimiento)
			throws Exception {
		establecimientoLogic.validateEstablecimiento(establecimiento);
	}

	public List<EstablecimientoObjetivo> getEstablecimientoObjetivo()
			throws Exception {
		return establecimientoObjetivoLogic.getEstablecimientoObjetivo();
	}

	public void saveEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		establecimientoObjetivoLogic.saveEstablecimientoObjetivo(entity);
	}

	public void deleteEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		establecimientoObjetivoLogic.deleteEstablecimientoObjetivo(entity);
	}

	public void updateEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception {
		establecimientoObjetivoLogic.updateEstablecimientoObjetivo(entity);
	}

	public EstablecimientoObjetivo getEstablecimientoObjetivo(
			Integer idUsuarioObjetivo) throws Exception {
		EstablecimientoObjetivo establecimientoObjetivo = null;

		try {
			establecimientoObjetivo = establecimientoObjetivoLogic.getEstablecimientoObjetivo(idUsuarioObjetivo);
		} catch (Exception e) {
			throw e;
		}

		return establecimientoObjetivo;
	}

	public List<EstablecimientoObjetivo> findByCriteriaInEstablecimientoObjetivo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return establecimientoObjetivoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<EstablecimientoObjetivo> findPageEstablecimientoObjetivo(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return establecimientoObjetivoLogic.findPageEstablecimientoObjetivo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEstablecimientoObjetivo()
			throws Exception {
		return establecimientoObjetivoLogic.findTotalNumberEstablecimientoObjetivo();
	}

	public List<EstablecimientoObjetivoDTO> getDataEstablecimientoObjetivo()
			throws Exception {
		return establecimientoObjetivoLogic.getDataEstablecimientoObjetivo();
	}

	public void validateEstablecimientoObjetivo(
			EstablecimientoObjetivo establecimientoObjetivo)
					throws Exception {
		establecimientoObjetivoLogic.validateEstablecimientoObjetivo(establecimientoObjetivo);
	}

	public List<EstadoObjetivo> getEstadoObjetivo() throws Exception {
		return estadoObjetivoLogic.getEstadoObjetivo();
	}

	public void saveEstadoObjetivo(EstadoObjetivo entity)
			throws Exception {
		estadoObjetivoLogic.saveEstadoObjetivo(entity);
	}

	public void deleteEstadoObjetivo(EstadoObjetivo entity)
			throws Exception {
		estadoObjetivoLogic.deleteEstadoObjetivo(entity);
	}

	public void updateEstadoObjetivo(EstadoObjetivo entity)
			throws Exception {
		estadoObjetivoLogic.updateEstadoObjetivo(entity);
	}

	public EstadoObjetivo getEstadoObjetivo(Integer idEstado)
			throws Exception {
		EstadoObjetivo estadoObjetivo = null;

		try {
			estadoObjetivo = estadoObjetivoLogic.getEstadoObjetivo(idEstado);
		} catch (Exception e) {
			throw e;
		}

		return estadoObjetivo;
	}

	public List<EstadoObjetivo> findByCriteriaInEstadoObjetivo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estadoObjetivoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<EstadoObjetivo> findPageEstadoObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return estadoObjetivoLogic.findPageEstadoObjetivo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEstadoObjetivo() throws Exception {
		return estadoObjetivoLogic.findTotalNumberEstadoObjetivo();
	}

	public List<EstadoObjetivoDTO> getDataEstadoObjetivo()
			throws Exception {
		return estadoObjetivoLogic.getDataEstadoObjetivo();
	}

	public void validateEstadoObjetivo(EstadoObjetivo estadoObjetivo)
			throws Exception {
		estadoObjetivoLogic.validateEstadoObjetivo(estadoObjetivo);
	}

	public List<EstadoProyecto> getEstadoProyecto() throws Exception {
		return estadoProyectoLogic.getEstadoProyecto();
	}

	public void saveEstadoProyecto(EstadoProyecto entity)
			throws Exception {
		estadoProyectoLogic.saveEstadoProyecto(entity);
	}

	public void deleteEstadoProyecto(EstadoProyecto entity)
			throws Exception {
		estadoProyectoLogic.deleteEstadoProyecto(entity);
	}

	public void updateEstadoProyecto(EstadoProyecto entity)
			throws Exception {
		estadoProyectoLogic.updateEstadoProyecto(entity);
	}

	public EstadoProyecto getEstadoProyecto(Integer idEstadoProyecto)
			throws Exception {
		EstadoProyecto estadoProyecto = null;

		try {
			estadoProyecto = estadoProyectoLogic.getEstadoProyecto(idEstadoProyecto);
		} catch (Exception e) {
			throw e;
		}

		return estadoProyecto;
	}

	public List<EstadoProyecto> findByCriteriaInEstadoProyecto(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estadoProyectoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<EstadoProyecto> findPageEstadoProyecto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return estadoProyectoLogic.findPageEstadoProyecto(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEstadoProyecto() throws Exception {
		return estadoProyectoLogic.findTotalNumberEstadoProyecto();
	}

	public List<EstadoProyectoDTO> getDataEstadoProyecto()
			throws Exception {
		return estadoProyectoLogic.getDataEstadoProyecto();
	}

	public void validateEstadoProyecto(EstadoProyecto estadoProyecto)
			throws Exception {
		estadoProyectoLogic.validateEstadoProyecto(estadoProyecto);
	}

	public List<Medalla> getMedalla() throws Exception {
		return medallaLogic.getMedalla();
	}

	public void saveMedalla(Medalla entity) throws Exception {
		medallaLogic.saveMedalla(entity);
	}

	public void deleteMedalla(Medalla entity) throws Exception {
		medallaLogic.deleteMedalla(entity);
	}

	public void updateMedalla(Medalla entity) throws Exception {
		medallaLogic.updateMedalla(entity);
	}

	public Medalla getMedalla(Integer idMedalla) throws Exception {
		Medalla medalla = null;

		try {
			medalla = medallaLogic.getMedalla(idMedalla);
		} catch (Exception e) {
			throw e;
		}

		return medalla;
	}

	public List<Medalla> findByCriteriaInMedalla(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return medallaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Medalla> findPageMedalla(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return medallaLogic.findPageMedalla(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberMedalla() throws Exception {
		return medallaLogic.findTotalNumberMedalla();
	}

	public List<MedallaDTO> getDataMedalla() throws Exception {
		return medallaLogic.getDataMedalla();
	}

	public void validateMedalla(Medalla medalla) throws Exception {
		medallaLogic.validateMedalla(medalla);
	}

	public List<MedallaEstablecimiento> getMedallaEstablecimiento()
			throws Exception {
		return medallaEstablecimientoLogic.getMedallaEstablecimiento();
	}

	public void saveMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception {
		medallaEstablecimientoLogic.saveMedallaEstablecimiento(entity);
	}

	public void deleteMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception {
		medallaEstablecimientoLogic.deleteMedallaEstablecimiento(entity);
	}

	public void updateMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception {
		medallaEstablecimientoLogic.updateMedallaEstablecimiento(entity);
	}

	public MedallaEstablecimiento getMedallaEstablecimiento(
			Integer idMedallaEstablecimiento) throws Exception {
		MedallaEstablecimiento medallaEstablecimiento = null;

		try {
			medallaEstablecimiento = medallaEstablecimientoLogic.getMedallaEstablecimiento(idMedallaEstablecimiento);
		} catch (Exception e) {
			throw e;
		}

		return medallaEstablecimiento;
	}

	public List<MedallaEstablecimiento> findByCriteriaInMedallaEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return medallaEstablecimientoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<MedallaEstablecimiento> findPageMedallaEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return medallaEstablecimientoLogic.findPageMedallaEstablecimiento(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberMedallaEstablecimiento()
			throws Exception {
		return medallaEstablecimientoLogic.findTotalNumberMedallaEstablecimiento();
	}

	public List<MedallaEstablecimientoDTO> getDataMedallaEstablecimiento()
			throws Exception {
		return medallaEstablecimientoLogic.getDataMedallaEstablecimiento();
	}

	public void validateMedallaEstablecimiento(
			MedallaEstablecimiento medallaEstablecimiento)
					throws Exception {
		medallaEstablecimientoLogic.validateMedallaEstablecimiento(medallaEstablecimiento);
	}

	public List<Norma> getNorma() throws Exception {
		return normaLogic.getNorma();
	}

	public void saveNorma(Norma entity) throws Exception {
		normaLogic.saveNorma(entity);
	}

	public void deleteNorma(Norma entity) throws Exception {
		normaLogic.deleteNorma(entity);
	}

	public void updateNorma(Norma entity) throws Exception {
		normaLogic.updateNorma(entity);
	}

	public Norma getNorma(Integer idNorma) throws Exception {
		Norma norma = null;

		try {
			norma = normaLogic.getNorma(idNorma);
		} catch (Exception e) {
			throw e;
		}

		return norma;
	}

	public List<Norma> findByCriteriaInNorma(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return normaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Norma> findPageNorma(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return normaLogic.findPageNorma(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberNorma() throws Exception {
		return normaLogic.findTotalNumberNorma();
	}

	public List<NormaDTO> getDataNorma() throws Exception {
		return normaLogic.getDataNorma();
	}

	public void validateNorma(Norma norma) throws Exception {
		normaLogic.validateNorma(norma);
	}

	public List<Objetivo> getObjetivo() throws Exception {
		return objetivoLogic.getObjetivo();
	}

	public void saveObjetivo(Objetivo entity) throws Exception {
		objetivoLogic.saveObjetivo(entity);
	}

	public void deleteObjetivo(Objetivo entity) throws Exception {
		objetivoLogic.deleteObjetivo(entity);
	}

	public void updateObjetivo(Objetivo entity) throws Exception {
		objetivoLogic.updateObjetivo(entity);
	}

	public Objetivo getObjetivo(Integer idObjetivo) throws Exception {
		Objetivo objetivo = null;

		try {
			objetivo = objetivoLogic.getObjetivo(idObjetivo);
		} catch (Exception e) {
			throw e;
		}

		return objetivo;
	}

	public List<Objetivo> findByCriteriaInObjetivo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return objetivoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Objetivo> findPageObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return objetivoLogic.findPageObjetivo(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberObjetivo() throws Exception {
		return objetivoLogic.findTotalNumberObjetivo();
	}

	public List<ObjetivoDTO> getDataObjetivo() throws Exception {
		return objetivoLogic.getDataObjetivo();
	}

	public void validateObjetivo(Objetivo objetivo) throws Exception {
		objetivoLogic.validateObjetivo(objetivo);
	}

	public List<Programa> getPrograma() throws Exception {
		return programaLogic.getPrograma();
	}

	public void savePrograma(Programa entity) throws Exception {
		programaLogic.savePrograma(entity);
	}

	public void deletePrograma(Programa entity) throws Exception {
		programaLogic.deletePrograma(entity);
	}

	public void updatePrograma(Programa entity) throws Exception {
		programaLogic.updatePrograma(entity);
	}

	public Programa getPrograma(Integer idPrograma) throws Exception {
		Programa programa = null;

		try {
			programa = programaLogic.getPrograma(idPrograma);
		} catch (Exception e) {
			throw e;
		}

		return programa;
	}

	public List<Programa> findByCriteriaInPrograma(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return programaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Programa> findPagePrograma(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return programaLogic.findPagePrograma(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberPrograma() throws Exception {
		return programaLogic.findTotalNumberPrograma();
	}

	public List<ProgramaDTO> getDataPrograma() throws Exception {
		return programaLogic.getDataPrograma();
	}

	public void validatePrograma(Programa programa) throws Exception {
		programaLogic.validatePrograma(programa);
	}

	public List<Proyecto> getProyecto() throws Exception {
		return proyectoLogic.getProyecto();
	}

	public void saveProyecto(Proyecto entity) throws Exception {
		proyectoLogic.saveProyecto(entity);
	}

	public void deleteProyecto(Proyecto entity) throws Exception {
		proyectoLogic.deleteProyecto(entity);
	}

	public void updateProyecto(Proyecto entity) throws Exception {
		proyectoLogic.updateProyecto(entity);
	}

	public Proyecto getProyecto(Integer idProyecto) throws Exception {
		Proyecto proyecto = null;

		try {
			proyecto = proyectoLogic.getProyecto(idProyecto);
		} catch (Exception e) {
			throw e;
		}

		return proyecto;
	}

	public List<Proyecto> findByCriteriaInProyecto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return proyectoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Proyecto> findPageProyecto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return proyectoLogic.findPageProyecto(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberProyecto() throws Exception {
		return proyectoLogic.findTotalNumberProyecto();
	}

	public List<ProyectoDTO> getDataProyecto() throws Exception {
		return proyectoLogic.getDataProyecto();
	}

	public void validateProyecto(Proyecto proyecto) throws Exception {
		proyectoLogic.validateProyecto(proyecto);
	}

	public List<ProyectoEstablecimiento> getProyectoEstablecimiento()
			throws Exception {
		return proyectoEstablecimientoLogic.getProyectoEstablecimiento();
	}

	public void saveProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		proyectoEstablecimientoLogic.saveProyectoEstablecimiento(entity);
	}

	public void deleteProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		proyectoEstablecimientoLogic.deleteProyectoEstablecimiento(entity);
	}

	public void updateProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception {
		proyectoEstablecimientoLogic.updateProyectoEstablecimiento(entity);
	}

	public ProyectoEstablecimiento getProyectoEstablecimiento(
			Integer idProyectoEstablecimiento) throws Exception {
		ProyectoEstablecimiento proyectoEstablecimiento = null;

		try {
			proyectoEstablecimiento = proyectoEstablecimientoLogic.getProyectoEstablecimiento(idProyectoEstablecimiento);
		} catch (Exception e) {
			throw e;
		}

		return proyectoEstablecimiento;
	}

	public List<ProyectoEstablecimiento> findByCriteriaInProyectoEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return proyectoEstablecimientoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ProyectoEstablecimiento> findPageProyectoEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return proyectoEstablecimientoLogic.findPageProyectoEstablecimiento(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberProyectoEstablecimiento()
			throws Exception {
		return proyectoEstablecimientoLogic.findTotalNumberProyectoEstablecimiento();
	}

	public List<ProyectoEstablecimientoDTO> getDataProyectoEstablecimiento()
			throws Exception {
		return proyectoEstablecimientoLogic.getDataProyectoEstablecimiento();
	}

	public void validateProyectoEstablecimiento(
			ProyectoEstablecimiento proyectoEstablecimiento)
					throws Exception {
		proyectoEstablecimientoLogic.validateProyectoEstablecimiento(proyectoEstablecimiento);
	}

	public List<RegistroDato> getRegistroDato() throws Exception {
		return registroDatoLogic.getRegistroDato();
	}

	public void saveRegistroDato(RegistroDato entity) throws Exception {
		registroDatoLogic.saveRegistroDato(entity);
	}

	public void deleteRegistroDato(RegistroDato entity)
			throws Exception {
		registroDatoLogic.deleteRegistroDato(entity);
	}

	public void updateRegistroDato(RegistroDato entity)
			throws Exception {
		registroDatoLogic.updateRegistroDato(entity);
	}

	public RegistroDato getRegistroDato(Integer idRegistroDato)
			throws Exception {
		RegistroDato registroDato = null;

		try {
			registroDato = registroDatoLogic.getRegistroDato(idRegistroDato);
		} catch (Exception e) {
			throw e;
		}

		return registroDato;
	}

	public List<RegistroDato> findByCriteriaInRegistroDato(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return registroDatoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<RegistroDato> findPageRegistroDato(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return registroDatoLogic.findPageRegistroDato(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRegistroDato() throws Exception {
		return registroDatoLogic.findTotalNumberRegistroDato();
	}

	public List<RegistroDatoDTO> getDataRegistroDato()
			throws Exception {
		return registroDatoLogic.getDataRegistroDato();
	}

	public void validateRegistroDato(RegistroDato registroDato)
			throws Exception {
		registroDatoLogic.validateRegistroDato(registroDato);
	}

	public List<Requisito> getRequisito() throws Exception {
		return requisitoLogic.getRequisito();
	}

	public void saveRequisito(Requisito entity) throws Exception {
		requisitoLogic.saveRequisito(entity);
	}

	public void deleteRequisito(Requisito entity) throws Exception {
		requisitoLogic.deleteRequisito(entity);
	}

	public void updateRequisito(Requisito entity) throws Exception {
		requisitoLogic.updateRequisito(entity);
	}

	public Requisito getRequisito(Integer idRequisito)
			throws Exception {
		Requisito requisito = null;

		try {
			requisito = requisitoLogic.getRequisito(idRequisito);
		} catch (Exception e) {
			throw e;
		}

		return requisito;
	}

	public List<Requisito> findByCriteriaInRequisito(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return requisitoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Requisito> findPageRequisito(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return requisitoLogic.findPageRequisito(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberRequisito() throws Exception {
		return requisitoLogic.findTotalNumberRequisito();
	}

	public List<RequisitoDTO> getDataRequisito() throws Exception {
		return requisitoLogic.getDataRequisito();
	}

	public void validateRequisito(Requisito requisito)
			throws Exception {
		requisitoLogic.validateRequisito(requisito);
	}

	public List<TipoServicio> getTipoServicio() throws Exception {
		return tipoServicioLogic.getTipoServicio();
	}

	public void saveTipoServicio(TipoServicio entity) throws Exception {
		tipoServicioLogic.saveTipoServicio(entity);
	}

	public void deleteTipoServicio(TipoServicio entity)
			throws Exception {
		tipoServicioLogic.deleteTipoServicio(entity);
	}

	public void updateTipoServicio(TipoServicio entity)
			throws Exception {
		tipoServicioLogic.updateTipoServicio(entity);
	}

	public TipoServicio getTipoServicio(Integer idTipoServicio)
			throws Exception {
		TipoServicio tipoServicio = null;

		try {
			tipoServicio = tipoServicioLogic.getTipoServicio(idTipoServicio);
		} catch (Exception e) {
			throw e;
		}

		return tipoServicio;
	}

	public List<TipoServicio> findByCriteriaInTipoServicio(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return tipoServicioLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoServicio> findPageTipoServicio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return tipoServicioLogic.findPageTipoServicio(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoServicio() throws Exception {
		return tipoServicioLogic.findTotalNumberTipoServicio();
	}

	public List<TipoServicioDTO> getDataTipoServicio()
			throws Exception {
		return tipoServicioLogic.getDataTipoServicio();
	}

	public void validateTipoServicio(TipoServicio tipoServicio)
			throws Exception {
		tipoServicioLogic.validateTipoServicio(tipoServicio);
	}

	public List<TipoServicioNorma> getTipoServicioNorma()
			throws Exception {
		return tipoServicioNormaLogic.getTipoServicioNorma();
	}

	public void saveTipoServicioNorma(TipoServicioNorma entity)
			throws Exception {
		tipoServicioNormaLogic.saveTipoServicioNorma(entity);
	}

	public void deleteTipoServicioNorma(TipoServicioNorma entity)
			throws Exception {
		tipoServicioNormaLogic.deleteTipoServicioNorma(entity);
	}

	public void updateTipoServicioNorma(TipoServicioNorma entity)
			throws Exception {
		tipoServicioNormaLogic.updateTipoServicioNorma(entity);
	}

	public TipoServicioNorma getTipoServicioNorma(Integer idTipoServicioNorma)
			throws Exception {
		TipoServicioNorma tipoServicioNorma = null;

		try {
			tipoServicioNorma = tipoServicioNormaLogic.getTipoServicioNorma(idTipoServicioNorma);
		} catch (Exception e) {
			throw e;
		}

		return tipoServicioNorma;
	}

	public List<TipoServicioNorma> findByCriteriaInTipoServicioNorma(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoServicioNormaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<TipoServicioNorma> findPageTipoServicioNorma(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoServicioNormaLogic.findPageTipoServicioNorma(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoServicioNorma() throws Exception {
		return tipoServicioNormaLogic.findTotalNumberTipoServicioNorma();
	}

	public List<TipoServicioNormaDTO> getDataTipoServicioNorma()
			throws Exception {
		return tipoServicioNormaLogic.getDataTipoServicioNorma();
	}

	public void validateTipoServicioNorma(TipoServicioNorma tipoServicioNorma)
			throws Exception {
		tipoServicioNormaLogic.validateTipoServicioNorma(tipoServicioNorma);
	}

	public List<Usuario> getUsuario() throws Exception {
		return usuarioLogic.getUsuario();
	}

	public void saveUsuario(Usuario entity) throws Exception {
		usuarioLogic.saveUsuario(entity);
	}

	public void deleteUsuario(Usuario entity) throws Exception {
		usuarioLogic.deleteUsuario(entity);
	}

	public void updateUsuario(Usuario entity) throws Exception {
		usuarioLogic.updateUsuario(entity);
	}

	public Usuario getUsuario(Integer idUsuario) throws Exception {
		Usuario usuario = null;

		try {
			usuario = usuarioLogic.getUsuario(idUsuario);
		} catch (Exception e) {
			throw e;
		}

		return usuario;
	}

	public List<Usuario> findByCriteriaInUsuario(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		return usuarioLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Usuario> findPageUsuario(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberUsuario() throws Exception {
		return usuarioLogic.findTotalNumberUsuario();
	}

	public List<UsuarioDTO> getDataUsuario() throws Exception {
		return usuarioLogic.getDataUsuario();
	}

	public void validateUsuario(Usuario usuario) throws Exception {
		usuarioLogic.validateUsuario(usuario);
	}
	
	public List<ValorDato> getValorDato()
			throws Exception {
		return valorDatoLogic.getValorDato();
	}

	public void saveValorDato(ValorDato entity)
			throws Exception {
		valorDatoLogic.saveValorDato(entity);
	}

	public void deleteValorDato(ValorDato entity)
			throws Exception {
		valorDatoLogic.deleteValorDato(entity);
	}

	public void updateValorDato(ValorDato entity)
			throws Exception {
		valorDatoLogic.updateValorDato(entity);
	}

	public ValorDato getValorDato(
			Integer idValorDato) throws Exception {
		ValorDato ValorDato = null;

		try {
			ValorDato = valorDatoLogic.getValorDato(idValorDato);
		} catch (Exception e) {
			throw e;
		}

		return ValorDato;
	}

	public List<ValorDato> findByCriteriaInValorDato(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return valorDatoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ValorDato> findPageValorDato(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return valorDatoLogic.findPageValorDato(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberValorDato() throws Exception {
		return valorDatoLogic.findTotalNumberValorDato();
	}

	public List<ValorDatoDTO> getDataValorDato()
			throws Exception {
		return valorDatoLogic.getDataValorDato();
	}

	public void validateValorDato(
			ValorDato valorDato) throws Exception {
		valorDatoLogic.validateValorDato(valorDato);
	}
	
	public List<ValorCampo> getValorCampo()
			throws Exception {
		return valorCampoLogic.getValorCampo();
	}

	public void saveValorCampo(ValorCampo entity)
			throws Exception {
		valorCampoLogic.saveValorCampo(entity);
	}

	public void deleteValorCampo(ValorCampo entity)
			throws Exception {
		valorCampoLogic.deleteValorCampo(entity);
	}

	public void updateValorCampo(ValorCampo entity)
			throws Exception {
		valorCampoLogic.updateValorCampo(entity);
	}

	public ValorCampo getValorCampo(
			Integer idValorCampo) throws Exception {
		ValorCampo ValorCampo = null;

		try {
			ValorCampo = valorCampoLogic.getValorCampo(idValorCampo);
		} catch (Exception e) {
			throw e;
		}

		return ValorCampo;
	}

	public List<ValorCampo> findByCriteriaInValorCampo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return valorCampoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ValorCampo> findPageValorCampo(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return valorCampoLogic.findPageValorCampo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberValorCampo() throws Exception {
		return valorCampoLogic.findTotalNumberValorCampo();
	}

	public List<ValorCampoDTO> getDataValorCampo()
			throws Exception {
		return valorCampoLogic.getDataValorCampo();
	}

	public void validateValorCampo(
			ValorCampo valorCampo) throws Exception {
		valorCampoLogic.validateValorCampo(valorCampo);
	}


	public void upload(FileUploadEvent event, EstablecimientoObjetivo establecimientoObjetivo) throws Exception {
		fileController.upload(event, establecimientoObjetivo);
	}

	public void copyFile(String fileName, InputStream in) throws Exception {
		fileController.copyFile(fileName, in);
	}

	public Objetivo findObjetivoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) throws Exception {
		return objetivoLogic.findObjetivoByEstablecimientoObjetivoId(idEstablecimientoObjetivo);
	}

	public Establecimiento findEstablecimientoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) throws Exception {
		return establecimientoLogic.findEstablecimientoByEstablecimientoObjetivoId(idEstablecimientoObjetivo);
	}

	public Usuario findUsuarioByEmail(String email) throws Exception {
		return usuarioLogic.findUsuarioByEmail(email);
	}

	public TipoServicio findTipoServicioByEstablecimientoId(Integer idEstablecimiento)
			throws Exception {
		return tipoServicioLogic.findTipoServicioByEstablecimientoId(idEstablecimiento);
	}

	public TipoServicioDTO tipoServicioToTipoServicioDTO(TipoServicio tipoServicio) throws Exception {
		return tipoServicioLogic.tipoServicioToTipoServicioDTO(tipoServicio);
	}

	public Requisito findRequisitoByObjetivoId(Integer idObjetivo) throws Exception {
		return requisitoLogic.findRequisitoByObjetivoId(idObjetivo);
	}

	public ObjetivoDTO objetivoToObjetivoDTO(Objetivo objetivo) throws Exception {
		return objetivoLogic.objetivoToObjetivoDTO(objetivo);
	}

	public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(
			Integer idProyectoEstablecimiento, Integer idObjetivo) throws Exception {
		return establecimientoObjetivoLogic.findEstablecimientoObjetivoByIds(idProyectoEstablecimiento, idObjetivo);
	}

	public List<ProyectoEstablecimiento> getProyectoEstablecimientoByEstablecimientoId(
			Integer idEstablecimiento) throws Exception {
		return proyectoEstablecimientoLogic.getProyectoEstablecimientoByEstablecimientoId(idEstablecimiento);
	}
	
	public List<Norma> findNormasByTipoServicioId(Integer idTipoServicio) throws Exception {
		return normaLogic.findNormasByTipoServicioId(idTipoServicio);
	}
	
	public List<Programa> findProgramasByProyectoId(Integer idProyecto)
	        throws Exception {
		return programaLogic.findProgramasByProyectoId(idProyecto);
	}
	
	public List<EstablecimientoObjetivo> getEstablecimientoObjetivosByProgramaId(
			Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception {
		return establecimientoObjetivoLogic.getEstablecimientoObjetivosByProgramaId(idPrograma, idProyectoEstablecimiento);
	}
	
	public Double getProgramaProgressPercentage(Integer idPrograma,
    		Integer idProyectoEstablecimiento) throws Exception {
		return programaLogic.getProgramaProgressPercentage(idPrograma, idProyectoEstablecimiento);
	}
	
	public CategoriaPrograma getCategoriaProgramaByProgramaId(Integer idPrograma)
	        throws Exception {
		return categoriaProgramaLogic.getCategoriaProgramaByProgramaId(idPrograma);
	}
	
	public List<ProgramaDTO> getDetailDataProgramaByProyectoEstablecimientoId(
    		Integer idProyectoEstablecimiento) throws Exception {
		return programaLogic.getDetailDataProgramaByProyectoEstablecimientoId(idProyectoEstablecimiento);
	}
	
	public Proyecto findProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento) throws Exception {
		return proyectoLogic.findProyectoByProyectoEstablecimientoId(idProyectoEstablecimiento);
	}
	
	public Double getProyectoEstablecimeintoProgress(Integer idProyectoEstablecimiento) throws Exception {
		return proyectoEstablecimientoLogic.getProyectoEstablecimeintoProgress(idProyectoEstablecimiento);
	}
	
	public List<ProyectoEstablecimientoDTO> getProyectoEstablecimientoDTOByEstablecimientoId(
    		Integer idEstablecimiento) throws Exception {
		return proyectoEstablecimientoLogic.getProyectoEstablecimientoDTOByEstablecimientoId(idEstablecimiento);
	}
	
	public EstadoObjetivo findEstadoObjetivoByEstablecimientoObjetivoId(Integer idEstablecimientoObjetivo)
	    	throws Exception {
		return estadoObjetivoLogic.findEstadoObjetivoByEstablecimientoObjetivoId(idEstablecimientoObjetivo);
	}
	
	public List<ObjetivoDTO> findObjetivoDataByEstadoDescripcion(String descripcionEstado,
    		Integer idProyectoEstablecimiento) throws Exception {
		return objetivoLogic.findObjetivoDataByEstadoDescripcion(descripcionEstado, idProyectoEstablecimiento);
	}
	
	public EstadoProyecto findEstadoProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception {
		return estadoProyectoLogic.findEstadoProyectoByProyectoEstablecimientoId(idProyectoEstablecimiento);
	}
	
	public Norma findNormaByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception {
		return normaLogic.findNormaByProyectoEstablecimientoId(idProyectoEstablecimiento);
	}
	
	public List<Objetivo> findObjetivosByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
			throws Exception {
		return objetivoLogic.findObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);
	}
	
	public List<ObjetivoDTO> findObjetivosByEstadoDescripcionProgramaId(String descripcionEstado, 
    		Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception {
		return objetivoLogic.findObjetivosByEstadoDescripcionProgramaId(descripcionEstado,
				idPrograma, idProyectoEstablecimiento);
	}
	
	public List<ObjetivoDTO> findObjetivosByProgramaId(Integer idPrograma, Integer idProyectoEstablecimiento)
    		throws Exception {
		return objetivoLogic.findObjetivosByProgramaId(idPrograma, idProyectoEstablecimiento);
	}
	
    public EstadoObjetivo findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(Integer idProyectoEstablecimiento,
    		Integer idObjtivo) throws Exception {
    	return estadoObjetivoLogic.findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(
    			idProyectoEstablecimiento, idObjtivo);
    }
    
    public List<RequisitoDTO> findRequisitoByNormaId(Integer idNorma) throws Exception {
    	return requisitoLogic.findRequisitoByNormaId(idNorma);
    }
    
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception {
    	return normaLogic.normaToNormaDTO(norma);
    }
    
    public RequisitoDTO requisitoToRequisitoDTO(Requisito requisito) throws Exception {
    	return requisitoLogic.requisitoToRequisitoDTO(requisito);
    }
    
    public Objetivo findObjetivoByRequisitoId(int idRequisito) 
        	throws Exception {
    	return objetivoLogic.findObjetivoByRequisitoId(idRequisito);
    }
    
    public Norma findNormaByRequisitoId(Integer idRequisito) throws Exception {
    	return normaLogic.findNormaByRequisitoId(idRequisito);
    }
    
    public List<DatoObjetivo> findDatoObjetivosByObjetivoId(Integer idObjetivo)
            throws Exception {
    	return datoObjetivoLogic.findDatoObjetivosByObjetivoId(idObjetivo);
    }
    
	public List<CampoRegistro> findCampoRegistrosByDatoObjetivoId(Integer idDatoObjetivo) throws Exception {
		return campoRegistroLogic.findCampoRegistrosByDatoObjetivoId(idDatoObjetivo);
	}

	public CampoRegistro findCampoRegistroByValorCampoId(Integer idValorCampo) throws Exception {
		return campoRegistroLogic.findCampoRegistroByValorCampoId(idValorCampo);
	}

	public List<CampoRegistroDTO> listCampoRegistroToListCampoRegistroDTO(List<CampoRegistro> campoRegistros)
			throws Exception {
		return campoRegistroLogic.listCampoRegistroToListCampoRegistroDTO(campoRegistros);
	}

	public void deleteRegistroDatoFull(RegistroDato entity) throws Exception {
		registroDatoLogic.deleteRegistroDatoFull(entity);
	}

	public List<RegistroDatoDTO> listRegistroDatoToListRegistroDatoDTO(List<RegistroDato> registroDatos)
			throws Exception {
		return registroDatoLogic.listRegistroDatoToListRegistroDatoDTO(registroDatos);
	}

	public List<RegistroDato> findRegistroDatosByIds(Integer establecimientoObjetivoId, Integer idDatoObjetivo)
			throws Exception {
		return registroDatoLogic.findRegistroDatosByIds(establecimientoObjetivoId, idDatoObjetivo);
	}

	public List<ValorCampo> findValorCamposByRegistroDatoId(Integer idRegistroDato) throws Exception {
		return valorCampoLogic.findValorCamposByRegistroDatoId(idRegistroDato);
	}

	public List<ValorCampoDTO> listValorCampoToListValorCampoDTO(List<ValorCampo> valorCampos) throws Exception {
		return valorCampoLogic.listValorCampoToListValorCampoDTO(valorCampos);
	}

	public List<ValorDato> findValorDatosByIds(Integer establecimientoObjetivoId, Integer idDatoObjetivo)
			throws Exception {
		return valorDatoLogic.findValorDatosByIds(establecimientoObjetivoId, idDatoObjetivo);
	}

	public List<ValorDatoDTO> listValorDatoToListValorDatoDTO(List<ValorDato> valorDatos) throws Exception {
		return valorDatoLogic.listValorDatoToListValorDatoDTO(valorDatos);
	}
	
	public CampoRegistroDTO campoRegistroToCampoRegistroDTO(CampoRegistro campoRegistro) throws Exception {
		return campoRegistroLogic.campoRegistroToCampoRegistroDTO(campoRegistro);
	}

	public List<DatoObjetivoDTO> listDatoObjetivoToListDatoObjetivoDTO(List<DatoObjetivo> datoObjetivos)
			throws Exception {
		return datoObjetivoLogic.listDatoObjetivoToListDatoObjetivoDTO(datoObjetivos);
	}
	
	public ValorCampoDTO valorCampoToValorCampoDTO(ValorCampo valorCampo)
	        throws Exception {
		return valorCampoLogic.valorCampoToValorCampoDTO(valorCampo);
	}
	
	public DatoObjetivoDTO datoObjetivoToDatoObjetivoDTO(DatoObjetivo datoObjetivo)
    		throws Exception {
		return datoObjetivoLogic.datoObjetivoToDatoObjetivoDTO(datoObjetivo);
	}
	
    public ValorDatoDTO valorDatoToValorDatoDTO(ValorDato valorDatos) 
    		throws Exception {
    	return valorDatoLogic.valorDatoToValorDatoDTO(valorDatos);
    }
    
    public Establecimiento findEstablecimientoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
			throws Exception {
    	return establecimientoLogic.findEstablecimientoByProyectoEstablecimientoId(idProyectoEstablecimiento);
    }
    
    public DatoObjetivo findDatoObjetivoAutoevaluacion(Integer idObjetivo) throws Exception {
    	return datoObjetivoLogic.findDatoObjetivoAutoevaluacion(idObjetivo);
    }
    
    public EstadoObjetivo findEstadoObjetivoByDescripcion(String descripcionEstado) throws Exception {
    	return estadoObjetivoLogic.findEstadoObjetivoByDescripcion(descripcionEstado);
    }
    
    public File[] getDirectoryFiles(EstablecimientoObjetivo establecimientoObjetivo) 
			throws Exception {
    	return fileController.getDirectoryFiles(establecimientoObjetivo);
    }
    
    public boolean deleteObjetivoFile(File file) throws Exception {
    	return fileController.deleteObjetivoFile(file);
    }
    
    public StreamedContent download(File file) throws Exception {
    	return fileController.download(file);
    }
    
    public void deleteAllObjetivoFile(EstablecimientoObjetivo establecimientoObjetivo) throws Exception {
    	fileController.deleteAllObjetivoFile(establecimientoObjetivo);
    }
    
    public List<RequisitoDTO> findRequisitosDTOByEstadoObjetivoDescripcion(String descripcionEstado,
    		Integer idProyectoEstablecimiento) throws Exception {
    	return requisitoLogic.findRequisitosDTOByEstadoObjetivoDescripcion(descripcionEstado, idProyectoEstablecimiento);
    }
    
    public Proyecto findProyectoByNormaId(Integer idNorma) throws Exception {
    	return proyectoLogic.findProyectoByNormaId(idNorma);
    }
    
    public EstadoProyecto findEstadoProyectoByDescripcion(String descripcionEstado)
    		throws Exception {
    	return estadoProyectoLogic.findEstadoProyectoByDescripcion(descripcionEstado);
    }
    
    public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
    		ProyectoEstablecimiento proyectoEstablecimiento) throws Exception {
    	return proyectoEstablecimientoLogic.proyectoEstablecimientoToProyectoEstablecimientoDTO(proyectoEstablecimiento);
    }
    
    public boolean isOtherSameProyectoInExecution(Integer idEstablecimiento, Integer idNorma)
    		throws Exception {
    	return proyectoEstablecimientoLogic.isOtherSameProyectoInExecution(idEstablecimiento, idNorma);
    }
    
    public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId
	(Integer idProyectoEstablecimiento) throws Exception {
    	return establecimientoObjetivoLogic.findEstablecimientoObjetivosByProyectoEstablecimientoId(idProyectoEstablecimiento);
    }
    
    public boolean isProyectoStateFinished(Integer idProyectoEstablecimiento) throws Exception {
    	return proyectoEstablecimientoLogic.isProyectoStateFinished(idProyectoEstablecimiento);
    }
    
    public void resetAllNewEstablecimientoObjetivoEstado(Integer idProyectoEstablecimiento) throws Exception {
    	establecimientoObjetivoLogic.resetAllNewEstablecimientoObjetivoEstado(idProyectoEstablecimiento);
    }
    
    public void finishProyectoEstado (Integer idProyectoEstablecimiento) throws Exception {
    	proyectoEstablecimientoLogic.finishProyectoEstado(idProyectoEstablecimiento);
    }
    
    public EstablecimientoDTO establecimientoToEstablecimientoDTO(Establecimiento establecimiento) throws Exception {
    	return establecimientoLogic.establecimientoToEstablecimientoDTO(establecimiento);
    }
}
