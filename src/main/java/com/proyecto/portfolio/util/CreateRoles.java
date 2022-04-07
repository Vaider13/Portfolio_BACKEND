package com.proyecto.portfolio.util;

import com.proyecto.portfolio.security.enums.RolNombre;
import com.proyecto.portfolio.security.model.Rol;
import com.proyecto.portfolio.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /**Rol rolAdmin = new Rol(RolNombre.ROL_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROL_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);**/
         
    }
}
