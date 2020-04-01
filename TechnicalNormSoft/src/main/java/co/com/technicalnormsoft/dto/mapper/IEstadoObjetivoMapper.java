package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.EstadoObjetivo;
import co.com.technicalnormsoft.model.dto.EstadoObjetivoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IEstadoObjetivoMapper {
    public EstadoObjetivoDTO estadoObjetivoToEstadoObjetivoDTO(
        EstadoObjetivo estadoObjetivo) throws Exception;

    public EstadoObjetivo estadoObjetivoDTOToEstadoObjetivo(
        EstadoObjetivoDTO estadoObjetivoDTO) throws Exception;

    public List<EstadoObjetivoDTO> listEstadoObjetivoToListEstadoObjetivoDTO(
        List<EstadoObjetivo> estadoObjetivos) throws Exception;

    public List<EstadoObjetivo> listEstadoObjetivoDTOToListEstadoObjetivo(
        List<EstadoObjetivoDTO> estadoObjetivoDTOs) throws Exception;
}
