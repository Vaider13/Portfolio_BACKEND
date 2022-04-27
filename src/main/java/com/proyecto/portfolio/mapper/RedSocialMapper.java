package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.RedSocialDto;
import com.proyecto.portfolio.model.RedSocial;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

//Se mapea los atributos de la clase "Red Social" a la clase "Red SocialDTO".
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface RedSocialMapper {

    List<RedSocialDto> map(List<RedSocial> redesSociales);

    default RedSocialDto map(RedSocial redesSociales) {
        RedSocialDto redesDto = new RedSocialDto();
        redesDto.setId(redesSociales.getId());
        redesDto.setFacebook(redesSociales.getFacebook());
        redesDto.setTwitter(redesSociales.getTwitter());
        redesDto.setInstagram(redesSociales.getInstagram());
        redesDto.setLinkedin(redesSociales.getLinkedin());
        return redesDto;
    }
}
