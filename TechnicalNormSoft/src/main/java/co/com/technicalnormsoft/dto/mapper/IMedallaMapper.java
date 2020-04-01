package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Medalla;
import co.com.technicalnormsoft.model.dto.MedallaDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IMedallaMapper {
    public MedallaDTO medallaToMedallaDTO(Medalla medalla)
        throws Exception;

    public Medalla medallaDTOToMedalla(MedallaDTO medallaDTO)
        throws Exception;

    public List<MedallaDTO> listMedallaToListMedallaDTO(List<Medalla> medallas)
        throws Exception;

    public List<Medalla> listMedallaDTOToListMedalla(
        List<MedallaDTO> medallaDTOs) throws Exception;
}
