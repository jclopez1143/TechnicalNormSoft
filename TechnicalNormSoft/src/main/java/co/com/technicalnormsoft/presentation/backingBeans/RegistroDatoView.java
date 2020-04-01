package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;
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
public class RegistroDatoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RegistroDatoView.class);
    private InputText txtEstablecimientoObjetivoId_EstablecimientoObjetivo;
    private InputText txtIdRegistroDato;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RegistroDatoDTO> data;
    private RegistroDatoDTO selectedRegistroDato;
    private RegistroDato entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RegistroDatoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRegistroDato = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRegistroDato = null;

        if (txtEstablecimientoObjetivoId_EstablecimientoObjetivo != null) {
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setValue(null);
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdRegistroDato != null) {
            txtIdRegistroDato.setValue(null);
            txtIdRegistroDato.setDisabled(false);
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
            Integer idRegistroDato = FacesUtils.checkInteger(txtIdRegistroDato);
            entity = (idRegistroDato != null)
                ? businessDelegatorView.getRegistroDato(idRegistroDato) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdRegistroDato.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setValue(entity.getEstablecimientoObjetivo()
                                                                                .getEstablecimientoObjetivoId());
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
            txtIdRegistroDato.setValue(entity.getIdRegistroDato());
            txtIdRegistroDato.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRegistroDato = (RegistroDatoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedRegistroDato"));
        txtDateIn.setValue(selectedRegistroDato.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedRegistroDato.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setValue(selectedRegistroDato.getEstablecimientoObjetivoId_EstablecimientoObjetivo());
        txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
        txtIdRegistroDato.setValue(selectedRegistroDato.getIdRegistroDato());
        txtIdRegistroDato.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRegistroDato == null) && (entity == null)) {
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
            entity = new RegistroDato();

            Integer idRegistroDato = FacesUtils.checkInteger(txtIdRegistroDato);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdRegistroDato(idRegistroDato);
            entity.setEstablecimientoObjetivo((FacesUtils.checkInteger(
                    txtEstablecimientoObjetivoId_EstablecimientoObjetivo) != null)
                ? businessDelegatorView.getEstablecimientoObjetivo(
                    FacesUtils.checkInteger(
                        txtEstablecimientoObjetivoId_EstablecimientoObjetivo))
                : null);
            businessDelegatorView.saveRegistroDato(entity);
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
                Integer idRegistroDato = new Integer(selectedRegistroDato.getIdRegistroDato());
                entity = businessDelegatorView.getRegistroDato(idRegistroDato);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setEstablecimientoObjetivo((FacesUtils.checkInteger(
                    txtEstablecimientoObjetivoId_EstablecimientoObjetivo) != null)
                ? businessDelegatorView.getEstablecimientoObjetivo(
                    FacesUtils.checkInteger(
                        txtEstablecimientoObjetivoId_EstablecimientoObjetivo))
                : null);
            businessDelegatorView.updateRegistroDato(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRegistroDato = (RegistroDatoDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedRegistroDato"));

            Integer idRegistroDato = new Integer(selectedRegistroDato.getIdRegistroDato());
            entity = businessDelegatorView.getRegistroDato(idRegistroDato);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idRegistroDato = FacesUtils.checkInteger(txtIdRegistroDato);
            entity = businessDelegatorView.getRegistroDato(idRegistroDato);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRegistroDato(entity);
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
        Integer idRegistroDato,
        Integer establecimientoObjetivoId_EstablecimientoObjetivo)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            businessDelegatorView.updateRegistroDato(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RegistroDatoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEstablecimientoObjetivoId_EstablecimientoObjetivo() {
        return txtEstablecimientoObjetivoId_EstablecimientoObjetivo;
    }

    public void setTxtEstablecimientoObjetivoId_EstablecimientoObjetivo(
        InputText txtEstablecimientoObjetivoId_EstablecimientoObjetivo) {
        this.txtEstablecimientoObjetivoId_EstablecimientoObjetivo = txtEstablecimientoObjetivoId_EstablecimientoObjetivo;
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

    public InputText getTxtIdRegistroDato() {
        return txtIdRegistroDato;
    }

    public void setTxtIdRegistroDato(InputText txtIdRegistroDato) {
        this.txtIdRegistroDato = txtIdRegistroDato;
    }

    public List<RegistroDatoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRegistroDato();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RegistroDatoDTO> registroDatoDTO) {
        this.data = registroDatoDTO;
    }

    public RegistroDatoDTO getSelectedRegistroDato() {
        return selectedRegistroDato;
    }

    public void setSelectedRegistroDato(RegistroDatoDTO registroDato) {
        this.selectedRegistroDato = registroDato;
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
