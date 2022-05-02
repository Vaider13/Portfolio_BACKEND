package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Integer> {
    public Idioma findByNombreIdioma(String nombreIdioma);
}
