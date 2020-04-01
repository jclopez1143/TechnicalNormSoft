package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IMedallaMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.MedallaDTO;
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
@RequestMapping("/medalla")
public class MedallaRestController {
    private static final Logger log = LoggerFactory.getLogger(MedallaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IMedallaMapper medallaMapper;

    @PostMapping(value = "/saveMedalla")
    public void saveMedalla(@RequestBody
    MedallaDTO medallaDTO) throws Exception {
        try {
            Medalla medalla = medallaMapper.medallaDTOToMedalla(medallaDTO);

            businessDelegatorView.saveMedalla(medalla);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteMedalla/{idMedalla}")
    public void deleteMedalla(@PathVariable("idMedalla")
    Integer idMedalla) throws Exception {
        try {
            Medalla medalla = businessDelegatorView.getMedalla(idMedalla);

            businessDelegatorView.deleteMedalla(medalla);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateMedalla/")
    public void updateMedalla(@RequestBody
    MedallaDTO medallaDTO) throws Exception {
        try {
            Medalla medalla = medallaMapper.medallaDTOToMedalla(medallaDTO);

            businessDelegatorView.updateMedalla(medalla);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataMedalla")
    public List<MedallaDTO> getDataMedalla() throws Exception {
        try {
            return businessDelegatorView.getDataMedalla();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getMedalla/{idMedalla}")
    public MedallaDTO getMedalla(@PathVariable("idMedalla")
    Integer idMedalla) throws Exception {
        try {
            Medalla medalla = businessDelegatorView.getMedalla(idMedalla);

            return medallaMapper.medallaToMedallaDTO(medalla);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
