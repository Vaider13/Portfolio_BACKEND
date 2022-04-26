
package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.ProyectoImagenDto;
import com.proyecto.portfolio.model.ProyectoImagen;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ProyectoImagenMapper {
    List<ProyectoImagenDto> map(List<ProyectoImagen> proyectoImagen);

    default ProyectoImagenDto map(ProyectoImagen proyectImg) {
        ProyectoImagenDto proyectImgDto = new ProyectoImagenDto();
        proyectImgDto.setId(proyectImg.getId());
        proyectImgDto.setImagenUrl(proyectImg.getImagenUrl());
        return proyectImgDto;
    }
}
