package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.EstadoProyecto;
import co.com.technicalnormsoft.model.dto.EstadoProyectoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IEstadoProyectoMapper {
    public EstadoProyectoDTO estadoProyectoToEstadoProyectoDTO(
        EstadoProyecto estadoProyecto) throws Exception;

    public EstadoProyecto estadoProyectoDTOToEstadoProyecto(
        EstadoProyectoDTO estadoProyectoDTO) throws Exception;

    public List<EstadoProyectoDTO> listEstadoProyectoToListEstadoProyectoDTO(
        List<EstadoProyecto> estadoProyectos) throws Exception;

    public List<EstadoProyecto> listEstadoProyectoDTOToListEstadoProyecto(
        List<EstadoProyectoDTO> estadoProyectoDTOs) throws Exception;
}
