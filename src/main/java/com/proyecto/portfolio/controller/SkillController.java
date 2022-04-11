package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.SkillDto;
import com.proyecto.portfolio.mapper.SkillMapper;
import com.proyecto.portfolio.model.Skill;
import com.proyecto.portfolio.service.IPersonaService;
import com.proyecto.portfolio.service.ISkillServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    ISkillServices skillService;

    @Autowired
    IPersonaService persoService;

    @Autowired
    SkillMapper SkillMapper;

    @GetMapping("/traer")
    public ResponseEntity<List<Skill>> getSkill() {
        List<Skill> list = skillService.getSkills();
        return new ResponseEntity(SkillMapper.map(list), HttpStatus.OK);
    }

    @GetMapping("/traer/{personaId}")
    public ResponseEntity<List<Skill>> getSkillByPersonaId(@PathVariable(value = "personaId") Integer personaId) {
        List<Skill> list = skillService.getByPersonaId(personaId);
        return new ResponseEntity(SkillMapper.map(list), HttpStatus.OK);
    }

    @GetMapping("/traerid/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable(value = "id") Integer id) {
        Skill skill = skillService.findSkill(id);
        return new ResponseEntity(SkillMapper.map(skill), HttpStatus.OK);
    }

    @PostMapping("/crear/{personaId}")
    public void saveSkill(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody SkillDto skillDto) {
        Skill skill = new Skill();
        skill.setPersona(persoService.findPersona(personaId));
        skill.setNombreSkill(skillDto.getNombreSkill());
        skill.setTipoSkill(skillDto.getTipoSkill());
        skill.setNivelSkill(skillDto.getNivelSkill());
        skillService.saveSkill(skill);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteSkill(@PathVariable(value = "id") Integer id) {
        skillService.deleteSkill(id);
    }

    @PutMapping("editar/{id}")
    public Skill editSkill(@PathVariable(value = "id") Integer id,
            @RequestBody SkillDto skillDto) {
        Skill skill = skillService.findSkill(id);
        skill.setNombreSkill(skillDto.getNombreSkill());
        skill.setTipoSkill(skillDto.getTipoSkill());
        skill.setNivelSkill(skillDto.getNivelSkill());
        skillService.saveSkill(skill);
        return skill;
    }
}
