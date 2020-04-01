package co.com.technicalnormsoft.presentation.backingBeans;

import co.com.technicalnormsoft.exceptions.*;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;
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
public class TipoServicioNormaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoServicioNormaView.class);
    private InputText txtIdNorma_Norma;
    private InputText txtIdTipoServicio_TipoServicio;
    private InputText txtIdTipoServicioNorma;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoServicioNormaDTO> data;
    private TipoServicioNormaDTO selectedTipoServicioNorma;
    private TipoServicioNorma entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipoServicioNormaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoServicioNorma = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoServicioNorma = null;

        if (txtIdNorma_Norma != null) {
            txtIdNorma_Norma.setValue(null);
            txtIdNorma_Norma.setDisabled(true);
        }

        if (txtIdTipoServicio_TipoServicio != null) {
            txtIdTipoServicio_TipoServicio.setValue(null);
            txtIdTipoServicio_TipoServicio.setDisabled(true);
        }

        if (txtIdTipoServicioNorma != null) {
            txtIdTipoServicioNorma.setValue(null);
            txtIdTipoServicioNorma.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer idTipoServicioNorma = FacesUtils.checkInteger(txtIdTipoServicioNorma);
            entity = (idTipoServicioNorma != null)
                ? businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdNorma_Norma.setDisabled(false);
            txtIdTipoServicio_TipoServicio.setDisabled(false);
            txtIdTipoServicioNorma.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIdNorma_Norma.setValue(entity.getNorma().getIdNorma());
            txtIdNorma_Norma.setDisabled(false);
            txtIdTipoServicio_TipoServicio.setValue(entity.getTipoServicio()
                                                          .getIdTipoServicio());
            txtIdTipoServicio_TipoServicio.setDisabled(false);
            txtIdTipoServicioNorma.setValue(entity.getIdTipoServicioNorma());
            txtIdTipoServicioNorma.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoServicioNorma = (TipoServicioNormaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedTipoServicioNorma"));
        txtIdNorma_Norma.setValue(selectedTipoServicioNorma.getIdNorma_Norma());
        txtIdNorma_Norma.setDisabled(false);
        txtIdTipoServicio_TipoServicio.setValue(selectedTipoServicioNorma.getIdTipoServicio_TipoServicio());
        txtIdTipoServicio_TipoServicio.setDisabled(false);
        txtIdTipoServicioNorma.setValue(selectedTipoServicioNorma.getIdTipoServicioNorma());
        txtIdTipoServicioNorma.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoServicioNorma == null) && (entity == null)) {
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
            entity = new TipoServicioNorma();

            Integer idTipoServicioNorma = FacesUtils.checkInteger(txtIdTipoServicioNorma);

            entity.setIdTipoServicioNorma(idTipoServicioNorma);
            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            entity.setTipoServicio((FacesUtils.checkInteger(
                    txtIdTipoServicio_TipoServicio) != null)
                ? businessDelegatorView.getTipoServicio(FacesUtils.checkInteger(
                        txtIdTipoServicio_TipoServicio)) : null);
            businessDelegatorView.saveTipoServicioNorma(entity);
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
                Integer idTipoServicioNorma = new Integer(selectedTipoServicioNorma.getIdTipoServicioNorma());
                entity = businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma);
            }

            entity.setNorma((FacesUtils.checkInteger(txtIdNorma_Norma) != null)
                ? businessDelegatorView.getNorma(FacesUtils.checkInteger(
                        txtIdNorma_Norma)) : null);
            entity.setTipoServicio((FacesUtils.checkInteger(
                    txtIdTipoServicio_TipoServicio) != null)
                ? businessDelegatorView.getTipoServicio(FacesUtils.checkInteger(
                        txtIdTipoServicio_TipoServicio)) : null);
            businessDelegatorView.updateTipoServicioNorma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoServicioNorma = (TipoServicioNormaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedTipoServicioNorma"));

            Integer idTipoServicioNorma = new Integer(selectedTipoServicioNorma.getIdTipoServicioNorma());
            entity = businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idTipoServicioNorma = FacesUtils.checkInteger(txtIdTipoServicioNorma);
            entity = businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoServicioNorma(entity);
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

    public String action_modifyWitDTO(Integer idTipoServicioNorma,
        Integer idNorma_Norma, Integer idTipoServicio_TipoServicio)
        throws Exception {
        try {
            businessDelegatorView.updateTipoServicioNorma(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoServicioNormaView").requestRender();
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

    public InputText getTxtIdTipoServicio_TipoServicio() {
        return txtIdTipoServicio_TipoServicio;
    }

    public void setTxtIdTipoServicio_TipoServicio(
        InputText txtIdTipoServicio_TipoServicio) {
        this.txtIdTipoServicio_TipoServicio = txtIdTipoServicio_TipoServicio;
    }

    public InputText getTxtIdTipoServicioNorma() {
        return txtIdTipoServicioNorma;
    }

    public void setTxtIdTipoServicioNorma(InputText txtIdTipoServicioNorma) {
        this.txtIdTipoServicioNorma = txtIdTipoServicioNorma;
    }

    public List<TipoServicioNormaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoServicioNorma();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoServicioNormaDTO> tipoServicioNormaDTO) {
        this.data = tipoServicioNormaDTO;
    }

    public TipoServicioNormaDTO getSelectedTipoServicioNorma() {
        return selectedTipoServicioNorma;
    }

    public void setSelectedTipoServicioNorma(
        TipoServicioNormaDTO tipoServicioNorma) {
        this.selectedTipoServicioNorma = tipoServicioNorma;
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
