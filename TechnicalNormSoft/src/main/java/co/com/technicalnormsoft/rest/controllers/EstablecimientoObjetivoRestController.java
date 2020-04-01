package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IEstablecimientoObjetivoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;
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
@RequestMapping("/establecimientoObjetivo")
public class EstablecimientoObjetivoRestController {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoObjetivoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEstablecimientoObjetivoMapper establecimientoObjetivoMapper;

    @PostMapping(value = "/saveEstablecimientoObjetivo")
    public void saveEstablecimientoObjetivo(
        @RequestBody
    EstablecimientoObjetivoDTO establecimientoObjetivoDTO)
        throws Exception {
        try {
            EstablecimientoObjetivo establecimientoObjetivo = establecimientoObjetivoMapper.establecimientoObjetivoDTOToEstablecimientoObjetivo(establecimientoObjetivoDTO);

            businessDelegatorView.saveEstablecimientoObjetivo(establecimientoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEstablecimientoObjetivo/{establecimientoObjetivoId}")
    public void deleteEstablecimientoObjetivo(
        @PathVariable("establecimientoObjetivoId")
    Integer establecimientoObjetivoId) throws Exception {
        try {
            EstablecimientoObjetivo establecimientoObjetivo = businessDelegatorView.getEstablecimientoObjetivo(establecimientoObjetivoId);

            businessDelegatorView.deleteEstablecimientoObjetivo(establecimientoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEstablecimientoObjetivo/")
    public void updateEstablecimientoObjetivo(
        @RequestBody
    EstablecimientoObjetivoDTO establecimientoObjetivoDTO)
        throws Exception {
        try {
            EstablecimientoObjetivo establecimientoObjetivo = establecimientoObjetivoMapper.establecimientoObjetivoDTOToEstablecimientoObjetivo(establecimientoObjetivoDTO);

            businessDelegatorView.updateEstablecimientoObjetivo(establecimientoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEstablecimientoObjetivo")
    public List<EstablecimientoObjetivoDTO> getDataEstablecimientoObjetivo()
        throws Exception {
        try {
            return businessDelegatorView.getDataEstablecimientoObjetivo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEstablecimientoObjetivo/{establecimientoObjetivoId}")
    public EstablecimientoObjetivoDTO getEstablecimientoObjetivo(
        @PathVariable("establecimientoObjetivoId")
    Integer establecimientoObjetivoId) throws Exception {
        try {
            EstablecimientoObjetivo establecimientoObjetivo = businessDelegatorView.getEstablecimientoObjetivo(establecimientoObjetivoId);

            return establecimientoObjetivoMapper.establecimientoObjetivoToEstablecimientoObjetivoDTO(establecimientoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
