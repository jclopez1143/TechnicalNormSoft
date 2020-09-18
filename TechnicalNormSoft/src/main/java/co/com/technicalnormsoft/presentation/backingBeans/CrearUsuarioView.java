package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;


/**
 * @author Silicon Cali
 * 
 *
 */
@ManagedBean
@ViewScoped
public class CrearUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CrearUsuarioView.class);
    private InputText txtCargoPersonaContacto;
    private InputText txtCelular;
    private InputText txtEmail;
    private InputMask txtNit;
    private InputText txtNombrePersonaContacto;
    private InputText txtRazonSocial;
    private InputText txtSitioWeb;
    private InputText txtTelefono;
    private Password txtPassword;
    private InputText txtIdUsuario;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private boolean termAgree;
    private CommandButton btnRegistrar;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    private String outcome;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    private HttpSession httpSession;
    
    public CrearUsuarioView() {
        super();
    }
    
    @PostConstruct
    public void init() {
		httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;

        if (txtCargoPersonaContacto != null) {
            txtCargoPersonaContacto.setValue(null);
            txtCargoPersonaContacto.setDisabled(true);
        }

        if (txtCelular != null) {
            txtCelular.setValue(null);
            txtCelular.setDisabled(true);
        }

        if (txtEmail != null) {
            txtEmail.setValue(null);
            txtEmail.setDisabled(true);
        }

        if (txtNit != null) {
            txtNit.setValue(null);
            txtNit.setDisabled(true);
        }

        if (txtNombrePersonaContacto != null) {
            txtNombrePersonaContacto.setValue(null);
            txtNombrePersonaContacto.setDisabled(true);
        }

        if (txtRazonSocial != null) {
            txtRazonSocial.setValue(null);
            txtRazonSocial.setDisabled(true);
        }

        if (txtSitioWeb != null) {
            txtSitioWeb.setValue(null);
            txtSitioWeb.setDisabled(true);
        }

        if (txtTelefono != null) {
            txtTelefono.setValue(null);
            txtTelefono.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdUsuario != null) {
            txtIdUsuario.setValue(null);
            txtIdUsuario.setDisabled(false);
        }

        if (btnRegistrar != null) {
            btnRegistrar.setDisabled(true);
        }

        return "";
    }

    public String action_create() {
        try {
        	if(!termAgree) {
        		throw new Exception("Debe aceptar los Térrminos y Condiciones.");
        	}
        	
            entity = new Usuario();

            entity.setCargoPersonaContacto(FacesUtils.checkString(
                    txtCargoPersonaContacto));
            entity.setCelular(FacesUtils.checkString(txtCelular));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setNit(FacesUtils.checkString(txtNit));
            entity.setNombrePersonaContacto(FacesUtils.checkString(
                    txtNombrePersonaContacto));
            entity.setRazonSocial(FacesUtils.checkString(txtRazonSocial));
            entity.setSitioWeb(FacesUtils.checkString(txtSitioWeb));
            entity.setTelefono(FacesUtils.checkString(txtTelefono));
            entity.setPassword(FacesUtils.checkString(txtPassword));
            businessDelegatorView.saveUsuario(entity);
            
            httpSession.setAttribute("usuario", entity);

            outcome = "/TechnicalNormSoft/login.xhtml";
			FacesContext c = FacesContext.getCurrentInstance();
			c.getExternalContext().redirect(outcome);
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
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

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputMask getTxtNit() {
        return txtNit;
    }

    public void setTxtNit(InputMask txtNit) {
        this.txtNit = txtNit;
    }

    public InputText getTxtNombrePersonaContacto() {
        return txtNombrePersonaContacto;
    }

    public void setTxtNombrePersonaContacto(InputText txtNombrePersonaContacto) {
        this.txtNombrePersonaContacto = txtNombrePersonaContacto;
    }

    public InputText getTxtRazonSocial() {
        return txtRazonSocial;
    }

    public void setTxtRazonSocial(InputText txtRazonSocial) {
        this.txtRazonSocial = txtRazonSocial;
    }

    public InputText getTxtSitioWeb() {
        return txtSitioWeb;
    }

    public void setTxtSitioWeb(InputText txtSitioWeb) {
        this.txtSitioWeb = txtSitioWeb;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public Password getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(Password txtPassword) {
		this.txtPassword = txtPassword;
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

    public boolean isTermAgree() {
		return termAgree;
	}

	public void setTermAgree(boolean termAgree) {
		this.termAgree = termAgree;
	}

	public InputText getTxtIdUsuario() {
        return txtIdUsuario;
    }

    public void setTxtIdUsuario(InputText txtIdUsuario) {
        this.txtIdUsuario = txtIdUsuario;
    }

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
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

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
