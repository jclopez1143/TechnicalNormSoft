package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Programa;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;

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
public class ProgramaMapper implements IProgramaMapper {
    private static final Logger log = LoggerFactory.getLogger(ProgramaMapper.class);

    /**
    * Logic injected by Spring that manages CategoriaPrograma entities
    *
    */
    @Autowired
    ICategoriaProgramaLogic logicCategoriaPrograma1;

    /**
    * Logic injected by Spring that manages Proyecto entities
    *
    */
    @Autowired
    IProyectoLogic logicProyecto2;

    @Transactional(readOnly = true)
    public ProgramaDTO programaToProgramaDTO(Programa programa)
        throws Exception {
        try {
            ProgramaDTO programaDTO = new ProgramaDTO();

            programaDTO.setIdPrograma(programa.getIdPrograma());
            programaDTO.setDateIn(programa.getDateIn());
            programaDTO.setDateUpdate(programa.getDateUpdate());
            programaDTO.setDescripcion((programa.getDescripcion() != null)
                ? programa.getDescripcion() : null);
            programaDTO.setIdCategoriaPrograma_CategoriaPrograma((programa.getCategoriaPrograma()
                                                                          .getIdCategoriaPrograma() != null)
                ? programa.getCategoriaPrograma().getIdCategoriaPrograma() : null);

            if (programa.getProyecto() != null) {
                programaDTO.setIdProyecto_Proyecto(programa.getProyecto()
                                                           .getIdProyecto());
            } else {
                programaDTO.setIdProyecto_Proyecto(null);
            }

            return programaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Programa programaDTOToPrograma(ProgramaDTO programaDTO)
        throws Exception {
        try {
            Programa programa = new Programa();

            programa.setIdPrograma(programaDTO.getIdPrograma());
            programa.setDateIn(programaDTO.getDateIn());
            programa.setDateUpdate(programaDTO.getDateUpdate());
            programa.setDescripcion((programaDTO.getDescripcion() != null)
                ? programaDTO.getDescripcion() : null);

            CategoriaPrograma categoriaPrograma = new CategoriaPrograma();

            if (programaDTO.getIdCategoriaPrograma_CategoriaPrograma() != null) {
                categoriaPrograma = logicCategoriaPrograma1.getCategoriaPrograma(programaDTO.getIdCategoriaPrograma_CategoriaPrograma());
            }

            if (categoriaPrograma != null) {
                programa.setCategoriaPrograma(categoriaPrograma);
            }

            Proyecto proyecto = new Proyecto();

            if (programaDTO.getIdProyecto_Proyecto() != null) {
                proyecto = logicProyecto2.getProyecto(programaDTO.getIdProyecto_Proyecto());
            }

            if (proyecto != null) {
                programa.setProyecto(proyecto);
            }

            return programa;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaDTO> listProgramaToListProgramaDTO(
        List<Programa> listPrograma) throws Exception {
        try {
            List<ProgramaDTO> programaDTOs = new ArrayList<ProgramaDTO>();

            for (Programa programa : listPrograma) {
                ProgramaDTO programaDTO = programaToProgramaDTO(programa);

                programaDTOs.add(programaDTO);
            }

            return programaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Programa> listProgramaDTOToListPrograma(
        List<ProgramaDTO> listProgramaDTO) throws Exception {
        try {
            List<Programa> listPrograma = new ArrayList<Programa>();

            for (ProgramaDTO programaDTO : listProgramaDTO) {
                Programa programa = programaDTOToPrograma(programaDTO);

                listPrograma.add(programa);
            }

            return listPrograma;
        } catch (Exception e) {
            throw e;
        }
    }
}
