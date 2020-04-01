package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Usuario;
import co.com.technicalnormsoft.model.dto.UsuarioDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IUsuarioMapper {
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception;

    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception;

    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuarios)
        throws Exception;

    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> usuarioDTOs) throws Exception;
}
