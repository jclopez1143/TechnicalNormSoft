package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IRequisitoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;
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
@RequestMapping("/requisito")
public class RequisitoRestController {
    private static final Logger log = LoggerFactory.getLogger(RequisitoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IRequisitoMapper requisitoMapper;

    @PostMapping(value = "/saveRequisito")
    public void saveRequisito(@RequestBody
    RequisitoDTO requisitoDTO) throws Exception {
        try {
            Requisito requisito = requisitoMapper.requisitoDTOToRequisito(requisitoDTO);

            businessDelegatorView.saveRequisito(requisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRequisito/{idRequisito}")
    public void deleteRequisito(@PathVariable("idRequisito")
    Integer idRequisito) throws Exception {
        try {
            Requisito requisito = businessDelegatorView.getRequisito(idRequisito);

            businessDelegatorView.deleteRequisito(requisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRequisito/")
    public void updateRequisito(@RequestBody
    RequisitoDTO requisitoDTO) throws Exception {
        try {
            Requisito requisito = requisitoMapper.requisitoDTOToRequisito(requisitoDTO);

            businessDelegatorView.updateRequisito(requisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRequisito")
    public List<RequisitoDTO> getDataRequisito() throws Exception {
        try {
            return businessDelegatorView.getDataRequisito();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRequisito/{idRequisito}")
    public RequisitoDTO getRequisito(
        @PathVariable("idRequisito")
    Integer idRequisito) throws Exception {
        try {
            Requisito requisito = businessDelegatorView.getRequisito(idRequisito);

            return requisitoMapper.requisitoToRequisitoDTO(requisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
