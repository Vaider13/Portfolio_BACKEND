package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.PersonaDto;
import com.proyecto.portfolio.model.Localidad;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.security.model.Usuario;
import com.proyecto.portfolio.security.service.UsuarioService;
import com.proyecto.portfolio.service.ILocalidadService;
import com.proyecto.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPerso;

    @Autowired
    private ILocalidadService localService;

    @Autowired
    UsuarioService userService;

    @GetMapping("persona/traer")
    public List<Persona> getPersonas() {
        return interPerso.getPersonas();

    }

    @GetMapping("persona/traer/{id}")
    public Persona getPersonaById(@PathVariable(name = "id") Integer id) {
        return interPerso.findPersona(id);
    }

    @PostMapping("persona/{usuario_id}/crear/{localidad_id}")
    public void crearPersona(@PathVariable(value = "localidad_id") Integer localidad_id,
            @PathVariable(value = "usuario_id") Integer usuario_id,
            @RequestBody PersonaDto personaDto) {
        Persona persona = new Persona();
        Localidad localidad = localService.findLocalidad(localidad_id);
        Usuario user = userService.getById(usuario_id);
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setFecha_nacimiento(personaDto.getFecha_nacimiento());
        persona.setTelefono(personaDto.getTelefono());
        persona.setTitulo(personaDto.getTitulo());
        persona.setAcerca_de(personaDto.getAcerca_de());
        persona.setLocalidad(localidad);
        persona.setUsuario(user);
        interPerso.savePersona(persona);
    }

   
    @DeleteMapping("persona/borrar/{id}")
    public void borrarPersona(@PathVariable Integer id) {
        interPerso.deletePersona(id);
    }

    @PutMapping("persona/editar/{id}")
    public Persona editPersona(@PathVariable Integer id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("fecha_nacimiento") String nuevaFechaNacimiento,
            @RequestParam("telefono") String nuevoTelefono,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("acerca_de") String nuevoAcercaDe,
            @RequestParam ("localidad_id") Integer localidad_id) {
        Persona perso = interPerso.findPersona(id);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setFecha_nacimiento(nuevaFechaNacimiento);
        perso.setTelefono(nuevoTelefono);
        perso.setTitulo(nuevoTitulo);
        perso.setAcerca_de(nuevoAcercaDe);
        perso.setLocalidad(localService.findLocalidad(localidad_id));
        interPerso.savePersona(perso);
        return perso;
    }
}
