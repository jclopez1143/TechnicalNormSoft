package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;
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
public class ValorCampoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ValorCampoView.class);
    private InputText txtValor;
    private InputText txtIdCampoRegistro_CampoRegistro;
    private InputText txtIdRegistroDato_RegistroDato;
    private InputText txtIdValorCampo;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ValorCampoDTO> data;
    private ValorCampoDTO selectedValorCampo;
    private ValorCampo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ValorCampoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedValorCampo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedValorCampo = null;

        if (txtValor != null) {
            txtValor.setValue(null);
            txtValor.setDisabled(true);
        }

        if (txtIdCampoRegistro_CampoRegistro != null) {
            txtIdCampoRegistro_CampoRegistro.setValue(null);
            txtIdCampoRegistro_CampoRegistro.setDisabled(true);
        }

        if (txtIdRegistroDato_RegistroDato != null) {
            txtIdRegistroDato_RegistroDato.setValue(null);
            txtIdRegistroDato_RegistroDato.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdValorCampo != null) {
            txtIdValorCampo.setValue(null);
            txtIdValorCampo.setDisabled(false);
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
            Integer idValorCampo = FacesUtils.checkInteger(txtIdValorCampo);
            entity = (idValorCampo != null)
                ? businessDelegatorView.getValorCampo(idValorCampo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtValor.setDisabled(false);
            txtIdCampoRegistro_CampoRegistro.setDisabled(false);
            txtIdRegistroDato_RegistroDato.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdValorCampo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtValor.setValue(entity.getValor());
            txtValor.setDisabled(false);
            txtIdCampoRegistro_CampoRegistro.setValue(entity.getCampoRegistro()
                                                            .getIdCampoRegistro());
            txtIdCampoRegistro_CampoRegistro.setDisabled(false);
            txtIdRegistroDato_RegistroDato.setValue(entity.getRegistroDato()
                                                          .getIdRegistroDato());
            txtIdRegistroDato_RegistroDato.setDisabled(false);
            txtIdValorCampo.setValue(entity.getIdValorCampo());
            txtIdValorCampo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedValorCampo = (ValorCampoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedValorCampo"));
        txtDateIn.setValue(selectedValorCampo.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedValorCampo.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtValor.setValue(selectedValorCampo.getValor());
        txtValor.setDisabled(false);
        txtIdCampoRegistro_CampoRegistro.setValue(selectedValorCampo.getIdCampoRegistro_CampoRegistro());
        txtIdCampoRegistro_CampoRegistro.setDisabled(false);
        txtIdRegistroDato_RegistroDato.setValue(selectedValorCampo.getIdRegistroDato_RegistroDato());
        txtIdRegistroDato_RegistroDato.setDisabled(false);
        txtIdValorCampo.setValue(selectedValorCampo.getIdValorCampo());
        txtIdValorCampo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedValorCampo == null) && (entity == null)) {
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
            entity = new ValorCampo();

            Integer idValorCampo = FacesUtils.checkInteger(txtIdValorCampo);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdValorCampo(idValorCampo);
            entity.setValor(FacesUtils.checkString(txtValor));
            entity.setCampoRegistro((FacesUtils.checkInteger(
                    txtIdCampoRegistro_CampoRegistro) != null)
                ? businessDelegatorView.getCampoRegistro(
                    FacesUtils.checkInteger(txtIdCampoRegistro_CampoRegistro))
                : null);
            entity.setRegistroDato((FacesUtils.checkInteger(
                    txtIdRegistroDato_RegistroDato) != null)
                ? businessDelegatorView.getRegistroDato(FacesUtils.checkInteger(
                        txtIdRegistroDato_RegistroDato)) : null);
            businessDelegatorView.saveValorCampo(entity);
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
                Integer idValorCampo = new Integer(selectedValorCampo.getIdValorCampo());
                entity = businessDelegatorView.getValorCampo(idValorCampo);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setValor(FacesUtils.checkString(txtValor));
            entity.setCampoRegistro((FacesUtils.checkInteger(
                    txtIdCampoRegistro_CampoRegistro) != null)
                ? businessDelegatorView.getCampoRegistro(
                    FacesUtils.checkInteger(txtIdCampoRegistro_CampoRegistro))
                : null);
            entity.setRegistroDato((FacesUtils.checkInteger(
                    txtIdRegistroDato_RegistroDato) != null)
                ? businessDelegatorView.getRegistroDato(FacesUtils.checkInteger(
                        txtIdRegistroDato_RegistroDato)) : null);
            businessDelegatorView.updateValorCampo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedValorCampo = (ValorCampoDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedValorCampo"));

            Integer idValorCampo = new Integer(selectedValorCampo.getIdValorCampo());
            entity = businessDelegatorView.getValorCampo(idValorCampo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idValorCampo = FacesUtils.checkInteger(txtIdValorCampo);
            entity = businessDelegatorView.getValorCampo(idValorCampo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteValorCampo(entity);
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
        Integer idValorCampo, String valor,
        Integer idCampoRegistro_CampoRegistro,
        Integer idRegistroDato_RegistroDato) throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setValor(FacesUtils.checkString(valor));
            businessDelegatorView.updateValorCampo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ValorCampoView").requestRender();
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

    public InputText getTxtIdCampoRegistro_CampoRegistro() {
        return txtIdCampoRegistro_CampoRegistro;
    }

    public void setTxtIdCampoRegistro_CampoRegistro(
        InputText txtIdCampoRegistro_CampoRegistro) {
        this.txtIdCampoRegistro_CampoRegistro = txtIdCampoRegistro_CampoRegistro;
    }

    public InputText getTxtIdRegistroDato_RegistroDato() {
        return txtIdRegistroDato_RegistroDato;
    }

    public void setTxtIdRegistroDato_RegistroDato(
        InputText txtIdRegistroDato_RegistroDato) {
        this.txtIdRegistroDato_RegistroDato = txtIdRegistroDato_RegistroDato;
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

    public InputText getTxtIdValorCampo() {
        return txtIdValorCampo;
    }

    public void setTxtIdValorCampo(InputText txtIdValorCampo) {
        this.txtIdValorCampo = txtIdValorCampo;
    }

    public List<ValorCampoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataValorCampo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ValorCampoDTO> valorCampoDTO) {
        this.data = valorCampoDTO;
    }

    public ValorCampoDTO getSelectedValorCampo() {
        return selectedValorCampo;
    }

    public void setSelectedValorCampo(ValorCampoDTO valorCampo) {
        this.selectedValorCampo = valorCampo;
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
