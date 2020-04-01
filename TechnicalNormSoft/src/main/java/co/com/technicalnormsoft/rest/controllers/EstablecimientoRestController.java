package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IEstablecimientoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;
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
@RequestMapping("/establecimiento")
public class EstablecimientoRestController {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEstablecimientoMapper establecimientoMapper;

    @PostMapping(value = "/saveEstablecimiento")
    public void saveEstablecimiento(
        @RequestBody
    EstablecimientoDTO establecimientoDTO) throws Exception {
        try {
            Establecimiento establecimiento = establecimientoMapper.establecimientoDTOToEstablecimiento(establecimientoDTO);

            businessDelegatorView.saveEstablecimiento(establecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEstablecimiento/{idEstablecimiento}")
    public void deleteEstablecimiento(
        @PathVariable("idEstablecimiento")
    Integer idEstablecimiento) throws Exception {
        try {
            Establecimiento establecimiento = businessDelegatorView.getEstablecimiento(idEstablecimiento);

            businessDelegatorView.deleteEstablecimiento(establecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEstablecimiento/")
    public void updateEstablecimiento(
        @RequestBody
    EstablecimientoDTO establecimientoDTO) throws Exception {
        try {
            Establecimiento establecimiento = establecimientoMapper.establecimientoDTOToEstablecimiento(establecimientoDTO);

            businessDelegatorView.updateEstablecimiento(establecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEstablecimiento")
    public List<EstablecimientoDTO> getDataEstablecimiento()
        throws Exception {
        try {
            return businessDelegatorView.getDataEstablecimiento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEstablecimiento/{idEstablecimiento}")
    public EstablecimientoDTO getEstablecimiento(
        @PathVariable("idEstablecimiento")
    Integer idEstablecimiento) throws Exception {
        try {
            Establecimiento establecimiento = businessDelegatorView.getEstablecimiento(idEstablecimiento);

            return establecimientoMapper.establecimientoToEstablecimientoDTO(establecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
