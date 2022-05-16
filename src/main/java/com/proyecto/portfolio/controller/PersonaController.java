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
@RequestMapping("persona")
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

    //Se traen todas las personas almacenadas.
    @GetMapping("/traer")
    public ResponseEntity<List<Persona>> getPersonas() {
        List<Persona> perso = interPerso.getPersonas();
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);

    }

    //se trae a la persona por medio de su ID.
    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable(name = "id") Integer id) {
        Persona perso = interPerso.findPersona(id);
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);
    }
    
    //Se trae a una persona correspondiente, por medio del ID asociado al usuario correspondiente.
    @GetMapping("/traer/usuario/{id}")
    public ResponseEntity<Persona> getByUserId(@PathVariable(name = "id") Integer id) {
        Persona perso = interPerso.findPersonaByUserId(id);
        return new ResponseEntity(persoMapper.map(perso), HttpStatus.OK);
    }

    //Se crea una nueva persona, que debe estar enlazada a un usuario, por medio del usuarioID.
    //Se crea un nuebo objeto, se le asignan los valores, provenientes del cuerpo de la solicitud y posteriormente se guardan.
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

    //Se borra una persona por medio de su ID.
    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Integer id) {
        interPerso.deletePersona(id);
    }

    //Se edita una persona por medio de su ID. Se trae la persona por medio de su ID.
    //Luego se le asignan los nuevos valores, que vienen en el cuerpo de la solicitud, y posteriormente se guarda.
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Integer id,
             @RequestBody PersonaDto personaDto){
        Persona perso = interPerso.findPersona(id);
        Localidad localidad = localService.findByName(personaDto.getLocalidad());
        perso.setApellido(personaDto.getApellido());
        perso.setNombre(personaDto.getNombre());
        perso.setFecha_nacimiento(personaDto.getFecha_nacimiento());
        perso.setTelefono(personaDto.getTelefono());
        perso.setTitulo(personaDto.getTitulo());
        perso.setAcerca_de(personaDto.getAcerca_de());
        perso.setUrlAvatar(personaDto.getUrlAvatar());
        perso.setUrlBanner(personaDto.getUrlBanner());
        perso.setLocalidad(localidad);
        interPerso.savePersona(perso);
        return perso;
    }
}
