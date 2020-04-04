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
import co.com.technicalnormsoft.model.control.CampoRegistroLogic;
import co.com.technicalnormsoft.model.control.CategoriaProgramaLogic;
import co.com.technicalnormsoft.model.control.CategoriaRequisitoLogic;
import co.com.technicalnormsoft.model.control.DatoObjetivoLogic;
import co.com.technicalnormsoft.model.control.EstablecimientoLogic;
import co.com.technicalnormsoft.model.control.EstablecimientoObjetivoLogic;
import co.com.technicalnormsoft.model.control.EstadoObjetivoLogic;
import co.com.technicalnormsoft.model.control.EstadoProyectoLogic;
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
import co.com.technicalnormsoft.model.control.IUsuarioLogic;
import co.com.technicalnormsoft.model.control.MedallaEstablecimientoLogic;
import co.com.technicalnormsoft.model.control.MedallaLogic;
import co.com.technicalnormsoft.model.control.NormaLogic;
import co.com.technicalnormsoft.model.control.ObjetivoLogic;
import co.com.technicalnormsoft.model.control.ProgramaLogic;
import co.com.technicalnormsoft.model.control.ProyectoEstablecimientoLogic;
import co.com.technicalnormsoft.model.control.ProyectoLogic;
import co.com.technicalnormsoft.model.control.RegistroDatoLogic;
import co.com.technicalnormsoft.model.control.RequisitoLogic;
import co.com.technicalnormsoft.model.control.TipoServicioLogic;
import co.com.technicalnormsoft.model.control.UsuarioLogic;
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
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author Silicon Cali
 * 
 *
 */
public interface IBusinessDelegatorView {
	public List<CampoRegistro> getCampoRegistro() throws Exception;

	public void saveCampoRegistro(CampoRegistro entity)
			throws Exception;

	public void deleteCampoRegistro(CampoRegistro entity)
			throws Exception;

	public void updateCampoRegistro(CampoRegistro entity)
			throws Exception;

	public CampoRegistro getCampoRegistro(Integer idCampoRegistro)
			throws Exception;

	public List<CampoRegistro> findByCriteriaInCampoRegistro(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CampoRegistro> findPageCampoRegistro(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberCampoRegistro() throws Exception;

	public List<CampoRegistroDTO> getDataCampoRegistro()
			throws Exception;

	public void validateCampoRegistro(CampoRegistro campoRegistro)
			throws Exception;

	public List<CategoriaPrograma> getCategoriaPrograma()
			throws Exception;

	public void saveCategoriaPrograma(CategoriaPrograma entity)
			throws Exception;

	public void deleteCategoriaPrograma(CategoriaPrograma entity)
			throws Exception;

	public void updateCategoriaPrograma(CategoriaPrograma entity)
			throws Exception;

	public CategoriaPrograma getCategoriaPrograma(Integer idCategoriaPrograma)
			throws Exception;

	public List<CategoriaPrograma> findByCriteriaInCategoriaPrograma(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CategoriaPrograma> findPageCategoriaPrograma(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCategoriaPrograma() throws Exception;

	public List<CategoriaProgramaDTO> getDataCategoriaPrograma()
			throws Exception;

	public void validateCategoriaPrograma(CategoriaPrograma categoriaPrograma)
			throws Exception;

	public List<CategoriaRequisito> getCategoriaRequisito()
			throws Exception;

	public void saveCategoriaRequisito(CategoriaRequisito entity)
			throws Exception;

	public void deleteCategoriaRequisito(CategoriaRequisito entity)
			throws Exception;

	public void updateCategoriaRequisito(CategoriaRequisito entity)
			throws Exception;

	public CategoriaRequisito getCategoriaRequisito(
			Integer idCategoriaRequisito) throws Exception;

	public List<CategoriaRequisito> findByCriteriaInCategoriaRequisito(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CategoriaRequisito> findPageCategoriaRequisito(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCategoriaRequisito() throws Exception;

	public List<CategoriaRequisitoDTO> getDataCategoriaRequisito()
			throws Exception;

	public void validateCategoriaRequisito(
			CategoriaRequisito categoriaRequisito) throws Exception;

	public List<DatoObjetivo> getDatoObjetivo() throws Exception;

	public void saveDatoObjetivo(DatoObjetivo entity) throws Exception;

	public void deleteDatoObjetivo(DatoObjetivo entity)
			throws Exception;

	public void updateDatoObjetivo(DatoObjetivo entity)
			throws Exception;

	public DatoObjetivo getDatoObjetivo(Integer idDatoObjetivo)
			throws Exception;

	public List<DatoObjetivo> findByCriteriaInDatoObjetivo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<DatoObjetivo> findPageDatoObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberDatoObjetivo() throws Exception;

	public List<DatoObjetivoDTO> getDataDatoObjetivo()
			throws Exception;

	public void validateDatoObjetivo(DatoObjetivo datoObjetivo)
			throws Exception;

	public List<Establecimiento> getEstablecimiento() throws Exception;

	public void saveEstablecimiento(Establecimiento entity)
			throws Exception;

	public void deleteEstablecimiento(Establecimiento entity)
			throws Exception;

	public void updateEstablecimiento(Establecimiento entity)
			throws Exception;

	public Establecimiento getEstablecimiento(Integer idEstablecimiento)
			throws Exception;

	public List<Establecimiento> findByCriteriaInEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Establecimiento> findPageEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstablecimiento() throws Exception;

	public List<EstablecimientoDTO> getDataEstablecimiento()
			throws Exception;

	public void validateEstablecimiento(Establecimiento establecimiento)
			throws Exception;

	public List<EstablecimientoObjetivo> getEstablecimientoObjetivo()
			throws Exception;

	public void saveEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception;

	public void deleteEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception;

	public void updateEstablecimientoObjetivo(EstablecimientoObjetivo entity)
			throws Exception;

	public EstablecimientoObjetivo getEstablecimientoObjetivo(
			Integer idUsuarioObjetivo) throws Exception;

	public List<EstablecimientoObjetivo> findByCriteriaInEstablecimientoObjetivo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstablecimientoObjetivo> findPageEstablecimientoObjetivo(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstablecimientoObjetivo()
			throws Exception;

	public List<EstablecimientoObjetivoDTO> getDataEstablecimientoObjetivo()
			throws Exception;

	public void validateEstablecimientoObjetivo(
			EstablecimientoObjetivo establecimientoObjetivo)
					throws Exception;

	public List<EstadoObjetivo> getEstadoObjetivo() throws Exception;

	public void saveEstadoObjetivo(EstadoObjetivo entity)
			throws Exception;

	public void deleteEstadoObjetivo(EstadoObjetivo entity)
			throws Exception;

	public void updateEstadoObjetivo(EstadoObjetivo entity)
			throws Exception;

	public EstadoObjetivo getEstadoObjetivo(Integer idEstado)
			throws Exception;

	public List<EstadoObjetivo> findByCriteriaInEstadoObjetivo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstadoObjetivo> findPageEstadoObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberEstadoObjetivo() throws Exception;

	public List<EstadoObjetivoDTO> getDataEstadoObjetivo()
			throws Exception;

	public void validateEstadoObjetivo(EstadoObjetivo estadoObjetivo)
			throws Exception;

	public List<EstadoProyecto> getEstadoProyecto() throws Exception;

	public void saveEstadoProyecto(EstadoProyecto entity)
			throws Exception;

	public void deleteEstadoProyecto(EstadoProyecto entity)
			throws Exception;

	public void updateEstadoProyecto(EstadoProyecto entity)
			throws Exception;

	public EstadoProyecto getEstadoProyecto(Integer idEstadoProyecto)
			throws Exception;

	public List<EstadoProyecto> findByCriteriaInEstadoProyecto(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstadoProyecto> findPageEstadoProyecto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberEstadoProyecto() throws Exception;

	public List<EstadoProyectoDTO> getDataEstadoProyecto()
			throws Exception;

	public void validateEstadoProyecto(EstadoProyecto estadoProyecto)
			throws Exception;

	public List<Medalla> getMedalla() throws Exception;

	public void saveMedalla(Medalla entity) throws Exception;

	public void deleteMedalla(Medalla entity) throws Exception;

	public void updateMedalla(Medalla entity) throws Exception;

	public Medalla getMedalla(Integer idMedalla) throws Exception;

	public List<Medalla> findByCriteriaInMedalla(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Medalla> findPageMedalla(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberMedalla() throws Exception;

	public List<MedallaDTO> getDataMedalla() throws Exception;

	public void validateMedalla(Medalla medalla) throws Exception;

	public List<MedallaEstablecimiento> getMedallaEstablecimiento()
			throws Exception;

	public void saveMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception;

	public void deleteMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception;

	public void updateMedallaEstablecimiento(MedallaEstablecimiento entity)
			throws Exception;

	public MedallaEstablecimiento getMedallaEstablecimiento(
			Integer idMedallaEstablecimiento) throws Exception;

	public List<MedallaEstablecimiento> findByCriteriaInMedallaEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MedallaEstablecimiento> findPageMedallaEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMedallaEstablecimiento()
			throws Exception;

	public List<MedallaEstablecimientoDTO> getDataMedallaEstablecimiento()
			throws Exception;

	public void validateMedallaEstablecimiento(
			MedallaEstablecimiento medallaEstablecimiento)
					throws Exception;

	public List<Norma> getNorma() throws Exception;

	public void saveNorma(Norma entity) throws Exception;

	public void deleteNorma(Norma entity) throws Exception;

	public void updateNorma(Norma entity) throws Exception;

	public Norma getNorma(Integer idNorma) throws Exception;

	public List<Norma> findByCriteriaInNorma(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Norma> findPageNorma(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberNorma() throws Exception;

	public List<NormaDTO> getDataNorma() throws Exception;

	public void validateNorma(Norma norma) throws Exception;

	public List<Objetivo> getObjetivo() throws Exception;

	public void saveObjetivo(Objetivo entity) throws Exception;

	public void deleteObjetivo(Objetivo entity) throws Exception;

	public void updateObjetivo(Objetivo entity) throws Exception;

	public Objetivo getObjetivo(Integer idObjetivo) throws Exception;

	public List<Objetivo> findByCriteriaInObjetivo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Objetivo> findPageObjetivo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberObjetivo() throws Exception;

	public List<ObjetivoDTO> getDataObjetivo() throws Exception;

	public void validateObjetivo(Objetivo objetivo) throws Exception;

	public List<Programa> getPrograma() throws Exception;

	public void savePrograma(Programa entity) throws Exception;

	public void deletePrograma(Programa entity) throws Exception;

	public void updatePrograma(Programa entity) throws Exception;

	public Programa getPrograma(Integer idPrograma) throws Exception;

	public List<Programa> findByCriteriaInPrograma(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Programa> findPagePrograma(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberPrograma() throws Exception;

	public List<ProgramaDTO> getDataPrograma() throws Exception;

	public void validatePrograma(Programa programa) throws Exception;

	public List<Proyecto> getProyecto() throws Exception;

	public void saveProyecto(Proyecto entity) throws Exception;

	public void deleteProyecto(Proyecto entity) throws Exception;

	public void updateProyecto(Proyecto entity) throws Exception;

	public Proyecto getProyecto(Integer idProyecto) throws Exception;

	public List<Proyecto> findByCriteriaInProyecto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Proyecto> findPageProyecto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberProyecto() throws Exception;

	public List<ProyectoDTO> getDataProyecto() throws Exception;

	public void validateProyecto(Proyecto proyecto) throws Exception;

	public List<ProyectoEstablecimiento> getProyectoEstablecimiento()
			throws Exception;

	public void saveProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception;

	public void deleteProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception;

	public void updateProyectoEstablecimiento(ProyectoEstablecimiento entity)
			throws Exception;

	public ProyectoEstablecimiento getProyectoEstablecimiento(
			Integer idProyectoEstablecimiento) throws Exception;

	public List<ProyectoEstablecimiento> findByCriteriaInProyectoEstablecimiento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ProyectoEstablecimiento> findPageProyectoEstablecimiento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberProyectoEstablecimiento()
			throws Exception;

	public List<ProyectoEstablecimientoDTO> getDataProyectoEstablecimiento()
			throws Exception;

	public void validateProyectoEstablecimiento(
			ProyectoEstablecimiento proyectoEstablecimiento)
					throws Exception;

	public List<RegistroDato> getRegistroDato() throws Exception;

	public void saveRegistroDato(RegistroDato entity) throws Exception;

	public void deleteRegistroDato(RegistroDato entity)
			throws Exception;

	public void updateRegistroDato(RegistroDato entity)
			throws Exception;

	public RegistroDato getRegistroDato(Integer idRegistroDato)
			throws Exception;

	public List<RegistroDato> findByCriteriaInRegistroDato(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<RegistroDato> findPageRegistroDato(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberRegistroDato() throws Exception;

	public List<RegistroDatoDTO> getDataRegistroDato()
			throws Exception;

	public void validateRegistroDato(RegistroDato registroDato)
			throws Exception;

	public List<Requisito> getRequisito() throws Exception;

	public void saveRequisito(Requisito entity) throws Exception;

	public void deleteRequisito(Requisito entity) throws Exception;

	public void updateRequisito(Requisito entity) throws Exception;

	public Requisito getRequisito(Integer idRequisito)
			throws Exception;

	public List<Requisito> findByCriteriaInRequisito(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Requisito> findPageRequisito(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberRequisito() throws Exception;

	public List<RequisitoDTO> getDataRequisito() throws Exception;

	public void validateRequisito(Requisito requisito)
			throws Exception;

	public List<TipoServicio> getTipoServicio() throws Exception;

	public void saveTipoServicio(TipoServicio entity) throws Exception;

	public void deleteTipoServicio(TipoServicio entity)
			throws Exception;

	public void updateTipoServicio(TipoServicio entity)
			throws Exception;

	public TipoServicio getTipoServicio(Integer idTipoServicio)
			throws Exception;

	public List<TipoServicio> findByCriteriaInTipoServicio(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<TipoServicio> findPageTipoServicio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberTipoServicio() throws Exception;

	public List<TipoServicioDTO> getDataTipoServicio()
			throws Exception;

	public void validateTipoServicio(TipoServicio tipoServicio)
			throws Exception;
	
	public List<TipoServicioNorma> getTipoServicioNorma()
			throws Exception;

	public void saveTipoServicioNorma(TipoServicioNorma entity)
			throws Exception;

	public void deleteTipoServicioNorma(TipoServicioNorma entity)
			throws Exception;

	public void updateTipoServicioNorma(TipoServicioNorma entity)
			throws Exception;

	public TipoServicioNorma getTipoServicioNorma(Integer idTipoServicioNorma)
			throws Exception;

	public List<TipoServicioNorma> findByCriteriaInTipoServicioNorma(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoServicioNorma> findPageTipoServicioNorma(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoServicioNorma() throws Exception;

	public List<TipoServicioNormaDTO> getDataTipoServicioNorma()
			throws Exception;

	public void validateTipoServicioNorma(TipoServicioNorma tipoServicioNorma)
			throws Exception;

	public List<Usuario> getUsuario() throws Exception;

	public void saveUsuario(Usuario entity) throws Exception;

	public void deleteUsuario(Usuario entity) throws Exception;

	public void updateUsuario(Usuario entity) throws Exception;

	public Usuario getUsuario(Integer idUsuario) throws Exception;

	public List<Usuario> findByCriteriaInUsuario(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception;

	public List<Usuario> findPageUsuario(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception;

	public Long findTotalNumberUsuario() throws Exception;

	public List<UsuarioDTO> getDataUsuario() throws Exception;

	public void validateUsuario(Usuario usuario) throws Exception;
	

	public List<ValorDato> getValorDato() throws Exception;

	public void saveValorDato(ValorDato entity) throws Exception;

	public void deleteValorDato(ValorDato entity)
		throws Exception;

	public void updateValorDato(ValorDato entity) throws Exception;

	public ValorDato getValorDato(Integer idValorDato) 
		throws Exception;

	public List<ValorDato> findByCriteriaInValorDato(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ValorDato> findPageValorDato(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberValorDato() throws Exception;

	public List<ValorDatoDTO> getDataValorDato()
		throws Exception;

	public void validateValorDato(ValorDato valorDato) 
		throws Exception;
	
	public List<ValorCampo> getValorCampo() throws Exception;

	public void saveValorCampo(ValorCampo entity) throws Exception;

	public void deleteValorCampo(ValorCampo entity) throws Exception;

	public void updateValorCampo(ValorCampo entity) throws Exception;

	public ValorCampo getValorCampo(
			Integer idValorCampo) throws Exception;

	public List<ValorCampo> findByCriteriaInValorCampo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ValorCampo> findPageValorCampo(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;
	
	public Long findTotalNumberValorCampo() throws Exception;

	public List<ValorCampoDTO> getDataValorCampo() throws Exception;

	public void validateValorCampo(ValorCampo valorCampo) throws Exception;

	public void upload(FileUploadEvent event, EstablecimientoObjetivo establecimientoObjetivo) throws Exception;

	public void copyFile(String fileName, InputStream in) throws Exception;

	public Objetivo findObjetivoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) 
			throws Exception;

	public Establecimiento findEstablecimientoByEstablecimientoObjetivoId(int idEstablecimientoObjetivo) 
			throws Exception;

	public Usuario findUsuarioByEmail(String email) throws Exception;

	public TipoServicio findTipoServicioByEstablecimientoId(Integer idEstablecimiento)
			throws Exception;

	public TipoServicioDTO tipoServicioToTipoServicioDTO(TipoServicio tipoServicio) 
			throws Exception;

	public Requisito findRequisitoByObjetivoId(Integer idObjetivo)
			throws Exception;
	
	public ObjetivoDTO objetivoToObjetivoDTO(Objetivo objetivo)
			throws Exception;
	
	public EstablecimientoObjetivo findEstablecimientoObjetivoByIds(
	    	Integer idProyectoEstablecimiento, Integer idObjetivo) throws Exception;
    
    public List<ProyectoEstablecimiento> getProyectoEstablecimientoByEstablecimientoId(
    		Integer idEstablecimiento) throws Exception;
    
    public List<Norma> findNormasByTipoServicioId(Integer idTipoServicio) throws Exception;
    
    public List<Programa> findProgramasByProyectoId(Integer idProyecto)
            throws Exception;
    
    public List<EstablecimientoObjetivo> getEstablecimientoObjetivosByProgramaId(
			Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception;
    
    public Double getProgramaProgressPercentage(Integer idPrograma,
    		Integer idProyectoEstablecimiento) throws Exception;
    
    public CategoriaPrograma getCategoriaProgramaByProgramaId(Integer idPrograma)
	        throws Exception;
    
    public Proyecto findProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento) 
    		throws Exception;
    
    public List<ProgramaDTO> getDetailDataProgramaByProyectoEstablecimientoId(
    		Integer idProyectoEstablecimiento) throws Exception; 
    
    public Double getProyectoEstablecimeintoProgress(Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public List<ProyectoEstablecimientoDTO> getProyectoEstablecimientoDTOByEstablecimientoId(
    		Integer idEstablecimiento) throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByEstablecimientoObjetivoId(Integer idEstablecimientoObjetivo)
	    	throws Exception;
    
    public List<ObjetivoDTO> findObjetivoDataByEstadoDescripcion(String descripcionEstado,
    		Integer idProyectoEstablecimiento) throws Exception;
    
    public EstadoProyecto findEstadoProyectoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public Norma findNormaByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public List<Objetivo> findObjetivosByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public List<ObjetivoDTO> findObjetivosByEstadoDescripcionProgramaId(String descripcionEstado, 
    		Integer idPrograma, Integer idProyectoEstablecimiento) throws Exception;
    
    public List<ObjetivoDTO> findObjetivosByProgramaId(Integer idPrograma, Integer idProyectoEstablecimiento)
    		throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(Integer idProyectoEstablecimiento,
    		Integer idObjtivo) throws Exception;
    
    public List<RequisitoDTO> findRequisitoByNormaId(Integer idNorma) throws Exception;
    
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception;
    
    public RequisitoDTO requisitoToRequisitoDTO(Requisito requisito) throws Exception;
    
    public Objetivo findObjetivoByRequisitoId(int idRequisito) 
        	throws Exception;
    
    public Norma findNormaByRequisitoId(Integer idRequisito) throws Exception;
    
    public List<DatoObjetivo> findDatoObjetivosByObjetivoId(Integer idObjetivo)
            throws Exception;
    
    public List<CampoRegistro> findCampoRegistrosByDatoObjetivoId(Integer idDatoObjetivo)
    		throws Exception;
    
    public CampoRegistro findCampoRegistroByValorCampoId(Integer idValorCampo)
            throws Exception;
    
    public List<CampoRegistroDTO> listCampoRegistroToListCampoRegistroDTO(List<CampoRegistro> campoRegistros)
            throws Exception;
    
    public void deleteRegistroDatoFull(RegistroDato entity)
            throws Exception;
    
    public List<RegistroDatoDTO> listRegistroDatoToListRegistroDatoDTO(List<RegistroDato> registroDatos)
            throws Exception;
    
    public List<RegistroDato> findRegistroDatosByIds(Integer establecimientoObjetivoId,
    		Integer idDatoObjetivo) throws Exception;
    
    public List<ValorCampo> findValorCamposByRegistroDatoId(Integer idRegistroDato) 
    		throws Exception;
    
    public List<ValorCampoDTO> listValorCampoToListValorCampoDTO(List<ValorCampo> valorCampos) 
    		throws Exception;
    
    public List<ValorDato> findValorDatosByIds(Integer establecimientoObjetivoId,
    		Integer idDatoObjetivo) throws Exception;
    
    public List<ValorDatoDTO> listValorDatoToListValorDatoDTO(List<ValorDato> valorDatos) 
    		throws Exception;
    
    public CampoRegistroDTO campoRegistroToCampoRegistroDTO(CampoRegistro campoRegistro) throws Exception;
    
    public List<DatoObjetivoDTO> listDatoObjetivoToListDatoObjetivoDTO( List<DatoObjetivo> datoObjetivos)
            throws Exception;
    
    public ValorCampoDTO valorCampoToValorCampoDTO(ValorCampo valorCampo)
            throws Exception;
    
    public DatoObjetivoDTO datoObjetivoToDatoObjetivoDTO(DatoObjetivo datoObjetivo)
    		throws Exception;
    
    public ValorDatoDTO valorDatoToValorDatoDTO(ValorDato valorDatos) 
    		throws Exception;
    
    public Establecimiento findEstablecimientoByProyectoEstablecimientoId(Integer idProyectoEstablecimiento)
			throws Exception;
    
    public DatoObjetivo findDatoObjetivoAutoevaluacion(Integer idObjetivo) throws Exception;
    
    public EstadoObjetivo findEstadoObjetivoByDescripcion(String descripcionEstado) throws Exception;
    
    public File[] getDirectoryFiles(EstablecimientoObjetivo establecimientoObjetivo) 
			throws Exception;
    
    public boolean deleteObjetivoFile(File file) throws Exception;
    
    public StreamedContent download(File file) throws Exception;
    
    public void deleteAllObjetivoFile(EstablecimientoObjetivo establecimientoObjetivo) throws Exception;
    
    public List<RequisitoDTO> findRequisitosDTOByEstadoObjetivoDescripcion(String descripcionEstado,
    		Integer idProyectoEstablecimiento) throws Exception;
    
    public Proyecto findProyectoByNormaId(Integer idNorma) throws Exception;
    
    public EstadoProyecto findEstadoProyectoByDescripcion(String descripcionEstado)
    		throws Exception;
    
    public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
    		ProyectoEstablecimiento proyectoEstablecimiento) throws Exception;
    
    public boolean isOtherSameProyectoInExecution(Integer idEstablecimiento, Integer idNorma)
    		throws Exception;
    
    public List<EstablecimientoObjetivo> findEstablecimientoObjetivosByProyectoEstablecimientoId
	(Integer idProyectoEstablecimiento) throws Exception;
    
    public boolean isProyectoStateFinished(Integer idProyectoEstablecimiento) throws Exception;
    
    public void resetAllNewEstablecimientoObjetivoEstado(Integer idProyectoEstablecimiento) throws Exception;
    
    public void finishProyectoEstado (Integer idProyectoEstablecimiento) throws Exception;
    
    public EstablecimientoDTO establecimientoToEstablecimientoDTO(Establecimiento establecimiento) throws Exception;
}
