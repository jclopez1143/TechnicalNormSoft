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
@Table(name = "estadoObjetivo", schema = "public")
public class EstadoObjetivo implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idEstado;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<EstablecimientoObjetivo> establecimientoObjetivos = new HashSet<EstablecimientoObjetivo>(0);

    public EstadoObjetivo() {
    }

    public EstadoObjetivo(Integer idEstado, Date dateIn, Date dateUpdate,
        String descripcion,
        Set<EstablecimientoObjetivo> establecimientoObjetivos) {
        this.idEstado = idEstado;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.establecimientoObjetivos = establecimientoObjetivos;
    }

    public Integer getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
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

    public Set<EstablecimientoObjetivo> getEstablecimientoObjetivos() {
        return this.establecimientoObjetivos;
    }

    public void setEstablecimientoObjetivos(
        Set<EstablecimientoObjetivo> establecimientoObjetivos) {
        this.establecimientoObjetivos = establecimientoObjetivos;
    }
}
