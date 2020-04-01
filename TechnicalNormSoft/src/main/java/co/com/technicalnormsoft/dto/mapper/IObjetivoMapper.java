package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Objetivo;
import co.com.technicalnormsoft.model.dto.ObjetivoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IObjetivoMapper {
    public ObjetivoDTO objetivoToObjetivoDTO(Objetivo objetivo)
        throws Exception;

    public Objetivo objetivoDTOToObjetivo(ObjetivoDTO objetivoDTO)
        throws Exception;

    public List<ObjetivoDTO> listObjetivoToListObjetivoDTO(
        List<Objetivo> objetivos) throws Exception;

    public List<Objetivo> listObjetivoDTOToListObjetivo(
        List<ObjetivoDTO> objetivoDTOs) throws Exception;
}
