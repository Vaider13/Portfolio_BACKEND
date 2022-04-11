package com.proyecto.portfolio.mapper;

import com.proyecto.portfolio.dto.SkillDto;
import com.proyecto.portfolio.model.Skill;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface SkillMapper {

    List<SkillDto> map(List<Skill> skill);

    default SkillDto map(Skill skill) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setNombreSkill(skill.getNombreSkill());
        skillDto.setTipoSkill(skill.getTipoSkill());
        skillDto.setNivelSkill(skill.getNivelSkill());
        return skillDto;
    }
}
