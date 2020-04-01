package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.TipoServicioNorma;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;

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
public class TipoServicioNormaMapper implements ITipoServicioNormaMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioNormaMapper.class);

    /**
    * Logic injected by Spring that manages Norma entities
    *
    */
    @Autowired
    INormaLogic logicNorma1;

    /**
    * Logic injected by Spring that manages TipoServicio entities
    *
    */
    @Autowired
    ITipoServicioLogic logicTipoServicio2;

    @Transactional(readOnly = true)
    public TipoServicioNormaDTO tipoServicioNormaToTipoServicioNormaDTO(
        TipoServicioNorma tipoServicioNorma) throws Exception {
        try {
            TipoServicioNormaDTO tipoServicioNormaDTO = new TipoServicioNormaDTO();

            tipoServicioNormaDTO.setIdTipoServicioNorma(tipoServicioNorma.getIdTipoServicioNorma());

            if (tipoServicioNorma.getNorma() != null) {
                tipoServicioNormaDTO.setIdNorma_Norma(tipoServicioNorma.getNorma()
                                                                       .getIdNorma());
            } else {
                tipoServicioNormaDTO.setIdNorma_Norma(null);
            }

            tipoServicioNormaDTO.setIdTipoServicio_TipoServicio((tipoServicioNorma.getTipoServicio()
                                                                                  .getIdTipoServicio() != null)
                ? tipoServicioNorma.getTipoServicio().getIdTipoServicio() : null);

            return tipoServicioNormaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoServicioNorma tipoServicioNormaDTOToTipoServicioNorma(
        TipoServicioNormaDTO tipoServicioNormaDTO) throws Exception {
        try {
            TipoServicioNorma tipoServicioNorma = new TipoServicioNorma();

            tipoServicioNorma.setIdTipoServicioNorma(tipoServicioNormaDTO.getIdTipoServicioNorma());

            Norma norma = new Norma();

            if (tipoServicioNormaDTO.getIdNorma_Norma() != null) {
                norma = logicNorma1.getNorma(tipoServicioNormaDTO.getIdNorma_Norma());
            }

            if (norma != null) {
                tipoServicioNorma.setNorma(norma);
            }

            TipoServicio tipoServicio = new TipoServicio();

            if (tipoServicioNormaDTO.getIdTipoServicio_TipoServicio() != null) {
                tipoServicio = logicTipoServicio2.getTipoServicio(tipoServicioNormaDTO.getIdTipoServicio_TipoServicio());
            }

            if (tipoServicio != null) {
                tipoServicioNorma.setTipoServicio(tipoServicio);
            }

            return tipoServicioNorma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoServicioNormaDTO> listTipoServicioNormaToListTipoServicioNormaDTO(
        List<TipoServicioNorma> listTipoServicioNorma)
        throws Exception {
        try {
            List<TipoServicioNormaDTO> tipoServicioNormaDTOs = new ArrayList<TipoServicioNormaDTO>();

            for (TipoServicioNorma tipoServicioNorma : listTipoServicioNorma) {
                TipoServicioNormaDTO tipoServicioNormaDTO = tipoServicioNormaToTipoServicioNormaDTO(tipoServicioNorma);

                tipoServicioNormaDTOs.add(tipoServicioNormaDTO);
            }

            return tipoServicioNormaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoServicioNorma> listTipoServicioNormaDTOToListTipoServicioNorma(
        List<TipoServicioNormaDTO> listTipoServicioNormaDTO)
        throws Exception {
        try {
            List<TipoServicioNorma> listTipoServicioNorma = new ArrayList<TipoServicioNorma>();

            for (TipoServicioNormaDTO tipoServicioNormaDTO : listTipoServicioNormaDTO) {
                TipoServicioNorma tipoServicioNorma = tipoServicioNormaDTOToTipoServicioNorma(tipoServicioNormaDTO);

                listTipoServicioNorma.add(tipoServicioNorma);
            }

            return listTipoServicioNorma;
        } catch (Exception e) {
            throw e;
        }
    }
}
