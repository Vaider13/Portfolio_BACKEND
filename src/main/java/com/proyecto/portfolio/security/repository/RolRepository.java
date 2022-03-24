
package com.proyecto.portfolio.security.repository;

import com.proyecto.portfolio.security.enums.RolNombre;
import com.proyecto.portfolio.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
  Optional<Rol> findByRolNombre(RolNombre rolNOmbre);   
}
