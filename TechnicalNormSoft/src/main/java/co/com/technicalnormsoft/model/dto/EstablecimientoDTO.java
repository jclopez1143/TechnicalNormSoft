package co.com.technicalnormsoft.model.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Silicon Cali
* 
*
*/
public class EstablecimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoDTO.class);
    private String cargoPersonaContacto;
    private String celular;
    private Date dateIn;
    private Date dateUpdate;
    private String direccion;
    private String email;
    private Integer idEstablecimiento;
    private String nombre;
    private String nombrePersonaContacto;
    private Double score;
    private String telefono;
    private Integer idTipoServicio_TipoServicio;
    private Integer idUsuario_Usuario;

    public String getCargoPersonaContacto() {
        return cargoPersonaContacto;
    }

    public void setCargoPersonaContacto(String cargoPersonaContacto) {
        this.cargoPersonaContacto = cargoPersonaContacto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrePersonaContacto() {
        return nombrePersonaContacto;
    }

    public void setNombrePersonaContacto(String nombrePersonaContacto) {
        this.nombrePersonaContacto = nombrePersonaContacto;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdTipoServicio_TipoServicio() {
        return idTipoServicio_TipoServicio;
    }

    public void setIdTipoServicio_TipoServicio(
        Integer idTipoServicio_TipoServicio) {
        this.idTipoServicio_TipoServicio = idTipoServicio_TipoServicio;
    }

    public Integer getIdUsuario_Usuario() {
        return idUsuario_Usuario;
    }

    public void setIdUsuario_Usuario(Integer idUsuario_Usuario) {
        this.idUsuario_Usuario = idUsuario_Usuario;
    }
}
