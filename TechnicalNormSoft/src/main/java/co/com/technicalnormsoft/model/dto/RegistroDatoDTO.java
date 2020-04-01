package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
*
* @author Silicon Cali
*
*/
public class RegistroDatoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RegistroDatoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idRegistroDato;
    private Integer establecimientoObjetivoId_EstablecimientoObjetivo;
    private Integer idDatoObjetivo_DatoObjetivo;
    private HashMap<String, ValorCampoDTO> valorCampos;

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

    public Integer getIdRegistroDato() {
        return idRegistroDato;
    }

    public void setIdRegistroDato(Integer idRegistroDato) {
        this.idRegistroDato = idRegistroDato;
    }

    public Integer getEstablecimientoObjetivoId_EstablecimientoObjetivo() {
        return establecimientoObjetivoId_EstablecimientoObjetivo;
    }

    public void setEstablecimientoObjetivoId_EstablecimientoObjetivo(
        Integer establecimientoObjetivoId_EstablecimientoObjetivo) {
        this.establecimientoObjetivoId_EstablecimientoObjetivo = establecimientoObjetivoId_EstablecimientoObjetivo;
    }

	public Integer getIdDatoObjetivo_DatoObjetivo() {
		return idDatoObjetivo_DatoObjetivo;
	}

	public void setIdDatoObjetivo_DatoObjetivo(Integer idDatoObjetivo_DatoObjetivo) {
		this.idDatoObjetivo_DatoObjetivo = idDatoObjetivo_DatoObjetivo;
	}

	public HashMap<String, ValorCampoDTO> getValorCampos() {
		return valorCampos;
	}

	public void setValorCampos(HashMap<String, ValorCampoDTO> valorCampos) {
		this.valorCampos = valorCampos;
	}
}
