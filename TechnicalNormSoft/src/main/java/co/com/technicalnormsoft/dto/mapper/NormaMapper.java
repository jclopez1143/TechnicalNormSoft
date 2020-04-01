package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.NormaDTO;

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
public class NormaMapper implements INormaMapper {
    private static final Logger log = LoggerFactory.getLogger(NormaMapper.class);

    @Transactional(readOnly = true)
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception {
        try {
            NormaDTO normaDTO = new NormaDTO();

            normaDTO.setIdNorma(norma.getIdNorma());
            normaDTO.setDateIn(norma.getDateIn());
            normaDTO.setDateUpdate(norma.getDateUpdate());
            normaDTO.setNombre((norma.getNombre() != null) ? norma.getNombre()
                                                           : null);

            return normaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Norma normaDTOToNorma(NormaDTO normaDTO) throws Exception {
        try {
            Norma norma = new Norma();

            norma.setIdNorma(normaDTO.getIdNorma());
            norma.setDateIn(normaDTO.getDateIn());
            norma.setDateUpdate(normaDTO.getDateUpdate());
            norma.setNombre((normaDTO.getNombre() != null)
                ? normaDTO.getNombre() : null);

            return norma;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<NormaDTO> listNormaToListNormaDTO(List<Norma> listNorma)
        throws Exception {
        try {
            List<NormaDTO> normaDTOs = new ArrayList<NormaDTO>();

            for (Norma norma : listNorma) {
                NormaDTO normaDTO = normaToNormaDTO(norma);

                normaDTOs.add(normaDTO);
            }

            return normaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Norma> listNormaDTOToListNorma(List<NormaDTO> listNormaDTO)
        throws Exception {
        try {
            List<Norma> listNorma = new ArrayList<Norma>();

            for (NormaDTO normaDTO : listNormaDTO) {
                Norma norma = normaDTOToNorma(normaDTO);

                listNorma.add(norma);
            }

            return listNorma;
        } catch (Exception e) {
            throw e;
        }
    }
}
