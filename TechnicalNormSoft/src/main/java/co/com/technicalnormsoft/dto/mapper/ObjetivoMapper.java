package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Objetivo;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope("singleton")
public class ObjetivoMapper implements IObjetivoMapper {
    private static final Logger log = LoggerFactory.getLogger(ObjetivoMapper.class);

    @Autowired
    IObjetivoLogic logicObjetivo1;

    @Autowired
    IProgramaLogic logicPrograma2;

    @Autowired
    IRequisitoLogic logicRequisito3;

    @Transactional(readOnly = true)
    public ObjetivoDTO objetivoToObjetivoDTO(Objetivo objetivo)
        throws Exception {
        try {
            ObjetivoDTO objetivoDTO = new ObjetivoDTO();

            objetivoDTO.setIdObjetivo(objetivo.getIdObjetivo());
            objetivoDTO.setDateIn(objetivo.getDateIn());
            objetivoDTO.setDateUpdate(objetivo.getDateUpdate());
            objetivoDTO.setDescripcion((objetivo.getDescripcion() != null)
                ? objetivo.getDescripcion() : null);
            objetivoDTO.setScore((objetivo.getScore() != null)
                    ? objetivo.getScore() : null);

            if (objetivo.getParentObjetivo() != null) {
                objetivoDTO.setIdObjetivo_Objetivo(objetivo.getParentObjetivo()
                                                           .getIdObjetivo());
            } else {
                objetivoDTO.setIdObjetivo_Objetivo(null);
            }

            if (objetivo.getPrograma() != null) {
                objetivoDTO.setIdPrograma_Programa(objetivo.getPrograma()
                                                           .getIdPrograma());
            } else {
                objetivoDTO.setIdPrograma_Programa(null);
            }

            if (objetivo.getRequisito() != null) {
                objetivoDTO.setIdRequisito_Requisito(objetivo.getRequisito()
                                                             .getIdRequisito());
            } else {
                objetivoDTO.setIdRequisito_Requisito(null);
            }

            return objetivoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Objetivo objetivoDTOToObjetivo(ObjetivoDTO objetivoDTO)
        throws Exception {
        try {
            Objetivo objetivo = new Objetivo();

            objetivo.setIdObjetivo(objetivoDTO.getIdObjetivo());
            objetivo.setDateIn(objetivoDTO.getDateIn());
            objetivo.setDateUpdate(objetivoDTO.getDateUpdate());
            objetivo.setDescripcion((objetivoDTO.getDescripcion() != null)
                ? objetivoDTO.getDescripcion() : null);
            objetivo.setScore((objetivoDTO.getScore() != null)
                    ? objetivoDTO.getScore() : null);

            Objetivo parentObjetivo = new Objetivo();

            if (objetivoDTO.getIdObjetivo_Objetivo() != null) {
            	parentObjetivo = logicObjetivo1.getObjetivo(objetivoDTO.getIdObjetivo_Objetivo());
            }

            if (parentObjetivo != null) {
                objetivo.setParentObjetivo(parentObjetivo);
            }

            Programa programa = new Programa();

            if (objetivoDTO.getIdPrograma_Programa() != null) {
                programa = logicPrograma2.getPrograma(objetivoDTO.getIdPrograma_Programa());
            }

            if (programa != null) {
                objetivo.setPrograma(programa);
            }

            Requisito requisito = new Requisito();

            if (objetivoDTO.getIdRequisito_Requisito() != null) {
                requisito = logicRequisito3.getRequisito(objetivoDTO.getIdRequisito_Requisito());
            }

            if (requisito != null) {
                objetivo.setRequisito(requisito);
            }

            return objetivo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ObjetivoDTO> listObjetivoToListObjetivoDTO(
        List<Objetivo> listObjetivo) throws Exception {
        try {
            List<ObjetivoDTO> objetivoDTOs = new ArrayList<ObjetivoDTO>();

            for (Objetivo objetivo : listObjetivo) {
                ObjetivoDTO objetivoDTO = objetivoToObjetivoDTO(objetivo);

                objetivoDTOs.add(objetivoDTO);
            }

            return objetivoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Objetivo> listObjetivoDTOToListObjetivo(
        List<ObjetivoDTO> listObjetivoDTO) throws Exception {
        try {
            List<Objetivo> listObjetivo = new ArrayList<Objetivo>();

            for (ObjetivoDTO objetivoDTO : listObjetivoDTO) {
                Objetivo objetivo = objetivoDTOToObjetivo(objetivoDTO);

                listObjetivo.add(objetivo);
            }

            return listObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
