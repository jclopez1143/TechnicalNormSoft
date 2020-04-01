package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.MedallaEstablecimiento;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;

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
public class MedallaEstablecimientoMapper
    implements IMedallaEstablecimientoMapper {
    private static final Logger log = LoggerFactory.getLogger(MedallaEstablecimientoMapper.class);

    /**
    * Logic injected by Spring that manages Establecimiento entities
    *
    */
    @Autowired
    IEstablecimientoLogic logicEstablecimiento1;

    /**
    * Logic injected by Spring that manages Medalla entities
    *
    */
    @Autowired
    IMedallaLogic logicMedalla2;

    @Transactional(readOnly = true)
    public MedallaEstablecimientoDTO medallaEstablecimientoToMedallaEstablecimientoDTO(
        MedallaEstablecimiento medallaEstablecimiento)
        throws Exception {
        try {
            MedallaEstablecimientoDTO medallaEstablecimientoDTO = new MedallaEstablecimientoDTO();

            medallaEstablecimientoDTO.setIdMedallaEstablecimiento(medallaEstablecimiento.getIdMedallaEstablecimiento());
            medallaEstablecimientoDTO.setDateIn(medallaEstablecimiento.getDateIn());
            medallaEstablecimientoDTO.setDateUpdate(medallaEstablecimiento.getDateUpdate());
            medallaEstablecimientoDTO.setIdEstablecimiento_Establecimiento((medallaEstablecimiento.getEstablecimiento()
                                                                                                  .getIdEstablecimiento() != null)
                ? medallaEstablecimiento.getEstablecimiento()
                                        .getIdEstablecimiento() : null);
            medallaEstablecimientoDTO.setIdMedalla_Medalla((medallaEstablecimiento.getMedalla()
                                                                                  .getIdMedalla() != null)
                ? medallaEstablecimiento.getMedalla().getIdMedalla() : null);

            return medallaEstablecimientoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public MedallaEstablecimiento medallaEstablecimientoDTOToMedallaEstablecimiento(
        MedallaEstablecimientoDTO medallaEstablecimientoDTO)
        throws Exception {
        try {
            MedallaEstablecimiento medallaEstablecimiento = new MedallaEstablecimiento();

            medallaEstablecimiento.setIdMedallaEstablecimiento(medallaEstablecimientoDTO.getIdMedallaEstablecimiento());
            medallaEstablecimiento.setDateIn(medallaEstablecimientoDTO.getDateIn());
            medallaEstablecimiento.setDateUpdate(medallaEstablecimientoDTO.getDateUpdate());

            Establecimiento establecimiento = new Establecimiento();

            if (medallaEstablecimientoDTO.getIdEstablecimiento_Establecimiento() != null) {
                establecimiento = logicEstablecimiento1.getEstablecimiento(medallaEstablecimientoDTO.getIdEstablecimiento_Establecimiento());
            }

            if (establecimiento != null) {
                medallaEstablecimiento.setEstablecimiento(establecimiento);
            }

            Medalla medalla = new Medalla();

            if (medallaEstablecimientoDTO.getIdMedalla_Medalla() != null) {
                medalla = logicMedalla2.getMedalla(medallaEstablecimientoDTO.getIdMedalla_Medalla());
            }

            if (medalla != null) {
                medallaEstablecimiento.setMedalla(medalla);
            }

            return medallaEstablecimiento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<MedallaEstablecimientoDTO> listMedallaEstablecimientoToListMedallaEstablecimientoDTO(
        List<MedallaEstablecimiento> listMedallaEstablecimiento)
        throws Exception {
        try {
            List<MedallaEstablecimientoDTO> medallaEstablecimientoDTOs = new ArrayList<MedallaEstablecimientoDTO>();

            for (MedallaEstablecimiento medallaEstablecimiento : listMedallaEstablecimiento) {
                MedallaEstablecimientoDTO medallaEstablecimientoDTO = medallaEstablecimientoToMedallaEstablecimientoDTO(medallaEstablecimiento);

                medallaEstablecimientoDTOs.add(medallaEstablecimientoDTO);
            }

            return medallaEstablecimientoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<MedallaEstablecimiento> listMedallaEstablecimientoDTOToListMedallaEstablecimiento(
        List<MedallaEstablecimientoDTO> listMedallaEstablecimientoDTO)
        throws Exception {
        try {
            List<MedallaEstablecimiento> listMedallaEstablecimiento = new ArrayList<MedallaEstablecimiento>();

            for (MedallaEstablecimientoDTO medallaEstablecimientoDTO : listMedallaEstablecimientoDTO) {
                MedallaEstablecimiento medallaEstablecimiento = medallaEstablecimientoDTOToMedallaEstablecimiento(medallaEstablecimientoDTO);

                listMedallaEstablecimiento.add(medallaEstablecimiento);
            }

            return listMedallaEstablecimiento;
        } catch (Exception e) {
            throw e;
        }
    }
}
