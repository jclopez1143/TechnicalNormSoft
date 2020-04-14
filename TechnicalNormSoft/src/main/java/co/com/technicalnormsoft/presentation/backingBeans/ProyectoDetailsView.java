package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.ProyectoEstablecimiento;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.FacesUtils;

import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.outputlabel.OutputLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Silicon Cali
 * 
 *
 */
@ManagedBean
@ViewScoped
public class ProyectoDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProyectoDetailsView.class);
	private EstablecimientoDTO selectedEstablecimiento;
	private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
	private NormaDTO selectedNorma;
	private Integer progresoProyecto;
	private List<ProgramaDTO> programasData;
	private List<ObjetivoDTO> objetivosEnCurso;
	private List<RequisitoDTO> requisitoCompletados;
	private EstadoProyecto estadoProyecto;
	private HttpSession httpSession;
	private OutputLabel labelPrueba;
	private boolean showFinishBtn;
	private boolean showTut;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProyectoDetailsView() {
		super();
	}

	@PostConstruct
	public void init() {
		try {
			httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			action_set_details();
		} catch (Exception e) {
		}
	}

	public String action_set_details() {
		try {
			
			selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");
			
			selectedEstablecimiento = businessDelegatorView.establecimientoToEstablecimientoDTO(
					businessDelegatorView.findEstablecimientoByProyectoEstablecimientoId(
							selectedProyectoEstablecimiento.getIdProyectoEstablecimiento()));
			
			estadoProyecto = businessDelegatorView.findEstadoProyectoByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			
			Norma norma = businessDelegatorView.findNormaByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			selectedNorma = businessDelegatorView.normaToNormaDTO(norma);
			
			programasData = businessDelegatorView.getDetailDataProgramaByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			
			progresoProyecto = businessDelegatorView.getProyectoEstablecimeintoProgress(selectedProyectoEstablecimiento.getIdProyectoEstablecimiento()).intValue();
			
			showFinishBtn = (progresoProyecto == 100) ? true : false;
			
			objetivosEnCurso = (estadoProyecto.getDescripcion().equals("Ejecución")) ?
					businessDelegatorView.findObjetivoDataByEstadoDescripcion("Iniciado", selectedProyectoEstablecimiento.getIdProyectoEstablecimiento()) : null;
			
			requisitoCompletados = (estadoProyecto.getDescripcion().equals("Autoevaluación")) ? 
				businessDelegatorView.findRequisitosDTOByEstadoObjetivoDescripcion("Cumple Req.", selectedProyectoEstablecimiento.getIdProyectoEstablecimiento())	: null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void action_show_objetivo_details(ActionEvent evt) {
		try {
			ObjetivoDTO selectedObjetivo = (ObjetivoDTO) (evt.getComponent()
					.getAttributes().get("selectedObjetivo"));

			httpSession.setAttribute("selectedObjetivo", selectedObjetivo);
			
			if (selectedObjetivo.getEstadoDescripcion() == null) {
				selectedObjetivo.setEstadoDescripcion(
						businessDelegatorView.findEstadoObjetivoByObjetivoIdProyectoEstablecimientoId(
								selectedProyectoEstablecimiento.getIdProyectoEstablecimiento(), 
								selectedObjetivo.getIdObjetivo()).getDescripcion()); 
			}
			
			String path = "";
			
			switch (estadoProyecto.getDescripcion()) {
			case "Ejecución":
				if (selectedObjetivo.getEstadoDescripcion().equals("Cumple Req.") ||
						selectedObjetivo.getEstadoDescripcion().equals("No Aplica")) {
					path = "/XHTML/detallesObjetivoAutoevaluacion.xhtml";
					break;
				}
				path = "/XHTML/detallesObjetivoEjecucion.xhtml";
				break;

			case "Autoevaluación":
				path = "/XHTML/detallesObjetivoAutoevaluacion.xhtml";
				break;
			}
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + path);
		} catch (Exception e) {
		}
	}

	public void action_show_programa_details(ActionEvent evt) {
		try {
			ProgramaDTO selectedPrograma = (ProgramaDTO) (evt.getComponent()
					.getAttributes().get("selectedPrograma"));

			httpSession.setAttribute("selectedPrograma", selectedPrograma);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesPrograma.xhtml");
		} catch (Exception e) {
		}
	}

	public String action_show_norma_details() {
		try {
			httpSession.setAttribute("selectedNorma", selectedNorma);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesNorma.xhtml");
		} catch (Exception e) {
		}
		return "";
	}
	
	public void action_show_requisito_details(ActionEvent evt) {
		try {
			RequisitoDTO selectedRequisito = (RequisitoDTO) (evt.getComponent()
					.getAttributes().get("selectedRequisito"));
			
			httpSession.setAttribute("selectedRequisito", selectedRequisito);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesRequisito.xhtml");
		} catch (Exception e) {
		}
	}
	
	public String action_finish_proyecto_state() {
		try {
			if (progresoProyecto >= 100 && selectedProyectoEstablecimiento != null) {
				
				ProyectoEstablecimiento proyectoEstablecimiento = businessDelegatorView.getProyectoEstablecimiento(
						selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			
				businessDelegatorView.finishProyectoEstado(proyectoEstablecimiento.getIdProyectoEstablecimiento());
				FacesUtils.addInfoMessage(estadoProyecto.getDescripcion() + " ha finalizado exitosamente.");
				
				Dialog finishDialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
						"dialogFinishState");
				finishDialog.setVisible(true);
			} else {
				FacesUtils.addErrorMessage("Debe completar todos los objetivos del Proyecto para finalizar "
						+ estadoProyecto.getDescripcion());
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			e.printStackTrace();
		}
		return "";
		
	}

	public EstablecimientoDTO getSelectedEstablecimiento() {
		return selectedEstablecimiento;
	}

	public void setSelectedEstablecimiento(EstablecimientoDTO selectedEstablecimiento) {
		this.selectedEstablecimiento = selectedEstablecimiento;
	}

	public ProyectoEstablecimientoDTO getSelectedProyectoEstablecimiento() {
		return selectedProyectoEstablecimiento;
	}

	public void setSelectedProyectoEstablecimiento(ProyectoEstablecimientoDTO selectedProyectoEstablecimiento) {
		this.selectedProyectoEstablecimiento = selectedProyectoEstablecimiento;
	}

	public NormaDTO getSelectedNorma() {
		return selectedNorma;
	}

	public void setSelectedNorma(NormaDTO selectedNorma) {
		this.selectedNorma = selectedNorma;
	}

	public List<ProgramaDTO> getProgramasData() {
		return programasData;
	}

	public void setProgramasData(List<ProgramaDTO> programasData) {
		this.programasData = programasData;
	}

	public List<ObjetivoDTO> getObjetivosEnCurso() {
		return objetivosEnCurso;
	}

	public void setObjetivosEnCurso(List<ObjetivoDTO> objetivosEnCurso) {
		this.objetivosEnCurso = objetivosEnCurso;
	}

	public List<RequisitoDTO> getRequisitoCompletados() {
		return requisitoCompletados;
	}

	public void setRequisitoCompletados(List<RequisitoDTO> requisitoCompletados) {
		this.requisitoCompletados = requisitoCompletados;
	}

	public EstadoProyecto getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public Integer getProgresoProyecto() {
		return progresoProyecto;
	}

	public void setProgresoProyecto(Integer progresoProyecto) {
		this.progresoProyecto = progresoProyecto;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	public OutputLabel getLabelPrueba() {
		return labelPrueba;
	}
	
	public void setLabelPrueba(OutputLabel labelPrueba) {
		this.labelPrueba = labelPrueba;
	}

	public boolean isShowTut() {
		return showTut;
	}

	public void setShowTut(boolean showTut) {
		this.showTut = showTut;
	}

	public boolean isShowFinishBtn() {
		return showFinishBtn;
	}

	public void setShowFinishBtn(boolean showFinishBtn) {
		this.showFinishBtn = showFinishBtn;
	}
}
