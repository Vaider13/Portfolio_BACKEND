
package com.proyecto.portfolio.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SkillDto {
    private Integer id;
    private String nombreSkill;
    private String tipoSkill;
    private Integer nivelSkill;
}
