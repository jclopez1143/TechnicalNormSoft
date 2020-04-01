package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.Date;


/**
*
* @author Silicon Cali
*
*/
public class ValorCampoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ValorCampoDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private Integer idValorCampo;
    private String valor;
    private Integer idCampoRegistro_CampoRegistro;
    private String nombreCampoRegistro;
    private Integer idRegistroDato_RegistroDato;

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

    public Integer getIdValorCampo() {
        return idValorCampo;
    }

    public void setIdValorCampo(Integer idValorCampo) {
        this.idValorCampo = idValorCampo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdCampoRegistro_CampoRegistro() {
        return idCampoRegistro_CampoRegistro;
    }

    public void setIdCampoRegistro_CampoRegistro(
        Integer idCampoRegistro_CampoRegistro) {
        this.idCampoRegistro_CampoRegistro = idCampoRegistro_CampoRegistro;
    }

	public String getNombreCampoRegistro() {
		return nombreCampoRegistro;
	}

	public void setNombreCampoRegistro(String nombreCampoRegistro) {
		this.nombreCampoRegistro = nombreCampoRegistro;
	}

	public Integer getIdRegistroDato_RegistroDato() {
        return idRegistroDato_RegistroDato;
    }

    public void setIdRegistroDato_RegistroDato(
        Integer idRegistroDato_RegistroDato) {
        this.idRegistroDato_RegistroDato = idRegistroDato_RegistroDato;
    }
}
