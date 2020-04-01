package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.ProyectoEstablecimiento;
import co.com.technicalnormsoft.model.dto.ProyectoEstablecimientoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IProyectoEstablecimientoMapper {
    public ProyectoEstablecimientoDTO proyectoEstablecimientoToProyectoEstablecimientoDTO(
        ProyectoEstablecimiento proyectoEstablecimiento)
        throws Exception;

    public ProyectoEstablecimiento proyectoEstablecimientoDTOToProyectoEstablecimiento(
        ProyectoEstablecimientoDTO proyectoEstablecimientoDTO)
        throws Exception;

    public List<ProyectoEstablecimientoDTO> listProyectoEstablecimientoToListProyectoEstablecimientoDTO(
        List<ProyectoEstablecimiento> proyectoEstablecimientos)
        throws Exception;

    public List<ProyectoEstablecimiento> listProyectoEstablecimientoDTOToListProyectoEstablecimiento(
        List<ProyectoEstablecimientoDTO> proyectoEstablecimientoDTOs)
        throws Exception;
}
