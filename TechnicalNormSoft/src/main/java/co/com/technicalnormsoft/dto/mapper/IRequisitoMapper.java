package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Requisito;
import co.com.technicalnormsoft.model.dto.RequisitoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IRequisitoMapper {
    public RequisitoDTO requisitoToRequisitoDTO(Requisito requisito)
        throws Exception;

    public Requisito requisitoDTOToRequisito(RequisitoDTO requisitoDTO)
        throws Exception;

    public List<RequisitoDTO> listRequisitoToListRequisitoDTO(
        List<Requisito> requisitos) throws Exception;

    public List<Requisito> listRequisitoDTOToListRequisito(
        List<RequisitoDTO> requisitoDTOs) throws Exception;
}
