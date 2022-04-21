package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.UsuarioDto;
import com.proyecto.portfolio.security.model.Usuario;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UsuarioMapper {

     List<UsuarioDto> map(List<Usuario> user);
    default UsuarioDto map(Usuario user) {
        UsuarioDto userDto = new UsuarioDto();
        userDto.setId(user.getId());
        userDto.setNombreUsuario(user.getNombreUsuario());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}
