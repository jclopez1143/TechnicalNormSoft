package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IRegistroDatoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;
import co.com.technicalnormsoft.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/registroDato")
public class RegistroDatoRestController {
    private static final Logger log = LoggerFactory.getLogger(RegistroDatoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IRegistroDatoMapper registroDatoMapper;

    @PostMapping(value = "/saveRegistroDato")
    public void saveRegistroDato(@RequestBody
    RegistroDatoDTO registroDatoDTO) throws Exception {
        try {
            RegistroDato registroDato = registroDatoMapper.registroDatoDTOToRegistroDato(registroDatoDTO);

            businessDelegatorView.saveRegistroDato(registroDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRegistroDato/{idRegistroDato}")
    public void deleteRegistroDato(
        @PathVariable("idRegistroDato")
    Integer idRegistroDato) throws Exception {
        try {
            RegistroDato registroDato = businessDelegatorView.getRegistroDato(idRegistroDato);

            businessDelegatorView.deleteRegistroDato(registroDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRegistroDato/")
    public void updateRegistroDato(@RequestBody
    RegistroDatoDTO registroDatoDTO) throws Exception {
        try {
            RegistroDato registroDato = registroDatoMapper.registroDatoDTOToRegistroDato(registroDatoDTO);

            businessDelegatorView.updateRegistroDato(registroDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRegistroDato")
    public List<RegistroDatoDTO> getDataRegistroDato()
        throws Exception {
        try {
            return businessDelegatorView.getDataRegistroDato();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRegistroDato/{idRegistroDato}")
    public RegistroDatoDTO getRegistroDato(
        @PathVariable("idRegistroDato")
    Integer idRegistroDato) throws Exception {
        try {
            RegistroDato registroDato = businessDelegatorView.getRegistroDato(idRegistroDato);

            return registroDatoMapper.registroDatoToRegistroDatoDTO(registroDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
