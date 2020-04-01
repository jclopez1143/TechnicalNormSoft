package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Norma;
import co.com.technicalnormsoft.model.dto.NormaDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface INormaMapper {
    public NormaDTO normaToNormaDTO(Norma norma) throws Exception;

    public Norma normaDTOToNorma(NormaDTO normaDTO) throws Exception;

    public List<NormaDTO> listNormaToListNormaDTO(List<Norma> normas)
        throws Exception;

    public List<Norma> listNormaDTOToListNorma(List<NormaDTO> normaDTOs)
        throws Exception;
}
