package co.com.technicalnormsoft.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Silicon Cali
* 
*
*/
@Entity
@Table(name = "medallaEstablecimiento", schema = "public")
public class MedallaEstablecimiento implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idMedallaEstablecimiento;
    @NotNull
    private Establecimiento establecimiento;
    @NotNull
    private Medalla medalla;
    private Date dateIn;
    private Date dateUpdate;

    public MedallaEstablecimiento() {
    }

    public MedallaEstablecimiento(Integer idMedallaEstablecimiento,
        Date dateIn, Date dateUpdate, Establecimiento establecimiento,
        Medalla medalla) {
        this.idMedallaEstablecimiento = idMedallaEstablecimiento;
        this.establecimiento = establecimiento;
        this.medalla = medalla;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
    }

    public Integer getIdMedallaEstablecimiento() {
        return this.idMedallaEstablecimiento;
    }

    public void setIdMedallaEstablecimiento(Integer idMedallaEstablecimiento) {
        this.idMedallaEstablecimiento = idMedallaEstablecimiento;
    }

    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Medalla getMedalla() {
        return this.medalla;
    }

    public void setMedalla(Medalla medalla) {
        this.medalla = medalla;
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
}
