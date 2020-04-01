package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.CategoriaRequisito;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.CategoriaRequisitoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
@Component
@Scope("singleton")
public class CategoriaRequisitoMapper implements ICategoriaRequisitoMapper {
    private static final Logger log = LoggerFactory.getLogger(CategoriaRequisitoMapper.class);

    @Transactional(readOnly = true)
    public CategoriaRequisitoDTO categoriaRequisitoToCategoriaRequisitoDTO(
        CategoriaRequisito categoriaRequisito) throws Exception {
        try {
            CategoriaRequisitoDTO categoriaRequisitoDTO = new CategoriaRequisitoDTO();

            categoriaRequisitoDTO.setIdCategoriaRequisito(categoriaRequisito.getIdCategoriaRequisito());
            categoriaRequisitoDTO.setDateIn(categoriaRequisito.getDateIn());
            categoriaRequisitoDTO.setDateUpdate(categoriaRequisito.getDateUpdate());
            categoriaRequisitoDTO.setDescripcion((categoriaRequisito.getDescripcion() != null)
                ? categoriaRequisito.getDescripcion() : null);

            return categoriaRequisitoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public CategoriaRequisito categoriaRequisitoDTOToCategoriaRequisito(
        CategoriaRequisitoDTO categoriaRequisitoDTO) throws Exception {
        try {
            CategoriaRequisito categoriaRequisito = new CategoriaRequisito();

            categoriaRequisito.setIdCategoriaRequisito(categoriaRequisitoDTO.getIdCategoriaRequisito());
            categoriaRequisito.setDateIn(categoriaRequisitoDTO.getDateIn());
            categoriaRequisito.setDateUpdate(categoriaRequisitoDTO.getDateUpdate());
            categoriaRequisito.setDescripcion((categoriaRequisitoDTO.getDescripcion() != null)
                ? categoriaRequisitoDTO.getDescripcion() : null);

            return categoriaRequisito;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaRequisitoDTO> listCategoriaRequisitoToListCategoriaRequisitoDTO(
        List<CategoriaRequisito> listCategoriaRequisito)
        throws Exception {
        try {
            List<CategoriaRequisitoDTO> categoriaRequisitoDTOs = new ArrayList<CategoriaRequisitoDTO>();

            for (CategoriaRequisito categoriaRequisito : listCategoriaRequisito) {
                CategoriaRequisitoDTO categoriaRequisitoDTO = categoriaRequisitoToCategoriaRequisitoDTO(categoriaRequisito);

                categoriaRequisitoDTOs.add(categoriaRequisitoDTO);
            }

            return categoriaRequisitoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaRequisito> listCategoriaRequisitoDTOToListCategoriaRequisito(
        List<CategoriaRequisitoDTO> listCategoriaRequisitoDTO)
        throws Exception {
        try {
            List<CategoriaRequisito> listCategoriaRequisito = new ArrayList<CategoriaRequisito>();

            for (CategoriaRequisitoDTO categoriaRequisitoDTO : listCategoriaRequisitoDTO) {
                CategoriaRequisito categoriaRequisito = categoriaRequisitoDTOToCategoriaRequisito(categoriaRequisitoDTO);

                listCategoriaRequisito.add(categoriaRequisito);
            }

            return listCategoriaRequisito;
        } catch (Exception e) {
            throw e;
        }
    }
}
