package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;
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
public class CategoriaProgramaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CategoriaProgramaView.class);
    private InputText txtDescripcion;
    private InputText txtIdCategoriaPrograma;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CategoriaProgramaDTO> data;
    private CategoriaProgramaDTO selectedCategoriaPrograma;
    private CategoriaPrograma entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CategoriaProgramaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCategoriaPrograma = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCategoriaPrograma = null;

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdCategoriaPrograma != null) {
            txtIdCategoriaPrograma.setValue(null);
            txtIdCategoriaPrograma.setDisabled(false);
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
            Integer idCategoriaPrograma = FacesUtils.checkInteger(txtIdCategoriaPrograma);
            entity = (idCategoriaPrograma != null)
                ? businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdCategoriaPrograma.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtIdCategoriaPrograma.setValue(entity.getIdCategoriaPrograma());
            txtIdCategoriaPrograma.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCategoriaPrograma = (CategoriaProgramaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedCategoriaPrograma"));
        txtDateIn.setValue(selectedCategoriaPrograma.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedCategoriaPrograma.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtDescripcion.setValue(selectedCategoriaPrograma.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtIdCategoriaPrograma.setValue(selectedCategoriaPrograma.getIdCategoriaPrograma());
        txtIdCategoriaPrograma.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCategoriaPrograma == null) && (entity == null)) {
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
            entity = new CategoriaPrograma();

            Integer idCategoriaPrograma = FacesUtils.checkInteger(txtIdCategoriaPrograma);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setIdCategoriaPrograma(idCategoriaPrograma);
            businessDelegatorView.saveCategoriaPrograma(entity);
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
                Integer idCategoriaPrograma = new Integer(selectedCategoriaPrograma.getIdCategoriaPrograma());
                entity = businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            businessDelegatorView.updateCategoriaPrograma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCategoriaPrograma = (CategoriaProgramaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedCategoriaPrograma"));

            Integer idCategoriaPrograma = new Integer(selectedCategoriaPrograma.getIdCategoriaPrograma());
            entity = businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idCategoriaPrograma = FacesUtils.checkInteger(txtIdCategoriaPrograma);
            entity = businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCategoriaPrograma(entity);
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
        String descripcion, Integer idCategoriaPrograma)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            businessDelegatorView.updateCategoriaPrograma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CategoriaProgramaView").requestRender();
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

    public InputText getTxtIdCategoriaPrograma() {
        return txtIdCategoriaPrograma;
    }

    public void setTxtIdCategoriaPrograma(InputText txtIdCategoriaPrograma) {
        this.txtIdCategoriaPrograma = txtIdCategoriaPrograma;
    }

    public List<CategoriaProgramaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCategoriaPrograma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CategoriaProgramaDTO> categoriaProgramaDTO) {
        this.data = categoriaProgramaDTO;
    }

    public CategoriaProgramaDTO getSelectedCategoriaPrograma() {
        return selectedCategoriaPrograma;
    }

    public void setSelectedCategoriaPrograma(
        CategoriaProgramaDTO categoriaPrograma) {
        this.selectedCategoriaPrograma = categoriaPrograma;
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
