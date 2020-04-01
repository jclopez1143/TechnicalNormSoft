package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.ValorCampo;
import co.com.technicalnormsoft.model.dto.ValorCampoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IValorCampoMapper {
    public ValorCampoDTO valorCampoToValorCampoDTO(ValorCampo valorCampo)
        throws Exception;

    public ValorCampo valorCampoDTOToValorCampo(ValorCampoDTO valorCampoDTO)
        throws Exception;

    public List<ValorCampoDTO> listValorCampoToListValorCampoDTO(
        List<ValorCampo> valorCampos) throws Exception;

    public List<ValorCampo> listValorCampoDTOToListValorCampo(
        List<ValorCampoDTO> valorCampoDTOs) throws Exception;
}
