package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EstablecimientoObjetivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoObjetivoDTO.class);
    private Date dateFin;
    private Date dateIn;
    private Date dateUpdate;
    private Integer establecimientoObjetivoId;
    private Integer idEstadoObjetivo_EstadoObjetivo;
    private Integer idProyectoEstablecimiento_ProyectoEstablecimiento;
    private String resolucion;
    private Integer idObjetivo_Objetivo;

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

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

    public Integer getEstablecimientoObjetivoId() {
        return establecimientoObjetivoId;
    }

    public void setEstablecimientoObjetivoId(Integer establecimientoObjetivoId) {
        this.establecimientoObjetivoId = establecimientoObjetivoId;
    }

    public Integer getIdEstadoObjetivo_EstadoObjetivo() {
        return idEstadoObjetivo_EstadoObjetivo;
    }

    public void setIdEstadoObjetivo_EstadoObjetivo(Integer idEstadoObjetivo_EstadoObjetivo) {
        this.idEstadoObjetivo_EstadoObjetivo = idEstadoObjetivo_EstadoObjetivo;
    }

    public Integer getIdProyectoEstablecimiento_ProyectoEstablecimiento() {
        return idProyectoEstablecimiento_ProyectoEstablecimiento;
    }

    public void setIdProyectoEstablecimiento_ProyectoEstablecimiento(
    		Integer idProyectoEstablecimiento_ProyectoEstablecimiento) {
        this.idProyectoEstablecimiento_ProyectoEstablecimiento = 
        		idProyectoEstablecimiento_ProyectoEstablecimiento;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Integer getIdObjetivo_Objetivo() {
        return idObjetivo_Objetivo;
    }

    public void setIdObjetivo_Objetivo(Integer idObjetivo_Objetivo) {
        this.idObjetivo_Objetivo = idObjetivo_Objetivo;
    }
}
