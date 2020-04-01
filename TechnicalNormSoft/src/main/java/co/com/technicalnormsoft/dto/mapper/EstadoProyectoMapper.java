package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.EstadoProyectoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
@Component
@Scope("singleton")
public class EstadoProyectoMapper implements IEstadoProyectoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstadoProyectoMapper.class);

    @Transactional(readOnly = true)
    public EstadoProyectoDTO estadoProyectoToEstadoProyectoDTO(
        EstadoProyecto estadoProyecto) throws Exception {
        try {
            EstadoProyectoDTO estadoProyectoDTO = new EstadoProyectoDTO();

            estadoProyectoDTO.setIdEstadoProyecto(estadoProyecto.getIdEstadoProyecto());
            estadoProyectoDTO.setDateIn(estadoProyecto.getDateIn());
            estadoProyectoDTO.setDateUpdate(estadoProyecto.getDateUpdate());
            estadoProyectoDTO.setDescripcion((estadoProyecto.getDescripcion() != null)
                ? estadoProyecto.getDescripcion() : null);

            return estadoProyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public EstadoProyecto estadoProyectoDTOToEstadoProyecto(
        EstadoProyectoDTO estadoProyectoDTO) throws Exception {
        try {
            EstadoProyecto estadoProyecto = new EstadoProyecto();

            estadoProyecto.setIdEstadoProyecto(estadoProyectoDTO.getIdEstadoProyecto());
            estadoProyecto.setDateIn(estadoProyectoDTO.getDateIn());
            estadoProyecto.setDateUpdate(estadoProyectoDTO.getDateUpdate());
            estadoProyecto.setDescripcion((estadoProyectoDTO.getDescripcion() != null)
                ? estadoProyectoDTO.getDescripcion() : null);

            return estadoProyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoProyectoDTO> listEstadoProyectoToListEstadoProyectoDTO(
        List<EstadoProyecto> listEstadoProyecto) throws Exception {
        try {
            List<EstadoProyectoDTO> estadoProyectoDTOs = new ArrayList<EstadoProyectoDTO>();

            for (EstadoProyecto estadoProyecto : listEstadoProyecto) {
                EstadoProyectoDTO estadoProyectoDTO = estadoProyectoToEstadoProyectoDTO(estadoProyecto);

                estadoProyectoDTOs.add(estadoProyectoDTO);
            }

            return estadoProyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoProyecto> listEstadoProyectoDTOToListEstadoProyecto(
        List<EstadoProyectoDTO> listEstadoProyectoDTO)
        throws Exception {
        try {
            List<EstadoProyecto> listEstadoProyecto = new ArrayList<EstadoProyecto>();

            for (EstadoProyectoDTO estadoProyectoDTO : listEstadoProyectoDTO) {
                EstadoProyecto estadoProyecto = estadoProyectoDTOToEstadoProyecto(estadoProyectoDTO);

                listEstadoProyecto.add(estadoProyecto);
            }

            return listEstadoProyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
