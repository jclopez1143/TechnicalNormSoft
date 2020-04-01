package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.IValorDatoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;
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
@RequestMapping("/valorDato")
public class ValorDatoRestController {
    private static final Logger log = LoggerFactory.getLogger(ValorDatoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IValorDatoMapper valorDatoMapper;

    @PostMapping(value = "/saveValorDato")
    public void saveValorDato(@RequestBody
    ValorDatoDTO valorDatoDTO) throws Exception {
        try {
            ValorDato valorDato = valorDatoMapper.valorDatoDTOToValorDato(valorDatoDTO);

            businessDelegatorView.saveValorDato(valorDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteValorDato/{idValorDato}")
    public void deleteValorDato(@PathVariable("idValorDato")
    Integer idValorDato) throws Exception {
        try {
            ValorDato valorDato = businessDelegatorView.getValorDato(idValorDato);

            businessDelegatorView.deleteValorDato(valorDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateValorDato/")
    public void updateValorDato(@RequestBody
    ValorDatoDTO valorDatoDTO) throws Exception {
        try {
            ValorDato valorDato = valorDatoMapper.valorDatoDTOToValorDato(valorDatoDTO);

            businessDelegatorView.updateValorDato(valorDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataValorDato")
    public List<ValorDatoDTO> getDataValorDato() throws Exception {
        try {
            return businessDelegatorView.getDataValorDato();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getValorDato/{idValorDato}")
    public ValorDatoDTO getValorDato(
        @PathVariable("idValorDato")
    Integer idValorDato) throws Exception {
        try {
            ValorDato valorDato = businessDelegatorView.getValorDato(idValorDato);

            return valorDatoMapper.valorDatoToValorDatoDTO(valorDato);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
