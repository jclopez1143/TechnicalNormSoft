package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author Silicon Cali
 * 
 */
@ManagedBean
@ViewScoped
public class EstablecimientoView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EstablecimientoView.class);
	private InputText txtCargoPersonaContacto;
	private InputText txtCelular;
	private InputText txtDireccion;
	private InputText txtEmail;
	private InputText txtNombre;
	private InputText txtNombrePersonaContacto;
	private InputText txtScore;
	private InputText txtTelefono;
	private SelectOneMenu txtIdTipoServicio_TipoServicio;
	private InputText txtIdUsuario_Usuario;
	private InputText txtIdEstablecimiento;
	private Calendar txtDateIn;
	private Calendar txtDateUpdate;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EstablecimientoDTO> data;
	private List<TipoServicioDTO> tipoServicioData;
	private TipoServicio tipoServicioSelected;
	private EstablecimientoDTO selectedEstablecimiento;
	private Establecimiento entity;
	private boolean showModify;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private String usuarioEmail;
	private Usuario usuario;
	private HttpSession httpSession;

	public EstablecimientoView() {
		super();
	}

	@PostConstruct
	public void init() {
		try {
			//get Usuario from httpsession
			httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			usuarioEmail = (String) httpSession.getAttribute("usuarioEmail");
			usuario = businessDelegatorView.findUsuarioByEmail(usuarioEmail);
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
			txtCargoPersonaContacto.setDisabled(false);
		}

		if (txtCelular != null) {
			txtCelular.setValue(null);
			txtCelular.setDisabled(false);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(false);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(false);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(false);
		}

		if (txtNombrePersonaContacto != null) {
			txtNombrePersonaContacto.setValue(null);
			txtNombrePersonaContacto.setDisabled(false);
		}

		if (txtScore != null) {
			txtScore.setValue(null);
			txtScore.setDisabled(false);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(false);
		}

		if (txtIdTipoServicio_TipoServicio != null) {
			txtIdTipoServicio_TipoServicio.setValue(null);
			txtIdTipoServicio_TipoServicio.setDisabled(false);
		}

		if (txtIdUsuario_Usuario != null) {
			txtIdUsuario_Usuario.setValue(null);
			txtIdUsuario_Usuario.setDisabled(false);
		}

		if (txtDateIn != null) {
			txtDateIn.setValue(null);
			txtDateIn.setDisabled(false);
		}

		if (txtDateUpdate != null) {
			txtDateUpdate.setValue(null);
			txtDateUpdate.setDisabled(false);
		}

		if (txtIdEstablecimiento != null) {
			txtIdEstablecimiento.setValue(null);
			txtIdEstablecimiento.setDisabled(false);
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

	public String action_save() {
		try {
			action_create();
			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_show_details(ActionEvent evt) {
		try {
			selectedEstablecimiento = (EstablecimientoDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedEstablecimiento"));
			httpSession.setAttribute("selectedEstablecimiento", selectedEstablecimiento);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
			String contextPath = origRequest.getContextPath();
			context.getExternalContext().redirect(contextPath + "/XHTML/detallesEstablecimiento.xhtml");
		} catch (Exception e) {
		}
	}

	public String action_create() {
		try {
			entity = new Establecimiento();


			entity.setCargoPersonaContacto(FacesUtils.checkString(
					txtCargoPersonaContacto));
			entity.setCelular(FacesUtils.checkString(txtCelular));
			entity.setDateIn(new Date());
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setNombrePersonaContacto(FacesUtils.checkString(
					txtNombrePersonaContacto));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			tipoServicioSelected = businessDelegatorView.getTipoServicio(
					Integer.parseInt(
							txtIdTipoServicio_TipoServicio.getValue().toString()));
			entity.setTipoServicio(tipoServicioSelected);
			entity.setUsuario(usuario);
			businessDelegatorView.saveEstablecimiento(entity);
			FacesUtils.addInfoMessage("Establecimiento creado exitosamente.");
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedEstablecimiento = (EstablecimientoDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedEstablecimiento"));

			Integer idEstablecimiento = new Integer(selectedEstablecimiento.getIdEstablecimiento());
			entity = businessDelegatorView.getEstablecimiento(idEstablecimiento);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer idEstablecimiento = FacesUtils.checkInteger(txtIdEstablecimiento);
			entity = businessDelegatorView.getEstablecimiento(idEstablecimiento);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteEstablecimiento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtNombrePersonaContacto() {
		return txtNombrePersonaContacto;
	}

	public void setTxtNombrePersonaContacto(InputText txtNombrePersonaContacto) {
		this.txtNombrePersonaContacto = txtNombrePersonaContacto;
	}

	public InputText getTxtScore() {
		return txtScore;
	}

	public void setTxtScore(InputText txtScore) {
		this.txtScore = txtScore;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public SelectOneMenu getTxtIdTipoServicio_TipoServicio() {
		return txtIdTipoServicio_TipoServicio;
	}

	public void setTxtIdTipoServicio_TipoServicio(
			SelectOneMenu txtIdTipoServicio_TipoServicio) {
		this.txtIdTipoServicio_TipoServicio = txtIdTipoServicio_TipoServicio;
	}

	public InputText getTxtIdUsuario_Usuario() {
		return txtIdUsuario_Usuario;
	}

	public void setTxtIdUsuario_Usuario(InputText txtIdUsuario_Usuario) {
		this.txtIdUsuario_Usuario = txtIdUsuario_Usuario;
	}

	public Calendar getTxtDateIn() {
		return txtDateIn;
	}

	public void setTxtDateIn(Calendar txtDateIn) {
		this.txtDateIn = txtDateIn;
	}

	public Calendar getTxtDateUpdate() {
		return txtDateUpdate;
	}

	public void setTxtDateUpdate(Calendar txtDateUpdate) {
		this.txtDateUpdate = txtDateUpdate;
	}

	public InputText getTxtIdEstablecimiento() {
		return txtIdEstablecimiento;
	}

	public void setTxtIdEstablecimiento(InputText txtIdEstablecimiento) {
		this.txtIdEstablecimiento = txtIdEstablecimiento;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
