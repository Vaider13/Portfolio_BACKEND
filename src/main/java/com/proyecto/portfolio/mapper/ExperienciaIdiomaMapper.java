package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.ExperienciaIdiomaDto;
import com.proyecto.portfolio.model.ExperienciaIdioma;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

//Se mapea los atributos de la clase "ExperienciaIdioma" a la clase "ExperienciaIdiomaDTO".
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ExperienciaIdiomaMapper {

    List<ExperienciaIdiomaDto> map(List<ExperienciaIdioma> experienciaIdioma);

    default ExperienciaIdiomaDto map(ExperienciaIdioma exp) {
        ExperienciaIdiomaDto expDto = new ExperienciaIdiomaDto();
        expDto.setId(exp.getId());
        expDto.setNombreIdioma(exp.getIdioma().getNombreIdioma());
        expDto.setOral(exp.getOral());
        expDto.setEscritura(exp.getEscritura());
        expDto.setLectura(exp.getLectura());
        return expDto;
    }
}
