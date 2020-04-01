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
@Table(name = "objetivo", schema = "public")
public class Objetivo implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idObjetivo;
    @NotNull
    private Objetivo parentObjetivo;
    @NotNull
    private Programa programa;
    @NotNull
    private Requisito requisito;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Double score;
    private Set<EstablecimientoObjetivo> establecimientoObjetivos = new HashSet<EstablecimientoObjetivo>(0);
    private Set<Objetivo> objetivos = new HashSet<Objetivo>(0);

    public Objetivo() {
    }

    public Objetivo(Integer idObjetivo, Date dateIn, Date dateUpdate,
        String descripcion, Double score,
        Set<EstablecimientoObjetivo> establecimientoObjetivos,
        Objetivo objetivo, Set<Objetivo> objetivos, Programa programa,
        Requisito requisito) {
        this.idObjetivo = idObjetivo;
        this.parentObjetivo = objetivo;
        this.programa = programa;
        this.requisito = requisito;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.score = score;
        this.establecimientoObjetivos = establecimientoObjetivos;
        this.objetivos = objetivos;
    }

    public Integer getIdObjetivo() {
        return this.idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Objetivo getParentObjetivo() {
        return this.parentObjetivo;
    }

    public void setParentObjetivo(Objetivo parentObjetivo) {
        this.parentObjetivo = parentObjetivo;
    }

    public Programa getPrograma() {
        return this.programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Requisito getRequisito() {
        return this.requisito;
    }

    public void setRequisito(Requisito requisito) {
        this.requisito = requisito;
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

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Set<EstablecimientoObjetivo> getEstablecimientoObjetivos() {
        return this.establecimientoObjetivos;
    }

    public void setEstablecimientoObjetivos(
        Set<EstablecimientoObjetivo> establecimientoObjetivos) {
        this.establecimientoObjetivos = establecimientoObjetivos;
    }

    public Set<Objetivo> getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(Set<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }
}
