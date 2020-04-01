package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
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
public class RequisitoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RequisitoView.class);
    private InputText txtDescripcion;
    private InputText txtNumeral;
    private InputText txtIdCategoriaRequisito_CategoriaRequisito;
    private InputText txtIdNorma_Norma;
    private InputText txtIdRequisito;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RequisitoDTO> data;
    private RequisitoDTO selectedRequisito;
    private Requisito entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RequisitoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRequisito = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRequisito = null;

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtNumeral != null) {
            txtNumeral.setValue(null);
            txtNumeral.setDisabled(true);
        }

        if (txtIdCategoriaRequisito_CategoriaRequisito != null) {
            txtIdCategoriaRequisito_CategoriaRequisito.setValue(null);
            txtIdCategoriaRequisito_CategoriaRequisito.setDisabled(true);
        }

        if (txtIdNorma_Norma != null) {
            txtIdNorma_Norma.setValue(null);
            txtIdNorma_Norma.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdRequisito != null) {
            txtIdRequisito.setValue(null);
            txtIdRequisito.setDisabled(false);
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
            Integer idRequisito = FacesUtils.checkInteger(txtIdRequisito);
            entity = (idRequisito != null)
                ? businessDelegatorView.getRequisito(idRequisito) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtNumeral.setDisabled(false);
            txtIdCategoriaRequisito_CategoriaRequisito.setDisabled(false);
            txtIdNorma_Norma.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdRequisito.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtNumeral.setValue(entity.getNumeral());
            txtNumeral.setDisabled(false);
            txtIdCategoriaRequisito_CategoriaRequisito.setValue(entity.getCategoriaRequisito()
                                                                      .getIdCategoriaRequisito());
            txtIdCategoriaRequisito_CategoriaRequisito.setDisabled(false);
            txtIdNorma_Norma.setValue(entity.getNorma().getIdNorma());
            txtIdNorma_Norma.setDisabled(false);
            txtIdRequisito.setValue(entity.getIdRequisito());
            txtIdRequisito.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRequisito = (RequisitoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedRequisito"));
        txtDateIn.setValue(selectedRequisito.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedRequisito.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtDescripcion.setValue(selectedRequisito.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtNumeral.setValue(selectedRequisito.getNumeral());
        txtNumeral.setDisabled(false);
        txtIdCategoriaRequisito_CategoriaRequisito.setValue(selectedRequisito.getIdCategoriaRequisito_CategoriaRequisito());
        txtIdCategoriaRequisito_CategoriaRequisito.setDisabled(false);
        txtIdNorma_Norma.setValue(selectedRequisito.getIdNorma_Norma());
        txtIdNorma_Norma.setDisabled(false);
        txtIdRequisito.setValue(selectedRequisito.getIdRequisito());
        txtIdRequisito.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRequisito == null) && (entity == null)) {
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
            entity = new Requisito();

            Integer idRequisito = FacesUtils.checkInteger(txtIdRequisito);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setIdRequisito(idRequisito);
            entity.setNumeral(FacesUtils.checkString(txtNumeral));
            entity.setCategoriaRequisito((FacesUtils.checkInteger(
                    txtIdCategoriaRequisito_CategoriaRequisito) != null)
                ? businessDelegatorView.getCategoriaRequisito(
                    FacesUtils.checkInteger(
                        txtIdCategoriaRequisito_CategoriaRequisito)) : null);
            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            businessDelegatorView.saveRequisito(entity);
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
                Integer idRequisito = new Integer(selectedRequisito.getIdRequisito());
                entity = businessDelegatorView.getRequisito(idRequisito);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setNumeral(FacesUtils.checkString(txtNumeral));
            entity.setCategoriaRequisito((FacesUtils.checkInteger(
                    txtIdCategoriaRequisito_CategoriaRequisito) != null)
                ? businessDelegatorView.getCategoriaRequisito(
                    FacesUtils.checkInteger(
                        txtIdCategoriaRequisito_CategoriaRequisito)) : null);
            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            businessDelegatorView.updateRequisito(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRequisito = (RequisitoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedRequisito"));

            Integer idRequisito = new Integer(selectedRequisito.getIdRequisito());
            entity = businessDelegatorView.getRequisito(idRequisito);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idRequisito = FacesUtils.checkInteger(txtIdRequisito);
            entity = businessDelegatorView.getRequisito(idRequisito);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRequisito(entity);
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
        String descripcion, Integer idRequisito, String numeral,
        Integer idCategoriaRequisito_CategoriaRequisito, Integer idNorma_Norma)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setNumeral(FacesUtils.checkString(numeral));
            businessDelegatorView.updateRequisito(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RequisitoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtNumeral() {
        return txtNumeral;
    }

    public void setTxtNumeral(InputText txtNumeral) {
        this.txtNumeral = txtNumeral;
    }

    public InputText getTxtIdCategoriaRequisito_CategoriaRequisito() {
        return txtIdCategoriaRequisito_CategoriaRequisito;
    }

    public void setTxtIdCategoriaRequisito_CategoriaRequisito(
        InputText txtIdCategoriaRequisito_CategoriaRequisito) {
        this.txtIdCategoriaRequisito_CategoriaRequisito = txtIdCategoriaRequisito_CategoriaRequisito;
    }

    public InputText getTxtIdNorma_Norma() {
        return txtIdNorma_Norma;
    }

    public void setTxtIdNorma_Norma(InputText txtIdNorma_Norma) {
        this.txtIdNorma_Norma = txtIdNorma_Norma;
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

    public InputText getTxtIdRequisito() {
        return txtIdRequisito;
    }

    public void setTxtIdRequisito(InputText txtIdRequisito) {
        this.txtIdRequisito = txtIdRequisito;
    }

    public List<RequisitoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRequisito();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RequisitoDTO> requisitoDTO) {
        this.data = requisitoDTO;
    }

    public RequisitoDTO getSelectedRequisito() {
        return selectedRequisito;
    }

    public void setSelectedRequisito(RequisitoDTO requisito) {
        this.selectedRequisito = requisito;
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
