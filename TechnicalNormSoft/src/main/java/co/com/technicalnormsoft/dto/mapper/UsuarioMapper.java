package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.*;
import co.com.technicalnormsoft.model.Usuario;
import co.com.technicalnormsoft.model.control.*;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;

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
public class UsuarioMapper implements IUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioMapper.class);

    @Transactional(readOnly = true)
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioDTO.setCargoPersonaContacto((usuario.getCargoPersonaContacto() != null)
                ? usuario.getCargoPersonaContacto() : null);
            usuarioDTO.setCelular((usuario.getCelular() != null)
                ? usuario.getCelular() : null);
            usuarioDTO.setDateIn(usuario.getDateIn());
            usuarioDTO.setDateUpdate(usuario.getDateUpdate());
            usuarioDTO.setEmail((usuario.getEmail() != null)
                ? usuario.getEmail() : null);
            usuarioDTO.setNit((usuario.getNit() != null) ? usuario.getNit() : null);
            usuarioDTO.setNombrePersonaContacto((usuario.getNombrePersonaContacto() != null)
                ? usuario.getNombrePersonaContacto() : null);
            usuarioDTO.setRazonSocial((usuario.getRazonSocial() != null)
                ? usuario.getRazonSocial() : null);
            usuarioDTO.setSitioWeb((usuario.getSitioWeb() != null)
                ? usuario.getSitioWeb() : null);
            usuarioDTO.setTelefono((usuario.getTelefono() != null)
                ? usuario.getTelefono() : null);
            usuarioDTO.setPassword((usuario.getPassword() != null)
                    ? usuario.getPassword() : null);

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception {
        try {
            Usuario usuario = new Usuario();

            usuario.setIdUsuario(usuarioDTO.getIdUsuario());
            usuario.setCargoPersonaContacto((usuarioDTO.getCargoPersonaContacto() != null)
                ? usuarioDTO.getCargoPersonaContacto() : null);
            usuario.setCelular((usuarioDTO.getCelular() != null)
                ? usuarioDTO.getCelular() : null);
            usuario.setDateIn(usuarioDTO.getDateIn());
            usuario.setDateUpdate(usuarioDTO.getDateUpdate());
            usuario.setEmail((usuarioDTO.getEmail() != null)
                ? usuarioDTO.getEmail() : null);
            usuario.setNit((usuarioDTO.getNit() != null) ? usuarioDTO.getNit()
                                                         : null);
            usuario.setNombrePersonaContacto((usuarioDTO.getNombrePersonaContacto() != null)
                ? usuarioDTO.getNombrePersonaContacto() : null);
            usuario.setRazonSocial((usuarioDTO.getRazonSocial() != null)
                ? usuarioDTO.getRazonSocial() : null);
            usuario.setSitioWeb((usuarioDTO.getSitioWeb() != null)
                ? usuarioDTO.getSitioWeb() : null);
            usuario.setTelefono((usuarioDTO.getTelefono() != null)
                ? usuarioDTO.getTelefono() : null);
            usuario.setPassword((usuarioDTO.getPassword() != null)
                    ? usuarioDTO.getPassword() : null);

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(
        List<Usuario> listUsuario) throws Exception {
        try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
                UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> listUsuarioDTO) throws Exception {
        try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
