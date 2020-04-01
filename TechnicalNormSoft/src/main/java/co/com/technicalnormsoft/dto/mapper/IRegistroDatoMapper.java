package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.RegistroDato;
import co.com.technicalnormsoft.model.dto.RegistroDatoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRegistroDatoMapper {
    public RegistroDatoDTO registroDatoToRegistroDatoDTO(
        RegistroDato registroDato) throws Exception;

    public RegistroDato registroDatoDTOToRegistroDato(
        RegistroDatoDTO registroDatoDTO) throws Exception;

    public List<RegistroDatoDTO> listRegistroDatoToListRegistroDatoDTO(
        List<RegistroDato> registroDatos) throws Exception;

    public List<RegistroDato> listRegistroDatoDTOToListRegistroDato(
        List<RegistroDatoDTO> registroDatoDTOs) throws Exception;
}
