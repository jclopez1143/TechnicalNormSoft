package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;

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
public class DatoObjetivoMapper implements IDatoObjetivoMapper {
    private static final Logger log = LoggerFactory.getLogger(DatoObjetivoMapper.class);

    /**
    * Logic injected by Spring that manages Objetivo entities
    *
    */
    @Autowired
    IObjetivoLogic logicObjetivo1;

    @Transactional(readOnly = true)
    public DatoObjetivoDTO datoObjetivoToDatoObjetivoDTO(
        DatoObjetivo datoObjetivo) throws Exception {
        try {
            DatoObjetivoDTO datoObjetivoDTO = new DatoObjetivoDTO();

            datoObjetivoDTO.setIdDatoObjetivo(datoObjetivo.getIdDatoObjetivo());
            datoObjetivoDTO.setDateIn(datoObjetivo.getDateIn());
            datoObjetivoDTO.setDateUpdate(datoObjetivo.getDateUpdate());
            datoObjetivoDTO.setMagnitud((datoObjetivo.getMagnitud() != null)
                ? datoObjetivo.getMagnitud() : null);
            datoObjetivoDTO.setNombre((datoObjetivo.getNombre() != null)
                ? datoObjetivo.getNombre() : null);
            datoObjetivoDTO.setPrioridad((datoObjetivo.getPrioridad() != null)
                ? datoObjetivo.getPrioridad() : null);
            datoObjetivoDTO.setTipo((datoObjetivo.getTipo() != null)
                ? datoObjetivo.getTipo() : null);
            datoObjetivoDTO.setIdObjetivo_Objetivo((datoObjetivo.getObjetivo()
                                                                .getIdObjetivo() != null)
                ? datoObjetivo.getObjetivo().getIdObjetivo() : null);

            return datoObjetivoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatoObjetivo datoObjetivoDTOToDatoObjetivo(
        DatoObjetivoDTO datoObjetivoDTO) throws Exception {
        try {
            DatoObjetivo datoObjetivo = new DatoObjetivo();

            datoObjetivo.setIdDatoObjetivo(datoObjetivoDTO.getIdDatoObjetivo());
            datoObjetivo.setDateIn(datoObjetivoDTO.getDateIn());
            datoObjetivo.setDateUpdate(datoObjetivoDTO.getDateUpdate());
            datoObjetivo.setMagnitud((datoObjetivoDTO.getMagnitud() != null)
                ? datoObjetivoDTO.getMagnitud() : null);
            datoObjetivo.setNombre((datoObjetivoDTO.getNombre() != null)
                ? datoObjetivoDTO.getNombre() : null);
            datoObjetivo.setPrioridad((datoObjetivoDTO.getPrioridad() != null)
                ? datoObjetivoDTO.getPrioridad() : null);
            datoObjetivo.setTipo((datoObjetivoDTO.getTipo() != null)
                ? datoObjetivoDTO.getTipo() : null);

            Objetivo objetivo = new Objetivo();

            if (datoObjetivoDTO.getIdObjetivo_Objetivo() != null) {
                objetivo = logicObjetivo1.getObjetivo(datoObjetivoDTO.getIdObjetivo_Objetivo());
            }

            if (objetivo != null) {
                datoObjetivo.setObjetivo(objetivo);
            }

            return datoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<DatoObjetivoDTO> listDatoObjetivoToListDatoObjetivoDTO(
        List<DatoObjetivo> listDatoObjetivo) throws Exception {
        try {
            List<DatoObjetivoDTO> datoObjetivoDTOs = new ArrayList<DatoObjetivoDTO>();

            for (DatoObjetivo datoObjetivo : listDatoObjetivo) {
                DatoObjetivoDTO datoObjetivoDTO = datoObjetivoToDatoObjetivoDTO(datoObjetivo);

                datoObjetivoDTOs.add(datoObjetivoDTO);
            }

            return datoObjetivoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<DatoObjetivo> listDatoObjetivoDTOToListDatoObjetivo(
        List<DatoObjetivoDTO> listDatoObjetivoDTO) throws Exception {
        try {
            List<DatoObjetivo> listDatoObjetivo = new ArrayList<DatoObjetivo>();

            for (DatoObjetivoDTO datoObjetivoDTO : listDatoObjetivoDTO) {
                DatoObjetivo datoObjetivo = datoObjetivoDTOToDatoObjetivo(datoObjetivoDTO);

                listDatoObjetivo.add(datoObjetivo);
            }

            return listDatoObjetivo;
        } catch (Exception e) {
            throw e;
        }
    }
}
