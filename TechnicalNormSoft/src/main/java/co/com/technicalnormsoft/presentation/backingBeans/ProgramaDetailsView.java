package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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
public class ProgramaDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProgramaDetailsView.class);
	private EstablecimientoDTO selectedEstablecimiento;
	private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
	private ProgramaDTO selectedPrograma;
	private EstadoProyecto estadoProyecto;
	private Double progresoPrograma;
	private List<ProgramaDTO> programasData;
	private List<ObjetivoDTO> objetivosEstadoA;
	private List<ObjetivoDTO> objetivosEstadoB;
	private List<ObjetivoDTO> allObjetivos;
	private HttpSession httpSession;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramaDetailsView() {
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
			selectedEstablecimiento = (EstablecimientoDTO) httpSession.getAttribute("selectedEstablecimiento");
			selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");
			selectedPrograma = (ProgramaDTO) httpSession.getAttribute("selectedPrograma");
			estadoProyecto = businessDelegatorView.findEstadoProyectoByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

			progresoPrograma = businessDelegatorView.getProgramaProgressPercentage(selectedPrograma.getIdPrograma(), 
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

			if (!estadoProyecto.getDescripcion().equals("Autoevaluación")) {
				objetivosEstadoA = businessDelegatorView.findObjetivosByEstadoDescripcionProgramaId("Iniciado",
						selectedPrograma.getIdPrograma(), selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

				objetivosEstadoB = businessDelegatorView.findObjetivosByEstadoDescripcionProgramaId("Completado",
						selectedPrograma.getIdPrograma(), selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			} else {
				objetivosEstadoA = businessDelegatorView.findObjetivosByEstadoDescripcionProgramaId("Cumple Req.",
						selectedPrograma.getIdPrograma(), selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

				objetivosEstadoB = businessDelegatorView.findObjetivosByEstadoDescripcionProgramaId("No Cumple Req.",
						selectedPrograma.getIdPrograma(), selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			}

			allObjetivos = businessDelegatorView.findObjetivosByProgramaId(selectedPrograma.getIdPrograma(), 
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_show_proyecto_details() {
		try {
			httpSession.setAttribute("selectedProyectoEstablecimiento", selectedProyectoEstablecimiento);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesProyecto.xhtml");
		} catch (Exception e) {
		}
		return "";
	}

	public void action_show_objetivo_details(ActionEvent evt) {
		try {
			ObjetivoDTO selectedObjetivo = (ObjetivoDTO) (evt.getComponent()
					.getAttributes().get("selectedObjetivo"));

			httpSession.setAttribute("selectedObjetivo", selectedObjetivo);
			ProyectoEstablecimientoDTO selectedProyectoEstablecimiento = 
					(ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");

			EstadoProyecto estadoProyecto = businessDelegatorView.findEstadoProyectoByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());

			String path = "";

			switch (estadoProyecto.getDescripcion()) {
			case "Ejecución":
				path = "/XHTML/detallesObjetivoEjecucion.xhtml";
				break;

			case "Autoevaluación":
				path = "/XHTML/detallesObjetivoAutoevaluacion.xhtml";
				break;

			default:
				path = "/XHTML/detallesObjetivoRevision.xhtml";
				break;
			}

			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + path);
		} catch (Exception e) {
		}
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

	public ProgramaDTO getSelectedPrograma() {
		return selectedPrograma;
	}

	public void setSelectedPrograma(ProgramaDTO selectedPrograma) {
		this.selectedPrograma = selectedPrograma;
	}

	public EstadoProyecto getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public List<ProgramaDTO> getProgramasData() {
		return programasData;
	}

	public void setProgramasData(List<ProgramaDTO> programasData) {
		this.programasData = programasData;
	}

	public List<ObjetivoDTO> getObjetivosEstadoA() {
		return objetivosEstadoA;
	}

	public void setObjetivosEstadoA(List<ObjetivoDTO> objetivosEstadoA) {
		this.objetivosEstadoA = objetivosEstadoA;
	}

	public List<ObjetivoDTO> getObjetivosEstadoB() {
		return objetivosEstadoB;
	}

	public void setObjetivosEstadoB(List<ObjetivoDTO> objetivosEstadoB) {
		this.objetivosEstadoB = objetivosEstadoB;
	}

	public List<ObjetivoDTO> getAllObjetivos() {
		return allObjetivos;
	}

	public void setAllObjetivos(List<ObjetivoDTO> allObjetivos) {
		this.allObjetivos = allObjetivos;
	}

	public Double getProgresoPrograma() {
		return progresoPrograma;
	}

	public void setProgresoPrograma(Double progresoPrograma) {
		this.progresoPrograma = progresoPrograma;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
