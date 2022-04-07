package com.proyecto.portfolio.security.service;

import com.proyecto.portfolio.security.model.Usuario;
import com.proyecto.portfolio.security.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    public Usuario getById(Integer id) {
        return usuarioRepo.getById(id);
    }
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    

    public Boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public Boolean existsByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

}
