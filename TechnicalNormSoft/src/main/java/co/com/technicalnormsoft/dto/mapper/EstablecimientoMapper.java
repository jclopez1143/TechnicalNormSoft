package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;

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
public class EstablecimientoMapper implements IEstablecimientoMapper {
    private static final Logger log = LoggerFactory.getLogger(EstablecimientoMapper.class);

    /**
    * Logic injected by Spring that manages TipoServicio entities
    *
    */
    @Autowired
    ITipoServicioLogic logicTipoServicio1;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario2;

    @Transactional(readOnly = true)
    public EstablecimientoDTO establecimientoToEstablecimientoDTO(
        Establecimiento establecimiento) throws Exception {
        try {
            EstablecimientoDTO establecimientoDTO = new EstablecimientoDTO();

            establecimientoDTO.setIdEstablecimiento(establecimiento.getIdEstablecimiento());
            establecimientoDTO.setCargoPersonaContacto((establecimiento.getCargoPersonaContacto() != null)
                ? establecimiento.getCargoPersonaContacto() : null);
            establecimientoDTO.setCelular((establecimiento.getCelular() != null)
                ? establecimiento.getCelular() : null);
            establecimientoDTO.setDateIn(establecimiento.getDateIn());
            establecimientoDTO.setDateUpdate(establecimiento.getDateUpdate());
            establecimientoDTO.setDireccion((establecimiento.getDireccion() != null)
                ? establecimiento.getDireccion() : null);
            establecimientoDTO.setEmail((establecimiento.getEmail() != null)
                ? establecimiento.getEmail() : null);
            establecimientoDTO.setNombre((establecimiento.getNombre() != null)
                ? establecimiento.getNombre() : null);
            establecimientoDTO.setNombrePersonaContacto((establecimiento.getNombrePersonaContacto() != null)
                ? establecimiento.getNombrePersonaContacto() : null);
            establecimientoDTO.setScore((establecimiento.getScore() != null)
                ? establecimiento.getScore() : null);
            establecimientoDTO.setTelefono((establecimiento.getTelefono() != null)
                ? establecimiento.getTelefono() : null);
            establecimientoDTO.setIdTipoServicio_TipoServicio((establecimiento.getTipoServicio()
                                                                              .getIdTipoServicio() != null)
                ? establecimiento.getTipoServicio().getIdTipoServicio() : null);

            if (establecimiento.getUsuario() != null) {
                establecimientoDTO.setIdUsuario_Usuario(establecimiento.getUsuario()
                                                                       .getIdUsuario());
            } else {
                establecimientoDTO.setIdUsuario_Usuario(null);
            }

            return establecimientoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Establecimiento establecimientoDTOToEstablecimiento(
        EstablecimientoDTO establecimientoDTO) throws Exception {
        try {
            Establecimiento establecimiento = new Establecimiento();

            establecimiento.setIdEstablecimiento(establecimientoDTO.getIdEstablecimiento());
            establecimiento.setCargoPersonaContacto((establecimientoDTO.getCargoPersonaContacto() != null)
                ? establecimientoDTO.getCargoPersonaContacto() : null);
            establecimiento.setCelular((establecimientoDTO.getCelular() != null)
                ? establecimientoDTO.getCelular() : null);
            establecimiento.setDateIn(establecimientoDTO.getDateIn());
            establecimiento.setDateUpdate(establecimientoDTO.getDateUpdate());
            establecimiento.setDireccion((establecimientoDTO.getDireccion() != null)
                ? establecimientoDTO.getDireccion() : null);
            establecimiento.setEmail((establecimientoDTO.getEmail() != null)
                ? establecimientoDTO.getEmail() : null);
            establecimiento.setNombre((establecimientoDTO.getNombre() != null)
                ? establecimientoDTO.getNombre() : null);
            establecimiento.setNombrePersonaContacto((establecimientoDTO.getNombrePersonaContacto() != null)
                ? establecimientoDTO.getNombrePersonaContacto() : null);
            establecimiento.setScore((establecimientoDTO.getScore() != null)
                ? establecimientoDTO.getScore() : null);
            establecimiento.setTelefono((establecimientoDTO.getTelefono() != null)
                ? establecimientoDTO.getTelefono() : null);

            TipoServicio tipoServicio = new TipoServicio();

            if (establecimientoDTO.getIdTipoServicio_TipoServicio() != null) {
                tipoServicio = logicTipoServicio1.getTipoServicio(establecimientoDTO.getIdTipoServicio_TipoServicio());
            }

            if (tipoServicio != null) {
                establecimiento.setTipoServicio(tipoServicio);
            }

            Usuario usuario = new Usuario();

            if (establecimientoDTO.getIdUsuario_Usuario() != null) {
                usuario = logicUsuario2.getUsuario(establecimientoDTO.getIdUsuario_Usuario());
            }

            if (usuario != null) {
                establecimiento.setUsuario(usuario);
            }

            return establecimiento;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EstablecimientoDTO> listEstablecimientoToListEstablecimientoDTO(
        List<Establecimiento> listEstablecimiento) throws Exception {
        try {
            List<EstablecimientoDTO> establecimientoDTOs = new ArrayList<EstablecimientoDTO>();

            for (Establecimiento establecimiento : listEstablecimiento) {
                EstablecimientoDTO establecimientoDTO = establecimientoToEstablecimientoDTO(establecimiento);

                establecimientoDTOs.add(establecimientoDTO);
            }

            return establecimientoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Establecimiento> listEstablecimientoDTOToListEstablecimiento(
        List<EstablecimientoDTO> listEstablecimientoDTO)
        throws Exception {
        try {
            List<Establecimiento> listEstablecimiento = new ArrayList<Establecimiento>();

            for (EstablecimientoDTO establecimientoDTO : listEstablecimientoDTO) {
                Establecimiento establecimiento = establecimientoDTOToEstablecimiento(establecimientoDTO);

                listEstablecimiento.add(establecimiento);
            }

            return listEstablecimiento;
        } catch (Exception e) {
            throw e;
        }
    }
}
