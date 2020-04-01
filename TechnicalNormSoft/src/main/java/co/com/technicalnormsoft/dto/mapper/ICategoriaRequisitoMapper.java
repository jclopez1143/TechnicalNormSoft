package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.CategoriaRequisito;
import co.com.technicalnormsoft.model.dto.CategoriaRequisitoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface ICategoriaRequisitoMapper {
    public CategoriaRequisitoDTO categoriaRequisitoToCategoriaRequisitoDTO(
        CategoriaRequisito categoriaRequisito) throws Exception;

    public CategoriaRequisito categoriaRequisitoDTOToCategoriaRequisito(
        CategoriaRequisitoDTO categoriaRequisitoDTO) throws Exception;

    public List<CategoriaRequisitoDTO> listCategoriaRequisitoToListCategoriaRequisitoDTO(
        List<CategoriaRequisito> categoriaRequisitos) throws Exception;

    public List<CategoriaRequisito> listCategoriaRequisitoDTOToListCategoriaRequisito(
        List<CategoriaRequisitoDTO> categoriaRequisitoDTOs)
        throws Exception;
}
