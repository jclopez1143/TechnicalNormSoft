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
@Table(name = "datoObjetivo", schema = "public")
public class DatoObjetivo implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idDatoObjetivo;
    @NotNull
    private Objetivo objetivo;
    private Date dateIn;
    private Date dateUpdate;
    private String magnitud;
    private String nombre;
    private Integer prioridad;
    private String tipo;
    private Set<CampoRegistro> campoRegistros = new HashSet<CampoRegistro>(0);
    private Set<ValorDato> valorDatos = new HashSet<ValorDato>(0);
    private Set<RegistroDato> registroDatos = new HashSet<RegistroDato>(0);

    public DatoObjetivo() {
    }

    public DatoObjetivo(Integer idDatoObjetivo,
        Set<CampoRegistro> campoRegistros, Date dateIn, Date dateUpdate,
        String magnitud, String nombre, Objetivo objetivo, Integer prioridad,
        String tipo, Set<ValorDato> valorDatos, Set<RegistroDato> registroDatos) {
        this.idDatoObjetivo = idDatoObjetivo;
        this.objetivo = objetivo;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.magnitud = magnitud;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.campoRegistros = campoRegistros;
        this.valorDatos = valorDatos;
        this.registroDatos = registroDatos;
        
    }

    public Integer getIdDatoObjetivo() {
        return this.idDatoObjetivo;
    }

    public void setIdDatoObjetivo(Integer idDatoObjetivo) {
        this.idDatoObjetivo = idDatoObjetivo;
    }

    public Objetivo getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
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

    public Set<CampoRegistro> getCampoRegistros() {
        return this.campoRegistros;
    }

    public void setCampoRegistros(Set<CampoRegistro> campoRegistros) {
        this.campoRegistros = campoRegistros;
    }

    public Set<ValorDato> getValorDatos() {
        return this.valorDatos;
    }

    public void setValorDatos(Set<ValorDato> valorDatos) {
        this.valorDatos = valorDatos;
    }

	public Set<RegistroDato> getRegistroDatos() {
		return registroDatos;
	}

	public void setRegistroDatos(Set<RegistroDato> registroDatos) {
		this.registroDatos = registroDatos;
	}
}
