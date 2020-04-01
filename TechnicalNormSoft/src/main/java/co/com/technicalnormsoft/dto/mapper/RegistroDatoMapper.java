package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.RegistroDato;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;

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
*/
@Component
@Scope("singleton")
public class RegistroDatoMapper implements IRegistroDatoMapper {
    private static final Logger log = LoggerFactory.getLogger(RegistroDatoMapper.class);

    @Autowired
    IEstablecimientoObjetivoLogic logicEstablecimientoObjetivo1;
    
    @Autowired
    IDatoObjetivoLogic logicDatoObjetivo2;

    @Transactional(readOnly = true)
    public RegistroDatoDTO registroDatoToRegistroDatoDTO(
        RegistroDato registroDato) throws Exception {
        try {
            RegistroDatoDTO registroDatoDTO = new RegistroDatoDTO();

            registroDatoDTO.setIdRegistroDato(registroDato.getIdRegistroDato());
            registroDatoDTO.setDateIn(registroDato.getDateIn());
            registroDatoDTO.setDateUpdate(registroDato.getDateUpdate());
            registroDatoDTO.setEstablecimientoObjetivoId_EstablecimientoObjetivo((registroDato.getEstablecimientoObjetivo()
                                                                                              .getEstablecimientoObjetivoId() != null)
                ? registroDato.getEstablecimientoObjetivo()
                              .getEstablecimientoObjetivoId() : null);
            registroDatoDTO.setIdDatoObjetivo_DatoObjetivo((registroDato.getDatoObjetivo().getIdDatoObjetivo() != null)
            		? registroDato.getDatoObjetivo().getIdDatoObjetivo() : null);

            return registroDatoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RegistroDato registroDatoDTOToRegistroDato(
        RegistroDatoDTO registroDatoDTO) throws Exception {
        try {
            RegistroDato registroDato = new RegistroDato();

            registroDato.setIdRegistroDato(registroDatoDTO.getIdRegistroDato());
            registroDato.setDateIn(registroDatoDTO.getDateIn());
            registroDato.setDateUpdate(registroDatoDTO.getDateUpdate());

            EstablecimientoObjetivo establecimientoObjetivo = new EstablecimientoObjetivo();

            if (registroDatoDTO.getEstablecimientoObjetivoId_EstablecimientoObjetivo() != null) {
                establecimientoObjetivo = logicEstablecimientoObjetivo1.getEstablecimientoObjetivo(registroDatoDTO.getEstablecimientoObjetivoId_EstablecimientoObjetivo());
            }
            

            if (establecimientoObjetivo != null) {
                registroDato.setEstablecimientoObjetivo(establecimientoObjetivo);
            }
            
            DatoObjetivo datoObjetivo = new DatoObjetivo();
            
            if (registroDatoDTO.getIdDatoObjetivo_DatoObjetivo() != null) {
            	datoObjetivo = logicDatoObjetivo2.getDatoObjetivo(registroDatoDTO.getIdDatoObjetivo_DatoObjetivo());
            }
            
            if (datoObjetivo != null) {
            	registroDato.setDatoObjetivo(datoObjetivo);
            }

            return registroDato;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegistroDatoDTO> listRegistroDatoToListRegistroDatoDTO(
        List<RegistroDato> listRegistroDato) throws Exception {
        try {
            List<RegistroDatoDTO> registroDatoDTOs = new ArrayList<RegistroDatoDTO>();

            for (RegistroDato registroDato : listRegistroDato) {
                RegistroDatoDTO registroDatoDTO = registroDatoToRegistroDatoDTO(registroDato);

                registroDatoDTOs.add(registroDatoDTO);
            }

            return registroDatoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RegistroDato> listRegistroDatoDTOToListRegistroDato(
        List<RegistroDatoDTO> listRegistroDatoDTO) throws Exception {
        try {
            List<RegistroDato> listRegistroDato = new ArrayList<RegistroDato>();

            for (RegistroDatoDTO registroDatoDTO : listRegistroDatoDTO) {
                RegistroDato registroDato = registroDatoDTOToRegistroDato(registroDatoDTO);

                listRegistroDato.add(registroDato);
            }

            return listRegistroDato;
        } catch (Exception e) {
            throw e;
        }
    }
}
