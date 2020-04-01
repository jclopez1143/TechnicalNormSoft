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
public class ProgramaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProgramaDTO.class);
    private Date dateIn;
    private Date dateUpdate;
    private String descripcion;
    private Integer progreso;
    private Integer idPrograma;
    private String descripcion_CategoriaPrograma;
    private Integer idCategoriaPrograma_CategoriaPrograma;
    private Integer idProyecto_Proyecto;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Integer idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Integer getIdCategoriaPrograma_CategoriaPrograma() {
        return idCategoriaPrograma_CategoriaPrograma;
    }

    public void setIdCategoriaPrograma_CategoriaPrograma(
        Integer idCategoriaPrograma_CategoriaPrograma) {
        this.idCategoriaPrograma_CategoriaPrograma = idCategoriaPrograma_CategoriaPrograma;
    }

    public Integer getIdProyecto_Proyecto() {
        return idProyecto_Proyecto;
    }

    public void setIdProyecto_Proyecto(Integer idProyecto_Proyecto) {
        this.idProyecto_Proyecto = idProyecto_Proyecto;
    }

	public String getDescripcion_CategoriaPrograma() {
		return descripcion_CategoriaPrograma;
	}

	public void setDescripcion_CategoriaPrograma(String descripcion_CategoriaPrograma) {
		this.descripcion_CategoriaPrograma = descripcion_CategoriaPrograma;
	}

	public Integer getProgreso() {
		return progreso;
	}

	public void setProgreso(Integer progreso) {
		this.progreso = progreso;
	}
}
