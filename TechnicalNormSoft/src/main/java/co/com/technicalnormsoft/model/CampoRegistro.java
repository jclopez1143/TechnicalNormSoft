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
@Table(name = "campoRegistro", schema = "public")
public class CampoRegistro implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idCampoRegistro;
    @NotNull
    private DatoObjetivo datoObjetivo;
    private Date dateIn;
    private Date dateUpdate;
    private String magnitud;
    private String nombre;
    private Integer prioridad;
    private String tipo;
    private Set<ValorCampo> valorCampos = new HashSet<ValorCampo>(0);

    public CampoRegistro() {
    }

    public CampoRegistro(Integer idCampoRegistro, Date dateIn, Date dateUpdate,
        DatoObjetivo datoObjetivo, String magnitud, String nombre,
        Integer prioridad, String tipo, Set<ValorCampo> valorCampos) {
        this.idCampoRegistro = idCampoRegistro;
        this.datoObjetivo = datoObjetivo;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.magnitud = magnitud;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.valorCampos = valorCampos;
    }

    public Integer getIdCampoRegistro() {
        return this.idCampoRegistro;
    }

    public void setIdCampoRegistro(Integer idCampoRegistro) {
        this.idCampoRegistro = idCampoRegistro;
    }

    public DatoObjetivo getDatoObjetivo() {
        return this.datoObjetivo;
    }

    public void setDatoObjetivo(DatoObjetivo datoObjetivo) {
        this.datoObjetivo = datoObjetivo;
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

    public String getMagnitud() {
        return this.magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<ValorCampo> getValorCampos() {
        return this.valorCampos;
    }

    public void setValorCampos(Set<ValorCampo> valorCampos) {
        this.valorCampos = valorCampos;
    }
}
