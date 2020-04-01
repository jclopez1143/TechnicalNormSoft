package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Medalla;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.MedallaDTO;

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
public class MedallaMapper implements IMedallaMapper {
    private static final Logger log = LoggerFactory.getLogger(MedallaMapper.class);

    @Transactional(readOnly = true)
    public MedallaDTO medallaToMedallaDTO(Medalla medalla)
        throws Exception {
        try {
            MedallaDTO medallaDTO = new MedallaDTO();

            medallaDTO.setIdMedalla(medalla.getIdMedalla());
            medallaDTO.setDateIn(medalla.getDateIn());
            medallaDTO.setDateUpdate(medalla.getDateUpdate());
            medallaDTO.setDescripcion((medalla.getDescripcion() != null)
                ? medalla.getDescripcion() : null);
            medallaDTO.setScore((medalla.getScore() != null)
                ? medalla.getScore() : null);

            return medallaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Medalla medallaDTOToMedalla(MedallaDTO medallaDTO)
        throws Exception {
        try {
            Medalla medalla = new Medalla();

            medalla.setIdMedalla(medallaDTO.getIdMedalla());
            medalla.setDateIn(medallaDTO.getDateIn());
            medalla.setDateUpdate(medallaDTO.getDateUpdate());
            medalla.setDescripcion((medallaDTO.getDescripcion() != null)
                ? medallaDTO.getDescripcion() : null);
            medalla.setScore((medallaDTO.getScore() != null)
                ? medallaDTO.getScore() : null);

            return medalla;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<MedallaDTO> listMedallaToListMedallaDTO(
        List<Medalla> listMedalla) throws Exception {
        try {
            List<MedallaDTO> medallaDTOs = new ArrayList<MedallaDTO>();

            for (Medalla medalla : listMedalla) {
                MedallaDTO medallaDTO = medallaToMedallaDTO(medalla);

                medallaDTOs.add(medallaDTO);
            }

            return medallaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Medalla> listMedallaDTOToListMedalla(
        List<MedallaDTO> listMedallaDTO) throws Exception {
        try {
            List<Medalla> listMedalla = new ArrayList<Medalla>();

            for (MedallaDTO medallaDTO : listMedallaDTO) {
                Medalla medalla = medallaDTOToMedalla(medallaDTO);

                listMedalla.add(medalla);
            }

            return listMedalla;
        } catch (Exception e) {
            throw e;
        }
    }
}
