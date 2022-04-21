package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.RedSocialDto;
import com.proyecto.portfolio.mapper.RedSocialMapper;
import com.proyecto.portfolio.model.Persona;
import com.proyecto.portfolio.model.RedSocial;
import com.proyecto.portfolio.service.IPersonaService;
import com.proyecto.portfolio.service.IRedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redes")
@CrossOrigin(origins = "*")
public class RedSocialController {

    @Autowired
    IRedSocialService iRedSocialService;

    @Autowired
    IPersonaService iPersonaService;

    @Autowired
    RedSocialMapper redSocialMapper;

    @GetMapping("/traer/{personaId}")
    public ResponseEntity<RedSocial> getByPersonaId(@PathVariable(value = "personaId") Integer personaId) {
        RedSocial redSocial = iRedSocialService.getByPersonaId(personaId);
        return new ResponseEntity(redSocialMapper.map(redSocial), HttpStatus.OK);
    }

    @PostMapping("/crear/{personaId}")
    public void saveRedSocial(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody RedSocialDto redSocialDto) {
        RedSocial redSocial = new RedSocial();
        Persona perso = iPersonaService.findPersona(personaId);
        redSocial.setPersona(perso);
        redSocial.setFacebook(redSocialDto.getFacebook());
        redSocial.setInstagram(redSocialDto.getInstagram());
        redSocial.setTwitter(redSocialDto.getTwitter());
        redSocial.setLinkedin(redSocialDto.getLinkedin());
        iRedSocialService.saveRedSocial(redSocial);
    }

    @PutMapping("/editar/{personaId}")
    public RedSocial editRedSocial(@PathVariable(value = "personaId") Integer personaId,
            @RequestBody RedSocialDto redSocialDto) {
        RedSocial redSocial = iRedSocialService.getByPersonaId(personaId);
        redSocial.setFacebook(redSocialDto.getFacebook());
        redSocial.setInstagram(redSocialDto.getInstagram());
        redSocial.setTwitter(redSocialDto.getTwitter());
        redSocial.setLinkedin(redSocialDto.getLinkedin());
        iRedSocialService.saveRedSocial(redSocial);
        return redSocial;
    }

}
