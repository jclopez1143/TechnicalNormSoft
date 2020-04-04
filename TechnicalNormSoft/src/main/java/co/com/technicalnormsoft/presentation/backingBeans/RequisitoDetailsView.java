package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.dto.NormaDTO;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Silicon Cali
 * 
 *
 */
@ManagedBean
@ViewScoped
public class RequisitoDetailsView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RequisitoDetailsView.class);
    private RequisitoDTO selectedRequisito;
    private ObjetivoDTO selectedObjetivo;
    private NormaDTO selectedNorma;
    private HttpSession httpSession;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RequisitoDetailsView() {
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
    		selectedRequisito = (RequisitoDTO) httpSession.getAttribute("selectedRequisito");
    		
    		selectedObjetivo = businessDelegatorView.objetivoToObjetivoDTO(
    				businessDelegatorView.findObjetivoByRequisitoId(selectedRequisito.getIdRequisito()));
    		
    		Norma norma = businessDelegatorView.findNormaByRequisitoId(selectedRequisito.getIdRequisito());
    		selectedNorma = businessDelegatorView.normaToNormaDTO(norma);
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    }
    
	public void action_show_objetivo_details() {
		try {
			httpSession.setAttribute("selectedObjetivo", selectedObjetivo);
			ProyectoEstablecimientoDTO selectedProyectoEstablecimiento = 
					(ProyectoEstablecimientoDTO) httpSession.getAttribute("selectedProyectoEstablecimiento");
			
			EstadoProyecto estadoProyecto = businessDelegatorView.findEstadoProyectoByProyectoEstablecimientoId(
					selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
			
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

	public RequisitoDTO getSelectedRequisito() {
		return selectedRequisito;
	}

	public void setSelectedRequisito(RequisitoDTO selectedRequisito) {
		this.selectedRequisito = selectedRequisito;
	}

	public ObjetivoDTO getSelectedObjetivo() {
		return selectedObjetivo;
	}

	public void setSelectedObjetivo(ObjetivoDTO selectedObjetivo) {
		this.selectedObjetivo = selectedObjetivo;
	}

	public NormaDTO getSelectedNorma() {
		return selectedNorma;
	}

	public void setSelectedNorma(NormaDTO selectedNorma) {
		this.selectedNorma = selectedNorma;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
