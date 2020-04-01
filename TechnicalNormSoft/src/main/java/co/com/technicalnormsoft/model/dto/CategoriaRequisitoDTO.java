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
public class CategoriaRequisitoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CategoriaRequisitoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Integer idCategoriaRequisito;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCategoriaRequisito() {
        return idCategoriaRequisito;
    }

    public void setIdCategoriaRequisito(Integer idCategoriaRequisito) {
        this.idCategoriaRequisito = idCategoriaRequisito;
    }
}
