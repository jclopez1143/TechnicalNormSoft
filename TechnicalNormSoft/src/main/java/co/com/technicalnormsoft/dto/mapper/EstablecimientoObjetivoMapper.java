package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class EstablecimientoObjetivoMapper
    implements IEstablecimientoObjetivoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoObjetivoMapper.class);

    /**
    * Logic injected by Spring that manages Objetivo entities
    *
    */
    @Autowired
    IObjetivoLogic logicObjetivo1;
    /**
     * Logic injected by Spring that manages EstadoObjetivo entities
     *
     */
     @Autowired
     IEstadoObjetivoLogic logicEstadoObjetivo2;
     /**
      * Logic injected by Spring that manages ProyectoEstablecimiento entities
      *
      */
      @Autowired
      IProyectoEstablecimientoLogic logicProyectoEstablecimiento3;

    @Transactional(readOnly = true)
    public EstablecimientoObjetivoDTO establecimientoObjetivoToEstablecimientoObjetivoDTO(
        EstablecimientoObjetivo establecimientoObjetivo)
        throws Exception {
        try {
            EstablecimientoObjetivoDTO establecimientoObjetivoDTO = new EstablecimientoObjetivoDTO();

            establecimientoObjetivoDTO.setEstablecimientoObjetivoId(establecimientoObjetivo.getEstablecimientoObjetivoId());
            establecimientoObjetivoDTO.setDateFin(establecimientoObjetivo.getDateFin());
            establecimientoObjetivoDTO.setDateIn(establecimientoObjetivo.getDateIn());
            establecimientoObjetivoDTO.setDateUpdate(establecimientoObjetivo.getDateUpdate());
            establecimientoObjetivoDTO.setResolucion((establecimientoObjetivo.getResolucion() != null)
                ? establecimientoObjetivo.getResolucion() : null);

            if (establecimientoObjetivo.getObjetivo() != null) {
                establecimientoObjetivoDTO.setIdObjetivo_Objetivo(establecimientoObjetivo.getObjetivo()
                                                                                         .getIdObjetivo());
            } else {
                establecimientoObjetivoDTO.setIdObjetivo_Objetivo(null);
            }
            
            if (establecimientoObjetivo.getEstadoObjetivo() != null) {
                establecimientoObjetivoDTO.setIdEstadoObjetivo_EstadoObjetivo(establecimientoObjetivo.getEstadoObjetivo()
                		.getIdEstado());
            } else {
                establecimientoObjetivoDTO.setIdEstadoObjetivo_EstadoObjetivo(null);
            }
            
            if (establecimientoObjetivo.getProyectoEstablecimiento() != null) {
                establecimientoObjetivoDTO.setIdProyectoEstablecimiento_ProyectoEstablecimiento(
                		establecimientoObjetivo.getProyectoEstablecimiento().getIdProyectoEstablecimiento());
            } else {
                establecimientoObjetivoDTO.setIdProyectoEstablecimiento_ProyectoEstablecimiento(null);
            }

            return establecimientoObjetivoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public EstablecimientoObjetivo establecimientoObjetivoDTOToEstablecimientoObjetivo(
        EstablecimientoObjetivoDTO establecimientoObjetivoDTO)
        throws Exception {
        try {
            EstablecimientoObjetivo establecimientoObjetivo = new EstablecimientoObjetivo();

            establecimientoObjetivo.setEstablecimientoObjetivoId(establecimientoObjetivoDTO.getEstablecimientoObjetivoId());
            establecimientoObjetivo.setDateFin(establecimientoObjetivoDTO.getDateFin());
            establecimientoObjetivo.setDateIn(establecimientoObjetivoDTO.getDateIn());
            establecimientoObjetivo.setDateUpdate(establecimientoObjetivoDTO.getDateUpdate());
            establecimientoObjetivo.setResolucion((establecimientoObjetivoDTO.getResolucion() != null)
                ? establecimientoObjetivoDTO.getResolucion() : null);

            Objetivo objetivo = new Objetivo();

            if (establecimientoObjetivoDTO.getIdObjetivo_Objetivo() != null) {
                objetivo = logicObjetivo1.getObjetivo(establecimientoObjetivoDTO.getIdObjetivo_Objetivo());
            }

            if (objetivo != null) {
                establecimientoObjetivo.setObjetivo(objetivo);
            }
            
            EstadoObjetivo estadoObjetivo = new EstadoObjetivo();
            
            if (establecimientoObjetivoDTO.getIdEstadoObjetivo_EstadoObjetivo() != null) {
            	estadoObjetivo = logicEstadoObjetivo2.getEstadoObjetivo(
            			establecimientoObjetivoDTO.getIdEstadoObjetivo_EstadoObjetivo());
            }
            
            if (estadoObjetivo != null) {
            	establecimientoObjetivo.setEstadoObjetivo(estadoObjetivo);
            }
            
            ProyectoEstablecimiento proyectoEstablecimiento = new ProyectoEstablecimiento();
            
            if (establecimientoObjetivoDTO.getIdProyectoEstablecimiento_ProyectoEstablecimiento() != null) {
            	proyectoEstablecimiento = logicProyectoEstablecimiento3.getProyectoEstablecimiento(
            			establecimientoObjetivoDTO.getIdProyectoEstablecimiento_ProyectoEstablecimiento());
            }
            
            if (proyectoEstablecimiento != null) {
            	establecimientoObjetivo.setProyectoEstablecimiento(proyectoEstablecimiento);
            }

            return establecimientoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstablecimientoObjetivoDTO> listEstablecimientoObjetivoToListEstablecimientoObjetivoDTO(
        List<EstablecimientoObjetivo> listEstablecimientoObjetivo)
        throws Exception {
        try {
            List<EstablecimientoObjetivoDTO> establecimientoObjetivoDTOs = new ArrayList<EstablecimientoObjetivoDTO>();

            for (EstablecimientoObjetivo establecimientoObjetivo : listEstablecimientoObjetivo) {
                EstablecimientoObjetivoDTO establecimientoObjetivoDTO = establecimientoObjetivoToEstablecimientoObjetivoDTO(establecimientoObjetivo);

                establecimientoObjetivoDTOs.add(establecimientoObjetivoDTO);
            }

            return establecimientoObjetivoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstablecimientoObjetivo> listEstablecimientoObjetivoDTOToListEstablecimientoObjetivo(
        List<EstablecimientoObjetivoDTO> listEstablecimientoObjetivoDTO)
        throws Exception {
        try {
            List<EstablecimientoObjetivo> listEstablecimientoObjetivo = new ArrayList<EstablecimientoObjetivo>();

            for (EstablecimientoObjetivoDTO establecimientoObjetivoDTO : listEstablecimientoObjetivoDTO) {
                EstablecimientoObjetivo establecimientoObjetivo = establecimientoObjetivoDTOToEstablecimientoObjetivo(establecimientoObjetivoDTO);

                listEstablecimientoObjetivo.add(establecimientoObjetivo);
            }

            return listEstablecimientoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
