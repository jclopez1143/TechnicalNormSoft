package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;

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
public class CampoRegistroMapper implements ICampoRegistroMapper {
    private static final Logger log = LoggerFactory.getLogger(CampoRegistroMapper.class);

    /**
    * Logic injected by Spring that manages DatoObjetivo entities
    *
    */
    @Autowired
    IDatoObjetivoLogic logicDatoObjetivo1;

    @Transactional(readOnly = true)
    public CampoRegistroDTO campoRegistroToCampoRegistroDTO(
        CampoRegistro campoRegistro) throws Exception {
        try {
            CampoRegistroDTO campoRegistroDTO = new CampoRegistroDTO();

            campoRegistroDTO.setIdCampoRegistro(campoRegistro.getIdCampoRegistro());
            campoRegistroDTO.setDateIn(campoRegistro.getDateIn());
            campoRegistroDTO.setDateUpdate(campoRegistro.getDateUpdate());
            campoRegistroDTO.setMagnitud((campoRegistro.getMagnitud() != null)
                ? campoRegistro.getMagnitud() : null);
            campoRegistroDTO.setNombre((campoRegistro.getNombre() != null)
                ? campoRegistro.getNombre() : null);
            campoRegistroDTO.setPrioridad((campoRegistro.getPrioridad() != null)
                ? campoRegistro.getPrioridad() : null);
            campoRegistroDTO.setTipo((campoRegistro.getTipo() != null)
                ? campoRegistro.getTipo() : null);
            campoRegistroDTO.setIdDatoObjetivo_DatoObjetivo((campoRegistro.getDatoObjetivo()
                                                                          .getIdDatoObjetivo() != null)
                ? campoRegistro.getDatoObjetivo().getIdDatoObjetivo() : null);

            return campoRegistroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public CampoRegistro campoRegistroDTOToCampoRegistro(
        CampoRegistroDTO campoRegistroDTO) throws Exception {
        try {
            CampoRegistro campoRegistro = new CampoRegistro();

            campoRegistro.setIdCampoRegistro(campoRegistroDTO.getIdCampoRegistro());
            campoRegistro.setDateIn(campoRegistroDTO.getDateIn());
            campoRegistro.setDateUpdate(campoRegistroDTO.getDateUpdate());
            campoRegistro.setMagnitud((campoRegistroDTO.getMagnitud() != null)
                ? campoRegistroDTO.getMagnitud() : null);
            campoRegistro.setNombre((campoRegistroDTO.getNombre() != null)
                ? campoRegistroDTO.getNombre() : null);
            campoRegistro.setPrioridad((campoRegistroDTO.getPrioridad() != null)
                ? campoRegistroDTO.getPrioridad() : null);
            campoRegistro.setTipo((campoRegistroDTO.getTipo() != null)
                ? campoRegistroDTO.getTipo() : null);

            DatoObjetivo datoObjetivo = new DatoObjetivo();

            if (campoRegistroDTO.getIdDatoObjetivo_DatoObjetivo() != null) {
                datoObjetivo = logicDatoObjetivo1.getDatoObjetivo(campoRegistroDTO.getIdDatoObjetivo_DatoObjetivo());
            }

            if (datoObjetivo != null) {
                campoRegistro.setDatoObjetivo(datoObjetivo);
            }

            return campoRegistro;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CampoRegistroDTO> listCampoRegistroToListCampoRegistroDTO(
        List<CampoRegistro> listCampoRegistro) throws Exception {
        try {
            List<CampoRegistroDTO> campoRegistroDTOs = new ArrayList<CampoRegistroDTO>();

            for (CampoRegistro campoRegistro : listCampoRegistro) {
                CampoRegistroDTO campoRegistroDTO = campoRegistroToCampoRegistroDTO(campoRegistro);

                campoRegistroDTOs.add(campoRegistroDTO);
            }

            return campoRegistroDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CampoRegistro> listCampoRegistroDTOToListCampoRegistro(
        List<CampoRegistroDTO> listCampoRegistroDTO) throws Exception {
        try {
            List<CampoRegistro> listCampoRegistro = new ArrayList<CampoRegistro>();

            for (CampoRegistroDTO campoRegistroDTO : listCampoRegistroDTO) {
                CampoRegistro campoRegistro = campoRegistroDTOToCampoRegistro(campoRegistroDTO);

                listCampoRegistro.add(campoRegistro);
            }

            return listCampoRegistro;
        } catch (Exception e) {
            throw e;
        }
    }
}
