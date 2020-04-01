package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
*
* @author Silicon Cali
*
*/
public class DatoObjetivoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DatoObjetivoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idDatoObjetivo;
    private String magnitud;
    private String nombre;
    private Integer prioridad;
    private String tipo;
    private Integer idObjetivo_Objetivo;
    private List<CampoRegistroDTO> campoRegistros;
    private HashMap<String, ValorDatoDTO> valorDatos;
    private List<RegistroDatoDTO> registroDatos;

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

    public Integer getIdDatoObjetivo() {
        return idDatoObjetivo;
    }

    public void setIdDatoObjetivo(Integer idDatoObjetivo) {
        this.idDatoObjetivo = idDatoObjetivo;
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

    public Integer getIdObjetivo_Objetivo() {
        return idObjetivo_Objetivo;
    }

    public void setIdObjetivo_Objetivo(Integer idObjetivo_Objetivo) {
        this.idObjetivo_Objetivo = idObjetivo_Objetivo;
    }

	public List<CampoRegistroDTO> getCampoRegistros() {
		return campoRegistros;
	}

	public void setCampoRegistros(List<CampoRegistroDTO> campoRegistros) {
		this.campoRegistros = campoRegistros;
	}

	public HashMap<String, ValorDatoDTO> getValorDatos() {
		return valorDatos;
	}

	public void setValorDatos(HashMap<String, ValorDatoDTO> valorDatos) {
		this.valorDatos = valorDatos;
	}

	public List<RegistroDatoDTO> getRegistroDatos() {
		return registroDatos;
	}

	public void setRegistroDatos(List<RegistroDatoDTO> registroDatos) {
		this.registroDatos = registroDatos;
	}
}
