
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer>{
    
    //Busca las experiencias laborales de una persona por medio de su ID.
    List<ExperienciaLaboral> findByPersonaId(Integer personaId);
}
