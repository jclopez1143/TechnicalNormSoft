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
@Table(name = "categoriaRequisito", schema = "public")
public class CategoriaRequisito implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idCategoriaRequisito;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<Requisito> requisitos = new HashSet<Requisito>(0);

    public CategoriaRequisito() {
    }

    public CategoriaRequisito(Integer idCategoriaRequisito, Date dateIn,
        Date dateUpdate, String descripcion, Set<Requisito> requisitos) {
        this.idCategoriaRequisito = idCategoriaRequisito;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
    }

    public Integer getIdCategoriaRequisito() {
        return this.idCategoriaRequisito;
    }

    public void setIdCategoriaRequisito(Integer idCategoriaRequisito) {
        this.idCategoriaRequisito = idCategoriaRequisito;
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

    public Set<Requisito> getRequisitos() {
        return this.requisitos;
    }

    public void setRequisitos(Set<Requisito> requisitos) {
        this.requisitos = requisitos;
    }
}
