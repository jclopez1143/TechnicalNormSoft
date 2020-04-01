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
@Table(name = "establecimiento", schema = "public")
public class Establecimiento implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idEstablecimiento;
    @NotNull
    private TipoServicio tipoServicio;
    @NotNull
    private Usuario usuario;
    private String cargoPersonaContacto;
    private String celular;
    private Date dateIn;
    private Date dateUpdate;
    private String direccion;
    private String email;
    private String nombre;
    private String nombrePersonaContacto;
    private Double score;
    private String telefono;
    private Set<MedallaEstablecimiento> medallaEstablecimientos = new HashSet<MedallaEstablecimiento>(0);
    private Set<ProyectoEstablecimiento> proyectoEstablecimientos = new HashSet<ProyectoEstablecimiento>(0);

    public Establecimiento() {
    }

    public Establecimiento(Integer idEstablecimiento,
        String cargoPersonaContacto, String celular, Date dateIn,
        Date dateUpdate, String direccion, String email,
        Set<MedallaEstablecimiento> medallaEstablecimientos, String nombre,
        String nombrePersonaContacto,
        Set<ProyectoEstablecimiento> proyectoEstablecimientos, Double score,
        String telefono, TipoServicio tipoServicio, Usuario usuario) {
        this.idEstablecimiento = idEstablecimiento;
        this.tipoServicio = tipoServicio;
        this.usuario = usuario;
        this.cargoPersonaContacto = cargoPersonaContacto;
        this.celular = celular;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.nombrePersonaContacto = nombrePersonaContacto;
        this.score = score;
        this.telefono = telefono;
        this.medallaEstablecimientos = medallaEstablecimientos;
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }

    public Integer getIdEstablecimiento() {
        return this.idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCargoPersonaContacto() {
        return this.cargoPersonaContacto;
    }

    public void setCargoPersonaContacto(String cargoPersonaContacto) {
        this.cargoPersonaContacto = cargoPersonaContacto;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePersonaContacto() {
        return this.nombrePersonaContacto;
    }

    public void setNombrePersonaContacto(String nombrePersonaContacto) {
        this.nombrePersonaContacto = nombrePersonaContacto;
    }

    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<MedallaEstablecimiento> getMedallaEstablecimientos() {
        return this.medallaEstablecimientos;
    }

    public void setMedallaEstablecimientos(
        Set<MedallaEstablecimiento> medallaEstablecimientos) {
        this.medallaEstablecimientos = medallaEstablecimientos;
    }

    public Set<ProyectoEstablecimiento> getProyectoEstablecimientos() {
        return this.proyectoEstablecimientos;
    }

    public void setProyectoEstablecimientos(
        Set<ProyectoEstablecimiento> proyectoEstablecimientos) {
        this.proyectoEstablecimientos = proyectoEstablecimientos;
    }
}
