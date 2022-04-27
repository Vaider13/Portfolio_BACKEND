package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.EducacionDto;
import com.proyecto.portfolio.mapper.EducacionMapper;
import com.proyecto.portfolio.model.Educacion;
import com.proyecto.portfolio.model.EstadoEducacion;
import com.proyecto.portfolio.model.GradoEducacion;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.service.IEducacionService;
import com.proyecto.portfolio.service.IEstadoEducacion;
import com.proyecto.portfolio.service.IGradoService;
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
@RequestMapping("educacion")
@CrossOrigin(origins = "*")
public class EducacionController {

    @Autowired
    EducacionMapper eduMapper;

    @Autowired
    IEducacionService iEduService;

    @Autowired
    IPersonaService iPersonaService;

    @Autowired
    IEstadoEducacion iEstadoEdu;

    @Autowired
    IGradoService iGradoEdu;

    //Trae todos los estudios almacenados.
    @GetMapping("/traer")
    public ResponseEntity<List<Educacion>>getEducacion() {
        List<Educacion> list = iEduService.getEducacion();
        return new ResponseEntity(eduMapper.map(list), HttpStatus.OK);
    }
    
    //Trae un estudio por medio de su ID.
    @GetMapping("/traerid/{id}")
    public ResponseEntity<Educacion>getEducacionById(@PathVariable(name = "id") Integer id) {
        Educacion edu = iEduService.findEducacion(id);
        return new ResponseEntity(eduMapper.map(edu), HttpStatus.OK);
    }
    
    //Trae los estudios de una persona por medio del ID de la persona.
    @GetMapping("/traer/{personaId}")
    public List<EducacionDto> getEducacionByPersonaId(@PathVariable(name = "personaId") Integer personaId) {
        List<Educacion> listaEducacion = iEduService.getEducacionByPersonaId(personaId);
        return eduMapper.map(listaEducacion);
    }

    //Crea un nuevo estudio, para ello se usa el ID de la parsona para identificar a que persona corresponde.
    //Se crea un nuevo objeto, se le asignan los valores, que vienen en el cuerpo de la solicitud, y posteriormente se guarda.    
    @PostMapping("/crear/{personaId}")
    public void crearEducacion(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody EducacionDto educacionDto) {
        Educacion edu = new Educacion();
        EstadoEducacion estado = iEstadoEdu.findByEstado(educacionDto.getEstadoEducacion());
        GradoEducacion grado = iGradoEdu.findByGrado(educacionDto.getGradoEducacion());
        Persona perso = iPersonaService.findPersona(personaId);
        edu.setPersona(perso);
        edu.setGradoEducacion(grado);
        edu.setEstadoEducacion(estado);
        edu.setNombreInstitucion(educacionDto.getNombreInstitucion());
        edu.setTitulo(educacionDto.getTitulo());
        edu.setFechaInicio(educacionDto.getFechaInicio());
        edu.setFechaFinal(educacionDto.getFechaFinal());
        edu.setLogoEducacion(educacionDto.getLogoEducacion());
        iEduService.saveEducacion(edu);
    }
    
    //Borra un estudio por medio del ID.
    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable Integer id) {
        iEduService.deleteEducacion(id);
    }

    //Se edita un estudio por medio de su ID. Se trae el estudio por medio de su ID.
    //Luego se le asignan los nuevos valores, que vienen en el cuerpo de la solicitud, y posteriormente se guarda.
    @PutMapping("/editar/{id}")
    public Educacion editEducacion(@PathVariable Integer id,
            @RequestBody EducacionDto educacionDto) {
        
        Educacion edu = iEduService.findEducacion(id);
        EstadoEducacion estado = iEstadoEdu.findByEstado(educacionDto.getEstadoEducacion());
        GradoEducacion grado = iGradoEdu.findByGrado(educacionDto.getGradoEducacion());
        edu.setNombreInstitucion(educacionDto.getNombreInstitucion());
        edu.setTitulo(educacionDto.getTitulo());
        edu.setFechaInicio(educacionDto.getFechaInicio());
        edu.setFechaFinal(educacionDto.getFechaFinal());
        edu.setLogoEducacion(educacionDto.getLogoEducacion());
        edu.setEstadoEducacion(estado);
        edu.setGradoEducacion(grado);
        iEduService.saveEducacion(edu);
        return edu;
    }

}
