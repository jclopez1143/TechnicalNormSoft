package co.com.technicalnormsoft.rest.controllers;

import co.com.technicalnormsoft.dto.mapper.ICategoriaRequisitoMapper;
import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.dto.CategoriaRequisitoDTO;
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
@RequestMapping("/categoriaRequisito")
public class CategoriaRequisitoRestController {
    private static final Logger log = LoggerFactory.getLogger(CategoriaRequisitoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICategoriaRequisitoMapper categoriaRequisitoMapper;

    @PostMapping(value = "/saveCategoriaRequisito")
    public void saveCategoriaRequisito(
        @RequestBody
    CategoriaRequisitoDTO categoriaRequisitoDTO) throws Exception {
        try {
            CategoriaRequisito categoriaRequisito = categoriaRequisitoMapper.categoriaRequisitoDTOToCategoriaRequisito(categoriaRequisitoDTO);

            businessDelegatorView.saveCategoriaRequisito(categoriaRequisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCategoriaRequisito/{idCategoriaRequisito}")
    public void deleteCategoriaRequisito(
        @PathVariable("idCategoriaRequisito")
    Integer idCategoriaRequisito) throws Exception {
        try {
            CategoriaRequisito categoriaRequisito = businessDelegatorView.getCategoriaRequisito(idCategoriaRequisito);

            businessDelegatorView.deleteCategoriaRequisito(categoriaRequisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCategoriaRequisito/")
    public void updateCategoriaRequisito(
        @RequestBody
    CategoriaRequisitoDTO categoriaRequisitoDTO) throws Exception {
        try {
            CategoriaRequisito categoriaRequisito = categoriaRequisitoMapper.categoriaRequisitoDTOToCategoriaRequisito(categoriaRequisitoDTO);

            businessDelegatorView.updateCategoriaRequisito(categoriaRequisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCategoriaRequisito")
    public List<CategoriaRequisitoDTO> getDataCategoriaRequisito()
        throws Exception {
        try {
            return businessDelegatorView.getDataCategoriaRequisito();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCategoriaRequisito/{idCategoriaRequisito}")
    public CategoriaRequisitoDTO getCategoriaRequisito(
        @PathVariable("idCategoriaRequisito")
    Integer idCategoriaRequisito) throws Exception {
        try {
            CategoriaRequisito categoriaRequisito = businessDelegatorView.getCategoriaRequisito(idCategoriaRequisito);

            return categoriaRequisitoMapper.categoriaRequisitoToCategoriaRequisitoDTO(categoriaRequisito);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
