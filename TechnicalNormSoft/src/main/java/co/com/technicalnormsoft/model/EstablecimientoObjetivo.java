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
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "establecimientoObjetivo", schema = "public")
public class EstablecimientoObjetivo implements java.io.Serializable {
    @Id
    @NotNull
    private Integer establecimientoObjetivoId;
    @NotNull
    private Objetivo objetivo;
    @NotNull
    private EstadoObjetivo estadoObjetivo;
    @NotNull
    private ProyectoEstablecimiento proyectoEstablecimiento;
    private Date dateFin;
    private Date dateIn;
    private Date dateUpdate;
    private String resolucion;
    private Set<RegistroDato> registroDatos = new HashSet<RegistroDato>(0);
    private Set<ValorDato> valorDatos = new HashSet<ValorDato>(0);

    public EstablecimientoObjetivo() {
    }

    public EstablecimientoObjetivo(Integer establecimientoObjetivoId,
        Date dateFin, Date dateIn, Date dateUpdate, EstadoObjetivo estadoObjetivo,
        ProyectoEstablecimiento proyectoEstablecimiento, Objetivo objetivo,
        Set<RegistroDato> registroDatos, String resolucion,
        Set<ValorDato> valorDatos) {
        this.establecimientoObjetivoId = establecimientoObjetivoId;
        this.objetivo = objetivo;
        this.dateFin = dateFin;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.estadoObjetivo = estadoObjetivo;
        this.proyectoEstablecimiento = proyectoEstablecimiento;
        this.resolucion = resolucion;
        this.registroDatos = registroDatos;
        this.valorDatos = valorDatos;
    }

    public Integer getEstablecimientoObjetivoId() {
        return this.establecimientoObjetivoId;
    }

    public void setEstablecimientoObjetivoId(Integer establecimientoObjetivoId) {
        this.establecimientoObjetivoId = establecimientoObjetivoId;
    }

    public Objetivo getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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

    public EstadoObjetivo getEstadoObjetivo() {
        return this.estadoObjetivo;
    }

    public void setEstadoObjetivo(EstadoObjetivo estadoObjetivo) {
        this.estadoObjetivo = estadoObjetivo;
    }

    public ProyectoEstablecimiento getProyectoEstablecimiento() {
        return this.proyectoEstablecimiento;
    }

    public void setProyectoEstablecimiento(ProyectoEstablecimiento proyectoEstablecimiento) {
        this.proyectoEstablecimiento = proyectoEstablecimiento;
    }

    public String getResolucion() {
        return this.resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public Set<RegistroDato> getRegistroDatos() {
        return this.registroDatos;
    }

    public void setRegistroDatos(Set<RegistroDato> registroDatos) {
        this.registroDatos = registroDatos;
    }

    public Set<ValorDato> getValorDatos() {
        return this.valorDatos;
    }

    public void setValorDatos(Set<ValorDato> valorDatos) {
        this.valorDatos = valorDatos;
    }
}
