
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer>{
    List<ExperienciaLaboral> findByPersonaId(Integer personaId);
}
