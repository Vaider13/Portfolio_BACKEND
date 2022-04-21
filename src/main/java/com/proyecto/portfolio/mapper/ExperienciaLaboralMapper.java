package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.ExperienciaLaboralDto;
import com.proyecto.portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ExperienciaLaboralMapper {

    List<ExperienciaLaboralDto> map(List<ExperienciaLaboral> experienciaLaboral);

    default ExperienciaLaboralDto map(ExperienciaLaboral exp) {
        ExperienciaLaboralDto expDto = new ExperienciaLaboralDto();
        expDto.setId(exp.getId());
        expDto.setNombreEmpresa(exp.getNombreEmpresa());
        expDto.setPuesto(exp.getPuesto());
        expDto.setFechaInicio(exp.getFechaInicio());
        expDto.setFechaFinal(exp.getFechaFinal());
        expDto.setEnCurso(exp.getEnCurso());
        expDto.setDescripcion(exp.getDescripcion());
        expDto.setLogoEmpresa(exp.getLogoEmpresa());
        return expDto;
    }
}
