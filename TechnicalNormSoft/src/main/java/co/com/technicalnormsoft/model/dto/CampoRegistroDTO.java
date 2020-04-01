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
public class CampoRegistroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CampoRegistroDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idCampoRegistro;
    private String magnitud;
    private String nombre;
    private Integer prioridad;
    private String tipo;
    private Integer idDatoObjetivo_DatoObjetivo;

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

    public Integer getIdCampoRegistro() {
        return idCampoRegistro;
    }

    public void setIdCampoRegistro(Integer idCampoRegistro) {
        this.idCampoRegistro = idCampoRegistro;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdDatoObjetivo_DatoObjetivo() {
        return idDatoObjetivo_DatoObjetivo;
    }

    public void setIdDatoObjetivo_DatoObjetivo(
        Integer idDatoObjetivo_DatoObjetivo) {
        this.idDatoObjetivo_DatoObjetivo = idDatoObjetivo_DatoObjetivo;
    }
}
