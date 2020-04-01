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
@Table(name = "valorDato", schema = "public")
public class ValorDato implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idValorDato;
    @NotNull
    private DatoObjetivo datoObjetivo;
    @NotNull
    private EstablecimientoObjetivo establecimientoObjetivo;
    private Date dateIn;
    private Date dateUpdate;
    private String valor;

    public ValorDato() {
    }

    public ValorDato(Integer idValorDato, Date dateIn, Date dateUpdate,
        DatoObjetivo datoObjetivo,
        EstablecimientoObjetivo establecimientoObjetivo, String valor) {
        this.idValorDato = idValorDato;
        this.datoObjetivo = datoObjetivo;
        this.establecimientoObjetivo = establecimientoObjetivo;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.valor = valor;
    }

    public Integer getIdValorDato() {
        return this.idValorDato;
    }

    public void setIdValorDato(Integer idValorDato) {
        this.idValorDato = idValorDato;
    }

    public DatoObjetivo getDatoObjetivo() {
        return this.datoObjetivo;
    }

    public void setDatoObjetivo(DatoObjetivo datoObjetivo) {
        this.datoObjetivo = datoObjetivo;
    }

    public EstablecimientoObjetivo getEstablecimientoObjetivo() {
        return this.establecimientoObjetivo;
    }

    public void setEstablecimientoObjetivo(
        EstablecimientoObjetivo establecimientoObjetivo) {
        this.establecimientoObjetivo = establecimientoObjetivo;
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
