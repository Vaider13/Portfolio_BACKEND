package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.ExperienciaIdiomaDto;
import com.proyecto.portfolio.mapper.ExperienciaIdiomaMapper;
import com.proyecto.portfolio.model.ExperienciaIdioma;
import com.proyecto.portfolio.model.Idioma;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.service.IExperienciaIdioma;
import com.proyecto.portfolio.service.IIdiomaService;
import com.proyecto.portfolio.service.IPersonaService;
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
@RequestMapping("experienciaidioma")
@CrossOrigin(origins = "*")
public class ExperienciaIdiomaController {

    @Autowired
    IExperienciaIdioma iExperienciaIdioma;

    @Autowired
    IPersonaService iPersoService;

    @Autowired
    IIdiomaService iIdiomaService;

    @Autowired
    ExperienciaIdiomaMapper expIdiomaMapper;

    @GetMapping("/traer")
    public ResponseEntity<List<ExperienciaIdioma>> getExperienciaIdiomas() {
        List<ExperienciaIdioma> list = iExperienciaIdioma.getExperienciaIdioma();
        return new ResponseEntity(expIdiomaMapper.map(list), HttpStatus.OK);
    }
    
    @GetMapping("/traerid/{id}")
    public ResponseEntity<ExperienciaIdioma> getExperienciaIdiomaById(@PathVariable(name
            = "id") Integer id) {
        ExperienciaIdioma exp = iExperienciaIdioma.getExperienciaIdiomaById(id);
        return new ResponseEntity(expIdiomaMapper.map(exp), HttpStatus.OK);
    }

    @GetMapping("/traer/{personaId}")
    public ResponseEntity<List<ExperienciaIdioma>> getExperienciaIdiomasByPersonaId(@PathVariable(name
            = "personaId") Integer personaId) {
        List<ExperienciaIdioma> list = iExperienciaIdioma.getExperienciaIdiomaByPersonaId(personaId);
        return new ResponseEntity(expIdiomaMapper.map(list), HttpStatus.OK);
    }
    
    @PostMapping("/crear/{personaId}")
    public void saveExperienciaIdiomaByPersonaId(@PathVariable(name
            = "personaId") Integer personaId,
            @RequestBody ExperienciaIdiomaDto expDto) {
        ExperienciaIdioma expIdioma = new ExperienciaIdioma();
        Persona perso = iPersoService.findPersona(personaId);
        Idioma idioma = iIdiomaService.getByIdioma(expDto.getNombreIdioma());
        expIdioma.setPersona(perso);
        expIdioma.setIdioma(idioma);
        expIdioma.setOral(expDto.getOral());
        expIdioma.setEscritura(expDto.getEscritura());
        expIdioma.setLectura(expDto.getLectura());
        iExperienciaIdioma.saveExperienciaIdioma(expIdioma);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void deleteExperienciaIdiomaById(@PathVariable(name
            = "id") Integer id) {
        iExperienciaIdioma.deleteById(id);
    }
    
    @PutMapping("/editar/{id}")
    public  ExperienciaIdioma editExperienciaIdiomaByPersonaId(@PathVariable(name
            = "id") Integer id,
            @RequestBody ExperienciaIdiomaDto expDto) {
        ExperienciaIdioma expIdioma = iExperienciaIdioma.getExperienciaIdiomaById(id);
        Idioma idioma = iIdiomaService.getByIdioma(expDto.getNombreIdioma());
        expIdioma.setIdioma(idioma);
        expIdioma.setOral(expDto.getOral());
        expIdioma.setEscritura(expDto.getEscritura());
        expIdioma.setLectura(expDto.getLectura());
        iExperienciaIdioma.saveExperienciaIdioma(expIdioma);
        return expIdioma;
    }
    

}
