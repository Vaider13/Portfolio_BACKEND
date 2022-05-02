package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.IdiomaDto;
import com.proyecto.portfolio.model.Idioma;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

//Se mapea los atributos de la clase "Idioma" a la clase "IdiomaDto".
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface IdiomaMapper {
    List<IdiomaDto> map(List<Idioma> idioma);
    
    default IdiomaDto map (Idioma idioma) {
      IdiomaDto idiomaDto = new IdiomaDto();
      idiomaDto.setId(idioma.getId());
      idiomaDto.setNombreIdioma(idioma.getNombreIdioma());
      return idiomaDto;
    }
}
