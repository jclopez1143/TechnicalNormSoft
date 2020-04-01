package co.com.technicalnormsoft.presentation.backingBeans;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class FileUploadController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ObjetivoEjecucionDetailsView.class);
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	public void upload(FileUploadEvent event) {
		try {
			EstablecimientoObjetivo establecimientoObjetivo = businessDelegatorView.getEstablecimientoObjetivo(1);
			
			businessDelegatorView.upload(event, establecimientoObjetivo);
			
			FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
}