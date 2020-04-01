package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.CategoriaPrograma;
import co.com.technicalnormsoft.model.dto.CategoriaProgramaDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface ICategoriaProgramaMapper {
    public CategoriaProgramaDTO categoriaProgramaToCategoriaProgramaDTO(
        CategoriaPrograma categoriaPrograma) throws Exception;

    public CategoriaPrograma categoriaProgramaDTOToCategoriaPrograma(
        CategoriaProgramaDTO categoriaProgramaDTO) throws Exception;

    public List<CategoriaProgramaDTO> listCategoriaProgramaToListCategoriaProgramaDTO(
        List<CategoriaPrograma> categoriaProgramas) throws Exception;

    public List<CategoriaPrograma> listCategoriaProgramaDTOToListCategoriaPrograma(
        List<CategoriaProgramaDTO> categoriaProgramaDTOs)
        throws Exception;
}
