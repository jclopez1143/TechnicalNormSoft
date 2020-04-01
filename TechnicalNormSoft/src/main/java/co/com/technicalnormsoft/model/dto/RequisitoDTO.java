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
public class RequisitoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RequisitoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Integer idRequisito;
    private String numeral;
    private Integer idCategoriaRequisito_CategoriaRequisito;
    private Integer idNorma_Norma;

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

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public Integer getIdCategoriaRequisito_CategoriaRequisito() {
        return idCategoriaRequisito_CategoriaRequisito;
    }

    public void setIdCategoriaRequisito_CategoriaRequisito(
        Integer idCategoriaRequisito_CategoriaRequisito) {
        this.idCategoriaRequisito_CategoriaRequisito = idCategoriaRequisito_CategoriaRequisito;
    }

    public Integer getIdNorma_Norma() {
        return idNorma_Norma;
    }

    public void setIdNorma_Norma(Integer idNorma_Norma) {
        this.idNorma_Norma = idNorma_Norma;
    }
}
