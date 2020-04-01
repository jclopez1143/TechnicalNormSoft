package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IDatoObjetivoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;
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
@RequestMapping("/datoObjetivo")
public class DatoObjetivoRestController {
    private static final Logger log = LoggerFactory.getLogger(DatoObjetivoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IDatoObjetivoMapper datoObjetivoMapper;

    @PostMapping(value = "/saveDatoObjetivo")
    public void saveDatoObjetivo(@RequestBody
    DatoObjetivoDTO datoObjetivoDTO) throws Exception {
        try {
            DatoObjetivo datoObjetivo = datoObjetivoMapper.datoObjetivoDTOToDatoObjetivo(datoObjetivoDTO);

            businessDelegatorView.saveDatoObjetivo(datoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteDatoObjetivo/{idDatoObjetivo}")
    public void deleteDatoObjetivo(
        @PathVariable("idDatoObjetivo")
    Integer idDatoObjetivo) throws Exception {
        try {
            DatoObjetivo datoObjetivo = businessDelegatorView.getDatoObjetivo(idDatoObjetivo);

            businessDelegatorView.deleteDatoObjetivo(datoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateDatoObjetivo/")
    public void updateDatoObjetivo(@RequestBody
    DatoObjetivoDTO datoObjetivoDTO) throws Exception {
        try {
            DatoObjetivo datoObjetivo = datoObjetivoMapper.datoObjetivoDTOToDatoObjetivo(datoObjetivoDTO);

            businessDelegatorView.updateDatoObjetivo(datoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataDatoObjetivo")
    public List<DatoObjetivoDTO> getDataDatoObjetivo()
        throws Exception {
        try {
            return businessDelegatorView.getDataDatoObjetivo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDatoObjetivo/{idDatoObjetivo}")
    public DatoObjetivoDTO getDatoObjetivo(
        @PathVariable("idDatoObjetivo")
    Integer idDatoObjetivo) throws Exception {
        try {
            DatoObjetivo datoObjetivo = businessDelegatorView.getDatoObjetivo(idDatoObjetivo);

            return datoObjetivoMapper.datoObjetivoToDatoObjetivoDTO(datoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
