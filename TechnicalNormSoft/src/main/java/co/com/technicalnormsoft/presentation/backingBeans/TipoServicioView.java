package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
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
public class TipoServicioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoServicioView.class);
    private InputText txtDescripcion;
    private InputText txtIdTipoServicio;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoServicioDTO> data;
    private TipoServicioDTO selectedTipoServicio;
    private TipoServicio entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipoServicioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoServicio = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoServicio = null;

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

        if (txtIdTipoServicio != null) {
            txtIdTipoServicio.setValue(null);
            txtIdTipoServicio.setDisabled(false);
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
            Integer idTipoServicio = FacesUtils.checkInteger(txtIdTipoServicio);
            entity = (idTipoServicio != null)
                ? businessDelegatorView.getTipoServicio(idTipoServicio) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdTipoServicio.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtIdTipoServicio.setValue(entity.getIdTipoServicio());
            txtIdTipoServicio.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoServicio = (TipoServicioDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedTipoServicio"));
        txtDateIn.setValue(selectedTipoServicio.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedTipoServicio.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtDescripcion.setValue(selectedTipoServicio.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtIdTipoServicio.setValue(selectedTipoServicio.getIdTipoServicio());
        txtIdTipoServicio.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoServicio == null) && (entity == null)) {
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
            entity = new TipoServicio();

            Integer idTipoServicio = FacesUtils.checkInteger(txtIdTipoServicio);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setIdTipoServicio(idTipoServicio);
            businessDelegatorView.saveTipoServicio(entity);
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
                Integer idTipoServicio = new Integer(selectedTipoServicio.getIdTipoServicio());
                entity = businessDelegatorView.getTipoServicio(idTipoServicio);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            businessDelegatorView.updateTipoServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoServicio = (TipoServicioDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedTipoServicio"));

            Integer idTipoServicio = new Integer(selectedTipoServicio.getIdTipoServicio());
            entity = businessDelegatorView.getTipoServicio(idTipoServicio);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idTipoServicio = FacesUtils.checkInteger(txtIdTipoServicio);
            entity = businessDelegatorView.getTipoServicio(idTipoServicio);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoServicio(entity);
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
        String descripcion, Integer idTipoServicio) throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            businessDelegatorView.updateTipoServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoServicioView").requestRender();
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

    public InputText getTxtIdTipoServicio() {
        return txtIdTipoServicio;
    }

    public void setTxtIdTipoServicio(InputText txtIdTipoServicio) {
        this.txtIdTipoServicio = txtIdTipoServicio;
    }

    public List<TipoServicioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoServicio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoServicioDTO> tipoServicioDTO) {
        this.data = tipoServicioDTO;
    }

    public TipoServicioDTO getSelectedTipoServicio() {
        return selectedTipoServicio;
    }

    public void setSelectedTipoServicio(TipoServicioDTO tipoServicio) {
        this.selectedTipoServicio = tipoServicio;
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
