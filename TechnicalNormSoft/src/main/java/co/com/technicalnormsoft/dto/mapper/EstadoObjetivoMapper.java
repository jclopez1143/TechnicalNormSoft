package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.EstadoObjetivo;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.EstadoObjetivoDTO;

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
public class EstadoObjetivoMapper implements IEstadoObjetivoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstadoObjetivoMapper.class);

    @Transactional(readOnly = true)
    public EstadoObjetivoDTO estadoObjetivoToEstadoObjetivoDTO(
        EstadoObjetivo estadoObjetivo) throws Exception {
        try {
            EstadoObjetivoDTO estadoObjetivoDTO = new EstadoObjetivoDTO();

            estadoObjetivoDTO.setIdEstado(estadoObjetivo.getIdEstado());
            estadoObjetivoDTO.setDateIn(estadoObjetivo.getDateIn());
            estadoObjetivoDTO.setDateUpdate(estadoObjetivo.getDateUpdate());
            estadoObjetivoDTO.setDescripcion((estadoObjetivo.getDescripcion() != null)
                ? estadoObjetivo.getDescripcion() : null);

            return estadoObjetivoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public EstadoObjetivo estadoObjetivoDTOToEstadoObjetivo(
        EstadoObjetivoDTO estadoObjetivoDTO) throws Exception {
        try {
            EstadoObjetivo estadoObjetivo = new EstadoObjetivo();

            estadoObjetivo.setIdEstado(estadoObjetivoDTO.getIdEstado());
            estadoObjetivo.setDateIn(estadoObjetivoDTO.getDateIn());
            estadoObjetivo.setDateUpdate(estadoObjetivoDTO.getDateUpdate());
            estadoObjetivo.setDescripcion((estadoObjetivoDTO.getDescripcion() != null)
                ? estadoObjetivoDTO.getDescripcion() : null);

            return estadoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoObjetivoDTO> listEstadoObjetivoToListEstadoObjetivoDTO(
        List<EstadoObjetivo> listEstadoObjetivo) throws Exception {
        try {
            List<EstadoObjetivoDTO> estadoObjetivoDTOs = new ArrayList<EstadoObjetivoDTO>();

            for (EstadoObjetivo estadoObjetivo : listEstadoObjetivo) {
                EstadoObjetivoDTO estadoObjetivoDTO = estadoObjetivoToEstadoObjetivoDTO(estadoObjetivo);

                estadoObjetivoDTOs.add(estadoObjetivoDTO);
            }

            return estadoObjetivoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstadoObjetivo> listEstadoObjetivoDTOToListEstadoObjetivo(
        List<EstadoObjetivoDTO> listEstadoObjetivoDTO)
        throws Exception {
        try {
            List<EstadoObjetivo> listEstadoObjetivo = new ArrayList<EstadoObjetivo>();

            for (EstadoObjetivoDTO estadoObjetivoDTO : listEstadoObjetivoDTO) {
                EstadoObjetivo estadoObjetivo = estadoObjetivoDTOToEstadoObjetivo(estadoObjetivoDTO);

                listEstadoObjetivo.add(estadoObjetivo);
            }

            return listEstadoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
