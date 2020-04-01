package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;
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
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class CampoRegistroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CampoRegistroView.class);
    private InputText txtMagnitud;
    private InputText txtNombre;
    private InputText txtPrioridad;
    private InputText txtTipo;
    private InputText txtIdDatoObjetivo_DatoObjetivo;
    private InputText txtIdCampoRegistro;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CampoRegistroDTO> data;
    private CampoRegistroDTO selectedCampoRegistro;
    private CampoRegistro entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CampoRegistroView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCampoRegistro = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCampoRegistro = null;

        if (txtMagnitud != null) {
            txtMagnitud.setValue(null);
            txtMagnitud.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtPrioridad != null) {
            txtPrioridad.setValue(null);
            txtPrioridad.setDisabled(true);
        }

        if (txtTipo != null) {
            txtTipo.setValue(null);
            txtTipo.setDisabled(true);
        }

        if (txtIdDatoObjetivo_DatoObjetivo != null) {
            txtIdDatoObjetivo_DatoObjetivo.setValue(null);
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdCampoRegistro != null) {
            txtIdCampoRegistro.setValue(null);
            txtIdCampoRegistro.setDisabled(false);
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
            Integer idCampoRegistro = FacesUtils.checkInteger(txtIdCampoRegistro);
            entity = (idCampoRegistro != null)
                ? businessDelegatorView.getCampoRegistro(idCampoRegistro) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtMagnitud.setDisabled(false);
            txtNombre.setDisabled(false);
            txtPrioridad.setDisabled(false);
            txtTipo.setDisabled(false);
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdCampoRegistro.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtMagnitud.setValue(entity.getMagnitud());
            txtMagnitud.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtPrioridad.setValue(entity.getPrioridad());
            txtPrioridad.setDisabled(false);
            txtTipo.setValue(entity.getTipo());
            txtTipo.setDisabled(false);
            txtIdDatoObjetivo_DatoObjetivo.setValue(entity.getDatoObjetivo()
                                                          .getIdDatoObjetivo());
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
            txtIdCampoRegistro.setValue(entity.getIdCampoRegistro());
            txtIdCampoRegistro.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCampoRegistro = (CampoRegistroDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedCampoRegistro"));
        txtDateIn.setValue(selectedCampoRegistro.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedCampoRegistro.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtMagnitud.setValue(selectedCampoRegistro.getMagnitud());
        txtMagnitud.setDisabled(false);
        txtNombre.setValue(selectedCampoRegistro.getNombre());
        txtNombre.setDisabled(false);
        txtPrioridad.setValue(selectedCampoRegistro.getPrioridad());
        txtPrioridad.setDisabled(false);
        txtTipo.setValue(selectedCampoRegistro.getTipo());
        txtTipo.setDisabled(false);
        txtIdDatoObjetivo_DatoObjetivo.setValue(selectedCampoRegistro.getIdDatoObjetivo_DatoObjetivo());
        txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
        txtIdCampoRegistro.setValue(selectedCampoRegistro.getIdCampoRegistro());
        txtIdCampoRegistro.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCampoRegistro == null) && (entity == null)) {
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
            entity = new CampoRegistro();

            Integer idCampoRegistro = FacesUtils.checkInteger(txtIdCampoRegistro);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdCampoRegistro(idCampoRegistro);
            entity.setMagnitud(FacesUtils.checkString(txtMagnitud));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrioridad(FacesUtils.checkInteger(txtPrioridad));
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setDatoObjetivo((FacesUtils.checkInteger(
                    txtIdDatoObjetivo_DatoObjetivo) != null)
                ? businessDelegatorView.getDatoObjetivo(FacesUtils.checkInteger(
                        txtIdDatoObjetivo_DatoObjetivo)) : null);
            businessDelegatorView.saveCampoRegistro(entity);
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
                Integer idCampoRegistro = new Integer(selectedCampoRegistro.getIdCampoRegistro());
                entity = businessDelegatorView.getCampoRegistro(idCampoRegistro);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setMagnitud(FacesUtils.checkString(txtMagnitud));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrioridad(FacesUtils.checkInteger(txtPrioridad));
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setDatoObjetivo((FacesUtils.checkInteger(
                    txtIdDatoObjetivo_DatoObjetivo) != null)
                ? businessDelegatorView.getDatoObjetivo(FacesUtils.checkInteger(
                        txtIdDatoObjetivo_DatoObjetivo)) : null);
            businessDelegatorView.updateCampoRegistro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCampoRegistro = (CampoRegistroDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedCampoRegistro"));

            Integer idCampoRegistro = new Integer(selectedCampoRegistro.getIdCampoRegistro());
            entity = businessDelegatorView.getCampoRegistro(idCampoRegistro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idCampoRegistro = FacesUtils.checkInteger(txtIdCampoRegistro);
            entity = businessDelegatorView.getCampoRegistro(idCampoRegistro);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCampoRegistro(entity);
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

    public String action_modifyWitDTO(Date dateIn, Date dateUpdate,
        Integer idCampoRegistro, String magnitud, String nombre,
        Integer prioridad, String tipo, Integer idDatoObjetivo_DatoObjetivo)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setMagnitud(FacesUtils.checkString(magnitud));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setPrioridad(FacesUtils.checkInteger(prioridad));
            entity.setTipo(FacesUtils.checkString(tipo));
            businessDelegatorView.updateCampoRegistro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CampoRegistroView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtMagnitud() {
        return txtMagnitud;
    }

    public void setTxtMagnitud(InputText txtMagnitud) {
        this.txtMagnitud = txtMagnitud;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtPrioridad() {
        return txtPrioridad;
    }

    public void setTxtPrioridad(InputText txtPrioridad) {
        this.txtPrioridad = txtPrioridad;
    }

    public InputText getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(InputText txtTipo) {
        this.txtTipo = txtTipo;
    }

    public InputText getTxtIdDatoObjetivo_DatoObjetivo() {
        return txtIdDatoObjetivo_DatoObjetivo;
    }

    public void setTxtIdDatoObjetivo_DatoObjetivo(
        InputText txtIdDatoObjetivo_DatoObjetivo) {
        this.txtIdDatoObjetivo_DatoObjetivo = txtIdDatoObjetivo_DatoObjetivo;
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

    public InputText getTxtIdCampoRegistro() {
        return txtIdCampoRegistro;
    }

    public void setTxtIdCampoRegistro(InputText txtIdCampoRegistro) {
        this.txtIdCampoRegistro = txtIdCampoRegistro;
    }

    public List<CampoRegistroDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCampoRegistro();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CampoRegistroDTO> campoRegistroDTO) {
        this.data = campoRegistroDTO;
    }

    public CampoRegistroDTO getSelectedCampoRegistro() {
        return selectedCampoRegistro;
    }

    public void setSelectedCampoRegistro(CampoRegistroDTO campoRegistro) {
        this.selectedCampoRegistro = campoRegistro;
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
