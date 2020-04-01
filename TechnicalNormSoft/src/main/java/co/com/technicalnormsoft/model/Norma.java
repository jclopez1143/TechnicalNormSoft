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
@Table(name = "norma", schema = "public")
public class Norma implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idNorma;
    private Date dateIn;
    private Date dateUpdate;
    private String nombre;
    private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);
    private Set<Requisito> requisitos = new HashSet<Requisito>(0);
    private Set<TipoServicioNorma> tipoServicioNormas = new HashSet<TipoServicioNorma>(0);

    public Norma() {
    }

    public Norma(Integer idNorma, Date dateIn, Date dateUpdate, String nombre,
        Set<Proyecto> proyectos, Set<Requisito> requisitos,
        Set<TipoServicioNorma> tipoServicioNormas) {
        this.idNorma = idNorma;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.nombre = nombre;
        this.proyectos = proyectos;
        this.requisitos = requisitos;
        this.tipoServicioNormas = tipoServicioNormas;
    }

    public Integer getIdNorma() {
        return this.idNorma;
    }

    public void setIdNorma(Integer idNorma) {
        this.idNorma = idNorma;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Set<Requisito> getRequisitos() {
        return this.requisitos;
    }

    public void setRequisitos(Set<Requisito> requisitos) {
        this.requisitos = requisitos;
    }

    public Set<TipoServicioNorma> getTipoServicioNormas() {
        return this.tipoServicioNormas;
    }

    public void setTipoServicioNormas(Set<TipoServicioNorma> tipoServicioNormas) {
        this.tipoServicioNormas = tipoServicioNormas;
    }
}
