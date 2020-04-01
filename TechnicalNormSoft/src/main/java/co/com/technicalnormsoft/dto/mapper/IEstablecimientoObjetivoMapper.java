package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.EstablecimientoObjetivo;
import co.com.technicalnormsoft.model.dto.EstablecimientoObjetivoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEstablecimientoObjetivoMapper {
    public EstablecimientoObjetivoDTO establecimientoObjetivoToEstablecimientoObjetivoDTO(
        EstablecimientoObjetivo establecimientoObjetivo)
        throws Exception;

    public EstablecimientoObjetivo establecimientoObjetivoDTOToEstablecimientoObjetivo(
        EstablecimientoObjetivoDTO establecimientoObjetivoDTO)
        throws Exception;

    public List<EstablecimientoObjetivoDTO> listEstablecimientoObjetivoToListEstablecimientoObjetivoDTO(
        List<EstablecimientoObjetivo> establecimientoObjetivos)
        throws Exception;

    public List<EstablecimientoObjetivo> listEstablecimientoObjetivoDTOToListEstablecimientoObjetivo(
        List<EstablecimientoObjetivoDTO> establecimientoObjetivoDTOs)
        throws Exception;
}
