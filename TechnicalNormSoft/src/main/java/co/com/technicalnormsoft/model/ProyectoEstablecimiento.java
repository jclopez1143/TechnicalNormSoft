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
@Table(name = "proyectoEstablecimiento", schema = "public")
public class ProyectoEstablecimiento implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idProyectoEstablecimiento;
    @NotNull
    private Establecimiento establecimiento;
    @NotNull
    private EstadoProyecto estadoProyecto;
    @NotNull
    private Proyecto proyecto;
    private Date dateIn;
    private Date dateUpdate;
    private String nombre;
    private Double score;
    private Set<EstablecimientoObjetivo> establecimientoObjetivos = new HashSet<EstablecimientoObjetivo>(0);

    public ProyectoEstablecimiento() {
    }

    public ProyectoEstablecimiento(Integer idProyectoEstablecimiento,
        Date dateIn, Date dateUpdate, Establecimiento establecimiento,
        Set<EstablecimientoObjetivo> establecimientoObjetivos,
        EstadoProyecto estadoProyecto, String nombre, Proyecto proyecto,
        Double score) {
        this.idProyectoEstablecimiento = idProyectoEstablecimiento;
        this.establecimiento = establecimiento;
        this.estadoProyecto = estadoProyecto;
        this.proyecto = proyecto;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.nombre = nombre;
        this.score = score;
        this.establecimientoObjetivos = establecimientoObjetivos;
    }

    public Integer getIdProyectoEstablecimiento() {
        return this.idProyectoEstablecimiento;
    }

    public void setIdProyectoEstablecimiento(Integer idProyectoEstablecimiento) {
        this.idProyectoEstablecimiento = idProyectoEstablecimiento;
    }

    public Establecimiento getEstablecimiento() {
        return this.establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public EstadoProyecto getEstadoProyecto() {
        return this.estadoProyecto;
    }

    public void setEstadoProyecto(EstadoProyecto estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
