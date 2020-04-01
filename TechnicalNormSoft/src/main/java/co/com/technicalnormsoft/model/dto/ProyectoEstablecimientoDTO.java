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
public class ProyectoEstablecimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idProyectoEstablecimiento;
    private String nombre;
    private Double score;
    private Integer idEstablecimiento_Establecimiento;
    private Integer idEstadoProyecto_EstadoProyecto;
    private Integer idProyecto_Proyecto;

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

    public Integer getIdProyectoEstablecimiento() {
        return idProyectoEstablecimiento;
    }

    public void setIdProyectoEstablecimiento(Integer idProyectoEstablecimiento) {
        this.idProyectoEstablecimiento = idProyectoEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getIdEstablecimiento_Establecimiento() {
        return idEstablecimiento_Establecimiento;
    }

    public void setIdEstablecimiento_Establecimiento(
        Integer idEstablecimiento_Establecimiento) {
        this.idEstablecimiento_Establecimiento = idEstablecimiento_Establecimiento;
    }

    public Integer getIdEstadoProyecto_EstadoProyecto() {
        return idEstadoProyecto_EstadoProyecto;
    }

    public void setIdEstadoProyecto_EstadoProyecto(
        Integer idEstadoProyecto_EstadoProyecto) {
        this.idEstadoProyecto_EstadoProyecto = idEstadoProyecto_EstadoProyecto;
    }

    public Integer getIdProyecto_Proyecto() {
        return idProyecto_Proyecto;
    }

    public void setIdProyecto_Proyecto(Integer idProyecto_Proyecto) {
        this.idProyecto_Proyecto = idProyecto_Proyecto;
    }
}
