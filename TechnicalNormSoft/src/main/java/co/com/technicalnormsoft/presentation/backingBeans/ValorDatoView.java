package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;
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
public class ValorDatoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ValorDatoView.class);
    private InputText txtValor;
    private InputText txtIdDatoObjetivo_DatoObjetivo;
    private InputText txtEstablecimientoObjetivoId_EstablecimientoObjetivo;
    private InputText txtIdValorDato;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ValorDatoDTO> data;
    private ValorDatoDTO selectedValorDato;
    private ValorDato entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ValorDatoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedValorDato = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedValorDato = null;

        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
        }

        if (txtIdDatoObjetivo_DatoObjetivo != null) {
            txtIdDatoObjetivo_DatoObjetivo.setValue(null);
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(true);
        }

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

        if (txtIdValorDato != null) {
            txtIdValorDato.setValue(null);
            txtIdValorDato.setDisabled(false);
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
            Integer idValorDato = FacesUtils.checkInteger(txtIdValorDato);
            entity = (idValorDato != null)
                ? businessDelegatorView.getValorDato(idValorDato) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtValor.setDisabled(false);
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdValorDato.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtValor.setValue(entity.getValor());
            txtValor.setDisabled(false);
            txtIdDatoObjetivo_DatoObjetivo.setValue(entity.getDatoObjetivo()
                                                          .getIdDatoObjetivo());
            txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setValue(entity.getEstablecimientoObjetivo()
                                                                                .getEstablecimientoObjetivoId());
            txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
            txtIdValorDato.setValue(entity.getIdValorDato());
            txtIdValorDato.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedValorDato = (ValorDatoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedValorDato"));
        txtDateIn.setValue(selectedValorDato.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedValorDato.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtValor.setValue(selectedValorDato.getValor());
        txtValor.setDisabled(false);
        txtIdDatoObjetivo_DatoObjetivo.setValue(selectedValorDato.getIdDatoObjetivo_DatoObjetivo());
        txtIdDatoObjetivo_DatoObjetivo.setDisabled(false);
        txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setValue(selectedValorDato.getEstablecimientoObjetivoId_EstablecimientoObjetivo());
        txtEstablecimientoObjetivoId_EstablecimientoObjetivo.setDisabled(false);
        txtIdValorDato.setValue(selectedValorDato.getIdValorDato());
        txtIdValorDato.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedValorDato == null) && (entity == null)) {
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
            entity = new ValorDato();

            Integer idValorDato = FacesUtils.checkInteger(txtIdValorDato);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdValorDato(idValorDato);
            entity.setValor(FacesUtils.checkString(txtValor));
            entity.setDatoObjetivo((FacesUtils.checkInteger(
                    txtIdDatoObjetivo_DatoObjetivo) != null)
                ? businessDelegatorView.getDatoObjetivo(FacesUtils.checkInteger(
                        txtIdDatoObjetivo_DatoObjetivo)) : null);
            entity.setEstablecimientoObjetivo((FacesUtils.checkInteger(
                    txtEstablecimientoObjetivoId_EstablecimientoObjetivo) != null)
                ? businessDelegatorView.getEstablecimientoObjetivo(
                    FacesUtils.checkInteger(
                        txtEstablecimientoObjetivoId_EstablecimientoObjetivo))
                : null);
            businessDelegatorView.saveValorDato(entity);
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
                Integer idValorDato = new Integer(selectedValorDato.getIdValorDato());
                entity = businessDelegatorView.getValorDato(idValorDato);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setValor(FacesUtils.checkString(txtValor));
            entity.setDatoObjetivo((FacesUtils.checkInteger(
                    txtIdDatoObjetivo_DatoObjetivo) != null)
                ? businessDelegatorView.getDatoObjetivo(FacesUtils.checkInteger(
                        txtIdDatoObjetivo_DatoObjetivo)) : null);
            entity.setEstablecimientoObjetivo((FacesUtils.checkInteger(
                    txtEstablecimientoObjetivoId_EstablecimientoObjetivo) != null)
                ? businessDelegatorView.getEstablecimientoObjetivo(
                    FacesUtils.checkInteger(
                        txtEstablecimientoObjetivoId_EstablecimientoObjetivo))
                : null);
            businessDelegatorView.updateValorDato(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedValorDato = (ValorDatoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedValorDato"));

            Integer idValorDato = new Integer(selectedValorDato.getIdValorDato());
            entity = businessDelegatorView.getValorDato(idValorDato);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idValorDato = FacesUtils.checkInteger(txtIdValorDato);
            entity = businessDelegatorView.getValorDato(idValorDato);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteValorDato(entity);
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
        Integer idValorDato, String valor, Integer idDatoObjetivo_DatoObjetivo,
        Integer establecimientoObjetivoId_EstablecimientoObjetivo)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setValor(FacesUtils.checkString(valor));
            businessDelegatorView.updateValorDato(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ValorDatoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(InputText txtValor) {
        this.txtValor = txtValor;
    }

    public InputText getTxtIdDatoObjetivo_DatoObjetivo() {
        return txtIdDatoObjetivo_DatoObjetivo;
    }

    public void setTxtIdDatoObjetivo_DatoObjetivo(
        InputText txtIdDatoObjetivo_DatoObjetivo) {
        this.txtIdDatoObjetivo_DatoObjetivo = txtIdDatoObjetivo_DatoObjetivo;
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

    public InputText getTxtIdValorDato() {
        return txtIdValorDato;
    }

    public void setTxtIdValorDato(InputText txtIdValorDato) {
        this.txtIdValorDato = txtIdValorDato;
    }

    public List<ValorDatoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataValorDato();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ValorDatoDTO> valorDatoDTO) {
        this.data = valorDatoDTO;
    }

    public ValorDatoDTO getSelectedValorDato() {
        return selectedValorDato;
    }

    public void setSelectedValorDato(ValorDatoDTO valorDato) {
        this.selectedValorDato = valorDato;
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
