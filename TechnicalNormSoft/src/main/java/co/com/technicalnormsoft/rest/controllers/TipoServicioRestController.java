package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.ITipoServicioMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;
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
@RequestMapping("/tipoServicio")
public class TipoServicioRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITipoServicioMapper tipoServicioMapper;

    @PostMapping(value = "/saveTipoServicio")
    public void saveTipoServicio(@RequestBody
    TipoServicioDTO tipoServicioDTO) throws Exception {
        try {
            TipoServicio tipoServicio = tipoServicioMapper.tipoServicioDTOToTipoServicio(tipoServicioDTO);

            businessDelegatorView.saveTipoServicio(tipoServicio);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTipoServicio/{idTipoServicio}")
    public void deleteTipoServicio(
        @PathVariable("idTipoServicio")
    Integer idTipoServicio) throws Exception {
        try {
            TipoServicio tipoServicio = businessDelegatorView.getTipoServicio(idTipoServicio);

            businessDelegatorView.deleteTipoServicio(tipoServicio);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTipoServicio/")
    public void updateTipoServicio(@RequestBody
    TipoServicioDTO tipoServicioDTO) throws Exception {
        try {
            TipoServicio tipoServicio = tipoServicioMapper.tipoServicioDTOToTipoServicio(tipoServicioDTO);

            businessDelegatorView.updateTipoServicio(tipoServicio);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTipoServicio")
    public List<TipoServicioDTO> getDataTipoServicio()
        throws Exception {
        try {
            return businessDelegatorView.getDataTipoServicio();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTipoServicio/{idTipoServicio}")
    public TipoServicioDTO getTipoServicio(
        @PathVariable("idTipoServicio")
    Integer idTipoServicio) throws Exception {
        try {
            TipoServicio tipoServicio = businessDelegatorView.getTipoServicio(idTipoServicio);

            return tipoServicioMapper.tipoServicioToTipoServicioDTO(tipoServicio);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
