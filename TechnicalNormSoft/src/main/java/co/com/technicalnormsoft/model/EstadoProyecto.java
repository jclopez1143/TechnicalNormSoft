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
@Table(name = "estadoProyecto", schema = "public")
public class EstadoProyecto implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idEstadoProyecto;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<ProyectoEstablecimiento> proyectoEstablecimientos = new HashSet<ProyectoEstablecimiento>(0);

    public EstadoProyecto() {
    }

    public EstadoProyecto(Integer idEstadoProyecto, Date dateIn,
        Date dateUpdate, String descripcion,
        Set<ProyectoEstablecimiento> proyectoEstablecimientos) {
        this.idEstadoProyecto = idEstadoProyecto;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }

    public Integer getIdEstadoProyecto() {
        return this.idEstadoProyecto;
    }

    public void setIdEstadoProyecto(Integer idEstadoProyecto) {
        this.idEstadoProyecto = idEstadoProyecto;
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

    public Set<ProyectoEstablecimiento> getProyectoEstablecimientos() {
        return this.proyectoEstablecimientos;
    }

    public void setProyectoEstablecimientos(
        Set<ProyectoEstablecimiento> proyectoEstablecimientos) {
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }
}
