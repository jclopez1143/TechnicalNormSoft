package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.DatoObjetivo;
import co.com.technicalnormsoft.model.dto.DatoObjetivoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IDatoObjetivoMapper {
    public DatoObjetivoDTO datoObjetivoToDatoObjetivoDTO(
        DatoObjetivo datoObjetivo) throws Exception;

    public DatoObjetivo datoObjetivoDTOToDatoObjetivo(
        DatoObjetivoDTO datoObjetivoDTO) throws Exception;

    public List<DatoObjetivoDTO> listDatoObjetivoToListDatoObjetivoDTO(
        List<DatoObjetivo> datoObjetivos) throws Exception;

    public List<DatoObjetivo> listDatoObjetivoDTOToListDatoObjetivo(
        List<DatoObjetivoDTO> datoObjetivoDTOs) throws Exception;
}
