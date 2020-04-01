package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IEstadoObjetivoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstadoObjetivoDTO;
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
@RequestMapping("/estadoObjetivo")
public class EstadoObjetivoRestController {
    private static final Logger log = LoggerFactory.getLogger(EstadoObjetivoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEstadoObjetivoMapper estadoObjetivoMapper;

    @PostMapping(value = "/saveEstadoObjetivo")
    public void saveEstadoObjetivo(
        @RequestBody
    EstadoObjetivoDTO estadoObjetivoDTO) throws Exception {
        try {
            EstadoObjetivo estadoObjetivo = estadoObjetivoMapper.estadoObjetivoDTOToEstadoObjetivo(estadoObjetivoDTO);

            businessDelegatorView.saveEstadoObjetivo(estadoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEstadoObjetivo/{idEstado}")
    public void deleteEstadoObjetivo(@PathVariable("idEstado")
    Integer idEstado) throws Exception {
        try {
            EstadoObjetivo estadoObjetivo = businessDelegatorView.getEstadoObjetivo(idEstado);

            businessDelegatorView.deleteEstadoObjetivo(estadoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEstadoObjetivo/")
    public void updateEstadoObjetivo(
        @RequestBody
    EstadoObjetivoDTO estadoObjetivoDTO) throws Exception {
        try {
            EstadoObjetivo estadoObjetivo = estadoObjetivoMapper.estadoObjetivoDTOToEstadoObjetivo(estadoObjetivoDTO);

            businessDelegatorView.updateEstadoObjetivo(estadoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEstadoObjetivo")
    public List<EstadoObjetivoDTO> getDataEstadoObjetivo()
        throws Exception {
        try {
            return businessDelegatorView.getDataEstadoObjetivo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEstadoObjetivo/{idEstado}")
    public EstadoObjetivoDTO getEstadoObjetivo(
        @PathVariable("idEstado")
    Integer idEstado) throws Exception {
        try {
            EstadoObjetivo estadoObjetivo = businessDelegatorView.getEstadoObjetivo(idEstado);

            return estadoObjetivoMapper.estadoObjetivoToEstadoObjetivoDTO(estadoObjetivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
