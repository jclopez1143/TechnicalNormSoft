package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IEstadoProyectoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstadoProyectoDTO;
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
@RequestMapping("/estadoProyecto")
public class EstadoProyectoRestController {
    private static final Logger log = LoggerFactory.getLogger(EstadoProyectoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEstadoProyectoMapper estadoProyectoMapper;

    @PostMapping(value = "/saveEstadoProyecto")
    public void saveEstadoProyecto(
        @RequestBody
    EstadoProyectoDTO estadoProyectoDTO) throws Exception {
        try {
            EstadoProyecto estadoProyecto = estadoProyectoMapper.estadoProyectoDTOToEstadoProyecto(estadoProyectoDTO);

            businessDelegatorView.saveEstadoProyecto(estadoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEstadoProyecto/{idEstadoProyecto}")
    public void deleteEstadoProyecto(
        @PathVariable("idEstadoProyecto")
    Integer idEstadoProyecto) throws Exception {
        try {
            EstadoProyecto estadoProyecto = businessDelegatorView.getEstadoProyecto(idEstadoProyecto);

            businessDelegatorView.deleteEstadoProyecto(estadoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEstadoProyecto/")
    public void updateEstadoProyecto(
        @RequestBody
    EstadoProyectoDTO estadoProyectoDTO) throws Exception {
        try {
            EstadoProyecto estadoProyecto = estadoProyectoMapper.estadoProyectoDTOToEstadoProyecto(estadoProyectoDTO);

            businessDelegatorView.updateEstadoProyecto(estadoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEstadoProyecto")
    public List<EstadoProyectoDTO> getDataEstadoProyecto()
        throws Exception {
        try {
            return businessDelegatorView.getDataEstadoProyecto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEstadoProyecto/{idEstadoProyecto}")
    public EstadoProyectoDTO getEstadoProyecto(
        @PathVariable("idEstadoProyecto")
    Integer idEstadoProyecto) throws Exception {
        try {
            EstadoProyecto estadoProyecto = businessDelegatorView.getEstadoProyecto(idEstadoProyecto);

            return estadoProyectoMapper.estadoProyectoToEstadoProyectoDTO(estadoProyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
