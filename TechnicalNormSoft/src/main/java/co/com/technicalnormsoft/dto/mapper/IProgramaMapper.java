package co.com.technicalnormsoft.dto.mapper;

import co.com.technicalnormsoft.model.Programa;
import co.com.technicalnormsoft.model.dto.ProgramaDTO;

import java.util.List;


/**
* @author Silicon Cali
* 
*
*/
public interface IProgramaMapper {
    public ProgramaDTO programaToProgramaDTO(Programa programa)
        throws Exception;

    public Programa programaDTOToPrograma(ProgramaDTO programaDTO)
        throws Exception;

    public List<ProgramaDTO> listProgramaToListProgramaDTO(
        List<Programa> programas) throws Exception;

    public List<Programa> listProgramaDTOToListPrograma(
        List<ProgramaDTO> programaDTOs) throws Exception;
}
