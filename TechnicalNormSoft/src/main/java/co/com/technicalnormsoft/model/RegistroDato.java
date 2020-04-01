package co.com.technicalnormsoft.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "registroDato", schema = "public")
public class RegistroDato implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idRegistroDato;
    @NotNull
    private EstablecimientoObjetivo establecimientoObjetivo;
    @NotNull
    private DatoObjetivo datoObjetivo;
    private Date dateIn;
    private Date dateUpdate;
    private Set<ValorCampo> valorCampos = new HashSet<ValorCampo>(0);

    public RegistroDato() {
    }

    public RegistroDato(Integer idRegistroDato, Date dateIn, Date dateUpdate,
        EstablecimientoObjetivo establecimientoObjetivo, DatoObjetivo datoObjetivo,
        Set<ValorCampo> valorCampos) {
        this.idRegistroDato = idRegistroDato;
        this.establecimientoObjetivo = establecimientoObjetivo;
        this.datoObjetivo = datoObjetivo;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.valorCampos = valorCampos;
    }

    public Integer getIdRegistroDato() {
        return this.idRegistroDato;
    }

    public void setIdRegistroDato(Integer idRegistroDato) {
        this.idRegistroDato = idRegistroDato;
    }

    public EstablecimientoObjetivo getEstablecimientoObjetivo() {
        return this.establecimientoObjetivo;
    }

    public void setEstablecimientoObjetivo(
        EstablecimientoObjetivo establecimientoObjetivo) {
        this.establecimientoObjetivo = establecimientoObjetivo;
    }

    public DatoObjetivo getDatoObjetivo() {
		return datoObjetivo;
	}

	public void setDatoObjetivo(DatoObjetivo datoObjetivo) {
		this.datoObjetivo = datoObjetivo;
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

    public Set<ValorCampo> getValorCampos() {
        return this.valorCampos;
    }

    public void setValorCampos(Set<ValorCampo> valorCampos) {
        this.valorCampos = valorCampos;
    }
}
