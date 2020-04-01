package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IMedallaEstablecimientoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;
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
@RequestMapping("/medallaEstablecimiento")
public class MedallaEstablecimientoRestController {
    private static final Logger log = LoggerFactory.getLogger(MedallaEstablecimientoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IMedallaEstablecimientoMapper medallaEstablecimientoMapper;

    @PostMapping(value = "/saveMedallaEstablecimiento")
    public void saveMedallaEstablecimiento(
        @RequestBody
    MedallaEstablecimientoDTO medallaEstablecimientoDTO)
        throws Exception {
        try {
            MedallaEstablecimiento medallaEstablecimiento = medallaEstablecimientoMapper.medallaEstablecimientoDTOToMedallaEstablecimiento(medallaEstablecimientoDTO);

            businessDelegatorView.saveMedallaEstablecimiento(medallaEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteMedallaEstablecimiento/{idMedallaEstablecimiento}")
    public void deleteMedallaEstablecimiento(
        @PathVariable("idMedallaEstablecimiento")
    Integer idMedallaEstablecimiento) throws Exception {
        try {
            MedallaEstablecimiento medallaEstablecimiento = businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento);

            businessDelegatorView.deleteMedallaEstablecimiento(medallaEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateMedallaEstablecimiento/")
    public void updateMedallaEstablecimiento(
        @RequestBody
    MedallaEstablecimientoDTO medallaEstablecimientoDTO)
        throws Exception {
        try {
            MedallaEstablecimiento medallaEstablecimiento = medallaEstablecimientoMapper.medallaEstablecimientoDTOToMedallaEstablecimiento(medallaEstablecimientoDTO);

            businessDelegatorView.updateMedallaEstablecimiento(medallaEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataMedallaEstablecimiento")
    public List<MedallaEstablecimientoDTO> getDataMedallaEstablecimiento()
        throws Exception {
        try {
            return businessDelegatorView.getDataMedallaEstablecimiento();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getMedallaEstablecimiento/{idMedallaEstablecimiento}")
    public MedallaEstablecimientoDTO getMedallaEstablecimiento(
        @PathVariable("idMedallaEstablecimiento")
    Integer idMedallaEstablecimiento) throws Exception {
        try {
            MedallaEstablecimiento medallaEstablecimiento = businessDelegatorView.getMedallaEstablecimiento(idMedallaEstablecimiento);

            return medallaEstablecimientoMapper.medallaEstablecimientoToMedallaEstablecimientoDTO(medallaEstablecimiento);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
