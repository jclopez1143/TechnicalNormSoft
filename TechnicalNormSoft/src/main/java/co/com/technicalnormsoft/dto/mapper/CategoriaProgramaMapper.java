package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;

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
public class CategoriaProgramaMapper implements ICategoriaProgramaMapper {
    private static final Logger log = LoggerFactory.getLogger(CategoriaProgramaMapper.class);

    @Transactional(readOnly = true)
    public CategoriaProgramaDTO categoriaProgramaToCategoriaProgramaDTO(
        CategoriaPrograma categoriaPrograma) throws Exception {
        try {
            CategoriaProgramaDTO categoriaProgramaDTO = new CategoriaProgramaDTO();

            categoriaProgramaDTO.setIdCategoriaPrograma(categoriaPrograma.getIdCategoriaPrograma());
            categoriaProgramaDTO.setDateIn(categoriaPrograma.getDateIn());
            categoriaProgramaDTO.setDateUpdate(categoriaPrograma.getDateUpdate());
            categoriaProgramaDTO.setDescripcion((categoriaPrograma.getDescripcion() != null)
                ? categoriaPrograma.getDescripcion() : null);

            return categoriaProgramaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public CategoriaPrograma categoriaProgramaDTOToCategoriaPrograma(
        CategoriaProgramaDTO categoriaProgramaDTO) throws Exception {
        try {
            CategoriaPrograma categoriaPrograma = new CategoriaPrograma();

            categoriaPrograma.setIdCategoriaPrograma(categoriaProgramaDTO.getIdCategoriaPrograma());
            categoriaPrograma.setDateIn(categoriaProgramaDTO.getDateIn());
            categoriaPrograma.setDateUpdate(categoriaProgramaDTO.getDateUpdate());
            categoriaPrograma.setDescripcion((categoriaProgramaDTO.getDescripcion() != null)
                ? categoriaProgramaDTO.getDescripcion() : null);

            return categoriaPrograma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaProgramaDTO> listCategoriaProgramaToListCategoriaProgramaDTO(
        List<CategoriaPrograma> listCategoriaPrograma)
        throws Exception {
        try {
            List<CategoriaProgramaDTO> categoriaProgramaDTOs = new ArrayList<CategoriaProgramaDTO>();

            for (CategoriaPrograma categoriaPrograma : listCategoriaPrograma) {
                CategoriaProgramaDTO categoriaProgramaDTO = categoriaProgramaToCategoriaProgramaDTO(categoriaPrograma);

                categoriaProgramaDTOs.add(categoriaProgramaDTO);
            }

            return categoriaProgramaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CategoriaPrograma> listCategoriaProgramaDTOToListCategoriaPrograma(
        List<CategoriaProgramaDTO> listCategoriaProgramaDTO)
        throws Exception {
        try {
            List<CategoriaPrograma> listCategoriaPrograma = new ArrayList<CategoriaPrograma>();

            for (CategoriaProgramaDTO categoriaProgramaDTO : listCategoriaProgramaDTO) {
                CategoriaPrograma categoriaPrograma = categoriaProgramaDTOToCategoriaPrograma(categoriaProgramaDTO);

                listCategoriaPrograma.add(categoriaPrograma);
            }

            return listCategoriaPrograma;
        } catch (Exception e) {
            throw e;
        }
    }
}
