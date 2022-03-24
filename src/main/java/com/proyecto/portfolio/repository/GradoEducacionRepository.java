
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.GradoEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoEducacionRepository extends JpaRepository<GradoEducacion, Integer> {
    GradoEducacion findByGrado(String grado);
}
