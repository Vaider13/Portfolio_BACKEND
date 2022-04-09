
package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.ProyectoDto;
import com.proyecto.portfolio.model.Proyecto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ProyectoMapper {
     List<ProyectoDto> map(List<Proyecto> proyecto);

    default ProyectoDto map(Proyecto proyect) {
        ProyectoDto proyectDto = new ProyectoDto();
        proyectDto.setId(proyect.getId());
        proyectDto.setNombre(proyect.getNombre());
        proyectDto.setFecha(proyect.getFecha());
        proyectDto.setDescripcion(proyect.getDescripcion());
        proyectDto.setUrlProyecto(proyect.getUrlProyecto());
        return proyectDto;
    }
}
