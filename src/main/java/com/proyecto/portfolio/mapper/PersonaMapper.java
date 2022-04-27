package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.PersonaDto;
import com.proyecto.portfolio.model.Persona;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

//Se mapea los atributos de la clase "Persona" a la clase "PersonaDTO".
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface PersonaMapper {

    List<PersonaDto> map(List<Persona> perso);

    default PersonaDto map(Persona perso) {
        PersonaDto persoDto = new PersonaDto();
        persoDto.setId(perso.getId());
        persoDto.setNombre(perso.getNombre());
        persoDto.setApellido(perso.getApellido());
        persoDto.setFecha_nacimiento(perso.getFecha_nacimiento());
        persoDto.setTitulo(perso.getTitulo());
        persoDto.setTelefono(perso.getTelefono());
        persoDto.setAcerca_de(perso.getAcerca_de());
        persoDto.setEmail(perso.getUsuario().getEmail());
        persoDto.setUrlAvatar(perso.getUrlAvatar());
        persoDto.setUrlBanner(perso.getUrlBanner());
        persoDto.setLocalidad(perso.getLocalidad().getLocalidad());
        persoDto.setProvincia(perso.getLocalidad().getProvincia().getProvincia());
        persoDto.setProvinciaId(perso.getLocalidad().getProvincia().getId());

        return persoDto;
    }

}
