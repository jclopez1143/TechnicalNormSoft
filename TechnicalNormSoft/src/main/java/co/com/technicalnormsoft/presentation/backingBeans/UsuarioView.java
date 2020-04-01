package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.*;
import co.com.technicalnormsoft.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Silicon Cali
 * 
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    private InputText txtCargoPersonaContacto;
    private InputText txtCelular;
    private InputText txtEmail;
    private InputText txtNit;
    private InputText txtNombrePersonaContacto;
    private InputText txtRazonSocial;
    private InputText txtSitioWeb;
    private InputText txtTelefono;
    private InputText txtIdUsuario;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedUsuario = null;
        setShowDialog(true);

        return "";
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

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtDateIn() {
        Date inputDate = (Date) txtDateIn.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtDateUpdate() {
        Date inputDate = (Date) txtDateUpdate.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer idUsuario = FacesUtils.checkInteger(txtIdUsuario);
            entity = (idUsuario != null)
                ? businessDelegatorView.getUsuario(idUsuario) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCargoPersonaContacto.setDisabled(false);
            txtCelular.setDisabled(false);
            txtEmail.setDisabled(false);
            txtNit.setDisabled(false);
            txtNombrePersonaContacto.setDisabled(false);
            txtRazonSocial.setDisabled(false);
            txtSitioWeb.setDisabled(false);
            txtTelefono.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdUsuario.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCargoPersonaContacto.setValue(entity.getCargoPersonaContacto());
            txtCargoPersonaContacto.setDisabled(false);
            txtCelular.setValue(entity.getCelular());
            txtCelular.setDisabled(false);
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtEmail.setValue(entity.getEmail());
            txtEmail.setDisabled(false);
            txtNit.setValue(entity.getNit());
            txtNit.setDisabled(false);
            txtNombrePersonaContacto.setValue(entity.getNombrePersonaContacto());
            txtNombrePersonaContacto.setDisabled(false);
            txtRazonSocial.setValue(entity.getRazonSocial());
            txtRazonSocial.setDisabled(false);
            txtSitioWeb.setValue(entity.getSitioWeb());
            txtSitioWeb.setDisabled(false);
            txtTelefono.setValue(entity.getTelefono());
            txtTelefono.setDisabled(false);
            txtIdUsuario.setValue(entity.getIdUsuario());
            txtIdUsuario.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedUsuario"));
        txtCargoPersonaContacto.setValue(selectedUsuario.getCargoPersonaContacto());
        txtCargoPersonaContacto.setDisabled(false);
        txtCelular.setValue(selectedUsuario.getCelular());
        txtCelular.setDisabled(false);
        txtDateIn.setValue(selectedUsuario.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedUsuario.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtEmail.setValue(selectedUsuario.getEmail());
        txtEmail.setDisabled(false);
        txtNit.setValue(selectedUsuario.getNit());
        txtNit.setDisabled(false);
        txtNombrePersonaContacto.setValue(selectedUsuario.getNombrePersonaContacto());
        txtNombrePersonaContacto.setDisabled(false);
        txtRazonSocial.setValue(selectedUsuario.getRazonSocial());
        txtRazonSocial.setDisabled(false);
        txtSitioWeb.setValue(selectedUsuario.getSitioWeb());
        txtSitioWeb.setDisabled(false);
        txtTelefono.setValue(selectedUsuario.getTelefono());
        txtTelefono.setDisabled(false);
        txtIdUsuario.setValue(selectedUsuario.getIdUsuario());
        txtIdUsuario.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuario == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Usuario();

            Integer idUsuario = FacesUtils.checkInteger(txtIdUsuario);

            entity.setCargoPersonaContacto(FacesUtils.checkString(
                    txtCargoPersonaContacto));
            entity.setCelular(FacesUtils.checkString(txtCelular));
            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setIdUsuario(idUsuario);
            entity.setNit(FacesUtils.checkString(txtNit));
            entity.setNombrePersonaContacto(FacesUtils.checkString(
                    txtNombrePersonaContacto));
            entity.setRazonSocial(FacesUtils.checkString(txtRazonSocial));
            entity.setSitioWeb(FacesUtils.checkString(txtSitioWeb));
            entity.setTelefono(FacesUtils.checkString(txtTelefono));
            businessDelegatorView.saveUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer idUsuario = new Integer(selectedUsuario.getIdUsuario());
                entity = businessDelegatorView.getUsuario(idUsuario);
            }

            entity.setCargoPersonaContacto(FacesUtils.checkString(
                    txtCargoPersonaContacto));
            entity.setCelular(FacesUtils.checkString(txtCelular));
            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setNit(FacesUtils.checkString(txtNit));
            entity.setNombrePersonaContacto(FacesUtils.checkString(
                    txtNombrePersonaContacto));
            entity.setRazonSocial(FacesUtils.checkString(txtRazonSocial));
            entity.setSitioWeb(FacesUtils.checkString(txtSitioWeb));
            entity.setTelefono(FacesUtils.checkString(txtTelefono));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Integer idUsuario = new Integer(selectedUsuario.getIdUsuario());
            entity = businessDelegatorView.getUsuario(idUsuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idUsuario = FacesUtils.checkInteger(txtIdUsuario);
            entity = businessDelegatorView.getUsuario(idUsuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String cargoPersonaContacto,
        String celular, Date dateIn, Date dateUpdate, String email,
        Integer idUsuario, String nit, String nombrePersonaContacto,
        String razonSocial, String sitioWeb, String telefono)
        throws Exception {
        try {
            entity.setCargoPersonaContacto(FacesUtils.checkString(
                    cargoPersonaContacto));
            entity.setCelular(FacesUtils.checkString(celular));
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setEmail(FacesUtils.checkString(email));
            entity.setNit(FacesUtils.checkString(nit));
            entity.setNombrePersonaContacto(FacesUtils.checkString(
                    nombrePersonaContacto));
            entity.setRazonSocial(FacesUtils.checkString(razonSocial));
            entity.setSitioWeb(FacesUtils.checkString(sitioWeb));
            entity.setTelefono(FacesUtils.checkString(telefono));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
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

    public InputText getTxtNit() {
        return txtNit;
    }

    public void setTxtNit(InputText txtNit) {
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

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
