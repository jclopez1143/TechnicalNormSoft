package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class EstablecimientoDetailsView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EstablecimientoDetailsView.class);
	private OutputLabel msgCargoPersonaContacto;
	private OutputLabel msgCelular;
	private OutputLabel msgDireccion;
	private OutputLabel msgEmail;
	private OutputLabel msgNombre;
	private OutputLabel msgNombrePersonaContacto;
	private OutputLabel msgScore;
	private OutputLabel msgTelefono;
	private OutputLabel msgTipoServicio;
	private InputText txtCargoPersonaContacto;
	private InputText txtCelular;
	private InputText txtDireccion;
	private InputText txtEmail;
	private InputText txtNombrePersonaContacto;
	private InputText txtTelefono;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EstablecimientoDTO> data;
	private List<ProyectoEstablecimientoDTO> dataProyectos;
	private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
	private List<Norma> dataNormas;
	private Norma selectedNorma;
	private List<TipoServicioDTO> tipoServicioData;
	private TipoServicio tipoServicioSelected;
	private EstablecimientoDTO selectedEstablecimiento;
	private Establecimiento entity;
	private ProyectoEstablecimiento nuevoProyectoEstablecimiento;
	private boolean showModify;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private HttpSession httpSession;

	public EstablecimientoDetailsView() {
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

	public String action_new() {
		action_clear();
		selectedEstablecimiento = null;
		setShowModify(true);

		return "";
	}

	@PreDestroy
	public void clear() {
		action_clear();
	}

	public String action_clear() {
		entity = null;
		selectedEstablecimiento = null;
		tipoServicioSelected = null;
		httpSession.setAttribute("selectedEstablecimiento", null);


		if (txtCargoPersonaContacto != null) {
			txtCargoPersonaContacto.setValue(null);
			txtCargoPersonaContacto.setRendered(false);
		}

		if (txtCelular != null) {
			txtCelular.setValue(null);
			txtCelular.setRendered(false);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setRendered(false);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setRendered(false);
		}

		if (txtNombrePersonaContacto != null) {
			txtNombrePersonaContacto.setValue(null);
			txtNombrePersonaContacto.setRendered(false);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setRendered(false);
		}

		if (btnSave != null) {
			btnSave.setRendered(false);
		}

		if (btnClear != null) {
			btnClear.setRendered(false);
		}

		if (btnModify != null) {
			btnModify.setRendered(true);
		}

		return "";
	}

	//Method for initialize Establecimiento Detailed Form to view specific attributes
	public String action_set_details() {
		try {
			selectedEstablecimiento = (EstablecimientoDTO) httpSession.getAttribute("selectedEstablecimiento");
			if(selectedEstablecimiento != null) {
				entity = businessDelegatorView.getEstablecimiento(selectedEstablecimiento.getIdEstablecimiento());

				msgCargoPersonaContacto = new OutputLabel();
				msgCargoPersonaContacto.setValue(entity.getCargoPersonaContacto());

				msgCelular = new OutputLabel();
				msgCelular.setValue(entity.getCelular());

				msgDireccion = new OutputLabel();
				msgDireccion.setValue(entity.getDireccion());

				msgEmail = new OutputLabel();
				msgEmail.setValue(entity.getEmail());

				msgNombrePersonaContacto = new OutputLabel();
				msgNombrePersonaContacto.setValue(entity.getNombrePersonaContacto());

				msgScore = new OutputLabel();
				msgScore.setValue(entity.getScore());

				msgTelefono = new OutputLabel();
				msgTelefono.setValue(entity.getTelefono());

				msgNombre = new OutputLabel();
				msgNombre.setValue(entity.getNombre());

				tipoServicioSelected = businessDelegatorView.
						findTipoServicioByEstablecimientoId(entity.getIdEstablecimiento());
				msgTipoServicio = new OutputLabel();
				msgTipoServicio.setValue(businessDelegatorView.tipoServicioToTipoServicioDTO(tipoServicioSelected).getDescripcion());
				
				dataNormas = businessDelegatorView.findNormasByTipoServicioId(tipoServicioSelected.getIdTipoServicio());

				setShowModify(false);
				btnModify = new CommandButton();
				btnModify.setRendered(true);
				btnClear = new CommandButton();
				btnClear.setRendered(false);
				btnSave = new CommandButton();
				btnSave.setRendered(false);
			}
		} catch (Exception e) {
			entity = null;
			e.printStackTrace();
		}
		return "";
	}

	public String action_set_dialog_proyecto_data() {
		try {
			dataNormas = businessDelegatorView.findNormasByTipoServicioId(tipoServicioSelected.getIdTipoServicio());

			Dialog dialogUpload = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
					"dialogProyecto");
			dialogUpload.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public void action_show_proyecto_details(ActionEvent evt) {
		try {
			selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedProyectoEstablecimiento"));
			httpSession.setAttribute("selectedProyectoEstablecimiento", selectedProyectoEstablecimiento);
			httpSession.setAttribute("selectedEstablecimiento", selectedEstablecimiento);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesProyecto.xhtml");
		} catch (Exception e) {
		}
	}

	public String action_cancel() {		
		txtCargoPersonaContacto.setValue(null);

		txtCelular.setValue(null);

		txtDireccion.setValue(null);

		txtEmail.setValue(null);

		txtNombrePersonaContacto.setValue(null);

		txtTelefono.setValue(null);

		setShowModify(false);

		btnModify.setRendered(true);
		btnClear.setRendered(false);
		btnSave.setRendered(false);

		return "";
	}

	public String action_close_dialog() {
		selectedNorma = null;
		Dialog dialog = (Dialog) FacesContext.getCurrentInstance().getViewRoot().findComponent(
				"dialogProyecto");
		if (dialog != null) {
			dialog.setVisible(false);
		}
		return "";
	}

	public String action_set_modify() {

		txtCargoPersonaContacto.setValue(entity.getCargoPersonaContacto());
		txtCelular.setValue(entity.getCelular());
		txtDireccion.setValue(entity.getDireccion());
		txtEmail.setValue(entity.getEmail());
		txtNombrePersonaContacto.setValue(entity.getNombrePersonaContacto());
		txtTelefono.setValue(entity.getTelefono());

		setShowModify(true);
		btnModify.setRendered(false);
		btnSave.setRendered(true);
		btnClear.setRendered(true);

		FacesUtils.addInfoMessage("El nombre del establecimiento y el tipo de servicio no podrá ser actualizado. En caso de cambiar, registre un nuevo Establecimiento.");
		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Integer idEstablecimiento = new Integer(selectedEstablecimiento.getIdEstablecimiento());
				entity = businessDelegatorView.getEstablecimiento(idEstablecimiento);
			}

			entity.setCargoPersonaContacto(FacesUtils.checkString(
					txtCargoPersonaContacto));
			msgCargoPersonaContacto.setValue(txtCargoPersonaContacto.getValue().toString());

			entity.setCelular(FacesUtils.checkString(txtCelular));
			msgCelular.setValue(txtCelular.getValue().toString());

			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			msgDireccion.setValue(txtDireccion.getValue().toString());

			entity.setEmail(FacesUtils.checkString(txtEmail));
			msgEmail.setValue(txtEmail.getValue().toString());

			entity.setNombrePersonaContacto(FacesUtils.checkString(
					txtNombrePersonaContacto));
			msgNombrePersonaContacto.setValue(txtNombrePersonaContacto.getValue().toString());

			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			msgTelefono.setValue(txtTelefono.getValue().toString());

			entity.setDateUpdate(new Date());
			businessDelegatorView.updateEstablecimiento(entity);
			action_cancel();
			FacesUtils.addInfoMessage("Establecimiento actualizado exitosamente.");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create_proyecto() {
		try {
			if (!businessDelegatorView.isOtherSameProyectoInExecution(entity.getIdEstablecimiento(),
					selectedNorma.getIdNorma())) {
				nuevoProyectoEstablecimiento = new ProyectoEstablecimiento();

				Proyecto proyecto = businessDelegatorView.
						findProyectoByNormaId(selectedNorma.getIdNorma());

				nuevoProyectoEstablecimiento.setProyecto(proyecto);
				nuevoProyectoEstablecimiento.setDateIn(new Date());
				nuevoProyectoEstablecimiento.setEstablecimiento(entity);
				nuevoProyectoEstablecimiento.setEstadoProyecto(businessDelegatorView.
						findEstadoProyectoByDescripcion("Autoevaluación"));
				nuevoProyectoEstablecimiento.setScore(0d);
				nuevoProyectoEstablecimiento.setNombre(proyecto.getNombre() + " : " + entity.getNombre());

				businessDelegatorView.saveProyectoEstablecimiento(nuevoProyectoEstablecimiento);

				selectedProyectoEstablecimiento = businessDelegatorView.proyectoEstablecimientoToProyectoEstablecimientoDTO(nuevoProyectoEstablecimiento);

				httpSession.setAttribute("selectedProyectoEstablecimiento", selectedProyectoEstablecimiento);
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
				String contextPath = origRequest.getContextPath();
				context.getExternalContext().redirect(contextPath + "/XHTML/detallesProyecto.xhtml");
			} else {
				FacesUtils.addErrorMessage("Ya se encuentra un Proyecto de la misma Norma Técnica en proceso.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public OutputLabel getMsgCargoPersonaContacto() {
		return msgCargoPersonaContacto;
	}

	public void setMsgCargoPersonaContacto(OutputLabel msgCargoPersonaContacto) {
		this.msgCargoPersonaContacto = msgCargoPersonaContacto;
	}

	public OutputLabel getMsgCelular() {
		return msgCelular;
	}

	public void setMsgCelular(OutputLabel msgCelular) {
		this.msgCelular = msgCelular;
	}

	public OutputLabel getMsgDireccion() {
		return msgDireccion;
	}

	public void setMsgDireccion(OutputLabel msgDireccion) {
		this.msgDireccion = msgDireccion;
	}

	public OutputLabel getMsgEmail() {
		return msgEmail;
	}

	public void setMsgEmail(OutputLabel msgEmail) {
		this.msgEmail = msgEmail;
	}

	public OutputLabel getMsgNombre() {
		return msgNombre;
	}

	public void setMsgNombre(OutputLabel msgNombre) {
		this.msgNombre = msgNombre;
	}

	public OutputLabel getMsgNombrePersonaContacto() {
		return msgNombrePersonaContacto;
	}

	public void setMsgNombrePersonaContacto(OutputLabel msgNombrePersonaContacto) {
		this.msgNombrePersonaContacto = msgNombrePersonaContacto;
	}

	public OutputLabel getMsgScore() {
		return msgScore;
	}

	public void setMsgScore(OutputLabel msgScore) {
		this.msgScore = msgScore;
	}

	public OutputLabel getMsgTelefono() {
		return msgTelefono;
	}

	public void setMsgTelefono(OutputLabel msgTelefono) {
		this.msgTelefono = msgTelefono;
	}

	public OutputLabel getMsgTipoServicio() {
		return msgTipoServicio;
	}

	public void setMsgTipoServicio(OutputLabel msgTipoServicio) {
		this.msgTipoServicio = msgTipoServicio;
	}

	public InputText getTxtCargoPersonaContacto() {
		return txtCargoPersonaContacto;
	}

	public void setTxtCargoPersonaContacto(InputText txtCargoPersonaContacto) {
		this.txtCargoPersonaContacto = txtCargoPersonaContacto;
	}

	public InputText getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(InputText txtCelular) {
		this.txtCelular = txtCelular;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public InputText getTxtNombrePersonaContacto() {
		return txtNombrePersonaContacto;
	}

	public void setTxtNombrePersonaContacto(InputText txtNombrePersonaContacto) {
		this.txtNombrePersonaContacto = txtNombrePersonaContacto;
	}


	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public List<EstablecimientoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEstablecimiento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EstablecimientoDTO> establecimientoDTO) {
		this.data = establecimientoDTO;
	}

	public List<ProyectoEstablecimientoDTO> getDataProyectos() {
		try {
			dataProyectos = businessDelegatorView.getProyectoEstablecimientoDTOByEstablecimientoId(
					selectedEstablecimiento.getIdEstablecimiento());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataProyectos;
	}

	public void setDataProyectos(List<ProyectoEstablecimientoDTO> dataProyectos) {
		this.dataProyectos = dataProyectos;
	}

	public List<Norma> getDataNormas() {
		return dataNormas;
	}

	public ProyectoEstablecimientoDTO getSelectedProyectoEstablecimiento() {
		return selectedProyectoEstablecimiento;
	}

	public void setSelectedProyectoEstablecimiento(ProyectoEstablecimientoDTO selectedProyectoEstablecimiento) {
		this.selectedProyectoEstablecimiento = selectedProyectoEstablecimiento;
	}

	public void setDataNormas(List<Norma> dataNormas) {
		this.dataNormas = dataNormas;
	}

	public Norma getSelectedNorma() {
		return selectedNorma;
	}

	public void setSelectedNorma(Norma selectedNorma) {
		this.selectedNorma = selectedNorma;
	}

	public List<TipoServicioDTO> getTipoServicioData() {
		try {
			if (tipoServicioData == null) {
				tipoServicioData = businessDelegatorView.getDataTipoServicio();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoServicioData;
	}

	public void setTipoServicioData(List<TipoServicioDTO> tipoServicioData) {
		this.tipoServicioData = tipoServicioData;
	}

	public TipoServicio getTipoServicioSelected() {
		return tipoServicioSelected;
	}

	public void setTipoServicioSelected(TipoServicio tipoServicioSelected) {
		this.tipoServicioSelected = tipoServicioSelected;
	}

	public EstablecimientoDTO getSelectedEstablecimiento() {
		return selectedEstablecimiento;
	}

	public void setSelectedEstablecimiento(EstablecimientoDTO establecimiento) {
		this.selectedEstablecimiento = establecimiento;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowModify() {
		return showModify;
	}

	public void setShowModify(boolean showModify) {
		this.showModify = showModify;
	}
}
