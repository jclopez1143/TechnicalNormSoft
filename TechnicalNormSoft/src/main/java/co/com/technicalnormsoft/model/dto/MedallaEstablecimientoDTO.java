package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Silicon Cali
* 
*
*/
public class MedallaEstablecimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MedallaEstablecimientoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idMedallaEstablecimiento;
    private Integer idEstablecimiento_Establecimiento;
    private Integer idMedalla_Medalla;

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Integer getIdMedallaEstablecimiento() {
        return idMedallaEstablecimiento;
    }

    public void setIdMedallaEstablecimiento(Integer idMedallaEstablecimiento) {
        this.idMedallaEstablecimiento = idMedallaEstablecimiento;
    }

    public Integer getIdEstablecimiento_Establecimiento() {
        return idEstablecimiento_Establecimiento;
    }

    public void setIdEstablecimiento_Establecimiento(
        Integer idEstablecimiento_Establecimiento) {
        this.idEstablecimiento_Establecimiento = idEstablecimiento_Establecimiento;
    }

    public Integer getIdMedalla_Medalla() {
        return idMedalla_Medalla;
    }

    public void setIdMedalla_Medalla(Integer idMedalla_Medalla) {
        this.idMedalla_Medalla = idMedalla_Medalla;
    }
}
