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
* @author Silicon Cali
* 
*
*/
@Entity
@Table(name = "medalla", schema = "public")
public class Medalla implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idMedalla;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Integer score;
    private Set<MedallaEstablecimiento> medallaEstablecimientos = new HashSet<MedallaEstablecimiento>(0);

    public Medalla() {
    }

    public Medalla(Integer idMedalla, Date dateIn, Date dateUpdate,
        String descripcion,
        Set<MedallaEstablecimiento> medallaEstablecimientos, Integer score) {
        this.idMedalla = idMedalla;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.score = score;
        this.medallaEstablecimientos = medallaEstablecimientos;
    }

    public Integer getIdMedalla() {
        return this.idMedalla;
    }

    public void setIdMedalla(Integer idMedalla) {
        this.idMedalla = idMedalla;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Set<MedallaEstablecimiento> getMedallaEstablecimientos() {
        return this.medallaEstablecimientos;
    }

    public void setMedallaEstablecimientos(
        Set<MedallaEstablecimiento> medallaEstablecimientos) {
        this.medallaEstablecimientos = medallaEstablecimientos;
    }
}
