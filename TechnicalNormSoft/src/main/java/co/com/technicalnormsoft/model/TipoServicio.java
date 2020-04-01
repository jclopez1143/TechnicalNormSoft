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
@Table(name = "tipoServicio", schema = "public")
public class TipoServicio implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idTipoServicio;
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Set<Establecimiento> establecimientos = new HashSet<Establecimiento>(0);
    private Set<TipoServicioNorma> tipoServicioNormas = new HashSet<TipoServicioNorma>(0);

    public TipoServicio() {
    }

    public TipoServicio(Integer idTipoServicio, Date dateIn, Date dateUpdate,
        String descripcion, Set<Establecimiento> establecimientos,
        Set<TipoServicioNorma> tipoServicioNormas) {
        this.idTipoServicio = idTipoServicio;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.descripcion = descripcion;
        this.establecimientos = establecimientos;
        this.tipoServicioNormas = tipoServicioNormas;
    }

    public Integer getIdTipoServicio() {
        return this.idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
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

    public Set<Establecimiento> getEstablecimientos() {
        return this.establecimientos;
    }

    public void setEstablecimientos(Set<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }

    public Set<TipoServicioNorma> getTipoServicioNormas() {
        return this.tipoServicioNormas;
    }

    public void setTipoServicioNormas(Set<TipoServicioNorma> tipoServicioNormas) {
        this.tipoServicioNormas = tipoServicioNormas;
    }
}
