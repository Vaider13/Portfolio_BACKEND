package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.ExperienciaIdioma;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaIdiomaRepository extends JpaRepository<ExperienciaIdioma, Integer> {
    
    public List<ExperienciaIdioma> findByPersonaId(Integer personaId);

}
