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
public class ObjetivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ObjetivoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Double score;
    private String numeralRequisito;
    private String estadoDescripcion;
    private Integer idObjetivo;
    private Integer idObjetivo_Objetivo;
    private Integer idPrograma_Programa;
    private Integer idRequisito_Requisito;

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getNumeralRequisito() {
		return numeralRequisito;
	}

	public void setNumeralRequisito(String numeralRequisito) {
		this.numeralRequisito = numeralRequisito;
	}

	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}

	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

	public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Integer getIdObjetivo_Objetivo() {
        return idObjetivo_Objetivo;
    }

    public void setIdObjetivo_Objetivo(Integer idObjetivo_Objetivo) {
        this.idObjetivo_Objetivo = idObjetivo_Objetivo;
    }

    public Integer getIdPrograma_Programa() {
        return idPrograma_Programa;
    }

    public void setIdPrograma_Programa(Integer idPrograma_Programa) {
        this.idPrograma_Programa = idPrograma_Programa;
    }

    public Integer getIdRequisito_Requisito() {
        return idRequisito_Requisito;
    }

    public void setIdRequisito_Requisito(Integer idRequisito_Requisito) {
        this.idRequisito_Requisito = idRequisito_Requisito;
    }
}
