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
@Table(name = "proyecto", schema = "public")
public class Proyecto  implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idProyecto;
    @NotNull
    private Norma norma;
    private Date dateIn;
    private Date dateUpdate;
    private String nombre;
    private String numeral;
    private Set<Programa> programas = new HashSet<Programa>(0);
    private Set<ProyectoEstablecimiento> proyectoEstablecimientos = new HashSet<ProyectoEstablecimiento>(0);

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto, Date dateIn, Date dateUpdate,
        String nombre, String numeral, Norma norma, Set<Programa> programas,
        Set<ProyectoEstablecimiento> proyectoEstablecimientos) {
        this.idProyecto = idProyecto;
        this.norma = norma;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.nombre = nombre;
        this.numeral = numeral;
        this.programas = programas;
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }

    public Integer getIdProyecto() {
        return this.idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Norma getNorma() {
        return this.norma;
    }

    public void setNorma(Norma norma) {
        this.norma = norma;
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

    public String getNumeral() {
		return numeral;
	}

	public void setNumeral(String numeral) {
		this.numeral = numeral;
	}

	public Set<Programa> getProgramas() {
        return this.programas;
    }

    public void setProgramas(Set<Programa> programas) {
        this.programas = programas;
    }

    public Set<ProyectoEstablecimiento> getProyectoEstablecimientos() {
        return this.proyectoEstablecimientos;
    }

    public void setProyectoEstablecimientos(
        Set<ProyectoEstablecimiento> proyectoEstablecimientos) {
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }
}
