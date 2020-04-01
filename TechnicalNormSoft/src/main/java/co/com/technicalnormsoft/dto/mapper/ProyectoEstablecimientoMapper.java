package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.ProyectoEstablecimiento;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;

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
public class ProyectoEstablecimientoMapper
    implements IProyectoEstablecimientoMapper {
    private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoMapper.class);

    /**
    * Logic injected by Spring that manages Establecimiento entities
    *
    */
    @Autowired
    IEstablecimientoLogic logicEstablecimiento1;

    /**
    * Logic injected by Spring that manages EstadoProyecto entities
    *
    */
    @Autowired
    IEstadoProyectoLogic logicEstadoProyecto2;

    /**
    * Logic injected by Spring that manages Proyecto entities
    *
    */
    @Autowired
    IProyectoLogic logicProyecto3;

    @Transactional(readOnly = true)
    public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
        ProyectoEstablecimiento proyectoEstablecimiento)
        throws Exception {
        try {
            ProyectoEstablecimientoDTO proyectoEstablecimientoDTO = new ProyectoEstablecimientoDTO();

            proyectoEstablecimientoDTO.setIdProyectoEstablecimiento(proyectoEstablecimiento.getIdProyectoEstablecimiento());
            proyectoEstablecimientoDTO.setDateIn(proyectoEstablecimiento.getDateIn());
            proyectoEstablecimientoDTO.setDateUpdate(proyectoEstablecimiento.getDateUpdate());
            proyectoEstablecimientoDTO.setNombre((proyectoEstablecimiento.getNombre() != null)
                ? proyectoEstablecimiento.getNombre() : null);
            proyectoEstablecimientoDTO.setScore((proyectoEstablecimiento.getScore() != null)
                ? proyectoEstablecimiento.getScore() : null);

            if (proyectoEstablecimiento.getEstablecimiento() != null) {
                proyectoEstablecimientoDTO.setIdEstablecimiento_Establecimiento(proyectoEstablecimiento.getEstablecimiento()
                                                                                                       .getIdEstablecimiento());
            } else {
                proyectoEstablecimientoDTO.setIdEstablecimiento_Establecimiento(null);
            }

            proyectoEstablecimientoDTO.setIdEstadoProyecto_EstadoProyecto((proyectoEstablecimiento.getEstadoProyecto()
                                                                                                  .getIdEstadoProyecto() != null)
                ? proyectoEstablecimiento.getEstadoProyecto()
                                         .getIdEstadoProyecto() : null);

            if (proyectoEstablecimiento.getProyecto() != null) {
                proyectoEstablecimientoDTO.setIdProyecto_Proyecto(proyectoEstablecimiento.getProyecto()
                                                                                         .getIdProyecto());
            } else {
                proyectoEstablecimientoDTO.setIdProyecto_Proyecto(null);
            }

            return proyectoEstablecimientoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProyectoEstablecimiento proyectoEstablecimientoDTOToProyectoEstablecimiento(
        ProyectoEstablecimientoDTO proyectoEstablecimientoDTO)
        throws Exception {
        try {
            ProyectoEstablecimiento proyectoEstablecimiento = new ProyectoEstablecimiento();

            proyectoEstablecimiento.setIdProyectoEstablecimiento(proyectoEstablecimientoDTO.getIdProyectoEstablecimiento());
            proyectoEstablecimiento.setDateIn(proyectoEstablecimientoDTO.getDateIn());
            proyectoEstablecimiento.setDateUpdate(proyectoEstablecimientoDTO.getDateUpdate());
            proyectoEstablecimiento.setNombre((proyectoEstablecimientoDTO.getNombre() != null)
                ? proyectoEstablecimientoDTO.getNombre() : null);
            proyectoEstablecimiento.setScore((proyectoEstablecimientoDTO.getScore() != null)
                ? proyectoEstablecimientoDTO.getScore() : null);

            Establecimiento establecimiento = new Establecimiento();

            if (proyectoEstablecimientoDTO.getIdEstablecimiento_Establecimiento() != null) {
                establecimiento = logicEstablecimiento1.getEstablecimiento(proyectoEstablecimientoDTO.getIdEstablecimiento_Establecimiento());
            }

            if (establecimiento != null) {
                proyectoEstablecimiento.setEstablecimiento(establecimiento);
            }

            EstadoProyecto estadoProyecto = new EstadoProyecto();

            if (proyectoEstablecimientoDTO.getIdEstadoProyecto_EstadoProyecto() != null) {
                estadoProyecto = logicEstadoProyecto2.getEstadoProyecto(proyectoEstablecimientoDTO.getIdEstadoProyecto_EstadoProyecto());
            }

            if (estadoProyecto != null) {
                proyectoEstablecimiento.setEstadoProyecto(estadoProyecto);
            }

            Proyecto proyecto = new Proyecto();

            if (proyectoEstablecimientoDTO.getIdProyecto_Proyecto() != null) {
                proyecto = logicProyecto3.getProyecto(proyectoEstablecimientoDTO.getIdProyecto_Proyecto());
            }

            if (proyecto != null) {
                proyectoEstablecimiento.setProyecto(proyecto);
            }

            return proyectoEstablecimiento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProyectoEstablecimientoDTO> listProyectoEstablecimientoToListProyectoEstablecimientoDTO(
        List<ProyectoEstablecimiento> listProyectoEstablecimiento)
        throws Exception {
        try {
            List<ProyectoEstablecimientoDTO> proyectoEstablecimientoDTOs = new ArrayList<ProyectoEstablecimientoDTO>();

            for (ProyectoEstablecimiento proyectoEstablecimiento : listProyectoEstablecimiento) {
                ProyectoEstablecimientoDTO proyectoEstablecimientoDTO = proyectoEstablecimientoToProyectoEstablecimientoDTO(proyectoEstablecimiento);

                proyectoEstablecimientoDTOs.add(proyectoEstablecimientoDTO);
            }

            return proyectoEstablecimientoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProyectoEstablecimiento> listProyectoEstablecimientoDTOToListProyectoEstablecimiento(
        List<ProyectoEstablecimientoDTO> listProyectoEstablecimientoDTO)
        throws Exception {
        try {
            List<ProyectoEstablecimiento> listProyectoEstablecimiento = new ArrayList<ProyectoEstablecimiento>();

            for (ProyectoEstablecimientoDTO proyectoEstablecimientoDTO : listProyectoEstablecimientoDTO) {
                ProyectoEstablecimiento proyectoEstablecimiento = proyectoEstablecimientoDTOToProyectoEstablecimiento(proyectoEstablecimientoDTO);

                listProyectoEstablecimiento.add(proyectoEstablecimiento);
            }

            return listProyectoEstablecimiento;
        } catch (Exception e) {
            throw e;
        }
    }
}
