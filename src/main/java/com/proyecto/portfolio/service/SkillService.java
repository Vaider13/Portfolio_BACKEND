
package com.proyecto.portfolio.service;

import com.proyecto.portfolio.model.Skill;
import com.proyecto.portfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillServices{

    @Autowired
    SkillRepository skillRepo;
    
    @Override
    public List<Skill> getSkills() {
        return skillRepo.findAll();
    }

    @Override
    public List<Skill> getByPersonaId(Integer personaId) {
        return skillRepo.findByPersonaId(personaId);
    }

    @Override
    public List<Skill> getByTipoSkill(String tipoSkill) {
        return skillRepo.findByTipoSkill(tipoSkill);
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Integer id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skill findSkill(Integer id) {
        return skillRepo.findById(id).get();
    }
    
}
