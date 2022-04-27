package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {

    //Trae todos los proyectos pertenecientes a una persona por medio del ID de la misma.
    List<Proyecto> findByPersonaId(Integer personaId);

}
