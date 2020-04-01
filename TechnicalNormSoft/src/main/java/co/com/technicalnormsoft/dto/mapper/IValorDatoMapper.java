package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.ValorDato;
import co.com.technicalnormsoft.model.dto.ValorDatoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IValorDatoMapper {
    public ValorDatoDTO valorDatoToValorDatoDTO(ValorDato valorDato)
        throws Exception;

    public ValorDato valorDatoDTOToValorDato(ValorDatoDTO valorDatoDTO)
        throws Exception;

    public List<ValorDatoDTO> listValorDatoToListValorDatoDTO(
        List<ValorDato> valorDatos) throws Exception;

    public List<ValorDato> listValorDatoDTOToListValorDato(
        List<ValorDatoDTO> valorDatoDTOs) throws Exception;
}
