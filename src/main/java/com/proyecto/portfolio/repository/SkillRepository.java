
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
   
    //Trae las Skill por medio del tipo de Skill (Hard O Soft)
    List<Skill>findByTipoSkill(String tipoSkill);
    
    //Trae todas las skill asociadas a una persona por medio del ID de la misma.
    List<Skill>findByPersonaId(Integer personaId);
    
}
