package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.model.EstadoProyecto;
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
public class NormaDetailsView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NormaDetailsView.class);
    private NormaDTO selectedNorma;
    private List<RequisitoDTO> requisitoData;
    private HttpSession httpSession;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public NormaDetailsView() {
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
    		selectedNorma = (NormaDTO) httpSession.getAttribute("selectedNorma");
    		requisitoData = businessDelegatorView.findRequisitoByNormaId(selectedNorma.getIdNorma());
        	
		} catch (Exception e) {
			e.printStackTrace();
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

	public NormaDTO getSelectedNorma() {
		return selectedNorma;
	}

	public void setSelectedNorma(NormaDTO selectedNorma) {
		this.selectedNorma = selectedNorma;
	}

	public List<RequisitoDTO> getRequisitoData() {
		return requisitoData;
	}

	public void setRequisitoData(List<RequisitoDTO> requisitoData) {
		this.requisitoData = requisitoData;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}
