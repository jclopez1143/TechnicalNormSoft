package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.INormaMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.NormaDTO;
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
@RequestMapping("/norma")
public class NormaRestController {
    private static final Logger log = LoggerFactory.getLogger(NormaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private INormaMapper normaMapper;

    @PostMapping(value = "/saveNorma")
    public void saveNorma(@RequestBody
    NormaDTO normaDTO) throws Exception {
        try {
            Norma norma = normaMapper.normaDTOToNorma(normaDTO);

            businessDelegatorView.saveNorma(norma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteNorma/{idNorma}")
    public void deleteNorma(@PathVariable("idNorma")
    Integer idNorma) throws Exception {
        try {
            Norma norma = businessDelegatorView.getNorma(idNorma);

            businessDelegatorView.deleteNorma(norma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateNorma/")
    public void updateNorma(@RequestBody
    NormaDTO normaDTO) throws Exception {
        try {
            Norma norma = normaMapper.normaDTOToNorma(normaDTO);

            businessDelegatorView.updateNorma(norma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataNorma")
    public List<NormaDTO> getDataNorma() throws Exception {
        try {
            return businessDelegatorView.getDataNorma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getNorma/{idNorma}")
    public NormaDTO getNorma(@PathVariable("idNorma")
    Integer idNorma) throws Exception {
        try {
            Norma norma = businessDelegatorView.getNorma(idNorma);

            return normaMapper.normaToNormaDTO(norma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
