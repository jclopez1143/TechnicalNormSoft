package co.com.technicalnormsoft.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "valorCampo", schema = "public")
public class ValorCampo implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idValorCampo;
    @NotNull
    private CampoRegistro campoRegistro;
    @NotNull
    private RegistroDato registroDato;
    private Date dateIn;
    private Date dateUpdate;
    private String valor;

    public ValorCampo() {
    }

    public ValorCampo(Integer idValorCampo, CampoRegistro campoRegistro,
        Date dateIn, Date dateUpdate, RegistroDato registroDato, String valor) {
        this.idValorCampo = idValorCampo;
        this.campoRegistro = campoRegistro;
        this.registroDato = registroDato;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.valor = valor;
    }

    public Integer getIdValorCampo() {
        return this.idValorCampo;
    }

    public void setIdValorCampo(Integer idValorCampo) {
        this.idValorCampo = idValorCampo;
    }

    public CampoRegistro getCampoRegistro() {
        return this.campoRegistro;
    }

    public void setCampoRegistro(CampoRegistro campoRegistro) {
        this.campoRegistro = campoRegistro;
    }

    public RegistroDato getRegistroDato() {
        return this.registroDato;
    }

    public void setRegistroDato(RegistroDato registroDato) {
        this.registroDato = registroDato;
    }

    public Date getDateIn() {
        return this.dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateUpdate() {
        return this.dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
