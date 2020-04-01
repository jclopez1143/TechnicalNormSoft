package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;
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
public class ProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProyectoView.class);
    private InputText txtIdNorma_Norma;
    private InputText txtIdProyecto;
    private InputText txtNombre;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProyectoDTO> data;
    private ProyectoDTO selectedProyecto;
    private Proyecto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProyectoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedProyecto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedProyecto = null;

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

        if (txtIdProyecto != null) {
            txtIdProyecto.setValue(null);
            txtIdProyecto.setDisabled(false);
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
            Integer idProyecto = FacesUtils.checkInteger(txtIdProyecto);
            entity = (idProyecto != null)
                ? businessDelegatorView.getProyecto(idProyecto) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdNorma_Norma.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdProyecto.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtIdNorma_Norma.setValue(entity.getNorma().getIdNorma());
            txtIdNorma_Norma.setDisabled(false);
            txtIdProyecto.setValue(entity.getIdProyecto());
            txtIdProyecto.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedProyecto = (ProyectoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedProyecto"));
        txtDateIn.setValue(selectedProyecto.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedProyecto.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtNombre.setValue(selectedProyecto.getNombre());
        txtNombre.setDisabled(false);
        txtIdNorma_Norma.setValue(selectedProyecto.getIdNorma_Norma());
        txtIdNorma_Norma.setDisabled(false);
        txtIdProyecto.setValue(selectedProyecto.getIdProyecto());
        txtIdProyecto.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedProyecto == null) && (entity == null)) {
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
            entity = new Proyecto();

            Integer idProyecto = FacesUtils.checkInteger(txtIdProyecto);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdProyecto(idProyecto);
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            businessDelegatorView.saveProyecto(entity);
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
                Integer idProyecto = new Integer(selectedProyecto.getIdProyecto());
                entity = businessDelegatorView.getProyecto(idProyecto);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            businessDelegatorView.updateProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedProyecto = (ProyectoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedProyecto"));

            Integer idProyecto = new Integer(selectedProyecto.getIdProyecto());
            entity = businessDelegatorView.getProyecto(idProyecto);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idProyecto = FacesUtils.checkInteger(txtIdProyecto);
            entity = businessDelegatorView.getProyecto(idProyecto);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteProyecto(entity);
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

    public String action_modifyWitDTO(Date dateIn, Date dateUpdate, String nombre,
        Integer idProyecto, Integer idNorma_Norma) throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setNombre(FacesUtils.checkString(nombre));
            businessDelegatorView.updateProyecto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProyectoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
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

    public InputText getTxtIdProyecto() {
        return txtIdProyecto;
    }

    public void setTxtIdProyecto(InputText txtIdProyecto) {
        this.txtIdProyecto = txtIdProyecto;
    }

    public List<ProyectoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProyecto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProyectoDTO> proyectoDTO) {
        this.data = proyectoDTO;
    }

    public ProyectoDTO getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(ProyectoDTO proyecto) {
        this.selectedProyecto = proyecto;
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
