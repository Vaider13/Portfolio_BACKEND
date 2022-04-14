package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.LocalidadDto;
import com.proyecto.portfolio.model.Localidad;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface LocalidadMapper {

    List<LocalidadDto> map(List<Localidad> localidad);

    default LocalidadDto map(Localidad localidad) {
        LocalidadDto localDto = new LocalidadDto();
        localDto.setId(localidad.getId());
        localDto.setLocalidad(localidad.getLocalidad());
        return localDto;
    }
}
