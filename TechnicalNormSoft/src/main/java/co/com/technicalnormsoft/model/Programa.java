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
@Table(name = "programa", schema = "public")
public class Programa implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idPrograma;
    @NotNull
    private CategoriaPrograma categoriaPrograma;
    @NotNull
    private Proyecto proyecto;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<Objetivo> objetivos = new HashSet<Objetivo>(0);

    public Programa() {
    }

    public Programa(Integer idPrograma, CategoriaPrograma categoriaPrograma,
        Date dateIn, Date dateUpdate, String descripcion,
        Set<Objetivo> objetivos, Proyecto proyecto) {
        this.idPrograma = idPrograma;
        this.categoriaPrograma = categoriaPrograma;
        this.proyecto = proyecto;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
    }

    public Integer getIdPrograma() {
        return this.idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public CategoriaPrograma getCategoriaPrograma() {
        return this.categoriaPrograma;
    }

    public void setCategoriaPrograma(CategoriaPrograma categoriaPrograma) {
        this.categoriaPrograma = categoriaPrograma;
    }

    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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

    public Set<Objetivo> getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(Set<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }
}
