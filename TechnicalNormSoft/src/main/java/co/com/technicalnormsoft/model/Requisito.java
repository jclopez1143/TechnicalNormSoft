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
@Table(name = "requisito", schema = "public")
public class Requisito implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idRequisito;
    @NotNull
    private CategoriaRequisito categoriaRequisito;
    @NotNull
    private Norma norma;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private String numeral;
    private Set<Objetivo> objetivos = new HashSet<Objetivo>(0);

    public Requisito() {
    }

    public Requisito(Integer idRequisito,
        CategoriaRequisito categoriaRequisito, Date dateIn, Date dateUpdate,
        String descripcion, Norma norma, String numeral, Set<Objetivo> objetivos) {
        this.idRequisito = idRequisito;
        this.categoriaRequisito = categoriaRequisito;
        this.norma = norma;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.numeral = numeral;
        this.objetivos = objetivos;
    }

    public Integer getIdRequisito() {
        return this.idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public CategoriaRequisito getCategoriaRequisito() {
        return this.categoriaRequisito;
    }

    public void setCategoriaRequisito(CategoriaRequisito categoriaRequisito) {
        this.categoriaRequisito = categoriaRequisito;
    }

    public Norma getNorma() {
        return this.norma;
    }

    public void setNorma(Norma norma) {
        this.norma = norma;
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

    public String getNumeral() {
        return this.numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public Set<Objetivo> getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(Set<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }
}
