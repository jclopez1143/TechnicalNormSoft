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
public class ValorDatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ValorDatoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idValorDato;
    private String valor;
    private Integer idDatoObjetivo_DatoObjetivo;
    private String nombreDatoObjetivo;
    private Integer establecimientoObjetivoId_EstablecimientoObjetivo;

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

    public Integer getIdValorDato() {
        return idValorDato;
    }

    public void setIdValorDato(Integer idValorDato) {
        this.idValorDato = idValorDato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdDatoObjetivo_DatoObjetivo() {
        return idDatoObjetivo_DatoObjetivo;
    }

    public void setIdDatoObjetivo_DatoObjetivo(
        Integer idDatoObjetivo_DatoObjetivo) {
        this.idDatoObjetivo_DatoObjetivo = idDatoObjetivo_DatoObjetivo;
    }

    public String getNombreDatoObjetivo() {
		return nombreDatoObjetivo;
	}

	public void setNombreDatoObjetivo(String nombreDatoObjetivo) {
		this.nombreDatoObjetivo = nombreDatoObjetivo;
	}

	public Integer getEstablecimientoObjetivoId_EstablecimientoObjetivo() {
        return establecimientoObjetivoId_EstablecimientoObjetivo;
    }

    public void setEstablecimientoObjetivoId_EstablecimientoObjetivo(
        Integer establecimientoObjetivoId_EstablecimientoObjetivo) {
        this.establecimientoObjetivoId_EstablecimientoObjetivo = establecimientoObjetivoId_EstablecimientoObjetivo;
    }
}
