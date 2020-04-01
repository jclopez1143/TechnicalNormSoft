package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Establecimiento;
import co.com.technicalnormsoft.model.dto.EstablecimientoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IEstablecimientoMapper {
    public EstablecimientoDTO establecimientoToEstablecimientoDTO(
        Establecimiento establecimiento) throws Exception;

    public Establecimiento establecimientoDTOToEstablecimiento(
        EstablecimientoDTO establecimientoDTO) throws Exception;

    public List<EstablecimientoDTO> listEstablecimientoToListEstablecimientoDTO(
        List<Establecimiento> establecimientos) throws Exception;

    public List<Establecimiento> listEstablecimientoDTOToListEstablecimiento(
        List<EstablecimientoDTO> establecimientoDTOs) throws Exception;
}
