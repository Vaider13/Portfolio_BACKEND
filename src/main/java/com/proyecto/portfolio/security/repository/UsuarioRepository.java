
package com.proyecto.portfolio.security.repository;

import com.proyecto.portfolio.security.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Boolean existsByNombreUsuario(String nombreUsuario);
    Boolean existsByEmail(String email);
}
