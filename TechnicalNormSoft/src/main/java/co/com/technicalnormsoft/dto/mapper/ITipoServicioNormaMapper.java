package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.TipoServicioNorma;
import co.com.technicalnormsoft.model.dto.TipoServicioNormaDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface ITipoServicioNormaMapper {
    public TipoServicioNormaDTO tipoServicioNormaToTipoServicioNormaDTO(
        TipoServicioNorma tipoServicioNorma) throws Exception;

    public TipoServicioNorma tipoServicioNormaDTOToTipoServicioNorma(
        TipoServicioNormaDTO tipoServicioNormaDTO) throws Exception;

    public List<TipoServicioNormaDTO> listTipoServicioNormaToListTipoServicioNormaDTO(
        List<TipoServicioNorma> tipoServicioNormas) throws Exception;

    public List<TipoServicioNorma> listTipoServicioNormaDTOToListTipoServicioNorma(
        List<TipoServicioNormaDTO> tipoServicioNormaDTOs)
        throws Exception;
}
