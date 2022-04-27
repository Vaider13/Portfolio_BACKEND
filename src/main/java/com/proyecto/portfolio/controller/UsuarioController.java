
package com.proyecto.portfolio.controller;

import com.proyecto.portfolio.dto.UsuarioDto;
import com.proyecto.portfolio.security.model.Usuario;
import com.proyecto.portfolio.security.service.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
  
    @GetMapping("/traer")
    public ResponseEntity<UsuarioDto> getByUserName(@RequestParam String userName) {
        Optional<Usuario> user = usuarioService.getByNombreUsuario(userName);
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
