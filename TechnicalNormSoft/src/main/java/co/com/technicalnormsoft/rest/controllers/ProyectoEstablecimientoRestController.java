package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IProyectoEstablecimientoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;
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
@RequestMapping("/proyectoEstablecimiento")
public class ProyectoEstablecimientoRestController {
    private static final Logger log = LoggerFactory.getLogger(ProyectoEstablecimientoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IProyectoEstablecimientoMapper proyectoEstablecimientoMapper;

    @PostMapping(value = "/saveProyectoEstablecimiento")
    public void saveProyectoEstablecimiento(
        @RequestBody
    ProyectoEstablecimientoDTO proyectoEstablecimientoDTO)
        throws Exception {
        try {
            ProyectoEstablecimiento proyectoEstablecimiento = proyectoEstablecimientoMapper.proyectoEstablecimientoDTOToProyectoEstablecimiento(proyectoEstablecimientoDTO);

            businessDelegatorView.saveProyectoEstablecimiento(proyectoEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteProyectoEstablecimiento/{idProyectoEstablecimiento}")
    public void deleteProyectoEstablecimiento(
        @PathVariable("idProyectoEstablecimiento")
    Integer idProyectoEstablecimiento) throws Exception {
        try {
            ProyectoEstablecimiento proyectoEstablecimiento = businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento);

            businessDelegatorView.deleteProyectoEstablecimiento(proyectoEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateProyectoEstablecimiento/")
    public void updateProyectoEstablecimiento(
        @RequestBody
    ProyectoEstablecimientoDTO proyectoEstablecimientoDTO)
        throws Exception {
        try {
            ProyectoEstablecimiento proyectoEstablecimiento = proyectoEstablecimientoMapper.proyectoEstablecimientoDTOToProyectoEstablecimiento(proyectoEstablecimientoDTO);

            businessDelegatorView.updateProyectoEstablecimiento(proyectoEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataProyectoEstablecimiento")
    public List<ProyectoEstablecimientoDTO> getDataProyectoEstablecimiento()
        throws Exception {
        try {
            return businessDelegatorView.getDataProyectoEstablecimiento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getProyectoEstablecimiento/{idProyectoEstablecimiento}")
    public ProyectoEstablecimientoDTO getProyectoEstablecimiento(
        @PathVariable("idProyectoEstablecimiento")
    Integer idProyectoEstablecimiento) throws Exception {
        try {
            ProyectoEstablecimiento proyectoEstablecimiento = businessDelegatorView.getProyectoEstablecimiento(idProyectoEstablecimiento);

            return proyectoEstablecimientoMapper.proyectoEstablecimientoToProyectoEstablecimientoDTO(proyectoEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
