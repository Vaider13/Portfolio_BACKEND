
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
    List<Skill>findByTipoSkill(String tipoSkill);
    List<Skill>findByPersonaId(Integer personaId);
    
}
