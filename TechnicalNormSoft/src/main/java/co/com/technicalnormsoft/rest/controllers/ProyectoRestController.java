package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IProyectoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;
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
@RequestMapping("/proyecto")
public class ProyectoRestController {
    private static final Logger log = LoggerFactory.getLogger(ProyectoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IProyectoMapper proyectoMapper;

    @PostMapping(value = "/saveProyecto")
    public void saveProyecto(@RequestBody
    ProyectoDTO proyectoDTO) throws Exception {
        try {
            Proyecto proyecto = proyectoMapper.proyectoDTOToProyecto(proyectoDTO);

            businessDelegatorView.saveProyecto(proyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteProyecto/{idProyecto}")
    public void deleteProyecto(@PathVariable("idProyecto")
    Integer idProyecto) throws Exception {
        try {
            Proyecto proyecto = businessDelegatorView.getProyecto(idProyecto);

            businessDelegatorView.deleteProyecto(proyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateProyecto/")
    public void updateProyecto(@RequestBody
    ProyectoDTO proyectoDTO) throws Exception {
        try {
            Proyecto proyecto = proyectoMapper.proyectoDTOToProyecto(proyectoDTO);

            businessDelegatorView.updateProyecto(proyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataProyecto")
    public List<ProyectoDTO> getDataProyecto() throws Exception {
        try {
            return businessDelegatorView.getDataProyecto();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getProyecto/{idProyecto}")
    public ProyectoDTO getProyecto(
        @PathVariable("idProyecto")
    Integer idProyecto) throws Exception {
        try {
            Proyecto proyecto = businessDelegatorView.getProyecto(idProyecto);

            return proyectoMapper.proyectoToProyectoDTO(proyecto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
