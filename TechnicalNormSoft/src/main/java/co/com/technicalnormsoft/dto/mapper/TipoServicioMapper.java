package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.TipoServicio;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;

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
public class TipoServicioMapper implements ITipoServicioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoServicioMapper.class);

    @Transactional(readOnly = true)
    public TipoServicioDTO tipoServicioToTipoServicioDTO(
        TipoServicio tipoServicio) throws Exception {
        try {
            TipoServicioDTO tipoServicioDTO = new TipoServicioDTO();

            tipoServicioDTO.setIdTipoServicio(tipoServicio.getIdTipoServicio());
            tipoServicioDTO.setDateIn(tipoServicio.getDateIn());
            tipoServicioDTO.setDateUpdate(tipoServicio.getDateUpdate());
            tipoServicioDTO.setDescripcion((tipoServicio.getDescripcion() != null)
                ? tipoServicio.getDescripcion() : null);

            return tipoServicioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoServicio tipoServicioDTOToTipoServicio(
        TipoServicioDTO tipoServicioDTO) throws Exception {
        try {
            TipoServicio tipoServicio = new TipoServicio();

            tipoServicio.setIdTipoServicio(tipoServicioDTO.getIdTipoServicio());
            tipoServicio.setDateIn(tipoServicioDTO.getDateIn());
            tipoServicio.setDateUpdate(tipoServicioDTO.getDateUpdate());
            tipoServicio.setDescripcion((tipoServicioDTO.getDescripcion() != null)
                ? tipoServicioDTO.getDescripcion() : null);

            return tipoServicio;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoServicioDTO> listTipoServicioToListTipoServicioDTO(
        List<TipoServicio> listTipoServicio) throws Exception {
        try {
            List<TipoServicioDTO> tipoServicioDTOs = new ArrayList<TipoServicioDTO>();

            for (TipoServicio tipoServicio : listTipoServicio) {
                TipoServicioDTO tipoServicioDTO = tipoServicioToTipoServicioDTO(tipoServicio);

                tipoServicioDTOs.add(tipoServicioDTO);
            }

            return tipoServicioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoServicio> listTipoServicioDTOToListTipoServicio(
        List<TipoServicioDTO> listTipoServicioDTO) throws Exception {
        try {
            List<TipoServicio> listTipoServicio = new ArrayList<TipoServicio>();

            for (TipoServicioDTO tipoServicioDTO : listTipoServicioDTO) {
                TipoServicio tipoServicio = tipoServicioDTOToTipoServicio(tipoServicioDTO);

                listTipoServicio.add(tipoServicio);
            }

            return listTipoServicio;
        } catch (Exception e) {
            throw e;
        }
    }
}
