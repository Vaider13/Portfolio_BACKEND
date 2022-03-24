
package com.proyecto.portfolio.repository;

import com.proyecto.portfolio.model.EstadoEducacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEducacionRepository extends JpaRepository<EstadoEducacion, Integer> {
    EstadoEducacion findByEstado(String estado);
}
