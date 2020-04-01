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
public class TipoServicioNormaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoServicioNormaDTO.class);
    private Integer idTipoServicioNorma;
    private Integer idNorma_Norma;
    private Integer idTipoServicio_TipoServicio;

    public Integer getIdTipoServicioNorma() {
        return idTipoServicioNorma;
    }

    public void setIdTipoServicioNorma(Integer idTipoServicioNorma) {
        this.idTipoServicioNorma = idTipoServicioNorma;
    }

    public Integer getIdNorma_Norma() {
        return idNorma_Norma;
    }

    public void setIdNorma_Norma(Integer idNorma_Norma) {
        this.idNorma_Norma = idNorma_Norma;
    }

    public Integer getIdTipoServicio_TipoServicio() {
        return idTipoServicio_TipoServicio;
    }

    public void setIdTipoServicio_TipoServicio(
        Integer idTipoServicio_TipoServicio) {
        this.idTipoServicio_TipoServicio = idTipoServicio_TipoServicio;
    }
}
