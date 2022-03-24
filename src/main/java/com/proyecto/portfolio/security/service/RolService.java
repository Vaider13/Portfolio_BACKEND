package com.proyecto.portfolio.security.service;

import com.proyecto.portfolio.security.enums.RolNombre;
import com.proyecto.portfolio.security.model.Rol;
import com.proyecto.portfolio.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepo;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepo.findByRolNombre(rolNombre);

    }
    
    public void save(Rol rol) {
        rolRepo.save(rol);
    }

}
