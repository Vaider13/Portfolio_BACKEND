
package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.EducacionDto;
import com.proyecto.portfolio.model.Educacion;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface EducacionMapper {
    
    List<EducacionDto> map(List<Educacion> educacion);
    
    default EducacionDto map (Educacion edu) {
      EducacionDto eduDto = new EducacionDto();
      eduDto.setId(edu.getId());
      eduDto.setTitulo(edu.getTitulo());
      eduDto.setNombreInstitucion(edu.getNombreInstitucion());
      eduDto.setFechaInicio(edu.getFechaInicio());
      eduDto.setFechaFinal(edu.getFechaFinal());
      eduDto.setLogoEducacion(edu.getLogoEducacion());
      eduDto.setEstadoEducacion(edu.getEstadoEducacion().getEstado());
      eduDto.setGradoEducacion(edu.getGradoEducacion().getGrado());      
      return eduDto;
   }
   
    }

