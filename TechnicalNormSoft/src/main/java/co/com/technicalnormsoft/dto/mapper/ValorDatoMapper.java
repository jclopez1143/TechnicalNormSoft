package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.ValorDato;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;

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
public class ValorDatoMapper implements IValorDatoMapper {
    private static final Logger log = LoggerFactory.getLogger(ValorDatoMapper.class);

    /**
    * Logic injected by Spring that manages DatoObjetivo entities
    *
    */
    @Autowired
    IDatoObjetivoLogic logicDatoObjetivo1;

    /**
    * Logic injected by Spring that manages EstablecimientoObjetivo entities
    *
    */
    @Autowired
    IEstablecimientoObjetivoLogic logicEstablecimientoObjetivo2;

    @Transactional(readOnly = true)
    public ValorDatoDTO valorDatoToValorDatoDTO(ValorDato valorDato)
        throws Exception {
        try {
            ValorDatoDTO valorDatoDTO = new ValorDatoDTO();

            valorDatoDTO.setIdValorDato(valorDato.getIdValorDato());
            valorDatoDTO.setDateIn(valorDato.getDateIn());
            valorDatoDTO.setDateUpdate(valorDato.getDateUpdate());
            valorDatoDTO.setValor((valorDato.getValor() != null)
                ? valorDato.getValor() : null);
            valorDatoDTO.setIdDatoObjetivo_DatoObjetivo((valorDato.getDatoObjetivo()
                                                                  .getIdDatoObjetivo() != null)
                ? valorDato.getDatoObjetivo().getIdDatoObjetivo() : null);
            valorDatoDTO.setEstablecimientoObjetivoId_EstablecimientoObjetivo((valorDato.getEstablecimientoObjetivo()
                                                                                        .getEstablecimientoObjetivoId() != null)
                ? valorDato.getEstablecimientoObjetivo()
                           .getEstablecimientoObjetivoId() : null);

            return valorDatoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ValorDato valorDatoDTOToValorDato(ValorDatoDTO valorDatoDTO)
        throws Exception {
        try {
            ValorDato valorDato = new ValorDato();

            valorDato.setIdValorDato(valorDatoDTO.getIdValorDato());
            valorDato.setDateIn(valorDatoDTO.getDateIn());
            valorDato.setDateUpdate(valorDatoDTO.getDateUpdate());
            valorDato.setValor((valorDatoDTO.getValor() != null)
                ? valorDatoDTO.getValor() : null);

            DatoObjetivo datoObjetivo = new DatoObjetivo();

            if (valorDatoDTO.getIdDatoObjetivo_DatoObjetivo() != null) {
                datoObjetivo = logicDatoObjetivo1.getDatoObjetivo(valorDatoDTO.getIdDatoObjetivo_DatoObjetivo());
            }

            if (datoObjetivo != null) {
                valorDato.setDatoObjetivo(datoObjetivo);
            }

            EstablecimientoObjetivo establecimientoObjetivo = new EstablecimientoObjetivo();

            if (valorDatoDTO.getEstablecimientoObjetivoId_EstablecimientoObjetivo() != null) {
                establecimientoObjetivo = logicEstablecimientoObjetivo2.getEstablecimientoObjetivo(valorDatoDTO.getEstablecimientoObjetivoId_EstablecimientoObjetivo());
            }

            if (establecimientoObjetivo != null) {
                valorDato.setEstablecimientoObjetivo(establecimientoObjetivo);
            }

            return valorDato;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ValorDatoDTO> listValorDatoToListValorDatoDTO(
        List<ValorDato> listValorDato) throws Exception {
        try {
            List<ValorDatoDTO> valorDatoDTOs = new ArrayList<ValorDatoDTO>();

            for (ValorDato valorDato : listValorDato) {
                ValorDatoDTO valorDatoDTO = valorDatoToValorDatoDTO(valorDato);

                valorDatoDTOs.add(valorDatoDTO);
            }

            return valorDatoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ValorDato> listValorDatoDTOToListValorDato(
        List<ValorDatoDTO> listValorDatoDTO) throws Exception {
        try {
            List<ValorDato> listValorDato = new ArrayList<ValorDato>();

            for (ValorDatoDTO valorDatoDTO : listValorDatoDTO) {
                ValorDato valorDato = valorDatoDTOToValorDato(valorDatoDTO);

                listValorDato.add(valorDato);
            }

            return listValorDato;
        } catch (Exception e) {
            throw e;
        }
    }
}
