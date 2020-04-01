package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.ValorCampo;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;

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
public class ValorCampoMapper implements IValorCampoMapper {
    private static final Logger log = LoggerFactory.getLogger(ValorCampoMapper.class);

    /**
    * Logic injected by Spring that manages CampoRegistro entities
    *
    */
    @Autowired
    ICampoRegistroLogic logicCampoRegistro1;

    /**
    * Logic injected by Spring that manages RegistroDato entities
    *
    */
    @Autowired
    IRegistroDatoLogic logicRegistroDato2;

    @Transactional(readOnly = true)
    public ValorCampoDTO valorCampoToValorCampoDTO(ValorCampo valorCampo)
        throws Exception {
        try {
            ValorCampoDTO valorCampoDTO = new ValorCampoDTO();

            valorCampoDTO.setIdValorCampo(valorCampo.getIdValorCampo());
            valorCampoDTO.setDateIn(valorCampo.getDateIn());
            valorCampoDTO.setDateUpdate(valorCampo.getDateUpdate());
            valorCampoDTO.setValor((valorCampo.getValor() != null)
                ? valorCampo.getValor() : null);
            valorCampoDTO.setIdCampoRegistro_CampoRegistro((valorCampo.getCampoRegistro()
                                                                      .getIdCampoRegistro() != null)
                ? valorCampo.getCampoRegistro().getIdCampoRegistro() : null);
            valorCampoDTO.setIdRegistroDato_RegistroDato((valorCampo.getRegistroDato()
                                                                    .getIdRegistroDato() != null)
                ? valorCampo.getRegistroDato().getIdRegistroDato() : null);

            return valorCampoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ValorCampo valorCampoDTOToValorCampo(ValorCampoDTO valorCampoDTO)
        throws Exception {
        try {
            ValorCampo valorCampo = new ValorCampo();

            valorCampo.setIdValorCampo(valorCampoDTO.getIdValorCampo());
            valorCampo.setDateIn(valorCampoDTO.getDateIn());
            valorCampo.setDateUpdate(valorCampoDTO.getDateUpdate());
            valorCampo.setValor((valorCampoDTO.getValor() != null)
                ? valorCampoDTO.getValor() : null);

            CampoRegistro campoRegistro = new CampoRegistro();

            if (valorCampoDTO.getIdCampoRegistro_CampoRegistro() != null) {
                campoRegistro = logicCampoRegistro1.getCampoRegistro(valorCampoDTO.getIdCampoRegistro_CampoRegistro());
            }

            if (campoRegistro != null) {
                valorCampo.setCampoRegistro(campoRegistro);
            }

            RegistroDato registroDato = new RegistroDato();

            if (valorCampoDTO.getIdRegistroDato_RegistroDato() != null) {
                registroDato = logicRegistroDato2.getRegistroDato(valorCampoDTO.getIdRegistroDato_RegistroDato());
            }

            if (registroDato != null) {
                valorCampo.setRegistroDato(registroDato);
            }

            return valorCampo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ValorCampoDTO> listValorCampoToListValorCampoDTO(
        List<ValorCampo> listValorCampo) throws Exception {
        try {
            List<ValorCampoDTO> valorCampoDTOs = new ArrayList<ValorCampoDTO>();

            for (ValorCampo valorCampo : listValorCampo) {
                ValorCampoDTO valorCampoDTO = valorCampoToValorCampoDTO(valorCampo);

                valorCampoDTOs.add(valorCampoDTO);
            }

            return valorCampoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ValorCampo> listValorCampoDTOToListValorCampo(
        List<ValorCampoDTO> listValorCampoDTO) throws Exception {
        try {
            List<ValorCampo> listValorCampo = new ArrayList<ValorCampo>();

            for (ValorCampoDTO valorCampoDTO : listValorCampoDTO) {
                ValorCampo valorCampo = valorCampoDTOToValorCampo(valorCampoDTO);

                listValorCampo.add(valorCampo);
            }

            return listValorCampo;
        } catch (Exception e) {
            throw e;
        }
    }
}
