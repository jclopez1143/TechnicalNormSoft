package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.TipoServicio;
import co.com.technicalnormsoft.model.dto.TipoServicioDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface ITipoServicioMapper {
    public TipoServicioDTO tipoServicioToTipoServicioDTO(
        TipoServicio tipoServicio) throws Exception;

    public TipoServicio tipoServicioDTOToTipoServicio(
        TipoServicioDTO tipoServicioDTO) throws Exception;

    public List<TipoServicioDTO> listTipoServicioToListTipoServicioDTO(
        List<TipoServicio> tipoServicios) throws Exception;

    public List<TipoServicio> listTipoServicioDTOToListTipoServicio(
        List<TipoServicioDTO> tipoServicioDTOs) throws Exception;
}
