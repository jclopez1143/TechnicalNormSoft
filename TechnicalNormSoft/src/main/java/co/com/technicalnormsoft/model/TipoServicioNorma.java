package co.com.technicalnormsoft.model;

import org.hibernate.validator.constraints.*;

import java.util.Date;

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
@Table(name = "tipoServicioNorma", schema = "public")
public class TipoServicioNorma implements java.io.Serializable {
    @Id
    @NotNull
    private Integer idTipoServicioNorma;
    @NotNull
    private Norma norma;
    @NotNull
    private TipoServicio tipoServicio;

    public TipoServicioNorma() {
    }

    public TipoServicioNorma(Integer idTipoServicioNorma, Norma norma,
        TipoServicio tipoServicio) {
        this.idTipoServicioNorma = idTipoServicioNorma;
        this.norma = norma;
        this.tipoServicio = tipoServicio;
    }

    public Integer getIdTipoServicioNorma() {
        return this.idTipoServicioNorma;
    }

    public void setIdTipoServicioNorma(Integer idTipoServicioNorma) {
        this.idTipoServicioNorma = idTipoServicioNorma;
    }

    public Norma getNorma() {
        return this.norma;
    }

    public void setNorma(Norma norma) {
        this.norma = norma;
    }

    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
