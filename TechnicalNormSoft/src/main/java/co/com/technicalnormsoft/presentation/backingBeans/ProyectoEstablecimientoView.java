package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
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
public class ProyectoEstablecimientoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoView.class);
    private InputText txtNombre;
    private InputText txtScore;
    private InputText txtIdEstablecimiento_Establecimiento;
    private InputText txtIdEstadoProyecto_EstadoProyecto;
    private InputText txtIdProyecto_Proyecto;
    private InputText txtIdProyectoEstablecimiento;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProyectoEstablecimientoDTO> data;
    private ProyectoEstablecimientoDTO selectedProyectoEstablecimiento;
    private ProyectoEstablecimiento entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProyectoEstablecimientoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedProyectoEstablecimiento = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedProyectoEstablecimiento = null;

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtScore != null) {
            txtScore.setValue(null);
            txtScore.setDisabled(true);
        }

        if (txtIdEstablecimiento_Establecimiento != null) {
            txtIdEstablecimiento_Establecimiento.setValue(null);
            txtIdEstablecimiento_Establecimiento.setDisabled(true);
        }

        if (txtIdEstadoProyecto_EstadoProyecto != null) {
            txtIdEstadoProyecto_EstadoProyecto.setValue(null);
            txtIdEstadoProyecto_EstadoProyecto.setDisabled(true);
        }

        if (txtIdProyecto_Proyecto != null) {
            txtIdProyecto_Proyecto.setValue(null);
            txtIdProyecto_Proyecto.setDisabled(true);
        }

        if (txtDateIn != null) {
            txtDateIn.setValue(null);
            txtDateIn.setDisabled(true);
        }

        if (txtDateUpdate != null) {
            txtDateUpdate.setValue(null);
            txtDateUpdate.setDisabled(true);
        }

        if (txtIdProyectoEstablecimiento != null) {
            txtIdProyectoEstablecimiento.setValue(null);
            txtIdProyectoEstablecimiento.setDisabled(false);
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
            Integer idProyectoEstablecimiento = FacesUtils.checkInteger(txtIdProyectoEstablecimiento);
            entity = (idProyectoEstablecimiento != null)
                ? businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombre.setDisabled(false);
            txtScore.setDisabled(false);
            txtIdEstablecimiento_Establecimiento.setDisabled(false);
            txtIdEstadoProyecto_EstadoProyecto.setDisabled(false);
            txtIdProyecto_Proyecto.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdProyectoEstablecimiento.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtScore.setValue(entity.getScore());
            txtScore.setDisabled(false);
            txtIdEstablecimiento_Establecimiento.setValue(entity.getEstablecimiento()
                                                                .getIdEstablecimiento());
            txtIdEstablecimiento_Establecimiento.setDisabled(false);
            txtIdEstadoProyecto_EstadoProyecto.setValue(entity.getEstadoProyecto()
                                                              .getIdEstadoProyecto());
            txtIdEstadoProyecto_EstadoProyecto.setDisabled(false);
            txtIdProyecto_Proyecto.setValue(entity.getProyecto().getIdProyecto());
            txtIdProyecto_Proyecto.setDisabled(false);
            txtIdProyectoEstablecimiento.setValue(entity.getIdProyectoEstablecimiento());
            txtIdProyectoEstablecimiento.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedProyectoEstablecimiento"));
        txtDateIn.setValue(selectedProyectoEstablecimiento.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedProyectoEstablecimiento.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtNombre.setValue(selectedProyectoEstablecimiento.getNombre());
        txtNombre.setDisabled(false);
        txtScore.setValue(selectedProyectoEstablecimiento.getScore());
        txtScore.setDisabled(false);
        txtIdEstablecimiento_Establecimiento.setValue(selectedProyectoEstablecimiento.getIdEstablecimiento_Establecimiento());
        txtIdEstablecimiento_Establecimiento.setDisabled(false);
        txtIdEstadoProyecto_EstadoProyecto.setValue(selectedProyectoEstablecimiento.getIdEstadoProyecto_EstadoProyecto());
        txtIdEstadoProyecto_EstadoProyecto.setDisabled(false);
        txtIdProyecto_Proyecto.setValue(selectedProyectoEstablecimiento.getIdProyecto_Proyecto());
        txtIdProyecto_Proyecto.setDisabled(false);
        txtIdProyectoEstablecimiento.setValue(selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
        txtIdProyectoEstablecimiento.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedProyectoEstablecimiento == null) && (entity == null)) {
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
            entity = new ProyectoEstablecimiento();

            Integer idProyectoEstablecimiento = FacesUtils.checkInteger(txtIdProyectoEstablecimiento);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setIdProyectoEstablecimiento(idProyectoEstablecimiento);
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setScore(FacesUtils.checkDouble(txtScore));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtIdEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtIdEstablecimiento_Establecimiento)) : null);
            entity.setEstadoProyecto((FacesUtils.checkInteger(
                    txtIdEstadoProyecto_EstadoProyecto) != null)
                ? businessDelegatorView.getEstadoProyecto(
                    FacesUtils.checkInteger(txtIdEstadoProyecto_EstadoProyecto))
                : null);
            entity.setProyecto((FacesUtils.checkInteger(txtIdProyecto_Proyecto) != null)
                ? businessDelegatorView.getProyecto(FacesUtils.checkInteger(
                        txtIdProyecto_Proyecto)) : null);
            businessDelegatorView.saveProyectoEstablecimiento(entity);
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
                Integer idProyectoEstablecimiento = new Integer(selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
                entity = businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setScore(FacesUtils.checkDouble(txtScore));
            entity.setEstablecimiento((FacesUtils.checkInteger(
                    txtIdEstablecimiento_Establecimiento) != null)
                ? businessDelegatorView.getEstablecimiento(
                    FacesUtils.checkInteger(
                        txtIdEstablecimiento_Establecimiento)) : null);
            entity.setEstadoProyecto((FacesUtils.checkInteger(
                    txtIdEstadoProyecto_EstadoProyecto) != null)
                ? businessDelegatorView.getEstadoProyecto(
                    FacesUtils.checkInteger(txtIdEstadoProyecto_EstadoProyecto))
                : null);
            entity.setProyecto((FacesUtils.checkInteger(txtIdProyecto_Proyecto) != null)
                ? businessDelegatorView.getProyecto(FacesUtils.checkInteger(
                        txtIdProyecto_Proyecto)) : null);
            businessDelegatorView.updateProyectoEstablecimiento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedProyectoEstablecimiento = (ProyectoEstablecimientoDTO) (evt.getComponent()
                                                                               .getAttributes()
                                                                               .get("selectedProyectoEstablecimiento"));

            Integer idProyectoEstablecimiento = new Integer(selectedProyectoEstablecimiento.getIdProyectoEstablecimiento());
            entity = businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idProyectoEstablecimiento = FacesUtils.checkInteger(txtIdProyectoEstablecimiento);
            entity = businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteProyectoEstablecimiento(entity);
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
        Integer idProyectoEstablecimiento, String nombre, Double score,
        Integer idEstablecimiento_Establecimiento,
        Integer idEstadoProyecto_EstadoProyecto, Integer idProyecto_Proyecto)
        throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setScore(FacesUtils.checkDouble(score));
            businessDelegatorView.updateProyectoEstablecimiento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProyectoEstablecimientoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtScore() {
        return txtScore;
    }

    public void setTxtScore(InputText txtScore) {
        this.txtScore = txtScore;
    }

    public InputText getTxtIdEstablecimiento_Establecimiento() {
        return txtIdEstablecimiento_Establecimiento;
    }

    public void setTxtIdEstablecimiento_Establecimiento(
        InputText txtIdEstablecimiento_Establecimiento) {
        this.txtIdEstablecimiento_Establecimiento = txtIdEstablecimiento_Establecimiento;
    }

    public InputText getTxtIdEstadoProyecto_EstadoProyecto() {
        return txtIdEstadoProyecto_EstadoProyecto;
    }

    public void setTxtIdEstadoProyecto_EstadoProyecto(
        InputText txtIdEstadoProyecto_EstadoProyecto) {
        this.txtIdEstadoProyecto_EstadoProyecto = txtIdEstadoProyecto_EstadoProyecto;
    }

    public InputText getTxtIdProyecto_Proyecto() {
        return txtIdProyecto_Proyecto;
    }

    public void setTxtIdProyecto_Proyecto(InputText txtIdProyecto_Proyecto) {
        this.txtIdProyecto_Proyecto = txtIdProyecto_Proyecto;
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

    public InputText getTxtIdProyectoEstablecimiento() {
        return txtIdProyectoEstablecimiento;
    }

    public void setTxtIdProyectoEstablecimiento(
        InputText txtIdProyectoEstablecimiento) {
        this.txtIdProyectoEstablecimiento = txtIdProyectoEstablecimiento;
    }

    public List<ProyectoEstablecimientoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProyectoEstablecimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(
        List<ProyectoEstablecimientoDTO> proyectoEstablecimientoDTO) {
        this.data = proyectoEstablecimientoDTO;
    }

    public ProyectoEstablecimientoDTO getSelectedProyectoEstablecimiento() {
        return selectedProyectoEstablecimiento;
    }

    public void setSelectedProyectoEstablecimiento(
        ProyectoEstablecimientoDTO proyectoEstablecimiento) {
        this.selectedProyectoEstablecimiento = proyectoEstablecimiento;
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
