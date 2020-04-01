package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IObjetivoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;
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
@RequestMapping("/objetivo")
public class ObjetivoRestController {
    private static final Logger log = LoggerFactory.getLogger(ObjetivoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IObjetivoMapper objetivoMapper;

    @PostMapping(value = "/saveObjetivo")
    public void saveObjetivo(@RequestBody
    ObjetivoDTO objetivoDTO) throws Exception {
        try {
            Objetivo objetivo = objetivoMapper.objetivoDTOToObjetivo(objetivoDTO);

            businessDelegatorView.saveObjetivo(objetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteObjetivo/{idObjetivo}")
    public void deleteObjetivo(@PathVariable("idObjetivo")
    Integer idObjetivo) throws Exception {
        try {
            Objetivo objetivo = businessDelegatorView.getObjetivo(idObjetivo);

            businessDelegatorView.deleteObjetivo(objetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateObjetivo/")
    public void updateObjetivo(@RequestBody
    ObjetivoDTO objetivoDTO) throws Exception {
        try {
            Objetivo objetivo = objetivoMapper.objetivoDTOToObjetivo(objetivoDTO);

            businessDelegatorView.updateObjetivo(objetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataObjetivo")
    public List<ObjetivoDTO> getDataObjetivo() throws Exception {
        try {
            return businessDelegatorView.getDataObjetivo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getObjetivo/{idObjetivo}")
    public ObjetivoDTO getObjetivo(
        @PathVariable("idObjetivo")
    Integer idObjetivo) throws Exception {
        try {
            Objetivo objetivo = businessDelegatorView.getObjetivo(idObjetivo);

            return objetivoMapper.objetivoToObjetivoDTO(objetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
