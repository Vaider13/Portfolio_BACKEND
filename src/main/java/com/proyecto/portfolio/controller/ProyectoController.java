package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.ProyectoDto;
import com.proyecto.portfolio.mapper.ProyectoMapper;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.model.Proyecto;
import com.proyecto.portfolio.service.IPersonaService;
import com.proyecto.portfolio.service.IProyectoService;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {
    
    @Autowired
    IProyectoService proyectService;
    
    @Autowired
    ProyectoMapper proyectMapper;
    
    @Autowired
    IPersonaService persoService;
    
    @GetMapping("/traer")
    public ResponseEntity<List<Proyecto>> getProyectos() {
        List<Proyecto> list = proyectService.getProyectos();
        return new ResponseEntity(proyectMapper.map(list), HttpStatus.OK);
    }
    
    @GetMapping("/traer/{personaId}")
    public ResponseEntity<List<Proyecto>> getExperienciaLaboralByPersonaId(@PathVariable(value = "personaId") Integer personaId) {
        List<Proyecto> list = proyectService.getProyectosByPersonaId(personaId);
        return new ResponseEntity(proyectMapper.map(list), HttpStatus.OK);
    }
    
    @GetMapping("/traerid/{id}")
    public ResponseEntity<Proyecto> getProyectoById(@PathVariable(value = "id") Integer id) {
        Proyecto proyect = proyectService.findProyecto(id);
        return new ResponseEntity(proyectMapper.map(proyect), HttpStatus.OK);
        
    }
    
    @PostMapping("/crear/{personaId}")
    public void crearProyecto(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody ProyectoDto proyectDto) {
        Proyecto proyect = new Proyecto();
        Persona perso = persoService.findPersona(personaId);
        proyect.setNombre(proyectDto.getNombre());
        proyect.setFecha(proyectDto.getFecha());
        proyect.setDescripcion(proyectDto.getDescripcion());
        proyect.setUrlProyecto(proyectDto.getUrlProyecto());
        proyect.setPersona(perso);
        proyectService.saveProyecto(proyect);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto(@PathVariable(value = "id") Integer id) {
        proyectService.deleteProyecto(id);
    }
    
    @PutMapping("/editar/{id}")
    public Proyecto editarProyecto(@PathVariable(value = "id") Integer id,
            @RequestBody ProyectoDto proyectDto) {
        Proyecto proyect = proyectService.findProyecto(id);
        proyect.setNombre(proyectDto.getNombre());
        proyect.setFecha(proyectDto.getFecha());
        proyect.setDescripcion(proyectDto.getDescripcion());
        proyect.setUrlProyecto(proyectDto.getUrlProyecto());
        proyectService.saveProyecto(proyect);
        return proyect;
    }
}
