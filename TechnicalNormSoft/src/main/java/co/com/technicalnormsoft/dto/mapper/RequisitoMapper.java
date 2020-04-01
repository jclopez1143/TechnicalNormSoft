package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Requisito;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;

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
public class RequisitoMapper implements IRequisitoMapper {
    private static final Logger log = LoggerFactory.getLogger(RequisitoMapper.class);

    /**
    * Logic injected by Spring that manages CategoriaRequisito entities
    *
    */
    @Autowired
    ICategoriaRequisitoLogic logicCategoriaRequisito1;

    /**
    * Logic injected by Spring that manages Norma entities
    *
    */
    @Autowired
    INormaLogic logicNorma2;

    @Transactional(readOnly = true)
    public RequisitoDTO requisitoToRequisitoDTO(Requisito requisito)
        throws Exception {
        try {
            RequisitoDTO requisitoDTO = new RequisitoDTO();

            requisitoDTO.setIdRequisito(requisito.getIdRequisito());
            requisitoDTO.setDateIn(requisito.getDateIn());
            requisitoDTO.setDateUpdate(requisito.getDateUpdate());
            requisitoDTO.setDescripcion((requisito.getDescripcion() != null)
                ? requisito.getDescripcion() : null);
            requisitoDTO.setNumeral((requisito.getNumeral() != null)
                ? requisito.getNumeral() : null);
            requisitoDTO.setIdCategoriaRequisito_CategoriaRequisito((requisito.getCategoriaRequisito()
                                                                              .getIdCategoriaRequisito() != null)
                ? requisito.getCategoriaRequisito().getIdCategoriaRequisito()
                : null);

            if (requisito.getNorma() != null) {
                requisitoDTO.setIdNorma_Norma(requisito.getNorma().getIdNorma());
            } else {
                requisitoDTO.setIdNorma_Norma(null);
            }

            return requisitoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Requisito requisitoDTOToRequisito(RequisitoDTO requisitoDTO)
        throws Exception {
        try {
            Requisito requisito = new Requisito();

            requisito.setIdRequisito(requisitoDTO.getIdRequisito());
            requisito.setDateIn(requisitoDTO.getDateIn());
            requisito.setDateUpdate(requisitoDTO.getDateUpdate());
            requisito.setDescripcion((requisitoDTO.getDescripcion() != null)
                ? requisitoDTO.getDescripcion() : null);
            requisito.setNumeral((requisitoDTO.getNumeral() != null)
                ? requisitoDTO.getNumeral() : null);

            CategoriaRequisito categoriaRequisito = new CategoriaRequisito();

            if (requisitoDTO.getIdCategoriaRequisito_CategoriaRequisito() != null) {
                categoriaRequisito = logicCategoriaRequisito1.getCategoriaRequisito(requisitoDTO.getIdCategoriaRequisito_CategoriaRequisito());
            }

            if (categoriaRequisito != null) {
                requisito.setCategoriaRequisito(categoriaRequisito);
            }

            Norma norma = new Norma();

            if (requisitoDTO.getIdNorma_Norma() != null) {
                norma = logicNorma2.getNorma(requisitoDTO.getIdNorma_Norma());
            }

            if (norma != null) {
                requisito.setNorma(norma);
            }

            return requisito;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RequisitoDTO> listRequisitoToListRequisitoDTO(
        List<Requisito> listRequisito) throws Exception {
        try {
            List<RequisitoDTO> requisitoDTOs = new ArrayList<RequisitoDTO>();

            for (Requisito requisito : listRequisito) {
                RequisitoDTO requisitoDTO = requisitoToRequisitoDTO(requisito);

                requisitoDTOs.add(requisitoDTO);
            }

            return requisitoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Requisito> listRequisitoDTOToListRequisito(
        List<RequisitoDTO> listRequisitoDTO) throws Exception {
        try {
            List<Requisito> listRequisito = new ArrayList<Requisito>();

            for (RequisitoDTO requisitoDTO : listRequisitoDTO) {
                Requisito requisito = requisitoDTOToRequisito(requisitoDTO);

                listRequisito.add(requisito);
            }

            return listRequisito;
        } catch (Exception e) {
            throw e;
        }
    }
}
