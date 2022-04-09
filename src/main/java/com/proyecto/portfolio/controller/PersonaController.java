package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.PersonaDto;
import com.proyecto.portfolio.mapper.PersonaMapper;
import com.proyecto.portfolio.model.Localidad;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.security.model.Usuario;
import com.proyecto.portfolio.security.service.UsuarioService;
import com.proyecto.portfolio.service.ILocalidadService;
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
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private IPersonaService interPerso;

    @Autowired
    private ILocalidadService localService;

    @Autowired
    private PersonaMapper persoMapper;

    @Autowired
    UsuarioService userService;

    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> perso = interPerso.getPersonas();
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);

    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable(name = "id") Integer id) {
        Persona perso = interPerso.findPersona(id);
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);
    }
    
    @GetMapping("/traer/usuario/{id}")
    public ResponseEntity<Persona> getByUserId(@PathVariable(name = "id") Integer id) {
        Persona perso = interPerso.findPersonaByUserId(id);
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);
    }

    @PostMapping("/crear/{userId}")
    public void crearPersona(@PathVariable(name = "userId") Integer userId,
            @RequestBody PersonaDto personaDto) {
        Persona persona = new Persona();
        Localidad localidad = localService.findByName(personaDto.getLocalidad());
        Usuario user = userService.getById(userId);
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setFecha_nacimiento(personaDto.getFecha_nacimiento());
        persona.setTelefono(personaDto.getTelefono());
        persona.setTitulo(personaDto.getTitulo());
        persona.setAcerca_de(personaDto.getAcerca_de());
        persona.setUrlAvatar(personaDto.getUrlAvatar());
        persona.setUrlBanner(personaDto.getUrlBanner());
        persona.setLocalidad(localidad);
        persona.setUsuario(user);
        interPerso.savePersona(persona);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Integer id) {
        interPerso.deletePersona(id);
    }

    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Integer id,
             @RequestBody PersonaDto personaDto){
        Persona perso = interPerso.findPersona(id);
        perso.setApellido(personaDto.getApellido());
        perso.setNombre(personaDto.getNombre());
        perso.setFecha_nacimiento(personaDto.getFecha_nacimiento());
        perso.setTelefono(personaDto.getTelefono());
        perso.setTitulo(personaDto.getTitulo());
        perso.setAcerca_de(personaDto.getAcerca_de());
        perso.setUrlAvatar(personaDto.getUrlAvatar());
        perso.setUrlBanner(personaDto.getUrlBanner());
        perso.setLocalidad(localService.findByName(personaDto.getLocalidad()));
        interPerso.savePersona(perso);
        return perso;
    }
}
