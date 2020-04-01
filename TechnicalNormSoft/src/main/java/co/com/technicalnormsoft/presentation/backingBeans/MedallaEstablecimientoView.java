package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;
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
public class MedallaEstablecimientoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MedallaEstablecimientoView.class);
    private InputText txtIdEstablecimiento_Establecimiento;
    private InputText txtIdMedalla_Medalla;
    private InputText txtIdMedallaEstablecimiento;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MedallaEstablecimientoDTO> data;
    private MedallaEstablecimientoDTO selectedMedallaEstablecimiento;
    private MedallaEstablecimiento entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public MedallaEstablecimientoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedMedallaEstablecimiento = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMedallaEstablecimiento = null;

        if (txtIdEstablecimiento_Establecimiento != null) {
            txtIdEstablecimiento_Establecimiento.setValue(null);
            txtIdEstablecimiento_Establecimiento.setDisabled(true);
        }

        if (txtIdMedalla_Medalla != null) {
            txtIdMedalla_Medalla.setValue(null);
            txtIdMedalla_Medalla.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdMedallaEstablecimiento != null) {
            txtIdMedallaEstablecimiento.setValue(null);
            txtIdMedallaEstablecimiento.setDisabled(false);
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
            Integer idMedallaEstablecimiento = FacesUtils.checkInteger(txtIdMedallaEstablecimiento);
            entity = (idMedallaEstablecimiento != null)
                ? businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdEstablecimiento_Establecimiento.setDisabled(false);
            txtIdMedalla_Medalla.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdMedallaEstablecimiento.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtIdEstablecimiento_Establecimiento.setValue(entity.getEstablecimiento()
                                                                .getIdEstablecimiento());
            txtIdEstablecimiento_Establecimiento.setDisabled(false);
            txtIdMedalla_Medalla.setValue(entity.getMedalla().getIdMedalla());
            txtIdMedalla_Medalla.setDisabled(false);
            txtIdMedallaEstablecimiento.setValue(entity.getIdMedallaEstablecimiento());
            txtIdMedallaEstablecimiento.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMedallaEstablecimiento = (MedallaEstablecimientoDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedMedallaEstablecimiento"));
        txtDateIn.setValue(selectedMedallaEstablecimiento.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedMedallaEstablecimiento.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtIdEstablecimiento_Establecimiento.setValue(selectedMedallaEstablecimiento.getIdEstablecimiento_Establecimiento());
        txtIdEstablecimiento_Establecimiento.setDisabled(false);
        txtIdMedalla_Medalla.setValue(selectedMedallaEstablecimiento.getIdMedalla_Medalla());
        txtIdMedalla_Medalla.setDisabled(false);
        txtIdMedallaEstablecimiento.setValue(selectedMedallaEstablecimiento.getIdMedallaEstablecimiento());
        txtIdMedallaEstablecimiento.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMedallaEstablecimiento == null) && (entity == null)) {
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
            entity = new MedallaEstablecimiento();

            Integer idMedallaEstablecimiento = FacesUtils.checkInteger(txtIdMedallaEstablecimiento);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdMedallaEstablecimiento(idMedallaEstablecimiento);
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtIdEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtIdEstablecimiento_Establecimiento)) : null);
            entity.setMedalla((FacesUtils.checkInteger(txtIdMedalla_Medalla) != null)
                ? businessDelegatorView.getMedalla(FacesUtils.checkInteger(
                        txtIdMedalla_Medalla)) : null);
            businessDelegatorView.saveMedallaEstablecimiento(entity);
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
                Integer idMedallaEstablecimiento = new Integer(selectedMedallaEstablecimiento.getIdMedallaEstablecimiento());
                entity = businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtIdEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtIdEstablecimiento_Establecimiento)) : null);
            entity.setMedalla((FacesUtils.checkInteger(txtIdMedalla_Medalla) != null)
                ? businessDelegatorView.getMedalla(FacesUtils.checkInteger(
                        txtIdMedalla_Medalla)) : null);
            businessDelegatorView.updateMedallaEstablecimiento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMedallaEstablecimiento = (MedallaEstablecimientoDTO) (evt.getComponent()
                                                                             .getAttributes()
                                                                             .get("selectedMedallaEstablecimiento"));

            Integer idMedallaEstablecimiento = new Integer(selectedMedallaEstablecimiento.getIdMedallaEstablecimiento());
            entity = businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idMedallaEstablecimiento = FacesUtils.checkInteger(txtIdMedallaEstablecimiento);
            entity = businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMedallaEstablecimiento(entity);
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
        Integer idMedallaEstablecimiento,
        Integer idEstablecimiento_Establecimiento, Integer idMedalla_Medalla)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            businessDelegatorView.updateMedallaEstablecimiento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MedallaEstablecimientoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdEstablecimiento_Establecimiento() {
        return txtIdEstablecimiento_Establecimiento;
    }

    public void setTxtIdEstablecimiento_Establecimiento(
        InputText txtIdEstablecimiento_Establecimiento) {
        this.txtIdEstablecimiento_Establecimiento = txtIdEstablecimiento_Establecimiento;
    }

    public InputText getTxtIdMedalla_Medalla() {
        return txtIdMedalla_Medalla;
    }

    public void setTxtIdMedalla_Medalla(InputText txtIdMedalla_Medalla) {
        this.txtIdMedalla_Medalla = txtIdMedalla_Medalla;
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

    public InputText getTxtIdMedallaEstablecimiento() {
        return txtIdMedallaEstablecimiento;
    }

    public void setTxtIdMedallaEstablecimiento(
        InputText txtIdMedallaEstablecimiento) {
        this.txtIdMedallaEstablecimiento = txtIdMedallaEstablecimiento;
    }

    public List<MedallaEstablecimientoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMedallaEstablecimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<MedallaEstablecimientoDTO> medallaEstablecimientoDTO) {
        this.data = medallaEstablecimientoDTO;
    }

    public MedallaEstablecimientoDTO getSelectedMedallaEstablecimiento() {
        return selectedMedallaEstablecimiento;
    }

    public void setSelectedMedallaEstablecimiento(
        MedallaEstablecimientoDTO medallaEstablecimiento) {
        this.selectedMedallaEstablecimiento = medallaEstablecimiento;
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
