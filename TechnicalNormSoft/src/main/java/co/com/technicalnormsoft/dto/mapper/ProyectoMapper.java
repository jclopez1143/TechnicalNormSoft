package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Proyecto;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;

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
public class ProyectoMapper implements IProyectoMapper {
    private static final Logger log = LoggerFactory.getLogger(ProyectoMapper.class);

    /**
    * Logic injected by Spring that manages Norma entities
    *
    */
    @Autowired
    INormaLogic logicNorma1;

    @Transactional(readOnly = true)
    public ProyectoDTO proyectoToProyectoDTO(Proyecto proyecto)
        throws Exception {
        try {
            ProyectoDTO proyectoDTO = new ProyectoDTO();

            proyectoDTO.setIdProyecto(proyecto.getIdProyecto());
            proyectoDTO.setDateIn(proyecto.getDateIn());
            proyectoDTO.setDateUpdate(proyecto.getDateUpdate());
            proyectoDTO.setNombre((proyecto.getNombre() != null)
                ? proyecto.getNombre() : null);
            proyectoDTO.setNumeral((proyecto.getNumeral() != null)
                    ? proyecto.getNumeral() : null);

            if (proyecto.getNorma() != null) {
                proyectoDTO.setIdNorma_Norma(proyecto.getNorma().getIdNorma());
            } else {
                proyectoDTO.setIdNorma_Norma(null);
            }

            return proyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Proyecto proyectoDTOToProyecto(ProyectoDTO proyectoDTO)
        throws Exception {
        try {
            Proyecto proyecto = new Proyecto();

            proyecto.setIdProyecto(proyectoDTO.getIdProyecto());
            proyecto.setDateIn(proyectoDTO.getDateIn());
            proyecto.setDateUpdate(proyectoDTO.getDateUpdate());
            proyecto.setNombre((proyectoDTO.getNombre() != null)
                ? proyectoDTO.getNombre() : null);
            proyecto.setNumeral((proyectoDTO.getNumeral() != null)
                    ? proyectoDTO.getNumeral() : null);

            Norma norma = new Norma();

            if (proyectoDTO.getIdNorma_Norma() != null) {
                norma = logicNorma1.getNorma(proyectoDTO.getIdNorma_Norma());
            }

            if (norma != null) {
                proyecto.setNorma(norma);
            }

            return proyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProyectoDTO> listProyectoToListProyectoDTO(
        List<Proyecto> listProyecto) throws Exception {
        try {
            List<ProyectoDTO> proyectoDTOs = new ArrayList<ProyectoDTO>();

            for (Proyecto proyecto : listProyecto) {
                ProyectoDTO proyectoDTO = proyectoToProyectoDTO(proyecto);

                proyectoDTOs.add(proyectoDTO);
            }

            return proyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Proyecto> listProyectoDTOToListProyecto(
        List<ProyectoDTO> listProyectoDTO) throws Exception {
        try {
            List<Proyecto> listProyecto = new ArrayList<Proyecto>();

            for (ProyectoDTO proyectoDTO : listProyectoDTO) {
                Proyecto proyecto = proyectoDTOToProyecto(proyectoDTO);

                listProyecto.add(proyecto);
            }

            return listProyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
