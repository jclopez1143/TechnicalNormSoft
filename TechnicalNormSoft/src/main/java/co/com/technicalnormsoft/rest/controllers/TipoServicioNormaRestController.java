package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.ITipoServicioNormaMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;
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
@RequestMapping("/tipoServicioNorma")
public class TipoServicioNormaRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioNormaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipoServicioNormaMapper tipoServicioNormaMapper;

    @PostMapping(value = "/saveTipoServicioNorma")
    public void saveTipoServicioNorma(
        @RequestBody
    TipoServicioNormaDTO tipoServicioNormaDTO) throws Exception {
        try {
            TipoServicioNorma tipoServicioNorma = tipoServicioNormaMapper.tipoServicioNormaDTOToTipoServicioNorma(tipoServicioNormaDTO);

            businessDelegatorView.saveTipoServicioNorma(tipoServicioNorma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoServicioNorma/{idTipoServicioNorma}")
    public void deleteTipoServicioNorma(
        @PathVariable("idTipoServicioNorma")
    Integer idTipoServicioNorma) throws Exception {
        try {
            TipoServicioNorma tipoServicioNorma = businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma);

            businessDelegatorView.deleteTipoServicioNorma(tipoServicioNorma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoServicioNorma/")
    public void updateTipoServicioNorma(
        @RequestBody
    TipoServicioNormaDTO tipoServicioNormaDTO) throws Exception {
        try {
            TipoServicioNorma tipoServicioNorma = tipoServicioNormaMapper.tipoServicioNormaDTOToTipoServicioNorma(tipoServicioNormaDTO);

            businessDelegatorView.updateTipoServicioNorma(tipoServicioNorma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoServicioNorma")
    public List<TipoServicioNormaDTO> getDataTipoServicioNorma()
        throws Exception {
        try {
            return businessDelegatorView.getDataTipoServicioNorma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoServicioNorma/{idTipoServicioNorma}")
    public TipoServicioNormaDTO getTipoServicioNorma(
        @PathVariable("idTipoServicioNorma")
    Integer idTipoServicioNorma) throws Exception {
        try {
            TipoServicioNorma tipoServicioNorma = businessDelegatorView.getTipoServicioNorma(idTipoServicioNorma);

            return tipoServicioNormaMapper.tipoServicioNormaToTipoServicioNormaDTO(tipoServicioNorma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
