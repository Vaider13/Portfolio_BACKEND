
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Skill;
import java.util.List;

public interface ISkillServices {
    
    public List<Skill>getSkills();
    
    public List<Skill>getByPersonaId(Integer personaId);
    
    public List<Skill>getByTipoSkill(String tipoSkill);
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Integer id);
    
    public Skill findSkill(Integer id);

}
