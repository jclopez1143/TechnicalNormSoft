package co.com.technicalnormsoft.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.*;


/**
* @author Silicon Cali
* 
*
*/
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idUsuario;
    private String cargoPersonaContacto;
    private String celular;
    private Date dateIn;
    private Date dateUpdate;
    private String email;
    private String nit;
    private String nombrePersonaContacto;
    private String razonSocial;
    private String sitioWeb;
    private String telefono;
    private String password;
    private Set<Establecimiento> establecimientos = new HashSet<Establecimiento>(0);

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String cargoPersonaContacto,
        String celular, Date dateIn, Date dateUpdate, String email,
        Set<Establecimiento> establecimientos, String nit,
        String nombrePersonaContacto, String razonSocial, String sitioWeb,
        String telefono, String password) {
        this.idUsuario = idUsuario;
        this.cargoPersonaContacto = cargoPersonaContacto;
        this.celular = celular;
        this.dateIn = dateIn;
        this.dateUpdate = dateUpdate;
        this.email = email;
        this.nit = nit;
        this.nombrePersonaContacto = nombrePersonaContacto;
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.telefono = telefono;
        this.password = password;
        this.establecimientos = establecimientos;
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombrePersonaContacto() {
        return this.nombrePersonaContacto;
    }

    public void setNombrePersonaContacto(String nombrePersonaContacto) {
        this.nombrePersonaContacto = nombrePersonaContacto;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSitioWeb() {
        return this.sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Establecimiento> getEstablecimientos() {
        return this.establecimientos;
    }

    public void setEstablecimientos(Set<Establecimiento> establecimientos) {
        this.establecimientos = establecimientos;
    }
}
