package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.ExperienciaLaboralDto;
import com.proyecto.portfolio.mapper.ExperienciaLaboralMapper;
import com.proyecto.portfolio.model.ExperienciaLaboral;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.service.IExperienciaLaboral;
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
@RequestMapping("trabajo")
@CrossOrigin(origins = "*")
public class ExperienciaLaboralController {

    @Autowired
    ExperienciaLaboralMapper expMapper;

    @Autowired
    IPersonaService iPersonaService;

    @Autowired
    IExperienciaLaboral iExpService;

    //Trae todas las experiencias laborales.
    @GetMapping("/traer")
    public ResponseEntity<List<ExperienciaLaboral>> getExperienciaLaboral() {
        List<ExperienciaLaboral> list = iExpService.getExperienciaLaboral();
        return new ResponseEntity(expMapper.map(list), HttpStatus.OK);
    }

    //Trae las experiencias laborales de una persona por medio del ID de la persona.
    @GetMapping("/traer/{personaId}")
    public ResponseEntity<List<ExperienciaLaboral>> getExperienciaLaboralByPersonaId(@PathVariable(value = "personaId") Integer personaId) {
        List<ExperienciaLaboral> list = iExpService.getExperienciaLaboralByPersonaId(personaId);
        return new ResponseEntity(expMapper.map(list), HttpStatus.OK);
    }

    //Trae una experiencia laboral por medio de su ID.
    @GetMapping("/traerid/{id}")
    public ResponseEntity<ExperienciaLaboral> getExperienciaLaboralById(@PathVariable Integer id) {
        ExperienciaLaboral exp = iExpService.findExperienciaLaboral(id);
        return new ResponseEntity(expMapper.map(exp), HttpStatus.OK);
    }

    //Crea una nueva experiencia laboral, para ello se usa el ID de la parsona para identificar a que persona corresponde.
    //Se crea un nuevo objeto, se le asignan los valores, que vienen en el cuerpo de la solicitud, y posteriormente se guarda.  
    @PostMapping("/crear/{personaId}")
    public void crearExperienciaLaboral(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody ExperienciaLaboralDto expDto) {
        ExperienciaLaboral exp = new ExperienciaLaboral();
        Persona perso = iPersonaService.findPersona(personaId);
        exp.setPersona(perso);
        exp.setNombreEmpresa(expDto.getNombreEmpresa());
        exp.setPuesto(expDto.getPuesto());
        exp.setFechaInicio(expDto.getFechaInicio());
        exp.setFechaFinal(expDto.getFechaFinal());
        exp.setEnCurso(expDto.getEnCurso());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setLogoEmpresa(expDto.getLogoEmpresa());
        iExpService.saveExperienciaLaboral(exp);
    }
    
    //Borra una experiencia laboral por medio del ID.
    @DeleteMapping("/borrar/{id}")
    public void deleteById(@PathVariable Integer id) {
        iExpService.deleteExperienciaLaboral(id);
    }

    //Se edita una experiencia laboral por medio de su ID. Se trae la experiencia laboral por medio de su ID.
    //Luego se le asignan los nuevos valores, que vienen en el cuerpo de la solicitud, y posteriormente se guarda.
    @PutMapping("/editar/{id}")
    public ExperienciaLaboral editExperienciaLaboral(@PathVariable Integer id,
            @RequestBody ExperienciaLaboralDto expDto) {
        ExperienciaLaboral exp = iExpService.findExperienciaLaboral(id);
        exp.setNombreEmpresa(expDto.getNombreEmpresa());
        exp.setPuesto(expDto.getPuesto());
        exp.setFechaInicio(expDto.getFechaInicio());
        exp.setFechaFinal(expDto.getFechaFinal());
        exp.setEnCurso(expDto.getEnCurso());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setLogoEmpresa(expDto.getLogoEmpresa());
        iExpService.saveExperienciaLaboral(exp);
        return exp;
    }
}
