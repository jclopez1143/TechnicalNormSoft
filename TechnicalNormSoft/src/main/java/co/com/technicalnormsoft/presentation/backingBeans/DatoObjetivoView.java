package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;
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
public class DatoObjetivoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatoObjetivoView.class);
    private InputText txtMagnitud;
    private InputText txtNombre;
    private InputText txtPrioridad;
    private InputText txtTipo;
    private InputText txtIdObjetivo_Objetivo;
    private InputText txtIdDatoObjetivo;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DatoObjetivoDTO> data;
    private DatoObjetivoDTO selectedDatoObjetivo;
    private DatoObjetivo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public DatoObjetivoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedDatoObjetivo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDatoObjetivo = null;

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

        if (txtIdObjetivo_Objetivo != null) {
            txtIdObjetivo_Objetivo.setValue(null);
            txtIdObjetivo_Objetivo.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdDatoObjetivo != null) {
            txtIdDatoObjetivo.setValue(null);
            txtIdDatoObjetivo.setDisabled(false);
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
            Integer idDatoObjetivo = FacesUtils.checkInteger(txtIdDatoObjetivo);
            entity = (idDatoObjetivo != null)
                ? businessDelegatorView.getDatoObjetivo(idDatoObjetivo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtMagnitud.setDisabled(false);
            txtNombre.setDisabled(false);
            txtPrioridad.setDisabled(false);
            txtTipo.setDisabled(false);
            txtIdObjetivo_Objetivo.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdDatoObjetivo.setDisabled(false);
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
            txtIdObjetivo_Objetivo.setValue(entity.getObjetivo().getIdObjetivo());
            txtIdObjetivo_Objetivo.setDisabled(false);
            txtIdDatoObjetivo.setValue(entity.getIdDatoObjetivo());
            txtIdDatoObjetivo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedDatoObjetivo = (DatoObjetivoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedDatoObjetivo"));
        txtDateIn.setValue(selectedDatoObjetivo.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedDatoObjetivo.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtMagnitud.setValue(selectedDatoObjetivo.getMagnitud());
        txtMagnitud.setDisabled(false);
        txtNombre.setValue(selectedDatoObjetivo.getNombre());
        txtNombre.setDisabled(false);
        txtPrioridad.setValue(selectedDatoObjetivo.getPrioridad());
        txtPrioridad.setDisabled(false);
        txtTipo.setValue(selectedDatoObjetivo.getTipo());
        txtTipo.setDisabled(false);
        txtIdObjetivo_Objetivo.setValue(selectedDatoObjetivo.getIdObjetivo_Objetivo());
        txtIdObjetivo_Objetivo.setDisabled(false);
        txtIdDatoObjetivo.setValue(selectedDatoObjetivo.getIdDatoObjetivo());
        txtIdDatoObjetivo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDatoObjetivo == null) && (entity == null)) {
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
            entity = new DatoObjetivo();

            Integer idDatoObjetivo = FacesUtils.checkInteger(txtIdDatoObjetivo);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdDatoObjetivo(idDatoObjetivo);
            entity.setMagnitud(FacesUtils.checkString(txtMagnitud));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrioridad(FacesUtils.checkInteger(txtPrioridad));
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setObjetivo((FacesUtils.checkInteger(txtIdObjetivo_Objetivo) != null)
                ? businessDelegatorView.getObjetivo(FacesUtils.checkInteger(
                        txtIdObjetivo_Objetivo)) : null);
            businessDelegatorView.saveDatoObjetivo(entity);
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
                Integer idDatoObjetivo = new Integer(selectedDatoObjetivo.getIdDatoObjetivo());
                entity = businessDelegatorView.getDatoObjetivo(idDatoObjetivo);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setMagnitud(FacesUtils.checkString(txtMagnitud));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setPrioridad(FacesUtils.checkInteger(txtPrioridad));
            entity.setTipo(FacesUtils.checkString(txtTipo));
            entity.setObjetivo((FacesUtils.checkInteger(txtIdObjetivo_Objetivo) != null)
                ? businessDelegatorView.getObjetivo(FacesUtils.checkInteger(
                        txtIdObjetivo_Objetivo)) : null);
            businessDelegatorView.updateDatoObjetivo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDatoObjetivo = (DatoObjetivoDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedDatoObjetivo"));

            Integer idDatoObjetivo = new Integer(selectedDatoObjetivo.getIdDatoObjetivo());
            entity = businessDelegatorView.getDatoObjetivo(idDatoObjetivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idDatoObjetivo = FacesUtils.checkInteger(txtIdDatoObjetivo);
            entity = businessDelegatorView.getDatoObjetivo(idDatoObjetivo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteDatoObjetivo(entity);
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
        Integer idDatoObjetivo, String magnitud, String nombre,
        Integer prioridad, String tipo, Integer idObjetivo_Objetivo)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setMagnitud(FacesUtils.checkString(magnitud));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setPrioridad(FacesUtils.checkInteger(prioridad));
            entity.setTipo(FacesUtils.checkString(tipo));
            businessDelegatorView.updateDatoObjetivo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DatoObjetivoView").requestRender();
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

    public InputText getTxtIdObjetivo_Objetivo() {
        return txtIdObjetivo_Objetivo;
    }

    public void setTxtIdObjetivo_Objetivo(InputText txtIdObjetivo_Objetivo) {
        this.txtIdObjetivo_Objetivo = txtIdObjetivo_Objetivo;
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

    public InputText getTxtIdDatoObjetivo() {
        return txtIdDatoObjetivo;
    }

    public void setTxtIdDatoObjetivo(InputText txtIdDatoObjetivo) {
        this.txtIdDatoObjetivo = txtIdDatoObjetivo;
    }

    public List<DatoObjetivoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDatoObjetivo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DatoObjetivoDTO> datoObjetivoDTO) {
        this.data = datoObjetivoDTO;
    }

    public DatoObjetivoDTO getSelectedDatoObjetivo() {
        return selectedDatoObjetivo;
    }

    public void setSelectedDatoObjetivo(DatoObjetivoDTO datoObjetivo) {
        this.selectedDatoObjetivo = datoObjetivo;
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
