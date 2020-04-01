package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Proyecto;
import co.com.technicalnormsoft.model.dto.ProyectoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IProyectoMapper {
    public ProyectoDTO proyectoToProyectoDTO(Proyecto proyecto)
        throws Exception;

    public Proyecto proyectoDTOToProyecto(ProyectoDTO proyectoDTO)
        throws Exception;

    public List<ProyectoDTO> listProyectoToListProyectoDTO(
        List<Proyecto> proyectos) throws Exception;

    public List<Proyecto> listProyectoDTOToListProyecto(
        List<ProyectoDTO> proyectoDTOs) throws Exception;
}
