package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;
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
public class ProgramaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProgramaView.class);
    private InputText txtDescripcion;
    private InputText txtIdCategoriaPrograma_CategoriaPrograma;
    private InputText txtIdProyecto_Proyecto;
    private InputText txtIdPrograma;
    private Calendar txtDateIn;
    private Calendar txtDateUpdate;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProgramaDTO> data;
    private ProgramaDTO selectedPrograma;
    private Programa entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProgramaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedPrograma = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPrograma = null;

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtIdCategoriaPrograma_CategoriaPrograma != null) {
            txtIdCategoriaPrograma_CategoriaPrograma.setValue(null);
            txtIdCategoriaPrograma_CategoriaPrograma.setDisabled(true);
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

        if (txtIdPrograma != null) {
            txtIdPrograma.setValue(null);
            txtIdPrograma.setDisabled(false);
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
            Integer idPrograma = FacesUtils.checkInteger(txtIdPrograma);
            entity = (idPrograma != null)
                ? businessDelegatorView.getPrograma(idPrograma) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtIdCategoriaPrograma_CategoriaPrograma.setDisabled(false);
            txtIdProyecto_Proyecto.setDisabled(false);
            txtDateIn.setDisabled(false);
            txtDateUpdate.setDisabled(false);
            txtIdPrograma.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDateIn.setValue(entity.getDateIn());
            txtDateIn.setDisabled(false);
            txtDateUpdate.setValue(entity.getDateUpdate());
            txtDateUpdate.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtIdCategoriaPrograma_CategoriaPrograma.setValue(entity.getCategoriaPrograma()
                                                                    .getIdCategoriaPrograma());
            txtIdCategoriaPrograma_CategoriaPrograma.setDisabled(false);
            txtIdProyecto_Proyecto.setValue(entity.getProyecto().getIdProyecto());
            txtIdProyecto_Proyecto.setDisabled(false);
            txtIdPrograma.setValue(entity.getIdPrograma());
            txtIdPrograma.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPrograma = (ProgramaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedPrograma"));
        txtDateIn.setValue(selectedPrograma.getDateIn());
        txtDateIn.setDisabled(false);
        txtDateUpdate.setValue(selectedPrograma.getDateUpdate());
        txtDateUpdate.setDisabled(false);
        txtDescripcion.setValue(selectedPrograma.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtIdCategoriaPrograma_CategoriaPrograma.setValue(selectedPrograma.getIdCategoriaPrograma_CategoriaPrograma());
        txtIdCategoriaPrograma_CategoriaPrograma.setDisabled(false);
        txtIdProyecto_Proyecto.setValue(selectedPrograma.getIdProyecto_Proyecto());
        txtIdProyecto_Proyecto.setDisabled(false);
        txtIdPrograma.setValue(selectedPrograma.getIdPrograma());
        txtIdPrograma.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPrograma == null) && (entity == null)) {
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
            entity = new Programa();

            Integer idPrograma = FacesUtils.checkInteger(txtIdPrograma);

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setIdPrograma(idPrograma);
            entity.setCategoriaPrograma((FacesUtils.checkInteger(
                    txtIdCategoriaPrograma_CategoriaPrograma) != null)
                ? businessDelegatorView.getCategoriaPrograma(
                    FacesUtils.checkInteger(
                        txtIdCategoriaPrograma_CategoriaPrograma)) : null);
            entity.setProyecto((FacesUtils.checkInteger(txtIdProyecto_Proyecto) != null)
                ? businessDelegatorView.getProyecto(FacesUtils.checkInteger(
                        txtIdProyecto_Proyecto)) : null);
            businessDelegatorView.savePrograma(entity);
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
                Integer idPrograma = new Integer(selectedPrograma.getIdPrograma());
                entity = businessDelegatorView.getPrograma(idPrograma);
            }

            entity.setDateIn(FacesUtils.checkDate(txtDateIn));
            entity.setDateUpdate(FacesUtils.checkDate(txtDateUpdate));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setCategoriaPrograma((FacesUtils.checkInteger(
                    txtIdCategoriaPrograma_CategoriaPrograma) != null)
                ? businessDelegatorView.getCategoriaPrograma(
                    FacesUtils.checkInteger(
                        txtIdCategoriaPrograma_CategoriaPrograma)) : null);
            entity.setProyecto((FacesUtils.checkInteger(txtIdProyecto_Proyecto) != null)
                ? businessDelegatorView.getProyecto(FacesUtils.checkInteger(
                        txtIdProyecto_Proyecto)) : null);
            businessDelegatorView.updatePrograma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPrograma = (ProgramaDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedPrograma"));

            Integer idPrograma = new Integer(selectedPrograma.getIdPrograma());
            entity = businessDelegatorView.getPrograma(idPrograma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idPrograma = FacesUtils.checkInteger(txtIdPrograma);
            entity = businessDelegatorView.getPrograma(idPrograma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePrograma(entity);
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
        String descripcion, Integer idPrograma,
        Integer idCategoriaPrograma_CategoriaPrograma,
        Integer idProyecto_Proyecto) throws Exception {
        try {
            entity.setDateIn(FacesUtils.checkDate(dateIn));
            entity.setDateUpdate(FacesUtils.checkDate(dateUpdate));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            businessDelegatorView.updatePrograma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProgramaView").requestRender();
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

    public InputText getTxtIdCategoriaPrograma_CategoriaPrograma() {
        return txtIdCategoriaPrograma_CategoriaPrograma;
    }

    public void setTxtIdCategoriaPrograma_CategoriaPrograma(
        InputText txtIdCategoriaPrograma_CategoriaPrograma) {
        this.txtIdCategoriaPrograma_CategoriaPrograma = txtIdCategoriaPrograma_CategoriaPrograma;
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

    public InputText getTxtIdPrograma() {
        return txtIdPrograma;
    }

    public void setTxtIdPrograma(InputText txtIdPrograma) {
        this.txtIdPrograma = txtIdPrograma;
    }

    public List<ProgramaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPrograma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProgramaDTO> programaDTO) {
        this.data = programaDTO;
    }

    public ProgramaDTO getSelectedPrograma() {
        return selectedPrograma;
    }

    public void setSelectedPrograma(ProgramaDTO programa) {
        this.selectedPrograma = programa;
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
