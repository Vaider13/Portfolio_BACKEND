
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Integer>{
    Persona findPersonaByUsuarioId(Integer usuario_id);
}
