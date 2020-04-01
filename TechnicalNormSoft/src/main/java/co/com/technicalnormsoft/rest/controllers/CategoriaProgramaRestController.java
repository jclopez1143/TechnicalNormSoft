package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.ICategoriaProgramaMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;
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
@RequestMapping("/categoriaPrograma")
public class CategoriaProgramaRestController {
    private static final Logger log = LoggerFactory.getLogger(CategoriaProgramaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICategoriaProgramaMapper categoriaProgramaMapper;

    @PostMapping(value = "/saveCategoriaPrograma")
    public void saveCategoriaPrograma(
        @RequestBody
    CategoriaProgramaDTO categoriaProgramaDTO) throws Exception {
        try {
            CategoriaPrograma categoriaPrograma = categoriaProgramaMapper.categoriaProgramaDTOToCategoriaPrograma(categoriaProgramaDTO);

            businessDelegatorView.saveCategoriaPrograma(categoriaPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCategoriaPrograma/{idCategoriaPrograma}")
    public void deleteCategoriaPrograma(
        @PathVariable("idCategoriaPrograma")
    Integer idCategoriaPrograma) throws Exception {
        try {
            CategoriaPrograma categoriaPrograma = businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma);

            businessDelegatorView.deleteCategoriaPrograma(categoriaPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCategoriaPrograma/")
    public void updateCategoriaPrograma(
        @RequestBody
    CategoriaProgramaDTO categoriaProgramaDTO) throws Exception {
        try {
            CategoriaPrograma categoriaPrograma = categoriaProgramaMapper.categoriaProgramaDTOToCategoriaPrograma(categoriaProgramaDTO);

            businessDelegatorView.updateCategoriaPrograma(categoriaPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCategoriaPrograma")
    public List<CategoriaProgramaDTO> getDataCategoriaPrograma()
        throws Exception {
        try {
            return businessDelegatorView.getDataCategoriaPrograma();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCategoriaPrograma/{idCategoriaPrograma}")
    public CategoriaProgramaDTO getCategoriaPrograma(
        @PathVariable("idCategoriaPrograma")
    Integer idCategoriaPrograma) throws Exception {
        try {
            CategoriaPrograma categoriaPrograma = businessDelegatorView.getCategoriaPrograma(idCategoriaPrograma);

            return categoriaProgramaMapper.categoriaProgramaToCategoriaProgramaDTO(categoriaPrograma);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
