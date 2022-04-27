package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {
    
    //Busca los estudios por medio del ID de una persona.
    List<Educacion> findByPersonaId(Integer personaId);
}
