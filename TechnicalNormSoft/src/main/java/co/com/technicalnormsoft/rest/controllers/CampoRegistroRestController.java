package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.ICampoRegistroMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;
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
@RequestMapping("/campoRegistro")
public class CampoRegistroRestController {
    private static final Logger log = LoggerFactory.getLogger(CampoRegistroRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICampoRegistroMapper campoRegistroMapper;

    @PostMapping(value = "/saveCampoRegistro")
    public void saveCampoRegistro(@RequestBody
    CampoRegistroDTO campoRegistroDTO) throws Exception {
        try {
            CampoRegistro campoRegistro = campoRegistroMapper.campoRegistroDTOToCampoRegistro(campoRegistroDTO);

            businessDelegatorView.saveCampoRegistro(campoRegistro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCampoRegistro/{idCampoRegistro}")
    public void deleteCampoRegistro(
        @PathVariable("idCampoRegistro")
    Integer idCampoRegistro) throws Exception {
        try {
            CampoRegistro campoRegistro = businessDelegatorView.getCampoRegistro(idCampoRegistro);

            businessDelegatorView.deleteCampoRegistro(campoRegistro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCampoRegistro/")
    public void updateCampoRegistro(
        @RequestBody
    CampoRegistroDTO campoRegistroDTO) throws Exception {
        try {
            CampoRegistro campoRegistro = campoRegistroMapper.campoRegistroDTOToCampoRegistro(campoRegistroDTO);

            businessDelegatorView.updateCampoRegistro(campoRegistro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCampoRegistro")
    public List<CampoRegistroDTO> getDataCampoRegistro()
        throws Exception {
        try {
            return businessDelegatorView.getDataCampoRegistro();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCampoRegistro/{idCampoRegistro}")
    public CampoRegistroDTO getCampoRegistro(
        @PathVariable("idCampoRegistro")
    Integer idCampoRegistro) throws Exception {
        try {
            CampoRegistro campoRegistro = businessDelegatorView.getCampoRegistro(idCampoRegistro);

            return campoRegistroMapper.campoRegistroToCampoRegistroDTO(campoRegistro);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
