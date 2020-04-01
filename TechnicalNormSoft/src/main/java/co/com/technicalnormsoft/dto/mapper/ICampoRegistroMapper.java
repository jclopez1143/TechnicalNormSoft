package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.CampoRegistro;
import co.com.technicalnormsoft.model.dto.CampoRegistroDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICampoRegistroMapper {
    public CampoRegistroDTO campoRegistroToCampoRegistroDTO(
        CampoRegistro campoRegistro) throws Exception;

    public CampoRegistro campoRegistroDTOToCampoRegistro(
        CampoRegistroDTO campoRegistroDTO) throws Exception;

    public List<CampoRegistroDTO> listCampoRegistroToListCampoRegistroDTO(
        List<CampoRegistro> campoRegistros) throws Exception;

    public List<CampoRegistro> listCampoRegistroDTOToListCampoRegistro(
        List<CampoRegistroDTO> campoRegistroDTOs) throws Exception;
}
