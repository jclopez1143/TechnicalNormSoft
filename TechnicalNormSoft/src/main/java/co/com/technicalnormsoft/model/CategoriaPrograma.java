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
@Table(name = "categoriaPrograma", schema = "public")
public class CategoriaPrograma implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idCategoriaPrograma;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<Programa> programas = new HashSet<Programa>(0);

    public CategoriaPrograma() {
    }

    public CategoriaPrograma(Integer idCategoriaPrograma, Date dateIn,
        Date dateUpdate, String descripcion, Set<Programa> programas) {
        this.idCategoriaPrograma = idCategoriaPrograma;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.programas = programas;
    }

    public Integer getIdCategoriaPrograma() {
        return this.idCategoriaPrograma;
    }

    public void setIdCategoriaPrograma(Integer idCategoriaPrograma) {
        this.idCategoriaPrograma = idCategoriaPrograma;
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

    public Set<Programa> getProgramas() {
        return this.programas;
    }

    public void setProgramas(Set<Programa> programas) {
        this.programas = programas;
    }
}
