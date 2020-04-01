package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IValorCampoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;
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
@RequestMapping("/valorCampo")
public class ValorCampoRestController {
    private static final Logger log = LoggerFactory.getLogger(ValorCampoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IValorCampoMapper valorCampoMapper;

    @PostMapping(value = "/saveValorCampo")
    public void saveValorCampo(@RequestBody
    ValorCampoDTO valorCampoDTO) throws Exception {
        try {
            ValorCampo valorCampo = valorCampoMapper.valorCampoDTOToValorCampo(valorCampoDTO);

            businessDelegatorView.saveValorCampo(valorCampo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteValorCampo/{idValorCampo}")
    public void deleteValorCampo(
        @PathVariable("idValorCampo")
    Integer idValorCampo) throws Exception {
        try {
            ValorCampo valorCampo = businessDelegatorView.getValorCampo(idValorCampo);

            businessDelegatorView.deleteValorCampo(valorCampo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateValorCampo/")
    public void updateValorCampo(@RequestBody
    ValorCampoDTO valorCampoDTO) throws Exception {
        try {
            ValorCampo valorCampo = valorCampoMapper.valorCampoDTOToValorCampo(valorCampoDTO);

            businessDelegatorView.updateValorCampo(valorCampo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataValorCampo")
    public List<ValorCampoDTO> getDataValorCampo() throws Exception {
        try {
            return businessDelegatorView.getDataValorCampo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getValorCampo/{idValorCampo}")
    public ValorCampoDTO getValorCampo(
        @PathVariable("idValorCampo")
    Integer idValorCampo) throws Exception {
        try {
            ValorCampo valorCampo = businessDelegatorView.getValorCampo(idValorCampo);

            return valorCampoMapper.valorCampoToValorCampoDTO(valorCampo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
