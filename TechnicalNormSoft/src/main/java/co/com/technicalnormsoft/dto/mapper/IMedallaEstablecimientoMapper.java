package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.MedallaEstablecimiento;
import co.com.technicalnormsoft.model.dto.MedallaEstablecimientoDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IMedallaEstablecimientoMapper {
    public MedallaEstablecimientoDTO medallaEstablecimientoToMedallaEstablecimientoDTO(
        MedallaEstablecimiento medallaEstablecimiento)
        throws Exception;

    public MedallaEstablecimiento medallaEstablecimientoDTOToMedallaEstablecimiento(
        MedallaEstablecimientoDTO medallaEstablecimientoDTO)
        throws Exception;

    public List<MedallaEstablecimientoDTO> listMedallaEstablecimientoToListMedallaEstablecimientoDTO(
        List<MedallaEstablecimiento> medallaEstablecimientos)
        throws Exception;

    public List<MedallaEstablecimiento> listMedallaEstablecimientoDTOToListMedallaEstablecimiento(
        List<MedallaEstablecimientoDTO> medallaEstablecimientoDTOs)
        throws Exception;
}
